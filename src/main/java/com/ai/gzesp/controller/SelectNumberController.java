package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.bssintf.NumInfo;
import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dto.NumberConResult;
import com.ai.gzesp.dto.RespInfo;
import com.ai.gzesp.dto.SelectNumberQueryCon;
import com.ai.gzesp.service.BssIntfService;
import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.service.WeShopService;
import com.mysql.jdbc.StringUtils;

@Controller
@RequestMapping("/order")
public class SelectNumberController {

    @Autowired
    private SelectNumberService selectNumberService;
    
    @Autowired
    private WeShopService weShopService;
    
    @Autowired
    private BssIntfService bssIntfService;
    
    /**
     * 三级页面：新号入网-选择号码 <br>
     * 此方法作废了，因为号码选择页面被 include到其他页面
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/selectNumber")
    public ModelAndView selectNumber(){
        ModelAndView mav = new ModelAndView("selectNumber.ftl");
        
        //商品归属地市下拉框  
        List<Map<Object, Object>> citys = weShopService.getCitys();
        //ess_city_code city_code, city_name, ess_province_code province_code
/*        Map<Object, Object> all = new HashMap<Object, Object>(); //加入全省选项
        all.put("CITY_CODE", "%");
        all.put("CITY_NAME", "全省");
        all.put("PROVINCE_CODE", "85");
        citys.add(0, all);*/
        mav.addObject("citys", citys);
        
        //获取靓号规则下拉框
        List<Map<Object, Object>> rules = selectNumberService.getNumberRules();
        mav.addObject("rules", rules);
        
        //数据库分页获取号码列表，默认归属贵阳,预存0-10000，第一页,一页20个, 网络类型null默认全部号码都可以选
        //List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(null, null, 0, 10000, 1, 20, null, null, null, null);
        //mav.addObject("numbers", numbers);
        
        return mav;
    }
    
    /**
     * 三级页面：新号入网-选择号码 <br>
     * 输入尾号搜索 ajax刷新号码列表
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/queryNumbersByAjax")
    public ModelAndView queryNumbersByAjax(@RequestBody SelectNumberQueryCon con){
        // 返回数据表格子页面
        ModelAndView mav = new ModelAndView("selectNumberSub.ftl");
        
        //20160618 ximh 修改，增加对bss本地产品的支持
        //bss本地产品选号码，开户，资料验证等都需要调用bss接口，沃掌柜原本只支持总部4G产品，通过物品属性里ctlg_code来区分总部和本地产品
        //10:省份新号入网 ，11省份上网卡
        if("10".equals(con.getCtlg_code())){
        	//拼装请求参数
        	Map<String, Object> param = bssIntfService.addCommonParam(con.getUser_id());
        	if("预付费".equals(con.getSer_type())){
        		param.put("SerType", "2");
        	}
        	else{
        		param.put("SerType", "1"); //1-后付费 2-预付费

        	}
        	if(StringUtils.isNullOrEmpty(con.getKeyword())){
            	param.put("QueryType", "01"); //选号条件 01：随机 ,03：号码关键字
            	param.put("QueryPara1", con.getKeyword());        		
        	}
        	else{
        		param.put("QueryType", "03"); //选号条件 01：随机 ,03：号码关键字
            	param.put("QueryPara1", con.getKeyword());        	
        	}
        	param.put("ProductID", con.getProduct_id());  
        	
        	RespInfo<List<NumInfo>> respInfo = bssIntfService.callIntfNumQuery(param);
        	List<Map<String, Object>> numbers = bssIntfService.listNumInfo2list(respInfo.getData());
        	mav.addObject("numbers", numbers);
        }
        else{
        	// 从数据库按分页查询，默认第一页,一页5个 注意参数转成了小写
        	List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(con.getEparchy_code(),
        			con.getNice_rule(), con.getNice_fee_start(), con.getNice_fee_end(), con.getPageNum(),
        			con.getPageSize(), con.getKeyword(), con.getSort(), con.getSortCol(), con.getNetType());
        	mav.addObject("numbers", numbers);
        }
        
    	// 从数据库按分页查询，默认第一页,一页5个 注意参数转成了小写
//    	List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(con.getEparchy_code(),
//    			con.getNice_rule(), con.getNice_fee_start(), con.getNice_fee_end(), con.getPageNum(),
//    			con.getPageSize(), con.getKeyword(), con.getSort(), con.getSortCol(), con.getNetType());
//    	mav.addObject("numbers", numbers);

        return mav;
    }
    
    /**
     * 功能描述: 选择号码页面点击号码后，需要预占号码，变更号码状态<br>
     *
     * @param con
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/updateNumberState")
    @ResponseBody
    public NumberConResult updateNumberState(@RequestBody NumberConResult con){
    	
    	// 号码预占
    	String status = Constants.STATUS_FAILD;
    	
        //20160618 ximh 修改，增加对bss本地产品的支持
        //bss本地产品选号码，开户，资料验证等都需要调用bss接口，沃掌柜原本只支持总部4G产品，通过物品属性里ctlg_code来区分总部和本地产品
        //10:省份新号入网 ，11省份上网卡
        if("10".equals(con.getCtlg_code())){
        	//拼装请求参数
        	Map<String, Object> param = bssIntfService.addCommonParam(con.getUser_id());
        	param.put("ResourcesType", "02"); //02  手机号码
        	param.put("ResourcesCode", con.getSerial_number());
        	param.put("OccupiedFlag", "1"); //1	预占
        	
        	RespInfo<Map<String, String>> respInfo = bssIntfService.callIntfCheckRes(param);
        	if("0000".equals(respInfo.getRespCode())){
        		status = Constants.STATUS_SUCCESS;
        	}
        }
        else{

        	boolean isSuccess = selectNumberService.updateNumberState(con.getSerial_number()); //更新成功的记录数
        	if(isSuccess){
        		status = Constants.STATUS_SUCCESS;
        	}
        }

//    	boolean isSuccess = selectNumberService.updateNumberState(con.getSerial_number()); //更新成功的记录数
//    	if(isSuccess){
//    		status = Constants.STATUS_SUCCESS;
//    	}
        
        NumberConResult result = new NumberConResult();
        result.setSerial_number(con.getSerial_number());
        result.setStatus(status);
        result.setNice_fee(con.getNice_fee());
        return result;
    }
}
