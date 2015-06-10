<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加银行卡</title>
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/addBankCardInput.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/addBankCardInput.js?v=${resVer}"></script>	
</head>
<body>
	   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	        </div> 
	<div class = "container">
		<br/>
		<br/>

		<p class = "header">请绑定持卡人本人的银行卡</p>
		<ul class = "border_top border_bottom">
			
			<li class = "border_bottom">
				<em> 持卡人 </em>	
				<input class="input_normal" type="text"  placeholder="" id="test">				
			</li>
			
			<li class = "border_bottom" >
				<em> 身份证 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em> 开户银行 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="test">				
			</li>
			
			
			<li class = "border_bottom">
				<em> 卡类型 </em>	
				<input class="input_normal"   type="text"  placeholder="" id="test">				
			</li>
			
			<li>
				<em> 卡号 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="test">				
			</li>
		</ul>
		
		<div style = "margin:10px 15px;font-size:14px;">
			<input id="chkRight" type="checkbox" checked="true" name="chkRight">
			同意   
			<a style="color:green" href="regProtocol">《用户协议》</a>
		</div> 
		
		<a id = "next"> 下一步
	
		</a>
		
	</div>

</body>
</html>