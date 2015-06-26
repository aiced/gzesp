$(function(){
	initBind();
	
});
function initBind(){
	var validation = document.getElementById("validation");
	var save = document.getElementById("next");

	validation.onclick = function() {
	    return validationClick(this);
	};
	
	save.onclick = function() {
	    return saveClick(this);
	};
}

function validationClick(){
//	var subTitle = document.getElementById("subTitle");
//	if(subTitle.innerHTML == "设置"){
//		alert('点击了设置');
//	}else if(subTitle.innerHTML == "重置" ){
//		alert('点击了重置');
//saveClicksaveClick
//	}
	alert("点击验证");
}

function isTextEmpty()
{
	if (!$("#txtPhone").val()) {
		
	}
}
//判断输入的是否是手机号
function isPhoneNum(strPhoneNum)
{
	if(strPhoneNum && /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|170)\d{8}$/.test(strPhoneNum)){
	    return true;//是手机号
	} else{
	    return false; //不是手机号
	}
}

function getNowDate()
{
  var d = new Date();
  var vYear = d.getFullYear();
  var vMon = d.getMonth() + 1;
  var vDay = d.getDate();
  var h = d.getHours(); 
  var m = d.getMinutes(); 
  var se = d.getSeconds(); 
  s=vYear+(vMon<10 ? "0" + vMon : vMon)+(vDay<10 ? "0"+ vDay : vDay)+(h<10 ? "0"+ h : h)+(m<10 ? "0" + m : m)+(se<10 ? "0" +se : se);
  return s;	
}

function checkCode()
{
	$("#hide_code_date").val(getNowDate());
	 
	if (!$("#txtPhone").val()) {
		iRet=11;
	}
	if (!isPhoneNum($("#txtPhone").val())) {
		iRet=12;
	}
	//校验绑定的预留手机号码
	if(!$("#txtCode").val())
	{
		iRet=21;
	}
	return opReturn(iRet);	
}
function getCode()
{
	if(!checkCode())
	{
		return;
	}
  	//这里开始做验证码操作 0是注册模板 1是支付模板
  	var bRet=sendMessage($("#txtphonenum").val(),"#btnCode","0");
  	if(bRet)
  	{
  		$("#txtCode").attr("disabled",false); 
  	}
  	return;
}
function checkData()
{
	var iRet=-1;
	if (!$("#txtPhone").val()) {
		iRet=11;
	}
	if (!isPhoneNum($("#txtPhone").val())) {
		iRet=12;
	}
	//校验绑定的预留手机号码
	if(!$("#txtCode").val())
	{
		iRet=21;
	}
	if($("#txtCode").val()!=code)
	{
		iRet=22;
	}
	if(getNowDate() - $("#hide_code_date").val()>1800)
	{
		iRet=23;
	}
	
	iRet=00;
	
	return opReturn(iRet);
}


//返回错误码：
//默认：-1
//00：成功！
//11：手机号不能为空
//12：手机号格式不正确
//13：请填写绑定时的预留手机号码
//21：验证码不能为空
//22：验证码不正确
//23：验证码超时
var bRet=-1;
function opReturn(iRet)
{
	switch (iRet) {
	case 00:
		alert("操作成功！");
		return true
	case 11:
		alert("手机号不能为空！");
		return false;
	case 12:
		alert("手机号格式不正确");
		return false;
	case 13:
		alert("与绑定时预留的手机号不匹配");
		return false;
	case 21:
		alert("验证码不能为空！");
		return false;
	case 22:
		alert("验证码错误！");
		return false;
	case 23:
		alert("验证码超时！");
		return false;
	default:
		return false;
	}
}





function saveClick(){
	
	if (!checkData()) {
		return;
	}
	window.location.href='/esp/shopManage/acct/payPasswordReset/'+$("#hide_user_id").val();
}