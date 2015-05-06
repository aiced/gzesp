
$(document).ready(function (){  
	//滚动加载
	$(window).scroll(function () {
		//如果是banner图片跳转到商品选择页面的，则不让ajax下拉刷新加载，会报错
		if ($('#isBanner').val() == "0") {
			var scrollTop = $(this).scrollTop();
			var scrollHeight = $(document).height();
			var windowHeight = $(this).height();
			if (scrollTop + windowHeight == scrollHeight) {
				// 此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
				// alert($('#datagrid').attr('pageNum'));
				var keyword = $('#keyword').val();
				var good_type = $('#good_type').val();
				var pageNum = parseInt($('#datagrid').attr('pageNum')) + 1; // 下拉表示要加载下一页

				queryFilterPublicAppend(good_type, pageNum, 10, keyword); // 每次加载10条
				$('#datagrid').attr('pageNum', pageNum); // 加载成功后页数+1
			}
        }
    }); 
});   



// 地市筛选触发事件
function cityFilter()
{
	//alert($(event.srcElement).attr('city_code'));
	//将下拉选项的文字赋值给按钮
	//$('#btnCity span').before($(event.srcElement).html());
	$('#btnCity').html($(event.srcElement).html() + '<span class="caret"></span>');
	//ajax刷新筛选结果
}

//查询 合约购机选择列表
function queryPhoneList(){
	var keyword = $('#keyword').val();
	if(keyword == '' || keyword == null)
	{
		return false;
	}	
	var good_type = $('#good_type').val();	
	var pageNum = 1; //搜索查询默认查第一页
	queryFilterPublic(good_type, pageNum, 10, keyword); //每次加载10条
}

//排序 合约购机列表 排序列的名字和按钮id一样，和数据库字段名一样
function sortPhoneList(sortCol){
	//alert(sortCol);
	var good_type = $('#good_type').val();	
	sortListPublic(good_type, sortCol);
}

//ajax查询刷新 
//公共入口方法 套餐选择 合约购机选择 上网卡选择 宽带选择 流量包选择 共用
function queryFilterPublic(goodType, pageNum, pageSize, keyword, sort, sortCol)
{
	var param = {"keyword":keyword, "goodType":goodType, "pageNum":pageNum, "pageSize":pageSize, "sort":sort, "sortCol":sortCol};
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/weShop/queryGoodListAjax",
		   //dataType:"json", //预期服务器返回的数据类型
		   data: JSON.stringify(param), //服务器只能接收json字符串
		   success: function(data){
			   //alert(data);
		     $('#datagrid').html(data);
			 //$('#datagrid').append(data);
		   }
		});
}

//下拉滚动条时 加载内容，而不是刷新列表区，除了回调函数外，其他参数都和 queryFilterPublic 一致
function queryFilterPublicAppend(goodType, pageNum, pageSize, keyword, sort, sortCol)
{
	var param = {"keyword":keyword, "goodType":goodType, "pageNum":pageNum, "pageSize":pageSize, "sort":sort, "sortCol":sortCol};
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/weShop/queryGoodListAjax",
		   //dataType:"json", //预期服务器返回的数据类型
		   data: JSON.stringify(param), //服务器只能接收json字符串
		   success: function(data){
			   //alert(data);
		     //$('#datagrid').html(data);
			 $('#datagrid').append(data);
		   }
		});
}

//点击 商品列表里某一个商品，跳转到商品详情页
function gotoGoodDetail(ctlg_code, goods_id){
	var href = $('#baseRoot').val() + "/weShop/goodDetail/"+ $('#user_id').val() +"/"+ ctlg_code + "/" + goods_id;
	//alert(href);
	window.location.href = href;            
}

//排序功能 sortCol是和数据库里的表字段名字一样的
function sortListPublic(goodType, sortCol){
	var pageSize = $('#datagrid .row').length; //当前已经展示了多少商品数目
	var btn = $('#' +sortCol);
	btn.attr('clicktimes', parseInt(btn.attr('clicktimes'))+1); //点击计数器+1
	var clicktimes = parseInt(btn.attr('clicktimes')); //排序按钮点击的次数，约定奇数表示升序，偶数表示降序,默认0降序
	var keyword = $('#keyword').val();
	var sort = ( clicktimes%2 == 0 ? "desc" : "asc" );
	var pageNum = 1; 
	queryFilterPublic(goodType, pageNum, pageSize, keyword, sort, sortCol);
}