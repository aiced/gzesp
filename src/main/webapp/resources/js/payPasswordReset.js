$(function(){
	initBind();
	
});
function initBind(){
	var save = document.getElementById("save");

	$("#txtpwd").focus(); 
	save.onclick = function() {
	    return saveClick(this);
	};
}

function doFocus(param)
{
	$(param).val("");
}

function doBlur(param)
{
	var iRet=-1;
	var id=$(param).attr("id");
	if (id == "txtpwd") {
		if (!$("#txtpwd").val()) {
			iRet=11;
			return opReturn(iRet);
		}
		if ($("#txtpwd").val().length<6) {
			iRet=14;
			return opReturn(iRet);
		}
	}
	else if(id=="txtrepwd")
	{
		if (!$("#txtrepwd").val()) {
			iRet=12;
			return opReturn(iRet);
		}
		if ($("#txtrepwd").val().length<6) {
			iRet=15;
			return opReturn(iRet);
		}
		if ($("#txtpwd").val()!=$("#txtrepwd").val()) {
			iRet=13;
			return opReturn(iRet);
		}
	}
	
	iRet=00;
	return opReturn(iRet);
}


function checkData()
{
	var iRet=-1;
	if (!$("#txtpwd").val()) {
		iRet=11;
		return opReturn(iRet);
	}
	if ($("#txtpwd").val().length<6) {
		iRet=14;
		return opReturn(iRet);
	}
	if (!$("#txtrepwd").val()) {
		iRet=12;
		return opReturn(iRet);
	}
	if ($("#txtrepwd").val().length<6) {
		iRet=15;
		return opReturn(iRet);
	}
	if ($("#txtpwd").val()!=$("#txtrepwd").val()) {
		iRet=13;
		return opReturn(iRet);
	}
	iRet=00;
	return opReturn(iRet);
}

//返回错误码：
//默认：-1
//00：成功！
//11：新密码不能为空
//12：确认密码不能为空
//13：新密码和确认密码不相同
//14：新密码长度必须大于6
//15：确认密码长度必须大于6
var bRet=-1;
function opReturn(iRet)
{
	switch (iRet) {
	case 00:
		//alert("操作成功！");
		return true
	case 11:
		alert("新密码不能为空！");
		return false;
	case 12:
		alert("确认密码不能为空！");
		return false;
	case 13:
		alert("新密码和确认密码不相同！");
		return false;
	case 14:
		alert("长度必须大于6");
		return false;
	case 15:
		alert("长度必须大于6");
		return false;
	default:
		return false;
	}
}

function saveClick(){
	
	if (!checkData()) {
		return;
	}
	
	var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtrepwd').val()};
	$.commonFormSubmit({
	 type: "POST",
	 action: 'postData',
	 data: parms,
	 success: function(data){
	  	 return;
	 }
	});

}