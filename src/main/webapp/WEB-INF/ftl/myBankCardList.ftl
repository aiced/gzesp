<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>我的银行卡</title>

    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/myacct.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/modaldialogStyle.css?v=${resVer}" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>

</head>
<body>
    <!--top_start-->
    <div id="top">
        <!--	<div style="float:left;width:20%;height:40px;font-size:14px;"></div> -->
        <div id="top_left"></div>
        <div id="top_middle">我的银行卡</div>
        <div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
    <div class="div_container">
        <div class="list-group">
            <a href="#" class="list-group-item">
                <span>交通银行</span>
                    <span class="list_gou">
                        <img src="jiantou.png">
                    </span>
            </a>
            <a href="#" class="list-group-item">
                <span>招商银行</span>
                    <span class="list_gou">
                        <img src="jiantou.png">
                    </span>
            </a>
            <a href="#" class="list-group-item">
                <span>中国银行</span>
                    <span class="list_gou">
                        <img src="jiantou.png">
                    </span>
            </a>
        </div>
        <div class="div_container">
            <button class="btn btn-warning btn-block " type="submit" data-toggle="modal" data-target="#myModal">添加银行卡</button>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入支付密码</h4>
                </div>
                <div class="modal-body">
                    <span>交通银行<span>尾号2878储蓄卡</span></span>
                    <br>
                    <div class="pwd_container">
                        <div>
                            <input type="email" class="form-control" id="1" placeholder="">
                        </div>
                        <div>
                            <input type="email" class="form-control" id="2" placeholder="">
                        </div>
                        <div>
                            <input type="email" class="form-control" id="3" placeholder="">
                        </div>
                        <div>
                            <input type="email" class="form-control" id="4" placeholder="">
                        </div>
                        <div>
                            <input type="email" class="form-control" id="5" placeholder="">
                        </div>
                        <div>
                            <input type="email" class="form-control" id="6" placeholder="">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default modal-button" data-dismiss="modal">取消</button>
                    <button type="button" class="btn btn-warning modal-button">确定</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>