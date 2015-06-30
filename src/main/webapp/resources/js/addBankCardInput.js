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

  	$("#search_select").mobiscroll($.extend(opt['date'], opt['default']));    
    
	
	var validation = document.getElementById("validation");
	if(validation){
		validation.onclick = function() {
		    return validationClick(this);
		};
	}
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
		alert("1111");
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


function checkData()
{
	var iRet=-1;
	if(!$("#txtusername").val()){
		iRet=11;
		return opReturn(iRet);
	}
	if(!$("#txtpersonalid").val()){
		iRet=12;
		return opReturn(iRet);
	}

/*	if(!$("#txtpersonalid").val()){
		iRet=13;
		return opReturn(iRet);
	}*/
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
//61:请输入验证码
//62:验证码不正确
//63:验证码超时

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
		alert("身份证格式不正确!");
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
	case 61:
		alert("请输入验证码");
		return false;
	case 62:
		alert("验证码不正确");
		return false;
	case 63:
		alert("验证码超时");
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
			'valid_flag':"0",
			'priority':"1",
			'card_type':"02",
			'bank_type':"9",
			
	};
	
	$.commonFormSubmit({
	 type: "POST",
	 action: 'postData',
	 data: parms,
	 success: function(data){
	  	 return;
	 }
	});
}


