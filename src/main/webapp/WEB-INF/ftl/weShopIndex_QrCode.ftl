<!DOCTYPE html>
<html lang="zh-cn">

  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>店铺二维码</title>
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
</style>

  <body >
<!--标题   -->
 	<div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right"></div>
	 </div>
      <div style="width:100%;height:20px;">
    </div>
    <div style="display: none;">
    	<img src='http://res.gz10010.xyz/uploader/qrcode.png' alt="" class="img-responsive"/>
	</div> 
     <div style="width:100%;height:244px;margin-left:0px;margin-bottom:20px;" >   	
     		<div id = "qrcodeDiv" style="width:200px;height:200px ;line-height:44px;margin:auto;">
     </div>	
     		
     	
     	
    </div>
    
    
    

    

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
     <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
     <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
     <script src="${resRoot}/js/jquery.qrcode.js?v=${resVer}"></script>
    <script src="${resRoot}/js/qrcode.js?v=${resVer}"></script>

 	 <script>
       //获取当前页面url并生成二维码展示在 xx的微店
       var thisUrl = "http://wap.gz10010.xyz/esp/weShop/index/"+${userid};
       $('#qrcodeDiv').qrcode({
		render:"canvas", //默认canvas方式，性能好
		text: thisUrl, //设置二维码内容
		width:200,     //设置宽度  
        height:200,     //设置高度 
        typeNumber:-1,  //计算模式 
        correctLevel:QRErrorCorrectLevel.H,//纠错等级  
        background:"#ffffff",//背景颜色  
        foreground:"#000000" //前景颜色
	});	
    </script>

    
  </body>
</html>