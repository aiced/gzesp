<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <title>我的账户</title>
    
    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/myacct.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/buttonStyle.css?v=${resVer}" rel="stylesheet">
    
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
</head>
<body>
    <!--top_start-->
    <div id="top">
       	<div id="top_left"></div>
       	<div id="top_middle">我的账户</div>
       	<div id="top_right">
			<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
		</div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
    <div class="div_container">
        <div class="container_top">
            <table>
                <tr>
                    <td>
						<img src="${resRoot}/image/myacct/qiandai.png" width="48" height="48">
                    	账户余额
                    </td>
                    <td rowspan="2" class="td01">
                        <div></div>
                    </td>
                    <td rowspan="2">
                        <a class="myButton" href="../withdraw/111">提现</a>
                    </td>
                </tr>
                <tr>
                    <td class="td02">
                        	￥888.00
                    </td>
                </tr>
            </table>
            <!--<div class="container_top_left">2</div>-->
            <!--<div class="container_top_mid"></div>-->
            <!--<div class="container_top_right">3</div>-->
            <!--<div class="dv_clear"></div>-->
        </div>
        <br/>
        <br/>
        <div class="container_mid">
            <div class="list-group">
                <a href="#" class="list-group-item">
                    <span class="list_icon">
						<img src="${resRoot}/image/myacct/daijinquan.png">
                    	代金券
                    </span>
                    <span class="list_gou">
						<img src="${resRoot}/image/myacct/jiantou.png">
                    </span>
                </a>
            </div>
            <div class="list-group">
                <a href="../myBankCardList/111" class="list-group-item">
                    <span class="list_icon">
						<img src="${resRoot}/image/myacct/ka.png">
                    	我的银行卡
                    	<span class="badge">4张</span>
                    </span>
                    <span class="list_gou">
						<img src="${resRoot}/image/myacct/jiantou.png"></span>
                    </span>
                </a>
            </div>
            <div class="list-group">
                <a href="../acctBalance/111" class="list-group-item">
                    <span class="list_icon">
						<img src="${resRoot}/image/myacct/xinxi.png">
                    	收支明细
                    </span>
                    <span class="list_gou">
						<img src="${resRoot}/image/myacct/jiantou.png"></span>
                    </span>
                </a>
            </div>
        </div>
    </div>
</body>
</html>