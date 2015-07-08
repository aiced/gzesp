$(document).ready(function (){  

//	select 绑定

}); 
$(function(){
	initBind();
	
});
function initBind(){
	var next = document.getElementById("next");
	if(next){
		next.onclick = function() {
		    return nextClick();
		};
	}
	
//  日历
    var currYear = (new Date()).getFullYear();	
	var opt={};
	opt.date = {preset : 'date'};
	opt.datetime = {preset : 'datetime'};
	opt.time = {preset : 'time'};
	opt.default = {
		theme: 'android-ics light', //皮肤样式
        display: 'modal', //显示方式 
        mode: 'scroller', //日期选择模式
		dateFormat: 'yyyy-mm',
		lang: 'zh',
		showNow: true,
		nowText: "今天",
		dateOrder: 'yymm',
        startYear: currYear - 10, //开始年份
        endYear: currYear + 10 //结束年份
	};

  	$("#date_select").mobiscroll($.extend(opt['date'], opt['default']));    
    
	
/*	var validation = document.getElementById("validation");
	if(validation){
		validation.onclick = function() {
		    return validationClick(this);
		};
	}*/
	var save = document.getElementById("save");
	if(save){
		save.onclick = function() {
		    return saveClick(this);
		};
		
	}
	
	


	
	$("#band_select").change(function(){
		
	});
	
	
	$("#cardType_select").change(function(){
		var index = $("#cardType_select").get(0).selectedIndex; // 选中索引		
		$("#CVN2_li").hide();
		$("#validity_li").hide();
		if(index == 2){
			$("#CVN2_li").show();
			$("#validity_li").show();
		}
		
	});
	
	$("#validity_select").change(function(){
		var index = $("#validity_select").selectedIndex; // 选中索引
		if(index == 0){
			return;
		}
		var text = $("#validity_select").options[index].text; // 选中文本
	});
	
}



function saveClick(){
	alert("点击确定");

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


function doBlur(param)
{
	var iRet=-1;
	var id=$(param).attr("id");
	if (id == "txtusername") {
		if(!$("#txtusername").val()){
			iRet=11;
			return opReturn(iRet);
		}
	}
	else if(id=="txtpersonalid")
	{
		if(!$("#txtpersonalid").val()){
			iRet=21;
			return opReturn(iRet);
		}
		if(!checkEnergyCard($("#txtpersonalid").val()))
		{

			iRet=22;
	  		return opReturn(iRet);
		}
	}
	else if(id=="txtcord")
	{
		if(!$("#txtcord").val())
		{
			iRet=31;
	  		return opReturn(iRet);
		}
		var reg = /^\d*$/;
		if(!reg.test($("#txtcord").val()))
		{
			iRet=32;
	  		return opReturn(iRet);
		}
	}
	else if(id=="txtcardno")
	{
		if(!$("#txtcardno").val()){
			iRet=41;
			return opReturn(iRet);
		}
		
		if (!luhmCheck($("#txtcardno").val())) {
			iRet=42;
			return opReturn(iRet);
		}
	}
	else if(id=="txtphone")
	{
	  	if(!$("#txtphone").val())
	  	{
			iRet=51;
			return opReturn(iRet);
	  	}
		if(!isPhoneNum($("#txtphone").val()))
		{
			iRet=52;
			return opReturn(iRet);
		}
		if (checkPhoneNum_New($("#txtPhone").val())){
			iRet=53;
			return opReturn(iRet);
		}
	}	
	else if(id=="txtverify")
	{
		if(!$("#txtverify").val())
		{
			iRet=61;
			return opReturn(iRet);
		}
		if($("#txtverify").val()!=code)
		{
			iRet=62;
			return opReturn(iRet);
		}
		if(getNowDate() - $("#hide_code_date").val()>1800)
		{
			iRet=63;
			return opReturn(iRet);
		}	
	}	
	

	iRet=00;
	return opReturn(iRet);
}



function doFocus(param)
{
	$(param).val("");
}


function checkCode()
{
	$("#hide_code_date").val(getNowDate());
	 
	if (!$("#txtphone").val()) {
		iRet=61;
		return opReturn(iRet);
	}
	if (!isPhoneNum($("#txtphone").val())) {
		iRet=62;
		return opReturn(iRet);
	}
	if (checkPhoneNum_New($("#txtphone").val())){
		iRet=63;
		return opReturn(iRet);
	}

	iRet=00;
	return opReturn(iRet);	
}
function getCode()
{
	if(!checkCode())
	{
		return;
	}
  	var bRet=sendMessage($("#txtphone").val(),"#validation","7");
  	if(bRet)
  	{
  		$("#txtverify").attr("disabled",false); 
  	}
  	return;
}
function checkData()
{
	var iRet=-1;
	if(!$("#txtusername").val()){
		iRet=11;
		return opReturn(iRet);
	}
	if(!$("#txtpersonalid").val()){
		iRet=21;
		return opReturn(iRet);
	}
	if(!checkEnergyCard($("#txtpersonalid").val()))
	{

		iRet=22;
  		return opReturn(iRet);
	}
	if($("#band_select").val()=="请选择开户银行")
	{
		iRet=13;
  		return opReturn(iRet);
	}
	if($("#cardType_select").val()=="--选择卡类型--")
	{
		iRet=14;
  		return opReturn(iRet);
	}
	if ($("#cardType_select").val()=="借记卡") {
		
	}
	else if($("#cardType_select").val()=="信用卡")
	{
		if(!$("#date_select").val())
		{
			iRet=15;
	  		return opReturn(iRet);
		}
		if(!$("#txtcord").val())
		{
			iRet=31;
	  		return opReturn(iRet);
		}
		var reg = /^\d*$/;
		if(!reg.test($("#txtcord").val()))
		{
			iRet=32;
	  		return opReturn(iRet);
		}
	}
	if(!$("#txtcardno").val()){
		iRet=41;
		return opReturn(iRet);
	}
	
	if (!luhmCheck($("#txtcardno").val())) {
		iRet=42;
		return opReturn(iRet);
	}
  	if(!$("#txtphone").val())
  	{
		iRet=51;
		return opReturn(iRet);
  	}
	if(!isPhoneNum($("#txtphone").val()))
	{
		iRet=52;
		return opReturn(iRet);
	}
	if (checkPhoneNum_New($("#txtPhone").val())){
		iRet=53;
		return opReturn(iRet);
	}
	
	if(!$("#txtverify").val())
	{
		iRet=61;
		return opReturn(iRet);
	}
	if($("#txtverify").val()!=code)
	{
		iRet=62;
		return opReturn(iRet);
	}
	if(getNowDate() - $("#hide_code_date").val()>1800)
	{
		iRet=63;
		return opReturn(iRet);
	}	
	if($("#chkRight").attr("checked")=="true")
	{
		iRet=71;
		return opReturn(iRet);
	}	
	iRet=00;
	return opReturn(iRet);
}


//返回错误码：
//默认：-1
//00：成功！
//11：持卡人不能为空
//21：身份证不能为空
//22：身份证格式不正确
//13：请选择开户银行
//14：请选择卡类型
//15：请选择信用卡有效期
//31：请输入信用卡背面后三位
//32：信用卡后三位必须为数字
//41：请输入卡号
//42：卡号格式不正确
//51：请输入银行预留手机号
//52：手机号格式不正确
//53：请输入注册时的手机号
//61:请输入验证码
//62:验证码不正确
//63:验证码超时
//71:请勾选同意用户协议

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
	case 21:
		alert("身份证不能为空!");
		return false;	
	case 22:
		return false;
	case 13:
		alert("请选择开户银行");
		return false;
	case 14:
		alert("请选择卡类型");
		return false;
	case 15:
		alert("请选择信用卡有效期");
		return false;
	case 31:
		alert("请输入信用卡背面后三位");
		return false;
	case 32:
		alert("信用卡后三位必须为数字");
		return false;
	case 41:
		alert("请输入卡号");
		return false;
	case 42:
		alert("卡号格式不正确");
		return false;
	case 51:
		alert("请输入银行预留手机号");
		return false;
	case 52:
		alert("手机号格式不正确");
		return false;
	case 53:
		alert("请输入您之前注册时的手机号码");
		return false;		
	case 61:
		alert("请输入验证码");
		return false;
	case 62:
		alert("验证码不正确");
		return false;
	case 63:
		alert("验证码超时");
		return false;
	case 71:
		alert("请勾选同意用户协议");
		return false;
	default:
		return false;
	}
}


function nextClick(){
	
	if (!checkData()) {
		return;
	}
	
	var parms = {
			'user_id':$('#hide_user_id').val(),
			'bank_no':$('#txtcardno').val(),
			'cvn2':$('#txtcord').val(),
			'phone':$('#txtphone').val(),
			'name':$('#txtusername').val(),
			'certificate_code':$('#txtpersonalid').val(),
			'expire_date':$('#date_select').val(),
			'valid_flag':"0",
			'priority':"1",
			'card_type':$('#cardType_select').val(),
			'bank_type':$('#band_select').val()
	};
	
	$.ajax({
	 type: "POST",
	 url: 'postData',
	 data: parms,
	 success: function(data){
		 if (data=="ok") {
			window.location.href='/esp/shopManage/acct/myBankCardList/'+$("#hide_user_id").val();
		}else {
			alert(data);
		}
		 
	  	 return;
	 }
	});
}


