<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
<title>添加银行卡</title>
	 <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/addBankCardInput.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/addBankCardInput.js?v=${resVer}"></script>	
	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
	
	
	<script src="${resRoot}/js/jquery.1.7.2.min.js"></script>
    <script src="${resRoot}/js/mobiscroll_002.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_004.js" type="text/javascript"></script>
	<link href="${resRoot}/css/mobiscroll_002.css" rel="stylesheet" type="text/css">
	<link href="${resRoot}/css/mobiscroll.css" rel="stylesheet" type="text/css">
	<script src="${resRoot}/js/mobiscroll.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_003.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_005.js" type="text/javascript"></script>
	<link href="${resRoot}/css/mobiscroll_003.css" rel="stylesheet" type="text/css">
    
</head>
<body>
    <!--top_start-->
    <div id="top">
       	<div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
       	<div id="top_middle">添加银行卡</div>
       	<div id="top_right" onclick="rightClick(this)">
			<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
		</div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
	<div class = "divContainer">
		<p class = "header">请绑定持卡人本人的银行卡</p>
		<ul class = "border_top border_bottom">
			
			<li class = "border_bottom">
				<em> 持卡人 </em>	
				<input class="input_normal" type="text"  placeholder="" id="txtusername">				
			</li>
			
			<li class = "border_bottom" >
				<em> 身份证 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="txtpersonalid">				
			</li>
			
			<li class = "border_bottom">
				<em> 开户银行 </em>	
<!-- 				<select id = "band_select" class= "" tabindex="1">
					<option value="-1">--选择银行卡--</option>
					<option value="1">中国招商银行</option>
					<option value="2">中国建设银行</option>
				</select> 	 -->			
                <select class="form-control" name="band_select" id="band_select" tabindex="1">
                	<option value="请选择开户银行">请选择开户银行</option>
		      		<#if (bankList?size==0)>
						<option value="数据加载失败">数据加载失败</option>
		        	<#else>
						<#list bankList as item>						
						    <option value="${item.param_code}">
							${item.param_value}
							</option>
						</#list>
		 			</#if>
                </select>
			</li>
			
			
			<li class = "border_bottom">
				<em> 卡类型 </em>	
				<select id = "cardType_select" class= "" tabindex="0">
					<option value="-1">--选择卡类型--</option>
					<option value="1">借记卡</option>
					<option value="2">信用卡</option>
				</select> 			
			</li>
			
			<li id = "validity_li" class = "border_bottom" style="display : none">
				<em class = "em_normal"> 有效期 </em>	
				<input value="" class="" readonly="readonly" name="search_select" id="search_select" type="text">
			</li>
			
			<li id = "CVN2_li" class = "border_bottom"  style="display : none">
				<em class = "em_long"> CVN2 <em>(卡背后三位)</em> </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="txt3cord">				
			</li>
			
			<li class = "border_bottom">
				<em> 卡号 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="txtcardno" name='txtcardno'>				
			</li>
			
			<li class = "border_bottom">
				<em class = "em_long"> 银行预留手机 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="txtphone">				
			</li>
			
			<li class = "border_bottom">
				<em class = "em_normal"> 验证码 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="输入验证码" id="txtverify">				
				<a id = "validation" class = "fright"> 输入验证码 </a	>		
			</li>
			

		</ul>
		
		<div style = "margin:15px 15px;font-size:14px;">
			<input id="chkRight" type="checkbox" checked="true" name="chkRight">
			同意   
			<a style="color:green" href="regProtocol">《用户协议》</a>
		</div> 
		
		<a id = "next"> 添加银行卡
	
		</a>
		<input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
	</div>

</body>
</html>
