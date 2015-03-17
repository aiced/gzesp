package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/weShop")
public class GoodDetailController {

    @Autowired
    private WeShopService weShopService;
    
    /**
     * 三级页面：商品详情 公共controller入口，根据传进来的商品目录，跳转到不同的商品详情页面<br>
     * 店铺主页-新号入网-套餐详情
     * 店铺主页-合约购机-商品详情页面
     * 店铺主页-上网卡-商品详情页面
     * 参数参考 GDS_P_CTLG 表
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/goodDetail/{user_id}/{ctlg_code}/{goods_id}")
    public ModelAndView goodDetail(@PathVariable("user_id") String user_id, @PathVariable("ctlg_code") String ctlg_code, @PathVariable("goods_id") String goods_id){
        ModelAndView mav = null;
        if(Constants.CTLG_CODE_XHRW_5.equals(ctlg_code) || Constants.CTLG_CODE_XHRW_10.equals(ctlg_code)){
            mav = new ModelAndView("planDetail.ftl"); //新号入网
        }
        else if(Constants.CTLG_CODE_HYGJ_4.equals(ctlg_code) || Constants.CTLG_CODE_HYGJ_9.equals(ctlg_code)){
            mav = new ModelAndView("phoneGoodDetail.ftl"); //合约购机
        }
        else if(Constants.CTLG_CODE_SWK_6.equals(ctlg_code) || Constants.CTLG_CODE_SWK_11.equals(ctlg_code)){
            mav = new ModelAndView("cardGoodDetail.ftl"); //上网卡
        }
        else if(Constants.CTLG_CODE_KD_7.equals(ctlg_code) || Constants.CTLG_CODE_KD_12.equals(ctlg_code)){
            mav = new ModelAndView("bandGoodDetail.ftl"); //宽带
        }
        else if(Constants.CTLG_CODE_LLB_8.equals(ctlg_code) || Constants.CTLG_CODE_LLB_13.equals(ctlg_code)){
            mav = new ModelAndView("flowGoodDetail.ftl"); //流量包
        }
        else{
            
        }
        
        //查询商品的图片集的link
        List<Map<Object, Object>> banners = weShopService.getGoodPhotos(goods_id);
        mav.addObject("banners", banners);
        
        //查询商品的 名称 价格 自定义活动
        Map<Object, Object> goodDetail = weShopService.getGoodDetail(goods_id, user_id);
        mav.addObject("detail", goodDetail);
        
        //商品评价条数  暂不考虑
        
        //商品归属地市下拉框  
        List<Map<Object, Object>> citys = weShopService.getCitys();
        mav.addObject("citys", citys);
        
        //默认都有货
        
        //版本 颜色 内存 优惠活动    这些都是通过商品关联物品获取物品属性
        Map<Object, List<Object>> attrs = weShopService.getAttrs(goods_id);
        mav.addObject("attrs", attrs);
        
        mav.addObject("user_id", user_id); //能人id赋给页面,后面一路传下去至订单完成
        return mav;
    }
}
