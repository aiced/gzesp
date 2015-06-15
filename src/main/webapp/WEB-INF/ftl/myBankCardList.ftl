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
    		else
    		{
    			$(param2).focus();
    			return true;
    		}
    	}
    	
    	function doClick()
    	{
    		//ajax请求
    		
    		var txtpwd="";
    		for (var i = 1; i < 7; i++) {
    			txtpwd=txtpwd+$("#txt"+i).val();
			}
    		if (txtpwd.length!=6)
    		{
    			alert("请输入6位支付密码！");
    			return;
    		}
    		
			var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':txtpwd};
			$.ajax({
			 type: "POST",
			 url: 'checkPwd',
			 data: parms,
			 success: function(data){
				alert(data);	
			 }
			});
    	}
    	 
    	function clearTextVal()
    	{
    		for (var i = 1; i < 7; i++) {
        		$("#txt"+i).val("");
			}
    	}
    </script>
</head>
<body>
    <!--top_start-->
    <div id="top">
        <div id="top_left"></div>
        <div id="top_middle">我的银行卡</div>
        <div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
    <div class="div_container">
        <div class="list-group">        
        	<#if (acctbankinfo?exists)>
       			<#list acctbankinfo as item>
		            <a href="#" class="list-group-item">
		            	<span> 
		            		<img width=64 height=64 alt="银行卡" src="${resRoot}/image/myacct/item_index.png" >
		            	</span>
		                <span>
		                	${item.param_value}
		                	<br/>
		                	尾号${item.bank_no?substring((item.bank_no?length)-4,item.bank_no?length)}
		                	<#if (item.card_type =='01')>
		                		信用卡
		                	<#elseif (item.card_type =='02')>
		                		储蓄卡
		                	</#if>
		                </span>
	                    <span class="list_gou">
	                        <img src="jiantou.png">
	                    </span>
		            </a>
        		</#list>
        	<#else>
 				<center>您还没有绑定银行卡</center>
        	</#if>
<!--             <a href="#" class="list-group-item">
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
            </a> -->
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
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="clearTextVal();"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入支付密码</h4>
                </div>
                <div class="modal-body">
<!--                     <span>交通银行<span>尾号2878储蓄卡</span></span>
                    <br> -->
                    <div class="pwd_container">
                        <div>
                            <input type="password" class="form-control" id="txt1" placeholder="" maxlength="1" onkeyup="checkData(this,txt2);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt2" placeholder="" maxlength="1" onkeyup="checkData(this,txt3);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt3" placeholder="" maxlength="1" onkeyup="checkData(this,txt4);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt4" placeholder="" maxlength="1" onkeyup="checkData(this,txt5);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt5" placeholder="" maxlength="1" onkeyup="checkData(this,txt6);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt6" placeholder="" maxlength="1" onkeyup="checkData(this,btnok);">
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