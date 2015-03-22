package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.beans.TdGdsDABLEACTIVITY;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.dao.service.TdGdsDABLEACTIVITYDao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class WeShopSetController {
    
    @Autowired
    private WeShopService weShopService;
    @Resource 
    GoodsSql goodsSql;
    @Resource 
    TdAurDAUTHINFODao tdAurDAUTHINFODao;
    
//    @RequestMapping("/index/{user_id}")
//    public ModelAndView index(@PathVariable("user_id") String user_id){
//        ModelAndView mav = new ModelAndView("weShopIndex.ftl");
    
    @RequestMapping("/weShopSet/{user_id}")
    
    public ModelAndView weShopSet(@PathVariable("user_id") String user_id){
    	String userId = user_id;
    	if(userId == null){
    		userId = "2015031806433310";
    	}
    	List<Map<String, Object>> userlist = goodsSql.GetProfileList(userId);   
    	Map rspMap = new HashMap();    
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");
    	rspMap.put("userId", userId);   
    	rspMap.put("total", userlist.size());   
    	rspMap.put("title", "店铺设置");
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("userlist", userlist);  
    	return new ModelAndView("weShopSet.ftl", rspMap);
    }
//    更新资料
    @RequestMapping("/weShopSetUpdate")
    @ResponseBody
    public void weShopSetUpdate(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String storeName = paramsMap.get("storeName");
    	String phoneNum = paramsMap.get("phoneNum");    	
    	String userId = paramsMap.get("userId");    	

    	TdAurDAUTHINFO tdAurDAUTHINFO = new TdAurDAUTHINFO();
    	tdAurDAUTHINFO.setStoreName(storeName);
    	tdAurDAUTHINFO.setPhoneNumber(phoneNum);
    	
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("USER_ID", userId);    	
    	tdAurDAUTHINFODao.updateByExampleSelective(tdAurDAUTHINFO, example);

    }
    
    
//   二维码界面。
    @RequestMapping("/weShopSet/weShopSetQrcode")
    public ModelAndView weShopSetQrcode(){
        //返回数据表格子页面
        ModelAndView mav = new ModelAndView("weShopSetQrcode.ftl"); 
        mav.addObject("name", "喻露露");
        mav.addObject("phone", "18685292522"); 
        mav.addObject("weixin", "1306520198@qq.com"); 
        mav.addObject("title", "二维码");
        return mav;
    }
}
