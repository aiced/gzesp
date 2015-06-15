$(function(){
	initBind();
	
});
function initBind(){
	var save = document.getElementById("save");
	save.onclick = function() {
	    return saveClick(this);
	};
}

function saveClick(){
	window.location.href='/esp/shopManage/acct/myAcct/'+	$("#hide_user_id").val();
}