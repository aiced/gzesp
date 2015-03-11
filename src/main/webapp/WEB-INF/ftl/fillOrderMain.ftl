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


    <style type="text/css">
        .div_contain
        {
            margin: 15px;
        }
        .list-group
        {
            font-size: 12px;
        }
        .list_gou
        {
            float: right;
            text-align: right;
        }
        .label-sm
        {
            margin-left: 20px;
            color: #c0c0c0;
        }
    </style>
</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
	    <div class="div_contain">
	        <div class="media">
	            <div class="media-left media-middle" style="background:#ffff00">
	                <a href="#">
	                    <img class="media-object" src="wo_logo.png" alt="64×64" width="64" height="64">
	                </a>
	            </div>
	            <div class="media-body">
	                <h4 class="media-heading">46元3G套餐 A/B计划</h4>
				                号码：13814023390(南京)<br/>
				                套餐：A类3G基本套餐64元挡<br/>
				                合约：存费送费<br/>
				                协议期：12<br/>
	            </div>
	        </div>
	        <br/>
	        <ul class="list-group">
	            <!--入网资料-->
	            <a href="#" class="list-group-item">
	                <label>入网资料</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	            <!--配送方式-->
	            <a href="#" class="list-group-item">
	                <label>配送方式</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	            <!--物流公司-->
	            <a href="#" class="list-group-item">
	                <label>物流公司</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	            <!--收获信息-->
	            <a href="#" class="list-group-item">
	                <label>收货信息</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	            <!--支付方式-->
	            <a href="#" class="list-group-item">
	                <label>支付方式</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	            <!--其他-->
	            <a href="#" class="list-group-item">
	                <label>其他</label><label class="label-sm">发票 代金券 备注 推荐人</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	        </ul>
	
	        <div class="list-group">
	            <a href="#" class="list-group-item">
	                <label class="label-sm">商品金额</label><span class="list_gou">￥199.00</span>
	            </a>
	            <a href="#" class="list-group-item">
	                <label class="label-sm">运费</label><span class="list_gou">+ ￥00.00</span>
	            </a>
	            <a href="#" class="list-group-item">
	                <label class="label-sm">代金券</label><span class="list_gou">- ￥00.00</span>
	            </a>
	            <a href="#" class="list-group-item">
	                <label class="label-sm">应付总额</label><span class="list_gou">￥199.00</span>
	            </a>
	        </div>
	        <br/>
	        <br/>
	        <br/>
	
	        <div style="font-size: 12px;text-align: center;"><a href="#"><u>为保障您的权益，下单请阅读并确定相关协议</u></a></div>
	        <br/>
	        <br/>
	        <br/>
	        <button class="btn btn-warning btn-block " type="submit">提交订单</button>
	    </div>
	</div>
</body>
</html>