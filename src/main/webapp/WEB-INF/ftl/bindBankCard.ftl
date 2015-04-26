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
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    <script type="text/javascript">
    	var bRet1=false;

    	function checkData()
    	{
    		if(!bRet1)
    		{
    			return false;
    		}
			if($("#selBank").val()=="请选择开户银行")
			{
				alert("请选择开户银行");
				return false;
			}

    		return true;
    		
    	}
    	
    	function checkCardcode()
    	{
		  	//在这里操作 银行卡号 文本框失去焦点
		  	if(!$("#txtbankcardid").val())
		  	{
		  		$("#div_bankcardid").addClass("has-error");
		  		bRet1=false;
		  		return;
		  	}
		  	else
		  	{
		  		
	    		if (!checkBankCard($("#txtbankcardid").val())) {
			  		$("#div_bankcardid").removeClass("has-error");
			  		bRet1=false;
					return;
				}
	    		
		  		$("#div_bankcardid").removeClass("has-error");
		  		$("#div_bankcardid").addClass("has-success");

		  		bRet1=true;
		  		return;
		  	}
    		
    		
    		
    	}
    	
    	
		$(document).ready(function(){ 
		   //第一次加载的时候 进行判断文本框是否为空
		   
			checkCardcode();
			
			
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
		       	var bReturn=false;  
	      		var parms = {'hide_userid':$("#hide_userid").val(),'selBank':$("#selBank").val(),'txtbankcardid':$("#txtbankcardid").val()};
	      		$.ajax({
	         		type: "POST",
	      		 	url: '${base}/shopManage/BankCard_PostData',
	      		 	data: parms,
	      		 	async:false,
	      		 	success: function(bRet){
					if(bRet)
					{
						alert("已经提交成功");
						location.href="${base}/shopManage/weShopSet?userid="+$("#hide_userid").val();
					}
	      		 }
	      		});
				
				return true;
			}
		  });		
		
		  
		  //[银行卡号]文本框失去焦点
		  $("#txtbankcardid").blur(function(){
			  
			  checkCardcode();
		  	//在这里操作 银行卡号 文本框失去焦点
		  	/*if(!$("#txtbankcardid").val())
		  	{
		  		$("#div_bankcardid").addClass("has-error");
		  		bRet1=false;
		  		return;
		  	}
		  	else
		  	{
		  		
	    		if (!checkBankCard($("#txtbankcardid").val())) {
			  		$("#div_bankcardid").removeClass("has-error");
			  		bRet1=false;
					return;
				}
	    		
		  		$("#div_bankcardid").removeClass("has-error");
		  		$("#div_bankcardid").addClass("has-success");

		  		bRet1=true;
		  		return;
		  	}*/
		  });
		   
		  
          //[返回]按钮点击
          $("#top_left_bank").click(function(){  
      		var parms = {'hide_userid':$("#hide_userid").val()};
      		$.commonFormSubmit({
         		 type: "POST",
      		 action: '${base}/shopManage/BankBack',
      		 data: parms,
      		 success: function(data){
      		  	 //history.back();
      		  	 //alert("ok");
      		  	 //return;
      		  	 //alert(data);
      		  	 return;
      		 }
      		});
          }); 		  
		  
		});
    </script>
    <style type="text/css">
        .container-fluid
        {
            margin: 15px;
        }

		#top_bank
		{
		    width: auto;
		    height: 40px;
		    background-color:#21292C;
		    color: #ffffff;
		    vertical-align: middle;
		    text-align: center;
		    line-height: 40px;
		    font-size: 20px;
		}
		#top_left_bank
		{
			float:left;
			width:20%;
			height:40px;
			font-size:14px;
		}
		#top_left_bank a
		{
			color: #ffffff;
		}
		#top_middle_bank
		{
			float:left;
			width:60%;
			height:40px;
			font-family: 'Microsoft Yahei','Simsun',Helvetica,Arial,sans-serif;
		    font-size: 19px;
		    font-weight: bold;
		}
		#top_right_bank
		{
			float:left;
			width:20%;
			height:40px;
		}
		#dv_clear_bank
		{
			clear:both;
		}
    </style>
</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top_bank">
        	<div id="top_left_bank"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        	<div id="top_middle_bank">${title}</div>
        	<div id="top_right_bank"></div>
        </div>
		<div id="dv_clear_bank"></div>
		<!--top_end-->
	
	    <div class="container-fluid">
	        <form action="#" method="post">
	            <!--开户银行-->
	            <div class="form-group">
	                <select class="form-control" name="selBank" id="selBank">
	                	<option value="请选择开户银行">请选择开户银行</option>
			      		<#if (bankList?size==0)>
							<option value="数据加载失败">数据加载失败</option>
			        	<#else>
							<#list bankList as item>						
								<#if (nengrendata.bankName != '' && item.param_code==nengrendata.bankName)>
									<option value="${item.param_code}" selected="selected">
								<#else>
								    <option value="${item.param_code}">
								</#if>
									${item.param_value}
									</option>
							</#list>
			 			</#if>
	                </select>
	            </div>
	  
	            <!--银行卡号-->
	            <div class="form-group" id="div_bankcardid">
	                <label for="txtbankcardid" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtbankcardid" name="txtbankcardid" placeholder="请输入银行卡号(储蓄卡)" value='${nengrendata.bankAcct}'>
	            </div>
				
				<br/>
				<br/>
				<br/>
	            <button class="btn btn-warning btn-block " type="button" name="btnSubmit" id="btnSubmit">提交</button>
	        	
	        	<input type="hidden" name="hide_userid" id="hide_userid" value="${userid}" />

	        </form>
	    </div>
	</div>
</body>
</html>