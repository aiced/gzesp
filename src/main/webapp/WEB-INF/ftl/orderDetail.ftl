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
    <![endif]-->
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
    <style type="text/css">
        .orderinfo
        {
            margin: 15px;
            font-size: 12px;
        }
    </style>
    <script type="text/javascript">
    
	$(function(){
		
		$("#stStatus").change(function(){
			
	    	var status=$('#stStatus option:selected');//选中的值
	    	if (status.val()!="-1") 
	    	{
	    		status.attr("disabled","disabled");  
	    	}
	    	else
	    	{
	    		alert("请选择该订单是否通过审核？");
	    	}
	    	
	    	//ajax 操作，刷新本界面数据   
			var parms = {'order_id':${ORDER_ID},'status':status.val()};
			$.commonFormSubmit({
			 type: "POST",
			 action: '${base}/shopManage/orderStatusUpdate',
			 data: parms,
			 success: function(data){
			  	 //history.back();
			  	 //alert("ok");
			  	 //return;
			  	 alert(data);

			  	 return;
			 }
			});
	    	
	    	
	    	
		});	
	});
    
    
 
    
    </script>
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
        <div class="orderinfo">
            <div class="list-group">
                <a href="#" class="list-group-item"><h5>订单编号：${ORDER_ID}</h5></a> 
                <a href="#" class="list-group-item"><h5>商品名称：<br/><br/>${GOODS_NAME}</h5></a> 
				<a href="#" class="list-group-item"><h5>套餐月费(¥)：${RES_ATTR_VAL_3}</h5></a>
				<a href="#" class="list-group-item"><h5>生效时间：${RES_ATTR_VAL_4}</h5></a>
                <a href="#" class="list-group-item"><h5>订单金额(¥)：${(TOPAY_FEE/1000)?string("#.##")}</h5></a>
                <a href="#" class="list-group-item"><h5>商品面值(¥)：${RES_ATTR_VAL_2}</h5></a>
                <a href="#" class="list-group-item"><h5>订购号码：${RES_ATTR_VAL_1}</h5></a>
                
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item"><h5>收货人姓名：${RECEIVER_NAME}</h5></a>
                <a href="#" class="list-group-item"><h5>收获地址：${POST_ADDR}</h5></a>
                <a href="#" class="list-group-item"><h5>联系电话：${MOBILE_PHONE}</h5></a>
                <!--<a href="#" class="list-group-item"><h5>送货日：${DELIVER_TIME_CODE}</h5></a>-->
            </div>
            <div class="list-group">
                <a href="#" class="list-group-item">
                <h5>支付方式：
				<#if (PAY_MODE=='11')>
                	银联信用卡
                <#elseif (PAY_MODE=='12')>
                	银联储蓄卡
                <#elseif (PAY_MODE=='21')>
                	支付宝
				<#else>
					未知
                </#if>
                </h5>
                </a>
                <a href="#" class="list-group-item">
                <h5>订单状态:
				<#if (ORDER_STATE=='00')>
                	待支付
                <#elseif (ORDER_STATE=='01')>
                	待分配
                <#elseif (ORDER_STATE=='02')>
                	待处理
                <#elseif (ORDER_STATE=='03')>
                	处理中
                <#elseif (ORDER_STATE=='04')>
                	待发货
                <#elseif (ORDER_STATE=='05')>
                	发货中
                <#elseif (ORDER_STATE=='06')>
                	物流在途
                <#elseif (ORDER_STATE=='07')>
                	待归档
                <#elseif (ORDER_STATE=='08')>
                	成功关闭（已归档）
                <#elseif (ORDER_STATE=='09')>
                	订单处理退单
                <#elseif (ORDER_STATE=='10')>
					客户拒收退单
				<#else>
					未知
                </#if>
                </h5>
                </a>
                <a href="#" class="list-group-item"><h5>下单时间：${Order_Time}</h5></a>
                <!-- <a href="#" class="list-group-item"><h5>缺货处理：${PAY_REMARK}</h5></a> -->
                <#if ((REFUND_STATE=="未知") || (REFUND_STATE==""))>
                <#else>
                	<a href="#" class="list-group-item">
                	<h5 style="color: red;">请谨慎选择（不可更改）</h5>
                	<br/>
                	<select class="form-control" id="stStatus">
                	  <option value="-1">请选择是否通过审核</option>
					  <option value="04">通过审核</option>
					  <option value="05">不通过审核</option>
					</select>
                	</a>
                	<a href="#" class="list-group-item">
                		退款原因：<br/>
						<textarea class="form-control" rows="3" disabled>${REFUND_REASON}</textarea>
                	</a>

                </#if>

            </div>
        </div>
    </div>



</body>
</html>