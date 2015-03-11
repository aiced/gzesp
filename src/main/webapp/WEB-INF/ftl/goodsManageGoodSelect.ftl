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
	
	html{
 		/*background-color:gray;*/
		}
	
	body {
	/*	默认有个高度 20px */
		/* background-color:red;*/
		 }
     html, body , p ,img{
	  margin:0; 
	  padding:0; 
	  border:0;
   	  list-style:none;
	 }

</style>

  <body>
   <!--标题   -->
 	<div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
	 </div
    <div style="width:100%;height:24px ;margin-top:20px;">
	 <p style="padding-left:20px;width:260px;height:24px ;line-height:24px;display: block;font-size:13px;color:#6A6969;margin-top:20px;">可选择的不超过四个</p>
    <!--添加图片  -->
     <div style="height:270px;margin:20px;position:relative;" >  
     				<!-- 当没有图片时候，会有边框，表示这里有个图片。  --> 
     		<div id="first_row_left" style="width:40%;height:40%;display: block;position:absolute;left:5px;top:5px">
     		    <img src="${resRoot}/image/goodsManager/addGoods.png", style="width:100%;height:100%;display: block;position:absolute;">
     			<img src="${resRoot}/image/goodsManager/addGoodsDelete.png", style="width:20px;height:20px;display: block;position:absolute;right:-10px;top:-10px">
     		 </div> 
         	<div id="first_row_right" style="width:40%;height:40%;display: block;position:absolute;right:5px;top:5px">
         	     		    <img src="${resRoot}/image/goodsManager/addGoods.png", style="width:100%;height:100%;display: block;position:absolute;">
         	     			<img src="${resRoot}/image/goodsManager/addGoodsDelete.png", style="width:20px;height:20px;display: block;position:absolute;right:-10px;top:-10px">
         	
         	</div>           		
       		<div id="second_row_left" style="width:40%;height:40%;display: block;position:absolute;left:5px;bottom:5px">
       		     		    <img src="${resRoot}/image/goodsManager/addGoods.png", style="width:100%;height:100%;display: block;position:absolute;">
       		     			<img src="${resRoot}/image/goodsManager/addGoodsDelete.png", style="width:20px;height:20px;display: block;position:absolute;right:-10px;top:-10px">
       		
       		</div>  
       		<div id="second_row_right" style="width:40%;height:40%;display: block;position:absolute;right:5px;bottom:5px">
       		     	         <img src="${resRoot}/image/goodsManager/addGoods.png", style="width:100%;height:100%;display: block;position:absolute;">
       		     			<img src="${resRoot}/image/goodsManager/addGoodsDelete.png", style="width:20px;height:20px;display: block;position:absolute;right:-10px;top:-10px">
       		</div>
     							
     </div>
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
		  $("#first_row_left").click(function(){  
		  //在这里操作获取验证码		  
		  	var parms = {'index':'1'};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodAdd', 
				data: parms
     	    });  
		  	
		  });  
		   $("#first_row_right").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'index':'2'};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodAdd', 
				data: parms
     	    });  
		  	
		  });  
		  $("#second_row_left").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'index':'3'};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodAdd', 
				data: parms
     	    });  
		  	
		  }); 
		  $("#second_row_right").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'index':'2'};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodAdd', 
				data: parms
     	    });  
		  	
		  }); 
		  
		});
		
	</script>

  </body>
</html>
