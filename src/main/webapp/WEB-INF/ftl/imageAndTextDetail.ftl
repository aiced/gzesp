
  	<!-- nav bar -->
    <div class="container-fluid navbar-fixed-top" style="background-color:#21292c;height:38px;">
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
    

    <div class="container-fluid" style="padding:50px 10px 0px 10px;">
      ${detail.CONTENT}
    </div>    
    <script>
       //激活tab导航
//       $('#myTab a').click(function (e) {
//          e.preventDefault();
//          $(this).tab('show');
//	    });	
	    
//	    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
//          e.target // newly activated tab
//          e.relatedTarget // previous active tab
//          //$(this).css('background-color', '#ffa200');
//          //$(e.relatedTarget).css('background-color', '#f4f4f4');
//        });
    </script>       

