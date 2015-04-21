
$(document).ready(function (){  
	//滚动加载
	$(window).scroll(function () {
        var scrollTop = $(this).scrollTop();
        var scrollHeight = $(document).height();
        var windowHeight = $(this).height();
        if (scrollTop + windowHeight == scrollHeight) {
        //此处是滚动条到底部时候触发的事件，在这里写要加载的数据，或者是拉动滚动条的操作
        //alert($('#datagrid').attr('pageNum'));
        var eparchy_code= $('#btnCity').attr('eparchy_code');	
        var keyword = $('#keyword').val();	
        var pageNum = parseInt($('#datagrid').attr('pageNum'))+1; //下拉表示要加载下一页
    	var pageSize = 20; //默认每次获取20个
    	var nice_fee_start = 0;
    	var nice_fee_end = 10000; //靓号预存费范围 0-10000	
    	var net_type = $('#net_type').html(); //网络类型
    	queryNumbersPublicAppend(eparchy_code, null, nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, null, null, net_type);	 //每次加载20条
        $('#datagrid').attr('pageNum', pageNum); //加载成功后页数+1
        }
    }); 
});

//地市筛选触发事件
function eparchyFilter()
{
	//alert($(event.srcElement).attr('city_code'));
	//将下拉选项的文字赋值给按钮
	//$('#btnCity span').before($(event.srcElement).html());
	$('#btnCity').html($(event.srcElement).html() + '<span class="caret"></span>');
	$('#btnCity').attr('eparchy_code', $(event.srcElement).attr('city_code'));
	//ajax刷新筛选结果	
	var keyword = $('#keyword').val();
	var eparchy_code= $('#btnCity').attr('eparchy_code');
	var pageNum = 1; //搜索查询默认查第一页
	var pageSize = 20; //默认每次筛选先获取20个
	var nice_fee_start = 0;
	var nice_fee_end = 10000; //靓号预存费范围 0-10000	
	var net_type = $('#net_type').html(); //网络类型
	queryNumbersPublic(eparchy_code, null, nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, null, null, net_type);
}

//靓号规则触发筛选
function ruleFilter(){
	//ajax刷新筛选结果	
	var nice_rule = $(event.srcElement).html();
	var keyword = $('#keyword').val();
	var eparchy_code= $('#btnCity').attr('eparchy_code');
	var pageNum = 1; //搜索查询默认查第一页
	var pageSize = 20;
	var nice_fee_start = 0;
	var nice_fee_end = 10000; //靓号预存费范围 0-10000	
	var net_type = $('#net_type').html(); //网络类型
	queryNumbersPublic(eparchy_code, nice_rule, nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, null, null, net_type);	
}

//预存费用 触发筛选
function feeFilter(){
	//ajax刷新筛选结果	
	//var nice_rule = $(event.srcElement).html();
	var nice_fee = $(event.srcElement).attr('nice_fee').split("-");
	var keyword = $('#keyword').val();
	var eparchy_code= $('#btnCity').attr('eparchy_code');
	var pageNum = 1; //搜索查询默认查第一页
	var pageSize = 20;
	var net_type = $('#net_type').html(); //网络类型
	queryNumbersPublic(eparchy_code, null, nice_fee[0], nice_fee[1], pageNum, pageSize, keyword, null, null, net_type);		
}

//查询 号码选择列表
function queryNumberList(){
	var keyword = $('#keyword').val();
	if(keyword == '' || keyword == null)
	{
		return false;
	}	
	var eparchy_code= $('#btnCity').attr('eparchy_code');
	var pageNum = 1; //搜索查询默认查第一页
	var pageSize = 20;
	var nice_fee_start = 0;
	var nice_fee_end = 10000; //靓号预存费范围 0-10000		
	var net_type = $('#net_type').html(); //网络类型
	queryNumbersPublic(eparchy_code, null, nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, null, null, net_type); //默认预存0-10000
}

//排序 合约购机列表 排序列的名字和按钮id一样，和数据库字段名一样
function sortNumberList(sortCol){
	//alert(sortCol);
	sortNumberListPublic(sortCol);
}

//排序功能 sortCol是和数据库里的表字段名字一样的
function sortNumberListPublic(sortCol){
	var eparchy_code= $('#btnCity').attr('eparchy_code');
	var pageSize = $('#datagrid .row .p-td-number').length; //当前已经展示了多少商品数目
	var btn = $('#' +sortCol);
	btn.attr('clicktimes', parseInt(btn.attr('clicktimes'))+1); //点击计数器+1
	var clicktimes = parseInt(btn.attr('clicktimes')); //排序按钮点击的次数，约定奇数表示升序，偶数表示降序,默认0降序
	var keyword = $('#keyword').val();
	var sort = ( clicktimes%2 == 0 ? "desc" : "asc" );
	var pageNum = 1; 
	var nice_fee_start = 0;
	var nice_fee_end = 10000; //靓号预存费范围 0-10000	
	var net_type = $('#net_type').html(); //网络类型
	queryNumbersPublic(eparchy_code, null, nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, sort, sortCol, net_type);
}

//ajax查询刷新 公共入口方法
//筛选 排序 关键字查询搜索 都是调用这个函数
function queryNumbersPublic(eparchy_code, nice_rule, nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, sort, sortCol, netType)
{
	var param = {"eparchy_code":eparchy_code, "nice_rule":nice_rule, "nice_fee_start":nice_fee_start, 
			     "nice_fee_end":nice_fee_end, "pageNum":pageNum, "pageSize":pageSize, 
			     "keyword":keyword, "sort":sort, "sortCol":sortCol, "netType":netType
			     };
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/order/queryNumbersByAjax",
		   //dataType:"json", //预期服务器返回的数据类型
		   data: JSON.stringify(param), //服务器只能接收json字符串
		   success: function(data){
			   //alert(data);
		     $('#datagrid').html(data);
		   }
		});
}

//下拉滚动条时 加载内容，而不是刷新列表区，除了回调函数外，其他参数都和 queryNumbersPublic 一致
function queryNumbersPublicAppend(eparchy_code, nice_rule, nice_fee_start, nice_fee_end, pageNum, pageSize, keyword, sort, sortCol, netType)
{
	var param = {"eparchy_code":eparchy_code, "nice_rule":nice_rule, "nice_fee_start":nice_fee_start, 
			     "nice_fee_end":nice_fee_end, "pageNum":pageNum, "pageSize":pageSize, 
			     "keyword":keyword, "sort":sort, "sortCol":sortCol, "netType":netType
			     };
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/order/queryNumbersByAjax",
		   //dataType:"json", //预期服务器返回的数据类型
		   data: JSON.stringify(param), //服务器只能接收json字符串
		   success: function(data){
			   //alert(data);
			   $('#datagrid').append(data);
		   }
		});
}

//点击 某个号码，选中 可以根据大家的页面自定义修改
function clickOneNumber(obj){
   var serial_number = $(obj).html().replace(/[ ]/g,""); //获取点击选中的号码并去除空格
   var nice_fee = $(obj).next('p').attr('nice_fee');
   //alert(serial_number);	
   //$('#serial_number').html(serial_number); //赋值给父页面里的某个 标签属性
   
   updateNumberState(serial_number, nice_fee); //预占号码
   //back2Main(); //子页面隐藏，主页面展示
}

//预占号码 变更号码状态
function updateNumberState(serial_number, nice_fee){
	if(serial_number == null || serial_number==''){
		return false;
	}
	var param = {"serial_number":serial_number, "nice_fee":nice_fee}; //号码和 靓号预存款，最后订单价格要加上预存
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/order/updateNumberState",
		   dataType:"json", //预期服务器返回的数据类型
		   data: JSON.stringify(param), //服务器只能接收json字符串
		   success: function(data){
			   //alert(data);
			   //$('#datagrid').append(data);
			   if(data.status == 'SUCCESS'){
					$('#alert_div').hide();
				}
				else{
					$('#alert_div').show();
				}
			   afterUpdateNumber(data); //回调函数，函数名字参数固定，内容可以自定义，此函数可以写在自己的js文件里
		   }
		});	
}


