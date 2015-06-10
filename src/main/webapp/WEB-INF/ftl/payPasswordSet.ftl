<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密码设置</title>
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/payPasswordSet.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/payPasswordSet.js?v=${resVer}"></script>
	</head>
<body>

 		   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	        </div> 

	<div class = "container">
 
	
	<br/>
	<br/>
		<ul class = "border_top border_bottom">
			<li class = "border_bottom">
				<em> 设置密码: </em>	
				<input class= "input_nolmal" type="password"  placeholder="必填" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em> 确认密码: </em>	
				<input class= "input_nolmal" type="password"  placeholder="必填" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em> 安全手机: </em>	
				<input class= "input_nolmal" type="text"  placeholder="必填" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em> 验证码 :</em>	
				<input class= "input_validation" type="text"  placeholder="必填" id="test">				
				<a id = "validation" class = "fright"> 输入验证码 </a	>		
			</li>
		</ul>
		
		<a id = "save"> 确认
	
		</a>
		
		
	</div>

</body>
</html>