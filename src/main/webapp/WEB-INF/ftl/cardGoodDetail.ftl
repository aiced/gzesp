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
              <img src="${resRoot}/image/banner/${item}" alt="" />
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
                <p class="goods-desp" style="padding:0px;margin:0px;">iPhone 6/iPhone 6 Plus 现货库存 先购先得 支持货到付款  限湖南省内配送  <strong class="cf60">一个身份证号码只能办理一次本业务（微店，电子沃店不参与本活动）</strong></p>
                <p class="goods-desp" style="padding:0px;margin:0px;"><strong class="cf60">自定义活动标题</strong></p>
                <p style="padding:0px;margin:0px;">
                    <label>合&nbsp;&nbsp;约&nbsp;&nbsp;价：</label>
                    <span>
                        <del style="display:none" class="prime-price">￥5288</del>
                        <strong class="current-price">￥7099</strong>（最高返<strong>7099</strong>元话费）
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
                        <select class="select-style" id="numberBelong" provinceCode="74">
                                        <option value="741">长沙</option>
                                        <option value="744">衡阳</option>
                                        <option value="742">株洲</option>
                                        <option value="743">湘潭</option>
                                        <option value="745">岳阳</option>
                                        <option value="792">邵阳</option>
                                        <option value="748">郴州</option>
                                        <option value="749">常德</option>
                                        <option value="747">益阳</option>
                                        <option value="795">怀化</option>
                                        <option value="796">永州</option>
                                        <option value="791">娄底</option>
                                        <option value="793">湘西</option>
                                        <option value="794">张家界</option>
                        </select>
                    </span>
                    <em id="amountChange_id" class="store in-store">有货</em>
                    <em class="dispatch">(省内配送)</em>
                </p>
                <p id="articleInfo" class="s-tip"></p>
            </li>
            <li id="machineVersionList" class="num-info-li bdr-b-none" >
                <p style="margin-bottom: 0px;"><label>版本</label></p>
                <div class="tabs-box">
                    <ul class="tabslist tabslist-long">
                        <li class="tab-on" machineVersion="iP6Plus" >12G省内年卡</li>
                    </ul>
                </div>
            </li>

        </ul>
    </div>

    <div class="btns-box userType">
        <a id="new-user" class="org-btn w-full fl" href="javascript:void(0)">立即购买</a>
    </div>


    
         
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/orderMain.js"></script>
    
    </script>
  </body>
</html>