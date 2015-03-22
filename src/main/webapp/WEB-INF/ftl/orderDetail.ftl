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
    <![endif]-->
    <style type="text/css">
        .orderinfo
        {
            margin: 15px;
            font-size: 12px;
        }
    </style>
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
        <div class="orderinfo">
            <div class="list-group">
                <a href="#" class="list-group-item">订单编号：${ORDER_ID}</a>
                <a href="#" class="list-group-item">订单金额：${INCOME_MONEY}元</a>
                <a href="#" class="list-group-item">下单时间：${Order_Time}</a>
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item">收货人姓名：${RECEIVER_NAME}</a>
                <a href="#" class="list-group-item">收获地址：${POST_ADDR} </a>
                <a href="#" class="list-group-item">联系电话：${MOBILE_PHONE} </a>
                <a href="#" class="list-group-item">送货日：${DELIVER_TIME_CODE}</a>
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item">支付方式：${PAY_MODE}</a>
                <a href="#" class="list-group-item">订单状态：${PAY_STATE}</a>
                <a href="#" class="list-group-item">缺货处理：${PAY_REMARK}</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>

</body>
</html>