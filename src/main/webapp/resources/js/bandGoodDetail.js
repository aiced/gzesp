function doClick()
{	
	//这里直接调用徐总的落订单的接口,下面的请求连接修改成徐总提供的连接
	var parms = {
			'USER_ID':$('#hide_user_id').val(),
			'PRODUCT_ID':$('#hide_productcode').val(),
			'TOPAY_MONEY':$('#hide_realfee').val(),
			'ORIGINAL_PRICE':$('#hide_origfee').val(),
			'GOODS_ID':$('#hide_goodsid').val(),
			'ORDER_FROM':'01',
			'VALUES1':$('#hide_oldproductcode').val()
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