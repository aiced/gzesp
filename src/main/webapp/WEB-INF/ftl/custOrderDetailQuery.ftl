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
        .contain
        {
            margin: 10px;
        }
        .container_top
        {
            background-color: #ffffff;
            height: 100px;
        }
        .top_div
        {
            font-weight: bold;
            font-size: 16px;
            height: 30px;
            line-height: 30px;
        }
        .top_div_left
        {
            text-align: left;
            float: left;
            margin-left: 10px;

        }
        .top_div_right
        {
            text-align: right;
            float: right;
            margin-right: 10px;
        }
        .top_div_bottom
        {
            margin-left: 10px;
            margin-right: 10px;
            color: #666666;
        }
        .div_clear
        {
            clear: both;
        }
        .container_mid_1
        {
            background-color: #ffffff;
            height: 260px;
        }
        .container_mid_2
        {
            background-color: #ffffff;
            height: auto;
        }
        .container_bottom
        {
            background-color: #ffffff;
            height: 140px;
        }
        .div_line
        {
            height: 1px;
            background-color: #ededed;
            margin-top: 10px;
            margin-bottom: 10px;
        }
        .mid_1_div1
        {
            font-weight: bold;
            font-size: 14px;
            height: 30px;
            line-height: 30px;
        }
        .mid_1_div_left
        {
            float: left;
            text-align: left;
            margin-left: 10px;
        }
        .mid_1_div_right
        {
            float: right;
            text-align: right;
            margin-right: 10px;
            color: red;
        }
        .mid_1_div2
        {
            margin: 10px;
        }
        .mid_1_div3
        {
            margin: 10px;
        }
        .mid_1_div3_left
        {
            background-color: #204d74;
            float: left;
            width: 50%;
            text-align: center;
        }
        .mid_1_div3_right
        {
            background-color: #269abc;
            float: right;
            width: 50%;
            padding: 5px;
        }
        .mid_1_div4
        {
            margin-left: 10px;
            margin-top: 10px;
            font-weight: bold;
        }
        .mid_2_div1
        {
            font-weight: bold;
            font-size: 14px;
            height: 30px;
            line-height: 30px;
        }
        .mid_2_div_left
        {
            float: left;
            text-align: left;
            margin-left: 10px;
        }
        .mid_2_div_right
        {
            float: right;
            text-align: right;
            margin-right: 10px;
            color: green;
        }
        .mid_2_div2
        {
            margin: 20px;
            color: #666666;
        }
        .mid_2_div3
        {
            margin: 10px;
        }
        .mid_2_div3_left
        {
            float: left;
            width: 50%;
            text-align: left;
        }
        .mid_2_div3_right
        {
            float: right;
            width: 50%;
            text-align: right;
        }
        .mid_2_div4
        {
            margin: 20px;
            color: #666666;
            padding-bottom: 10px;
        }
        .bottom_1_div1
        {
            margin-left: 10px;
            margin-top: 10px;
            padding-top: 5px;
            font-weight: bold;
        }
        .bottom_1_div1_left
        {
            float: left;
            text-align: left;
            margin-left: 10px;
        }
        .bottom_1_div1_right
        {
            float: right;
            text-align: right;
            margin-right: 10px;
            color: red;
        }
        .bottom_1_div2
        {
            text-align: right;
            margin-right: 10px;
        }
        .bottom_1_div3
        {
            text-align: right;
            margin-right: 10px;
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
        <div class="contain">
            <div class="container_top">
                <div class="top_div">
                    <div class="top_div_left">${RECEIVER_NAME}</div>
                    <div class="top_div_right">${MOBILE_PHONE}</div>
                </div>
                <div class="div_clear"></div>
                <div class="top_div_bottom">${ADDRESS}</div>
            </div>
            <br/>
            <div class="container_mid_1">
                <div class="mid_1_div1">
                    <div class="mid_1_div_left">订单号：${ORDER_ID}</div>
                    <div class="mid_1_div_right">${ORDER_STATE}</div>
                </div>
                <div class="div_clear"></div>
                <div class="div_line"></div>
                <div class="mid_1_div2">
                    <img src="${imageRoot}${USER_IMG}" width="32" height="32">&nbsp;&nbsp;
                    <label>${STORE_NAME}</label>
                </div>
                <div class="mid_1_div3 media">
                    <div class="media-left media-middle">
                        <img src="${imageRoot}${PHOTO_LINKS}" width="96" height="96">&nbsp;&nbsp;
                    </div>
                    <div class="media-body">
                        <div><label>${GOODS_NAME}</label></div>
                        <div>
							<label></label>
                        	 <#if (ORDER_STATE_CODE=='00') || (ORDER_STATE_CODE=='02')>
	                            	<div style="text-align: center;border: 1px solid #91CA7D;float: right;width: 60px;color:#91CA7D"><a href="${base}/pay/selectPayMode/${ORDER_ID}/${TOPAY_MONEY*1000}">去支付</a></div>
		                     <#elseif (ORDER_STATE_CODE=='01')>
	                            	<div style="text-align: center;border: 1px solid #91CA7D;float: right;width: 60px;color:#91CA7D"><a href="../custRefund?orderid=${ORDER_ID}">退款</a></div>
		                     </#if>
                        	
                        </div>
                        <div class="div_clear"></div>
                        <br/>
                        <div>
                            <div style="float: left;color: #666666">${SALE_NUM}件</div>
                            <div style="float: right;color: red">￥${TOPAY_FEE}</div>
                        </div>
                    </div>
                </div>
                <div class="div_clear"></div>
                <div class="div_line"></div>
<!--                 <div class="mid_1_div4"> -->
<!--                    	 共1件商品 实付：5000元 -->
<!--                 </div> -->
            </div>
            <br/>
            <div class="container_mid_2">
                <div class="mid_2_div1">
                    <div class="mid_2_div_left">支付方式</div>
                    <div class="mid_2_div_right">${PAY_TYPE}</div>
                </div>
                <div class="div_clear"></div>
                <div class="div_line"></div>
                <div class="mid_2_div2">
                   	 物流公司：${EXPRESS_COMPNAY}
                </div>
                <div class="mid_2_div2">
                	物流单号：${EXPRESS_ID}
                </div>

                <div class="div_line"></div>
                <div class="mid_2_div3">
                    <div class="mid_2_div3_left">
                        <label>发票信息</label>
                    </div>
                    <div class="mid_2_div3_right">
                        <label>纸质发票</label>
                    </div>
                </div>
                <div class="div_clear"></div>
                <div class="mid_2_div4">
                    <div>发票抬头：${INVOCE_TITLE}</div>
                    <div>发票内容：${INVOCE_CONTENT}</div>
                </div>
            </div>
            <div class="container_bottom">
                <div class="bottom_1_div1">
                    <div class="bottom_1_div1_left">商品总额</div>
                    <div class="bottom_1_div1_right">￥${TOPAY_MONEY}</div>
                </div>
                <div class="div_clear"></div>
                <div class="bottom_1_div1">
                    <div class="bottom_1_div1_left">运费</div>
                    <div class="bottom_1_div1_right">￥${POST_FEE}</div>
                </div>
                <div class="div_clear"></div>
                <div class="div_line"></div>
                <div class="bottom_1_div2">
                    <label>实付款：</label><span style="color: red">${RECV_FEE}</span>
                </div>
                <div class="bottom_1_div3">
                   	 下单时间：${ORDER_TIME}
                </div>
            </div>
            <!-- <div>
                <div style="text-align: center;border: 2px solid #91CA7D;float: right;width: 60px;color:#91CA7D;margin-top: 10px;margin-right: 10px;margin-bottom:30px;background-color: #ffffff;font-size: 16px;">评价</div>
            </div> -->
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