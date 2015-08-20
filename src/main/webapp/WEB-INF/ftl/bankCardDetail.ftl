<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>${title}</title>
    
    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/myacct.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/buttonStyle.css?v=${resVer}" rel="stylesheet">
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

    <script type="text/javascript">
    	
    	function checkData(param1,param2)
    	{
    		var reg = /^\d*$/;
    		if(!reg.test($(param1).val()))
    		{
    			alert("密码只能是数字");
    			$(param1).val("");
    			return false;
    		}
    		else if ($(param1).val().length==6) {
    			$(param2).focus();
    			$(param1).select();
    			param1.setSelectionRange(0,0);
    			return true;
			}
    	}
    	
    	function doClick()
    	{
    		//ajax请求
    		
/*     		var txtpwd="";
    		for (var i = 1; i < 7; i++) {
    			txtpwd=txtpwd+$("#txt"+i).val();
			} */
			$("#btnok").attr('disabled',"true");
    		if ($('#txtsecuritypwd').val().length!=6)
    		{
    			alert("请输入6位安全密码！");
    			$("#btnok").removeAttr("disabled");
    			return;
    		}
    		
			var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtsecuritypwd').val(),'bank_no':$('#hide_bank_no').val()};
			$.ajax({
			 type: "POST",
			 url: '/esp/shopManage/acct/bankCardDetail/undindingBankCard',
			 data: parms,
			 success: function(data){
				 
				 switch(data)
				 {
				 case 1: //密码错误
					alert("输入密码有误，请重新输入！");
					clearTextVal();
				 	break;
				 case 2://删除失败
				 	alert("操作失败，请重新操作");
				 	break;
				 case 3: //操作成功
				 	alert("操作成功");
					break;
				default:
					alert("未知错误");
					break;
				 }
				window.location.href='/esp/shopManage/acct/myBankCardList/'+$("#hide_user_id").val();
			 }
			});
    	}
    	 
    	function clearTextVal()
    	{
/*     		for (var i = 1; i < 7; i++) {
        		$("#txt"+i).val("");
			} */
    		$('#txtsecuritypwd').val("");
    	}
    	function doFocus(param)
    	{
    		$(param).val("");
    	}
    	function leftClick(param)
    	{
    		window.location.href='/esp/shopManage/acct/myBankCardList/'+$("#hide_user_id").val();
    	}
    </script>
</head>
<body>
    <!--top_start-->
    <div id="top">
       	<div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
       	<div id="top_middle">${title}</div>
       	<div id="top_right" onclick="rightClick(this)">
			<!-- <span class="glyphicon glyphicon-cog" aria-hidden="true"></span> -->
		</div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->

    <div class="div_container_bank">
        <div class="list-group">
			<#if (acctbankinfo?exists)>
			        
            <a href="#" class="list-group-item">
            	<div class="span1"> 
            		<img width=80 height=60 alt="银行卡" src="${resRoot}/image/myacct/${acctbankinfo.BANK_TYPE}.png" >
            	</div>
                <div class="span2">
                	${acctbankinfo.PARAM_VALUE}
                	<br/>
                	<span>
                	尾号${acctbankinfo.BANK_NO?substring((acctbankinfo.BANK_NO?length)-4,acctbankinfo.BANK_NO?length)}
                	<#if (acctbankinfo.CARD_TYPE =='01')>
                		信用卡
                	<#elseif (acctbankinfo.CARD_TYPE =='02')>
                		储蓄卡
                	</#if>
                	</span>
                </div>
 <!--                <div class="span3">
                    <img src="${resRoot}/image/myacct/jiantou.png">
                </div> -->
            </a>
        	<#else>
 				<center>您还没有绑定银行卡</center>
        	</#if>
        </div>
        <div class="div_container">
            <button class="btn btn-warning btn-block " type="submit" data-toggle="modal" data-target="#myModal">解除绑定</button>
        </div>
        <input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
        <input type="hidden" id="hide_bank_no" name="hide_bank_no" value=${acctbankinfo.BANK_NO}>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入安全密码</h4>
                </div>
                <div class="modal-body">
                	<#if (acctbankinfo?exists)>
                		<span>${acctbankinfo.PARAM_VALUE}
                			<span>
                				尾号${acctbankinfo.BANK_NO?substring((acctbankinfo.BANK_NO?length)-4,acctbankinfo.BANK_NO?length)}
                			</span>
                		</span>
                	 <#else>
 						<center>您还没有绑定银行卡</center>
        			</#if>
                    
                    <br>
                    <div class="pwd_container">
                    	<div>
                     		<input type="password" value="" name="txtsecuritypwd" id="txtsecuritypwd" maxlength="6" size="6" class="form-control" onkeyup="checkData(this,btnok);" >
                        </div>
<!--                         <div>
                            <input type="password" class="form-control" id="txt1" placeholder="" onkeyup="checkData(this,txt2);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt2" placeholder="" onkeyup="checkData(this,txt3);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt3" placeholder="" onkeyup="checkData(this,txt4);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt4" placeholder="" onkeyup="checkData(this,txt5);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt5" placeholder="" onkeyup="checkData(this,txt6);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt6" placeholder="" onkeyup="checkData(this,btnok);" onfocus="doFocus(this);">
                        </div> -->
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