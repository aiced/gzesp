package com.ai.gzesp.controller;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dto.UserCheckReq_Req;
import com.ai.gzesp.dto.UserCheckReq_Res;
import com.ai.gzesp.service.BssBandService;
import com.ai.gzesp.service.UnionPayService2;
import com.ai.gzesp.service.WeShopService;
import com.ai.gzesp.utils.MD5Util;
import com.ai.sysframe.utils.StringUtil;


@Controller
@RequestMapping("/weShop")
public class BandAcctVerifyController {

    @Autowired
    private WeShopService weShopService;
    
    
    //没有直接使用weShopService是因为不想混淆了。到时候太乱
    @Autowired
	BssBandService bssBandService;
    
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
    public ModelAndView bandAcctCheck(@RequestBody String inputParam)
    {
    	ModelAndView mav=null;
    	String errorcontent = "";
		Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
		String user_id = paramsMap.get("user_id");	//能人id
		String bandAcct=paramsMap.get("bandAcct"); //宽带账号
    	
		//根据md5key对发送报文进行签名：签名的规则为：NumID=XXX $key=XXX进行MD5加密
		String strEncrypt="NumID="+bandAcct+"$key="+Constants.md5key_bbs;
		strEncrypt=MD5Util.md5s2(strEncrypt);
		
		//构造bss：校验用户接口报文
		String packet=bssBandService.ReqCheckUserPacket(bandAcct, strEncrypt);	
		System.out.println("BSS发送请求的报文："+packet);
		
    	String strUrl=Constants.BSS_SERVERURL;//未来需要填写的url
		HashMap<String, String> map = new HashMap<String, String>() ;
		map.put("xmlmsg", packet);
		System.out.println("IPaddress:"+strUrl);
		String strRet=bssBandService.HttpPost(strUrl,map);//bss返回结果
		
		if (strRet.isEmpty()) {
    		return mav=new ModelAndView("redirect:/weShop/goodSelect/band/"+user_id);  
		}
		//解析响应报文
		UserCheckReq_Res userCheckReq_Res=	bssBandService.ResCheckUserPacket(strRet,bandAcct);
		
		//将相关的数据添加到mav里面 展示到页面上
		if (userCheckReq_Res!=null) {
		
			int iRet=0;
			String curproinfo="";
			String proinfo="";
	    	strRet=bssBandService.CheckReqCode(userCheckReq_Res.getRespCode().toString());
	    	//判断报文返回的code
	    	if (!strRet.isEmpty()) {
				errorcontent=strRet;
				
		    	//插入bss报文请求日志表
				iRet=bssBandService.insertBSSLog(
						"宽带账号校验", 
						userCheckReq_Res.getRespCode()+userCheckReq_Res.getRespDesc(), 
						user_id, 
						bandAcct, 
						"", 
						"", 
						"",
						"",
						"",
						"",
						"",
						"", 
						"", 
						"", 
						"");
				
			}
	    	else {
				for (int i = 0; i < userCheckReq_Res.getCurrProductList().size(); i++) {
					curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getCurrProductCode();
					curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getCurrProductName();
					curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getCurrProductType();
					curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getProductActiveTime();
					curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getProductInActiveTime()+",";
				}
				//有的宽带账号比较特殊，只有自己当前的产品，通过cb返回的结果看到并没有可以办理的产品，且该账号在网厅上也不能办理。
				//所以这里直接判断是否存在可以办理的产品即可。后续操作不影响。但要注意前台展示的地方也要做适当的修改。edit_by_wenh_2015_12_14
				if(userCheckReq_Res.getProductList()!=null)
				{
					for (int i = 0; i < userCheckReq_Res.getProductList().size(); i++) {
						proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductCode();
						proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductFee();
						proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductName();
						proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductRate();
						proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductType();
						proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getDiscntReq().getDiscntType();
						proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getDiscntReq().getDiscntValue()+",";
					}
				}

		    	//插入bss报文请求日志表
				iRet=bssBandService.insertBSSLog(
						"宽带账号校验", 
						userCheckReq_Res.getRespCode()+userCheckReq_Res.getRespDesc(), 
						user_id, 
						bandAcct, 
						userCheckReq_Res.getCustName(), 
						userCheckReq_Res.getProvinceCode(), 
						userCheckReq_Res.getCityCode(),
						userCheckReq_Res.getNetType(),
						userCheckReq_Res.getPayType(),
						userCheckReq_Res.getUserStatus(),
						userCheckReq_Res.getUserType(),
						curproinfo, 
						proinfo, 
						"", 
						"");
				
				
			}

			if (iRet>0) //插入成功 
			{
	        	mav= new ModelAndView("bandGoodSelect.ftl");
	        	mav.addObject("errorcontent", errorcontent);
	        	mav.addObject("user_id", user_id); 	
	        	mav.addObject("bandAcct",bandAcct);
	        	mav.addObject("userCheckReq_Res", userCheckReq_Res);
	        	System.out.println(userCheckReq_Res.getCustName());
			}
			else //插入失败 
			{
		       	mav=new ModelAndView("redirect:/weShop/goodSelect/band/"+user_id);
			}	
		}
		else {
	       	mav=new ModelAndView("redirect:/weShop/goodSelect/band/"+user_id);    	
		}
        return mav;

		
//		
//		//将相关的数据添加到mav里面 展示到页面上
//		if (userCheckReq_Res!=null) {
//			
//			String curproinfo="";
//			for (int i = 0; i < userCheckReq_Res.getCurrProductList().size(); i++) {
//				curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getCurrProductCode();
//				curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getCurrProductName();
//				curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getCurrProductType();
//				curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getProductActiveTime();
//				curproinfo=curproinfo+userCheckReq_Res.getCurrProductList().get(i).getProductInActiveTime()+",";
//			}
//			
//			String proinfo="";
//			for (int i = 0; i < userCheckReq_Res.getProductList().size(); i++) {
//				proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductCode();
//				proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductFee();
//				proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductName();
//				proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductRate();
//				proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getProductType();
//				proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getDiscntReq().getDiscntType();
//				proinfo=proinfo+userCheckReq_Res.getProductList().get(i).getDiscntReq().getDiscntValue()+",";
//			}
//			
//			
//			//插入bss报文请求日志表
//			int iRet=bssBandService.insertBSSLog(
//					"宽带账号校验", 
//					userCheckReq_Res.getRespCode()+userCheckReq_Res.getRespDesc(), 
//					user_id, 
//					bandAcct, 
//					userCheckReq_Res.getCustName(), 
//					userCheckReq_Res.getProvinceCode(), 
//					userCheckReq_Res.getCityCode(),
//					userCheckReq_Res.getNetType(),
//					userCheckReq_Res.getPayType(),
//					userCheckReq_Res.getUserStatus(),
//					userCheckReq_Res.getUserType(),
//					curproinfo, 
//					proinfo, 
//					"", 
//					"");
//			
//			if (iRet>0) //插入成功 
//			{
//	        	mav= new ModelAndView("bandGoodSelect.ftl");
//				
//
//				
//	        	mav.addObject("user_id", user_id); 	
//	        	mav.addObject("bandAcct",bandAcct);
//	        	mav.addObject("userCheckReq_Res", userCheckReq_Res);
//	        	System.out.println(userCheckReq_Res.getCustName());
//			}
//			else //插入失败 
//			{
//		       	mav=new ModelAndView("redirect:/weShop/goodSelect/band/"+user_id);
//			}
//			
//		}
//		else {
//	       	mav=new ModelAndView("redirect:/weShop/goodSelect/band/"+user_id);    		
//		}
//        
//        return mav;
    }
}
