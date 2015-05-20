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
    
    <!-- edit_by_wenh_2015_4_23 -->
    <style type="text/css">
		.carousel-indicators
		{
			bottom:-10%;
		}
		.carousel-indicators li
		{
			width:5px;
			height:5px;
			margin:0px;
		}
		.carousel-indicators .active
		{
			width:5px;
			height:5px;
		}
    </style>

  </head>

  <body>
    <!-- 手机浏览器分享会用到的图片 -->
    <div style="display: none;">
    	<img src='${imageRoot}/uploader/share_logo.png' alt="" class="img-responsive"/>
	</div> 
  
    <!-- head bar -->
    <div style="background-color:#f1791a;padding:5px;height:45px;line-height: 35px;">
       <div style="float: left;">
         <img src="${resRoot}/image/weShop/logo.png" class="img-responsive" alt="" style="width:80px;height: 30px;"/>
       </div>
       <div style="float:left;font-size: 10px;color: white;margin-left:10px;margin-top: 4px;">内测版</div>
       <div style="float:right;" >
       	<!-- <a href="${base}/customer/custOrderQuery" style="color:black;"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></a> -->
       	<a href="${base}/customer/custOrderQuery" style="color:white;float: right;font-size: 12px;"><u>我的订单</u></a>
       </div>
       <div style="clear:both;"></div>       
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
    <div id="myCarousel" class="carousel slide" data-ride="carousel" >
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
              <a href="${base}${item.banner_href}/${user_id}?imgsrc=${item.banner_url}"><img src="${item.banner_url}" alt="" style="height:120px;width:100%;"/></a>
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
    	
    	<div class="col-xs-3" style="padding:0px" id="qrcodeDiv" onclick="doqrcodeClick();">
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
     	<#-- ${base}/weShop/goodSelect/flow/${user_id}-->
    	  <a href="#" onclick="Tishi();">
    	    <img src="${resRoot}/image/weShop/tsllb4.png" alt="" class="img-rounded img-responsive" />
    	  </a>  
    	</div>
    	<div class="col-xs-4" style="padding:2px">
    	<#--${base}/weShop/goodSelect/band/${user_id}-->
    	  <a href="#" onclick="Tishi();">
    	    <img src="${resRoot}/image/weShop/kdxy4.png" alt="" class="img-rounded img-responsive" />  
    	  </a>  
    	</div>
    	<div class="col-xs-4" style="padding:2px">
    	  <a href="#" onclick="Tishi();">
    	    <img src="${resRoot}/image/weShop/sjpj4.png" alt="" class="img-rounded img-responsive" />
    	  </a>    
    	</div>
      </div> 
    </div>    
    
    <!--店长推荐 -->
    <div class="container-fluid" style="margin:10px;margin-bottom:0px;padding:5px;padding-top:0px;padding-bottom:0px;">
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
    	  	  <p style="font-size:14px;">
    	  	    <#if (item.CTLG_CODE==4 || item.CTLG_CODE==9)>
                                   合约价:
                <#else>
                                   销售价:
                </#if>
    	  	    <font class="price-red-bold">${item.GOODS_PRICE}</font>
    	  	  </p>
    	  	  <p style="font-size:14px;">销量:${item.GOODS_AMOUNT}</p>
    	      </div>
          <#if (item_index%2==1 || !item_has_next)>
            </div> 
          </#if>
        </#list>                   	            
      </#if>
    </div> 
    
    <!--热销合约 -->
    <div class="container-fluid" style="margin:10px;margin-bottom:0px;padding:5px;padding-top:0px;padding-bottom:0px;">
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
    	  	  <p style="font-size:14px;">
    	  	    <#if (item.CTLG_CODE==4 || item.CTLG_CODE==9)>
                                   合约价:
                <#else>
                                   销售价:
                </#if>
    	  	    <font class="price-red-bold">${item.GOODS_PRICE}</font>
    	  	  </p>
    	  	  <p style="font-size:14px;">销量:${item.GOODS_AMOUNT}</p>
    	      </div>
          <#if (item_index%2==1 || !item_has_next)>
            </div> 
          </#if>
        </#list>                   	            
      </#if>                  	            
    </div>         

   <!--热销套餐-->
    <div class="container-fluid" style="margin:10px;margin-bottom:0px;padding:5px;padding-top:0px;padding-bottom:0px;">
      <div class="row">
        <div class="col-xs-12" style="padding-left:10px">
    	  <img src="${resRoot}/image/weShop/rxtc.png" alt="" class="img-responsive" />  
    	</div> 		    		
      </div>     	            
    </div>
    <div class="container-fluid" style="margin:0px;padding-top:0px;">
      <#if (rxtc?? && rxtc?size>0)>
        <#list rxtc as item>  
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
    	  	  <p style="font-size:14px;">
    	  	    <#if (item.CTLG_CODE==4 || item.CTLG_CODE==9)>
                                   合约价:
                <#else>
                                   销售价:
                </#if>    	  	    
    	  	    <font class="price-red-bold">${item.GOODS_PRICE}</font>
    	  	  </p>
    	  	  <p style="font-size:14px;">销量:${item.GOODS_AMOUNT}</p>
    	      </div>
          <#if (item_index%2==1 || !item_has_next)>
            </div> 
          </#if>
        </#list>                   	            
      </#if>                  	            
    </div> 

    <!--热销网卡 -->
    <div class="container-fluid" style="margin:10px;margin-bottom:0px;padding:5px;padding-top:0px;padding-bottom:0px;">
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
    	  	  <p style="font-size:14px;">
    	  	    <#if (item.CTLG_CODE==4 || item.CTLG_CODE==9)>
                                   合约价:
                <#else>
                                   销售价:
                </#if>    	  	    
    	  	    <font class="price-red-bold">${item.GOODS_PRICE}</font>
    	  	  </p>
    	  	  <p style="font-size:14px;">销量:${item.GOODS_AMOUNT}</p>
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
    <script src="${resRoot}/js/hammer.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/jquery.hammer.js?v=${resVer}"></script>
    
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
       //手势滑动操作
       $('#myCarousel').hammer().on('swipeleft', function(){
     	  $(this).carousel('next');
     	});
     	$('#myCarousel').hammer().on('swiperight', function(){
     	  $(this).carousel('prev');
     	});
       
     	
     	function Tishi()
     	{
     		alert("敬请期待！");
     	}
		function doqrcodeClick()
		{
			location.href="${base}/weShop/Qrcode?userid=${user_id}";
		}
    </script>

  <!-- 如果是安卓手机&&当前是微信内置浏览器 则弹出遮罩层提示更换浏览器 start -->   
  <div id="divMask">
    <#include "divMask.ftl"> 
  </div>    
  <!-- 如果是安卓手机&&当前是微信内置浏览器 则弹出遮罩层提示更换浏览器 end -->   
  
  </body>
</html>
