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
        .head_top
        {
            height: 100px;
            background: #f66326;
            color: #ffffff;
        }
        .head_bottom
        {
            height: 40px;
            background: #ffffff;
        }
        .head_bottom_show{
            float: right;
            margin-top: 10px;
        }
        .head_bottom_line
        {
            float:right;
            background: #cccccc;
            width: 1px;
            height: 30px;
            margin: 5px;
        }
        .head_bottom_share{
            float: right;
            margin-top: 10px;
            margin-right:15px ;
        }
        .head_user
        {
            width: 90px;
            height: 90px;
            top:100px;
            left:15px;
            position:absolute;
        }
        .head_title
        {
            margin-left: 15px;
            margin-top: 15px;
            margin-bottom: 15px;
        }
        .detail_info
        {
            margin: 15px;
            background: #ffffff;
        }
        .yesterday_view
        {
            font-size:5px;
            color: #9EC7FF;
        }
        .month_view
        {
            font-size:5px;
            color:#759EE7;
        }
        .total_view
        {
            font-size:5px;
            color:#385B8A;
        }
        .yesterday_sale
        {
            font-size:5px;
            color:#ffB878
        }
        .month_sale
        {
        	font-size:5px;
            color:#DB9A5F;
        }
        .total_sale
        {
            font-size:5px;
            color:#96653A;
        }

        .yesterday_money
        {
            font-size:5px;
            color:#ff7878;
        }
        .month_money
        {
            font-size:5px;
            color:#ce4141;
        }
        .total_money
        {
            font-size:5px;
            color: #742525;
        }
        .list-group
        {
            margin: 15px;
        }
        .list_gou
        {
            float: right;
            text-align: right;
        }
        .head_top_logo
        {
            margin-left: 20px;
            padding-top: 10px;
        }
        .head_top_info
        {
            height: 100%;
            margin-left: 120px;
        }
        .head_top_info_details
        {
            margin-left: 10px;
        }
        .shopname
        {
            font-size: 18px;
            font-weight: bold;
            padding: 1px;
        }
        .shoptel,.shopweixin
        {
            font-size: 12px;
            padding: 1px;
        }
    </style>
</head>
<body>
	<div>
	    <div>
	    	<!--top_start-->
	        <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
	        </div>
			<div id="dv_clear"></div>
			<!--top_end-->
	        <div>
	            <div class="head_top">
	                <div class="head_top_logo">
	                    <img src="${resRoot}/image/shopHome/wo_logo_white.png" width="65" height="20"/>
	                </div>
	                <div class="head_top_info">
	                    <div class="head_top_info_details">
	                        <div class="shopname">${name}</div>
	                        <div class="shoptel"><img src="${resRoot}/image/shopHome/tel.png" width="16" height="16"/>&nbsp;&nbsp;${phone}</div>
	                        <div class="shopweixin"><img src="${resRoot}/image/shopHome/weixin.png" width="16" height="16"/>&nbsp;&nbsp;${weixin}</div>
	                    </div>
	                </div>
	            </div>
	            <div class="head_bottom">
	                <div class="head_bottom_share"><img src="${resRoot}/image/shopHome/shopshare.png" width="24" height="24">店铺分享</div>
	                <div class="head_bottom_line"></div>
	                <div class="head_bottom_show"><img src="${resRoot}/image/shopHome/shoppreview.png" width="24" height="24">复制链接</div>
	            </div>
	            <div class="head_user"><img src="${resRoot}/image/shopHome/head.png" alt="头像" class="img-circle" width="90" height="90"></div>
	        </div>
	        <div class="head_title">
	           <div style="width:8px;height: 20px;background: #CFCFCF;float: left;margin-right:5px;"></div> 店铺发展信息
	        </div>
	        <div class="detail_info">
	            <table class="table table-striped table-condensed">
	                <tr>
	                	<#if viewcountlist?size==0>
		                    <td class="yesterday_view">昨日访问：0</td>
		                    <td class="month_view">本月访问：0</td>
		                    <td class="total_view">累计访问：0</td>	                		
		                <#else>
	                		<#list viewcountlist as item>
	                	    	<td class="yesterday_view">昨日访问：${item.visitDay}</td>
	                    		<td class="month_view">本月访问：${item.visitMonth}</td>
	                    		<td class="total_view">累计访问：${item.visitTotal}</td>
	                		</#list>
	                	</#if>
					</tr>

	                <tr>
	                	<#if saleList?size==0>
		                    <td class="yesterday_sale">昨日销售：0</td>
		                    <td class="month_sale">本月销售：0</td>
		                    <td class="total_sale">累计销售：0</td>	                		
		                <#else>
	                		<#list saleList as item>
	                	    	<td class="yesterday_sale">昨日销售：${item.yesterday_count}</td>
	                    		<td class="month_sale">本月销售：${item.month_count}</td>
	                    		<td class="total_sale">累计销售：${item.total_count}</td>
	                		</#list>
	                	</#if>
					</tr>
					<tr>
	                	<#if viewcountlist?size==0>
		                    <td class="yesterday_view">昨日佣金：0</td>
		                    <td class="month_view">本月佣金：0</td>
		                    <td class="total_view">累计佣金：0</td>	                		
		                <#else>
	                		<#list viewcountlist as item>
	                	    	<td class="yesterday_money">昨日佣金：${item.visitDay}</td>
	                    		<td class="month_money">本月佣金：${item.visitMonth}</td>
	                    		<td class="total_money">累计佣金：${item.visitTotal}</td>
	                		</#list>
	                	</#if>
					</tr>
	
	            </table>
	        </div>
	        <div class="list-group">
	            <a href="goodsManageRecommend?userid=${userid}" class="list-group-item">商品管理 <span class="list_gou"><img src="${resRoot}/image/shopHome/jiantou.png" width="9" height="15"></span></a>
	            <a href="ordersQuery?userid=${userid}" class="list-group-item">订单查询 <span class="list_gou"><img src="${resRoot}/image/shopHome/jiantou.png" width="9" height="15"></span></a>
	            <a href="commissionQuery" class="list-group-item">佣金查询 <span class="list_gou"><img src="${resRoot}/image/shopHome/jiantou.png" width="9" height="15"></span></a>
	        </div>
	        <div class="list-group">
	            <button class="btn btn-lg btn-default btn-block" type="button" id="btnGoIntoShop" name="btnGoIntoShop">进入店铺主页</button>
	        </div>
	    </div>
	</div>


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>

	<script type="text/javascript">
		$(document).ready(function(){  
		   //[导航-右边]按钮点击
		  $("#top_right").click(function(){  
		  //在这里操作导航-右边操作
		  	location.href = "weShopSet/"+${userid};
		  });  
		  //[进入店铺]按钮点击
		  $("#btnGoIntoShop").click(function(){  
		  //在这里操作进入店铺操作
		  	location.href = "../weShop/index/"+${userid};
		  });  
		});
	</script>
</body>
</html>