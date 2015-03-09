
//地市筛选触发事件
function cityFilter()
{
	//alert($(event.srcElement).attr('city_code'));
	//将下拉选项的文字赋值给按钮
	//$('#btnCity span').before($(event.srcElement).html());
	$('#btnCity').html($(event.srcElement).html() + '<span class="caret"></span>');
	//ajax刷新筛选结果
}

//输入尾号点击搜索执行ajax查询刷新
function queryFilter()
{
	var weihao = $('#weihao').val();
	if(weihao == '' || weihao == null)
	{
		return false;
	}
	
	var param = {"weihao":weihao};
	
	$.ajax({
		   type: "POST",
		   url: "queryNumbersByAjax",
		   data: param,
		   success: function(data){
			   //alert(data);
		     $('#datagrid').html(data);
		   }
		});
}