<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>提现</title>

    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/myacct.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/modaldialogStyle.css?v=${resVer}" rel="stylesheet">

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
    <script type="text/javascript" src="${resRoot}/js/withdraw.js?v=${resVer}"></script>
  
    
    <script type="text/javascript">

    	
    </script>
</head>
<body>
<!--top_start-->
<div id="top">
	<div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
   	<div id="top_middle">提现</div>
   	<div id="top_right">
	</div>
</div>
<div class="dv_clear"></div>
<!--top_end-->
	<#if (acctbankinfolist?exists)>
	<div class="div_container">
		<#list acctbankinfolist as item>
		    <div class="radio">
		        <div id="lab${item_index}" >
		            <input type="radio" name="optionsRadios" id="optionsRadios${item_index}" value="${item.SIGN_CODE}" onclick="doRadClick(this,'${item.BANK_NO}',${item.BANK_TYPE});">
                	<label for="optionsRadios${item_index}">${item.PARAM_VALUE}
	                	<span>
	                	尾号${item.BANK_NO?substring((item.BANK_NO?length)-4,item.BANK_NO?length)}
	                	<#if (item.CARD_TYPE =='01')>
	                		信用卡
	                	<#elseif (item.CARD_TYPE =='02')>
	                		储蓄卡
	                	</#if>
	                	</span>
                	</label>
		        </div>
		    </div>
    	</#list>

</div>
<br>
<div class="div_container_mid form-group" >
    <span>转出金额
    	<input type="text" class="input" id="txtbalance" placeholder="当前可提现金额${acctinfo.BALANCE?string('#.##')}元" onblur="doBlur(this);">
	</span>
</div>
<div class="div_container_bottom">
    预计在3-7个工作日后打到您的银行账户，请注意查收～
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<div class="div_container">
    <button class="btn btn-warning btn-block " type="submit" data-toggle="modal" data-target="#myModal" onclick="doSubmit(this);">确认转出</button>
</div>
    <input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
    <input type="hidden" id="hide_balance" name="hide_balance" value=${acctinfo.BALANCE?string('#.##')}>
    <input type="hidden" id="hide_acctid" name="hide_acctid" value=${acctinfo.ACCT_ID}>       
   	<input type="hidden" id="hide_bankno" name="hide_bankno" value="">       
   	<input type="hidden" id="hide_banktype" name="hide_banktype" value="">       
   	
   	<#else>
		<center>您还没有绑定银行卡</center>
		<center><a href="/esp/shopManage/acct/myBankCardList/${acctinfo.USER_ID}">现在去绑定</a></center>
   	</#if>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">请输入安全密码</h4>
            </div>
            <div class="modal-body">
                <span id='span_modal'></span>
                <br>
                <div class="pwd_container">
                   	<div>
                    	<input type="password" value="" name="txtsecuritypwd" id="txtsecuritypwd" maxlength="6" size="6" class="form-control" onkeyup="checkPwd(this,btnok);" >
                    </div>
                    <!-- <div>
                        <input type="password" class="form-control" id="txt1" placeholder="" maxlength="1" onkeyup="checkPwd(this,txt2);" onfocus="doFocus(this);">
                    </div>
                    <div>
                        <input type="password" class="form-control" id="txt2" placeholder="" maxlength="1" onkeyup="checkPwd(this,txt3);" onfocus="doFocus(this);">
                    </div>
                    <div>
                        <input type="password" class="form-control" id="txt3" placeholder="" maxlength="1" onkeyup="checkPwd(this,txt4);" onfocus="doFocus(this);">
                    </div>
                    <div>
                        <input type="password" class="form-control" id="txt4" placeholder="" maxlength="1" onkeyup="checkPwd(this,txt5);" onfocus="doFocus(this);">
                    </div>
                    <div>
                        <input type="password" class="form-control" id="txt5" placeholder="" maxlength="1" onkeyup="checkPwd(this,txt6);" onfocus="doFocus(this);">
                    </div>
                    <div>
                        <input type="password" class="form-control" id="txt6" placeholder="" maxlength="1" onkeyup="checkPwd(this,btnok);" onfocus="doFocus(this);">
                    </div> -->
                </div>
            </div>
            <div class="modal-footer">
                   <button type="button" class="btn btn-default modal-button" name="btnclear" id="btnclear" onclick="clearTextVal();">清空</button>
                   <button type="button" class="btn btn-warning modal-button" name="btnok" id="btnok" onclick="doClick(this,2);">确定</button>
            </div>
        </div>
    </div>
</div>


</body>
</html>