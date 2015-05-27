package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dto.GoodsDetailResult;
import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.token.Token;

@Controller
@RequestMapping("/weShop")
public class GoodDetailController {

    @Autowired
    private WeShopService weShopService;
    
    @Autowired
    private SelectNumberService selectNumberService;
    
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
    @Token(save=true)
    @RequestMapping("/goodDetail/{user_id}/{ctlg_code}/{goods_id}")
    public ModelAndView goodDetail(@PathVariable("user_id") String user_id, @PathVariable("ctlg_code") String ctlg_code, @PathVariable("goods_id") String goods_id){
    	//调用公共业务逻辑获取各种信息
    	ModelAndView mav = getGoodDetailPublic(user_id, ctlg_code, goods_id);

        //edit_by_wenh_2015_4_18
        weShopService.insertVisitLog(user_id);
        return mav;
    }
    
    /**
     * banner图片如果是单个商品则跳转到商品详情页
     * 后台配置banner图的跳转href链接：/weShop/bannerGoodDetail/{goods_id} , {user_id}会在weShopIndex.ftl 里动态拼接
     * @param user_id
     * @param ctlg_code
     * @param goods_id
     * @return
     */
    @Token(save=true)
    @RequestMapping("/bannerGoodDetail/{goods_id}/{user_id}")
    public ModelAndView bannerGoodDetail(@PathVariable("goods_id") String goods_id, @PathVariable("user_id") String user_id){
    	ModelAndView mav = null;
        //先根据商品id获取商品类目
        Map<String, String> ctlg = weShopService.getCtlgCode(goods_id);
        //如果根据商品id没捞到商品类目，则返回首页
        if(ctlg == null || ctlg.isEmpty()){
        	mav = new ModelAndView("redirect:/weShop/index/"+user_id);
        }
        String ctlg_code = ctlg.get("CTLG_CODE");
        //调用公共业务逻辑获取各种信息
        mav = getGoodDetailPublic(user_id, ctlg_code, goods_id);
        //从banner跳到商品详情页就不记录访问日志了
        return mav;
    }   
    
    /**
     * 获取商品详情的公共业务逻辑
     * @param user_id
     * @param ctlg_code
     * @param goods_id
     * @return
     */
    private ModelAndView getGoodDetailPublic(String user_id, String ctlg_code, String goods_id){
    	ModelAndView mav = null;
        //根据不同商品类目，跳转到不同页面
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
        
        //查询商品的 名称 价格 自定义活动 等所有字段属性
        GoodsDetailResult goodDetail = weShopService.getGoodDetail(goods_id, user_id);
        mav.addObject("detail", goodDetail);
        
        //商品评价条数  暂不考虑
        
        //商品归属地市下拉框  
        List<Map<Object, Object>> citys = weShopService.getCitys();
        //ess_city_code city_code, city_name, ess_province_code province_code
/*        Map<Object, Object> all = new HashMap<Object, Object>(); //加入全省选项
        all.put("CITY_CODE", "%");
        all.put("CITY_NAME", "全省");
        all.put("PROVINCE_CODE", "85");
        citys.add(0, all);*/
        mav.addObject("citys", citys);
        
        //查看有货无货
        Map<Object, Object> store = weShopService.getStoreNum(goods_id);
        mav.addObject("store", store);
        
        //版本 颜色 内存 优惠活动    这些都是通过商品关联物品获取物品属性
        Map<Object, List<Map<Object, Object>>> attrs = weShopService.getAttrs(goods_id);
        mav.addObject("attrs", attrs);
        
        mav.addObject("user_id", user_id); //能人id赋给页面,后面一路传下去至订单完成
        
        //如果是新号入网，因为要include 号码选择子页，还需要查询出号码选择列表的信息
        if(Constants.CTLG_CODE_XHRW_5.equals(ctlg_code) || Constants.CTLG_CODE_XHRW_10.equals(ctlg_code)){
            //号码选择子页面需要下面 靓号规则和号码列表
            //获取靓号规则下拉框
            List<Map<Object, Object>> rules = selectNumberService.getNumberRules();
            mav.addObject("rules", rules);
            
//            String net_type = null;
//            if(attrs.get("NETTYPE") != null){
//            	net_type = (String) attrs.get("NETTYPE").get(0).get("ATTR_CODE"); //网络类别2G/3G/4G/CARD
//            }
//            //数据库分页获取号码列表，默认归属贵阳,预存0-10000，第一页,一页20个,
//            List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(null, null, 0, 10000, 1, 20, null, null, null, net_type);
//            mav.addObject("numbers", numbers);
        }
        
        //edit_by_wenh_2015_4_18
        //weShopService.insertVisitLog(user_id);   	
        
        return mav;
    }
}
