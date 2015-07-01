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
				if(!data)
				{
					alert("输入密码有误，请重新输入！");
					clearTextVal();
					return 
				}
				window.location.href='/esp/shopManage/acct/addBankCardInput1/'+$("#hide_user_id").val();
			 }
			});
    	}
    	 
    	function clearTextVal()
    	{
    		for (var i = 1; i < 7; i++) {
        		$("#txt"+i).val("");
			}
    	}
    	function doFocus(param)
    	{
    		$(param).val("");
    	}
    	
    	function leftClick(param)
    	{
    		window.location.href='/esp/shopManage/acct/myAcct/'+$("#hide_user_id").val();
    	}
    	