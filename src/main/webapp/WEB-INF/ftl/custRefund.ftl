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
        .top_container
        {
            margin:30px 10px 10px 10px;
            height: 100px;
        }
        .top_container div{
            font-size: 12px;
            padding: 2px;
        }
        .mid_container
        {
            margin:30px 5px 5px 5px;
            font-size: 14px;
        }
        .div1
        {
            float: left;
            width: 10%;
            height: 34px;
            line-height: 34px;
        }
        .div2
        {
            float: left;
            width: 111px;
            height: 34px;
            line-height: 34px;
        }
        .div3
        {
            float: left;
            width: 50%;
        }
        .div_clear
        {
            clear: both;
        }
        .divstart
        {
            text-align: center;
            margin: 20px;
            color: #666666;
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
	    <div class="container-fluid">
	        <form>
	            <div class="top_container">
	                <div>订单编号：1111111111</div>
	                <div>退款金额：120元</div>
	                <div style="font-weight: bolder">退款方式：</div>
	                <div>原路返回（按照您原来支付的方式进行原来退回退款）</div>
	            </div>
	            <div class="mid_container">
	                <div class="input-group">
	                    <div class="div1"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16"></div>
	                    <div class="div2">申请人姓名：</div>
	                    <div class="div3"> <input type="text" class="form-control" id="txtname" placeholder="请输入姓名"></div>
	                </div>
	                <br/>
	                <div class="input-group">
	                    <div class="div1"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16"></div>
	                    <div class="div2">手机号码：</div>
	                    <div class="div3"><input type="text" class="form-control" id="txtphone" placeholder="请输入手机号"></div>
	                </div>
	                <br/>
	                <div class="input-group">
	                    <div class="div1"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16"></div>
	                    <div class="div2">退款原因：</div>
	                    <div class="div3"><input type="text" class="form-control" id="txtreason" placeholder="请退款原因"></div>
	                </div>
	            </div>
	            <div class="div_clear"></div>
	            <div class="divstart"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16">为必填选项</div>
	            <br/>
	            <br/>
	            <button class="btn btn-warning btn-block " type="submit">提交申请</button>
	        </form>
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