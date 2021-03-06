package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.UserService;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.token.Instead;

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
    
	@Autowired
	private UserService userService;
    
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
    public ModelAndView index(HttpServletRequest request, @PathVariable("user_id") String user_id){
    	
    	//获取该店铺属于哪个集团，不同集团可以展示的商品不一样
    	//正常登录/checklogin 里登录成功会设置session，
    	Subject subject = SecurityUtils.getSubject();
		org.apache.shiro.session.Session session = subject.getSession(true);
//    	//测试发现subject.getSession(true);会每次新建session，这边保存了，下一个request又没有了
//    	HttpSession session = request.getSession(true);
		String mchId = (String)session.getAttribute("mchId");
		//如果不是正常登录进来的，比如游客进来的，mchId是空，这边也会补充设置下
		if(StringUtils.isBlank(mchId)){
			Map<String, String> mchInfo = userService.getMchId(user_id); 
			//不是所有店铺都有商户号
			if(MapUtils.isNotEmpty(mchInfo)){
				mchId = mchInfo.get("MCH_ID");
				session.setAttribute("mchId", mchId); //前面session里没赋值的话，这边赋值
			}
		}
		 
        ModelAndView mav = new ModelAndView("weShopIndex.ftl");
        //根据shopId获取 能人信息 店铺名称 手机 微信
        Map<Object, Object> developer = weShopService.getDevloperInfo(user_id);
        mav.addObject("developer", developer);
        
        //获取广告轮播图片的url
        List<Map<String, String>> banners = weShopService.getBanners();
        mav.addObject("banners", banners);
        
        //获取店长推荐 热销前4的商品 
        List<Map<Object, Object>> dztj = weShopService.getDztj(user_id, mchId);
        mav.addObject("dztj", dztj);
        
        //获取热销合约商品
        List<Map<Object, Object>> rxhy = weShopService.getRxhy(mchId);
        mav.addObject("rxhy", rxhy);
        
        //获取热销套餐商品
        List<Map<Object, Object>> rxtc = weShopService.getRxtc(mchId);
        mav.addObject("rxtc", rxtc);
        
        
        
        //获取热销网卡商品
        List<Map<Object, Object>> rxwk = weShopService.getRxwk(mchId);
        mav.addObject("rxwk", rxwk);
        
        //edit_by_wenh_2015_4_18
        weShopService.insertVisitLog(user_id);
        
        
        
        mav.addObject("user_id", user_id); //能人id赋给页面,后面一路传下去至订单完成
        
		// keep userid in session --add by leoxu --2015/5/6
		request.getSession(true).setAttribute("userId", user_id);
		
        return mav;
    }

    /**
     * 店铺管理页面 -> 代客下单
     * 这边用注解+拦截器的形式往session里存一个instead属性值，
     * 最后提交订单的时候判断是否有此值，从而区分是代客下单还是普通用户
     * @param request
     * @param user_id
     * @return
     */
    @Instead
    @RequestMapping("/insteadBuy/{user_id}")
    public ModelAndView insteadBuy(HttpServletRequest request, @PathVariable("user_id") String user_id){
        //直接session存值也是可以的
    	//request.getSession(false).setAttribute("instead", user_id);
		      
    	//session存值后直接跳转到店铺首页
		String url = "redirect:/weShop/index/" + user_id;
    	ModelAndView mav = new ModelAndView(url);
    	
        return mav;
    }
  
}
