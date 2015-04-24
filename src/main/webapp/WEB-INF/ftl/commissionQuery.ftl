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

	<!-- 日历控件_start -->
	<link href="${resRoot}/css/mobiscroll_002.css" rel="stylesheet" type="text/css">
	<link href="${resRoot}/css/mobiscroll_003.css" rel="stylesheet" type="text/css">
	<link href="${resRoot}/css/mobiscroll.css" rel="stylesheet" type="text/css">
	<!-- 日历控件_end -->


    <!--日历控件css-->
	<!--<link href="${resRoot}/css/date_common.css?v=${resVer}" rel="stylesheet">-->
    
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
	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
    
    <!-- 日历控件_start -->
    <script src="${resRoot}/js/mobiscroll_002.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_004.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_003.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_005.js" type="text/javascript"></script>
	<!-- 日历控件_end -->
    
    
    <!--日历控件js-->
    <!--<script src="${resRoot}/js/date.js?v=${resVer}"></script>
    <script src="${resRoot}/js/date_iscroll.js?v=${resVer}"></script>-->
    <script type="text/javascript">
    
    //[点击收益列表]
    function doneClick(obj)
    {
    	//var tdlist = $(obj).find('td');
    	//var td=tdlist.eq(2);//订单号
	    var userId = $("#hideuserid").val();
	    var orderIdArray= new Array(); 
    	orderIdArray=$(obj).text().split('-');
    	//ajax 操作，刷新本界面数据   
		var parms = {'ORDER_ID':orderIdArray[1]};
		$.commonFormSubmit({
		 type: "POST",
		 action: '${base}/shopManage/orderDetail',
		 data: parms,
		 success: function(data){
		  	 //history.back();
		  	 //alert("ok");
		  	 //return;
		  	 //alert(data);

		  	 return;
		 }
		});
    }
    
    //[状态筛选]
    function doStatusClick(obj)
    {
    	//记录状态 筛选 1可提现 2无效单 3结算中4未激活
    	//alert($(obj).text());
    	if($(obj).text() == "未激活")
    	{
    		iStatusflag='00';
    	}
    	else if($(obj).text()=="结算中")
    	{
    		iStatusflag='01';
    	}
    	else if($(obj).text()=="已到帐")
    	{
    		iStatusflag='02';
    	}
    	else if($(obj).text()=="已退货")
    	{
    		iStatusflag='03';
    	}	
    	else if($(obj).text()=="已失效")
    	{
    		iStatusflag='04';
    	}	
    	//二次查询数据，因为有iStatusflag参数的存在
    	selectData();
    	
    	
    	
    }
    function countTotal()
    {
	    var totalSale = 0;
	    var totalCommission=0;
	    var totalRowCount=0;
	    $('table tr:gt(0)').each(function() { 
	    	$(this).find('td:eq(2)').each(function(){ 
	    		totalRowCount=totalRowCount+1;
	    		totalSale += parseFloat($(this).text()); 
	    	}); 
	    	//$(this).find('td:eq(3)').each(function(){ 
	    	//	totalCommission += parseFloat($(this).text()); 
	    	//}); 
	    }); 
	    $('#totalRowCount').append('<td colspan="4"><h5>共'+totalRowCount+'条数据</h5></td>');
	    $('#totalRow').append('<td colspan="2"><h5><label class="query_info_left">合计</label></h5></td>');
	    $('#totalRow').append('<td><h5><label>'+totalSale+'(¥)</label></h5></td>');
	    $('#totalRow').append('<td><h5><label></label></h5></td>');
    }
    
    function selectData()
    {
  		if(iflag == 1)
   		{
   			var param = {"iflag":iflag,"zhangqiTime":$("#zhangqiTime").val(),"userID":$("#hideuserid").val(),"iStatusflag":iStatusflag};
   		}
   		else if(iflag==2)
   		{
   			var param = {"iflag":iflag,"startDate":$("#beginTime").val(),"endDate":$("#endTime").val(),"userID":$("#hideuserid").val(),"iStatusflag":iStatusflag};
   		}
   		
   		$.ajax({
   			   type: "POST",
   			   url: "selectCommissions",
   			   data: param,
   			   async: false,
   			   success: function(bRet){
   				   //alert(bRet);
   				   $("#commmiss_query_info").html(bRet);
  				  	 	//调用计算总和方法
  				  	 	countTotal();
   			   }
   			});
    }
    
    

    var iflag=2;//记录查询的条件 1.帐期查询 2起始日期查询
    var iStatusflag=-1;//记录状态 筛选 1可提现 2无效但 3结算中4未激活
   	$(function(){
		var currYear = (new Date()).getFullYear();	
		var opt={};
		opt.date = {preset : 'date'};
		opt.datetime = {preset : 'datetime'};
		opt.time = {preset : 'time'};
		opt.default = {
			theme: 'android-ics light', //皮肤样式
	        display: 'modal', //显示方式 
	        mode: 'scroller', //日期选择模式
			dateFormat: 'yyyy-mm',
			lang: 'zh',
			showNow: true,
			nowText: "今天",
			dateOrder: 'yymm',
	        startYear: currYear - 10, //开始年份
	        endYear: currYear + 10 //结束年份
		};
		opt.default_main={
			theme: 'android-ics light', //皮肤样式
	        display: 'modal', //显示方式 
	        mode: 'scroller', //日期选择模式
			dateFormat: 'yyyy-mm-dd',
			lang: 'zh',
			showNow: true,
			nowText: "今天",
			dateOrder: 'yymmdd',
	        startYear: currYear - 10, //开始年份
	        endYear: currYear + 10 //结束年份	
		};

	  	$("#zhangqiTime").mobiscroll($.extend(opt['date'], opt['default']));
	  	$("#beginTime").mobiscroll($.extend(opt['date'], opt['default_main']));
	  	$("#endTime").mobiscroll($.extend(opt['date'], opt['default_main']));

	  //js日期比较(yyyy-mm-dd)
	    function CompareDate(startDate,endDate) {
	        var arr = startDate.split("-");
	        var starttime = new Date(arr[0], arr[1], arr[2]);
	        var starttimes = starttime.getTime();
	
	        var arrs = endDate.split("-");
	        var lktime = new Date(arrs[0], arrs[1], arrs[2]);
	        var lktimes = lktime.getTime();
	
	        if (starttimes > lktimes) {
	            return false;
	        }
	        else
	            return true;
	
	    }
	  	 //检验输入数值是否正确
        function checkData()
        {
        	if($("#beginTime").val())
			{
        		if(!$("#endTime").val())
        		{
        			alert("请输入截至日期");
        			return false;
        		}
			}
        	if($("#endTime").val())
        	{
        		if(!$("#beginTime").val())
        		{
        			alert("请输入起始日期");
        			return false;
        		}
        	}
        	if(!CompareDate($("#beginTime").val(),$("#endTime").val()))
        	{
        		alert("截至日期不能大于等于起始日期");
        		return false;
        	}
        	return true;
        }
	  	
	  	
   	    //[点击查询]
   	    $("#btnselect").click(function(){
   	    	//在这里操作数据库查询
   	    	iStatusflag=-1;//初始化
        	if(!checkData())
        	{
        		return false;
        	}
        	else
        	{
       	    	selectData();
        	}
   	    });
   	    countTotal();//计算总和
   	    
   	    $("#selSearch").change(function(){
   	    	if($("#selSearch").val() == "1")
   	    	{
   	    		iflag="1";
   	   	    	$(".order_top_middle").css("display","none");
   	   	    	$("#zhangqiTime").css("display","block");
   	    	}
   	    	else
   	    	{
   	    		iflag="2";
   	    		$("#zhangqiTime").css("display","none");
   	    		$(".order_top_middle").css("display","block");
   	    	}
   	    });

   	});

    </script>
    <style type="text/css">
        .row
        {
            /*margin: 15px;*/
            padding: 10px;
        }
        .query_info_top
        {
            background: #ffffff;
            height:120px;
            padding:10px;
        }
        .query_info_detail
        {
            background: #ffffff;
            margin-top: 40px;
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
            width:25%;
            float: left;
            display: none;
        }
        select
        {
        	height: 34px;
        	font-size: 1em;
        }

        .query_info_top_middle
        {
            width:100%;
            float: left;

        }
        .query_info_top_right
        {
            width:20%;
            float: right;
            margin-right: 7px;
        }
        .query_info_top_clear
        {
            clear:both;;
        }

        input
        {
        	height: 34px;
        	width:100%;	
        	padding:0px;
        	font-size: 12px;
        	text-align: center;
        	line-height: 34px;
        	
        }
        .input-lg
        {
        	padding:0px;
        	font-size: 12px;
        	text-align: center
        }

        .order_top_middle1
        {
            float: left;
            width: 48%%;
        }
        .order_top_middle2
        {
            float: left;
            width: 4%;

            text-align: center;
        }
        .order_top_middle3
        {
            float: left;
            width: 48%;
        }
        .query_info_bottom
        {
        	background: #cccccc;
			position:fixed;
        	bottom:0em;
        	height: 120px;
        	color：#333333;
        	padding: 20px;
        	z-index:-9999;
        }

		.dropdown-menu
		{
			min-width:60px;
		}
		.dropdown-menu li {
			width:60px;
		}
		.dropdown-menu li a
		{
			padding:3px;
			text-align: center;
		}
}

    </style>
</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->

	    <form>
	        <div>
	            <div class="query_info_top">
	             <div style="height:50px;line-height: 50px;">
	             
	             
	              <!-- <h4><div class="query_info_top_left"><label>收益帐期</label></div></h4> -->
	              <!-- <div class="query_info_top_left">
		                <select name="selSearch" id="selSearch">
		                		<option value="2">订单日期</option>
								<option value="1">收益帐期</option>
								
		                </select>
	           		</div> -->
	                <div class="query_info_top_middle">
	                	<input  id="zhangqiTime"  name="zhangqiTime" value="" style="display:none" />
		                <!--<div id="datePlugin"></div>-->
		                <!-- 隐藏控件用于保存userid -->
						<div class="order_top_middle" >
							<div class="order_top_middle1">
								<input id="beginTime"  name="beginTime" value="" placeholder="开始时间"/>
							</div>
							<div class="order_top_middle2">—</div>
							<div class="order_top_middle3">
								<input id="endTime" name="endTime" value="" placeholder="结束时间"/>
							</div>
							<!-- 这句和日历控件有关千万别忘掉 -->
						</div>
						<!--<div id="datePlugin"></div>-->
					</div>
					<div class="query_info_top_clear"></div>
					</div>
					<br/>
	                <div>
	                    <button class="btn btn-warning btn-block" name="btnselect" id="btnselect" type="button">查询</button>
	                </div>

            		<input type="hidden" id="hideuserid" name="hideuserid" value=${hideuserid}>
	            </div>
	            <div class="query_info_top_clear"></div>

	        </div>
	    </form>

	    <div class="query_info_detail">
	        <h5><label>收益明细</label></h5>
	        <div id="commmiss_query_info">
				<#if (commList?size==0)>
					您没有收益
				<#else>
				<table class="table table-hover table-striped table-condensed" style="table-layout: fixed;">
				    <tr>
				        <!--<th>序号</th>-->
				        <th><div class="th_title">商品名称</div></th>
				        <th><div class="th_title">订单详情</div></th>
				        <th><div class="th_title">收益(¥)</div></th>
				        <th>
							<div class="dropdown" style="padding:0px;">
								<button class="btn dropdown-toggle" style="background-color: transparent;padding: 0px;margin: 0px;font-weight: bold;" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="false">
								    	状态
								    <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<!-- <li><a href="#">可领取</a></li>
									<li role="presentation" class="divider"></li>
									<li><a href="#">冻结</a></li>
									 -->
									<li onclick="doStatusClick(this);"><a href="#">未激活</a></li>
									<li role="presentation" class="divider"></li>
									<li onclick="doStatusClick(this);"><a href="#">结算中</a></li>
									<li role="presentation" class="divider"></li>
									<li onclick="doStatusClick(this);"><a href="#">已到帐</a></li>
									<li role="presentation" class="divider"></li>
									<li onclick="doStatusClick(this);"><a href="#">已退货</a></li>
									<li role="presentation" class="divider"></li>
									<li onclick="doStatusClick(this);"><a href="#">已失效</a></li>
								</ul>
							</div>
						</th>
				    </tr>
					<#list commList as item>
						<tr>
					      <!-- <td>${item_index}</td> --><!-- 序号 -->
					      <td style="width:74px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;">${item.GOODS_NAME}</td><!--商品名称 -->
					      <td style="width:59px;overflow:hidden;text-overflow:ellipsis;white-space:nowrap;" onclick="doneClick(this);">${item.RECEIVER_NAME}-${item.ORDER_ID}</td><!-- 订单号-->
						  <td>
					      	<#if (item.SUM_CMS_MONEY== '')>
					      		${(item.CMS_PRE_FEE/1000)?string("#.##")}
					      	<#else>
					      		${(item.SUM_CMS_MONEY/1000)?string("#.##")}
					      	</#if>      
						  </td><!-- 预期-->
					     <!-- 记录状态 筛选 1可提现 2无效单 3结算中4未激活 -->
					      <td>
					      	<#if (item.CMS_STATE == "")>
					      		<span class="label label-default">未知</span>
					      	<#elseif (item.CMS_STATE=='00')><!-- 未激活-->
					      		<span class="label label-default">未激活</span>
					      	<#elseif (item.CMS_STATE=='01')><!-- 结算中 -->	
					      		<span class="label label-primary">结算中</span>
					      	<#elseif (item.CMS_STATE=='02')><!-- 已到帐 -->
					      		<span class="label label-success">已到帐</span>
					      	<#elseif (item.CMS_STATE=='03')><!-- 已退货-->
					      		<span class="label label-warning">已退货</span>
					      	<#elseif (item.CMS_STATE=='04')><!-- 已失效-->
					      		<span class="label label-danger">已失效</span>	
					      	</#if>
					      </td><!-- 状态 -->
						</tr>
					</#list>
					<tr id="totalRowCount">

				    </tr>
				    <tr id="totalRow">

				    </tr>
				</table>
				</#if>
	        </div><!-- commmiss_query_info_end -->
			
	    </div>
	    <br/>
	    <br/>
		<div>
			&nbsp;&nbsp;&nbsp;<label>还没有绑定银行卡？</label>&nbsp;&nbsp;&nbsp;<label><a style="color:green;" href="${base}/shopManage/bindBankCard?userid=${hideuserid}"><u>点此去绑定</u></a></label>
	        <!-- <div class="query_info_bottom">
				温馨提示：我们每天凌晨4点根据用户状态计算收益收益，处于冻结状态的收益可能是未到计算时点或号码还没有激活。
	    	</div> -->
		</div>
		<br/>
	    <br/>
	</div>
	

</body>
</html>