<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<title>密码重置</title>
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/payPasswordReset.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/payPasswordReset.js?v=${resVer}"></script>

	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
</head>
<body>
	   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">密码重置</div>
	        </div> 
	<div class = "container">
			<br/>
			<ul class = "border_top border_bottom">
			
			<li class = "border_bottom">
				<em> 新密码: </em>	
				<input class= "input_nolmal" type="password"  placeholder="" id="txtpwd" name='txtpwd' onfocus="doFocus(this);" onblur="doBlur(this);">				
			</li>
			
			<li >
				<em> 确认密码: </em>	
				<input class= "input_nolmal" type="password"  placeholder="" id="txtrepwd" name='txtrepwd' onfocus="doFocus(this);" onblur="doBlur(this);">				
			</li>
		</ul>
		
		<a id = "save"> 确定
	
		</a>
		<input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
		
		</div>
</body>
</html>