$(function(){
	initBind();
	
});
function initBind(){
	var row = document.getElementById("row");
	row.onclick = function() {
	    return rowClick(this);
	};
}

function leftClick(param)
{
	window.location.href='/esp/shopManage/acct/myAcct/'+$("#hide_user_id").val();
}

function rowClick(){
	var subTitle = document.getElementById("subTitle");
	var user_id=document.getElementById("hide_user_id");
	
	if(subTitle.innerHTML == "设置"){
		window.location.href="../payPasswordSet/"+user_id.value;

	}else if(subTitle.innerHTML == "重置" ){
		window.location.href="../payPasswordResetVerify/"+user_id.value;
	}
}
