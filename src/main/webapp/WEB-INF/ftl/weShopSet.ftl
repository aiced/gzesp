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
	.avatar{width:36px;height:36px ;float:right;display: block;margin-right:10px;margin-top:4px;}
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
	 </div>
    
    <div style="width:100%;height:20px;">
    </div>
    
    <!--列表   -->
	<!--店铺图标   -->	
	<#list userlist as info>			
			 <#if (info_index<=0) > 
	<div class = "cellDiv" >
		    	<p class = "cellRightLable"> 店铺图标 </p>
		    	  	<#if ('${info.avatar}'?exists) > 
			  			   <img class = "avatar img-circle" src='${info.avatar}' > 
 					<#else>						
 		    				<img class = "avatar img-circle" src=""  > 
					</#if>		    	
		    	</div>	
   	<!--店铺名称   -->	
	    <div class = "cellDiv" >
		    	<p class = "cellRightLable"> 店铺名称 </p>
		    	<input id = "storeName" class = "input" value=${info.storeName} placeholder="点击输入店名"></input> 
		    	<div class = "cellTopLine">
		    	</div>		
	    </div>
	<!--联系方式   -->	
	    <div class = "cellDiv" >
		    	<p class = "cellRightLable"> 联系方式 </p>
		    	<input id = "phoneNum" class = "input" value=${info.phoneNumber} placeholder="点击输入联系方式"></input> 
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
    
    <input id = "hideTag" type = "hidden" name = 'hideTag' value = ${info.userId}>
    
				
 			 </#if>
	</#list>
	

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
	
	 <script type="text/javascript">
    function doneClick(obj) {
 		 var storeName = document.getElementById("storeName");
 		if (storeName.value.length !== 0){
		 }else{
	 		alert("店名不能为空");
		    return;
 		}
 
 		var phoneNum  = document.getElementById("phoneNum");
 		alert(phoneNum.value);
 		var re = /^1\d{10}$/;
  		  if (re.test(phoneNum.value)) {
  		  } else {
 			 alert("请输入正确的手机号");
 			 return;
   		 }
	    var userId = $("#hideTag").val();;	
    	//ajax 操作，刷新本界面数据   
		var parms = {'storeName':storeName.value,'phoneNum':phoneNum.value,'userId':userId};
		$.ajax({
		 type: "POST",
		 url: "weShopSetUpdate",
		 data: parms,
		 success: function(data){
			 window.location.reload(); 
		 }
		});			
}
     </script>
	
    
  </body>
</html>