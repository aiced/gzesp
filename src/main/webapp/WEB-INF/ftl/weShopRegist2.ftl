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
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script type="text/javascript">
    	var bRet1=false;
    	var bRet2=false;
 
    	function checkData()
    	{
    		/*if(!$("#txtname").val())
    		{
    			alert("请输入姓名");
    			return false;
    		}
    		if(!checkEnergyCard($("#txtpersonalid").val()))
    		{
    			return false;
    		}
    		if(!$("#txtbankcardid").val())
    		{
    			alert("请输入银行卡号");
    			return false;
    		}
    		
    		if (!checkBankCard($("#txtbankcardid").val())) {
				return false;
			}
    		return true;*/
    		
    		
    		
    		if(!bRet1)
    		{
    			alert("请输入姓名");
    			return false;
    		}
    		if(!bRet2)
    		{
    			return false;
    		}
    		return true;
    		
    	}
		$(document).ready(function(){ 
		   //[提交]按钮点击
		  $("#btnSubmit").click(function(){  
			  //在这里操作提交
			  //alert(!checkData());
			if(!checkData())
			{
				//alert("有错误不可以提交");
				return false;
			}
			else
			{
				//alert("可以提交了！");
				return true;
			}
		  });		
			
		  //[姓名]文本框失去焦点
		  $("#txtname").blur(function(){
		  	//在这里操作 姓名 文本框失去焦点
		  	if(!$("#txtname").val())
		  	{
		  		$("#div_name").addClass("has-error");
		  		bRet1=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_name").removeClass("has-error");
		  		$("#div_name").addClass("has-success");

		  		bRet1=true;
		  		return;
		  	}
		  });
		  
		  //[身份证号]文本框失去焦点
		  $("#txtpersonalid").blur(function(){
		  	//在这里操作 身份证号 文本框失去焦点
		  	if(!$("#txtpersonalid").val())
		  	{
		  		$("#div_personalid").addClass("has-error");
		  		bRet2=false;
		  		return;
		  	}
		  	else
		  	{
		  		
	    		if(!checkEnergyCard($("#txtpersonalid").val()))
	    		{
			  		$("#div_personalid").addClass("has-error");
			  		bRet2=false;
	    			return;
	    		}
		  		
		  		$("#div_personalid").removeClass("has-error");
		  		$("#div_personalid").addClass("has-success");

		  		bRet2=true;
		  		return;
		  	}
		  });
		   
		  //[银行卡号]文本框失去焦点
		 /* $("#txtbankcardid").blur(function(){
		  	//在这里操作 银行卡号 文本框失去焦点
		  	if(!$("#txtbankcardid").val())
		  	{
		  		$("#div_bankcardid").addClass("has-error");
		  		bRet3=false;
		  		return;
		  	}
		  	else
		  	{
		  		
	    		if (!checkBankCard($("#txtbankcardid").val())) {
			  		$("#div_bankcardid").removeClass("has-error");
			  		bRet3=false;
					return;
				}
	    		
		  		$("#div_bankcardid").removeClass("has-error");
		  		$("#div_bankcardid").addClass("has-success");

		  		bRet3=true;
		  		return;
		  	}
		  });*/
		   
		});
    </script>
    <style type="text/css">
        .container-fluid
        {
            margin: 15px;
        }
		.breadcrumb
		{
			background-color: #cccccc;
			font-size: 12px;
		}

    </style>
</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
		<ol class="breadcrumb">
			<label style="color:green;">1.输入手机号</label>&nbsp;&nbsp;>&nbsp;&nbsp;<label style="color:green;">2.身份信息填写</label>&nbsp;&nbsp;>&nbsp;&nbsp;<label>3.设置密码</label>
		</ol>
	    <div class="container-fluid">
	        <form action="reg_step2_postdata" method="post">
	        	<span style="color: #ff0000">为保证收益的准确发放，以下请填写真实信息!</span>
	            <br/>
	            <br/>
	            <!--姓名-->
	            <div class="form-group" id="div_name">
	                <label for="txtname" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtname" name="txtname" placeholder="请输入姓名">
	            </div>
	            <!--性别-->
	            <div class="form-group">
	                <label class="radio-inline">
	                    <input type="radio" name="radsex" id="radnan" value="男" checked="checked"> 男
	                </label>
	                <label class="radio-inline">
	                    <input type="radio" name="radsex" id="radnv" value="女"> 女
	                </label>
	            </div>
	            
	            <!--身份证号-->
	            <div class="form-group" id="div_personalid">
	                <label for="txtpersonalid" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtpersonalid" name="txtpersonalid" placeholder="请输入身份证号">
	            </div>
	            <!--输入微信号-->
	            <div class="form-group" id="div_weichat">
	                <label for="txtwechataccount" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtwechataccount" name="txtwechataccount" placeholder="请输入微信号(选填)">
	            </div>
	            <!--开户银行-->
	            <#-- <div class="form-group">
	                <select class="form-control" name="selBank">
			      		<#if (bankList?size==0)>
							<option value="数据加载失败">数据加载失败</option>
			        	<#else>
							<#list bankList as item>
								<option value="${item.param_code}">${item.param_value}</option>
							</#list>
			 			</#if>
	                </select>
	            </div> -->
	            <!--银行卡号-->
	            <!-- <div class="form-group" id="div_bankcardid">
	                <label for="txtbankcardid" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtbankcardid" name="txtbankcardid" placeholder="请输入银行卡号">
	            </div> -->
				<!-- 用户注册协议 -->
				<!-- <div style="float:right;font-size: 12px;">
					<input type="checkbox" name="chkRight" id="chkRight" checked="true"><a href="regProtocol">用户注册协议</a>
				</div> -->
				<br/>
				<br/>
	            <button class="btn btn-warning btn-block " type="submit" name="btnSubmit" id="btnSubmit">下一步</button>
	        	
	        	<input type="hidden" name="selArea" value="${area}" />
	        	<input type="hidden" name="txtphonenum" value="${phonenum}" />
	        	<input type="hidden" name="txtopenid" value="${openid}" />



				
	        </form>
	    </div>
	</div>
</body>
</html>