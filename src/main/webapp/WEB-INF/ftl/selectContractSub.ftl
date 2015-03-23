<div id="period-select" class="p-list">
    <#list dataList as item>
		<a href="javascript:void(0);"  value="${item.pageName}" data-pageVal="${item.pageVal}" >${item.pageName}</a>
	</#list>
</div>
<table class="table table-bordered">
	<tr>
  		<td id="pageVal"></td>
 	</tr>
</table>

