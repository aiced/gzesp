     		<#list topUpDealList as info>			
	            <li class="rel" orderId = "${info.orderId}"}>
           			 <p class="title"> ${info.goodsName} － ${info.phoneNumber} </p>

					<#if (info.orderState =='00')>
  				        <p class="status"> 未支付 </p>
                	<#elseif (info.orderState =='02')>
			 			 <p class="status"> 支付成功 </p> 
                	</#if>          			 
           			 <p class="date"> ${info.createTime} </p>
            		<span class="abs"> ￥${info.topayMoney} </span>
       			 </li>
			</#list> 