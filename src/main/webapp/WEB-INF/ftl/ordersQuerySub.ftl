        	<#if (orderList?size==0)>
	        	<div class="order_middle">
	        		您还没有订单
	        	</div>
        	<#else>
				<#list orderList as item>
		           <div class="order_middle">
		           	   <input type="hidden" name="itemindx${item_index}" id="itemindex${item_index}" value=${item_index}>
		               <div class="order_contain">
		                   <div class="order_contain_top">
		                   	   <!-- ,苹果最新手机iphone6 4.7寸大屏幕 超强性能处理器 -->
		                       <div class="order_contain_title">${item.GOODS_NAME}</div>
		                       <#if (item.PAY_STATE=='0')>
		                       	<div class="order_contain_statue">未支付</div>
		                       <#elseif (item.PAY_STATE=='1')>
		                       	<div class="order_contain_statue">已支付</div>
		                       <#elseif (item.PAY_STATE=='2')>
		                       	<div class="order_contain_statue">支付失败</div>
		                       <#elseif (item.PAY_STATE=='3')>
		                       	<div class="order_contain_statue">已冲正</div>	
		                       <#elseif (item.PAY_STATE=='4')>
		                       	<div class="order_contain_statue">冲正失败</div>
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
		                           <div>订单编号：${item.ORDER_ID}</div>
		                           <div>订单金额：${item.INCOME_MONEY}元</div>
		                           <div>下单时间：${item.ORDER_TIME}</div>
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
			    		<input id="GOODS_NAME" name="GOODS_NAME" value='${item.GOODS_NAME}'></input>
				    	<input id="INCOME_MONEY" name="INCOME_MONEY" value='${item.INCOME_MONEY}'></input>
				    	<input id="Order_Time" name="Order_Time" value='${item.Order_Time}'></input>
				    	<input id="RECEIVER_NAME" name="RECEIVER_NAME" value='${item.RECEIVER_NAME}'></input>
				    	<input id="POST_ADDR" name="POST_ADDR" value='${item.POST_ADDR}'></input>
				    	<input id="MOBILE_PHONE" name="MOBILE_PHONE" value= '${item.MOBILE_PHONE}'></input>
				    	<input id="DELIVER_TIME_CODE" name="DELIVER_TIME_CODE" value='${item.DELIVER_TIME_CODE}'></input>
				    	<input id="PAY_MODE" name="PAY_MODE" value='${item.PAY_MODE}'></input>
				    	<input id="PAY_STATE" name="PAY_STATE" value='${item.PAY_STATE}'></input>
				    	<input id="PAY_REMARK" name="PAY_REMARK" value='${item.PAY_REMARK}'></input>
				 	 </form>
		           </div><!-- order_middle_end -->
				</#list>
 			</#if>