$(function(){
	initBind();
	
});
function initBind(){
	var row = document.getElementById("row");
	row.onclick = function() {
	    return rowClick(this);
	};
}

function rowClick(){
	var subTitle = document.getElementById("subTitle");
	var user_id=document.getElementById("hide_user_id");
	
	if(subTitle.innerHTML == "设置"){
<<<<<<< HEAD
		window.location.href="../payPasswordSet/"+user_id.value;
=======
		alert('点击了设置');
//    	window.location.href='../acctSecurity/'+$("#hide_user_id").val();
    	window.location.href='../acctSecurity/'+'2';


	}else if(subTitle.innerHTML == "重置" ){
		alert('点击了重置');
>>>>>>> branch 'master' of https://github.com/aiced/gzesp.git

	}else if(subTitle.innerHTML == "重置" ){
		window.location.href="../payPasswordResetVerify/"+user_id.value;
	}
}
