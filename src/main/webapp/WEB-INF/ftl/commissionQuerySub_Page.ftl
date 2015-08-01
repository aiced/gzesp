<#if (commList?size==0)>
<#else>
<table class="table table-hover table-striped table-condensed" style="table-layout: fixed;text-align: center;">
	<#list commList as item>
		<tr>
	      <td style="width:100px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">${item.GOODS_NAME}</td><!--商品名称 -->
	      <td style="width:80px;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;" onclick="doneClick(this);"><span style="border-bottom:1px solid #999999;">${item.RECEIVER_NAME}-${item.ORDER_ID}</span></td><!-- 订单号-->
		  <td>
	      	<#if (item.SUM_CMS_MONEY== '')>
		      		<#if (item.CMS_TYPE == '0')> <!-- 比例 -->
		      			${(item.CMS_PRE_FEE/1000)?string("#.##")} <!-- 预期 -->
		      		<#elseif (item.CMS_TYPE=='1')><!-- 奖励 -->
		      			${(item.CMS_PRE_FEE/1000)?string("#.##")}<label style="color: red;">(奖)</label> <!-- 预期 -->
		      		<#else><!-- 未知 -->
		      			未知
		      		</#if>
		      	<#else>
		      		<#if (item.CMS_TYPE_DAILLY == '0')> <!-- 比例 -->
		      			${(item.SUM_CMS_MONEY/1000)?string("#.##")}<!-- 实际 -->
		      		<#elseif (item.CMS_TYPE_DAILLY=='1')><!-- 奖励 -->
		      			${(item.SUM_CMS_MONEY/1000)?string("#.##")}<!-- 实际 --><label style="color: red;">(奖)</label> <!-- 预期 -->
		      		<#else><!-- 未知 -->
		      			未知
		      		</#if>
		      	</#if>      
		  </td><!-- 预期-->
	     
	      <td>
	      	<#if (item.CMS_STATE == "")>
	      		<span class="label label-default">未知</span>
	      	<#elseif (item.CMS_STATE=='00')><!-- 未激活-->
	      		<span class="label label-default">未激活</span>
	      	<#elseif (item.CMS_STATE=='01')><!-- 结算中 -->	
	      		<span class="label label-primary">结算中</span>
	      	<#elseif (item.CMS_STATE=='02')><!-- 待发放 -->
	      		<span class="label label-success">待发放</span>
	      	<#elseif (item.CMS_STATE=='03')><!-- 已退货-->
	      		<span class="label label-warning">已退货</span>
	      	<#elseif (item.CMS_STATE=='04')><!-- 已失效-->
	      		<span class="label label-danger">已失效</span>	
	      	</#if>
	      </td><!-- 状态 -->
		</tr>
	</#list>
	</table>
</#if>