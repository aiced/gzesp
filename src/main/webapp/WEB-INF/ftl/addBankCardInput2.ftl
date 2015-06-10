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
			
			<li class = "border_bottom" >
				<em class = "em_long"> CVN2 <em>(卡背后三位)</em> </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em class = "em_normal"> 有效期 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="test">				
			</li>
			
			
			<li class = "border_bottom">
				<em class = "em_long"> 银行预留手机 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="test">				
			</li>
			
			<li >
				<em class = "em_normal"> 验证码 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="输入验证码" id="test">				
				<a id = "validation" class = "fright"> 输入验证码 </a	>		
			</li>
		</ul>
		
		
		<div style = "margin:10px 15px;font-size:14px;">
			<input id="chkRight" type="checkbox" checked="true" name="chkRight">
			同意   
			<a style="color:green" href="regProtocol">《用户协议》</a>
		</div> 

		<a id = "save"> 下一步
	
		</a>
		
	</div>

</body>
</html>