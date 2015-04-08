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
	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
    <!--日历控件js-->
    <script src="${resRoot}/js/date.js?v=${resVer}"></script>
    <script src="${resRoot}/js/date_iscroll.js?v=${resVer}"></script>
    <script type="text/javascript">
    
    //[点击佣金列表]
    function doneClick(obj)
    {
    	var tdlist = $(obj).find('td');
    	var td=tdlist.eq(2);//订单号
	    var userId = $("#hideuserid").val();
    	//ajax 操作，刷新本界面数据   
		var parms = {'userid':'${hideuserid}','orderid':td.text()};
		$.commonFormSubmit({
		 type: "POST",
		 action: '${base}/shopManage/commissionDetail',
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
    function countTotal()
    {
	    var totalSale = 0;
	    var totalCommission=0;
	    $('table tr:gt(0)').each(function() { 
	    	$(this).find('td:eq(3)').each(function(){ 
	    		totalSale += parseFloat($(this).text()); 
	    	}); 
	    	$(this).find('td:eq(4)').each(function(){ 
	    		totalCommission += parseFloat($(this).text()); 
	    	}); 
	    }); 
	    $('#totalRow').append('<td colspan="3"><h4><label class="query_info_left">合计</label></h4></td>');
	    $('#totalRow').append('<td><h4><label>'+totalSale+'</label></h4></td>');
	    $('#totalRow').append('<td><h4><label>'+totalCommission+'</label></h4></td>');
    }
    
    var iflag=1;//记录查询的条件 1.帐期查询 2起始日期查询
   	$(function(){
   		
   		$('#zhangqiTime').date();
   	    $('#beginTime').date();
   	    $('#endTime').date();
   	    
   	    //[点击查询]
   	    $("#btnselect").click(function(){
   	    	//在这里操作数据库查询
       		
       		if(iflag == 1)
       		{
       			var param = {"startDate":$("#zhangqiTime").val(),"userID":$("#hideuserid").val()};
       		}
       		else if(iflag==2)
       		{
       			var param = {"startDate":$("#beginTime").val(),"userID":$("#hideuserid").val()};
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
   	    });
   	    countTotal();//计算总和
   	    
   	    $("#selSearch").change(function(){
   	    	if($("#selSearch").val() == "1")
   	    	{
   	    		iflag=1;
   	   	    	$(".order_top_middle").css("display","none");
   	   	    	$("#zhangqiTime").css("display","block");
   	    	}
   	    	else
   	    	{
   	    		iflag=2;
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
            height:60px;
        }
        .query_info_detail
        {
            background: #ffffff;
            padding-top: 40px;
        }
        .query_info_bottom
        {
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
            height: 60px;
            line-height: 60px;
            margin-left: 7px;
        }
        select
        {
        	height: 45px;
        	font-size: 1em;
        }
        input
        {
            width: 80px;
            height: 34px;
        }
        .query_info_top_middle
        {
            width:45%;
            float: left;
            margin-top: 7px;
            margin-left: 20px;
        }
        .query_info_top_right
        {
            width:20%;
            float: right;
            margin-top: 7px;
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

        .order_top_middle1
        {
            float: left;
            width: 45%;
        }
        .order_top_middle2
        {
            float: left;
            width: 10%;
            line-height: 34px;
        }
        .order_top_middle3
        {
            float: left;
            width: 45%;
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
								<option value="1">佣金帐期</option>
								<option value="2">订单日期</option>
		                </select>
	           		</div>
	                <div class="query_info_top_middle">
	                	<input  id="zhangqiTime" class="kbtn input-lg" name="zhangqiTime" value="" />
		                <div id="datePlugin"></div>
		                <!-- 隐藏控件用于保存userid -->
						<div class="order_top_middle" style="display:none">
							<div class="order_top_middle1">
								<input id="beginTime" class="kbtn" name="beginTime" value="" />
							</div>
							<div class="order_top_middle2">—</div>
							<div class="order_top_middle3">
								<input id="endTime" class="kbtn" name="endTime" value="" />
							</div>
							
							<!-- 这句和日历控件有关千万别忘掉 -->
						</div>
						<div id="datePlugin"></div>

					</div>
	                <div class="query_info_top_right">
	                    <button class="btn btn-lg btn-warning btn-block" name="btnselect" id="btnselect" type="button">查询</button>
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
				<table class="table table-hover table-striped table-condensed">
				    <tr>
				        <th>序号</th>
				        <th>商品名称</th>
				        <th>订单号</th>
				        <th>预期收益</th>
				        <th>当前应收</th>
				    </tr>
					<#list commList as item>
						<tr onclick="doneClick(this);">
					      <td>${item_index}</td><!-- 序号 -->
					      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:74px;">${item.GOODS_NAME}</td><!--商品名称 -->
					      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:59px;">${item.ORDER_ID}</td><!-- 订单号-->
					      <td>${item.CMS_SUM_MONEY}</td><!-- 销售金额 -->
					      <td>${item.CMS_MONEY}</td><!-- 佣金 -->
						</tr>
					</#list>
				    <tr id="totalRow">

				    </tr>
				</table>
				</#if>
	        </div><!-- commmiss_query_info_end -->
	    </div>
	</div>
	

</body>
</html>