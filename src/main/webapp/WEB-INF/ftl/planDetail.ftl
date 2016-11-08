<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">

    <title>${detail.GOODS_NAME}</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain2.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain3.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/selectNumber.css?v=${resVer}" rel="stylesheet">    
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet"> 
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodDetail.js?v=${resVer}"></script>
    <script src="${resRoot}/js/selectNumber.js?v=${resVer}"></script>   
    <script src="${resRoot}/js/hammer.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/jquery.hammer.js?v=${resVer}"></script>     
    
    <style type="text/css">
    	.carousel-indicators
		{
			bottom:-2%;
		}
    </style>
  </head>

  <body>
  <!-- 传给订单填写主页面 -->
  <form id="form1" method="post" action="${base}/order/fillOrderMain" style="display:none;">
    <input id="user_id" name="user_id" value="${user_id}"></input>
    <input id="goods_id" name="goods_id" value="${detail.GOODS_ID}"></input>
    <input id="goods_name" name="goods_name" value="${detail.GOODS_NAME}"></input>
    <input id="goods_price" name="goods_price" value="${detail.GOODS_PRICE}"></input>
    <input id="nice_fee" name="nice_fee" value="0"></input>
    <input id="total_price" name="total_price" value="${detail.GOODS_PRICE}"></input>
    <input id="serial_number" name="serial_number" value=""></input>
    <input id="goods_disc" name="goods_disc" value="IPHONE6，64G，黑色，5.5寸 ，5999，18651885060，贵阳"></input>
    <input id="attr_val" name="attr_val" value="2015031915263332|COLORRS|深空灰色|简单描述^2015031915263332|PCKPLAN|A计划|电话300分钟　短信0条　流量800M"></input>
    <input id="fromPage" name="fromPage" value="planDetail"></input>
    <input id="original_price" name="original_price" value="${detail.ORIGINAL_PRICE}"></input>
    <input id="ctlg_code" name="ctlg_code" value="${detail.CTLG_CODE}"></input>
    <input id="album_id" name="album_id" value="${detail.ALBUM_ID}"></input>
    <input id="ver_no" name="ver_no" value="${detail.VER_NO}"></input>
    <input id="merchant_id" name="merchant_id" value="${detail.MERCHANT_ID}"></input>
    <input id="create_time" name="create_time" value="${detail.CREATE_TIME}"></input>
    <input id="create_staff_id" name="create_staff_id" value="${detail.CREATE_STAFF_ID}"></input>
    <input id="goods_state" name="goods_state" value="${detail.GOODS_STATE}"></input>
    <input id="recom_tag" name="recom_tag" value="${detail.RECOM_TAG}"></input>
    <input id="price_rule" name="price_rule" value="${detail.PRICE_RULE}"></input>
    <input id="begin_time" name="begin_time" value="${detail.BEGIN_TIME}"></input>
    <input id="end_time" name="end_time" value="${detail.END_TIME}"></input>
    <input id="simp_desc" name="simp_desc" value="${detail.SIMP_DESC}"></input>
  </form>
  
  <!-- 第一页 商品详情主页start --> 
  <div id="page_main">   
  	<!-- nav bar -->
  	<!--
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
    -->
	<div id="top">
	  <div id="top_left">
	    <a href="javascript:history.back(-1);">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    </a>
	  </div>
	  <div id="top_middle">套餐详情</div>
	  <!-- <div id="top_right">
	    <button class="btn btn-primary btn-sm" style="background-color:#21292c;" data-toggle="modal" data-target="#myModal">分享</button>
	  </div> -->
	</div>    
  
    <!-- 分享到弹出框 -->    
    <#--
    <div id="myModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content" style="padding:5px;height:80px;">
    	    分享到：
          <!-- Baidu Button BEGIN -- >
          <div class="bdsharebuttonbox">
            <a class="bds_more" href="#" data-cmd="more"></a>
            <a title="分享到QQ空间" class="bds_qzone" href="#" data-cmd="qzone"></a>
            <a title="分享到新浪微博" class="bds_tsina" href="#" data-cmd="tsina"></a>
            <a title="分享到腾讯微博" class="bds_tqq" href="#" data-cmd="tqq"></a>
            <a title="分享到人人网" class="bds_renren" href="#" data-cmd="renren"></a>
            <a title="分享到微信" class="bds_weixin" href="#" data-cmd="weixin"></a>
          </div>
          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
          <!-- Baidu Button END -- >   
        </div>
      </div>
    </div> 
    --> 

    <!-- Carousel 广告轮播-->	
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
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
            <#--
            <li class="num-info-li">
                <a id="goodsAssess" href="javascript:void();">
                    <b class="list-arr"></b>
                    <span class="appr-num"><strong id="assessNum">0</strong>人点评</span>
                    <label>商品评价</label>
                </a>
            </li>
            -->
            <li class="num-info-li">
                <a href="#subpage_2" onclick="showSubpage('subpage_2')"><b class="list-arr"></b><span class="detail-info">手机参数，商品信息</span><label>图文详情</label></a>
            </li>
            <!-- 商品的网络类型 2G/3G/4G/CARD-->
              <#if attrs.NETTYPE??>
                <#list attrs.NETTYPE as item>
                  <#if item_index==0>
                    <span id="net_type" style="display:none" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}">${item.ATTR_CODE}</span>
                  </#if>
                </#list>
              </#if>
            <!-- 商品的预付费还是后付费  后付费/预付费-->
              <#if attrs.SERTYPE??>
                <#list attrs.SERTYPE as item>
                  <#if item_index==0>
                    <span id="ser_type" style="display:none" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}">${item.ATTR_CODE}</span>
                  </#if>
                </#list>
              </#if>              
            <!-- 商品的预存款，应该只有4g商品才会插这个属性，用于按预存款算佣金-->
              <#if attrs.SAVEMEY??>
                <#list attrs.SAVEMEY as item>
                  <#if item_index==0>
                    <span id="save_money" style="display:none" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}">${item.ATTR_CODE}</span>
                  </#if>
                </#list>
              </#if>              
            <!-- 选择号码 -->
            <li class="num-info-li city-li">
              <#if attrs.NUMBERS??>
                <#list attrs.NUMBERS as item>
                  <#if item_index==0>
                    <a href="#subpage_3" onclick="showSubpage('subpage_3')">
                      <b class="list-arr" style="margin-top: 12px;"></b>
                      <span class="detail-info" id="phone_number" attr_val="${item.RES_ID}|${item.ATTR_CODE}|" style="font-size: 14px;color:#ec7218;margin-top: 5px;">请选择号码</span>
                      <label color="#F70909">选择号码</label>
                    </a>
                  </#if>
                </#list>
              </#if>
            </li>
            <!-- A/B/C 套餐 -->
            <#if attrs.PCKPLAN??>
              <li id="planList" class="num-info-li" >
                  <!--<a href="#subpage_4" onclick="showSubpage('subpage_4')"><b class="list-arr"></b><span class="detail-info">套餐详情</span><label>套餐</label></a> -->
                  <p style="margin-bottom: 0px;"><label>套餐</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist" attr_val="">
                        <#list attrs.PCKPLAN as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE}" values1="${item.VALUES1}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" pckplan_desc="${item.VALUES1}">${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE}" values1="${item.VALUES1}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" pckplan_desc="${item.VALUES1}">${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE}" values1="${item.VALUES1}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" pckplan_desc="${item.VALUES1}">${item.ATTR_VAL_NAME}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
                        <!-- A/B/C 套餐  描述-->
                        <#list attrs.PCKPLAN as item>
                          <#if item_index==0>
                            <p id="pckplan_desc" style="margin-bottom: 0px;color:#999;">${item.VALUES1}</p>  
                          </#if>
                        </#list>                  
              </li>              
            </#if>
            <!-- 不同 套餐月费 -->
            <#if attrs.PACKRES??>
              <li id="planList" class="num-info-li" >
                  <!--<a href="#subpage_4" onclick="showSubpage('subpage_4')"><b class="list-arr"></b><span class="detail-info">套餐详情</span><label>套餐</label></a> -->
                  <p style="margin-bottom: 0px;"><label>套餐</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist" attr_val="">
                        <#list attrs.PACKRES as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE}" values1="${item.VALUES1}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" package_desc="${item.VALUES1}">${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE}" values1="${item.VALUES1}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" package_desc="${item.VALUES1}">${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE}" values1="${item.VALUES1}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" package_desc="${item.VALUES1}">${item.ATTR_VAL_NAME}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
                        <!--不同 套餐月费 描述 -->
                        <#list attrs.PACKRES as item>
                          <#if item_index==0>
                            <input id="product_id" type="hidden" name="product_id" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" package_desc="${item.VALUES1}" value="${item.VALUES1}"></input>
                            <p id="package_desc" style="margin-bottom: 0px;color:#999;">${item.VALUES1}</p>                           
                          </#if>
                        </#list>                  
              </li>              
            </#if>
            <!-- 必选叠加包-->        
            <#if attrs.MUSTPCK??>
              <li id="mustPckList" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>必选叠加包</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.MUSTPCK as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" all_must_select="true">${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0 tab-on" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" all_must_select="true">${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li class="tab-on" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" all_must_select="true">${item.ATTR_VAL_NAME}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>            
            <!-- 可选叠加包-->  
            <#if attrs.ADDPCKE??>
              <li id="addPckList" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>可选叠加包(可多选)</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.ADDPCKE as item>
                          <#if item_index==0>
                            <li attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" multi_select="true">${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" multi_select="true">${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE}" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" multi_select="true">${item.ATTR_VAL_NAME}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>    
            <!-- 多选一叠加包-->        
            <#if attrs.ONEPCKE??>
              <li id="onePckList" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>多选一叠加包</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.ONEPCKE as item>
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
                <p style="margin-bottom: 0px;color:#999;">商品金额：<strong class="current-price">￥</strong><strong class="current-price" id="current_price">${detail.GOODS_PRICE}</strong></p> 
            </li>            
        </ul>
    </div>

    <div class="btns-box userType">
        <!-- <a id="new-user" class="org-btn w-full fl" onclick="planGotoOrderMain()">立即购买</a> -->
        <button id="new-user" class="btn btn-warning btn-block" type="button"  onclick="planGotoOrderMain()"> 立即购买</button>
    </div>
  </div>    
  <!-- 第一页 商品详情主页end -->
  
  <!-- 第二页 图文详情页start -->   
  <div id="subpage_2" class="bg-white" style="display:none;">
    <#include "imageAndTextDetail.ftl"> 
  </div>    
  <!-- 第二页 图文详情页end -->   
  
  <!-- 第三页 选择号码start -->
  <div id="subpage_3" class="bg-gray" style="display:none;"> 
    <#include "selectNumber.ftl">
  </div>    
  <!-- 第三页 选择号码end -->     
  
  <!-- 第四页 ABC套餐详情start 暂定作废 -->
  <div id="subpage_4" class="bg-white" style="display:none;"> 
  </div>       
  <!-- 第四页 ABC套餐详情end -->  
         
  <!-- 如果是安卓手机&&当前是微信内置浏览器 则弹出遮罩层提示更换浏览器 start -->  
  <#--   
  <div id="divMask">
    <#include "divMask.ftl"> 
  </div>    
  -->
  <!-- 如果是安卓手机&&当前是微信内置浏览器 则弹出遮罩层提示更换浏览器 end -->   
    
  </body>
</html>
