<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>系统错误</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
  </head>

  <body>
	<div id="top">
	  <div id="top_left">
	    <a href="javascript:history.back(-1);">
	      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	    </a>
	  </div>
	</div>    
    
         
    <div class="container-fluid" style="background-color:#ffffff;margin:15px;">
      <div>
    	  <p>${respCode}</p>
	      <p>${respDesc}</p>
      </div>    

      <a id="btn_home" class="btn btn-warning" href="${base}/weShop/index/${user_id}" role="button">再去逛逛</a>
    </div>
    
    
  </body>
</html>
