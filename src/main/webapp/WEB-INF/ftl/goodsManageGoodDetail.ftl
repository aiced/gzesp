<!DOCTYPE html>
<html lang="zh-cn">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>商品管理</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
 	 <!-- Bootstrap core CSS -->
 	 /*
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    */      
  </head>
 <style type="text/css">	 
 	* {margin:0;padding:0;} 
	
	html{
 	/* 	background-color:gray; */
		}
	
	body {
	/*	默认有个高度 20px */
/* 		 background-color:red; */
		 }
     html, body , p ,img{
	  margin:0; 
	  padding:0; 
	  border:0;
   	  list-style:none;
	 }

</style>
  
 
 <body >
	<!--标题   -->
    <div style="background-color:#1D2427; width:100%;height:44px;margin-left:0px;margin-bottom:0px;" >   	
     	<a style="color:#fff;width:60px;height:44px ;line-height:44px; float:left;display: block;text-align:center;margin-left:1px"> 返回 </a>	
    	<a style="color:#fff;width:40px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:10px;margin-top:12px;border:1px solid #fff"> 编辑 </a>	
    	<p style="color:#fff;width:60px;height:44px ;line-height:44px;margin:auto;"> 商品管理 </p> 	
    </div>
    <!--图片  -->
     <div style="width:100%;height:150px;margin-bottom:10px;" >  
     				<!-- 当没有图片时候，会有边框，表示这里有个图片。  --> 	
     	    		<img style="background-color:gray;width:100%;height:98%;display: block;float:left;">  
     	    		<img style="background-color:red;width:40px;height:40px;display: block;margin-left:20px;margin-top:-95px;float:left;">  
     	    		<img style="background-color:red;width:40px;height:40px;display: block;margin-right:20px;margin-top:-95px;float:right;">       	    		
     </div>
     <!--文字  -->
     <div style="margin-bottom:0px;padding-top:0px;padding-bottom:15px;" >  
     		<p style="margin-left:5px;margin-right:5px;margin-bottom:5px;font-size:16px;color:#33333">［老用户专享］苹果（apple）iphone6/iphone6 plus 4G全国套餐合约机 直降300元 全国无漫游</p>
     		<div style=" width:100%;height:25px;float:none;margin-bottom:10px;">
     		     		<p style="padding:5px;margin-bottom:0px;font-size:15px;color:#717171;float:left;">合约价:</p>	<p style="padding:5px;margin-bottom:0px;float:left; font-size:17px;color:red">¥5900（最高返5900）</p>	  
     		</div>
     		<div style=" width:100%;height:25px;float:none;">
     		     		<p style="padding:5px;margin-bottom:0px;font-size:15px;color:#717171;float:left;">商品佣金:</p> <p style="padding:5px;margin-bottom:0px;float:left; font-size:17px;color:red">¥5900</p>	    	    		
     		</div>  	    		
     </div>
     <!-- 自定义活动 -->
      <div style="width:100%;margin-bottom:20px;padding-top:20px;padding-bottom:20px;" >  
     	    	<p style="background-color:gray; width:100%;height:1px ;margin:auto;"> </p> 
       	    	<p style="margin:10px;font-size:17px;color:#484848">自定义活动 </p> 
       	    	<!--活动标题  -->
       	   		<div style="width:100%;height:50px;margin-bottom:10px;padding-top:10px;">
       	   			<p style="width:60px;height:30px;line-height:30px;margin-left:10px;margin-bottom:10px;float:left;color:#878787">活动标题 </p> 
       	   			<input style="width:70%;height:30px;margin-right:30px;float:right;padding-left:10px;"  type="tel" placeholder="赠品：虎牌保温杯" data-value="赠品：虎牌保温杯">       	   			
       	   		</div>
       	   		<!--活动详情  -->
       	   		<div style="width:100%;height:150px;margin-bottom:10px;padding-top:10px;padding-bottom:10px;">
       	   			<p style="width:60px;height:20px;margin-left:10px;margin-bottom:10px;float:left;color:#878787">活动详情 </p> 
       	   			<textarea style="width:70%;height:120px;margin-right:30px;float:right;padding:10px;" > </textarea>     	   			
       	   		</div>    	    		
     </div>
</body>
  
  
</html>
