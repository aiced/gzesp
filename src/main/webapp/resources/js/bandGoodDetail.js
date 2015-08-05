function doClick()
{	
	var parms = {'user_id':$('#hide_user_id').val()};
	$.commonFormSubmit({
	 type: "POST",
	 action: '/esp/weShop/bandGoodPostData',
	 data: parms,
	 success: function(data){
	  	 return;
	 }
	});
}