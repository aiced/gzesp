
//这个地方那个需要将数据传递到bandGoodDetail.ftl
//这个地方仅仅是一个数据的传递
function doClick(param)
{	
	alert(param);
	var parms = {'user_id':$('#hide_user_id').val()};
	$.commonFormSubmit({
	 type: "POST",
	 action: '/esp/weShop/bandAcctPostData',
	 data: parms,
	 success: function(data){
	  	 return;
	 }
	});
}