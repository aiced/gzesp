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
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodDetail.js?v=${resVer}"></script>
    <script src="${resRoot}/js/selectNumber.js?v=${resVer}"></script>    
    
  </head>

  <body>
  <!-- 传给订单填写主页面 -->
  <form id="form1" action="${base}/order/fillOrderMain" style="display:none;">
    <input id="user_id" value="${user_id}"></input>
    <input id="goods_id" value="${detail.GOODS_ID}"></input>
    <input id="goods_name" value="${detail.GOODS_NAME}"></input>
    <input id="goods_price" value="${detail.GOODS_PRICE}"></input>
    <input id="goods_disc" value="IPHONE6，64G，黑色，5.5寸 ，5999，18651885060，贵阳"></input>
    <input id="attr_val" value="2015031915263332|COLORRS|深空灰色|简单描述^2015031915263332|PCKPLAN|A计划|电话300分钟　短信0条　流量800M"></input>
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
                      <ul class="tabslist" attr_val="">
                        <#list attrs.PACKRES as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
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
                        <#list attrs.SIMSIZE as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
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
        <a id="new-user" class="org-btn w-full fl" onclick="planGotoOrderMain()">立即购买</a>
    </div>
  </div>    
  <!-- 第一页 商品详情主页end -->
  
  <!-- 第二页 图文详情页start -->   
  <div id="subpage_2" class="bg-white" data-role="page" style="display:none;">
    <#include "imageAndTextDetail.ftl"> 
  </div>    
  <!-- 第二页 图文详情页end -->   
  
  <!-- 第三页 选择号码start -->
  <div id="subpage_3" class="bg-gray" data-role="page" style="display:none;"> 
    <#include "selectNumber.ftl">
  </div>    
  <!-- 第三页 选择号码end -->     
  
  <!-- 第四页 ABC套餐详情start 暂定作废 -->
  <div id="subpage_4" class="bg-white" data-role="page" style="display:none;"> 
  </div>       
  <!-- 第四页 ABC套餐详情end -->  
         

    
  </body>
</html>
