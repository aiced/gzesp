<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    
    <style>
    	.info-li{position:relative;overflow:hidden;display:block;padding:10px 0;margin-bottom:-1px;border:1px solid #d4d3d3;border-color:#d4d3d3 transparent;}
	    .info-li-on{z-index:100;border:1px solid #ed6d00;}
		.info-li .list-arr{float:none;position:absolute;top:50%;right:3px;margin-top:-5px;}
		.info-li-on .list-arr{background-image:url(${resRoot}/image/common/arr_2.gif);}
	</style>
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
    
    <div class="container-fluid" style="padding:5px">
	    <ul class="list-group">
		  <li class="list-group-item">
		  	<h3>已选手机:<small>${selectedPhone}</small></h3>
		  </li>
		  <li class="list-group-item  info-li info-li-on">
		  	<b class="list-arr">ass</b>
			  <h3>选择合约</br><small>请根据您的月消费，选择一个合适的合约计划</small></h3>
		  </li>
		  <li class="list-group-item">
		  	<h3>选择号码</br><small>请选择一个入网号码，如果您选择的是靓号，需要预存靓号预存款</small></h3>
		  </li>
		</ul>
    </div>
    
     <div class="container-fluid" style="padding:5px">
     	<button type="button" class="btn btn-warning  btn-lg btn-block">下一步</button>
      </div>
      

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery-1.11.2.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
  </body>
</html>
