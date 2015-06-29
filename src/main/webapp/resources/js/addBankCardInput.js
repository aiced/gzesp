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
		alert("1111");
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

function nextClick(){
	alert("点击下一步");

	
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


