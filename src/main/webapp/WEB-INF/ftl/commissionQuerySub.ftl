<#if (commList?size==0)>
	您没有佣金
<#else>
<table class="table table-hover table-striped table-condensed" style="table-layout: fixed;">
    <tr>
        <th><div class="th_title">商品名称</div></th>
        <th><div class="th_title">订单详情</div></th>
        <th><div class="th_title">收益</div></th>
        <th>
				<div class="btn-group" role="group" aria-label="...">
					<div class="btn-group" role="group">
						<div class="dropdown-toggle"
							data-toggle="dropdown" aria-expanded="false">
							状态
							<span class="caret"></span>
						</div>
						<ul class="dropdown-menu" role="menu">
							<!-- <li><a href="#">可领取</a></li>
							<li role="presentation" class="divider"></li>
							<li><a href="#">冻结</a></li>
							 -->
							<li onclick="doStatusClick(this);"><a href="#">可提现</a></li>
							<li role="presentation" class="divider"></li>
							<li onclick="doStatusClick(this);"><a href="#">无效单</a></li>
							<li role="presentation" class="divider"></li>
							<li onclick="doStatusClick(this);"><a href="#">结算中</a></li>
							<li role="presentation" class="divider"></li>
							<li onclick="doStatusClick(this);"><a href="#">未激活</a></li>
						</ul>
					</div>
				</div>
			</th>
    </tr>
	<#list commList as item>
		<tr>
	      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:74px;">${item.GOODS_NAME}</td><!--商品名称 -->
	      <td style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:59px;" onclick="doneClick(this);">${item.RECEIVER_NAME}-${item.ORDER_ID}</td><!-- 订单号-->
		  <td>
	      	<#if (item.SUM_CMS_MONEY== '')>
	      		${item.CMS_PRE_FEE}
	      	<#else>
	      		${item.SUM_CMS_MONEY}
	      	</#if>      
		  </td><!-- 预期-->
	     
	      <td>
	      	<#if (item.ACT_STATUS=='0'  && item.CMS_MONTH=='')><!-- 没激活没到时间:未激活 -->
	      		<span class="label label-default">未激活</span>
	      	<#elseif (item.ACT_STATUS=='0' && item.CMS_MONTH!='')><!-- 没激活到时间:无效单 -->	
	      		<span class="label label-primary">无效单</span>
	      	<#elseif (item.ACT_STATUS=='1' && item.CMS_MONTH=='')><!-- 激活没到时间:结算中 -->
	      		<span class="label label-warning">结算中</span>
	      	<#elseif (item.ACT_STATUS=='1' && item.CMS_MONTH!='')><!-- 激活到时间 :可提现-->
	      		<span class="label label-success">可提现</span>
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