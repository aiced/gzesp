package com.ai.gzesp.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPCITY;
import com.ai.gzesp.dao.service.TdAurDAUTHINFODao;
import com.ai.gzesp.dao.service.TdOrdDREFUNDDao;
import com.ai.gzesp.dao.service.TdSysPCITYDao;
import com.ai.gzesp.utils.SmsUtils;
import com.ai.sysframe.exception.ReturnCode;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.PathUtil;
import com.ai.sysframe.utils.StringUtil;
import com.alibaba.fastjson.JSON;

@Controller
public class CommonController {
    
    @Resource
    TdAurDAUTHINFODao tdAurDAUTHINFODao;
    @Resource
    TdOrdDREFUNDDao tdOrdDREFUNDDao;
    
	//@Resource 
	//SgipService sgipService;
	 protected Logger logger = LoggerFactory.getLogger(getClass());
	 
	 @Resource
	 private TdSysPCITYDao tdSysPCITYDao;
	 public List<TdSysPCITY> getCityList() {
		 
		 Criteria example = new Criteria();
		 example.createConditon().andEqualTo("PROVINCE_CODE", "85");
		 List<TdSysPCITY> list = tdSysPCITYDao.selectByExample(example);
		 return list;
	 }
	 
//  @RequestMapping(value="uploadFile")
  @RequestMapping(value="/common/uploadFile",method = RequestMethod.POST)
  public void uploadFile(
  		@RequestParam(value = "idCardNum", required = true)String idCardNum, 
  		@RequestParam(value = "uploadFile", required = true)MultipartFile[] imgFiles, 
  		HttpServletRequest request,HttpServletResponse response) throws IOException {
  	
      Map<String, Object> resultMap = new HashMap<String, Object>();
      List fileInfoList = new ArrayList();
      for(MultipartFile imgFile : imgFiles) {
	      //判断上传文件是否为空
	      if (imgFile == null || imgFile.getOriginalFilename() == null || "".equals(imgFile.getOriginalFilename())) {
	    	  resultMap.put("rspCode", "9999");
	    	  resultMap.put("message","error");
	          String text = JSON.toJSONString(resultMap);
	          response.getWriter().write(text);
	          return;
	      }
	    
	      //上传原文件名
	      String imgFileName = imgFile.getOriginalFilename();
	      String size = imgFile.getSize()/1024+"KB";
	      
	      // 上传地址
	//      String upToPath = PathUtil.getFileUploadPath("FILE",request.getParameter("uploadType"));
	//      String appWebPath = upToPath.substring(upToPath.indexOf(PathUtil.WEB_TYPE));
	      
	      String upToPath = PathUtil.WEB_ROOT_PARENT_PATH 
	    		  + "uploadfile/"
	    		  + PathUtil.WEB_UPLOAD_PATH 
	    		  + DateUtil.getCurrentYearMonth()
	    		  + File.separator
	    		  + idCardNum 
	    		  + File.separator;
	      
	      logger.debug("upToPath"+upToPath);
	      
	      File upFile= new File(upToPath);
	      
	      if (!upFile.exists()) {
	          upFile.mkdirs();
			}

			Random r = new Random();
			int rint = r.nextInt(99);
			String rStr = StringUtil.paddingLeft(String.valueOf(rint), '0', 2);
 	
	//      String fileName = new SimpleDateFormat("HHmmssSSS").format(new Date())+ imgFileName.substring(imgFileName.lastIndexOf("."), imgFileName.length() );
	      String fileName = DateUtil.now().getTime() + rStr + imgFileName.substring(imgFileName.lastIndexOf("."), imgFileName.length());
	      //拷贝文件
	      FileCopyUtils.copy(imgFile.getBytes(), new File(upToPath + fileName));
	
	      //url路径
	//      String basePath = appWebPath + fileName;
	      Map fileInfo = new HashMap();
	      fileInfo.put("url", File.separator + PathUtil.WEB_UPLOAD_PATH  + DateUtil.getCurrentYearMonth()  + File.separator+ idCardNum + File.separator + fileName);
	      fileInfo.put("size", size);
	      fileInfo.put("originalFilename", imgFileName);
	      fileInfoList.add(fileInfo);
      }
      resultMap.put("rspCode", "0000");
      resultMap.put("rspDesc", "success");
      resultMap.put("fileInfoList", fileInfoList);
     

      String text = JSON.toJSONString(resultMap);
      response.setContentType("text/html");
      response.getWriter().write(text);
  }
  
//  @RequestMapping(value="${adminPath}/queryResourceFromDBPost", method=RequestMethod.POST)
//  public void queryResourceFromDBPost(
//  		@RequestBody Map<String, Object> inputParam,
//  		HttpServletResponse response) throws IOException {
//  	String resId = (String) inputParam.get("resourceId");
//      TCarResource record = tCarResourceDao.selectByPrimaryKey(Integer.parseInt(resId));
//     
//      byte[] date = record.getData();
//      response.getOutputStream().write(date);
//  }
//  
//  @RequestMapping(value="${adminPath}/queryResourceFromDBGet", method=RequestMethod.GET)
//  public void queryResourceFromDBGet(
//  		@RequestParam(value = "phoneNum", required = false)String phoneNum,
//  		@RequestParam(value = "resourceId", required = true)String resourceId,
//  		HttpServletResponse response) throws IOException {
//      TCarResource record = tCarResourceDao.selectByPrimaryKey(Integer.parseInt(resourceId));
//     
////      response.setContentType("text/html");
//      byte[] date = record.getData();
//      response.getOutputStream().write(date);
//  }

  
  
 //edit_by_wenh_2015_3_27
	@RequestMapping("/common/checkPhoneNum")
	@ResponseBody
	public Boolean checkPhoneNum(@RequestBody String strPhoneNum) {
		Map<String, String> paramsMap = StringUtil.params2Map(strPhoneNum);
		String PhoneNum = paramsMap.get("PhoneNum");
		System.out.println(PhoneNum);
		Criteria myCriteria = new Criteria();
		myCriteria.createConditon().andEqualTo("PHONE_NUMBER", PhoneNum);
		int count = tdAurDAUTHINFODao.countByExample(myCriteria);
		System.out.println(count);
		if (count >= 1) {
			return false; // 该账户已经注册了

		} else {
			return true;// 没有注册过
		}
	}
	@RequestMapping("/common/checkWeChat")
	@ResponseBody
	public Boolean checkWeChat(@RequestBody String strWeChat)
	{
		Map<String, String> paramsMap = StringUtil.params2Map(strWeChat);
		String WeChat = paramsMap.get("WeChat");
		System.out.println(WeChat);
		Criteria myCriteria = new Criteria();
		myCriteria.createConditon().andEqualTo("WEIXIN_ID", WeChat);
		int count = tdAurDAUTHINFODao.countByExample(myCriteria);
		System.out.println("微信的个数："+count);
		if(count >= 1) {
			return false; //该账户已经注册了
	        
		} else {
			return true;//没有注册过
		}
	} 
	
	//edit_by_wenh_2015_4_9	
    @RequestMapping("/common/checkBankCard")
    @ResponseBody
    public Boolean checkBankCard(@RequestBody String strBankCard)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strBankCard);
    	String BankCard = paramsMap.get("BankCard");
    	return CommonUtil.checkBankCard(BankCard);
    }
    //edit_by_wenh_2015_4_10
    @RequestMapping("/common/yanzhengma")
    @ResponseBody
    public Boolean sendYanzhenma(@RequestBody String strParam)
    {
    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
    	String strphone = paramsMap.get("phone");
    	String strcode=paramsMap.get("code");
    	String strFlag=paramsMap.get("flag");
    	
    	//新版
    	System.out.println("短信验证码："+strcode);
    	String strRet="";
    	
    	if (strFlag.equals("0"))//注册模板
    	{
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2013102300","@1@="+strcode);//
		}
    	else if(strFlag.equals("1")) //支付模板
    	{
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2015051550","@1@="+strcode);//
    	}
    	else if(strFlag.equals("2"))//支付完成短信通知
    	{
    		String order_name=paramsMap.get("order_name");
    		
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2015052754","@1@="+order_name);
    	}
    	else if(strFlag.equals("3"))//退款申请短信通知
    	{
    		String order_id=paramsMap.get("order_id");
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2015052703","@1@="+order_id);
    	}
    	else if(strFlag.equals("4"))//您修改微店登录密码的验证码是：@1@，请在30分钟内完成验证。
    	{
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2015060623","@1@="+strcode);
    	}
    	else if(strFlag.equals("5"))//您正在设置账户安全码，验证码：@1@，请在30分钟内完成验证。
    	{
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2015070602","@1@="+strcode);
    	}
    	else if(strFlag.equals("6"))//您正在修改账户安全码，验证码：@1@，请在30分钟内完成验证。
    	{
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2015070640","@1@="+strcode);
    	}
    	else if(strFlag.equals("7"))//您正在绑定账户银行卡，验证码：@1@，请在30分钟内完成验证。
    	{
    		strRet=SmsUtils.doSendMessage(strphone,"MB-2015070629","@1@="+strcode);
    	}
    	
		 System.out.println("短信返回值："+strRet);
		 if (strRet != null && strRet.split("#").length==3)
		 {
			 return true; //发送成功 值:0#1#1
		 }
		 else {
	    	 return false;
		 }
    	 

    	//旧版
//    	Map<String, String> paramsMap = StringUtil.params2Map(strParam);
//    	String strphone = "86"+paramsMap.get("phone");
//    	String strcode=paramsMap.get("code");
//    	return sgipService.smsSend(new String[]{strphone},"微店注册验证码："+strcode+"，祝您开店顺利！【贵州联通】。");
    	
    
    	
    }
	//edit_by_wenh_2015_4_19
	@RequestMapping("/common/checkRefundOrderId")
	@ResponseBody
	public Boolean checkRefundOrderId(@RequestBody String strParam) {
		Map<String, String> paramsMap = StringUtil.params2Map(strParam);
		String PhoneNum = paramsMap.get("orderid");
		System.out.println(PhoneNum);
		Criteria myCriteria = new Criteria();
		myCriteria.createConditon().andEqualTo("ORDER_ID", PhoneNum);
		int count = tdOrdDREFUNDDao.countByExample(myCriteria);
		System.out.println(count);
		if (count >= 1) {
			return false; //已经申请过退过款了
		} else {
			return true;// 没有申请退款
		}
	}
    
    
	@RequestMapping("/error")
	@ResponseBody
	public ModelAndView error(HttpServletRequest request, 
			@RequestParam(value="code") String errorCode, @RequestParam(value="userId") String userId)	{
		String msg = "";
		String action = "";
		
		if(ReturnCode.SERVER_RUN_ERR.equals(errorCode)) {
			msg = "赶快联系管理员大哥吧。。";
		} else if(ReturnCode.REPEAT_SUBMIT.equals(errorCode)) {
			msg = "放心！已经操作成功了，再逛逛吧。。";
		} else if(ReturnCode.NOT_LOGIN.equals(errorCode)) {
			msg = "赶快登录去吧。。";
		} else {
			msg = "赶快联系管理员大哥吧。。";
		}
		
		action = "location.href = \'./weShop/index/"+userId+"\'";
		
		ModelAndView mav = new ModelAndView("error.ftl");
		mav.addObject("userId", userId);
		mav.addObject("msg", msg);
		mav.addObject("action", action);
		return mav;
	} 
	
	//短信接口改造：方便后台调用
    @RequestMapping("/common/sendmessage/{phonenum}/{ischeck}")
    @ResponseBody
    public String sendMessage(@PathVariable("phonenum") String phonenum, @PathVariable("ischeck") String ischeck)
    {
    	System.out.println("发送短信_电话："+phonenum);
    	System.out.println("发送短信_标志"+ischeck);
    	//ischeck 是否通过审核 审核通过传1 审核未通过传2
    	String strRet="";//返回值
    	if (ischeck.equals("1")) //审核已经通过
    	{
    		strRet=SmsUtils.doSendMessage(phonenum,"MB-2015052732","");
		}
    	else if(ischeck.equals("2")) //审核未通过
    	{
        	strRet=SmsUtils.doSendMessage(phonenum,"MB-2015052713","");
		}

		System.out.println("短信返回值："+strRet);
		if (strRet != null && strRet.split("#").length==3)
		{
			return "发送成功"; //发送成功 值:0#1#1
		}
		else {
	    	return "发送失败";
		}

    }
	
}
