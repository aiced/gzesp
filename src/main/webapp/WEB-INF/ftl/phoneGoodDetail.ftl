<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>商品详情</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain2.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain3.css?v=${resVer}" rel="stylesheet">
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
        <div class="col-xs-8">
    	  <p class="text-center navbar-p">商品详情 </p>
    	</div>
    	<div class="col-xs-2" style="margin:0px;padding:0px;">
          <button class="btn btn-primary btn-sm" style="background-color:#21292c;" data-toggle="modal" data-target="#myModal">分享</button>
        </div> 
      </div>      
    </div> 
  
    <!-- 分享到弹出框 -->    
    <div id="myModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content" style="padding:5px;height:60px;">
    	    分享到：
          <!-- Baidu Button BEGIN -->
          <div class="bdsharebuttonbox">
            <a class="bds_more" href="#" data-cmd="more"></a>
            <a title="分享到QQ空间" class="bds_qzone" href="#" data-cmd="qzone"></a>
            <a title="分享到新浪微博" class="bds_tsina" href="#" data-cmd="tsina"></a>
            <a title="分享到腾讯微博" class="bds_tqq" href="#" data-cmd="tqq"></a>
            <a title="分享到人人网" class="bds_renren" href="#" data-cmd="renren"></a>
            <a title="分享到微信" class="bds_weixin" href="#" data-cmd="weixin"></a></div>
          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"1","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"image":{"viewList":["qzone","tsina","tqq","renren","weixin"],"viewText":"分享到：","viewSize":"16"},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
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
                <p class="goods-desp" style="padding:0px;margin:0px;">${detail.GOODS_NAME}</p>
                <p class="goods-desp" style="padding:0px;margin:0px;"><strong class="cf60">${detail.ATY_TITLE}</strong></p>
                <p style="padding:0px;margin:0px;">
                    <label>合&nbsp;&nbsp;约&nbsp;&nbsp;价：</label>
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
                <a href="#sub-detail"><b class="list-arr"></b><span class="detail-info">手机参数，商品信息</span><label>图文详情</label></a>
            </li>
            <li class="num-info-li city-li"  style="height:50px;">
                <p>
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
                    <em id="amountChange_id" class="store in-store">有货</em>
                    <em class="dispatch">(省内配送)</em>
                </p>
                <p id="articleInfo" class="s-tip"></p>
            </li>
            <#if attrs.SIZERES??>
              <li id="machineVersionList" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>版本</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.SIZERES as item>
                          <#if item_index==0>
                            <li class="tab-on" machineVersion="${item}" >${item}</li>
                          <#elseif item_index%2==1>
                            <li class="mrg-r-0" machineVersion="${item}" >${item}</li>
                          <#else>
                            <li machineVersion="${item}" >${item}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>
            <#if attrs.COLORRS??>
              <li id="colorList" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>颜色</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.COLORRS as item>
                          <#if item_index==0>
                            <li class="tab-on" colorcode="${item}" >${item}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" colorcode="9809120800036795">${item}</li>
                          <#else>
                            <li colorcode="${item}" >${item}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>
            <#if attrs.CAPTYRS??>
              <li id="romList" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>内存</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist">
                        <#list attrs.CAPTYRS as item>
                          <#if item_index==0>
                            <li class="tab-on" romsize="${item}" >${item}</li>
                          <#elseif item_index%3==2>
                            <li class="mrg-r-0" romsize="9809120800036795">${item}</li>
                          <#else>
                            <li romsize="${item}" >${item}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>
            <#if attrs.xx??>
              <li id="activityType" class="num-info-li" >
                  <p style="margin-bottom: 0px;"><label>优惠活动</label></p>
                  <div class="tabs-box">
                      <ul class="tabslist tabslist-long">
                        <#list attrs.xx as item>
                          <#if item_index==0>
                            <li class="tab-on" activityType="${item}" >${item}</li>
                          <#elseif item_index%2==1>
                            <li class="mrg-r-0" activityType="${item}" >${item}</li>
                          <#else>
                            <li activityType="${item}" >${item}</li>
                          </#if>
                        </#list>
                      </ul>
                  </div>
              </li>              
            </#if>            

        </ul>
    </div>

    <div class="btns-box userType">
        <a id="new-user" class="org-btn w-49p fl" href="javascript:void(0)">新号入网</a>
        <a id="old-user" class="blue-btn w-49p fr" href="javascript:void(0)">老用户办理</a>
    </div>

    <div class="btns-box noAmount" style="display:none">
        <div class="noAmountInfo">
          <div class="info">
             <div class="img-w">
               <img src="${resRoot}/image/order/light-little.png"/>
             </div>
             <p>您当前所选型号暂时无货,可选其他型号或到货通知</p>
          </div>
        </div>
        <a href="javascript:void(0)" class="org-btn w-full" id="arrivalNotice">到货通知</a>
    </div>
    <div class="pop-layer" id="buyTips">
        <div class="pop-layer-t"><h2>提示</h2></div>
        <div class="pop-layer-m">
            <p>对不起，老用户暂时不能享受打折优惠</p>
            <div class="pop-btns-box">
                <a href="javascript:void(0);" class="nav-btn" id="originalBuy"><span>原价购买</span></a>
                <a href="javascript:void(0);" class="nav-btn" id="discountBuy"><span>折扣换新号</span></a>
            </div>
        </div>
    </div>

    
         
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/orderMain.js"></script>
    
  </body>
</html>
