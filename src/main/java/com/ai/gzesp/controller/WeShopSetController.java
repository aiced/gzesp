package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @RequestMapping("/weShopSet")
    @ResponseBody
    public ModelAndView weShopSet(@RequestParam(value = "userid", required = true)String strUserID){
    	String userId = strUserID;
    	//edit_by_wenh_2015_3_25
//    	if(userId == null){
//    		userId = "2015031806433310";
//    	}
    	System.out.println("userid"+userId);
    	List<Map<String, Object>> userlist = goodsSql.GetProfileList(userId);   
    	Map rspMap = new HashMap();
    	rspMap.put("rspCode", "0000");
    	rspMap.put("name", userlist.get(0).get("user_name"));
    	rspMap.put("storename", userlist.get(0).get("storeName"));
    	rspMap.put("userId", userId);   
    	rspMap.put("total", userlist.size());   
    	rspMap.put("title", "店铺设置");
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("userlist", userlist);  
    	//edit_by_wenh_2015_3_25
    	rspMap.put("weixin", userlist.get(0).get("weixin_id"));

    	return new ModelAndView("weShopSet.ftl", rspMap);
    }
//    更新资料
    @RequestMapping("/weShopSetUpdate")
    @ResponseBody
    public ModelAndView weShopSetUpdate(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String strUserName=paramsMap.get("username");
    	String storeName = paramsMap.get("storeName");
    	String phoneNum = paramsMap.get("phoneNum");    	
    	String userId = paramsMap.get("userId");    	
    	//edit_by_wenh_2015_3_25
    	String weixinid=paramsMap.get("weixinid");
    	System.out.println(weixinid);
    	TdAurDAUTHINFO tdAurDAUTHINFO = new TdAurDAUTHINFO();
    	tdAurDAUTHINFO.setStoreName(storeName);
    	tdAurDAUTHINFO.setPhoneNumber(phoneNum);
    	tdAurDAUTHINFO.setWeixinId(weixinid);
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("USER_ID", userId);    	
    	tdAurDAUTHINFODao.updateByExampleSelective(tdAurDAUTHINFO, example);

    	
    	//edit_by_wenh_2015_3_25
    	ModelAndView mav = null;
    	ModelMap mmap=null;
		mmap=new ModelMap();
        //从数据库获取信息赋值
//		mmap.addAttribute("title", "我的微店");
		mmap.addAttribute("userid", userId);
//		mmap.addAttribute("name", strUserName);//姓名
//		mmap.addAttribute("storename", storeName);//店名
//		mmap.addAttribute("phone", phoneNum); //手机号
//		mmap.addAttribute("weixin",weixinid ); //微信
		mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap);    
    	
    	return mav;
    }
    
    
//   二维码界面。
    @RequestMapping("/weShopSet/weShopSetQrcode")
    public ModelAndView weShopSetQrcode(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
        //返回数据表格子页面
    	String userId = paramsMap.get("userId");
        ModelAndView mav = new ModelAndView("weShopSetQrcode.ftl"); 
        mav.addObject("name", "喻露露");
        mav.addObject("phone", "18685292522"); 
        mav.addObject("weixin", "1306520198@qq.com"); 
        mav.addObject("userId", userId);
        return mav;
    }
}
