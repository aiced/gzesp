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
    
        <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
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
    
		$(document).ready(function(){  
		  if($("#hideRet").val()!="")
		  {
			 alert($("#hideRet").val()); 
		  }

		
		   //[登录]按钮点击
		  $("#btnSubmit").click(function(){  
		  	//在这里操作登录按钮逻辑
			var bRet=isPhoneNum($("#inputMobile").val());
			if(!bRet)
			{
				alert("手机号格式不对，请重新输入。");
				return false
			}
			else
			{
				return true;
			}
		  }); 
		});
	</script>
    
    <style type="text/css">
    	.login{
    		height: 40px;
            vertical-align: middle;
			float:left;
			text-align=center;
            line-height: 40px;
            font-size: 12px;
    	}
        .forget_pwd{
            width: auto;
            height: 40px;
            vertical-align: middle;
            float:right;
            line-height: 40px;
            font-size: 12px;
        }
        .login_bottom{
            width:100%;
            position:absolute;
            bottom: 5%;
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
        	<div id="top_right"></div></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
        <div class="container">
            <form class="form-signin" action="checklogin" method="post">
                <br/>
                <br/>
                <label for="inputMobile" class="sr-only">输入手机号</label>
                <input type="text"  id="inputMobile" name="inputMobile" class="form-control" placeholder="输入手机号"  required autofocus>
                <br/>
                <label for="inputPassword" class="sr-only">输入密码</label>
                <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="输入密码" required>
                <br/>
                <br/>
                <button class="btn btn-warning btn-block " type="submit" name="btnSubmit" id="btnSubmit">登录</button>
            </form>
            <div>
            	<div class="login">
            		<a name="btnReg" id="btnReg" href="register/step1">注册</a>
            	</div>
                <div class="forget_pwd">
                	<a href="findPassword/step1">忘记密码</a>
            	</div>
            </div>

        </div> <!-- /container -->
        <div class="login_bottom">
           <img src="${resRoot}/image/login/wo_logo.png" width="92px" height="92px">
        </div>
		<input type="hidden" name="hideRet" id="hideRet" value="${ret}" />  
    </div>
    
    

    
</body>
</html>