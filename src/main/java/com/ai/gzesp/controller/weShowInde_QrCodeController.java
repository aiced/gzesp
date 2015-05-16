package com.ai.gzesp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/weShop")
public class weShowInde_QrCodeController {
    @Autowired
    private WeShopService weShopService;
    
//  二维码界面。
   @RequestMapping("/Qrcode")
   public ModelAndView weShopSetQrcode(@RequestParam(value = "userid", required = true)String strUserID){

       ModelAndView mav = new ModelAndView("weShopIndex_QrCode.ftl"); 
       mav.addObject("userid", strUserID);
       mav.addObject("title","店铺二维码");
       
       return mav;
   }
}
