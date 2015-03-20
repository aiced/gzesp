
    <input type="hidden" id="baseRoot" value="${base}"></input>
  	<!-- nav bar -->
    <div class="container-fluid" style="background-color:#21292c;height:38px;">
      <div class="row" style="margin-top:8px;margin-left:5px;">
        <div class="col-xs-2" style="margin-top:5px;padding:0px;">
    	  <a class="left carousel-control" href="javascript:void(0);" onclick="back2Main()" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">back</span>
          </a>
    	  </div>
        <div class="col-xs-7">
    	    <p class="text-center navbar-p">选择号码</p>
    	  </div>    	
      </div>      
    </div>

  
    <!-- 号码筛选，排序 -->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;">
      <!-- 输入尾号筛选-->
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-12" style="margin:0px;padding:0px">
    	  <div class="input-group">
            <input id='keyword' type="text" class="form-control input-sm" placeholder="输入尾号">
            <span class="input-group-btn">
              <button class="btn btn-default btn-sm" type="button" onclick="queryNumberList()">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
              </button>
            </span>
          </div>
    	</div>  		
      </div>
      <hr align="center"  color="#f4f4f4" size="1" style="margin:0" noShade>
      <!-- 地市筛选 尾号筛选 预存款筛选-->           	
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-3" style="padding:0px;margin:0px;text-align:center">
    	  <div class="dropdown">
            <button id="btnCity" type="button" class="btn btn-default btn-sm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" eparchy_code="850">
                        贵阳
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
              <#list citys as item>  
                <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="eparchyFilter();" city_code="${item.CITY_CODE}">${item.CITY_NAME}</a></li> 
              </#list>
            </ul>
          </div>
    	</div>  	
    	<div class="col-xs-1">
    	  <div class="shuxian"></div> 
    	</div>
    	<div class="col-xs-3" style="padding:0px;text-align:center">
    	  <div class="dropdown">
            <button id="dLabel" type="button" class="btn btn-default btn-sm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             尾号规律
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
              <#list rules as item>  
                <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="ruleFilter()">${item.NICE_RULE}</a></li> 
              </#list>
            </ul>
          </div>  
    	</div>
    	<div class="col-xs-1">
    	  <div class="shuxian"></div> 
    	</div>
    	<div class="col-xs-3" style="padding:0px;text-align:center">
    	  <div class="dropdown">
            <button id="dLabel" type="button" class="btn btn-default btn-sm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                             预存款
              <span class="caret"></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-center" role="menu" aria-labelledby="dLabel">
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="feeFilter()" nice_fee="0-0">0</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="feeFilter()" nice_fee="1-100">1-100</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="feeFilter()" nice_fee="101-200">101-200</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="feeFilter()" nice_fee="201-500">201-500</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="feeFilter()" nice_fee="501-1000">501-1000</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="feeFilter()" nice_fee="1000-10000">1000以上</a></li>
            </ul>
          </div>    	  
        </div>   		    		
      </div>
      <hr align="center"  color="#f4f4f4" size="a" style="margin:0" noShade>
      <!-- 号码排序 价格排序-->
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-5" style="padding:0px;margin:0px;text-align:center">
    	  <button type="button" id="serial_number" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false" clicktimes="0" onclick="sortNumberList('serial_number')">
                        号码 <span class="glyphicon glyphicon-sort" aria-hidden="true"></span>
          </button>
    	</div>  	
    	<div class="col-xs-1">
    	  <div class="shuxian"></div> 
    	</div>
    	<div class="col-xs-5" style="padding:0px;text-align:center">
    	  <button type="button" id="nice_fee" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false" clicktimes="0" onclick="sortNumberList('nice_fee')">
                        价格 <span class="glyphicon glyphicon-sort" aria-hidden="true"></span>
          </button>    	  
    	</div>  		    		
      </div>
    </div>

    <!-- 号码展示表格-->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;" id="datagrid" pageNum="1">
      <!-- 查询结果无数据或者异常时展示提示信息-->
      <#if  (!numbers?exists || numbers?size=0)>
        <div class="row"> 
          <p class="p-td-price">查询无结果</p>  	
        </div>     
      </#if>
      <!-- 有数据时展示 -->       
      <#list numbers as item>  
        <#if item_index%2==0>
          <div class="row">
            <div class="col-xs-6 border-td-left" style="padding:0px;" >
        <#else>
            <div class="col-xs-6 border-td-right" style="padding:0px;">
        </#if>
    	      <p class="p-td-number" onclick="clickOneNumber()">${item.SERIAL_NUMBER[0..2]} ${item.SERIAL_NUMBER[3..6]} ${item.SERIAL_NUMBER[7..10]}</p>
    	      <p class="p-td-price">预存话费:${item.NICE_FEE}</p>
    	    </div>
        <#if (item_index%2==1 || !item_has_next)>
          </div> 
        </#if>
      </#list>            
    </div>    

