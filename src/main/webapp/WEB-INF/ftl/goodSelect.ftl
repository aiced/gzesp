<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>商品选择</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/goodSelect.css?v=${resVer}" rel="stylesheet">
  </head>

  <body>
    <input type="hidden" id="baseRoot" value="${base}"></input>
    <input type="hidden" id="user_id" value="${user_id}"></input>
    <input type="hidden" id="good_type" value="${good_type}"></input>
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
    	    <p class="text-center navbar-p">商品选择</p>
    	  </div>    	
      </div>      
    </div>

  
    <!-- 销量价格筛选，排序 -->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;">
      <!-- 输入筛选-->
      <div class="row" style="margin:5px 0px 5px 0px;">
    	<div class="col-xs-12" style="margin:0px;padding:0px">
    	  <div class="input-group">
            <input id='keyword' type="text" class="form-control input-sm" placeholder="输入商品名称关键字">
            <span class="input-group-btn">
              <button class="btn btn-default btn-sm" type="button" onclick="queryPhoneList()">
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
    	  <button type="button" id="goods_amount" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false" clicktimes="0" onclick="sortPhoneList('goods_amount')">
                        销量 <span class="glyphicon glyphicon-sort" aria-hidden="true"></span>
          </button>
    	</div>  	
    	<div class="col-xs-1">
    	  <div class="shuxian"></div> 
    	</div>
    	<div class="col-xs-3" style="padding:0px;text-align:center">
    	  <button type="button" id="goods_price" class="btn btn-default btn-sm"  aria-haspopup="true" aria-expanded="false" clicktimes="0" onclick="sortPhoneList('goods_price')">
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
    
    <!-- 套餐展示表格-->
    <div class="container-fluid" style="margin:10px;padding:0px" id="datagrid" pageNum="1">
      <!-- 查询结果无数据或者异常时展示提示信息-->
      <#if  (!goodList?exists || goodList?size=0)>
        <div class="row" id="nullresult" style="margin:0 0 10px 0;padding:0px;background-color:#ffffff;"> 
          <p class="p-td-price">查询无结果</p>  	
        </div>
      </#if>
      <!-- 有数据时展示 -->
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
    </div> 
    
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodSelect.js?v=${resVer}"></script>
  </body>
</html>
