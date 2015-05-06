<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>迷路啦</title>

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
	  <div id="top_middle">迷路啦</div>
	  <div id="top_right"></div>
	</div>    
    
         
    <div class="container-fluid" style="background-color:#ffffff;margin:15px;">
      <div>
        <p>${msg}</p> 
      </div>
      <button  class="btn btn-warning btn-block " type="submit" onclick="${action}" >走你</button>
    </div>
    
    
  </body>
</html>
