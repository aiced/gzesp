package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dto.GoodSelectQueryCon;
import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/weShop")
public class GoodSelectController {
    
    @Autowired
    private WeShopService weShopService;
    

    /**
     * 三级页面：商品选择列表 公共入口controller<br>
     * 店铺主页-新号入网-套餐列表选择
     * 店铺主页-合约购机-商品选择页面
     * 店铺主页-上网卡-商品选择页面
     * 店铺主页-宽带续费-产品选择页面
     * 店铺主页-特色流量包-产品选择页面
     *
     * @param goodType
     * @param user_id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/goodSelect/{good_type}/{user_id}")
    public ModelAndView goodSelect(@PathVariable("good_type") String goodType, @PathVariable("user_id") String user_id){
        ModelAndView mav = null;
        String[] ctlgArray = null;
        if(Constants.GOOD_TYPE_PLAN.equals(goodType)){
            mav = new ModelAndView("goodSelect.ftl"); //新号入网套餐选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_XHRW_5, Constants.CTLG_CODE_XHRW_10};
        }
        else if(Constants.GOOD_TYPE_PHONE.equals(goodType)){
            mav = new ModelAndView("goodSelect.ftl"); //合约购机选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_HYGJ_4, Constants.CTLG_CODE_HYGJ_9};
        }
        else if(Constants.GOOD_TYPE_CARD.equals(goodType)){
            mav = new ModelAndView("goodSelect.ftl"); //上网卡选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_SWK_6, Constants.CTLG_CODE_SWK_11};
        }
        else if(Constants.GOOD_TYPE_FLOW.equals(goodType)){
            mav = new ModelAndView("flowGoodSelect.ftl"); //特色流量包选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_LLB_8, Constants.CTLG_CODE_LLB_13};
        }
        else if(Constants.GOOD_TYPE_BAND.equals(goodType)){
            mav = new ModelAndView("bandGoodSelect.ftl"); //宽带续约选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_KD_7, Constants.CTLG_CODE_KD_12};
        }
        else{
        }
        
        //从数据库按分页查询，默认第一页,一页10个
        List<Map<Object, Object>> goodList = weShopService.queryGoodListByPage(ctlgArray, 1, 10, null, null, null);
        mav.addObject("goodList", goodList);

        mav.addObject("good_type", goodType); //能人id赋给页面,后面一路传下去至订单完成
        mav.addObject("user_id", user_id); //能人id赋给页面,后面一路传下去至订单完成
        return mav;
    }
    
    /**
     * 输入关键字搜索 ajax刷新商品选择列表 <br>
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/queryGoodListAjax")
    public ModelAndView queryGoodListAjax(@RequestBody GoodSelectQueryCon con){
        //返回数据表格子页面
        ModelAndView mav = null;
        String[] ctlgArray = null;
        if(Constants.GOOD_TYPE_PLAN.equals(con.getGoodType())){
            mav = new ModelAndView("goodSelectSub.ftl"); //新号入网套餐选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_XHRW_5, Constants.CTLG_CODE_XHRW_10};
        }
        else if(Constants.GOOD_TYPE_PHONE.equals(con.getGoodType())){
            mav = new ModelAndView("goodSelectSub.ftl"); //合约购机选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_HYGJ_4, Constants.CTLG_CODE_HYGJ_9};
        }
        else if(Constants.GOOD_TYPE_CARD.equals(con.getGoodType())){
            mav = new ModelAndView("goodSelectSub.ftl"); //上网卡选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_SWK_6, Constants.CTLG_CODE_SWK_11};
        }
        else if(Constants.GOOD_TYPE_FLOW.equals(con.getGoodType())){
            mav = new ModelAndView("flowGoodSelect.ftl"); //特色流量包选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_LLB_8, Constants.CTLG_CODE_LLB_13};
        }
        else if(Constants.GOOD_TYPE_BAND.equals(con.getGoodType())){
            mav = new ModelAndView("bandGoodSelect.ftl"); //宽带续约选择页面
            ctlgArray = new String[]{Constants.CTLG_CODE_KD_7, Constants.CTLG_CODE_KD_12};
        }
        else{
        }   
        
        //从数据库按分页查询，默认第一页,一页5个 注意参数转成了小写
        List<Map<Object, Object>> goodList = weShopService.queryGoodListByPage(ctlgArray, con.getPageNum(),
                con.getPageSize(), con.getKeyword().toLowerCase(), con.getSort(), con.getSortCol());
        mav.addObject("goodList", goodList);

        return mav;
    }

}