<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>我的订单</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/goodSelect.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    
      <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodSelect.js?v=${resVer}"></script>
    
    <style>
    	 .goodsState a{
    	 	float:left;width:18%;height:32px;line-height:32px;margin:0 2% 10px 0;text-align:center;border-right:1px solid #ccc;font-weight:bold;font-size:13px;color:#2f3e46;
			text-decoration:none;
    	 }
    	 .goodsState a:last-child{
    		border-right-style:none;
    	}
    	 .goodsState a:visited{color:#2F3E46;}
    	 .goodsState a:focus{outline-style:none;}
    	 .goodsState a.selected{color:#e8742b;}
    </style>
    <script type="text/javascript">
// 	    $(function() {
// 		    $('.goodsState a').bind("click",function(){
// 				$(this).addClass("selected").siblings().removeClass("selected");
// 				alert($(this).attr("value"));
// 				return false;
// 			});
// 	    })
	    
	    function showCustOrderDetail(orderId) {
        	//alert(orderId);
        	location.href = "${base}/customer/custOrderDetail/"+orderId;
        	return false;
	    }
	    
	    function custOrderFilter() {
	    	var param = {"keyword": $('#keyword').val(),
	    			"cust_passport": $('#cust_passport').val(),
	    			"cust_phone": $('#cust_phone').val()};
	    	$.ajax({
	 		   type: "POST",
	 		   contentType:"application/json", //发送给服务器的内容编码类型
	 		   url: "${base}/customer/custOrderFilterByAjax",
	 		   //dataType:"json", //预期服务器返回的数据类型
	 		   data: JSON.stringify(param), //服务器只能接收json字符串
	 		   success: function(data){
	 			   //alert(data);
	 			   $('#datagrid').html(data);
	 		   }
	 		});
	    }
    </script>
  </head>

  <body>
  	<!-- nav bar -->
	<div id="top">
	  <div id="top_left">
	    <a href="javascript:history.back(-1);">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    </a>
	  </div>
	  <div id="top_middle">我的订单</div>
	  <div id="top_right"></div>
	</div>       

  
    <div class="container-fluid" >
    
	    <!-- 销量价格筛选，排序 -->
	    <div class="container-fluid" >
	      <!-- 输入筛选-->
	      <div class="row" style="margin-top:10px;background-color:#ffffff;">
	    	<div class="col-xs-12" style="padding:0" >
	    	  <div class="input-group">
	            <input id='keyword' type="text" class="form-control input-sm" placeholder="输入关键字">
	            <span class="input-group-btn">
	              <button class="btn btn-default btn-sm" type="button" onclick="custOrderFilter()">
	                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
	              </button>
	            </span>
	          </div>
	    	</div>  		
	      </div>
	      <!-- 销量排序 价格排序-->
	      <div class="row goodsState" style="margin:10px 0px 5px 0px;">
<!-- 	      	<div class="col-xs-12">  -->
<!-- 		    	<a href="#" value="1">全部</a>     	 -->
<!-- 		    	<a href="#" value="2">待付款</a> -->
<!-- 		    	<a href="#">待发货</a>	    		 -->
<!-- 		    	<a href="#">待收货</a>    		 -->
<!-- 		    	<a href="#">待评价</a> -->
<!-- 	    	</div>   -->
<!-- 	    	<div class="col-xs-2" ><a href="#">全部</a>    	</div>  	 -->
<!-- 	    	<div class="col-xs-3" ><a href="#">待付款</a>    	</div> -->
<!-- 	    	<div class="col-xs-3" >待发货    	</div>  		    		 -->
<!-- 	    	<div class="col-xs-2" >待收货    	</div>  		    		 -->
<!-- 	    	<div class="col-xs-2"> 待评价    	</div>   -->
	      </div>
	    </div>
	    
	    <!-- 套餐展示表格-->
	    <div class="container-fluid" style="margin:10px;padding:0px" id="datagrid" pageNum="1">
	      <!-- 查询结果无数据或者异常时展示提示信息-->
	      <#if  (!custMyOrderList?exists || custMyOrderList?size=0)>
	        <div class="row" id="nullresult" style="margin:0 0 10px 0;padding:0px;background-color:#ffffff;"> 
	          <p class="p-td-price">查询无结果</p>  	
	        </div>
	      <#else>
	      <!-- 有数据时展示 -->
		      <#list custMyOrderList as item>
		      	<div onclick="showCustOrderDetail(${item.ORDER_ID})">
			        <div class="row" style="margin-top:15px;margin-bottom:1px;background-color:#ffffff;">
			        	<div class="col-xs-9" >	
			        			<p>订单号：${item.ORDER_ID}</p>
			        	</div>
			        	<div class="col-xs-3" style="padding:0">	
			        			<p class="text-right">${item.ORDER_STATE}</p>
			        	</div>
			        </div> 
			        
			        <div class="row" style="background-color:#ffffff;" >
	<!-- 		        	<div class="col-xs-1" ></div> -->
			        	<div class="col-xs-2 col-xs-offset-1" >
			      	    	<img src="${imageRoot}${item.USER_IMG}" alt="" class="img-responsive" /> 
			      	  	</div>
			        	<div class="col-xs-9" >
			      	    	<span>${item.STORE_NAME}</span>
			      	  	</div>
			        </div>
			        
			        <div class="row" style="background-color:#ffffff;" >
			          <div class="col-xs-4" style="padding:1px;">
			      	    <img src="${imageRoot}${item.PHOTO_LINKS}" alt="" class="img-responsive" /> 
			      	  </div>
			          <div class="col-xs-8" style="padding:0px;">
			      	    <p class="p-td">${item.GOODS_NAME}</p>
			      	    <p class="p-td-price"> <font>${item.SALE_NUM}件</font>&nbsp;&nbsp; ￥<font>${item.TOPAY_FEE}</font></p>
			      	  </div>    	
			        </div>
		        </div>
		      </#list>
	      </#if>
	    </div> 
    </div> 
    
    <input type="hidden" id="cust_passport" name="cust_passport" value="${cust_passport}" />
    <input type="hidden" id="cust_phone" name="cust_phone" value="${cust_phone}" />
    
     
  </body>
</html>
