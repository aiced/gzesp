<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
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
				<select id = "band_select" class= "" tabindex="1">
					<option value="-1">--选择银行卡--</option>
					<option value="1">中国招商银行</option>
					<option value="2">中国建设银行</option>
				</select> 				
				
			</li>
			
			
			<li class = "border_bottom">
				<em> 卡类型 </em>	
				<select id = "cardType_select" class= "" tabindex="1">
					<option value="1">银联卡</option>
					<option value="2">信用卡</option>
				</select> 			
			</li>
			
			<li id = "validity_li" class = "border_bottom">
				<em class = "em_normal"> 有效期 </em>	
					<select id = "validity_select" class= "" tabindex="1">
					<option value="-1">--选择有效期--</option>
					<option value="1">2015-08</option>
					<option value="2">2015-09</option>
				</select> 	
			</li>
			
			<li id = "CVN2_li" class = "border_bottom" >
				<em class = "em_long"> CVN2 <em>(卡背后三位)</em> </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em> 卡号 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em class = "em_long"> 银行预留手机 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="test">				
			</li>
			
			<li class = "border_bottom">
				<em class = "em_normal"> 验证码 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="输入验证码" id="test">				
				<a id = "validation" class = "fright"> 输入验证码 </a	>		
			</li>
			

		</ul>
		
		<div style = "margin:15px 15px;font-size:14px;">
			<input id="chkRight" type="checkbox" checked="true" name="chkRight">
			同意   
			<a style="color:green" href="regProtocol">《用户协议》</a>
		</div> 
		
		<a id = "next"> 下一步
	
		</a>
		
	</div>

</body>
</html>