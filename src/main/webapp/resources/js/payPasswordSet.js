$(function(){
	initBind();
	
});
function initBind(){
	var validation = document.getElementById("validation");
	var save = document.getElementById("save");

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

function saveClick(){
	var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtrepwd').val(),'update_time':$('#hide_update_time').val()};
	$.commonFormSubmit({
	 type: "POST",
	 action: 'postData',
	 data: parms,
	 success: function(data){
	  	 return;
	 }
	});
}