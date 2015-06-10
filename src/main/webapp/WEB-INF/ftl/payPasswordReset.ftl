<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>密码重置</title>
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/payPasswordReset.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/payPasswordReset.js?v=${resVer}"></script>


</head>
<body>
	   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	        </div> 
	<div class = "container">
			<br/>
			<ul class = "border_top border_bottom">
			
			<li class = "border_bottom">
				<em> 请输入新密码 </em>	
				<input class= "input_nolmal" type="text"  placeholder="" id="test">				
			</li>
			
			<li >
				<em> 请确定密码 </em>	
				<input class= "input_nolmal" type="text"  placeholder="" id="test">				
			</li>
		</ul>
		
		<a id = "save"> 确定
	
		</a>

		</div>
</body>
</html>