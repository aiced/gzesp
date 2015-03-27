 <span class="input-group-addon" id="sizing-addon3">区</span>
<select name="selDistrict" id="selDistrict" class="form-control" placeholder="请选择地区" aria-describedby="sizing-addon3">
  		<#if (districts?? && districts?size>0)>
		<#list districts as item>
			<option value="${item.districtCode}">${item.districtName}</option>
		</#list>
		<#else>
		<option value="数据加载失败">数据加载失败</option>
		</#if>
</select>