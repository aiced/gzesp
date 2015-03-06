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
    <div style="background-color:#1D2427; width:100%;height:44px;margin-left:0px;margin-bottom:20px;" >   	
     	<a style="color:#fff;width:60px;height:44px ;line-height:44px; float:left;display: block;text-align:center;margin-left:1px"> 返回 </a>	
    	<a style="color:#fff;width:40px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:10px;margin-top:12px;border:1px solid #fff"> 编辑 </a>	
    	<p style="color:#fff;width:60px;height:44px ;line-height:44px;margin:auto;"> 商品管理 </p> 	
    </div>
    
     <div style=" width:100%;height:44px;margin-left:0px;margin-bottom:20px;" >   	
     		<p style="float:left;width:120px;height:44px;line-height:44px;text-align:center;font-size:18px;color:#6A6969;">店长推荐
    		</p>
    		<img src="${resRoot}/image/goodsManager/goodSelectArrow.png", style="width:9px;height:16px;float:right;margin-right:10px;margin-top:10px;">  
			<div style="background-color:#A6A6A6;width:100%;float:left;height:0.5px;margin-top:0px;">
			</div>
     </div>
     
     <div style="width:100%;height:44px;margin-left:0px;margin-bottom:20px;" >   	
     		<p style="float:left;width:120px;height:44px;line-height:44px;text-align:center;font-size:18px;color:#6A6969;">热约合约
    		</p>
    		
    		<img src="${resRoot}/image/goodsManager/goodSelectArrow.png", style="width:9px;height:16px;float:right;margin-right:10px;margin-top:10px;">  
			<div style="background-color:#A6A6A6;width:100%;float:left;height:0.5px;margin-top:0px;">
			</div>
     </div>
     
          <div style="width:100%;height:44px;margin-left:0px;margin-bottom:20px;" >   	
     		<p style="float:left;width:120px;height:44px;line-height:44px;text-align:center;font-size:18px;color:#6A6969;">热销网卡
    		</p>
    		<img src="${resRoot}/image/goodsManager/goodSelectArrow.png", style="width:9px;height:16px;float:right;margin-right:10px;margin-top:10px;">  
			<div style="background-color:#A6A6A6;width:100%;float:left;height:0.5px;margin-top:0px;">
			</div>
     </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery-1.11.2.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
  </body>
</html>
