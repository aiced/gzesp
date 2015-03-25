<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>${detail.GOODS_NAME}</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/flowGoodDetail.css?v=${resVer}" rel="stylesheet">   
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">  
  </head>

  <body>
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
    	  <p class="text-center navbar-p">叠加流量包</p>
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
	  <div id="top_right">
	    <button class="btn btn-primary btn-sm" style="background-color:#21292c;" data-toggle="modal" data-target="#myModal">分享</button>
	  </div>
	</div>       
    
    <!-- 图片 -->
    <div class="container-fluid" style="margin:0px;padding:0px;">
      <img src="${resRoot}/image/flowGood/detail_flow_1g.png" class="img-responsive" alt="">           
    </div>
    <!-- 生效时间 -->
    <div class="container-fluid" style="background-color:#fff;margin:0px;padding:0px;text-align:center;border:1px solid #b1d85c">
      <p>
      	<font style="font-size: 20px;">国内流量:</font> 
      	<font style="font-size:20px;color:#ed6d00;font-weight:normal;">100M</font>
      	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
      	<font style="font-size: 20px;">价格:</font> 
      	<font style="font-size:20px;color:#ed6d00;font-weight:normal;">10元</font>      	
      </p>         
    </div>    

    <!-- 分隔的色块 -->
    <div class="container-fluid" style="margin:0px;padding: 0px;height:20px;">  
    </div>
                
    <!-- 详细文字描述 -->
    <div class="container-fluid" style="background-color:#fff;margin:0px;padding: 0px;">
    	<h2>业务介绍</h2>
      <p>
      	宽带并没有很严格的定义。从一般的角度理解，它是能够满足人们感观所能感受到的各种媒体在网络上传输所需要的带宽，因此它也是一个动态的、发展的概念。
        FCC（Federal Communications Commission，美国联邦通讯委员会）2015年1月7日做了年度宽带进程报告，在报告中现任主席Tom Wheeler对“宽带”进行了重新定义，原定的下行速度4Mbps调整成25Mbps，原定的上行速度1Mbps调整成3Mbps。
        美国宽带网新标准：25Mbps下行/3Mbps上行
      </p>  
    </div> 

    <!-- 手机验证码校验 -->
    <div class="container-fluid" >
    	<div class="row">
        <div class="col-xs-6 col-sm-6" style="margin:10px;">
        	<input type="email" id="phoneNum" class="form-control" style="position:relative;height:auto;" placeholder="手机号码" required autofocus>
        </div>
        <div class="col-xs-4 col-sm-4" style="text-align:center;margin:10px;padding:0px;">
        	<button class="btn btn-warning btn-block" type="submit">发送验证码</button>
        </div>             		
      </div>
    	<div class="row">
        <div class="col-xs-6 col-sm-6" style="margin:10px;margin-top:0px;">
        	<input type="email" id="checkCode" class="form-control" placeholder="验证码">
        </div>            		
      </div>
    	<div class="row">
    		<div class="col-xs-11 col-sm-11" style="margin:10px;margin-top:0px;">
        	<button type="button" class="btn btn-lg btn-warning btn-block">确认订购,去支付</button>
        </div>
               		
      </div>                                              
         
    </div>              
  
    <!-- Bootstrap core JavaScript -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
  </body>
</html>
