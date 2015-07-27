<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>订单状态明细</title>
    
    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">

    <link href="${resRoot}/css/custOrderStateDetails.css?v=${resVer}" rel="stylesheet">


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
	<script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
</head>
<body>
<!-- 代码 开始 -->
<!--top_start-->
<div id="top">
	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	<div id="top_middle">订单状态明细</div>
	<div id="top_right"></div>
</div>
<div id="dv_clear"></div>
<!--top_end-->


<div class="content">
<#if (listdealloginfo?exists)>

	<article>
		<section>
			<span class="point-time point-grey"></span>
			<aside>
				<p class="things">待支付</p>
				<!-- <p class="brief"><span class="text-yellow">Award</span> (Miami. FL)</p> -->
			</aside>
		</section>
		<#list listdealloginfo as item>
					
			<section>
				<span class="point-time point-grey"></span>
				<time datetime="2013-03">
					<span class='span1'>${item.HOUR_MINUTE}</span>
					<span>${item.MONTH_DAY}</span>
					<span>${item.YEAR}</span>
				</time>
				<aside>
					<p class="things">${item.DEAL_CONTENT}</p>
<!-- 					<p class="brief"><span class="text-red">Social Appearance</span></p> -->
				</aside>
			</section>
			<#if (!item_has_next)>
				<section>
					<span class="point-time point-greenlight"></span>
					<aside>
						<p class="things_end text-greenlight">${item.CURRENT_STATE_CONTENT}</p>
					</aside>
				</section>	
			
			<#else>
				<section>
					<span class="point-time point-grey"></span>
					<aside>
						<p class="things">${item.CURRENT_STATE_CONTENT}</p>
					</aside>
				</section>	
			</#if>
   		</#list>
	</article>
<#else>
	<center>暂时没有订单状态详情</center>
</#if>
</div>
</body>
</html>