<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>欢迎来到${name}的微店</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/weShopIndex.css?v=${resVer}" rel="stylesheet">
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
    <div style="background-color:#1D2427; width:100%;height:44px;margin-left:0px;margin-bottom:20px;" >   	
     	<a style="color:#fff;width:60px;height:44px ;line-height:44px; float:left;display: block;text-align:center;margin-left:1px"> 返回 </a>	
    	<a style="color:#fff;width:40px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:10px;margin-top:12px;border:1px solid #fff"> 编辑 </a>	
    	<p style="color:#fff;width:60px;height:44px ;line-height:44px;margin:auto;"> 店铺设置 </p> 	
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
		    	<input id = "storeName" class = "input" value="张三微店" readonly="readonly" autocomplete="off"></input> 
		    	<div class = "cellTopLine">
		    	</div>		
	    </div>
	<!--联系方式   -->	
	    <div class = "cellDiv" >
		    	<p class = "cellRightLable"> 联系方式 </p>
		    	<input id = "phoneNum" class = "input" value="16601983264" readonly="readonly" autocomplete="off"></input> 
		    	<div class = "cellTopLine">
		    	</div>		
	    </div>
	<!--店铺二维码   -->	
	    <div class = "cellDiv" >
		    	<p class = "cellRightLable"> 店铺二维码 </p>
		    	
		    	<img class = "arrow" src="${resRoot}/image/goodsManager/goodSelectArrow.png" > 
		    	<img class = "qrCode" src="${resRoot}/image/weShop/erweima.png"" > 
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
    	<a class = "ok"> 确定</a>
    </div>

    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
  </body>
</html>