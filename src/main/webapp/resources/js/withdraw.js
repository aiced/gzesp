    function leftClick(param)
    {
		window.location.href='/esp/shopManage/acct/myAcct/'+$("#hide_user_id").val();
    }
    
    //ajax调用后台controller
    function insertWithdraw()
    {
		var parms = {
				'user_id':$('#hide_user_id').val(),
				'withdraw_fee':$('#txtbalance').val(),
				'hide_acctid':$('#hide_acctid').val(),
				'hide_bank_no':$("#hide_bankno").val(),
				'hide_bank_type':$("#hide_banktype").val()
				};
		$.ajax({
		 type: "POST",
		 url: '/esp/shopManage/acct/withdraw/postData',
		 data: parms,
		 success: function(data){			 
			alert(data);
			window.location.href='/esp/shopManage/acct/withdraw/'+$("#hide_user_id").val();
			
		 }
		});
    }
    
    
    function doRadClick(param1,bank_no,bank_type)
    {
		var txt=$("input[name='optionsRadios']:checked").next("label").text();
		if (txt.indexOf("信用卡") > 0 ) {
			alert("不支持信用卡提现，如没有绑定其他储蓄卡，请先绑定储蓄卡再次进行提现！");
			return;
		}
		
		$("#span_modal").html($("input[name='optionsRadios']:checked").next("label").text());
		$("#hide_bankno").val(bank_no);
		$("#hide_banktype").val(bank_type);
		
    }
    
    
    
	function doClick(param1,param2)
	{
		//alert($(param)[0].tagName);
		//var id=$(param).attr("id");
		//var a=$("#"+id+" :input").attr("checked","checked");
		switch (param2) {
		case 1:
			var txt=$("input[name='optionsRadios']:checked").next("label").text();
			if (txt.indexOf("信用卡") > 0 ) {
				alert("不支持信用卡提现，如没有绑定其他储蓄卡，请先绑定储蓄卡再次进行提现！");
				return;
			}
			
			$("#span_modal").html($("input[name='optionsRadios']:checked").next("label").text());
			
			break;
		case 2: //弹出框确定按
//    		var txtpwd="";
//    		for (var i = 1; i < 7; i++) {
//    			txtpwd=txtpwd+$("#txt"+i).val();
//			}
			$(param1).attr('disabled',"true");
    		if ($('#txtsecuritypwd').val().length!=6)
    		{
    			alert("请输入6位安全密码！");
    			$(param1).removeAttr("disabled");
    			return;
    		}
    		else if ($('#txtbalance').val()==0) {
    			alert("不能提取0元！");
    			clearTextVal();
    			$(param1).removeAttr("disabled");
    			return true;
			}
    		//判断输入的密码是否正确
			var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtsecuritypwd').val()};
			$.ajax({
			 type: "POST",
			 url: '/esp/shopManage/acct/myBankCardList/checkPwd',
			 data: parms,
			 success: function(data){
				if(!data)
				{
					alert("输入密码有误，请重新输入！");
					clearTextVal();
					window.location.href='/esp/shopManage/acct/withdraw/'+$("#hide_user_id").val();
					return;//这个千万别注释掉
				}
				//调用插入
				insertWithdraw();
			 }
			});
		default:
			break;
		}		
	}
	function clearTextVal()
	{
//		for (var i = 1; i < 7; i++) {
//    		$("#txt"+i).val("");
//		}
		$("#txtsecuritypwd").val("");
	}
	
	function doFocus(param)
	{
		$(param).val("");
	}
	function doBlur(param)
	{
		if (!$(param).val()) {
			iRet=11;
	  		return opReturn(iRet);
		}
		var reg = /^[0-9]+([.]\d{1,2})?$/;
		if(!reg.test($(param).val()))
		{
			iRet=12;
	  		return opReturn(iRet);
		}
		if (parseInt($("#txtbalance").val())>parseInt($("#hide_balance").val())) {
			iRet=13;
			$(".div_container button").attr("data-target","");
	  		return opReturn(iRet);
		}
		iRet=00;
		return opReturn(iRet);
	}
	
	function checkPwd(param1,param2)
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
	
	function checkData()
	{
		if (!$("#txtbalance").val()) {
			iRet=11;
			$(".div_container button").attr("data-target","");
	  		return opReturn(iRet);
		}
		
		var reg = /^[0-9]+([.]\d{1,2})?$/;
		if(!reg.test($("#txtbalance").val()))
		{
			iRet=12;
	  		return opReturn(iRet);
		}
		if (parseInt($("#txtbalance").val())>parseInt($("#hide_balance").val())) {
			iRet=13;
			$(".div_container button").attr("data-target","");
	  		return opReturn(iRet);
		}
		
		if ($("#span_modal").html()=="") {
			iRet=21
			$(".div_container button").attr("data-target","");
			return opReturn(iRet);
		}
		$(".div_container button").attr("data-target","#myModal");
		
		iRet=00;
		return opReturn(iRet);
	}
	
	//返回错误码：
	//默认：-1
	//00：成功！
	//12：金额必须是数字
	//11：金额不能为空
	//13：提取金额必须小于余额
	//21:请选择银行卡
	var bRet=-1;
	function opReturn(iRet)
	{
		switch (iRet) {
		case 00:
			//alert("操作成功！");
			return true;
		case 11:
			alert("提现金额不能为空!");
			return false;			
		case 12:
			alert("请输入数字(例:0.00),最高保留两位小数!");
			$("#txtbalance").val("");
			return false;
		case 13:
			alert("提现金额必须小于余额");
			$("#txtbalance").val("")
			return false;
		case 21:
			alert("请选择银行卡");
			return false;
		default:
			return false;
		}
	}
	
	
 
	
	
	
	
	
	
	function doSubmit(param)
	{
		if (!checkData()) {
			return;
		}
		//调用奚总接口，提现
	}
	
	
	