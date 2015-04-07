<#if (commList?size==0)>
	您没有佣金
<#else>
<table class="table table-hover table-striped table-condensed">
    <tr>
        <th>序号</th>
        <th>商品名称</th>
        <th>订单号</th>
        <th>销售金额</th>
        <th>佣金</th>
    </tr>
	<#list commList as item>
		<tr onclick="doneClick(this);">
	      <td>${item_index}</td><!-- 序号 -->
	      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:74px;">${item.GOODS_NAME}</td><!--商品名称 -->
	      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:59px;">${item.ORDER_ID}</td><!-- 订单号-->
	      <td>${item.CMS_SUM_MONEY}</td><!-- 销售金额 -->
	      <td>${item.CMS_MONEY}</td><!-- 佣金 -->
		</tr>
	</#list>
    <tr>
    	<td colspan="3"><h4><label class="query_info_left">合计</label></h4></td>
    	<td><h4><label>200</label></h4></td>
    	<td><h4><label>300</label></h4></td>
    </tr>
</table>
</#if>