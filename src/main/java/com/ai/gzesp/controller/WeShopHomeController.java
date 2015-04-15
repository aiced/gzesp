package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.asn1.ocsp.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.beans.TdAurDCOUNT;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.dao.service.TdAurDCOUNTDao;
import com.ai.gzesp.dao.sql.OrdersSql;
import com.ai.gzesp.dao.sql.ViewSql;
import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/shopManage")
public class WeShopHomeController {

	@Resource
	TdAurDCOUNTDao tdAurDCOUNTDao;
	@Resource
	TdAurDAUTHINFODao tdAurDAUTHINFODao;
    @Autowired
    private WeShopService weShopService;
	@Resource 
	OrdersSql ordersSql;
	@Resource 
	ViewSql viewSql;
    @RequestMapping("/weShopHome")
    @ResponseBody
    public ModelAndView index(HttpServletRequest requestinputParams){
        ModelAndView mav = new ModelAndView("weShopHome.ftl");
        
        String strUserID=requestinputParams.getParameter("userid");
        
        //从数据库获取信息赋值
       	Criteria myCriteria = new Criteria();
    	myCriteria.createConditon().andEqualTo("USER_ID", strUserID);
 
      	List<TdAurDAUTHINFO> list = tdAurDAUTHINFODao.selectByExample(myCriteria);
    	//ModelMap mmap=null;
    	if(list.size() >= 1) 
    	{
    		//mav = new ModelAndView("weShopHome.ftl");
    		//mmap=new ModelMap();
            //从数据库获取信息赋值
    		mav.addObject("title", "我的微店");
    		mav.addObject("id", list.get(0).getId());
    		mav.addObject("userid",list.get(0).getUserId());
    		mav.addObject("name", list.get(0).getUserName());//姓名
    		mav.addObject("storename", list.get(0).getStoreName());//姓名
    		mav.addObject("phone", list.get(0).getPhoneNumber()); //手机号
    		mav.addObject("weixin", list.get(0).getWeixinId()); //微信
    		mav.addObject("userimage",list.get(0).getUserImg());          
    	} 
        
        
        
        //根据userid查询访问量
    	List<Map<String, Object>> ViewCountlist = viewSql.getViewCountByUserID(strUserID);
        //根据userid查询销售量
       	List<Map<String, Object>> SaleList=ordersSql.getOrderCountByUserID(strUserID);

//    	//根据userid查询佣金值
//    	myCriteria.createConditon().andEqualTo("USER_ID",requestinputParams.getParameter("userid"));
//    	List<TdAurDCOUNT> Yongjinlist = tdAurDCOUNTDao.selectByExample(myCriteria);
    	
    	
        //mav.addObject("id",requestinputParams.getParameter("id"));
//        mav.addObject("userid",requestinputParams.getParameter("userid"));
//        mav.addObject("title",requestinputParams.getParameter("title"));
//        mav.addObject("name", requestinputParams.getParameter("name"));
//        mav.addObject("storename", requestinputParams.getParameter("storename"));
//        mav.addObject("phone", requestinputParams.getParameter("phone")); 
//        mav.addObject("weixin", requestinputParams.getParameter("weixin"));
//        mav.addObject("userimage",requestinputParams.getParameter("userimage"));
        mav.addObject("viewcountlist",ViewCountlist);
        mav.addObject("saleList", SaleList);
      //mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap); 
        return mav;
    }
}
