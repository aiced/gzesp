<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

	<title>密码设置</title>
	 <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/payPasswordSet.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/payPasswordSet.js?v=${resVer}"></script>
	
	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    
</head>
<body style="background-color:transparent">

 		   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">密码设置</div>
	        </div> 

	<div class = "divContainer">
 
	
	<br/>
	<br/>
		<ul class = "border_top border_bottom">
			<li class = "border_bottom">
				<em> 设置密码: </em>	
				<input class= "input_nolmal" type="password"  placeholder="长度必须是6位（必填）" id="txtpwd" name='txtpwd' onfocus="doFocus(this);" onblur="doBlur(this);">				
			</li>
			<li class = "border_bottom">
				<em> 确认密码: </em>	
				<input class= "input_nolmal" type="password"  placeholder="长度必须是6位（必填）" id="txtrepwd" name='txtrepwd' onfocus="doFocus(this);" onblur="doBlur(this);">				
			</li>
			
			<li class = "border_bottom">
				<em> 安全手机: </em>	
				<input class= "input_nolmal" type="text"  placeholder="必填" id="txtPhone" name='txtPhone' onfocus="doFocus(this);" onblur="doBlur(this);">				
			</li>
			
			<li class = "border_bottom">
				<em> 验证码 :</em>	
				<input class= "input_validation" type="text"  placeholder="必填" id="txtCode" onfocus="doFocus(this);" onblur="doBlur(this);" disabled='true'>
				<a id = "validation" class = "fright" > 输入验证码 </a>		
			</li>
		</ul>
		
		<a id = "save"> 确认
	
		</a>
        <input type="hidden" id="hide_update_time" name="hide_update_time" value=${acctinfo.UPDATE_TIME}>
        <input type="hidden" id="hide_user_id" name="hide_user_id" value=${acctinfo.USER_ID}>
		<input type="hidden" value='' id="hide_code_date" name="hide_code_date">
	</div>

</body>
</html>