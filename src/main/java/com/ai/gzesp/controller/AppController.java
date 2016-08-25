package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.service.AppService;
import com.ai.gzesp.service.BssIntfService;
import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.UserService;
import com.ai.gzesp.utils.BssIntfUtil;
import com.ai.gzesp.utils.DateUtils;
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
	
	@Resource
	private BssIntfService bssIntfService;
	
	@Resource
	private AppService appService;
    
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
     *            "developer_code":"",
     *            "developer_name":"",
     *            "channel_code":"",
     *            "channel_name":""
     *            }
     * @param param
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String, String> param){
        Map<String, Object> result = new HashMap<String, Object>();
        
    	String strPhoneNum = param.get("inputMobile");
    	String strPwd = MD5Util.md5s2(param.get("inputPassword")); //md5加密
        
        //String strPhoneNum = inputMobile;
    	//String strPwd = MD5Util.md5s2(inputPassword); //md5加密
    	
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
			result.put("developer_code", busiInfo.get("DEVELOPER_CODE"));
			result.put("developer_name", busiInfo.get("DEVELOPER_NAME"));
			result.put("channel_code", busiInfo.get("CHANNEL_CODE"));
			result.put("channel_name", busiInfo.get("CHANNEL_NAME"));
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
     *               "order_id":"123456",  //订单id
     *               "phone_number":"18651885060",  //订单选中的手机号码
     *               "is_ok":"1",  // 1身份证已经补录，0身份证未补录，“”表示全部
     *               "start_day":"2015-09-01", //订单开始日期
     *               "end_day":"2015-09-01",  //订单结束日期
     *               "pageNum":"1", //页数
     *               "pageSize":"10", //每页条数
     *               }
     * 返回json：[{"order_id":"1081431679469542", 
     *            "create_time":"2015-09-01 12:00:01",
     *            "intf_order_status":"",
     *            "write_card_status":"", //0 表示写卡成功，空表示写卡失败
     *            "intf_order_desc":"阿斯蒂芬",  //外围接口失败描述
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
    @RequestMapping(value="/queryOfflineOrders", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, String>> queryOfflineOrders(@RequestBody Map<String, String> param){
    	String user_id = param.get("user_id");
    	String order_id = param.get("order_id");
    	String phone_number = param.get("phone_number");
    	String is_ok = param.get("is_ok"); // 1身份证已经补录，0身份证未补录，“”表示全部
    	String start_day = param.get("start_day");
    	String end_day = param.get("end_day");
    	String pageNum = param.get("pageNum");
    	String pageSize = param.get("pageSize");
    	
		return orderService.queryOfflineOrders(
				user_id, is_ok, order_id, phone_number, start_day, end_day, pageNum,
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
    @RequestMapping(value="/updateOrderPsptNo", method = RequestMethod.POST)
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
    
    /**
     * 能人app写卡成功后归档，订单号回传沃掌柜
     * 1.更新ord_d_base 里的order_state 状态为 08 已归档
     * 
     * app传参json：{"phone_number":"18651885060" //手机号-app端在写卡环节无法获得沃掌柜订单id,因此使用手机号}
     * 返回json：{"result_code":"00", 
     *            "result_desc":"订单归档成功"
     *            }              
     * @param param
     * @return
     */
    @RequestMapping(value="/updateOrderArchive", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> updateOrderArchive(@RequestBody Map<String, String> param){
    	HashMap<String, String> result = new HashMap<String, String>();
    	String phone_number = param.get("phone_number");
    	
		int n3 = orderService.updateOrderArchive(phone_number);
		if( n3 > 0){
			result.put("result_code", "00");
			result.put("result_desc", "订单归档成功");
			//再加上录单请求需要传给沃易登的数据
		}
		else{
			result.put("result_code", "01");
			result.put("result_desc", "手机号:" + phone_number + ",订单归档失败");
		}
		
		return result;
    }
    
    /**
     * 根据user_id 查询出未绑定身份证的订单，用于后面绑定身份证号, 这里只查出bss本地产品的订单
     * 需要线下当场开卡时，下的订单没有传身份证照片
     * app传参json：{"user_id":"12345", //能人id
     *               "order_id":"123456",  //订单id
     *               "phone_number":"18651885060",  //订单选中的手机号码
     *               "is_ok":"1",  // 1身份证已经补录，0身份证未补录，“”表示全部
     *               "start_day":"2015-09-01", //订单开始日期
     *               "end_day":"2015-09-01",  //订单结束日期
     *               "pageNum":"1", //页数
     *               "pageSize":"10", //每页条数
     *               }
     * 返回json：[{"order_id":"1081431679469542", 
     *            "create_time":"2015-09-01 12:00:01", 
     *            "intf_order_status":"",  //0 表示bss开户成功,其他表示失败
     *            "write_card_status":"", //0 表示写卡成功，空表示写卡失败
     *            "intf_order_desc":"阿斯蒂芬",  //外围接口失败描述
     *            "prov_order_id":"123456",
     *            "orig_total_fee":"50000",
     *            "is_ok":"0", 
     *            "cust_name":"奚敏辉",
     *            "pspt_no":"12345678",
     *            "photo_links":"http://res.woboss.gz186.com/uploader/goodsimages/201504232158113515701303.png", 
     *            "goods_name":"【一年卡】12GB上网卡 包2GB全国流量 10GB省内流量 直降180元！", 
     *            "income_money":"220", 
     *            "phone_number":"13885185322",
     *            "product_id":"99999830", //product_id 找不到的时候为空字符串""
     *            "ctlg_code": "5",
     *            "user_type": "00", //'00''预付费', '01'后付费
     *            "staff_id":"abcde",
     *            "eparchy_code":"0541",
     *            "depart_id":"12345"
     *            }]
     * @param param
     * @return
     */
    @RequestMapping(value="/queryBssOrderList", method = RequestMethod.POST)
    @ResponseBody
    public List<Map<String, String>> queryBssOrderList(@RequestBody Map<String, String> param){
    	String user_id = param.get("user_id");
    	String order_id = param.get("order_id");
    	String phone_number = param.get("phone_number");
    	String is_ok = param.get("is_ok"); // 1身份证已经补录，0身份证未补录，“”表示全部
    	String start_day = param.get("start_day");
    	String end_day = param.get("end_day");
    	String pageNum = param.get("pageNum");
    	String pageSize = param.get("pageSize");
    	
    	return orderService.queryBssOrderList(
				user_id, is_ok, order_id, phone_number, start_day, end_day, pageNum,
				pageSize);
    	
    }    
    
    
    /**
     * bss 获取写卡数据接口，给文辉app调用
     * app传参json：{"user_id":"12345", //能人id
     *               "phone_number":"18651885060",  //订单选中的手机号码
     *               "iccid":"123456",  // 蓝牙读卡器读出来的sim iccid
     *               "cust_name":"奚敏辉", //蓝牙读卡器读出来的身份证姓名
     *               "pspt_id":"32028229840116211",  //蓝牙读卡器读出来的身份证号码
     *               "product_id":"12345656", //queryBssOrderList接口获取的订单信息里返给app的
     *               "ctlg_code":"10", //商品类目
     *               "user_type": "00" //'00''预付费', '01'后付费
     *               }
     * 返回json：{"respCode":"0000", //0000 成功，其他表示失败
     *               "respDesc":"xxx",  //描述
     *               "data":{"ICCID":"12345", "IMSI":"123455", "ProcId":"12345", "CardData":"xxx"}  
     *               }               
     * @param param
     * @return
     */
    @RequestMapping("/bssGetCardData")
    @ResponseBody
    public RespInfo<Map<String, String>> bssGetCardData(@RequestBody Map<String, Object> param){
    	
    	//封装请求参数map，参数名字要转换成接口规范
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
    	paramsMap.put("UserNum", (String)param.get("phone_number"));
    	paramsMap.put("SimCard", (String)param.get("iccid"));
    	paramsMap.put("CustName", (String)param.get("cust_name"));
    	paramsMap.put("PsptId", (String)param.get("pspt_id"));
    	paramsMap.put("ProductId", (String)param.get("product_id"));
    	paramsMap.put("BusiType", "32");//??“3”，代表3G网络“2”代表新开。
    	paramsMap.put("ProcId", BssIntfUtil.generateLogId("")); //20位
    	
    	//10:省份新号入网 ，11：省份上网卡
    	if("10".equals(param.get("ctlg_code"))){
    		paramsMap.put("CardType", "04");  //04	3G本地USIM卡	3G用户开户及本地补换卡
    	}
    	else{
    		paramsMap.put("CardType", "05"); //05	3G无线上网卡	3G无线上网卡开户
    	}
    	paramsMap.put("UserType", (String)param.get("user_type"));//00	预付费用户, 01 	后付费用户
    	
    	//根据能人id，查出该能人归属地市，然后获取该地市用于bss接口的公用省市区，渠道id，渠道类型信息
		Map<String, Object> param2 = bssIntfService.addCommonParam((String)param.get("user_id"));
		paramsMap.put("EparchyCode", param2.get("EparchyCode"));
		paramsMap.put("StaffId", param2.get("StaffId"));
		paramsMap.put("DepartId", param2.get("DepartId"));
    	
    	RespInfo<Map<String, String>> respInfo = bssIntfService.callIntfGetCardData(paramsMap);
    	//添加下面3个参数是因为后面写卡结果通知接口需要用到，免的再查一遍数据库
    	respInfo.getData().put("EparchyCode", (String)param2.get("EparchyCode"));
    	respInfo.getData().put("StaffId", (String)param2.get("EparchyCode"));
    	respInfo.getData().put("DepartId", (String)param2.get("EparchyCode"));
    	return respInfo;
    }
    
    /**
     * 封装的写卡结果通知接口
     * 包括：1.沃掌柜订单归档 2.修改订单主表里写卡状态  3.bss写卡结果通知接口   
     * 新增  4.卡数据同步接口， 5.卡处理结果提交接口
     * app传参json：{"phone_number":"18651885060",  //订单选中的手机号码
     *               "iccid":"123456",  // 蓝牙读卡器读出来的sim iccid
     *               "imsi":"123456", //
     *               "EparchyCode":"0850",  //蓝牙读卡器读出来的身份证号码
     *               "StaffId":"abcd", //queryBssOrderList接口获取的订单信息里返给app的
     *               "DepartId":"abcde", //商品类目
     *               "OperRst":"0", //写卡结果:0：写卡成功,非0则由读卡器返回的错误代码
     *               "ProcId":"12345", // 获取写卡数据接口返回的里面有这个流水id
     *               "user_id":"12345", //能人id
     *               "ProvOrderID":"12345", //省份订单id，queryBssOrderList接口成功后会返回在data节点里
     *               "order_id":"12345656", //queryBssOrderList接口获取的订单信息里返给app的
     *               "CardData":"xxx", //获取写卡数据接口返回的
     *               "OrigTotalFee":"50000" //查询订单列表接口 返回给app
     *               }
     * 返回json：{"respCode":"0000", //0000 成功，其他表示失败
     *               "respDesc":"xxx"  //描述
     *               }  
     * @param param
     * @return
     */
    @RequestMapping("/bssWriteCard")
    @ResponseBody
    public RespInfo<Map<String, String>> bssWriteCard(@RequestBody Map<String, String> param){
    	RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
    	
    	//封装请求参数map，参数名字要转换成接口规范
    	Map<String, Object> paramsMap = new HashMap<String, Object>();
    	paramsMap.put("UserNum", param.get("phone_number"));
    	paramsMap.put("Iccid", param.get("iccid"));
    	paramsMap.put("Imsi", param.get("imsi"));
    	paramsMap.put("EparchyCode", param.get("EparchyCode"));
    	paramsMap.put("StaffId", param.get("StaffId"));
    	paramsMap.put("DepartId", param.get("DepartId"));
    	paramsMap.put("UpdateTime", DateUtils.getCurentTime("yyyy-MM-dd HH:mm:ss"));
    	paramsMap.put("OperRst", param.get("OperRst")); //写卡结果:0：写卡成功,非0则由读卡器返回的错误代码
    	paramsMap.put("ProcId2", param.get("ProcId")); //获取写卡数据接口返回的里面有这个流水id
    	
    	//如果写卡成功，先把沃掌柜里订单状态改为归档 
    	//1.更新ord_d_base 里的order_state 状态为 08 已归档
    	//2.修改订单主表里写卡状态, //0 写卡成功才调用，失败就不用掉此接口
    	if("0".equals(param.get("OperRst"))){
    		int n3 = orderService.updateOrderArchive(param.get("phone_number"));
    		if( n3 > 0){
    			respInfo.setRespCode("0000");
    			respInfo.setRespDesc("沃掌柜订单归档成功");
    			//再加上录单请求需要传给沃易登的数据
    		}
    		else{
    			respInfo.setRespCode("0001");
    			respInfo.setRespDesc("手机号:" + param.get("phone_number") + ",订单归档失败");
    			return respInfo;
    		}
    		
    		//
        	param.put("write_card_status", "0");
        	int i = appService.updateWriteCardStatus(param);
    	}
    	

    	
    	//3.通知bss 写卡结果
    	RespInfo<Map<String, String>> respInfo3 = bssIntfService.callIntfWriteCard(paramsMap);
    	
    	//写卡通知接口成功了才继续往下走判断
		if("0000".equals(respInfo3.getRespCode())){
		}
		else{
			respInfo.setRespCode(respInfo3.getRespCode());
			respInfo.setRespDesc("【写卡结果通知接口】" + respInfo3.getRespDesc()); 
			return respInfo;
		}
		
    	//0 写卡成功才调用 4,5 两个接口，失败就不用
    	if("0".equals(param.get("OperRst"))){
    		//先拼装所有bss请求需要用到的公共参数，比如工号，省市区县
    		Map<String, Object> param2 = bssIntfService.addCommonParam(param.get("user_id"));
    		param2.put("OrderID", param.get("order_id"));
    		param2.put("orderID", param.get("order_id"));
    		param2.put("ProvOrderID", param.get("ProvOrderID"));
    		param2.put("NumID", param.get("phone_number"));
    		param2.put("SimID", param.get("iccid"));
    		param2.put("IMSI", param.get("imsi"));
    		param2.put("CardData", param.get("CardData"));
    		param2.put("OrigTotalFee", param.get("OrigTotalFee"));
    		//4.卡数据同步接口
    		RespInfo<Map<String, String>> respInfo4 = bssIntfService.callIntfWriteCardPre(param2);

    		if("0000".equals(respInfo4.getRespCode())){
    		}
    		else{
    			respInfo.setRespCode(respInfo4.getRespCode());
    			respInfo.setRespDesc("【卡数据同步接口】" + respInfo4.getRespDesc()); 
    			return respInfo;
    		}
    		
    		//5.卡处理结果提交接口
			RespInfo<Map<String, String>> respInfo5 = bssIntfService.callIntfOrderSub2(param2);
    		if("0000".equals(respInfo5.getRespCode())){
    		}
    		else{
    			respInfo.setRespCode(respInfo5.getRespCode());
    			respInfo.setRespDesc("【卡处理结果提交接口】" + respInfo5.getRespDesc()); 
    			return respInfo;
    		}
    		
    		//走到这里表示以上接口都成功
    		respInfo.setRespCode("0000"); 
    		respInfo.setRespDesc("订单提交到bss成功");
    		return respInfo;
    	}
    	else{
    		//写卡失败 则直接返回,走到这一步，respInfo3肯定是成功的0000
    		return respInfo3;	
    	}

    }
    
    /**
     * 封装的bss开户接口
     * 封装了 bss开户 的几个顺序调用的接口：1客户资料验证接口，2用户校验接口，3订购信息合法性验证与费用计算接口, 5.开户信息预提交接口， 6.订单提交接口
     * app传参json：{"user_id":"12345", //能人id
     *               "pspt_id":"32028229840116211",  //蓝牙读卡器读出来的身份证号码
     *               "order_id":"12345656", //queryBssOrderList接口获取的订单信息里返给app的
     *               "cust_name":"奚敏辉", //蓝牙读卡器读出来的身份证姓名
     *               "phone_number":"18651885060",  //订单选中的手机号码
     *            "developer_code":"",
     *            "developer_name":"",
     *            "channel_code":"",
     *            "channel_name":""               
     *               }
     * 返回json：{"respCode":"0000", //0000 成功，其他表示失败
     *               "respDesc":"xxx"  //描述
     *               }   
     * @param param
     * @return
     */
    @RequestMapping("/bssOpenAll")
    @ResponseBody
    public RespInfo<Map<String, String>> bssOpenAll(@RequestBody Map<String, String> param){
    	//封装请求参数map，参数名字要转换成接口规范
    	Map<String, String> paramsMap = new HashMap<String, String>();
    	paramsMap.put("userId", param.get("user_id"));
    	paramsMap.put("idCardNum", param.get("pspt_id"));
    	paramsMap.put("orderId", param.get("order_id"));
    	paramsMap.put("custName", param.get("cust_name"));
    	paramsMap.put("phoneNum", param.get("phone_number"));
    	paramsMap.put("developerCode", param.get("developer_code"));
    	paramsMap.put("developerName", param.get("developer_name"));
    	paramsMap.put("channelCode", param.get("channel_code"));
    	paramsMap.put("channelName", param.get("channel_name"));

    	//调用bss接口开户
    	RespInfo<Map<String, String>> respInfo = bssIntfService.callBssOpenAll(paramsMap);
    	
    	//如果开户成功，修改 订单主表 intf_order_status 字段为0，为了返回给app时统一返回值
    	if("0000".equals(respInfo.getRespCode())){
    		param.put("intf_order_status", "0");
    		param.put("prov_order_id", respInfo.getData().get("ProvOrderID"));
    		param.put("orig_total_fee", respInfo.getData().get("OrigTotalFee"));
    	}
    	else{
    		param.put("intf_order_status", respInfo.getRespCode());
    		param.put("prov_order_id", "");
    		param.put("orig_total_fee", "");
    	}
		param.put("intf_order_desc", respInfo.getRespDesc());
		//更新intf_order_status，intf_order_desc，prov_order_id 三个字段
		int i = appService.updateOrderIntfStatus(param);
		
		
    	return respInfo;
    }
    
	/**
	 * 根据android还是ios系统查询当前最新的app版本号和下载地址
	 * @param inParam
	 * @return
	 */
	@RequestMapping(value = "/queryLatestVersion")
	@ResponseBody
	public RespInfo<Map<String, String>> queryLatestVersion(@RequestBody Map<String, String> inParam){
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		
		if(inParam.containsKey("os")){
			Map<String, String> row = appService.queryLatestVersion(inParam);
			
			if(MapUtils.isNotEmpty(row)){
				respInfo.setRespCode("0");
				respInfo.setRespDesc("获取最新版本成功");
				respInfo.setData(row);
			}
			else{
				respInfo.setRespCode("-1");
				respInfo.setRespDesc("没有查询到最新版本号");
			}
		}
		else{
			respInfo.setRespCode("-1");
			respInfo.setRespDesc("请求中必须有os参数");
		}

		return respInfo;
	}
	
	/**
	 * 4G 订单状态同步，app每次查询到统一门户的订单状态，要同时保存到沃掌柜里
     * app传参json：{"phone_number":"18651885060",  //订单的手机号码
     *               "intf_order_status":"0" //统一门户系统的订单状态
     *               "intf_order_desc":"abcd" //统一门户系统的订单错误描述
     *               }
     * 返回json：{"respCode":"0", //0 成功，其他表示失败
     *               "respDesc":"xxx"  //描述
     *               }  
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/updateOrderIntfStatus", method = RequestMethod.POST)
	@ResponseBody
	public RespInfo<Map<String, String>> updateOrderIntfStatus(@RequestBody Map<String, String> param){
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		
		int i = appService.updateOrderIntfStatus(param);
		
		if(i > 0){
			respInfo.setRespCode("0");
			respInfo.setRespDesc("更新接口订单状态成功");
		}
		else{
			respInfo.setRespCode("-1");
			respInfo.setRespDesc("更新接口订单状态失败");
		}

		return respInfo;
	}
	
	/**
	 * 4G 沃掌柜写卡状态同步，app每次写卡完毕，除了要通知统一门户接口，还要同时保存到沃掌柜里，
	 * 0 写卡成功才调用，失败就不用掉此接口
     * app传参json：{"phone_number":"18651885060",  //订单的手机号码
     *               "write_card_status":"0" //0 写卡成功才调用，失败就不用掉此接口
     *               }
     * 返回json：{"respCode":"0", //0 成功，其他表示失败
     *               "respDesc":"xxx"  //描述
     *               }  
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/updateWriteCardStatus", method = RequestMethod.POST)
	@ResponseBody
	public RespInfo<Map<String, String>> updateWriteCardStatus(@RequestBody Map<String, String> param){
		RespInfo<Map<String, String>> respInfo = new RespInfo<Map<String, String>>();
		
		int i = appService.updateWriteCardStatus(param);
		
		if(i > 0){
			respInfo.setRespCode("0");
			respInfo.setRespDesc("沃掌柜写卡状态成功");
		}
		else{
			respInfo.setRespCode("-1");
			respInfo.setRespDesc("沃掌柜写卡状态失败");
		}

		return respInfo;
	}	
}
