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
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
    <!-- 日历控件_start -->
    <script src="${resRoot}/js/mobiscroll_002.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_004.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_003.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_005.js" type="text/javascript"></script>
	<!-- 日历控件_end -->


    <script type="text/javascript">
    
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
    
	    function doneClick(obj)
	    {
        	var formid = $(obj).find('form');
        	formid.submit();
	    }
	  

        $(function(){ 
        	var currYear = (new Date()).getFullYear();	
    		var opt={};
    		opt.date = {preset : 'date'};
    		opt.datetime = {preset : 'datetime'};
    		opt.time = {preset : 'time'};
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

    	  	$("#beginTime").mobiscroll($.extend(opt['date'], opt['default_main']));
    	  	$("#endTime").mobiscroll($.extend(opt['date'], opt['default_main']));

			$("#txtorderid").blur(function(){
				

			});
    	  	

            
            
            
            //[返回]按钮点击
            $("#top_left").click(function(){  
        		var parms = {'userid':'${hideuserid}','fromPage':'${fromPage}'};
        		$.commonFormSubmit({
           		 type: "POST",
        		 action: '${base}/shopManage/Back',
        		 data: parms,
        		 success: function(data){
        		  	 //history.back();
        		  	 //alert("ok");
        		  	 //return;
        		  	 //alert(data);
        		  	 return;
        		 }
        		});
            });    
            
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
            	
	    	  	if(isNaN($("#txtorderid").val())){
		      	  	  alert("订单号必须为数字");
		      	  	  return false;
		      	  	}
            	return true;
            }
            //[点击订单列表]
            //$(".order_middle").click(function(){
            //	//alert($("#itemindex").val());
            //	var formid = $(this).find('form');
            //	formid.submit();
            //});
 			           
            //[查询]按钮点击
            $("#btnselect").click(function(){
            	if(!checkData())
            	{
            		return false;
            	}
            	else
            	{
            		$("#hidepageindex").val(1);//点击查询 从第一条开始查询
            		//在这里操作数据库查询的
            		var bRetrun=false;
            		var param = {"startDate":$("#beginTime").val(),"endDate":$("#endTime").val(),"orderID":$("#txtorderid").val(),"userID":$("#hideuserid").val(),"hidepageindex":$("#hidepageindex").val()};
       				$("#hidepageindex").val(parseInt($("#hidepageindex").val())+4);
            		$.ajax({
            			   type: "POST",
            			   url: "selectOrders",
            			   data: param,
            			   async: false,
            			   success: function(bRet){
            				   //alert(bRet);
            				   $("#order_middle_info").html(bRet);
            			   }
            			});
            	}
            });
    	  	//常量_记录每页分4条
            $("#hidepageindex").val(5);
            //第一次进来分页查询
            function queryOrderInfo_Page()
            {
        		//在这里操作数据库查询的
        		var bRetrun=false;
        		var param = {"startDate":$("#beginTime").val(),"endDate":$("#endTime").val(),"orderID":$("#txtorderid").val(),"userID":$("#hideuserid").val(),"hidepageindex":$("#hidepageindex").val()};
        		
        		$.ajax({
        			   type: "POST",
        			   url: "selectOrders_Page",
        			   data: param,
        			   async: false,
        			   success: function(bRet){
        				   //alert(bRet);
        				   $("#order_middle_info").append(bRet);
        			   }
        			});
            	
            }
            //div滚动价值
            $("#order_middle_info_contain").scroll(function(){
            	
                $('#scroll-to-bottom-msg').html('');
            	$('#scroll-top-msg').html($("#order_middle_info_contain")[0].scrollTop);
            	$('#scroll-height-msg').html($("#order_middle_info_contain")[0].scrollHeight);
            	//parseInt($("#order_middle_info_contain")[0].scrollHeight - $("#order_middle_info_contain").height(),10);//将值转化为十进制
     			 if($("#order_middle_info_contain")[0].scrollTop >= ($("#order_middle_info_contain")[0].scrollHeight - $("#order_middle_info_contain").height())) 
                	{
     				 	queryOrderInfo_Page();
   						$("#hidepageindex").val(parseInt($("#hidepageindex").val())+4);
                	}                
                });
        	//滚动加载
        	//$(window).scroll(function () {
       		//	var scrollTop = $(this).scrollTop();
       		//	var scrollHeight = $(document).height();
       		//	var windowHeight = $(this).height();
       		//	if (scrollTop + windowHeight == scrollHeight) {
       		//		// 此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
       		//		// alert($('#datagrid').attr('pageNum'));
       				
       		//		queryOrderInfo_Page();
       		//		$("#hidepageindex").val(parseInt($("#hidepageindex").val())+4);
       		//		//var keyword = $('#keyword').val();
       		//		//var good_type = $('#good_type').val();
       		//		//var pageNum = parseInt($('#datagrid').attr('pageNum')) + 1; // 下拉表示要加载下一页/

       		//		//queryFilterPublicAppend(good_type, pageNum, 10, keyword); // 每次加载10条
       		//		//$('#datagrid').attr('pageNum', pageNum); // 加载成功后页数+1
       		//	}
            //}); 
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
            width: 30%;
            height: 34px;
            
        }
        h4{
        	margin-top: 5px;
        }
        .order_top_middle
        {
            float: left;
            width: 60%;
            text-align: center;
            margin-left: 5px;
            margin-right: 5px;
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
            width: 100%;
            height: 34px;
        }
        .div_line
        {
            height: 1px;
            background: #e6e6e6;
            margin-top: 20px;
        }
       .order_middle_contain
        {
           background: #ffffff;

            margin: 15px;
        } 
        .order_middle
        {
           
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
            text-align:center;
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
            margin-top: 15px;
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
            height:85px;
            line-height: 85px;
            margin-right: 10px;
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
        <div  class="order_top">
            <div class="order_top_left"><h5><label>订单时间</label></h5></div>
            
            <div class="order_top_middle">
                <div class="order_top_middle1">
                    <!--<input type="text" id="txtdatefrom" class="form-control">-->
                    <input  id="beginTime" class="kbtn" name="beginTime" value=""/>                    
                </div>
                
                <div class="order_top_middle2">
                    —
                </div>
                <div class="order_top_middle3">
                    <!--<input type="text" id="txtdateto" class="form-control">-->
                    <input  id="endTime" class="kbtn" name="endTime" value=""/>
                </div>
                <div id="datePlugin"></div><!-- 这句和日历控件有关千万别忘掉 -->
            </div>
            
            <!-- <div class="order_top_right"> -->
            <!--    <button class="btn btn-warning btn-block" type="button" name="btnselect" id="btnselect">查询</button>-->
            <!--</div>-->
            <div class="div_clear"></div>
        </div>
        <div  class="order_top">
            <div class="order_top_left"><h5><label>订单号</label></h5></div>
            
            <div class="order_top_middle">
				<input type="text" class="kbtn" name="txtorderid" style = "border:1px solid #B7B7B7;" id="txtorderid" value=""/>
            </div>
            
            <!-- <div class="order_top_right"> -->
            <!--    <button class="btn btn-warning btn-block" type="button" name="btnselect" id="btnselect">查询</button>-->
            <!--</div>-->
			<div class="div_clear"></div>
            <div class="div_line"></div>
            <br/>
            <button class="btn btn-warning btn-block" type="button" name="btnselect" id="btnselect">查询</button>
            <!-- 隐藏控件用于保存userid -->
            <input type="hidden" id="hideuserid" name="hideuserid" value=${hideuserid}>
            <input type="hidden" id="hidepageindex" name="hidepageindex" value=0>
        </div>        
        <div class="div_clear"></div>
        <br/>
        <br/>
		<br/>
		<br/>
		<div id="order_middle_info_contain" style="overflow-y:auto; overflow-x:hidden; height:400px;">
        <div id="order_middle_info" >
        	<#if (orderList?size==0)>
	        	<div class="order_middle">
	        		<h5 style="text-align:center;height:140px;line-height:140px;">您还没有订单</h5>
	        	</div>
        	<#else>
				<#list orderList as item>
				<div class="order_middle_contain">
		           <div class="order_middle" onclick="doneClick(this);">
		           	   <input type="hidden" name="itemindx${item_index}" id="itemindex${item_index}" value=${item_index}>
		               <div class="order_contain">
		                   <div class="order_contain_top">
		                   	   <!-- ,苹果最新手机iphone6 4.7寸大屏幕 超强性能处理器 -->
		                       <h5><div class="order_contain_title">${item.GOODS_NAME}</div></h5>
		                       <#if (item.ORDER_STATE=='00')>
		                       	<h5><div class="order_contain_statue">待支付</div></h5>
		                       <#elseif (item.ORDER_STATE=='01')>
		                       	<h5><div class="order_contain_statue">待分配</div></h5>
		                       <#elseif (item.ORDER_STATE=='02')>
		                       	<h5><div class="order_contain_statue">待处理</div></h5>
		                       <#elseif (item.ORDER_STATE=='03')>
		                       	<h5><div class="order_contain_statue">处理中</div></h5>
		                       <#elseif (item.ORDER_STATE=='04')>
		                       	<h5><div class="order_contain_statue">待发货</div></h5>
		                       <#elseif (item.ORDER_STATE=='05')>
		                       <h5><div class="order_contain_statue">发货中</div></h5>
		                       <#elseif (item.ORDER_STATE=='06')>
		                       <h5><div class="order_contain_statue">物流在途</div></h5>
		                       <#elseif (item.ORDER_STATE=='07')>
		                       <h5><div class="order_contain_statue">待归档</div></h5>
		                       <#elseif (item.ORDER_STATE=='08')>
		                       <h5><div class="order_contain_statue">成功关闭（已归档）</div></h5>
		                       <#elseif (item.ORDER_STATE=='09')>
		                       <h5><div class="order_contain_statue">订单处理退单</div></h5>
		                       <#elseif (item.ORDER_STATE=='10')>
								<h5><div class="order_contain_statue">客户拒收退单</div></h5>
		                       <#elseif (item.ORDER_STATE=='11')>
								<h5><div class="order_contain_statue">店主审核中</div></h5>
		                       <#elseif (item.ORDER_STATE=='12')>
								<h5><div class="order_contain_statue">管理员审核中</div></h5>
		                       <#elseif (item.ORDER_STATE=='13')>
								<h5><div class="order_contain_statue">审核通过未退款</div></h5>
		                       <#elseif (item.ORDER_STATE=='14')>
								<h5><div class="order_contain_statue">审核通过已退款</div></h5>
		                       </#if>
		                       <!-- <div class="order_contain_statue">${item.PAY_STATE}</div> -->
		                   </div>
		                   <div class="div_clear"></div>
		                   <div class="order_line"></div>
		                   <div class="order_contain_middle">
		                       <div class="order_contain_middle_left">
		                           <img src="${imageRoot}${item.PHOTO_LINKS}" width="50" height="65">
		                       </div>
		                       <div class="order_contain_middle_middle">
		                           <h5><div>订单编号：${item.ORDER_ID}</div></h5>
		                           
		                           <h5><div>订单金额(¥)：${(item.TOPAY_FEE/1000)?string("#.##")}</div></h5>
		                           <h5><div>下单时间：${item.ORDER_TIME}</div></h5>
		                       </div>
		                       <div class="order_contain_middle_right">
		                           <img src="${resRoot}/image/orderQuery/jiantou.png" width="9" height="15">
		                       </div>
		                       <div class="div_clear"></div>
		                   </div>
		               </div>
		               
		           <!-- 传给订单详情主页面 -->
				 	 <form id="form${item_index}" method="post" action="orderDetail" style="display:none;">
				    	<input id="ORDER_ID" name="ORDER_ID" value='${item.ORDER_ID}'></input>
			    		<!--<input id="GOODS_NAME" name="GOODS_NAME" value='${item.GOODS_NAME}'></input>
				    	<input id="INCOME_MONEY" name="INCOME_MONEY" value='${item.INCOME_MONEY}'></input>
				    	<input id="Order_Time" name="Order_Time" value='${item.Order_Time}'></input>
				    	<input id="RECEIVER_NAME" name="RECEIVER_NAME" value='${item.RECEIVER_NAME}'></input>
				    	<input id="POST_ADDR" name="POST_ADDR" value='${item.POST_ADDR}'></input>
				    	<input id="MOBILE_PHONE" name="MOBILE_PHONE" value= '${item.MOBILE_PHONE}'></input>
				    	<input id="DELIVER_TIME_CODE" name="DELIVER_TIME_CODE" value='${item.DELIVER_TIME_CODE}'></input>
				    	<input id="PAY_MODE" name="PAY_MODE" value='${item.PAY_MODE}'></input>
				    	<input id="PAY_STATE" name="PAY_STATE" value='${item.PAY_STATE}'></input>
				    	<input id="PAY_REMARK" name="PAY_REMARK" value='${item.PAY_REMARK}'></input>-->
				 	 </form>
		           </div><!-- order_middle_end -->
		           
					<#if (item.ORDER_TYPE=='2' && item.ORDER_STATE=='00')>
                       <div class="order_line"></div>
			           <div style="color:green;text-align: right;padding-bottom: 5px;"><u><a href="/esp/pay/insteadPay/${hideuserid}/${item.ORDER_ID}">去支付>>></a></u></div>
                    </#if>
				</div>

				</#list>
 			</#if>
        </div><!-- order_middle_info_end -->
        </div>
    </div>


</body>
</html>