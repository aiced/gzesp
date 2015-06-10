<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/acctBalance.css?v=${resVer}" rel="stylesheet">  
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/acctBalance.js?v=${resVer}"></script>	
	
</head>
<body>
   		  <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	        </div> 

	<div class = "container">
	<!-- topbar  -->
		<div class = "border_bottom" style = "height : 40px">
			<a id="income_a" class="topbar_a topbar_a_selected rel " >收入
				<em class ="abs right_line"></em>
			</a>
			<a id="spending_a" class="topbar_a topbar_a_nalmal rel" >支出
				<em class ="abs right_line"></em>
			</a>
			<a id="withdrawal_a" class="topbar_a topbar_a_nalmal" name = "提现" >提现</a>
		</div>
	<!-- search  -->
	<div style = "padding:15px 8px">
		<div style = "width:25%;height:25px;display:inline-block;margin-right: -3px; class = "rel">
 			<em id="search_tile" class= "abs">月份查询</em> 
		</div>
		<div style = "width:50%;height:25px;display:inline-block;margin-right: -3px;" class = "rel">
 		 	<select id = "search_select" class= "abs" tabindex="1">
				<option value="-1">--选择月份--</option>
				<option value="1">1月</option>
				<option value="2">2月</option>
				<option value="3">3月</option>
				<option value="4">4月</option>
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
			<span  class = "list_title_left_text abs">总收入</span>
			<span  class = "list_title_right_text abs">1000</span>
		</div>
		
		<ul>
			<li class = "row border_bottom">
				<div class = "row_left">
					<p class = "row_left_title">佣金转入 <span class = "row_left_subtitle"> (订单号：31445) </span> </p>
					<p class = "row_left_time">2015-07 &nbsp 07:45</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">2000 </p>
					<p class = "row_right_audit" name = "row_right_audit">审核中</p>
				</div>
				
			</li>	
			
				<li class = "row border_bottom">
				<div class = "row_left">
					<p class = "row_left_title">佣金转入 <span class = "row_left_subtitle"> (订单号：31445) </span> </p>
					<p class = "row_left_time">2015-07 &nbsp 07:45</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">2000 </p>
					<p class = "row_right_audit" name = "row_right_audit">审核未通过</p>
				</div>
				
			</li>	
			
					<li class = "row border_bottom">
				<div class = "row_left">
					<p class = "row_left_title">佣金转入 <span class = "row_left_subtitle"> (订单号：31445) </span> </p>
					<p class = "row_left_time">2015-07 &nbsp 07:45</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">2000 </p>
					<p class = "row_right_audit" name = "row_right_audit">审核已通过</p>
				</div>
				
			</li>	
			
			</li>	
			
					<li class = "row border_bottom">
				<div class = "row_left">
					<p class = "row_left_title">佣金转入 <span class = "row_left_subtitle"> (订单号：31445) </span> </p>
					<p class = "row_left_time">2015-07 &nbsp 07:45</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">2000 </p>
					<p class = "row_right_audit" name = "row_right_audit">已打款</p>
				</div>
				
			</li>	
			
		</ul>
		
		
	</div>
	
	
	
			
			
			
			
			
	</div>

</body>
</html>