<!DOCTYPE html>
<html>
<head lang="zh-cn">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>${title}</title>
    
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![end if]-->
    
        <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script>
    
    $(function(){
    	$('#custOrderQueryForm').submit(function() {
    		var phone = $('#inputMobile').val();
        	var passport = $('#inputPassport').val();
        	//alert(phone + passport);
        	location.href = "custMyOrder/"+phone+"/"+passport;
        	return false;
    	});
    })
//     function onBtnSubmit() {
//     	var phone = $('#inputMobile').val();
//     	var passport = $('#inputPassport').val();
//     	location.href = "custMyOrder/"+phone+"/"+passport;
//     	return false;
//     }
    
    </script>
</head>
<body>
    <div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
        <div class="container">
            <form  id="custOrderQueryForm" class="form-signin" method="post">
                <br/>
                <br/>
                <input type="text"  id="inputMobile" name="inputMobile" class="form-control" placeholder="输入您的手机号"  required autofocus>
                <br/>
                <input type="text" id="inputPassport" name="inputPassport" class="form-control" placeholder="输入您的证件号" required>
                <br/>
                <br/>
                <button class="btn btn-warning btn-block "  name="btnSubmit" id="btnSubmit" >提交</button>
            </form>

        </div> 
    </div>
    
</body>
</html>