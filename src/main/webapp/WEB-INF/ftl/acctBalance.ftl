<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
	<title>收支明细</title>
	
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/acctBalance.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/acctBalance.js?v=${resVer}"></script>	
	
</head>
<body>
    <input type="hidden" id="baseRoot" value="${base}"></input>
    <input type="hidden" id="user_id" value="${user_id}"></input>
   		  <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${resRoot} ${title}</div>
	      </div> 

	<div class = "container">
	<!-- topbar  -->
		<div class = "border_bottom" style = "height : 40px">
			<a id="income_a" class="topbar_a_selected topbar_a rel" >收入
				<em class ="abs right_line"></em>
			</a>
			<a id="spending_a" class="topbar_a_nomal topbar_a rel" >支出
				<em class ="abs right_line"></em>
			</a>
			<a id="withdrawal_a" class="topbar_a_nomal topbar_a rel" name = "提现" >提现</a>
		</div>
		
	<!-- search  -->
	<div style = "padding:15px 8px">
		<div style = "width:25%;height:25px;display:inline-block;margin-right: -3px; class = "rel">
 			<em id="search_tile" class= "abs">月份查询</em> 
		</div>
		
		<!--选择月份 -->
		<div style = "width:50%;height:25px;display:inline-block;margin-right: -3px;" class = "rel">
 		 	<select id = "search_select" class= "abs" tabindex="1">
				<option value="-1">--选择月份--</option>
				<#list monthList as item>
							<option> ${item}</option>			
				</#list>				
			</select> 
		</div>	
		<div style = "width:24%;height:25px;display:inline-block;margin-right:-3px;" class = "rel">
			<a id="search_a" class ="abs">查询
		    </a>
		</div>		
	</div>	
	<!-- 列表 -->

	<div >
		<div id = "list_head" class = "border_bottom border_top rel">
			<span  class = "list_title_left_text abs">${sumTitle}</span>
			<span  class = "list_title_right_text abs">${sumNum}</span>
		</div>
		<ul id = "datagrid">			
		<#if (costList?size == 0) > 
		   	没有账单
		<#else>
			<#list costList as item>
				<li class = "row border_bottom">
				<div class = "row_left">
					<p class = "row_left_title">${item.orderType} </p>
					<#if (item.orderNum) > 
						<span class = "row_left_order"> (订单号：${item.orderNum}) </span>
					</#if>
					<p class = "row_left_time">${item.createTime}</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">${item.payNum} </p>
					<p class = "row_right_audit" name = "row_right_audit">${item.state}</p>
				</div>
				<div style="clear:both;"></div> 
			   </li>			
			</#list>
	 	</#if>
		</ul>		
	</div>
	</div>

</body>
</html>