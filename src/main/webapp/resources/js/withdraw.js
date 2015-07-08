    function leftClick(param)
    {
		window.location.href='/esp/shopManage/acct/myAcct/'+$("#hide_user_id").val();
    }
    
	function doClick(param)
	{
		//alert($(param)[0].tagName);
		//var id=$(param).attr("id");
		//var a=$("#"+id+" :input").attr("checked","checked");
		
		var txt=$("input[name='optionsRadios']:checked").next("label").text();
		if (txt.indexOf("信用卡") > 0 ) {
			alert("不支持信用卡提现，如没有绑定其他储蓄卡，请先绑定储蓄卡再次进行提现！");
			return;
		}
		
		$("#span_modal").html($("input[name='optionsRadios']:checked").next("label").text());
		
	}

	function doBlur(param)
	{
		var reg = /^\d*$/;
		if(!reg.test($(param).val()))
		{
			iRet=11;
	  		return opReturn(iRet);
		}
		iRet=00;
		return opReturn(iRet);
	}
	
	
	function checkData()
	{
		if (!$("#txtbalance").val()) {
			iRet=12;
	  		return opReturn(iRet);
		}
		
		var reg = /^\d*$/;
		if(!reg.test($("#txtbalance").val()))
		{
			iRet=11;
	  		return opReturn(iRet);
		}
		
		if ($("#txtbalance").val()>$("#hide_balance").val()) {
			iRet=13;
	  		return opReturn(iRet);
		}
		
		iRet=00;
		return opReturn(iRet);
	}
	
	//返回错误码：
	//默认：-1
	//00：成功！
	//11：金额必须是数字
	//12：金额不能为空
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
			alert("持卡人不能为空!");
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
	
	
	