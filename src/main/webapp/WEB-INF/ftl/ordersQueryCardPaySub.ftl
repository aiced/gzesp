        	<#if (!czcardlist?exists)>

        	<#else>
				<#list czcardlist as item>
				<div class="order_middle_contain">
		           <div class="order_middle">
		           	   <input type="hidden" name="itemindx${item_index}" id="itemindex${item_index}" value=${item_index}>
		               <div class="order_contain">
	                   		<div class="order_contain_top">
		                   	   <!-- ,苹果最新手机iphone6 4.7寸大屏幕 超强性能处理器 -->
		                       <h5><div class="order_contain_title">${item.GOODS_NAME}</div></h5>
		                       <#if (item.ORDER_STATE=='00')>
		                       	<h5><div class="order_contain_statue">待支付</div></h5>
		                       <#elseif (item.ORDER_STATE=='01')>
		                       	<h5><div class="order_contain_statue">支付成功待充值</div></h5>
		                       <#elseif (item.ORDER_STATE=='02')>
		                       	<h5><div class="order_contain_statue">充值成功</div></h5>
		                       </#if>
		                       <!-- <div class="order_contain_statue">${item.PAY_STATE}</div> -->
		                   </div>
		                   <div class="div_clear"></div>
		                   <div class="order_line"></div>
		                   <div class="order_contain_middle">
		                       <div class="order_contain_middle_left">
		                           <img src="${imageRoot}${item.PHOTO_LINKS}" width="50" height="65" alt="产品图片">
		                       </div>
		                       <div class="order_contain_middle_middle">
		                           <h5><div>订单编号：${item.ORDER_ID}</div></h5>
		                           <h5><div>订单金额(¥)：#{item.TOPAY_MONEY/1000;m1M2}</div></h5>
		                           <h5><div>下单时间：${item.CREATE_TIME}</div></h5>
		                       </div>
		                       <div class="order_contain_middle_right">
		                           <img src="${resRoot}/image/orderQuery/jiantou.png" width="9" height="15" style="display: none;">
		                       </div>
		                       <div class="div_clear"></div>
		                   </div>
		               </div>
		               
		           <!-- 传给订单详情主页面 -->
				 	 <form id="form${item_index}" method="post" action="orderDetail" style="display:none;">
				    	<input id="ORDER_ID" name="ORDER_ID" value='${item.ORDER_ID}'></input>
				 	 </form>
		           </div><!-- order_middle_end -->
					<#if (item.ORDER_TYPE=='2' && item.ORDER_STATE=='00')>
                       <div class="order_line"></div>
			           <div style="color:green;text-align: right;padding-bottom: 5px;"><u><a href="/esp/pay/insteadPay/${item.USER_ID}/${item.ORDER_ID}">去支付>>></a></u></div>
                    </#if>
				</div>
				</#list>
 			</#if>