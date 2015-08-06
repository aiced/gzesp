function doClick()
{	
	//这里直接调用徐总的落订单的接口,下面的请求连接修改成徐总提供的连接
	//bss接口返回的是钱的单位是分，徐总要求的单位为元所以除以100
	var parms = {
			'USER_ID':$('#hide_user_id').val(),
			'PRODUCT_ID':$('#hide_productcode').val(),
			'TOPAY_MONEY':$('#hide_realfee').val()/100,
			'ORIGINAL_PRICE':$('#hide_origfee').val()/100,
			'GOODS_ID':$('#hide_goodsid').val(),
			'ORDER_FROM':'01',
			'VALUES1':$('#hide_oldproductcode').val(),
			'BANDNUMID':$('#hide_num_id').val()
			};
	$.commonFormSubmit({
	 type: "POST",
	 action: '/esp/order/submitBand',
	 data: parms,
	 success: function(data){
	  	 return;
	 }
	});
}