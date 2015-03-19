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
    <div style="background-color:#1D2427; width:100%;height:44px;margin-left:0px;margin-bottom:0px;" >   	
     	<a id="netInfoBackBtn" style="color:#fff;width:60px;height:44px ;line-height:44px; float:left;display: block;text-align:center;margin-left:1px"> 返回 </a>	
    	<a style="color:#fff;width:40px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:10px;margin-top:12px;border:1px solid #fff"> 编辑 </a>	
    	<p style="color:#fff;width:60px;height:44px ;line-height:44px;margin:auto;"> 店铺设置 </p> 	
    </div>
    <!-- 主机号，身份证号 -->
    <div style="background-color:white;height:110px;padding-top:25px;text-align:center;">
      	 	 <div  style ="width:100%;height:25px;font-size:14px;">
      		      		 <input id = "userName" type="text" placeholder="主机姓名" style ="width:175px;height:25px;line-height:25px;padding-left:5px;border:1px solid #A6A6A6;border-radius:2px;font-size:10px;margin:0px auto;pading-left:5px">
      		 </div> 
      		 <div  style ="width:100%;height:25px;font-size:14px;margin-top:10px;">
   						 <input id = "userCard" type="text" placeholder="身份证号" style ="width:175px;height:25px;line-height:25px;padding-left:5px;margin-top:10px;border:1px solid #A6A6A6;font-size:10px;margin:auto;">
      		 </div> 
     </div> 
      
     
     <div style="background-color:#EBEBEB;height:410px;">
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
       
      <div style="width:100%;height:250px;text-align:center;" >
      			<div class="img-w">
	     		     <img id ="firstCard" src="${resRoot}/image/order/card01.png" style="display:block;width:175px;height:110px;margin:0px auto;">
	     		     <input class="file-input select-file" type="file" id="file-font" name="files[]" accept="image/*"/>     			
	     			  <div style="width:100%;height:15px" >	</div>
     			  </div>
     			     
     			 <div class="img-w"> 
     	        	 <img id ="secondCard" src="${resRoot}/image/order/card02.png" style="display:block;width:175px;height:110px;margin:0px auto;">
     	         	<input class="file-input select-file" type="file" id="file-back" name="files[]" accept="image/*"/>
       		 		  <div style="width:100%;height:40px" >	</div>
       		 	</div>
       		     <a id="netInfoBtn" style="background-color:#FD8E4D;color:#fff;width:90%;height:35px ;line-height:35px;display: block;text-align:center;margin:0px auto;" > 同意协议并确定 </a>	
    	</div>
     	
        </div>
    
  </body>
</html>