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

function saveClick(){
	alert("点击下一步");
	window.location.href='/esp/shopManage/acct/payPasswordReset/'+$("#hide_user_id").val();
}