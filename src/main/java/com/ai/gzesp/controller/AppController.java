package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.UserService;
import com.ai.gzesp.utils.MD5Util;

/**
 * @author xmh
 * 线下下单controller，下单时可以不传身份证照片，身份证字段可空，
 * 1.登陆验证接口 和 沃掌柜用同一套用户名密码
 * 2.提供接口，app可以根据工号或者能人id查询刚刚下过的没身份证的订单，用于读身份证时和订单关联
 *   同时返回json，根据机器人需要的格式提供报文数据，给app，app拿来发给机器人
 * 3.提供接口用于 app读 二代证读卡器 读出的身份证号码后，将订单号和身份证号姓名回传沃掌柜，更新订单里身份证字段
 * 4.提供接口，app把机器人回传的 写卡数据，传给沃掌柜，保存备份
 * 5.提供接口，用于写卡不知道是否成功时，重新要写卡数据，再次写卡
 */
@Controller
@RequestMapping("/app/offline")
public class AppController {

    @Autowired
    private OrderService orderService;
    
	@Autowired
	private UserService userService;
    
    /**
     * 登陆验证接口 和 沃掌柜用同一套用户名密码
     * 登陆验证 参考 WeShopLoginController.checkLogin()
     * app传参json：{"inputMobile":"18651885060", "inputPassword":"123456"}
     * 返回json：{"result_code":"00", 
     *            "result_desc":"登陆成功", 
     *            "user_id":"123456", 
     *            "store_name":"XXX的店铺", 
     *            "phone_number":"18651885060", 
     *            "bss_login_code":"", 
     *            "bss_login_pwd":"", 
     *            "cbss_login_code":"", 
     *            "cbss_login_pwd":"",
     *            "develop_code":"",
     *            "develop_name":"",
     *            "channel_code":"",
     *            "channel_name":""
     *            }
     * @param param
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(/*@RequestBody Map<String, String> param*/@RequestParam("inputMobile") String inputMobile, @RequestParam("inputPassword") String inputPassword){
        Map<String, Object> result = new HashMap<String, Object>();
        
    	//String strPhoneNum = param.get("inputMobile");
    	//String strPwd = MD5Util.md5s2(param.get("inputPassword")); //md5加密
        
        String strPhoneNum = inputMobile;
    	String strPwd = MD5Util.md5s2(inputPassword); //md5加密
    	
    	//登陆验证 参考 WeShopLoginController.checkLogin()
		Map<Object, Object> userMap = userService.getUserInfoByPhonePassword(strPhoneNum, strPwd);
		//userMap不为空表示登陆成功
		if(userMap != null){
			result.put("result_code", "00");
			result.put("result_desc", "登陆成功");
			//同时返回该沃掌柜账户绑定的 bss工号密码，cbss工号密码
			Map<String, String> busiInfo = userService.getBusiInfo(strPhoneNum); //其实可以放上面验证登陆语句一起执行
			result.put("user_id", busiInfo.get("USER_ID"));
			result.put("store_name", busiInfo.get("STORE_NAME"));
			result.put("phone_number", busiInfo.get("PHONE_NUMBER"));
			result.put("bss_login_code", busiInfo.get("BSS_LOGIN_CODE"));
			result.put("bss_login_pwd", busiInfo.get("BSS_LOGIN_PWD"));
			result.put("cbss_login_code", busiInfo.get("CBSS_LOGIN_CODE"));
			result.put("cbss_login_pwd", busiInfo.get("CBSS_LOGIN_PWD"));
		}
		else{
			result.put("result_code", "01");
			result.put("result_desc", "用户名密码错误");
		}
		
        return result;
    }
    

    /**
     * 根据user_id 查询出未绑定身份证的订单，用于后面绑定身份证号
     * 需要线下当场开卡时，下的订单没有传身份证照片
     * app传参json：{"user_id":"12345", //能人id
     *               "phone_number":"18651885060",  //订单选中的手机号码
     *               "is_ok":"1",  // 1身份证已经补录，0身份证未补录，“”表示全部
     *               "start_day":"2015-09-01", //订单开始日期
     *               "end_day":"2015-09-01",  //订单结束日期
     *               "pageNum":"1", //页数
     *               "pageSize":"10", //每页条数
     *               }
     * 返回json：[{"order_id":"1081431679469542", 
     *            "create_time":"2015-09-01 12:00:01", 
     *            "is_ok":"0", 
     *            "photo_links":"http://res.woboss.gz186.com/uploader/goodsimages/201504232158113515701303.png", 
     *            "goods_name":"【一年卡】12GB上网卡 包2GB全国流量 10GB省内流量 直降180元！", 
     *            "income_money":"220", 
     *            "serial_number":"13885185322",
     *            "fee_mode":"01",
     *            "sys_code":"CBS",
     *            "product_id":"99999830", //product_id 找不到的时候为空字符串""
     *            "product_name":"4G全国套餐-76元套餐", // 找不到的时候为空字符串""
     *            "product_group":"up99999830k59999792&cp99999830k59999790e*&cp89000100", //找不到的时候为空字符串""
     *            "is_terminal": "1",
     *            "is_selfmachine": "1",
     *            "is_joinactivity": "1", 
     *            "activity_type": "CFSF001", 
     *            "assure_type": "4", 
     *            "activity_id": "89000100", 
     *            "activity_name": "存费送费合约存120元送240元(12个月", 
     *            "activity_detail": "",
     *            "terminal_type": "01", //目前机器人不支持上网卡开户，所以这边终端类型 写死01
     *            "pre_fee": "50",
     *            "ctlg_code": "5" 
     *            }]
     * @param param
     * @return
     */
    @RequestMapping(value="/queryOfflineOrders", method = RequestMethod.POST, consumes="application/octet-stream", produces="application/json;charset=UTF-8")
    @ResponseBody
    public List<Map<String, String>> queryOfflineOrders(@RequestBody Map<String, String> param){
    	String user_id = param.get("user_id");
    	String phone_number = param.get("phone_number");
    	String is_ok = param.get("is_ok"); // 1身份证已经补录，0身份证未补录，“”表示全部
    	String start_day = param.get("start_day");
    	String end_day = param.get("end_day");
    	String pageNum = param.get("pageNum");
    	String pageSize = param.get("pageSize");
    	
		return orderService.queryOfflineOrders(
				user_id, is_ok, phone_number, start_day, end_day, pageNum,
				pageSize);
    }
    
    
    /**
     * 能人app通过读卡器读二代证信息后，将身份证号，姓名，订单号回传沃掌柜
     * 1.更新ord_d_cust 里的 pspt_no,cust_name
     * 2.更新ord_d_post 里的 receiver_name 
     * 3.更新ord_d_base 里的order_state 状态为 07 待归档
     * 
     * app传参json：{"order_id":"12345", //订单id
     *               "pspt_no":"320282198401162411",  //身份证号
     *               "cust_name":"奚敏辉"  // 身份证姓名
     *               }
     * 返回json：{"result_code":"00", 
     *            "result_desc":"身份证信息补录成功"
     *            }              
     * @param param
     * @return
     */
    @RequestMapping(value="/updateOrderPsptNo", method = RequestMethod.POST, consumes="application/octet-stream", produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map<String, String> updateOrderPsptNo(@RequestBody Map<String, String> param){
    	HashMap<String, String> result = new HashMap<String, String>();
    	String order_id = param.get("order_id");
    	String pspt_no = param.get("pspt_no");
    	String cust_name = param.get("cust_name");
    	
		int n1 = orderService.updateOrderPsptNo(order_id, pspt_no, cust_name);
		int n2 = orderService.updateOrderCustName(order_id, cust_name);
		int n3 = orderService.updateOrderState(order_id);
		if(n1 > 0 && n2 > 0 && n3 > 0){
			result.put("result_code", "00");
			result.put("result_desc", "更新身份证成功");
			//再加上录单请求需要传给沃易登的数据
		}
		else{
			result.put("result_code", "01");
			result.put("result_desc", "订单号" + order_id + "更新身份证失败");
		}
		
		return result;
    }
}
