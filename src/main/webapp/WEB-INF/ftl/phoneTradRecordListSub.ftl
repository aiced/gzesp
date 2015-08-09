<#list topUpDealList as info>			
	            <li class="rel" orderId = "${info.orderId}"}>
	          	 	<#if ('${from}' =='renewal')>
	            	    <p class="title"> ${info.goodsName}</p>
	            	<#else>
	            		 <p class="title"> ${info.goodsName} － ${info.phoneNumber} </p>
	            	</#if>              	

					<#if (info.orderState =='00')>
  				        <p class="status"> 未支付 </p>
                	<#elseif (info.orderState =='01')>
			 			 <p class="status"> 支付成功 </p> 
			 		<#elseif (info.orderState =='02')>
			 			 <p class="status"> 支付成功待充值 </p> 
			 		<#elseif (info.orderState =='99')>
			 			 <p class="status"> 取消 </p> 
                	</#if>          			 
           			 <p class="date"> ${info.createTime} </p>
            		<span class="abs"> ￥${info.topayMoney} </span>
       			 </li>
			</#list>   