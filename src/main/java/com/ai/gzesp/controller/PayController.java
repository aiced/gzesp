package com.ai.gzesp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.PayService;

/**
 * 支付入口<br> 
 * 公共的方法入口
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/pay")
public class PayController {
    
    @Autowired
    private PayService payService;

    /**
     * 选择支付方式(在线支付or货到付款) 以及选择 银联or支付宝 <br>
     * 〈功能详细描述〉
     *
     * @param order_id
     * @param fee
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/selectPayMode/{order_id}/{fee}")
    public ModelAndView selectPayMode(@PathVariable("order_id") String order_id, @PathVariable("fee") String fee){
        ModelAndView mav = new ModelAndView("selectPayMode.ftl");
        
        mav.addObject("title", "选择支付方式");
        mav.addObject("order_id", order_id);
        mav.addObject("fee", fee);
        return mav;
    }
    

    /**
     * 支付结束后，选择再去逛逛，回到能人店铺的首页
     * 根据order_id 查询 能人id，然后再跳转
     * @param order_id
     * @param fee
     * @return
     */
    @RequestMapping("/goToWeShopIndex/{order_id}")
    public ModelAndView goToWeShopIndex(@PathVariable("order_id") String order_id){
    	Map<Object, Object> userInfo = payService.queryUserIdByOrderId(order_id);
    	
        ModelAndView mav = new ModelAndView("redirect:/weShop/index/"+userInfo.get("USER_ID"));
    	//ModelAndView mav = new ModelAndView("redirect:/weShop/index/"+"2015000000000000");
        
        return mav;
    }

}
