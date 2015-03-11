<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>套餐选择</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${resRoot}/css/goodSelect.css" rel="stylesheet">
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
    	    <p class="text-center navbar-p">套餐选择</p>
    	  </div>    	
      </div>      
    </div>

  
    <!-- 号码筛选，排序 -->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;">
      <!-- 输入筛选-->
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-12" style="margin:0px;padding:0px">
    	  <div class="input-group">
            <input id='weihao' type="text" class="form-control input-sm" placeholder="">
            <span class="input-group-btn">
              <button class="btn btn-default btn-sm" type="button" onclick="queryFilter()">
                <span class="glyphicon glyphicon-search" aria-hidden="true"></span>
              </button>
            </span>
          </div>
    	</div>  		
      </div>
      <hr align="center"  color="#f4f4f4" size="1" style="margin:0" noShade>
      <!-- 销量排序 价格排序-->
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-3" style="padding:0px;margin:0px;text-align:center">
    	  <button type="button" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false">
                        销量 <span class="glyphicon glyphicon-sort" aria-hidden="true"></span>
          </button>
    	</div>  	
    	<div class="col-xs-1">
    	  <div class="shuxian"></div> 
    	</div>
    	<div class="col-xs-3" style="padding:0px;text-align:center">
    	  <button type="button" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false">
                        价格 <span class="glyphicon glyphicon-sort" aria-hidden="true"></span>
          </button>    	  
    	</div>
    	<div class="col-xs-1">
    	  <div class="shuxian"></div> 
    	</div>
    	<div class="col-xs-3" style="padding:0px;text-align:center">
    	  <button type="button" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false">
                        筛选 <span class="glyphicon glyphicon-th" aria-hidden="true"></span>
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
    
    <!-- 套餐展示表格-->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;padding:2px" id="datagrid">
      <div class="row" style="margin:0px;padding:0px;">
        <div class="col-xs-4" style="padding:1px;">
    	  <img src="${resRoot}/image/weShop/hygj.png" alt="" class="img-responsive" /> 
    	</div>
        <div class="col-xs-8" style="padding:0px;">
    	  <p class="p-td">46元3G套餐 AB计划 <font color="#F70909">预存话费一得三 超大流量免费送</font></p>
    	  <p class="p-td">得252话费</p>
    	  <p class="p-td-price">￥84</p>
    	</div>    	
      </div> 
    </div> 
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;padding:2px" id="datagrid">
      <div class="row" style="margin:0px;padding:0px;">
        <div class="col-xs-4" style="padding:0px;">
    	  <img src="${resRoot}/image/dztj/dztj_iphone6.jpg" alt="" class="img-responsive" /> 
    	</div>
        <div class="col-xs-8" style="padding:0px;">
    	  <p class="p-td">46元3G套餐 AB计划 <font color="#F70909">预存话费一得三 超大流量免费送</font></p>
    	  <p class="p-td">得252话费</p>
    	  <p class="p-td-price">￥84</p>
    	</div>    	
      </div> 
    </div>  
    
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodSelect.js?v=${resVer}"></script>
  </body>
</html>
