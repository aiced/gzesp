<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <title>${title}</title>
   
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">

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
    
    function submitMenu() {
    	var menuTxt = $('#menuTxt').val().replace(/[\r|\n|\t]/g,"");
    	
    	$.ajax({
 		   type: "POST",
 		   contentType:"application/json", //发送给服务器的内容编码类型
 		   url: "createMenuSubmit",
 		   //data: JSON.stringify(menuTxt), //服务器只能接收json字符串
 		   data: menuTxt, //服务器只能接收json字符串
 		   success: function(data){
 			   alert(data);
 		   }
 		});
    }
    
    </script>
</head>
<body>
	
	    <div class="container-fluid">
	        	
	            <br/>
	            <!--菜单内容-->
	            <textarea class="form-control" rows="30" id="menuTxt" name="menuTxt" placeholder="请输入菜单"></textarea>
	            
				<br/>
				<br/>
	            <button class="btn-sm btn-warning btn-block " onclick="submitMenu()" name="btnSubmit" id="btnSubmit">提交</button>
	        	
	    </div>
</body>
</html