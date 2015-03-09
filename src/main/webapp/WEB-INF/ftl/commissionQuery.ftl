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
        .row
        {
            /*margin: 15px;*/
            padding: 10px;
        }
        .query_info_top
        {
            background: #ffffff;
            height:50px;
        }
        .query_info_detail
        {
            font-size: 12px;
            background: #ffffff;
        }
        .query_info_bottom
        {
            font-size: 12px;
            background: #ffffff;
            margin-top: 15px;
        }
        h5
        {
            padding-top: 15px;
            margin-left: 10px;
        }
        .query_info_left
        {
            float: left;
        }
        .query_info_right
        {
            float: right;
        }
        .query_info_top_left
        {
            width:20%;
            float: left;
            font-size: 12px;
            height: 34px;
            line-height: 34px;
            margin-top: 7px;
            margin-left: 7px;
        }
        .query_info_top_middle
        {
            width:50%;
            float: left;
            margin-top: 7px;
        }
        .query_info_top_right
        {
            width:20%;
            float: left;
            margin-top: 7px;
            margin-left: 7px;
        }
        .query_info_top_clear
        {
            clear:both;;
        }
        .btn
        {
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

	    <form>
	        <div>
	            <div class="query_info_top">
	                <div class="query_info_top_left"><label>佣金帐期</label></div>
	                <div class="query_info_top_middle">
	                    <select class="form-control">
	                        <option>2015年1月</option>
	                        <option>2015年2月</option>
	                        <option>2015年3月</option>
	                        <option>2015年4月</option>
	                        <option>2015年5月</option>
	                    </select>
	                </div>
	                <div class="query_info_top_right">
	                    <button class="btn btn-warning btn-block" type="submit">查询</button>
	                </div>
	            </div>
	            <div class="query_info_top_clear"></div>
	        </div>
	    </form>
	    <div class="query_info_detail">
	        <h5><label>当月佣金明细</label></h5>
	        <table class="table table-hover table-striped table-condensed">
	            <tr>
	                <th>序号</th>
	                <th>商品名称</th>
	                <th>订单号</th>
	                <th>销售金额</th>
	                <th>佣金</th>
	            </tr>
	            <tr>
	                <td>1</td>
	                <td>iphone6</td>
	                <td>abc110</td>
	                <td>5288</td>
	                <td>50</td>
	            </tr>
	            <tr>
	                <td>2</td>
	                <td>iphone6</td>
	                <td>abc110</td>
	                <td>5288</td>
	                <td>50</td>
	            </tr>
	            <tr>
	                <td>3</td>
	                <td>iphone6</td>
	                <td>abc110</td>
	                <td>5288</td>
	                <td>50</td>
	            </tr>
	            <tr>
	                <td>4</td>
	                <td>iphone6</td>
	                <td>abc110</td>
	                <td>5288</td>
	                <td>50</td>
	            </tr>
	        </table>
	        <div class="row">
	            <div class="col-xs-9 col-sm-9">
	                <label class="query_info_left" placeholder=".col-xs-9 col-sm-9">合计</label>
	            </div>
	            <div class="col-xs-3 col-sm-3">
	                <label class="query_info_right" placeholder=".col-xs-3 col-sm-3">200</label>
	            </div>
	        </div>
	    </div>
	    <div class="query_info_bottom">
	        <div class="row">
	            <div class="col-xs-9 col-sm-9">
	                <label class="query_info_left" placeholder=".col-xs-9 col-sm-9">截至当前佣金累计金额</label>
	            </div>
	            <div class="col-xs-3 col-sm-3">
	                <label class="query_info_right" placeholder=".col-xs-3 col-sm-3">200</label>
	            </div>
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