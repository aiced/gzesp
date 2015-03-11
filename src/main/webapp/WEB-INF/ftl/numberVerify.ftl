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
    <style type="text/css">
        .btn{
            padding: 1px 5px;
            font-size: 12px;
            line-height: 1.5;
        }
    </style>
</head>
<body>

	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
    	<div class="container">
        	<form>
            <br>
            <br>
            <div class="row">
                <div class="col-xs-8 col-sm-8">
                    <input type="text" class="form-control" id="txtphonenum"aria-describedby="txtnum" placeholder="请输入联通手机号"  required autofocus>
                </div>
                <div class="col-xs-4 col-sm-4">
                    <button class="btn btn-primary btn-block form-control" type="button" name="btnCode" id="btnCode">获取验证码</button>
                </div>
            </div>
            <br>
            <!--输入验证码-->
            <div class="form-group">
                <label for="yanzhengma" class="sr-only"></label>
                <input type="text" class="form-control" id="yanzhengma" placeholder="请输入验证码"  required>
            </div>
            <br/>
            <button class="btn-sm btn-warning btn-block" type="button" id="btnSubmit" onClick="">提交校验</button>
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
		$(document).ready(function(){  
		   //[获取验证码]按钮点击
		  $("#btnCode").click(function(){  
		  //在这里操作获取验证码操作
		  	//location.href = "weShopSet";
		  });
		});
	</script>
</body>
</html>