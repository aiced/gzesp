package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

/**
 * 一级功能：wap端<br> 
 * 二级功能：店铺主页
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
@Controller
@RequestMapping("/weShop")
public class WeShopController {
    
    @Autowired
    private WeShopService weShopService;
    
    /**
     * 三级页面：店铺主页 <br>
     * 〈功能详细描述〉
     *
     * @param user_id 能人id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/index/{user_id}")
    public ModelAndView index(@PathVariable("user_id") String user_id){
        ModelAndView mav = new ModelAndView("weShopIndex.ftl");
        //根据shopId获取 能人信息 店铺名称 手机 微信
        Map<Object, Object> developer = weShopService.getDevloperInfo(user_id);
        mav.addObject("developer", developer);
        
        //获取广告轮播图片的url
        List<Map<String, String>> banners = weShopService.getBanners();
        mav.addObject("banners", banners);
        
        //获取店长推荐 热销前4的商品 
        List<Map<Object, Object>> dztj = weShopService.getDztj(user_id);
        mav.addObject("dztj", dztj);
        
        //获取热销合约商品
        List<Map<Object, Object>> rxhy = weShopService.getRxhy();
        mav.addObject("rxhy", rxhy);
        
        //获取热销网卡商品
        List<Map<Object, Object>> rxwk = weShopService.getRxwk();
        mav.addObject("rxwk", rxwk);

        mav.addObject("user_id", user_id); //能人id赋给页面,后面一路传下去至订单完成
        return mav;
    }
}
