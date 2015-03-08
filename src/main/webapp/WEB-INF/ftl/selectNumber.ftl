<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>新号入网</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resRoot}/css/selectNumber.css" rel="stylesheet">
  </head>

  <body>
  	<!-- nav bar -->
    <div class="container-fluid" style="background-color:#21292c;height:38px;">
      <div class="row" style="margin-top:8px;margin-left:5px;">
        <div class="col-xs-2" style="margin-top:5px;padding:0px;">
    	  <a class="left carousel-control" href="javascript:history.back(-1);" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">back</span>
          </a>
    	  </div>
        <div class="col-xs-7">
    	    <p class="text-center navbar-p">新号入网</p>
    	  </div>    	
      </div>      
    </div>

  
    <!-- 号码筛选，排序 -->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;">
      <!-- 输入尾号筛选-->
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-12" style="margin:0px;padding:0px">
    	  <div class="input-group">
            <input type="text" class="form-control input-sm" placeholder="输入尾号">
            <span class="input-group-btn">
              <button class="btn btn-default btn-sm" type="button">搜索</button>
            </span>
          </div>
    	</div>  		
      </div>
      <hr align="center"  color="#f4f4f4" size="1" style="margin:0" noShade>
      <!-- 地市筛选 尾号筛选 预存款筛选-->           	
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-3" style="padding:0px;margin:0px;text-align:center">
    	  <div class="dropdown">
            <button id="btnCity" type="button" class="btn btn-default btn-sm" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        贵阳
            <span class="caret"></span>
            </button>
            <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
              <#list citys as item>  
                <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="cityFilter();" city_code="${item.city_code}">${item.city_name}</a></li> 
              </#list>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#" onclick="cityFilter();">贵阳</a></li>
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
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">AA</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">AAA</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ABC</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ABCD</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">ABAB</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">AABB</a></li>
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
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">0</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">1-100</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">101-200</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">201-500</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">501-1000</a></li>
              <li role="presentation"><a role="menuitem" tabindex="-1" href="#">1000以上</a></li>
            </ul>
          </div>    	  
        </div>   		    		
      </div>
      <hr align="center"  color="#f4f4f4" size="a" style="margin:0" noShade>
      <!-- 号码排序 价格排序-->
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-5" style="padding:0px;margin:0px;text-align:center">
    	  <button type="button" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false">
                        号码 <span class="glyphicon glyphicon-sort" aria-hidden="true"></span>
          </button>
    	</div>  	
    	<div class="col-xs-1">
    	  <div class="shuxian"></div> 
    	</div>
    	<div class="col-xs-5" style="padding:0px;text-align:center">
    	  <button type="button" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false">
                        价格 <span class="glyphicon glyphicon-sort" aria-hidden="true"></span>
          </button>    	  
    	</div>  		    		
      </div>
    </div>

    <!-- 查询结果无数据或者异常时展示提示信息-->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;display:none;">
      <div class="row"> 
        <p class="p-td-price">查询无结果</p>  	
      </div>            
    </div> 
        
    <!-- 号码展示表格-->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;">
      <!--
      <div class="row">
        <div class="col-xs-6 border-td-left" style="padding:0px;">
    	  <p class="p-td-number">185 1234 1234</p>
    	  <p class="p-td-price">预存话费:0</p>
    	</div>
        <div class="col-xs-6 border-td-right" style="padding:0px;">
    	  <p class="p-td-number">185 1234 1234</p>
    	  <p class="p-td-price">预存话费:0</p>
    	</div>    	
      </div> 
      <div class="row">
        <div class="col-xs-6 border-td-left" style="padding:0px;">
    	  <p class="p-td-number">185 1234 1234</p>
    	  <p class="p-td-price">预存话费:0</p>
    	</div>
        <div class="col-xs-6 border-td-right" style="padding:0px;">
    	  <p class="p-td-number">185 1234 1234</p>
    	  <p class="p-td-price">预存话费:0</p>
    	</div>    	
      </div>
      -->
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
    </div>    

    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/selectNumber.js?v=${resVer}"></script>
  </body>
</html>
