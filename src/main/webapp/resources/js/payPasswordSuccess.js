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
	alert("点击保存");
}