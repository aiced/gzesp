<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>宽带续费</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/bandAcctVerify.css?v=${resVer}" rel="stylesheet">
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
        <div class="col-xs-8">
    	  <p class="text-center navbar-p">宽带续费 </p>
    	</div>
      </div>      
    </div> 
    
    <!-- 表单 -->
    <div class="container">
      <form class="form-signin">
        <label for="bandAcct" class="sr-only">band acct</label>
        <input type="text" id="bandAcct" name='bandAcct' class="form-control" placeholder="固网账户" autofocus>
        <br/>
        <button class="btn btn-lg btn-warning btn-block" type="button" onclick="doCheckClick(this);">验证</button>
		<input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
      </form>

    </div> <!-- /container -->    

    <!-- Bootstrap core JavaScript -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script type="text/javascript" src="${resRoot}/js/bandAcctVerify.js?v=${resVer}"></script>	
  	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
  </body>
</html>
