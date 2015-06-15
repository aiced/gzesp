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
    
    
    <script type="text/javascript">
    
    function isSetPwd(param)
    {
 		if (!$("#hide_update_time").val())
  		{
  			alert("请先点击右上角进行安全设置！");
  			$(param).attr('href', '#'); 
  			return false;
  		}  
    }
    function rightClick(param)
    {
    	window.location.href='../acctSecurity/'+$("#hide_user_id").val();
    	
    }
   	$(function(){
   				
   	});
   	
   	
    </script>
</head>
<body>





    <!--top_start-->
    <div id="top">
       	<div id="top_left"></div>
       	<div id="top_middle">我的账户</div>
       	<div id="top_right" onclick="rightClick(this)">
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
                    	<a href="../withdraw/${acctinfo.USER_ID}" onclick="isSetPwd(this);" class="myButton" id="btntixian">提现</a>
                    </td>
                </tr>
                <tr>
                    <td class="td02">
                    ¥${(acctinfo.BALANCE/1000)?string("#.##")}
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
        <div id="container_mid" class="container_mid">
            <div class="list-group">
                <a href="#" class="list-group-item"  onclick="isSetPwd(this);">
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
                <a href="../myBankCardList/${acctinfo.USER_ID}" class="list-group-item"  onclick="isSetPwd(this);">
                    <span class="list_icon">
						<img src="${resRoot}/image/myacct/ka.png">
                    	我的银行卡
                    	<span class="badge">${bankcout}张</span>
                    </span>
                    <span class="list_gou">
						<img src="${resRoot}/image/myacct/jiantou.png"></span>
                    </span>
                </a>
            </div>
            <div class="list-group">
                <a onclick="isSetPwd(this);" href="../acctBalance/${acctinfo.USER_ID}" class="list-group-item">
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
        <input type="hidden" id="hide_update_time" name="hide_update_time" value=${acctinfo.UPDATE_TIME}>
        <input type="hidden" id="hide_user_id" name="hide_user_id" value=${acctinfo.USER_ID}>
    </div>
</body>
</html>