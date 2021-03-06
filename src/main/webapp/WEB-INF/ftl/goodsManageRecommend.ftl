<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">

  </head>

 <style type="text/css">	 
 	* {margin:0;padding:0;} 
	
	html{
 	/*	background-color:gray;*/
		}
	
	body {
	/*	默认有个高度 20px */
	/*	 background-color:red;*/
		 }
     html, body , p {
	  margin:0; 
	  padding:0; 
   	  list-style:none;
	 }

</style>

  <body>
  <!--标题   -->
  		   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	        </div>        
	        
    
     <div id="first_row" style=" width:100%;height:50px;padding-top:5px;padding-left:15px;margin-left:0px;border-bottom:1px solid #A6A6A6" >   	
     		<p style="float:left;height:44px;line-height:44px;text-align:center;font-size:18px;color:#6A6969;">店长推荐
    		</p>
    		<img src="${resRoot}/image/goodsManager/goodSelectArrow.png", style="width:9px;height:16px;float:right;margin-right:10px;margin-top:10px;">  
     </div>
     
     <div id="second_row"  style="width:100%;height:50px;padding-top:5px;padding-left:15px;margin-left:0px;border-bottom:1px solid #A6A6A6; background:#dcdcdc;color:#aaa;" >   	
     		<p style="float:left;line-height:44px;text-align:center;font-size:18px;color:#6A6969;">热销合约（敬请期待）	</p>
    		
    		<img src="${resRoot}/image/goodsManager/goodSelectArrow.png", style="width:9px;height:16px;float:right;margin-right:10px;margin-top:10px;">  
     </div>
     <div id="third_row" style="width:100%;height:50px;padding-top:5px;padding-left:15px;margin-left:0px;border-bottom:1px solid #A6A6A6; background:#dcdcdc;color:#aaa;" >   	
     		<p style="float:left;line-height:44px;text-align:center;font-size:18px;color:#6A6969;">热销套餐（敬请期待）	</p>
    		<img src="${resRoot}/image/goodsManager/goodSelectArrow.png", style="width:9px;height:16px;float:right;margin-right:10px;margin-top:10px;">  
     </div>
     <div id="third_row" style="width:100%;height:50px;padding-top:5px;padding-left:15px;margin-left:0px;border-bottom:1px solid #A6A6A6; background:#dcdcdc;color:#aaa;" >   	
     		<p style="float:left;line-height:44px;text-align:center;font-size:18px;color:#6A6969;">热销网卡（敬请期待）	</p>
    		<img src="${resRoot}/image/goodsManager/goodSelectArrow.png", style="width:9px;height:16px;float:right;margin-right:10px;margin-top:10px;">  
     </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
     <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    <script type="text/javascript">
		$(document).ready(function(){  
		   //[获取验证码]按钮点击	
		  $("#first_row").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'userId':${userId}};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodSelect', 
				data: parms
     	    });  
		  	
		  });  
		  /* $("#second_row").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'userId':${userId}};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodSelect', 
				data: parms
     	    });  
		  	
		  });*/  
		  /*$("#third_row").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'userId':${userId}};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodSelect', 
				data: parms
     	    });  
		  	
		  });*/ 
		  
	        //[返回]按钮点击
	        $("#top_left").click(function(){
	    		location.href = "weShopHome?userid="+${userId};
	        });   
		});
	</script>
    
    
  </body>
</html>
