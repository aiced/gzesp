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
	var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtrepwd').val()};
	$.commonFormSubmit({
	 type: "POST",
	 action: 'postData',
	 data: parms,
	 success: function(data){
	  	 return;
	 }
	});

}