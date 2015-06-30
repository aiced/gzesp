<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
<title>密码设置成功</title>
 	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/payPasswordSuccess.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/payPasswordSuccess.js?v=${resVer}"></script>
</head>
<body>
		   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">设置成功</div>
	        </div> 
	<br/>
	<br/>
	<div class = "divContainer">
		<div class = "imgContainer">
				<img src="${resRoot}/image/myacct/right.png"> 
		</div>	
		<p class = "set_success"> 设置密码成功 </p>
		<p class = "set_alert"> 为了保障您的资金安全，请妥善保管您的密码 </p>		
		<a id = "save"> 完成
		</a>
		<input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
	</div>
		
</body>
</html>

