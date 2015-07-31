package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.WeShopService;
import com.ai.gzesp.utils.HttpUtils;
import com.ai.sysframe.utils.StringUtil;
import com.ai.wx.util.HttpClientUtil;

@Controller
@RequestMapping("/weShop")
public class BandAcctVerifyController {

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
    @RequestMapping("/bandAcctVerify")
    public ModelAndView bandAcctVerify(){
        ModelAndView mav = new ModelAndView("bandAcctVerify.ftl");
        //从数据库获取信息赋值
        //广告轮播图片的url
        List<String> banners = new ArrayList<String>();
        banners.add("banner_iphone6.png");
        banners.add("banner_honer_x1.png");
        mav.addObject("banners", banners);

        return mav;
    }
    
    //
    @RequestMapping("/bandAcctCheck")
    @ResponseBody
    public String bandAcctCheck(@RequestBody String inputParam)
    {

//    	Province	UserCheckReq	1	String	F2	省分
//    	City	UserCheckReq	1	String	F3	地市
//    	District	UserCheckReq	1	String	V10	区县
//    	ChannelID	UserCheckReq	1	String	V20	渠道编码
//    	NumID	UserCheckReq	1	String	V20	服务号码
    	
    	//渠道编号：是固定写死的，是之前就商量好的。
    	//省份：贵州 ，地市 和区县其实可以根据服务号码来去判断（有类似025 南京这种的区号）
    	
    	
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String user_id = paramsMap.get("user_id");
		String bandAcct=paramsMap.get("bandAcct");
    	
    	
    	String strUrl="";//未来需要填写的url
    	Map<String, Object> map=new HashMap<String, Object>();
    	map.put("Province", "");
    	map.put("City", "");
    	map.put("District", "");
    	map.put("ChannelID", "");
    	map.put("NumID", bandAcct);
    	
    	//先注释掉
//    	try {
//			HttpUtils.URLPost(strUrl, map);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return "未知错误";
//		}
    	//这里调用bss接口
    	return "0000";
    }
}
