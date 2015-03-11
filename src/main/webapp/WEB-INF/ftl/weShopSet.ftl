<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>欢迎来到${name}的微店</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
         <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
  
  </head>
  
  
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
	 
	.cellDiv {background:white;width:100%;height:44px;}
	.cellRightLable{color:#545454;margin-left:10px;width:150px;height:42px;line-height:42px;float:left;display: block;}
	.cellTopLine{background-color:#E8E9E8;width:95%;height:0.5px;margin:auto;}
	.avartar{width:36px;height:36px ;float:right;display: block;margin-right:10px;margin-top:4px;}
	.input{width:140px;height:40px ;float:right;display: block;margin-right:10px;margin-top:2px; text-align:right;
		border-left: 0;
   		border-right: 0;
  		border-top: 0;
  	    border-bottom:0px;
  	    color:#BABABA;
  	    }
  	 .arrow{width:10px;height:15px ;float:right;display: block;margin-right:10px;margin-top:15px}
  	 .qrCode{width:20px;height:20px ;float:right;display: block;margin-right:5px;margin-top:12px;background-color:#E8E9E8;}
  	 .skin{width:20px;height:20px ;float:right;display: block;margin-right:5px;margin-top:12px;background-color:#E8E9E8;}
  	 
   .ok{
    background-color:#F7A837;
    width : 90%;
	height : 40px;
	line-height: 40px;
    color: #fff;
    font-size: 16px;
    font-weight: bold;
    text-align: center;
	margin:2px auto;
	display: block;
	}
  	    
  	    
	
</style>

  <body >
<!--标题   -->
 	<div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
	 </div>
    
    <div style="width:100%;height:20px;">
    </div>
    
    <!--列表   -->
	<!--店铺图标   -->	
		<div class = "cellDiv" >
		    	<p class = "cellRightLable"> 店铺图标 </p>
 		    	<img class = "avartar img-circle" src="${resRoot}/image/weShop/touxiang.png" > 
		    	</div>	
   	<!--店铺名称   -->	
	    <div class = "cellDiv" >
		    	<p class = "cellRightLable"> 店铺名称 </p>
		    	<input id = "storeName" class = "input" value="张三微店" placeholder="点击输入店名"></input> 
		    	<div class = "cellTopLine">
		    	</div>		
	    </div>
	<!--联系方式   -->	
	    <div class = "cellDiv" >
		    	<p class = "cellRightLable"> 联系方式 </p>
		    	<input id = "phoneNum" class = "input" value="16601983264" placeholder="点击输入联系方式"></input> 
		    	<div class = "cellTopLine">
		    	</div>		
	    </div>
	<!--店铺二维码   -->	
	    <div id ="qrCode" class = "cellDiv" >
		    	<p class = "cellRightLable"> 店铺二维码 </p>
		    	
		    	<img class = "arrow" src="${resRoot}/image/goodsManager/goodSelectArrow.png" > 
		    	<img class = "qrCode" src="${resRoot}/image/weShop/erweima.png" > 
		    	<div class = "cellTopLine">
		    	</div>		
	    </div>
	 <!--店铺皮肤   -->	
	     <div class = "cellDiv" >
		    	<p class = "cellRightLable"> 店铺皮肤 </p>
		    	<img class = "arrow" src="${resRoot}/image/goodsManager/goodSelectArrow.png" > 
		    	<img class = "skin" src="${resRoot}/image/goodsManager/skin.png" > 
		    	<div class = "cellTopLine">
		    	</div>		
	    </div>
				
    <div style="width:100%;height:44px;margin-top:20px;">   	
    	<a class = "ok" onclick="doneClick(this); return false;"> 确定</a>
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
		  $("#qrCode").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'name':'leoxu', 'age':'1', 'index':'1'};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/weShopSet/weShopSetQrcode', 
				data: parms
     	    });  
		  	
		  });  
		  
		});
	</script>
    
  </body>
</html>