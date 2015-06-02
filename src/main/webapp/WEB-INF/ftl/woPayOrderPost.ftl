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
        	<textarea class="form-control" rows="23" name="param" id="param">303001300001639assigntype=0018$banktype=$callbackurl=http://localhost:8080/esp/payResult/woPay$expand=18551855717$expandone=$expandtwo=$goodsname=测试商品iphone6$idno=WU9aLguSDh7dw7PDkfbSxGftHObHA0QL$iptvflag=$loginname=文辉$merno=303001300001639$meruserid=9999999999999999$modifydesc=00$mp=2$name=0keYGzrlADU=$orderbalance=200$paybalance=200$respmode=1$servercallurl=http://www.baidu.com$signmsg=3e3bab54be5d0369df3a89819b05f6ea$storeindex=http://wap.woboss.gz186.com/esp/weShop/index/2015051408084496$storename=沃掌柜$storeorderid=3111111111111111$straighttype=0018$usefultime=$version=2.2.2$wostoretime=20150601172433</textarea>
        	<button class="btn btn-warning btn-block" type="submit" name="btnSubmit" id="btnSubmit">提交</button>
        </form>
        <button class="btn btn-warning btn-block" type="submit" name="btnajaxSubmit" id="btnajaxSubmit">ajax提交</button>
    </div>
</body>
</html>