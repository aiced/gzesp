<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>收支明细</title>
	 <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/acctBalance.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/acctBalance.js?v=${resVer}"></script>	
			
	
	<script src="${resRoot}/js/jquery.1.7.2.min.js"></script>
    <script src="${resRoot}/js/mobiscroll_002.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_004.js" type="text/javascript"></script>
	<link href="${resRoot}/css/mobiscroll_002.css" rel="stylesheet" type="text/css">
	<link href="${resRoot}/css/mobiscroll.css" rel="stylesheet" type="text/css">
	<script src="${resRoot}/js/mobiscroll.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_003.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_005.js" type="text/javascript"></script>
	<link href="${resRoot}/css/mobiscroll_003.css" rel="stylesheet" type="text/css">
	
		
	
</head>
<body>
    <div id="top">
       	<div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
       	<div id="top_middle">我的账户</div>
       	<div id="top_right"></div>
    </div>
    <div class="dv_clear"></div>
    <input type="hidden" id="baseRoot" value="${base}"></input>
    <input type="hidden" id="user_id" value="${user_id}"></input>
	<div class = "divContainer">
	<!-- topbar  -->
		<div class = "tapDiv border_bottom" style = "height : 40px">
			<a id="income_a" class="topbar_a_selected topbar_a rel" >收入
				<em class ="abs right_line"></em>
			</a>
			<a id="spending_a" class="topbar_a_nomal topbar_a rel" >支出
				<em class ="abs right_line"></em>
			</a>
			<a id="withdrawal_a" class="topbar_a_nomal topbar_a rel" name = "提现" >提现</a>
		</div>
		
	<!-- search  -->
	<div class = "search rel">
		<div class = "leftDiv fleft">
 			<em id="search_tile" class= "abs">月份查询</em> 
		</div>
		
		<!--选择月份 -->
		<div class = "middleDiv fleft">
			<input value="" class="" readonly="readonly" name="search_select" id="search_select" type="text">
		</div>	
		<div style = "width:24%;height:25px;display:inline-block;margin-right:-3px;" class = "rel">
			<a id="search_a" class ="abs">查询
		    </a>
		</div>		
	</div>	
	<!-- 列表 -->

	<div class = "sumDiv">
		<div id = "list_head" class = "border_bottom border_top rel">
			<span id = "sumTitle" class = "list_title_left_text abs">总收入</span>
			<span id = "sumNum" class = "list_title_right_text abs">${acctlogtotal}</span>
		</div>
		<ul id = "datagrid">			
		<#if (acctloglist?? && acctloglist?size>0) > 
			<#list acctloglist as item>
				<li class = "li_row border_bottom">
				<div class = "row_left">

					<p class = "row_left_title">${item.TRADE_TYPE}
					<#if (item.CANCEL_TAG) > 
						(${item.CANCEL_TAG})
					</#if>
					</p>

					<#if (item.ORDER_ID) > 
						<span class = "row_left_order"> (订单号：${item.ORDER_ID}) </span>
					</#if>
					<p class = "row_left_time">${item.UPDATE_TIME}</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">#{item.FEE;m1M2}</p>
					<p class = "row_right_audit" name = "row_right_audit">${item.OPERATE_TAG}</p>
				</div>
				<div style="clear:both;"></div> 
			   </li>			
			</#list>
		<#else>
			 	<div class = "noBill">
			 		没有账单			
			 	</div>
	 	</#if>
		</ul>		
	</div>
	</div>
</body>
</html>
</body>
</html>
