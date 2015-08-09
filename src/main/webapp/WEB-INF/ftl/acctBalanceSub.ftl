		<#if (acctloglist?? && acctloglist?size>0) > 
			<#list acctloglist as item>
				<li class = "li_row border_bottom">
				<div class = "row_left">
					<p class = "row_left_title">${item.TRADE_TYPE}/ ${item.CANCEL_TAG} </p>
					<#if (item.ORDER_ID) > 
						<span class = "row_left_order"> (订单号：${item.ORDER_ID}) </span>
					</#if>
					<p class = "row_left_time">${item.UPDATE_TIME}</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">${item.FEE} </p>
					<p class = "row_right_audit" name = "row_right_audit">${item.AUDIT_STATE}</p>
				</div>
				<div style="clear:both;"></div> 
			   </li>			
			</#list>
		<#else>
			 	<div class = "noBill">
			 		没有账单			
			 	</div>
	 	</#if>