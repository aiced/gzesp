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

    <!--日历控件css-->
	<link href="${resRoot}/css/date_common.css?v=${resVer}" rel="stylesheet">
    
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

    <!--日历控件js-->
    <script src="${resRoot}/js/date.js?v=${resVer}"></script>
    <script src="${resRoot}/js/date_iscroll.js?v=${resVer}"></script>
    <script type="text/javascript">
        $(function(){
            $('#beginTime').date();
            $('#endTime').date();
        });
    </script>

    <style type="text/css">
        .order_top
        {
            height:50px ;
            margin: 10px;
        }
        .order_top_left
        {
            float: left;
            width: 20%;
            font-size: 12px;
            height: 34px;
            line-height: 34px;
        }
        .order_top_middle
        {
            float: left;
            width: 55%;
            text-align: center;
            margin-left: 5px;
            margin-right: 5px;
        }
        .order_top_middle1
        {
            float: left;
            width: 40%;
        }
        .order_top_middle2
        {
            float: left;
            width: 20%;
            line-height: 34px;
        }
        .order_top_middle3
        {
            float: left;
            width: 40%;
        }
        .order_top_right
        {
            float: right;
            width: auto;
        }
        .div_clear
        {
            clear:both;
        }
        input
        {
            width: 70px;
            font-size: 12px;
            height: 34px;
        }
        .div_line
        {
            height: 1px;
            background: #e6e6e6;
            margin-top: 20px;
        }
        .order_middle
        {
            background: #ffffff;
            height: 110px;
            margin: 15px;
            font-size: 12px;
        }
        .order_contain
        {
            margin: 3px;
        }
        .order_contain_top
        {
            height: 20px;
        }
        .order_contain_title
        {
            float: left;
            overflow: hidden;
            text-overflow: ellipsis;
            white-space: nowrap;
            width:180px;
            margin-top: 5px;
        }
        .order_contain_statue
        {
            float: right;
            width: 40px;
            height: 20px;
            border: 1px solid #ff7878;
            color: #ff7878;
            margin-top: 5px;
        }
        .order_line
        {
            height: 1px;
            background: #ededed;
            margin-top: 5px;
            margin-bottom: 5px;
        }
        .order_contain_middle
        {
        }
        .order_contain_middle_left
        {
            float: left;
            background: #66512c;
        }
        .order_contain_middle_middle
        {
            float: left;
            margin-left: 5px;
            margin-top: 8px;
        }
        .order_contain_middle_right
        {
            float: right;
            height:65px;
            line-height: 65px;
            margin-right: 10px;
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
        <div  class="order_top">
            <div class="order_top_left"><label>订单时间</label></div>
            <div class="order_top_middle">
                <div class="order_top_middle1">
                    <!--<input type="text" id="txtdatefrom" class="form-control">-->
                    <input  id="beginTime" class="kbtn" />
                </div>
                <div class="order_top_middle2">
                    —
                </div>
                <div class="order_top_middle3">
                    <!--<input type="text" id="txtdateto" class="form-control">-->
                    <input  id="endTime" class="kbtn" />
                </div>
                <div id="datePlugin"></div>
            </div>
            <div class="order_top_right">
                <button class="btn btn-warning btn-block" type="submit">查询</button>
            </div>
            <div class="div_clear"></div>
            <div class="div_line"></div>
        </div>
        <div class="div_clear"></div>

        <div order_queryinfo>
            <div class="order_middle">
                <div class="order_contain">
                    <div class="order_contain_top">
                        <div class="order_contain_title">苹果最新手机iphone6 4.7寸大屏幕 超强性能处理器</div>
                        <div class="order_contain_statue">已处理</div>
                    </div>
                    <div class="div_clear"></div>
                    <div class="order_line"></div>
                    <div class="order_contain_middle">
                        <div class="order_contain_middle_left">
                            <img src="${resRoot}/image/login/wo_logo.png" width="50" height="65">
                        </div>
                        <div class="order_contain_middle_middle">
                            <div>订单编号：20101010101010100000</div>
                            <div>订单金额：5288元</div>
                            <div>下单时间：2015.2.8 15：00</div>
                        </div>

                        <div class="order_contain_middle_right">
                            <img src="${resRoot}/image/orderQuery/jiantou.png" width="9" height="15">
                        </div>
                        <div class="div_clear"></div>
                    </div>
                </div>
            </div>
            <div class="order_middle">
                <div class="order_contain">
                    <div class="order_contain_top">
                        <div class="order_contain_title">苹果最新手机iphone6 4.7寸大屏幕 超强性能处理器</div>
                        <div class="order_contain_statue">已处理</div>
                    </div>
                    <div class="div_clear"></div>
                    <div class="order_line"></div>
                    <div class="order_contain_middle">
                        <div class="order_contain_middle_left">
                            <img src="wo_logo.png" width="50" height="65">
                        </div>
                        <div class="order_contain_middle_middle">
                            <div>订单编号：20101010101010100000</div>
                            <div>订单金额：5288元</div>
                            <div>下单时间：2015.2.8 15：00</div>
                        </div>

                        <div class="order_contain_middle_right">
                            <img src="${resRoot}/image/orderQuery/jiantou.png" width="9" height="15">
                        </div>
                        <div class="div_clear"></div>
                    </div>
                </div>
            </div>
            <div class="order_middle">
                <div class="order_contain">
                    <div class="order_contain_top">
                        <div class="order_contain_title">苹果最新手机iphone6 4.7寸大屏幕 超强性能处理器</div>
                        <div class="order_contain_statue">已处理</div>
                    </div>
                    <div class="div_clear"></div>
                    <div class="order_line"></div>
                    <div class="order_contain_middle">
                        <div class="order_contain_middle_left">
                            <img src="wo_logo.png" width="50" height="65">
                        </div>
                        <div class="order_contain_middle_middle">
                            <div>订单编号：20101010101010100000</div>
                            <div>订单金额：5288元</div>
                            <div>下单时间：2015.2.8 15：00</div>
                        </div>

                        <div class="order_contain_middle_right">
                            <img src="${resRoot}/image/orderQuery/jiantou.png" width="9" height="15">
                        </div>
                        <div class="div_clear"></div>
                    </div>
                </div>
            </div>
            <div class="order_middle">
                <div class="order_contain">
                    <div class="order_contain_top">
                        <div class="order_contain_title">苹果最新手机iphone6 4.7寸大屏幕 超强性能处理器</div>
                        <div class="order_contain_statue">已处理</div>
                    </div>
                    <div class="div_clear"></div>
                    <div class="order_line"></div>
                    <div class="order_contain_middle">
                        <div class="order_contain_middle_left">
                            <img src="wo_logo.png" width="50" height="65">
                        </div>
                        <div class="order_contain_middle_middle">
                            <div>订单编号：20101010101010100000</div>
                            <div>订单金额：5288元</div>
                            <div>下单时间：2015.2.8 15：00</div>
                        </div>

                        <div class="order_contain_middle_right">
                            <img src="${resRoot}/image/orderQuery/jiantou.png" width="9" height="15">
                        </div>
                        <div class="div_clear"></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>