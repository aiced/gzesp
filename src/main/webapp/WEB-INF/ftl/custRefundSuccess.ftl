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
        .div1
        {
            text-align: center;
            margin-top: 100px;
            margin-bottom: 10px;
        }
        .div2
        {
            text-align: center;
            margin: 10px;
        }
        .div3
        {
            color: #666666;
            margin: 20px;
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
        <div class="div1">
            <img src="${resRoot}/image/custRefund/right.png" width="64" height="64">
        </div>
        <div class="div2">
            <label>退款申请已提交！</label>
        </div>
        <div class="div3">
           	 我们将于1-3个工作日完成审核内容，审核通过后，将短信通知您。
        </div>
        <br/>
        <br/>
        <div style="text-align: center;"><h5><a href="${base}/customer/custOrderDetail/${orderid}"><label><u>返回订单详情</u></label></a></h5></div>
        <input type="hidden" id="hide_orderid" name="hide_orderid" value='${orderid}'>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>

</html>