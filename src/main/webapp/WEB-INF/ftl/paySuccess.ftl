<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
     <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">

  </head>

 <style type="text/css">	 
 	* {margin:0;padding:0;} 
      html, body , p {
	  margin:0; 
	  padding:0; 
   	  list-style:none;
	 }
</style>

  <body>
  <!--标题   -->
  		   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
	        </div>  
	        
	         <div style="width:100%;height:20px;">
   			 </div>
    		 <div style="width:100%;height:244px;margin-left:0px;margin-top:30px;margin-bottom:40px;" >   	
     				<div style="width:200px;height:125px ;line-height:44px;margin:auto;">
     				<img src="${resRoot}/image/order/paySuccessHeader.png"  style="display:block; width:100%;height:100%;">
  		     </div>	 
  		     
  		      <div style="width:100%;height:100px;margin-left:0px;margin-top:10px;margin-bottom:40px;text-align: center" > 
					<div style="width:200px;height:30px;margin-left: auto;margin-right: auto;">
						  <img src="${resRoot}/image/order/paySuccessDot.png" style="display:block;float:left; margin-top:16px;width:10px;height:10px;">
							<p style="display:block;float:left; margin-top:12px;margin-left:5px;width:170px;height:10px;font-size:13px;">您的订单号：${orderId}</p>
					</div>
					<div style="width:200px;height:30px;margin-left: auto;margin-right: auto;">
						  <img src="${resRoot}/image/order/paySuccessDot.png" style="display:block;float:left; margin-top:16px;width:10px;height:10px;">
							<p style="display:block;float:left; margin-top:12px;margin-left:5px;width:170px;height:10px;font-size:13px;">您的付款方式：${payModle}</p>
					</div>
					
					<div style="width:200px;height:30px;margin-left: auto;margin-top:25px;margin-right: auto;">
						   <a id="netInfoBtn" style="background-color:#FD8E4D;color:#fff;width:50%;height:30px ;line-height:30px;display: block;text-align:center;margin:0px auto;text-decoration:none" onclick="backClick(); return false;" > 返回商城 </a>	
					</div>
					
					
   		     </div>	        
	        
    
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
     <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
	<script>
		function backClick() {
			alert('点击返回');
		}
	 </script>
    
    
  </body>
</html>
