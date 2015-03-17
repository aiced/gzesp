
//地市筛选触发事件
function cityFilter()
{
	//alert($(event.srcElement).attr('city_code'));
	//将下拉选项的文字赋值给按钮
	//$('#btnCity span').before($(event.srcElement).html());
	$('#btnCity').html($(event.srcElement).html() + '<span class="caret"></span>');
	//ajax刷新筛选结果
}

//查询合约购机选择列表
function queryPhoneList(){
	queryFilterPublic("phone");
}

//输入关键字点击搜索执行ajax查询刷新 
//公共方法 套餐选择 合约购机选择 上网卡选择 宽带选择 流量包选择 共用
function queryFilterPublic(goodType)
{
	var keyword = $('#keyword').val();
	if(keyword == '' || keyword == null)
	{
		return false;
	}
	
	var param = {"keyword":keyword, "goodType":goodType};
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json",
		   url: $('#baseRoot').val() + "/weShop/queryGoodListAjax",
		   dataType:"json",
		   data: JSON.stringify(param),
		   success: function(data){
			   //alert(data);
		     $('#datagrid').html(data);
		   }
		});
}

//点击 商品列表里某一个商品，跳转到商品详情页
function gotoGoodDetail(ctlg_code, goods_id){
	var href = $('#baseRoot').val() + "/weShop/goodDetail/"+ $('#user_id').val() +"/"+ ctlg_code + "/" + goods_id;
	alert(href);
	window.location.href = href;            
}