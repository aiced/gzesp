package com.ai.gzesp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/weShop")
public class CardGoodSelectController {

    @Autowired
    private WeShopService weShopService;
    
    /**
     * 三级页面：店铺主页-上网卡-商品选择页面<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/cardGoodSelect")
    public ModelAndView phoneGoodSelect(){
        ModelAndView mav = new ModelAndView("cardGoodSelect.ftl");
        //从数据库获取信息赋值

        return mav;
    }
}
