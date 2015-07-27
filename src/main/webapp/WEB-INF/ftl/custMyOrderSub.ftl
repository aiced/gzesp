
	    <!-- 套餐展示表格-->
	      <!-- 查询结果无数据或者异常时展示提示信息-->
	      <#if  (!custMyOrderList?exists || custMyOrderList?size=0)>
	       <!--  <div class="row" id="nullresult" style="margin:0 0 10px 0;padding:0px;background-color:#ffffff;"> 
	          <p class="p-td-price">查询无结果</p>  	
	        </div> -->
	      <#else>
	      <!-- 有数据时展示 -->
		      <#list custMyOrderList as item>
		      	<div onclick="showCustOrderDetail(${item.ORDER_ID})">
			        <div class="row" style="margin-top:15px;margin-bottom:1px;background-color:#ffffff;">
			        	<div class="col-xs-7" >	
			        			<p>订单号：${item.ORDER_ID}</p>
			        	</div>
			        	<div class="col-xs-5" style="padding:0">	
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
    