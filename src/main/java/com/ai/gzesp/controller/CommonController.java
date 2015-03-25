package com.ai.gzesp.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPCITY;
import com.ai.gzesp.dao.service.TdSysPCITYDao;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.PathUtil;
import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/common")
public class CommonController {
    
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
  @RequestMapping(value="/uploadFile",method = RequestMethod.POST)
  public void uploadFile(
  		@RequestParam(value = "idCardNum", required = true)String idCardNum, 
  		@RequestParam(value = "uploadFile", required = true)MultipartFile imgFile, 
  		HttpServletRequest request,HttpServletResponse response) throws IOException {
  	
      Map<String, Object> map = new HashMap<String, Object>();
      //判断上传文件是否为空
      if (imgFile == null || imgFile.getOriginalFilename() == null || "".equals(imgFile.getOriginalFilename())) {
          map.put("rspCode", "9999");
          map.put("message","error");
          String text = JSON.toJSONString(map);
          response.getWriter().write(text);
          return;
      }
    
      //上传原文件名
      String imgFileName = imgFile.getOriginalFilename();
      String size = imgFile.getSize()/1024+"KB";
      
      // 上传地址
//      String upToPath = PathUtil.getFileUploadPath("FILE",request.getParameter("uploadType"));
//      String appWebPath = upToPath.substring(upToPath.indexOf(PathUtil.WEB_TYPE));
      
      String upToPath = PathUtil.WEB_ROOT_PATH + PathUtil.WEB_UPLOAD_PATH + idCardNum + File.separator;
      
      logger.debug("upToPath"+upToPath);
      
      File upFile= new File(upToPath);
      
      if (!upFile.exists()) {
          upFile.mkdirs();
      }
//      String fileName = new SimpleDateFormat("HHmmssSSS").format(new Date())+ imgFileName.substring(imgFileName.lastIndexOf("."), imgFileName.length() );
      String fileName = DateUtil.now().getTime() + imgFileName.substring(imgFileName.lastIndexOf("."), imgFileName.length());
      //拷贝文件
      FileCopyUtils.copy(imgFile.getBytes(), new File(upToPath + fileName));

      //url路径
//      String basePath = appWebPath + fileName;

      map.put("rspCode", "0000");
      map.put("rspDesc", "success");
      map.put("url", File.separator + PathUtil.WEB_UPLOAD_PATH + idCardNum + File.separator + fileName);
      map.put("size", size);
      map.put("originalFilename", imgFileName);

      String text = JSON.toJSONString(map);
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

}
