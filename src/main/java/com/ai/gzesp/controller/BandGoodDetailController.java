package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.token.Token;

@Controller
@RequestMapping("/weShop")
public class BandGoodDetailController {

    @Autowired
    private WeShopService weShopService;
    
    /**
     * 三级页面：店铺主页-宽带续费-宽带号验证页面<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/bandGoodDetail")
    public ModelAndView bandGoodDetail(){
        ModelAndView mav = new ModelAndView("bandGoodDetail.ftl");
        //从数据库获取信息赋值
        //广告轮播图片的url
        List<String> banners = new ArrayList<String>();
        banners.add("banner_iphone6.png");
        banners.add("banner_honer_x1.png");
        mav.addObject("banners", banners);

        return mav;
    }
    
    @Token(remove=true)
    @RequestMapping("/bandGoodPostData")
    public ModelAndView bandGoodPostData(HttpServletRequest request,@RequestBody String inputParam){

    	//20150703 ximh modify 提交订单时根据session里是否有 instead属性，来区分是代客下单或者普通用户下单，ord_d_base里插订单类型
    	boolean isInstead = request.getSession(false).getAttribute("instead") == null ? false : true;
    	
    	
    	
    	//这个地方要进行落订单插入表的操作
    	
    	
    	
    	
    	
    	
    	//这里，要根据是否是代客下单 跳转到不同的支付页面
    	//20150703 ximh modify 提交订单时根据session里是否有 instead属性，来区分是代客下单或者普通用户下单，跳转到不同的支付页面
    	String url = null;
    	if(isInstead){
    		//url = "redirect:/pay/insteadPay/" + paramsMap.get("userId") + "/" + orderId;
    	}
    	else{
    		//url = "redirect:/pay/selectPayMode/"+orderId+"/"+fee;
    	}
    	
    	ModelAndView mav = new ModelAndView(url);
    	return mav;
    }  
}
