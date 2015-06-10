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
	if(subTitle.innerHTML == "设置"){
		alert('点击了设置');
	}else if(subTitle.innerHTML == "重置" ){
		alert('点击了重置');

	}
}