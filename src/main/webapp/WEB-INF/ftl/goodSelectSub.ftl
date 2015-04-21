      <!-- 查询结果无数据或者异常时展示提示信息-->
      <#if (!goodList?exists || goodList?size=0)>
        <div class="row" id="nullresult" style="margin:0 0 10px 0;padding:0px;background-color:#ffffff;"> 
          <p class="p-td-price">无更多结果</p>  	
        </div>
      </#if>
      <!-- 有数据时展示 -->    
    <#if goodList??>  
      <#list goodList as item>
        <div class="row" style="margin:0 0 10px 0;padding:0px;background-color:#ffffff;" onclick="gotoGoodDetail(${item.CTLG_CODE}, ${item.GOODS_ID});">
          <div class="col-xs-4" style="padding:1px;">
      	    <img src="${imageRoot}${item.PHOTO_LINKS}" alt="" class="img-responsive" /> 
      	  </div>
          <div class="col-xs-8" style="padding:0px;">
      	    <p class="p-td">${item.GOODS_NAME}</p>
      	    <p class="p-td-price">价格:￥<font>${item.GOODS_PRICE}</font> &nbsp;&nbsp; 销量:<font>${item.GOODS_AMOUNT}</font></p>
      	  </div>    	
        </div>
      </#list>
    </#if>