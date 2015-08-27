   	function checkData(param1,param2)
    	{
   		
   			//alert($(".pwd_container").width());
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
    		
//    		var txtpwd="";
//    		for (var i = 1; i < 7; i++) {
//    			txtpwd=txtpwd+$("#txt"+i).val();
//			}
			$("#btnok").attr('disabled',"true");
    		if ($('#txtsecuritypwd').val().length!=6)
    		{
    			alert("请输入6位安全密码！");
    			$("#btnok").removeAttr("disabled");
    			return;
    		}
    		
			var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtsecuritypwd').val()};
			$.ajax({
			 type: "POST",
			 url: 'checkPwd',
			 data: parms,
			 success: function(data){
				if(!data)
				{
					alert("输入密码有误，请重新输入！");
					clearTextVal();
	    			$("#btnok").removeAttr("disabled");
					return 
				}
				window.location.href='/esp/shopManage/acct/addBankCardInput1/'+$("#hide_user_id").val();
			 }
			});
    	}
    	 
    	function clearTextVal()
    	{
//    		for (var i = 1; i < 7; i++) {
//        		$("#txt"+i).val("");
//			}
    		$("#txtsecuritypwd").val("");
    	}
    	function doFocus(param)
    	{
    		//alert("1");
    		//$(param).val("1");
    		$(param).val("");
    	}
    	
    	function leftClick(param)
    	{
    		window.location.href='/esp/shopManage/acct/myAcct/'+$("#hide_user_id").val();
    	}
    	