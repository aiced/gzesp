<!DOCTYPE html>
<html lang="zh-cn">
  
 <style type="text/css">	 
 	 * {margin:0;padding:0;} 
	html,body{
 		background-color:#E8E9E8; 
	}
	 html, body , p {
	  margin:0; 
	  padding:0; 
   	  list-style:none;
	 }
	
	.img-w {
	    position: relative;
	    overflow: hidden;
	    width: 100%;
	    padding: 20px;
	    margin-bottom: 15px;
	    background-color: #F0F0F0;
	    text-align: center;
	}
	.file-input {
	    opacity: 0;
	    width: 100%;
	    height: 100%;
	    position: absolute;
	    bottom: 0px;
	    left: 0px;
	    z-index: 999;
	}
  	    
</style>

  <body >
<!--标题   -->
   	<div id="top">
       	<div id="netInfoBackBtn"><div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div></div>
       	<div id="top_middle">${title}</div>
       	<div id="top_right"></div>
    </div>
	<div id="dv_clear"></div>
    <!-- 主机号，身份证号 -->
     <div class="container">
      		<br/>
      		 <input id = "userName" type="text" placeholder="机主姓名"  class="form-control" required>
			 <br/>
			 <input id = "userCard" type="text" placeholder="身份证号" class="form-control" required>
			  <br/>
     </div> 
      
     
     <div class="container">
     <!--上传文字  -->
     	<div style="height:70px;" >
     			<div style="background-color:#5B5B5B; float:left;width:5px;height:12px;margin-top:8px;margin-left:8px;">
     			</div>
     			 <p style="color:#5B5B5B;float:left;margin-top:8px;margin-left:8px;width:100px;height:12px ;line-height:12px;font-size:14px;"> 证件照片 </p> 	
     			<div style="color:#818181; float:left;width:100%;height:15px;margin-top:8px;margin-bottom:8px;text-align:center;font-size:9px;">
     				请上传身份证正、反两面照片，头像要求、照片、姓名、地址文字、头像清晰     				
     			</div>     		
     	</div>
      <!--上传图片  -->
       
<!--        <div id="picsHolder"> -->
<!-- 			       <img id="viewImg" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABIAAAAfCAYAAADqUJ2JAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDE0IDc5LjE1Njc5NywgMjAxNC8wOC8yMC0wOTo1MzowMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTQgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkE3MkQ2NDI0QkU1RDExRTQ5QzBFOUI4QTc4RDQ5Q0UxIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkE3MkQ2NDI1QkU1RDExRTQ5QzBFOUI4QTc4RDQ5Q0UxIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QTcyRDY0MjJCRTVEMTFFNDlDMEU5QjhBNzhENDlDRTEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QTcyRDY0MjNCRTVEMTFFNDlDMEU5QjhBNzhENDlDRTEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5aNbEVAAABoklEQVR42pyVzytEURTH3zxDSPZ2zL9hMSTR5FcyouwICSGj+QcskEhCfpdYKIQw6kUWVhY2FjbvWYhSSkpvsPK903k1nW65Z7716TWn1+e9ue+ec0Ou69ZZlrUJ8sEo2LUEiUQimWsYbIEyqu+AIrBuCWOz3yGwCnpzEfWDXyZbobpIdALiGtmSRBb8NSVrBmmNbEC6RinQBHwmWwSD0sV2QAx8MdkCGJaIVG5APfhksnkwIhGp3IJa8MFkc2BMIlK5AzXgndVndTL7nzW8B9XgTSMbl4hUHkAVeGX1GTAhEak8gih4ZvUpz/OSmQVE90s6oQJcgXJWT9rC3nwCCU1dLKoEG6ymerRHIopSG5UySSeG24GpSG3Oc1DCJB2QHJp+tRhNh2ImaQdHpp+/hW4uZJI2cGy6IdUT90EBk7SCU9MW6QJ7dLIE+aE3PDNt2m6wDfI0kgvTMdIH1pjkmyQp08E2BJZp7gRJm0iyRQkap9kSnySXJhstTG8yzeo+nSqO6bZXokmNpJG6XHRAvjBJg1QSiOLUAg6N1Wsrh/wJMABVKF1HcKrwSAAAAABJRU5ErkJggg==" style="max-width:500px"/> -->
<!--        </div> -->
      <div style="padding:5px" >
      			<div class="img-w">
	     		     <img id ="firstCard" src="${resRoot}/image/order/card01.png" style="display:block;width:175px;height:110px;margin:0px auto;">
	     		     <input  class="file-input select-file" type="file" id="file-front" name="uploadFile" accept="image/*"/>     			
     			  </div>
     			     
     			 <div class="img-w"> 
     	        	 <img id ="secondCard" src="${resRoot}/image/order/card02.png" style="display:block;width:175px;height:110px;margin:0px auto;" />
     	         	<input class="file-input select-file" type="file" id="file-back" name="uploadFile" accept="image/*"/>
       		 	</div>
<!--        		     <button id="netInfoBtn" class="btn btn-warning btn-block " type="submit" >同意协议并确定</button> -->
       		     <button id="netInfoBtn" class="btn btn-warning btn-block " type="submit" >上传证件照</button>
    	</div>
     	
     </div>
    
  </body>
</html>