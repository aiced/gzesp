package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.OrderService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/weShop")
public class BandGoodSelectController {

    @Autowired
    private WeShopService weShopService;
    @Autowired
    private OrderService orderService;
    /**
     * 三级页面：店铺主页-宽带续费-产品选择页面<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
//    @RequestMapping("/bandGoodSelect")
//    public ModelAndView bandGoodSelect(){
//        ModelAndView mav = new ModelAndView("bandGoodSelect.ftl");
//        //从数据库获取信息赋值
//        //广告轮播图片的url
//        List<String> banners = new ArrayList<String>();
//        banners.add("banner_iphone6.png");
//        banners.add("banner_honer_x1.png");
//        mav.addObject("banners", banners);
//
//        return mav;
//    }
    
    @RequestMapping("/bandAcctPostData")
    public ModelAndView bandAcctPostData(@RequestBody String inputParam){
    	
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String user_id = paramsMap.get("user_id");	//能人id
		String num_id=paramsMap.get("num_id"); //宽带账号
    	String productcode=paramsMap.get("productcode");
    	String origfee=paramsMap.get("origfee");
    	String realfee=paramsMap.get("realfee");
    	String oldproductcode=paramsMap.get("oldproductcode");
    	
    	//通过查询gds_d_info表获得goodsid，宽带续约的产品是需要配的
    	Map<String, Object> map=orderService.queryBandGoodsId("12");
    	
        ModelAndView mav = new ModelAndView("bandGoodDetail.ftl");

        mav.addObject("user_id",user_id);
        mav.addObject("num_id",num_id);
        mav.addObject("productcode",productcode);
        mav.addObject("origfee",origfee);
        mav.addObject("realfee",realfee);
        mav.addObject("goods_id",map.get("GOODS_ID").toString());
        mav.addObject("oldproductcode",oldproductcode);
        
        //这里仅仅是拿到数据，然后传递到下个页面
        
        
        
        
        return mav;
    }  
    
    
}
