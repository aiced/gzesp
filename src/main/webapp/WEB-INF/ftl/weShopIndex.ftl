<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>欢迎来到${name}的微店</title>

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
          <a herf="#"><img src="${resRoot}/image/weShop/fenxiang.png" class="img-responsive" alt="" /></a>
        </div>        
      </div>
    </div>

    <!-- Carousel 广告轮播-->	
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="background-color:#f1791a">
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <!--<li data-target="#myCarousel" data-slide-to="2"></li> -->
      </ol>
      <div class="carousel-inner" role="listbox">
        <div class="item active">
          <img src="${resRoot}/image/banner/banner_iphone6.png" alt="First slide" />
          <div class="container">
            <div class="carousel-caption">
              
            </div>
          </div>
        </div>
        <!--
        <div class="item">
          <img src="${resRoot}/image/banner/banner_honer_x1.png" alt="Second slide" />
          <div class="container">
            <div class="carousel-caption">
              
            </div>
          </div>
        </div>
        -->
        <div class="item">
          <img src="${resRoot}/image/banner/banner_sim_46.jpg" alt="Third slide" />
          <div class="container">
            <div class="carousel-caption">
              
            </div>
          </div>
        </div>
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
    <div class="container-fluid" style="margin:10px;background-color:#ffffff;">
      <div class="row" >
        <div class="col-xs-3 div-text-center" style="background-color:#ffc798;">
    	  <p class="text-center" style="color:#ffffff;font-size:20px;">公告</p> 
    	</div>
        <div class="col-xs-6" style="padding:4px;margin:6px;">
    	  <img src="${resRoot}/image/weShop/gonggao.png" alt="" class="img-responsive" />  
    	</div>    	
      </div>
    </div>
    
    <!-- xxx 的微店 -->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;padding-top:5px;">
      <div class="row ">
        <div class="col-xs-3 col-sm-3 col-md-3" style="padding:5px">
    	  <img src="${resRoot}/image/weShop/touxiang_default.png" alt="" class="img-circle img-responsive" />  
    	</div>
    	<div class="col-xs-6 col-sm-6 col-md-6" style="padding:0px;padding-top:10px;">
    	  <ul class="list-unstyled">
            <li style="font-size:20px;">${name}的微店</li>
            <li style="font-size:12px;">手机：${phone}</li>
            <li style="font-size:12px;">微信：${weixin}</li>
          </ul>  
    	</div>
    	<div class="col-xs-3 col-sm-3 col-md-3" style="padding:5px">
    	  <img src="${resRoot}/image/weShop/erweima.png" alt="" class="img-responsive" />   
    	</div>    		    		
      </div>	            
    </div>
    
    <!--新号入网  合约购机  上网卡  特色流量包  宽带续约-->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;margin-bottom:0px;padding: 5px;">
      <div class="row" style="margin-top:5px;">
        <div class="col-xs-1" style="padding:0px"></div>
    	<div class="col-xs-2" style="padding:0px">
    	  <a href="http://m.10010.com/mall-mobile/NumList/search">
    	    <img src="${resRoot}/image/weShop/xhrw2.png" alt="" class="img-rounded img-responsive" />
    	  </a>    
    	</div>
    	<div class="col-xs-2" style="padding:0px"></div>
    	<div class="col-xs-2" style="padding:0px">
    	  <a href="http://m.10010.com/MobileList">
    	    <img src="${resRoot}/image/weShop/hygj2.png" alt="" class="img-rounded img-responsive" />  
    	  </a>
    	</div>
    	<div class="col-xs-2" style="padding:0px"></div>
    	<div class="col-xs-2" style="padding:0px">
    	  <a href="http://m.10010.com/CardList">
    	    <img src="${resRoot}/image/weShop/swk2.png" alt="" class="img-rounded img-responsive" />  
    	  </a>
    	</div>
        <div class="col-xs-1" style="padding:0px"></div>    	     		   		    		
      </div>
      <!--
      <div class="row" style="margin-top:5px;">
        <div class="col-xs-1" style="padding:0px"></div>
    	<div class="col-xs-2" style="padding:0px">
    	  <img src="${resRoot}/image/weShop/tsllb2.png" alt="" class="img-rounded img-responsive" />  
    	</div>
    	<div class="col-xs-2" style="padding:0px"></div>
    	<div class="col-xs-2" style="padding:0px">
    	  <img src="${resRoot}/image/weShop/kdxy2.png" alt="" class="img-rounded img-responsive" />  
    	</div>
    	<div class="col-xs-2" style="padding:0px"></div>
    	<div class="col-xs-2" style="padding:0px">
    	  <img src="${resRoot}/image/weShop/sjpj2.png" alt="" class="img-rounded img-responsive" />  
    	</div>
        <div class="col-xs-1" style="padding:0px"></div>    	     		   		    		
      </div> 
      -->    	            
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
      <div class="row">
    	<div class="col-xs-6" style="padding:10px">
    	  <a href="http://m.10010.com/mobilegoodsdetail/981410108357.html" >
    	    <img src="${resRoot}/image/dztj/dztj_iphone6.jpg" alt="" class="img-responsive"/>
    	  </a>
    		<p class="text-left" style="font-size:14px;font-weight:bold;">苹果(Apple)iphone6</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">5999</font></p>
    		<p class="text-left" style="font-size:10px;">销量:68</p>
    	</div>
    	<div class="col-xs-6" style="padding:10px">
    	  <a href="http://m.10010.com/mobilegoodsdetail/981409287410.html" >
    	    <img src="${resRoot}/image/dztj/dztj_note.jpg" alt="" class="img-responsive" />
    	  </a>
    		<p class="text-left" style="font-size:14px;font-weight:bold;">三星Note4</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">4699</font></p>
    		<p class="text-left" style="font-size:10px;">销量:50</p>
    	</div>    		  		 		    		
      </div>
      <div class="row">
    	<div class="col-xs-6" style="padding:10px">
    	  <a href="http://m.10010.com/mobilegoodsdetail/851403121719.html" >
    	    <img src="${resRoot}/image/dztj/dztj_4G.jpg" alt="" class="img-responsive" />
    	  </a>
    		<p class="text-left" style="font-size:14px;font-weight:bold;">4G全国套餐</p> 
    		<p class="text-left" style="font-size:10px;"><font color="#F70909">用的起 用的放心的套餐</font></p>
    		<p class="text-left" style="font-size:10px;">销量:68</p>
    	</div>
    	<div class="col-xs-6" style="padding:10px">
    	  <a href="http://m.10010.com/mobilegoodsdetail/851203213262.html" >
    	    <img src="${resRoot}/image/dztj/dztj_3G_46.jpg" alt="" class="img-responsive" />
    	  </a>
    		<p class="text-left" style="font-size:14px;font-weight:bold;">46元3G套餐</p> 
    		<p class="text-left" style="font-size:10px;"><font color="#F70909">A/B/C计划预存话费</font></p>
    		<p class="text-left" style="font-size:10px;">销量:50</p>
    	</div>    		  		 		    		
      </div>            	            
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
      <div class="row">
    	<div class="col-xs-6" style="padding:10px">
    	  <img src="${resRoot}/image/rxhy/rxhy_iphone6.jpg" alt="" class="img-responsive" />
    		<p class="text-left" style="font-size:14px;font-weight:bold;">苹果(Apple)iphone6</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">4899</font></p>
    		<p class="text-left" style="font-size:10px;">销量:68</p>
    	</div>
    	<div class="col-xs-6" style="padding:10px">
    	  <img src="${resRoot}/image/rxhy/rxhy_s5.png" alt="" class="img-responsive" />
    		<p class="text-left" style="font-size:14px;font-weight:bold;">三星S5</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">4999</font></p>
    		<p class="text-left" style="font-size:10px;">销量:50</p>
    	</div>    		  		 		    		
      </div>
      <div class="row">
    	<div class="col-xs-6" style="padding:10px">
    	  <img src="${resRoot}/image/rxhy/rxhy_mi4.png" alt="" class="img-responsive" />
    		<p class="text-left" style="font-size:14px;font-weight:bold;">小米4</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">1899</font></p>
    		<p class="text-left" style="font-size:10px;">销量:68</p>
    	</div>
    	<div class="col-xs-6" style="padding:10px">
    	  <img src="${resRoot}/image/rxhy/rxhy_hm_note.png" alt="" class="img-responsive" />
    		<p class="text-left" style="font-size:14px;font-weight:bold;">红米note</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">999</font></p>
    		<p class="text-left" style="font-size:10px;">销量:50</p>
    	</div>    		  		 		    		
      </div>             	            
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
      <div class="row">
    	<div class="col-xs-6" style="padding:10px">
    	  <img src="${resRoot}/image/rxwk/rxwk_card.png" alt="" class="img-responsive" />
    		<p class="text-left" style="font-size:14px;font-weight:bold;">上网卡包年16g</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">499</font></p>
    		<p class="text-left" style="font-size:10px;">销量:68</p>
    	</div>
    	<div class="col-xs-6" style="padding:10px">
    	  <img src="${resRoot}/image/rxwk/rxwk_card.png" alt="" class="img-responsive" />
    		<p class="text-left" style="font-size:14px;font-weight:bold;">上网卡包年10g</p> 
    		<p class="text-left" style="font-size:10px;">合约价:<font color="#F70909">500</font></p>
    		<p class="text-left" style="font-size:10px;">销量:50</p>
    	</div>    		  		 		    		
      </div>      	            
    </div>
      

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
  </body>
</html>
