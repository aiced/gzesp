<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>${detail.GOODS_NAME}</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain2.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain3.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet"> 
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodDetail.js?v=${resVer}"></script>  
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
    <input id="fromPage" name="fromPage" value="cardGoodDetail"></input>
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
    	  <p class="text-center navbar-p">商品详情 </p>
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
	  <div id="top_middle">商品详情</div>
	  <!-- <div id="top_right">
	    <button class="btn btn-primary btn-sm" style="background-color:#21292c;" data-toggle="modal" data-target="#myModal">分享</button>
	  </div> -->
	</div>      
  
    <!-- 分享到弹出框 -->  
    <#--  
    <div id="myModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content" style="padding:5px;height:60px;">
    	    分享到：
          <!-- Baidu Button BEGIN -- >
          <div class="bdsharebuttonbox">
            <a class="bds_more" href="#" data-cmd="more"></a>
            <a title="分享到QQ空间" class="bds_qzone" href="#" data-cmd="qzone"></a>
            <a title="分享到新浪微博" class="bds_tsina" href="#" data-cmd="tsina"></a>
            <a title="分享到腾讯微博" class="bds_tqq" href="#" data-cmd="tqq"></a>
            <a title="分享到人人网" class="bds_renren" href="#" data-cmd="renren"></a>
            <a title="分享到微信" class="bds_weixin" href="#" data-cmd="weixin"></a></div>
          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
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
                <p class="goods-desp" style="padding:0px;margin:0px;">${detail.GOODS_NAME}</p>
                <p class="goods-desp" style="padding:0px;margin:0px;"><strong class="cf60">${detail.ATY_TITLE}</strong></p>
                <p style="padding:0px;margin:0px;">
                    <label>合&nbsp;&nbsp;约&nbsp;&nbsp;价：</label>
                    <span>
                        <del style="display:none" class="prime-price">￥${detail.GOODS_PRICE}</del>
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
            <li class="num-info-li city-li"  style="height:50px;">
                <p>
                    <#--
                    <label class="fl">商品归属：</label>
                    <span class="select-w">
                        <select class="select-style" id="numberBelong" provinceCode="">
                          <#if citys??>
                            <#list citys as item>
                              <option value="${item.CITY_CODE}">${item.CITY_NAME}</option>
                            </#list>
                          </#if>
                        </select>
                    </span>
                    -->
                    <label class="fl">库存状态：</label>
                    <#if ((store.GOODS_AMOUNT?number)>0)>
                      <em id="amountChange_id" class="store in-store">有货</em>
                      <em class="dispatch">(省内配送)</em>
                    <#else>
                      <em id="amountChange_id" class="store no-store">无货</em>
                    </#if>
                </p>
                <p id="articleInfo" class="s-tip"></p>
            </li>
            <!-- 商品的网络类型 2g/3g/4g/上网卡-->
              <#if attrs.NETTYPE??>
                <#list attrs.NETTYPE as item>
                  <#if item_index==0>
                    <span id="net_type" style="display:none" attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}"></span>
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
             <!-- 优惠活动 -->             
            <#if attrs.PACKRES??>
              <li id="activityType" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>优惠活动</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist tabslist-long">
                        <#list attrs.PACKRES as item>
                          <#if item_index==0>
                            <li class="tab-on" attr_code="${item.ATTR_CODE} attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
                          <#elseif item_index%2==1>
                            <li class="mrg-r-0" attr_code="${item.ATTR_CODE} attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
                          <#else>
                            <li attr_code="${item.ATTR_CODE} attr_val="${item.RES_ID}|${item.ATTR_CODE}|${item.ATTR_VAL_CODE}|${item.VALUES1}" >${item.ATTR_VAL_NAME}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>
            <!-- 选择号码  虽然不用选号码但是后台生产的时候需要号码补录等 所以下订单的时候还是需要号码属性 值插空就行 -->
              <#if attrs.NUMBERS??>
                <#list attrs.NUMBERS as item>
                  <#if item_index==0>
                      <span style="display:none;" id="phone_number" attr_val="${item.RES_ID}|${item.ATTR_CODE}||">请选择号码</span>
                  </#if>
                </#list>
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
        </ul>
    </div>

    <div class="btns-box userType">
        <a id="new-user" class="org-btn w-full fl" onclick="cardGotoOrderMain()" >立即购买</a>
    </div>
  </div>    
  <!-- 第一页 商品详情主页end -->

  <!-- 第二页 图文详情start -->  
  <div id="subpage_2" class="bg-white" data-role="page" style="display:none;">
    <#include "imageAndTextDetail.ftl">
  </div>  
  <!-- 第二页 图文详情end -->
 
  <!-- 第三页 商品评价start -->   
  <!-- 第三页 商品评价end -->     
 
  </body>
</html>
