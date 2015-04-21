      <!-- 查询结果无数据或者异常时展示提示信息-->
      <#if  (!numbers?exists || numbers?size=0)>
        <div class="row"> 
          <p class="p-td-price">无更多结果</p>  	
        </div>     
      </#if>
      <!-- 有数据时展示 -->       
      <#list numbers as item>  
        <#if item_index%2==0>
          <div class="row">
            <div class="col-xs-6 border-td-left" style="padding:0px;">
        <#else>
            <div class="col-xs-6 border-td-right" style="padding:0px;">
        </#if>
    	      <p class="p-td-number" onclick="clickOneNumber(this)">${item.SERIAL_NUMBER[0..2]} ${item.SERIAL_NUMBER[3..6]} ${item.SERIAL_NUMBER[7..10]}</p>
    	      <p class="p-td-price" nice_fee="${item.NICE_FEE}">预存话费:${item.NICE_FEE}</p>
    	    </div>
        <#if (item_index%2==1 || !item_has_next)>
          </div> 
        </#if>
      </#list>                      