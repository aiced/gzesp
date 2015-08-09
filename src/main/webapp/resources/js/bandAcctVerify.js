

//验证 ajax请求后台controller，controller里面调用bss接口进行宽带账号验证
function doCheckClick(param)
{
//	var parms = {'user_id':$('#hide_user_id').val(),'bandAcct':$('#bandAcct').val()};
//	$.ajax({
//	 type: "POST",
//	 url: '/esp/weShop/bandAcctCheck',
//	 data: parms,
//	 success: function(data){
//		//这里要根据返回值做判断然后进行不同的页面跳转
//		alert(data);
//		if (date=="0000") {
//			window.location.href='/esp/weShop/bandGoodSelect/+'+$("#hide_user_id").val();
//		}
//	 }
//	});
	
	
	if(!$("#bandAcct").val())
	{
		iRet=11;
  		return opReturn(iRet);
	}
//	var reg = /^\d*$/;
//	if(!reg.test($("#bandAcct").val()))
//	{
//		iRet=12;
//  		return opReturn(iRet);
//	}
	
	
	var parms = {'user_id':$('#hide_user_id').val(),'bandAcct':$('#bandAcct').val()};
	$.commonFormSubmit({
	 type: "POST",
	 action: '/esp/weShop/bandAcctCheck',
	 data: parms,
	 success: function(data){

	  	 return;
	 }
	});
	
	
	var bRet=-1;
	function opReturn(iRet)
	{
		switch (iRet) {
		case 00:
			//alert("操作成功！");
			return true;
		case 11:
			alert("固网账户不能为空!");
			return false;
		case 12:
			alert("固网账户必须为数字!");
			return false;	
		default:
			return false;
		}
	}
	
}