package com.ai.gzesp.controller;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import com.ai.gzesp.dao.beans.TdAurDBASEINFO;
import com.ai.gzesp.dao.beans.TdAurDRELINFO;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.dao.service.TdAurDBASEINFODao;
import com.ai.gzesp.dao.service.TdAurDRELINFODao;
import com.ai.gzesp.service.WeShopService;
import com.ai.gzesp.utils.MD5Util;
import com.ai.sysframe.token.Token;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/auth")
public class WeShopRegist3Controller {

	@Autowired
    private WeShopService weShopService;
	
    @Resource 
    TdAurDAUTHINFODao tdAurDAUTHINFODao;
    
    @Resource 
    TdAurDRELINFODao tdAurDRELINFODao;
	
    @Resource
    TdAurDBASEINFODao tdAurDBASEINFODao;
	
    Long LGId=0L;
	
	
	@RequestMapping("/register/step3")
    public ModelAndView index(@RequestParam(value = "userid", required = false)String strUserID,@RequestParam(value = "ispostback", required = false)String strIsPostBack){
        ModelAndView mav = new ModelAndView("weShopRegist3.ftl");
        //从数据库获取信息赋值
        mav.addObject("title", "注册微店");
        mav.addObject("userid",strUserID);
        mav.addObject("ispostback",strIsPostBack);
        System.out.println("ispostback="+strIsPostBack);
        return mav;
    }

    @RequestMapping("/register/reg_step3_postdata")
    public ModelAndView RegStep3_PostData(@RequestBody String inputParams)
    {
    	///插入数据需要用事务来处理：因为涉及到多表插入
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParams);
    	ModelAndView mav = null;
    	ModelMap mmap=new ModelMap();

    	String strPhoneNum = paramsMap.get("txtphonenum");//手机号
    	
	   	 if (!checkPhoneNum(strPhoneNum)) //已经注册过了
	   	 {
	   			mmap.addAttribute("userid",LGId.toString());
	   			mmap.addAttribute("ispostback","1");//判断是否重复提交注册
	   			mav=new ModelAndView("redirect:step3",mmap);     
	   	    	return mav; 
	   	 }
    	Long LId=getID();
    	LGId=LId;
    	System.out.println("LId="+LId);    	
    	String strArea=paramsMap.get("selArea");//地区

    	String strwecharaccount=paramsMap.get("wecharaccount");//微信号
    	String strName=paramsMap.get("name");//姓名
    	String strSex=paramsMap.get("sex");//性别
    	String strPersonalId=paramsMap.get("personalId");//身份证号
    	String strDefalutImg="/uploader/headimages/touxiang_default.png";
    	String strOpenid=paramsMap.get("txtopenid");
    	String strPwd=MD5Util.md5s2(paramsMap.get("txtpassword"));
    	
    	
    	System.out.println("打印的数据");
    	System.out.println(strArea);
    	System.out.println(strPhoneNum);
    	System.out.println(strwecharaccount);
    	System.out.println(strName);
    	System.out.println(strSex);
    	System.out.println(strPersonalId);
    	System.out.println(strOpenid);
    	System.out.println(strPwd);
    	
    	
    	

    	
    	//插入能人登录信息表
    	TdAurDAUTHINFO record_aurdauthinfo = new TdAurDAUTHINFO();
    	record_aurdauthinfo.setId(LId);//ID
    	record_aurdauthinfo.setUserId(LId.toString());//USER_ID用户名
    	record_aurdauthinfo.setUserName(strName);//USER_NAME
    	record_aurdauthinfo.setUserPassword(strPwd);//USER_PASSWORD
    	record_aurdauthinfo.setWeixinId(strwecharaccount); //WEIXIN_ID
    	record_aurdauthinfo.setPhoneNumber(strPhoneNum);//PHONE_NUMBER
    	record_aurdauthinfo.setStatus("00");//STATUS
    	record_aurdauthinfo.setStoreId(LId.toString());//STORE_ID
    	record_aurdauthinfo.setStoreName(strName+"的店铺");//STORE_NAME
    	record_aurdauthinfo.setUserImg(strDefalutImg);
    	record_aurdauthinfo.setWxopenId(strOpenid);
    	//record.setCreateTime(DateUtil.getNow());
    	tdAurDAUTHINFODao.insertSelective(record_aurdauthinfo);
    	
    	//插入能人关系信息表
    	TdAurDRELINFO record_aurdrelinfo=new TdAurDRELINFO();
    	record_aurdrelinfo.setId(LId);//ID
    	record_aurdrelinfo.setUserId(LId.toString());//USER_ID用户名
    	record_aurdrelinfo.setDevlopId("100");//DEVLOP_ID
    	record_aurdrelinfo.setDevlopName("100");//DEVLOP_NAME
    	tdAurDRELINFODao.insertSelective(record_aurdrelinfo);
    	
    	//插入能人基础信息表
    	TdAurDBASEINFO record_aurdbaseinfo=new TdAurDBASEINFO();
    	record_aurdbaseinfo.setId(LId);//ID
    	record_aurdbaseinfo.setUserId(LId.toString());//USER_ID
    	record_aurdbaseinfo.setUserName(strName);//USER_NAME
    	record_aurdbaseinfo.setChannelType("05");//CHANNEL_TYPE
    	record_aurdbaseinfo.setChannelLevel("00");//CHANNEL_LEVEL
    	record_aurdbaseinfo.setProvinceCode("85");
    	record_aurdbaseinfo.setEparchyCode(strArea);
    	//record_aurdbaseinfo.setSalesArea(strArea);//SALES_AREA
    	record_aurdbaseinfo.setCreateDate(DateUtil.getNow());//CREATE_DATE
    	record_aurdbaseinfo.setStatus("00");//STATUS
    	record_aurdbaseinfo.setIdentityType("00");//IDENTITY_TYPE
    	record_aurdbaseinfo.setIdentityNum(strPersonalId);//IDENTITY_NUM
    	record_aurdbaseinfo.setMobile(strPhoneNum);//MOBILE
    	//record_aurdbaseinfo.setBankName(strBank);//BANK_NAME
    	//record_aurdbaseinfo.setBankAcct(strBankCardId);//BANK_ACCT
    	tdAurDBASEINFODao.insertSelective(record_aurdbaseinfo);
    	
		mmap.addAttribute("userid",LId.toString());
		mav=new ModelAndView("redirect:/shopManage/weShopHome",mmap);     
    	return mav;
    	
    } 
    //生成id
    //当前时间+2位随机码
    private Long getID()
    {
        Date date = new Date(); 
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); 
        //产生2位随机验证码
        String strCode="";
        for (int i = 0; i < 2; i++) {  
        	 
        	strCode += Integer.parseInt(new DecimalFormat("0").format(Math.random() * 9));  
        }
       //14位的时间+2位随机验证码，四舍五入之后转换成double并返回
        strCode=df.format(date)+strCode;
        System.out.println(strCode);
        Long lCode=Long.parseLong(strCode);
        return lCode;

    }
    //edit_by_wenh_2015_5_21
	public Boolean checkPhoneNum( String strPhoneNum) {
		Criteria myCriteria = new Criteria();
		myCriteria.createConditon().andEqualTo("PHONE_NUMBER", strPhoneNum);
		int count = tdAurDAUTHINFODao.countByExample(myCriteria);
		System.out.println(count);
		if (count >= 1) {
			return false; // 该账户已经注册了

		} else {
			return true;// 没有注册过
		}
	}
	
}
