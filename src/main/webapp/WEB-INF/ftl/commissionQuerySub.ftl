<#if (commList?size==0)>
<table class="table table-hover table-striped table-condensed" style="table-layout: fixed;text-align: center;">
    <tr>
        <th><div class="th_title">商品名称</div></th>
        <th><div class="th_title">订单详情</div></th>
        <th><div class="th_title">收益(¥)</div></th>
        <th>
			<div class="dropdown" style="padding:0px;">
				<button class="btn dropdown-toggle" style="background-color: transparent;padding: 0px;margin: 0px;font-weight: bold;" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="false">
				    	状态
				    <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<!-- <li><a href="#">可领取</a></li>
					<li role="presentation" class="divider"></li>
					<li><a href="#">冻结</a></li>
					 -->
					<li onclick="doStatusClick(this);"><a href="#">全部</a></li> 
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">未激活</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">结算中</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">已到帐</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">已退货</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">已失效</a></li>
				</ul>
			</div>
		</th>
    </tr>
	<tr>
		<td colspan="4">您没有收益</td>
	</tr>
	<tr id="totalRowCount">

   	</tr>
    <tr id="totalRow">

    </tr>
</table>
	
	
<#else>
<table class="table table-hover table-striped table-condensed" style="table-layout: fixed;text-align: center;">
    <tr>
        <th><div class="th_title">商品名称</div></th>
        <th><div class="th_title">订单详情</div></th>
        <th><div class="th_title">收益(¥)</div></th>
        <th>
			<div class="dropdown th_title" style="padding:0px;">
				<button class="btn dropdown-toggle" style="background-color: transparent;padding: 0px;margin: 0px;font-weight: bold;" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="false">
				    	状态
				    <span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<!-- <li><a href="#">可领取</a></li>
					<li role="presentation" class="divider"></li>
					<li><a href="#">冻结</a></li>
					 -->
					<li onclick="doStatusClick(this);"><a href="#">全部</a></li> 
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">未激活</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">结算中</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">已到帐</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">已退货</a></li>
					<li role="presentation" class="divider"></li>
					<li onclick="doStatusClick(this);"><a href="#">已失效</a></li>
				</ul>
			</div>
		</th>
    </tr>
	<#list commList as item>
		<tr>
	      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:74px;">${item.GOODS_NAME}</td><!--商品名称 -->
	      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:59px;" onclick="doneClick(this);">${item.RECEIVER_NAME}-${item.ORDER_ID}</td><!-- 订单号-->
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
		      		<#if (item.CMS_TYPE == '0')> <!-- 比例 -->
		      			${(item.SUM_CMS_MONEY/1000)?string("#.##")}<!-- 实际 -->
		      		<#elseif (item.CMS_TYPE=='1')><!-- 奖励 -->
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
	      	<#elseif (item.CMS_STATE=='02')><!-- 已到帐 -->
	      		<span class="label label-success">已到帐</span>
	      	<#elseif (item.CMS_STATE=='03')><!-- 已退货-->
	      		<span class="label label-warning">已退货</span>
	      	<#elseif (item.CMS_STATE=='04')><!-- 已失效-->
	      		<span class="label label-danger">已失效</span>	
	      	</#if>
	      </td><!-- 状态 -->
		</tr>
	</#list>
	<tr id="totalRowCount">

   	</tr>
    <tr id="totalRow">

    </tr>
</table>
</#if>