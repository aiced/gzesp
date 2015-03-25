<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>欢迎来到${developer.STORE_NAME}</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/weShopIndex.css?v=${resVer}" rel="stylesheet">
  </head>

  <body>
    <!-- head bar -->
    <div class="container-fluid" style="background-color:#f1791a;padding:5px">
      <div class="row" style="margin:0px;">     
        <div class="col-xs-4" >
          <img src="${resRoot}/image/weShop/logo.png" class="img-responsive" alt="" style="position:static;+position:relative;top:-50%;left:-50%;"/>
        </div>
        <div class="col-xs-2 col-xs-offset-6" style="padding-top:2px;">
          <a href="#" data-toggle="modal" data-target="#myModal"><img src="${resRoot}/image/weShop/fenxiang.png" class="img-responsive" alt="" /></a>
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
              <img src="${item.banner_url}" alt="" />
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
  
    <!-- 能人招募广告 -->
    <!--
    <div class="container-fluid" style="margin:10px;background-color:#ffffff;">
      <div class="row" >
        <div class="col-xs-3 div-text-center" style="background-color:#ffc798;margin:0px;padding:2px">
    	  <p class="text-center" style="color:#ffffff;font-size:20px;">公告</p> 
    	</div>
        <div class="col-xs-6" style="padding:3px;padding-bottom:0px;margin:3px;">
    	  <a href="${base}/weShop/agentJoin" ><img src="${resRoot}/image/weShop/gonggao.png" alt="" class="img-responsive" /></a>  
    	</div>    	
      </div>
    </div>
    -->
    
    <!-- xxx 的微店 -->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;padding-top:5px;">
      <div class="row ">
        <div class="col-xs-3" style="padding:5px">
    	  <img src="${imageRoot}${developer.USER_IMG}" alt="" class="img-circle img-responsive" />  
    	</div>
    	<div class="col-xs-6" style="padding:10px 0px 10px 0px;">
    	  <ul class="list-unstyled">
            <li style="font-size:15px;">${developer.STORE_NAME}</li>
            <li style="font-size:15px;">手机：${developer.PHONE_NUMBER}</li>
            <li style="font-size:15px;">微信：${developer.WEIXIN_ID}</li>
          </ul>  
    	</div>
    	<div class="col-xs-3" style="padding:5px" id="qrcodeDiv">
    	</div>    		    		
      </div>	            
    </div>
    
    <!--新号入网  合约购机  上网卡  特色流量包  宽带续约-->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px 10px 0px 10px;">
      <div class="row" style="margin-top:2px;margin-bottom:2px;">
    	<div class="col-xs-4" style="padding:2px;">
    	  <a href="${base}/weShop/goodSelect/plan/${user_id}">
    	    <img src="${resRoot}/image/weShop/xhrw4.png" alt="" class="img-rounded img-responsive" />
    	  </a>    
    	</div>
    	<div class="col-xs-4" style="padding:2px;">
    	  <a href="${base}/weShop/goodSelect/phone/${user_id}">
    	    <img src="${resRoot}/image/weShop/hygj4.png" alt="" class="img-rounded img-responsive" />  
    	  </a>
    	</div>
    	<div class="col-xs-4" style="padding:2px;">
    	  <a href="${base}/weShop/goodSelect/card/${user_id}">
    	    <img src="${resRoot}/image/weShop/swk4.png" alt="" class="img-rounded img-responsive" />  
    	  </a>
    	</div>
      </div>
      <div class="row" style="margin-top:0px;">
    	<div class="col-xs-4" style="padding:2px">
    	  <a href="${base}/weShop/goodSelect/flow/${user_id}">
    	    <img src="${resRoot}/image/weShop/tsllb4.png" alt="" class="img-rounded img-responsive" />
    	  </a>  
    	</div>
    	<div class="col-xs-4" style="padding:2px">
    	  <a href="${base}/weShop/goodSelect/band/${user_id}">
    	    <img src="${resRoot}/image/weShop/kdxy4.png" alt="" class="img-rounded img-responsive" />  
    	  </a>  
    	</div>
    	<div class="col-xs-4" style="padding:2px">
    	  <a href="#">
    	    <img src="${resRoot}/image/weShop/sjpj4.png" alt="" class="img-rounded img-responsive" />
    	  </a>    
    	</div>
      </div>
    </div>    
    
    <!--店长推荐 -->
    <div class="container-fluid" style="margin:10px;margin-bottom:0px;padding:5px;padding-top:0px;padding-bottom:0px;background-color:#ffd3d3;">
      <div class="row">
        <div class="col-xs-12" style="padding-left:10px;">
    	  <img src="${resRoot}/image/weShop/dztj.png" alt="" class="img-responsive">  
    	</div> 		    		
      </div>     	            
    </div>
    <div class="container-fluid" style="margin:0px;padding-top:0px;">
      <#if (dztj?? && dztj?size>0)>
        <#list dztj as item>  
          <#if item_index%2==0>
            <div class="row">
              <div class="col-xs-6" style="padding:10px">
          <#else>
              <div class="col-xs-6" style="padding:10px">
          </#if>
    	        <a href="${base}/weShop/goodDetail/${user_id}/${item.CTLG_CODE}/${item.GOODS_ID}" >
    	          <img src="${imageRoot}${item.PHOTO_LINKS}" alt="" class="img-responsive" />
    	        </a>
    	  	  <div class="text-shenlue">${item.GOODS_NAME}</div>
    	  	  <p style="font-size:14px;">合约价:<font class="price-red-bold">${item.GOODS_PRICE}</font></p>
    	  	  <p style="font-size:14px;">销量:${item.GOODS_AMOUNT}</p>
    	      </div>
          <#if (item_index%2==1 || !item_has_next)>
            </div> 
          </#if>
        </#list>                   	            
      </#if>
    </div> 
    
    <!--热销合约 -->
    <div class="container-fluid" style="margin:10px;margin-bottom:0px;padding:5px;padding-top:0px;padding-bottom:0px;background-color:#e6ffd6;">
      <div class="row">
        <div class="col-xs-12" style="padding-left:10px">
    	  <img src="${resRoot}/image/weShop/rxhy.png" alt="" class="img-responsive" />  
    	</div> 		    		
      </div>     	            
    </div>
    <div class="container-fluid" style="margin:0px;padding-top:0px;">
      <#if (rxhy?? && rxhy?size>0)>
        <#list rxhy as item>  
          <#if item_index%2==0>
            <div class="row">
              <div class="col-xs-6" style="padding:10px">
          <#else>
              <div class="col-xs-6" style="padding:10px">
          </#if>
    	        <a href="${base}/weShop/goodDetail/${user_id}/${item.CTLG_CODE}/${item.GOODS_ID}" >
    	          <img src="${imageRoot}${item.PHOTO_LINKS}" alt="" class="img-responsive" />
    	        </a>
    	      <!-- <h4 style="font-size:14px;font-weight:bold;">${item.GOODS_NAME}</h4> -->
    	  	  <div class="text-shenlue">${item.GOODS_NAME}</div>
    	  	  <p style="font-size:10px;">合约价:<font class="price-red-bold">${item.GOODS_PRICE}</font></p>
    	  	  <p style="font-size:10px;">销量:${item.GOODS_AMOUNT}</p>
    	      </div>
          <#if (item_index%2==1 || !item_has_next)>
            </div> 
          </#if>
        </#list>                   	            
      </#if>                  	            
    </div>         

    <!--热销网卡 -->
    <div class="container-fluid" style="margin:10px;margin-bottom:0px;padding:5px;padding-top:0px;padding-bottom:0px;background-color:#d3dbff;">
      <div class="row">
        <div class="col-xs-12" style="padding-left:10px">
    	  <img src="${resRoot}/image/weShop/rxwk.png" alt="" class="img-responsive" />  
    	</div> 		    		
      </div>     	            
    </div>
    <div class="container-fluid" style="margin:0px;padding-top:0px;">
      <#if (rxwk?? && rxwk?size>0)>
        <#list rxwk as item>  
          <#if item_index%2==0>
            <div class="row">
              <div class="col-xs-6" style="padding:10px">
          <#else>
              <div class="col-xs-6" style="padding:10px">
          </#if>
    	        <a href="${base}/weShop/goodDetail/${user_id}/${item.CTLG_CODE}/${item.GOODS_ID}" >
    	          <img src="${imageRoot}${item.PHOTO_LINKS}" alt="" class="img-responsive" />
    	        </a>
    	  	  <div class="text-shenlue">${item.GOODS_NAME}</div>
    	  	  <p style="font-size:10px;">合约价:<font class="price-red-bold">${item.GOODS_PRICE}</font></p>
    	  	  <p style="font-size:10px;">销量:${item.GOODS_AMOUNT}</p>
    	      </div>
          <#if (item_index%2==1 || !item_has_next)>
            </div> 
          </#if>
        </#list>                   	            
      </#if>           	            
    </div>
      
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/jquery.qrcode.js?v=${resVer}"></script>
    <script src="${resRoot}/js/qrcode.js?v=${resVer}"></script>
    
    <script>
       //获取当前页面url并生成二维码展示在 xx的微店
       var thisUrl = window.location.href;
       $('#qrcodeDiv').qrcode({
		render:"canvas", //默认canvas方式，性能好
		text: thisUrl, //设置二维码内容
		width:70,     //设置宽度  
        height:70,     //设置高度 
        typeNumber:-1,  //计算模式 
        correctLevel:QRErrorCorrectLevel.H,//纠错等级  
        background:"#ffffff",//背景颜色  
        foreground:"#000000" //前景颜色
	});	
    </script>
  </body>
</html>
