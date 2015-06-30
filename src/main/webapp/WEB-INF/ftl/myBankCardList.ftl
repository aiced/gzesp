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
	<script type="text/javascript" src="${resRoot}/js/myBankCardList.js?v=${resVer}"></script>
    
</head>
<body>
    <!--top_start-->
    <div id="top">
        <div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        <div id="top_middle">我的银行卡</div>
        <div id="top_right"></div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
    <div class="div_container_bank">
        <div class="list-group">        
        	<#if (acctbankinfolist?exists)>
       			<#list acctbankinfolist as item>
        			<a href="/esp/shopManage/acct/bankCardDetail/${item.USER_ID}/${item.BANK_NO}" class="list-group-item">
		            	<div class="span1"> 
		            		<img width=80 height=60 alt="银行卡" src="${resRoot}/image/myacct/${item.BANK_TYPE}.png" >
		            	</div>
		                <div class="span2">
		                	${item.PARAM_VALUE}
		                	<br/>
		                	<span>
		                	尾号${item.BANK_NO?substring((item.BANK_NO?length)-4,item.BANK_NO?length)}
		                	<#if (item.CARD_TYPE =='01')>
		                		信用卡
		                	<#elseif (item.CARD_TYPE =='02')>
		                		储蓄卡
		                	</#if>
		                	</span>
		                </div>
	                    <div class="span3">
	                        <img src="${resRoot}/image/myacct/jiantou.png">
	                    </div>
		            </a>
        		</#list>
        	<#else>
 				<center>您还没有绑定银行卡</center>
        	</#if>
        </div>
        <div class="div_container">
            <button class="btn btn-warning btn-block " type="submit" data-toggle="modal" data-target="#myModal">添加银行卡</button>
        </div>
		<input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="clearTextVal();"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入支付密码</h4>
                </div>
                <div class="modal-body">
<!--                     <span>交通银行<span>尾号2878储蓄卡</span></span>
                    <br> -->
                    <div class="pwd_container">
                        <div>
                            <input type="password" class="form-control" id="txt1" placeholder="" maxlength="1" onkeyup="checkData(this,txt2);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt2" placeholder="" maxlength="1" onkeyup="checkData(this,txt3);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt3" placeholder="" maxlength="1" onkeyup="checkData(this,txt4);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt4" placeholder="" maxlength="1" onkeyup="checkData(this,txt5);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt5" placeholder="" maxlength="1" onkeyup="checkData(this,txt6);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt6" placeholder="" maxlength="1" onkeyup="checkData(this,btnok);" onfocus="doFocus(this);">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default modal-button" name="btnclear" id="btnclear" onclick="clearTextVal();">清空</button>
                    <button type="button" class="btn btn-warning modal-button" name="btnok" id="btnok" onclick="doClick();">确定</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>