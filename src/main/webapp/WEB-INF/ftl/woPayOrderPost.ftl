<!DOCTYPE html>
<html>
<head lang="zh-cn">
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
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
    <script type="text/javascript">

		$(document).ready(function(){  
            $("#btnajaxSubmit").click(function(){  
        		var parms = {'userid':'${hideuserid}','fromPage':'${fromPage}'};
        		$.commonFormSubmit({
           		 type: "POST",
        		 action: '${base}/pay/woPay/payReq/${order_id}/${fee}',
        		 success: function(data){
        		  	 //history.back();
        		  	 //alert("ok");
        		  	 //return;
        		  	 alert(data);
        		  	 //$("#wopay_div").append(data);
        		  	 return;
        		 }
        		});
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
        </div> <!-- /container -->
        <div id="wopay_div">
        </div>
        <form method=post action="http://123.125.97.67:8802/sy2_mini24_cs/httpservice/wapPayPageAction.do?reqcharset=UTF-8">
        	<textarea class="form-control" rows="23" name="param" id="param">${postdata}</textarea>
        	<button class="btn btn-warning btn-block" type="submit" name="btnSubmit" id="btnSubmit">提交</button>
        </form>
        <button class="btn btn-warning btn-block" type="submit" name="btnajaxSubmit" id="btnajaxSubmit">ajax提交</button>
    </div>
</body>
</html>