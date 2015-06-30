<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
<title>安全设置</title>
	 <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/acctSecurity.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/acctSecurity.js?v=${resVer}"></script>
	
</head>
<body>
	   <div id="top">
	       	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	       	<div id="top_middle">安全设置</div>
	   </div>
		<div class = "divContainer">
			<a id = "row" class = "rel">
				<em class = "title">支付密码</em>
				<#if (!acctinfo.UPDATE_TIME)>
					<em id= "subTitle" class = "fright">设置</em>
				<#else>
					<em id= "subTitle" class = "fright">重置</em>
				</#if>
			</a>
			<p class = "footer">资金账户变动，绑定／解除银行卡时需要输入的密码</p>		
		</div>
        <input type="hidden" id="hide_update_time" name="hide_update_time" value=${acctinfo.UPDATE_TIME}>
        <input type="hidden" id="hide_user_id" name="hide_user_id" value=${acctinfo.USER_ID}>
</body>
</html>