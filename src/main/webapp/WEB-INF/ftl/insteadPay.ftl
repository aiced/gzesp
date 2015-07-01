<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>支付</title>
    
    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/myacct.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/buttonStyle.css?v=${resVer}" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
	
</head>
<body>
    <!--top_start-->
    <div id="top">
        <!--	<div style="float:left;width:20%;height:40px;font-size:14px;"></div> -->
        <div id="top_left"></div>
        <div id="top_middle">支付</div>
        <div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
    <div class="div_container_top">
        <label>选择支付方式</label>
    </div>
    <div class="div_container_top1">
        <div class="div_container_top2">
            <img src=""><span class="sp1">代金券</span><span class="sp2">你有5张优惠券<img src="jiantou.png" width="9" height="20"></span>
        </div>
        <div class="dv_clear"></div>
        <div class="div_line"></div>
        <div class="dv_clear"></div>
        <div class="div_container_top2">
            <img src=""><span class="sp1">微账户 <span>可用余额200</span></span><span class="sp2"><img src="jiantou.png" width="9" height="20"></span>
        </div>
    </div>
    <div class="div_container_top">
        <label>还需支付120</label>
    </div>
    <div class="div_container_top1">

    </div>
    <div class="div_container_top">
    </div>
    <div class="div_container_top3">
        <span class="sp3">实付款</span>
        <span class="sp4">￥333.00</span>
    </div>

    <div class="div_container">
        <button class="btn btn-warning btn-block " type="submit" data-toggle="modal" data-target="#myModal">确认支付</button>
    </div>
</body>
</html>