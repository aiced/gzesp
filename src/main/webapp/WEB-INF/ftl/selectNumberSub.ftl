      <#list numbers as item>  
        <#if item_index%2==0>
          <div class="row">
            <div class="col-xs-6 border-td-left" style="padding:0px;">
        <#else>
            <div class="col-xs-6 border-td-right" style="padding:0px;">
        </#if>
    	      <p class="p-td-number">${item.number[0..2]} ${item.number[3..6]} ${item.number[7..10]}</p>
    	      <p class="p-td-price">预存话费:${item.fee}</p>
    	    </div>
        <#if (item_index%2==1 || !item_has_next)>
          </div> 
        </#if>
      </#list>            