
  	<!-- nav bar -->
    <div class="container-fluid" style="background-color:#21292c;height:38px;">
      <div class="row" style="margin-top:8px;margin-left:5px;">
        <div class="col-xs-2" style="margin-top:5px;padding:0px;">
    	  <a class="left carousel-control" onclick="back2Main()" role="button" data-slide="prev">
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
          <li role="presentation" class="active"><a href="#tabPane1" aria-controls="tabPane1" role="tab" data-toggle="tab">商品参数</a></li>
          <li role="presentation"><a href="#tabPane2" aria-controls="tab2" role="tabPane2" data-toggle="tab">商品信息</a></li>
          <li role="presentation"><a href="#tabPane3" aria-controls="tab3" role="tabPane3" data-toggle="tab">活动信息</a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          ${detail.CONTENT}
        </div>
      </div>
    </div>
    
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

