<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <title>${title}</title>
   
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/weShopLoginIndex.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![end if]-->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>

	<script type="text/javascript">
	
		var bRet1=true;
		var bRet2=false;
		var bRet3=false;
		//判断输入的是否是手机号
    	function isPhoneNum(strPhoneNum)
    	{
			if(strPhoneNum && /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|170)\d{8}$/.test(strPhoneNum)){
			    return true;//是手机号
			} else{
			    return false; //不是手机号
			}
    	}
    	//校验输入数值是否正确
		function checkData()
		{
			if(!bRet1)
			{
				return false;
			}
			if(!bRet2)
			{
				return false;
			}
			if(!bRet3)
			{
				
				return false;
			}
			if($("#selArea").val()=="请选择您所在的地区")
			{
				alert("请选择您所在的区域");
				return false;
			}
    		if(!$('#chkRight').is(':checked')) {
    			alert("请勾选用户注册协议");
    		    return false;
    		}
			return true;
		}
	
    	function getNowDate()
    	{
		  var d = new Date();
		  var vYear = d.getFullYear();
		  var vMon = d.getMonth() + 1;
		  var vDay = d.getDate();
		  var h = d.getHours(); 
		  var m = d.getMinutes(); 
		  var se = d.getSeconds(); 
		  s=vYear+(vMon<10 ? "0" + vMon : vMon)+(vDay<10 ? "0"+ vDay : vDay)+(h<10 ? "0"+ h : h)+(m<10 ? "0" + m : m)+(se<10 ? "0" +se : se);
		  return s;	
    	}
    	
		$(document).ready(function(){  
			
			$("#txtphonenum").focus();
			
		   //[获取验证码]按钮点击
		  $("#btnCode").click(function(){  
			  //在这里操作获取验证码
			  //alert("发送验证码");
			  //点击的时候 获得当前时间
			  $("#hide_code_date").val(getNowDate());
			  
			  var bRet=isPhoneNum($("#txtphonenum").val());
				
			  if(!bRet)
			  {
			  	alert("手机号格式不对，请重新输入。");
			  	bRet1=false;
			  	return;
			  }
			  else if(!checkPhoneNum($("#txtphonenum").val()))
			  {
				  bRet1=false;
				  return;
			  }
			  else
			  {
			  	//这里开始做验证码操作 0是注册模板 1是支付模板
			  	bRet1=sendMessage($("#txtphonenum").val(),"#btnCode","0");
			  	if(bRet1)
			  	{
			  		$("#txtyanzhengma").attr("disabled",false); 
			  	}
			  	return;
			  }
		  });
		  //[手机号]文本框失去焦点
		  $("#txtphonenum").blur(function(){
			  	if(!$("#txtphonenum").val())
			  	{
			  		$("#div_phonenum").addClass("has-error");
			  		bRet2=false;
			  		return;
			  	}
			  	else
			  	{
					var bRet=isPhoneNum($("#txtphonenum").val());
						
					if(!bRet)
					{
					  	alert("手机号格式不对，请重新输入。");
					  	$("#div_phonenum").addClass("has-error");
					  	bRet2=false;
					  	return;
					}
					else if(!checkPhoneNum($("#txtphonenum").val()))
					{
						  $("#div_phonenum").addClass("has-error");
						  bRet2=false;
						  return;
					}
					else
					{
				  		$("#div_phonenum").removeClass("has-error");
				  		$("#div_phonenum").addClass("has-success");
				  		bRet2=true;
				  		return;
					}
			  	}
			});
		  //[验证码]文本框失去焦点  
		  $("#txtyanzhengma").blur(function(){
			  
		  	if(!$("#txtyanzhengma").val())
		  	{
		  		$("#div_yanzhengma").addClass("has-error");
		  		bRet3=false;
		  		//alert("验证码不能为空");
		  		return;
		  	}
		  	else if($("#txtyanzhengma").val()!=code)
		  	{
		  		alert("输入的验证码与短信中的验证码不匹配");
		  		$("#div_yanzhengma").addClass("has-error");
		  		bRet3=false;
		  		return;
		  	}
		  	else if(getNowDate() - $("#hide_code_date").val()>1800)
		  	{
		  		$("#div_yanzhengma").addClass("has-error");
		  		alert("验证码过期");
		  		bRet3=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_yanzhengma").removeClass("has-error");
		  		$("#div_yanzhengma").addClass("has-success");
		  		bRet3=true;
		  		return;
		  	}
		  });
		  //[微信号]文本框失去焦点
		  /*$("#txtwechataccount").blur(function(){
		  	//在这里操作 微信号  文本框失去焦点
		  	if(!$("#txtwechataccount").val())
		  	{
		  		//$("#tishi").html("微信号不能为空");
		  		$("#div_weichat").addClass("has-error");
		  		bRet4=false;
		  		return;
		  	}
		  	else if(!checkWeChat($("#txtwechataccount").val()))
		  	{
			 	$("#div_weichat").addClass("has-error");
			  	bRet4=false;
			  	return;
		  	}
		  	else
		  	{
		  		$("#div_weichat").removeClass("has-error");
		  		$("#div_weichat").addClass("has-success");
		  		bRet4=true;
		  		return;
		  	}
		  });*/
		  //[登录密码]文本框失去焦点
		  /*$("#txtpassword").blur(function(){
		  	//在这里操作 登录密码文本框失去焦点
		  	if(!$("#txtpassword").val())
		  	{
		  		$("#div_password").addClass("has-error");
		  		bRet5=false;
		  		return;
		  	}
		  	else if($("#txtpassword").val().length<6)
		  	{
		  		$("#div_password").addClass("has-error");
		  		bRet5=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_password").removeClass("has-error");
		  		$("#div_password").addClass("has-success");

		  		bRet5=true;
		  		return;
		  	}
		  });*/
		  //[再次设置登录密码]文本框失去焦点
		  /*$("#txtrepassword").blur(function(){
		  	//在这里操作 再次设置登录密码 文本框失去焦点
		  	if(!$("#txtrepassword").val())
		  	{
		  		$("#div_repassword").addClass("has-error");
		  		bRet6=false;
		  		return;
		  	}
		  	else if($("#txtrepassword").val().length<6)
		  	{
		  		$("#div_repassword").addClass("has-error");
		  		bRet6=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_repassword").removeClass("has-error");
		  		$("#div_repassword").addClass("has-success");
		  		
			  	if($("#txtpassword").val()!=$("#txtrepassword").val())
			  	{
			  		alert("两次输入的密码不相同");
			  		bRet6=false;
			  		return;
			  	}
		  		bRet6=true;
		  		return;
		  	}
		  });*/
		  //[下一步]按钮点击
		  $("#btnStep1").click(function(){
			//在这里操作 [下一步]按钮点击
			if(!checkData())
			{
				//数据校验错误
				return false;
			}
			else 
			{
				////数据校验正确
				//location.href='step2';
				return true;
			}	
		  });
		});
	</script>
    
    
    <style type="text/css">
    .container-fluid
    {
        margin: 15px;
    }
	.btn-code
	{
		font-size: 12px;
		padding: 6px 0px;
		height: 34px;
	}
	.breadcrumb
	{
		background-color: #cccccc;
		font-size: 12px;
	}

    </style>
</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
		<#if (isreg?exists)>
			<center>您已经注册过，请勿重新注册。</center>
		<#else>
			<ol class="breadcrumb">
				<label style="color:green;">1.输入手机号</label>&nbsp;&nbsp;>&nbsp;&nbsp;<label>2.身份信息填写</label>&nbsp;&nbsp;>&nbsp;&nbsp;<label>3.设置密码</label>
			</ol>
			
		    <div class="container-fluid">
		        <form action="reg_step1_postdata" method="post">
	    	       <div class="input-group" id="div_phonenum">
	                    <span class="input-group-addon" id="txtnum">+86</span>
	                    <input type="text" class="form-control" id="txtphonenum" name="txtphonenum" aria-describedby="txtnum" placeholder="请输入联通手机号">
	                </div><!-- /input-group -->
		            <br/>
		            <!--输入验证码-->
		            <div class="row">
		                <div class="col-xs-7 col-sm-7 col-md-7">
				            <div class="form-group" id="div_yanzhengma">
				                <label for="txtyanzhengma" class="sr-only"></label>
				                <input type="text" class="form-control" id="txtyanzhengma" name="txtyanzhengma" placeholder="请输入验证码" disabled='true'>
				            </div>
		                </div>
		                <div class="col-xs-5 col-sm-5 col-md-5">
		                    <button class="btn-primary btn-block btn btn-code" type="button" id="btnCode">获取验证码</button>
		                </div>
		            </div>
		            
		            <div class="input-group">
		                <span class="input-group-addon" id="sizing-addon2">地区</span>
		                <select name="selArea" id="selArea" class="form-control" placeholder="请选择地区" aria-describedby="sizing-addon2">
			      		<option value="请选择您所在的地区">请选择您所在的地区</option>
			      		<#if (cityList?size==0)>
							<option value="数据加载失败">数据加载失败</option>
			        	<#else>
							<#list cityList as item>
								<option value="${item.city_code}">${item.city_name}</option>
							</#list>
			 			</#if>
		                </select>
		            </div>
		            <br/>
		            <!--输入微信号-->
		            <!-- <div class="form-group" id="div_weichat">
		                <label for="txtwechataccount" class="sr-only"></label>
		                <input type="text" class="form-control" id="txtwechataccount" name="txtwechataccount" placeholder="请输入微信号(选填)">
		            </div> -->
		            <!--输入密码-->
		            <!-- <div class="form-group" id="div_password">
		                <label for="txtpassword" class="sr-only">Password</label>
		                <input type="password" class="form-control" id="txtpassword" name="txtpassword" placeholder="请设置登录密码(至少6位)">
		            </div> -->
		            <!--再次输入验证码-->
		            <!-- <div class="form-group" id="div_repassword">
		                <label for="txtrepassword" class="sr-only">Password</label>
		                <input type="password" class="form-control" id="txtrepassword" name="txtrepassword" placeholder="请再次设置登录密码(至少6位)">
		            </div> -->
		            <input type="hidden" value='${openid}' id="hide_openid" name="hide_openid">
		            <input type="hidden" value='' id="hide_code_date" name="hide_code_date">
		            <div style="float:right;font-size: 14px;">
						<a href="${base}/auth/login" style="color:blue"><u>已有帐号去登录</u></a>
					</div>
					<br/>
					<br/>
		            <button class="btn-warning btn-block btn" type="submit" id="btnStep1" name="btnStep1">下一步</button>
		            <br/>
					<!-- 用户注册协议 -->
					<div style="float:left;font-size: 14px;">
						<input type="checkbox" name="chkRight" id="chkRight" checked="true">我已阅读并同意 &nbsp;&nbsp;<a href="regProtocol" style="color:green">用户注册协议</a>
					</div>
		        </form>
		    </div>
		</#if>

	</div>
</body>
</html>