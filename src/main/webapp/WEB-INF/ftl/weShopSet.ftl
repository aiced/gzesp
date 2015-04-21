<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<title>欢迎来到${name}的微店</title>

<!-- Bootstrap core CSS -->
<link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}"
	rel="stylesheet">
<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">

</head>

<!-- Bootstrap core JavaScript====================== -->
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
		  	var parms = {'name':'leoxu', 'age':'1', 'index':'1','userId':$("#hideTag").val()};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/weShopSet/weShopSetQrcode', 
				data: parms
     	    });  
		  });  
		  //店铺名称文本框失去焦点
		  $("#storeName").focus(function(){
			  $("#storeName").val("");
		  });
		  //手机号文本框失去焦点
		  $("#phoneNum").focus(function(){
			  $("#phoneNum").val("");
		  });
		  //微信号文本框失去焦点
		  $("#weixin").focus(function(){
			  $("#weixin").val("");
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
 		//修改手机号 还需要去判断是否有手机号是否存在
 		var phoneNum  = document.getElementById("phoneNum");
 		var re = /^1\d{10}$/;
 		if($("#hide_phonenumber").val()!=phoneNum.value)
 		{
 			 if(!checkPhoneNum(phoneNum.value)) //edit_by_wenh_2015_3_26
 	 		 {
 	 			  return
 	 		 }
 	  		  if (re.test(phoneNum.value)) {
 	  		  } 
 	  		  else {
 	 			 alert("请输入正确的手机号");
 	 			 return;
 	   		 }
 		}
 		if($("#hide_weixin_id").val()!=$("#weixin").val())
 		{
			 if(!checkWeChat($("#weixin").val())) //edit_by_wenh_2015_3_26
 	 		 {
 	 			  return;
 	 		 }
 		}

	    var userId = $("#hideTag").val();
    	//ajax 操作，刷新本界面数据   
		var parms = {'storeName':storeName.value,'phoneNum':phoneNum.value,'userId':${userId},'weixinid':$('#weixin').val(),'username':'${name}'};
		$.commonFormSubmit({
		 type: "POST",
		 action: '${base}/shopManage/weShopSetUpdate',
		 data: parms,
		 success: function(data){
		  	 //history.back();
		  	 //alert("ok");
		  	 //return;
		  	 //alert(data);
		  	 return;
		 }
		});			
}
     </script>
<style type="text/css">

.cellDiv {
	background: white;
	width: 100%;
	height: 60px;
}

.cellRightLable {
	color: #545454;
	margin-left: 10px;
	height: 60px;
	line-height: 60px;
	float: left;
}

.cellTopLine {
	background-color: #E8E9E8;
	width: 95%;
	height: 0.5px;
	margin: auto;
}

.avatar {
	width: 48px;
	height: 48px;
	float: right;
	margin-right: 30px;
	margin-top: 5px;
}

.input {
	width: 140px;
	height: 40px;
	float: right;
	display: block;
	margin-right: 10px;
	margin-top: 10px;
	text-align: right;
	border-left: 0;
	border-right: 0;
	border-top: 0;
	border-bottom: 0px;
	color: #BABABA;
}

.arrow {
	width: 10px;
	height: 15px;
	float: right;
	margin-right: 10px;
	margin-top: 30px
}

.qrCode {
	width: 48px;
	height: 48px;
	float: right;
	display: block;
	margin-right: 12px;
	margin-top: 10px;
	background-color: #E8E9E8;
}

.skin {
	width: 48px;
	height: 48px;
	float: right;
	display: block;
	margin-right: 12px;
	margin-top: 10px;
	background-color: #E8E9E8;
}

</style>

<body>
	<!--标题   -->
	<!--top_start-->
	<div id="top">
		<div id="top_left">
			<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		</div>
		<div id="top_middle">${title}</div>
		<div id="top_right"></div>
	</div>
	<div id="dv_clear"></div>
	<!--top_end-->
	<!--列表   -->
	<!--店铺图标   -->
	<#list userlist as info> <#if (info_index<=0) >
	<div class="cellDiv">
		<div class="cellRightLable">店铺图标</div>
		<!-- edit_by_wenh_2015_3_31 通过根据该字段的字符串的长度是否大于5来进行显示相关图片，已经路径的长度肯定大于5，5是随便写的，后续可以修改 -->
		<#if ('${info.avatar}'?length gt 5) > 
			<img class="avatar img-circle" src='${imageRoot}${info.avatar}'> 
		<#else> 
			<img class="avatar img-circle" src="${imageRoot}/esp/resources/image/shopHome/head.png">
		</#if>
	</div>
	<!--店铺名称   -->
	<div class="cellDiv">
		<h5><div class="cellRightLable">店铺名称</div></h5>
		<input id="storeName" class="input input-lg" value=${info.storeName}
			placeholder="点击输入店名"></input>
		<div class="cellTopLine"></div>
	</div>
	<!--联系方式   -->
	<div class="cellDiv">
		<h5><div class="cellRightLable">联系方式</div></h5>
		<input id="phoneNum" class="input input-lg" value=${info.phoneNumber}
			placeholder="点击输入联系方式"></input>
		<div class="cellTopLine"></div>
	</div>
	<!-- edit_wenh_2015_3_27 -->
	<input type="hidden" value=${info.phoneNumber} id="hide_phonenumber" />
	<!--微信号   -->
	<div class="cellDiv">
		<h5><div class="cellRightLable">微信号</div></h5>
		<input id="weixin" class="input input-lg" value='${info.weixin_id}'
			placeholder="点击输入微信"></input>
		<div class="cellTopLine"></div>
	</div>
	<!-- edit_wenh_2015_3_27 -->
	<input type="hidden" value=${info.weixin_id} id="hide_weixin_id" />
	<!--店铺二维码   -->
	<div id="qrCode" class="cellDiv">
		<h5><div class="cellRightLable">店铺二维码</div></h5>

		<img class="arrow"
			src="${resRoot}/image/goodsManager/goodSelectArrow.png"> <img
			class="qrCode" src="${resRoot}/image/weShop/erweima.png">
		<div class="cellTopLine"></div>
	</div>
	<!--店铺皮肤   -->
	<div class="cellDiv">
		<h5><div class="cellRightLable">店铺皮肤</div></h5>
		<img class="arrow"
			src="${resRoot}/image/goodsManager/goodSelectArrow.png"> <img
			class="skin" src="${resRoot}/image/goodsManager/skin.png">
		<div class="cellTopLine"></div>
	</div>
	<br/>
	<div style="margin: 20px;">
		<button class="btn btn-warning btn-block" type="button" onclick="doneClick(this);"> 确定</button>
	</div>

	<input id="hideTag" type="hidden" name='hideTag' value=${info.userId}>


	</#if> </#list>
</body>
</html>