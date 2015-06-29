<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<title>安全验证</title>
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/payPasswordResetVerify.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/payPasswordResetVerify.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>


</head>
<body>
	   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">安全验证</div>
	        </div> 
		<div class = "container">
			<br/>
			<ul class = "border_top border_bottom">
			
			<li class = "border_bottom">
				<em> 安全手机 </em>	
				<input class= "input_nolmal" type="text"  placeholder="输入手机号" id="txtPhone" name="txtPhone" onblur="doBlur(this);" onfocus="doFocus(this);">				
			</li>
			
			<li >
				<em> 验证码 </em>	
				<input class= "input_validation" type="text"  placeholder="输入验证码" id="txtCode" name="txtCode" disabled='true' onblur="doBlur(this);" onfocus="doFocus(this);">				
				<a id = "validation" class = "fright" onclick="getCode(this);"> 获取验证码 </a>		
			</li>
		</ul>
		
		<a id = "next"> 下一步
	
		</a>
		
		<input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
		<input type="hidden" value='' id="hide_code_date" name="hide_code_date">
		</div>
</body>
</html>