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
	    padding: 15px 0px;
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
	    z-index: 2;
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
       
      <div style="padding:5px" >
      			<div class="img-w">
	     		     <img id ="firstCard" src="${resRoot}/image/order/card01.png" style="display:block;width:175px;height:110px;margin:0px auto;">
	     		     <input class="file-input select-file" type="file" id="file-front" name="uploadFile" accept="image/*"/>     			
	     			  <div style="width:100%;height:15px" >	</div>
     			  </div>
     			     
     			 <div class="img-w"> 
     	        	 <img id ="secondCard" src="${resRoot}/image/order/card02.png" style="display:block;width:175px;height:110px;margin:0px auto;">
     	         	<input class="file-input select-file" type="file" id="file-back" name="uploadFile" accept="image/*"/>
       		 		  <div style="width:100%;height:40px" >	</div>
       		 	</div>
       		     <button id="netInfoBtn" class="btn btn-warning btn-block " type="submit" >同意协议并确定</button>
    	</div>
     	
     </div>
    
  </body>
</html>