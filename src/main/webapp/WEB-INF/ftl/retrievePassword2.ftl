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
</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
	    <div class="container">
	        <form action="#">
	            <br>
	            <br>
	            <!--输入密码-->
	            <div class="form-group">
	                <label for="txtpassword" class="sr-only">Password</label>
	                <input type="password" class="form-control" id="txtpassword" placeholder="请设置登录密码" required autofocus>
	            </div>
	            <!--再次输入验证码-->
	            <div class="form-group">
	                <label for="txtrepassword" class="sr-only">Password</label>
	                <input type="password" class="form-control" id="txtrepassword" placeholder="请再次设置登录密码"  required>
	            </div>
	            <br/>
	            <button class="btn btn-warning btn-block " type="submit" name="btnSubmit" id="btnSubmit">确认</button>
	        </form>
	    </div> <!-- /container -->
	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>

	<script type="text/javascript">
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
		  	if(!$("#txtpassword").val())
		  	{
				alert("请设置登录密码");
				return false;
		  	}
		  	if(!$("#txtrepassword").val())
		  	{
				alert("请在再次设设置登录密码");
				return false;
		  	}
		  	if($("#txtpassword").val()!=$("#txtrepassword").val())
		  	{
		  		alert("两次输入的密码不相同");
		  		return false;
		  	}
			return true;
		}
	
		$(document).ready(function(){  
		   //[提交]按钮点击
		  $("#btnSubmit").click(function(){  
			  //在这里操作提交
			  if(!checkData())
			  {
				  //
				  return false;
			  }
			  else
			  {
				  //提交操作
			  }

		  });

		});
	</script>
</body>
</html>