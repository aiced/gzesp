<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>套餐详情</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain2.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain3.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/selectNumber.css?v=${resVer}" rel="stylesheet">    
  </head>

  <body>
  <!-- -->
  <form id="form1" action="${base}/order/newNumberJoin" style="display:none;">
    <input id="user_id" value="${user_id}"></input>

  </form>
  <!-- 第一页 商品详情主页start --> 
  <div id="page_main">   
  	<!-- nav bar -->
    <div class="container-fluid" style="background-color:#21292c;height:38px;">
      <div class="row" style="margin-top:8px;margin-left:5px;">
        <div class="col-xs-2" style="margin-top:5px;padding:0px;">
    	  <a class="left carousel-control" href="javascript:history.back(-1);" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">back</span>
          </a>
    	</div>
        <div class="col-xs-8">
    	  <p class="text-center navbar-p">套餐详情 </p>
    	</div>
    	<div class="col-xs-2" style="margin:0px;padding:0px;">
          <button class="btn btn-primary btn-sm" style="background-color:#21292c;" data-toggle="modal" data-target="#myModal">分享</button>
        </div> 
      </div>      
    </div> 
  
    <!-- 分享到弹出框 -->    
    <div id="myModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content" style="padding:5px;height:80px;">
    	    分享到：
          <!-- Baidu Button BEGIN -->
          <div class="bdsharebuttonbox">
            <a class="bds_more" href="#" data-cmd="more"></a>
            <a title="分享到QQ空间" class="bds_qzone" href="#" data-cmd="qzone"></a>
            <a title="分享到新浪微博" class="bds_tsina" href="#" data-cmd="tsina"></a>
            <a title="分享到腾讯微博" class="bds_tqq" href="#" data-cmd="tqq"></a>
            <a title="分享到人人网" class="bds_renren" href="#" data-cmd="renren"></a>
            <a title="分享到微信" class="bds_weixin" href="#" data-cmd="weixin"></a>
          </div>
          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
          <!-- Baidu Button END -->   
        </div>
      </div>
    </div>  

    <!-- Carousel 广告轮播-->	
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="background-color:#f1791a">
      <ol class="carousel-indicators">
        <#list banners as item>  
          <#if item_index=0>
            <li data-target="#myCarousel" data-slide-to="${item_index}" class="active"></li>
          <#else>
            <li data-target="#myCarousel" data-slide-to="${item_index}"></li>
          </#if>  
        </#list>  
      </ol>
      <div class="carousel-inner" role="listbox">
        <#list banners as item>
          <#if item_index=0>
            <div class="item active">
          <#else>
            <div class="item">
          </#if>
              <img src="${imageRoot}${item.PHOTO_LINKS}" alt="" />
              <div class="container">
                <div class="carousel-caption">
              </div>
            </div>
        </div>
        </#list>
      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>      
    </div>
    
    <!-- 商品描述 -->
    <div class="num-info">
        <ul>
            <li class="goods-info">
                <i class="collect"></i>
                <!--<a id="onlineChat" class="service mrg-t-0" href="javascript:void();"><i></i>导购</a> -->
                <p class="goods-desp">${detail.GOODS_NAME}</p>
                <p class="goods-desp" style="padding:0px;margin:0px;"><strong class="cf60">${detail.ATY_TITLE}</strong></p>
                <p>
                    <label>价格：</label>
                    <span>
                        <!--<del style="display:none" class="prime-price">￥${detail.GOODS_PRICE}</del>-->
                        <strong class="current-price">￥${detail.GOODS_PRICE}</strong>
                    </span>
                </p>
            </li>
            <li class="num-info-li">
                <a id="goodsAssess" href="javascript:void();">
                    <b class="list-arr"></b>
                    <span class="appr-num"><strong id="assessNum">0</strong>人点评</span>
                    <label>商品评价</label>
                </a>
            </li>
            <li class="num-info-li">
                <a href="#subpage_2" onclick="showSubpage('subpage_2')"><b class="list-arr"></b><span class="detail-info">手机参数，商品信息</span><label>图文详情</label></a>
            </li>
            <li class="num-info-li city-li">
                <a href="#subpage_3" onclick="showSubpage('subpage_3')"><b class="list-arr"></b><span class="detail-info" id="serial_number">请选择号码</span><label color="#F70909">选择号码</label></a>
            </li>
            <!-- A/B/C 套餐 -->
            <#if attrs.PACKRES??>
              <li id="planList" class="num-info-li" >
                  <!--<a href="#subpage_4" onclick="showSubpage('subpage_4')"><b class="list-arr"></b><span class="detail-info">套餐详情</span><label>套餐</label></a> -->
                  <p style="margin-bottom: 0px;"><label>套餐</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.CAPTYRS as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE} attr_val="${item.ATTR_VAL_CODE}" >${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE} attr_val="${item.ATTR_VAL_CODE}" >${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE} attr_val="${item.ATTR_VAL_CODE}" >${item.ATTR_VAL_NAME}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
                  <p style="margin-bottom: 0px;color:#999;">${item.VALUES1}</p>  
              </li>              
            </#if>    
            <!-- 普通卡/微卡/Nano卡-->        
            <#if attrs.SIMSIZE??>
              <li id="simTypeList" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>卡类型</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.CAPTYRS as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE} attr_val="${item.ATTR_VAL_CODE}" >${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE} attr_val="${item.ATTR_VAL_CODE}" >${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE} attr_val="${item.ATTR_VAL_CODE}" >${item.ATTR_VAL_NAME}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>                     
            <li id="price" class="num-info-li" >
                <p style="margin-bottom: 0px;color:#999;">商品金额：<strong class="current-price">￥${detail.GOODS_PRICE}</strong></p> 
            </li>            
        </ul>
    </div>

    <div class="btns-box userType">
        <a id="new-user" class="org-btn w-full fl" href="javascript:void(0)">立即购买</a>
    </div>
  </div>    
  <!-- 第一页 商品详情主页end -->
  
  <!-- 第二页 图文详情页start -->   
  <div id="subpage_2" class="bg-white" data-role="page" style="display:none;">
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
    	  <p class="text-center navbar-p">图文详情 </p>
    	</div>    	
      </div>      
    </div> 
    
    <!-- tab页-->
    <div class="container-fluid" >
      <div role="tabpanel">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist" id="myTab">
          <li role="presentation" class="active"><a href="#tabPane1" aria-controls="tabPane1" role="tab" data-toggle="tab">手机参数</a></li>
          <li role="presentation"><a href="#tabPane2" aria-controls="tab2" role="tabPane2" data-toggle="tab">商品信息</a></li>
          <li role="presentation"><a href="#tabPane3" aria-controls="tab3" role="tabPane3" data-toggle="tab">活动信息</a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
        ${detail.CONTENT}

        </div>
      </div>
    </div>  
  </div>    
  <!-- 第二页 图文详情页end -->   
  
  <!-- 第三页 选择号码start -->
  <div id="subpage_3" class="bg-white" data-role="page" style="display:none;"> 
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
            <div class="col-xs-6 border-td-left" style="padding:0px;" onclick="clickOneNumber()">
        <#else>
            <div class="col-xs-6 border-td-right" style="padding:0px;" onclick="clickOneNumber()">
        </#if>
    	      <p class="p-td-number">${item.SERIAL_NUMBER[0..2]} ${item.SERIAL_NUMBER[3..6]} ${item.SERIAL_NUMBER[7..10]}</p>
    	      <p class="p-td-price">预存话费:${item.NICE_FEE}</p>
    	    </div>
        <#if (item_index%2==1 || !item_has_next)>
          </div> 
        </#if>
      </#list>            
    </div>      
  </div>    
  <!-- 第三页 选择号码end -->     
  
  <!-- 第四页 ABC套餐详情start 暂定作废 -->
  <div id="subpage_4" class="bg-white" data-role="page" style="display:none;"> 
  <!--
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
    	  <p class="text-center navbar-p">套餐详情 </p>
    	</div>    	
      </div>      
    </div> 
    
    <!-- 广告图 -->
    <div class="container-fluid" style="margin:15px;padding:0px;">
      <p class="p-plan-title">A计划</p> 
      <div style="margin:0px;">
        <img src="${resRoot}/image/banner/banner_iphone6.png" alt="" class="img-responsive">
      </div>
      <p class="p-plan-title">B计划</p> 
      <div style="margin:0px;">
        <img src="${resRoot}/image/banner/banner_iphone6.png" alt="" class="img-responsive">
      </div>
      <p class="p-plan-title">C计划</p> 
      <div style="margin:0px;">
        <img src="${resRoot}/image/banner/banner_iphone6.png" alt="" class="img-responsive">
      </div>                  
    </div>
   -->  
  </div>       
  <!-- 第四页 ABC套餐详情end -->  
         
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodDetail.js?v=${resVer}"></script>
    <script src="${resRoot}/js/selectNumber.js?v=${resVer}"></script>
    
  </body>
</html>
