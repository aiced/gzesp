<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <title>${title}</title>
   
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/weShopLoginIndex.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![end if]-->

    <style type="text/css">
        .container-fluid
        {
            margin: 15px;
        }
        .btn{
            padding: 1px 5px;
            font-size: 12px;
            line-height: 1.5;
        }
        .form-control
        {
            font-size: 10px;
            padding:3px 3px;
        }

    </style>
</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
	
	    <div class="container-fluid">
	        <form>
	            <!--姓名-->
	            <div class="form-group">
	                <label for="txtname" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtname" placeholder="请输入姓名">
	            </div>
	            <!--性别-->
	            <div class="form-group">
	                <label class="radio-inline">
	                    <input type="radio" name="radsex" id="radnan" value="男"> 男
	                </label>
	                <label class="radio-inline">
	                    <input type="radio" name="radsex" id="radnv" value="女"> 女
	                </label>
	            </div>
	            <!--身份证号-->
	            <div class="form-group">
	                <label for="txtpersonalid" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtpersonalid" placeholder="请输入身份证号">
	            </div>
	            <!--开户银行-->
	            <div class="form-group">
	                <select class="form-control">
	                    <option>贵州银行1</option>
	                    <option>贵州银行2</option>
	                    <option>贵州银行3</option>
	                    <option>贵州银行4</option>
	                    <option>贵州银行5</option>
	                </select>
	            </div>
	            <!--银行卡号-->
	            <div class="form-group">
	                <label for="txtbankcardid" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtbankcardid" placeholder="请输入银行卡号">
	            </div>
	            <br/>
	            <button class="btn-sm btn-warning btn-block " type="submit">提交</button>
	        </form>
	    </div>
	</div>
 
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
</body>
</html>