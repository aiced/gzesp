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
	
		var bRet1=false;
		var bRet2=false;

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
			return true;
		}
	
		$(document).ready(function(){  
		  $("#txtpassword").focus();
		  
		  //[登录密码]文本框失去焦点
		  $("#txtpassword").blur(function(){
		  	//在这里操作 登录密码文本框失去焦点
		  	if(!$("#txtpassword").val())
		  	{
		  		$("#div_password").addClass("has-error");
		  		bRet1=false;
		  		return;
		  	}
		  	else if($("#txtpassword").val().length<6)
		  	{
		  		$("#div_password").addClass("has-error");
		  		bRet1=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_password").removeClass("has-error");
		  		$("#div_password").addClass("has-success");

		  		bRet1=true;
		  		return;
		  	}
		  });
		  //[再次设置登录密码]文本框失去焦点
		  $("#txtrepassword").blur(function(){
		  	//在这里操作 再次设置登录密码 文本框失去焦点
		  	if(!$("#txtrepassword").val())
		  	{
		  		$("#div_repassword").addClass("has-error");
		  		bRet2=false;
		  		return;
		  	}
		  	else if($("#txtrepassword").val().length<6)
		  	{
		  		$("#div_repassword").addClass("has-error");
		  		bRet2=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_repassword").removeClass("has-error");
		  		$("#div_repassword").addClass("has-success");
		  		
			  	if($("#txtpassword").val()!=$("#txtrepassword").val())
			  	{
			  		alert("两次输入的密码不相同");
			  		bRet2=false;
			  		return;
			  	}
			  	bRet2=true;
		  		return;
		  	}
		  });
		  //[下一步]按钮点击
		  $("#btnStep3").click(function(){
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
		<ol class="breadcrumb">
			<label style="color:green;">1.输入手机号</label>&nbsp;&nbsp;>&nbsp;&nbsp;<label style="color:green;">2.身份信息填写</label>&nbsp;&nbsp;>&nbsp;&nbsp;<label style="color:green;">3.设置密码</label>
		</ol>
		
	    <div class="container-fluid">
	        <form action="reg_step3_postdata" method="post">
    	      
	            <!--输入密码-->
	            <div class="form-group" id="div_password">
	                <label for="txtpassword" class="sr-only">Password</label>
	                <input type="password" class="form-control" id="txtpassword" name="txtpassword" placeholder="请设置登录密码(至少6位)">
	            </div>
	            <!--再次输入验证码-->
	           	<div class="form-group" id="div_repassword">
	                <label for="txtrepassword" class="sr-only">Password</label>
	                <input type="password" class="form-control" id="txtrepassword" name="txtrepassword" placeholder="请再次设置登录密码(至少6位)">
	            </div>
	            <br/>
	            <input type="hidden" value='${openId}' id="hide_openid" name="hide_openid">
	            <button class="btn-warning btn-block btn" type="submit" id="btnStep3" name="btnStep3">提交</button>
	            
	            <input type="hidden" name="selArea" value="${area}" />
	        	<input type="hidden" name="txtphonenum" value="${phonenum}" />
				<input type="hidden" name="txtopenid" value="${openid}" />
				
				
	        	
	            <input type="hidden" name="wecharaccount" value="${wecharaccount}" />
	        	<input type="hidden" name="name" value="${name}" />
	        	<input type="hidden" name="sex" value="${sex}" />
	            <input type="hidden" name="personalId" value="${personalId}" />

	            <br/>
	        </form>
	    </div>
	</div>
</body>
</html>