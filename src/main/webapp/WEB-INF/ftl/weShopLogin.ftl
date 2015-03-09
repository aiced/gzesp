<!DOCTYPE html>
<html>
<head lang="zh-cn">
    <meta charset="utf-8">
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
    
    <style type="text/css">
        .forget_pwd{
            width: auto;
            height: 40px;
            vertical-align: middle;
            text-align: right;
            line-height: 40px;
            font-size: 12px;
        }
        .login_bottom{
            width:100%;
            position:absolute;
            bottom: 0;
            text-align: center;
        }
    </style>
</head>
<body>
    <div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
        <div class="container">
            <form class="form-signin">
                <br/>
                <br/>
                <label for="inputMobile" class="sr-only">输入手机号</label>
                <input type="text"  id="inputMobile"  class="form-control" placeholder="输入手机号"  required autofocus>
                <br/>
                <label for="inputPassword" class="sr-only">输入密码</label>
                <input type="password" id="inputPassword" class="form-control" placeholder="输入密码" required>
                <br/>
                <br/>
                <button class="btn btn-default btn-block" type="button" name="btnReg" id="btnReg" onClick="location.href='register/step1'">注册</button>
                <br/>
                <button class="btn btn-warning btn-block " type="submit" name="btnSubmit" id="btnSubmit">登录</button>
            </form>
            <br/>
            <div class="forget_pwd">
                <a href="findPassword/step1">忘记密码</a>
            </div>
        </div> <!-- /container -->
        <div class="login_bottom">
           <img src="${resRoot}/image/login/wo_logo.png" width="128px" height="128px">
        </div>
    </div>
    
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    	<script type="text/javascript">
		$(document).ready(function(){  
		   //[登录]按钮点击
		  $("#btnSubmit").click(function(){  
		  //在这里操作登录按钮逻辑
		  	//alert("点击登录");
		  	///shopManage/weShopHome
		  	location.href = "../shopManage/weShopHome";
		  });  
		});
	</script>
    
</body>
</html>