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
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
        <div class="container-fluid">
            <form>
                <!--输入收件人-->
                <div class="form-group">
                    <label for="txtname" class="sr-only"></label>
                    <input type="text" class="form-control" id="txtname" placeholder="收件人">
                </div>
                <!--输入手机号-->
                <div class="form-group">
                    <label for="txtphone" class="sr-only"></label>
                    <input type="text" class="form-control" id="txtphone" placeholder="请输入手机号">
                </div>
                <div class="row">
                    <div class="col-xs-4 col-sm-4">
                        <div class="input-group">
                            <select class="form-control" placeholder="省">
                                <option>贵州</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4">
                        <div class="input-group">
                            <select class="form-control" placeholder="市">
                                <option>贵州</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4">
                        <div class="input-group">
                            <select class="form-control" placeholder="区">
                                <option>贵州</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                </div>
                <br/>
                <!--输入详细地址-->
                <div class="form-group">
                    <textarea class="form-control" rows="3" id="txtaddress" placeholder="请输入详细地址"></textarea>

                </div>
                <br/>
                <button class="btn btn-warning btn-block " type="submit">确定</button>
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