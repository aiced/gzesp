		      		<#if eparchyList??>
		      		    <option value="开户银行地市">开户银行地市</option>
						<#list eparchyList as item>						
						    <option value="${item.EPARCHY_CODE}" >
							${item.EPARCHY_NAME}
							</option>
						</#list>
		 			</#if>

		      		<#if cityList??>
		      		    <option value="开户银行区县">开户银行区县</option>
						<#list cityList as item>						
						    <option value="${item.CITY_CODE}" >
							${item.CITY_NAME}
							</option>
						</#list>
		 			</#if>		 			