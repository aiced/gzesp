$(function(){
	initBind();
	
});
function initBind(){
	var validation = document.getElementById("validation");
	var save = document.getElementById("save");

	
	save.onclick = function() {
	    return saveClick(this);
	};
}

function saveClick(){
	alert("点击确定");

}