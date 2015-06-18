<#if (costList?size == 0) > 
		   	
		<#else>
			<#list costList as item>
				<li class = "row border_bottom">
				<div class = "row_left">
					<p class = "row_left_title">${item.orderType} <span class = "row_left_subtitle"> (订单号：31445) </span> </p>
					<p class = "row_left_time">${item.createTime}</p>
				</div>
				<div class = "row_right">
					<p class = "row_right_num_normal" name ="row_right_num">${item.payNum} </p>
					<p class = "row_right_audit" name = "row_right_audit">${item.state}</p>
				</div>
				<div style="clear:both;"></div> 
				</li>
			
			</#list>
</#if>