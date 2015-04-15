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
    
    //[点击佣金列表]
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
    		iStatusflag=4;
    	}
    	else if($(obj).text()=="无效单")
    	{
    		iStatusflag=2;
    	}
    	else if($(obj).text()=="结算中")
    	{
    		iStatusflag=3;
    	}
    	else if($(obj).text()=="可提现")
    	{
    		iStatusflag=1;
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
	    $('#totalRowCount').append('<td colspan="4"><h4>共'+totalRowCount+'条数据</h4></td>');
	    $('#totalRow').append('<td colspan="2"><h4><label class="query_info_left">合计</label></h4></td>');
	    $('#totalRow').append('<td><h4><label>'+totalSale+'</label></h4></td>');
	    $('#totalRow').append('<td><h4><label></label></h4></td>');
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
            height:100px;
            line-height: 100px;

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
            width:18%;
            float: left;
            margin-left: 7px;
        }
        select
        {
        	height: 45px;
        	font-size: 1em;
        }

        .query_info_top_middle
        {
            width:50%;
            float: left;
            margin-left: 20px;
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
        	height: 45px;
        	width:100%;	
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
            width: 48%;
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
			min-width:80px;
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
	              <!-- <h4><div class="query_info_top_left"><label>佣金帐期</label></div></h4> -->
	              	<div class="query_info_top_left">
		                <select name="selSearch" id="selSearch">
		                		<option value="2">订单日期</option>
								<!-- <option value="1">佣金帐期</option> -->
								
		                </select>
	           		</div>
	                <div class="query_info_top_middle">
	                	<input  id="zhangqiTime" class="kbtn input-lg" name="zhangqiTime" value="" style="display:none" />
		                <!--<div id="datePlugin"></div>-->
		                <!-- 隐藏控件用于保存userid -->
						<div class="order_top_middle" >
							<div class="order_top_middle1">
								<input id="beginTime" class="input-lg" name="beginTime" value="" />
							</div>
							<div class="order_top_middle2">—</div>
							<div class="order_top_middle3">
								<input id="endTime" class="input-lg" name="endTime" value="" />
							</div>
							
							<!-- 这句和日历控件有关千万别忘掉 -->
						</div>
						<!--<div id="datePlugin"></div>-->

					</div>
	                <div class="query_info_top_right">
	                    <button class="btn btn-lg btn-warning" name="btnselect" id="btnselect" type="button">查询</button>
	                </div>

            		<input type="hidden" id="hideuserid" name="hideuserid" value=${hideuserid}>
	            </div>
	            <div class="query_info_top_clear"></div>

	        </div>
	    </form>

	    <div class="query_info_detail">
	        <h4><label>当月佣金明细</label></h4>
	        <div id="commmiss_query_info">
				<#if (commList?size==0)>
					您没有佣金
				<#else>
				<table class="table table-hover table-striped table-condensed" style="table-layout: fixed;">
				    <tr>
				        <!--<th>序号</th>-->
				        <th><div class="th_title">商品名称</div></th>
				        <th><div class="th_title">订单详情</div></th>
				        <th><div class="th_title">收益</div></th>
				        <th>
							<div class="btn-group" role="group" aria-label="...">
								<div class="btn-group" role="group">
									<div class="dropdown-toggle"
										data-toggle="dropdown" aria-expanded="false">
										状态
										<span class="caret"></span>
									</div>
									<ul class="dropdown-menu" role="menu">
										<!--<li><a href="#">可领取</a></li>
										<li role="presentation" class="divider"></li>
										<li><a href="#">冻结</a></li> -->
										<li onclick="doStatusClick(this);"><a href="#">可提现</a></li>
										<li role="presentation" class="divider"></li>
										<li onclick="doStatusClick(this);"><a href="#">无效单</a></li>
										<li role="presentation" class="divider"></li>
										<li onclick="doStatusClick(this);"><a href="#">结算中</a></li>
										<li role="presentation" class="divider"></li>
										<li onclick="doStatusClick(this);"><a href="#">未激活</a></li>
									</ul>
								</div>
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
					      		${item.CMS_PRE_FEE}
					      	<#else>
					      		${item.SUM_CMS_MONEY}
					      	</#if>      
						  </td><!-- 预期-->
					     <!-- 记录状态 筛选 1可提现 2无效单 3结算中4未激活 -->
					      <td>
					      	<#if (item.ACT_STATUS=='0'  && item.CMS_MONTH=='')><!-- 没激活没到时间:未激活 -->
					      		<span class="label label-default">未激活</span>
					      	<#elseif (item.ACT_STATUS=='0' && item.CMS_MONTH!='')><!-- 没激活到时间:无效单 -->	
					      		<span class="label label-primary">无效单</span>
					      	<#elseif (item.ACT_STATUS=='1' && item.CMS_MONTH=='')><!-- 激活没到时间:结算中 -->
					      		<span class="label label-warning">结算中</span>
					      	<#elseif (item.ACT_STATUS=='1' && item.CMS_MONTH!='')><!-- 激活到时间 :可提现-->
					      		<span class="label label-success">可提现</span>
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
		<div >
	        <div class="query_info_bottom">
				温馨提示：我们的佣金出帐日为每月的20号，处于冻结状态的佣金可能是未到出帐日或号码还没有激活，每月出帐后的佣金将在25号到达您的微账户。
	    	</div>
		</div>

	</div>
	

</body>
</html>