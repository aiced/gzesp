package com.ai.wx.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.PathUtil;
import com.ai.sysframe.utils.StringUtil;
import com.ai.wx.util.HttpClientUtil;
import com.alibaba.fastjson.JSON;


/**
 * 自定义菜单功能 服务类<br> 
 * 〈功能详细描述〉
 *
 * @author 14040909
 */
@Service
public class MaterialService {
    
    private static Logger log = LoggerFactory.getLogger(MaterialService.class);
    
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
    	      
    	      log.debug("upToPath"+upToPath);
    	      
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
    
   /**
    * 
    * 1、对于临时素材，每个素材（media_id）会在开发者上传或粉丝发送到微信服务器3天后自动删除（所以用户发送给开发者的素材，若开发者需要，应尽快下载到本地），以节省服务器资源。
2、media_id是可复用的。
3、素材的格式大小等要求与公众平台官网一致。具体是，图片大小不超过2M，支持bmp/png/jpeg/jpg/gif格式，语音大小不超过5M，长度不超过60秒，支持mp3/wma/wav/amr格式
4、需使用https调用本接口。
    * http请求方式: POST/FORM,需使用https
https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE
调用示例（使用curl命令，用FORM表单方式上传一个多媒体文件）：
curl -F media=@test.jpg "https://api.weixin.qq.com/cgi-bin/media/upload?access_token=ACCESS_TOKEN&type=TYPE"
    */
//    public String addTempM(String accessToken) {
//    	log.error("发送客服消息");
//        if (StringUtils.isEmpty(accessToken) || StringUtils.isEmpty(jsonMsg) ) {
//            log.error("accessToken ||jsonMsg 为空");
//            return ""; 
//        }
//        
//        // 拼装 获取 access_token的 https的url
//        StringBuilder url = new StringBuilder();
//        url.append("https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=");
//        url.append(accessToken);
//        //获取返回的 json，并转换成bean
//        String respJson = HttpClientUtil.sendPostRequestByJava(url.toString(), jsonMsg);
////        ErrorCode resultModel = null;
//        if(StringUtils.isNotBlank(respJson)){
//            log.debug("客服 sendMsg 返回json：" + respJson);
////            resultModel = JsonUtils.parseJson(respJson, ErrorCode.class);
//        } else {
//            log.error("客服消息失败");
//        }
//
//        return respJson;
//    }
    
//    public String addTempM(String accessToken) {
//    	ByteArrayBody byteArrayBody = new ByteArrayBody(data, "application/json", "some.json");
//    	MultipartEntity multipartEntity = new MultipartEntity();
//    	multipartEntity.addPart("upload", byteArrayBody);
//    }
    
}
