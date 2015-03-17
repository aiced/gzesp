package com.ai.gzesp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.bouncycastle.asn1.ocsp.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/shopManage")
public class WeShopHomeController {

//	@Resource
//	TdAurDAUTHINFODao tdAurDAUTHINFODao;
	
    @Autowired
    private WeShopService weShopService;
    
    @RequestMapping("/weShopHome")
    @ResponseBody
    public ModelAndView index(HttpServletRequest requestinputParams){
    	System.out.println(requestinputParams.getParameter("title"));
        ModelAndView mav = new ModelAndView("weShopHome.ftl");
        //从数据库获取信息赋值

        
        
    	Criteria myCriteria = new Criteria();
    	myCriteria.createConditon().andEqualTo("ID", requestinputParams.getParameter("id"));
 
//    	List<TdAurDAUTHINFO> list = tdAurDAUTHINFODao.selectByExample(myCriteria);
              
        mav.addObject("id",requestinputParams.getParameter("id"));
        mav.addObject("userid",requestinputParams.getParameter("userid"));
        mav.addObject("title",requestinputParams.getParameter("title"));
        mav.addObject("name", requestinputParams.getParameter("name"));
        mav.addObject("phone", requestinputParams.getParameter("phone")); 
        mav.addObject("weixin", requestinputParams.getParameter("weixin")); 
        
        
        
        return mav;
    }
}
