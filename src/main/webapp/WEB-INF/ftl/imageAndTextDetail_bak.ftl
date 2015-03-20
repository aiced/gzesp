<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title></title>
    <link rel="shortcut icon" href="${resRoot}/image/favicon.ico" type="image/x-icon"/>
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/imageAndTextDetail.css" rel="stylesheet">
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
        <div class="col-xs-7">
    	  <p class="text-center navbar-p">图文详情 </p>
    	</div>    	
      </div>      
    </div> 
    
    <!-- tab页-->
    <div class="container-fluid" >
      <div role="tabpanel">
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist" id="myTab">
          <li role="presentation" class="active"><a href="#tabPane1" aria-controls="tabPane1" role="tab" data-toggle="tab">手机参数</a></li>
          <li role="presentation"><a href="#tabPane2" aria-controls="tab2" role="tabPane2" data-toggle="tab">商品信息</a></li>
          <li role="presentation"><a href="#tabPane3" aria-controls="tab3" role="tabPane3" data-toggle="tab">活动信息</a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <div role="tabpanel" class="tab-pane active" id="tabPane1">
            <!-- 4g -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">4G支持</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:15px;">是</p> 
    	          </div>    	
              </div>
            </div>
            <!-- 是否双卡双待 -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">单卡/双卡双待</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:15px;">单卡</p> 
    	          </div>    	
              </div>
            </div> 
            <!-- cpu -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">CPU</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:15px;">64位架构A8芯片</p> 
    	          </div>    	
              </div>
            </div>
            <!-- sim卡类型 -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">SIM卡类型</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:15px;">nano卡</p> 
    	          </div>    	
              </div>
            </div>
            <!-- 分辨率 -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">分辨率</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:15px;">1344x750像素</p> 
    	          </div>    	
              </div>
            </div>            
            <!-- 屏幕尺寸 -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">屏幕尺寸</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:15px;">5.5寸</p> 
    	          </div>    	
              </div>
            </div>
            <!-- 摄像头 -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">摄像头</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:10px;">主800万像素，副120万像素</p> 
    	          </div>    	
              </div>
            </div>
            <!-- 操作系统 -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">操作系统</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:10px;">IOS</p> 
    	          </div>    	
              </div>
            </div>
            <!-- 内存ROM -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">内存ROM</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:10px;">128G</p> 
    	          </div>    	
              </div>
            </div>
            <!-- 运行内存RAM -->
            <div class="container-fluid" style="margin:10px 0px 0px 0px;background-color:#ffffff;">
              <div class="row" >
                <div class="col-xs-5 div-text-center" style="background-color:#ffc798;">
    	            <p class="text-center" style="color:#ffffff;font-size:15px;">运行内存RAM</p> 
    	          </div>
                <div class="col-xs-7 div-text-center" style="">
    	            <p class="text-center" style="font-size:10px;">1G</p> 
    	          </div>    	
              </div>
            </div>                                                                                                              
          </div>
          <div role="tabpanel" class="tab-pane" id="tabPane2">
            <!-- 广告图 -->
            <div class="container-fluid" style="background-color:#ffffff;margin:0px;padding:0px;">
              <img src="${resRoot}/image/imageAndTextDetail/banner_honer_x1.png" alt="" class="img-responsive" />      
            </div>
            <div class="container-fluid" style="background-color:#ffffff;margin:0px;padding:0px;">
              <img src="${resRoot}/image/imageAndTextDetail/banner_iphone6.png" alt="" class="img-responsive" />      
            </div>  
          </div>
          <div role="tabpanel" class="tab-pane" id="tabPane3">
          </div>
        </div>
      </div>
    </div>
    
  
    
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    
    <script>
       //激活tab导航
       $('#myTab a').click(function (e) {
          e.preventDefault();
          $(this).tab('show');
	    });	
	    
	    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
          e.target // newly activated tab
          e.relatedTarget // previous active tab
          //$(this).css('background-color', '#ffa200');
          //$(e.relatedTarget).css('background-color', '#f4f4f4');
        });
    </script>       
    
  </body>
</html>
