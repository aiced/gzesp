var pageSize = 10;

$(document).ready(function (){  
//	//滚动加载
	$(window).scroll(function () {
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		var height = scrollTop + windowHeight;
		 
		if (scrollTop + windowHeight == scrollHeight) {
				var type = getTypeIndex();
				var monthKey = null;
				if(getMonth() != null){
				    monthKey = getMonth(); // 选中文本;
				}
				//页码请求算法,得到所有的li的个数。
				var pageNum =null;
				var rowNum = $("li");
				if(rowNum.length%pageSize ==0 ){
					 pageNum = rowNum.length/pageSize +1;
					 loadMoreData(type,monthKey,pageNum);					
				}				
		}
    }); 
}); 

$(function(){
	initBind();	
});

function initBind(){
//	收入
    $("#income_a").bind('click',function(){
	    return topBarClick(this);
    });
//  支出
    $("#spending_a").bind('click',function(){
	    return topBarClick(this);
    });
//  体现
    $("#withdrawal_a").bind('click',function(){
	    return topBarClick(this);
    });
    
    
//   日历
    var currYear = (new Date()).getFullYear();	
	var opt={};
	opt.date = {preset : 'date'};
	opt.datetime = {preset : 'datetime'};
	opt.time = {preset : 'time'};
	opt.default = {
		theme: 'android-ics light', //皮肤样式
        display: 'modal', //显示方式 
        mode: 'scroller', //日期选择模式
		dateFormat: 'yyyy-mm',
		lang: 'zh',
		showNow: true,
		nowText: "今天",
		dateOrder: 'yymm',
        startYear: currYear - 10, //开始年份
        endYear: currYear + 10 //结束年份
	};

  	$("#search_select").mobiscroll($.extend(opt['date'], opt['default']));    
    
    
    
//  搜索  
    $("#search_a").bind("click",function(){
	    return searchClick(this);
    });
//	$("ul").delegate("li", "click", function(){
//		$(this).hide();
//		$(this).index();
//	});	
}

function topBarClick(obj){
//	得到点击索引；
	setTypeIndex(obj);	
	var type = getTypeIndex();
	//清空月份	
	setMonthNull();
	var monthKey = null;
	var pageNum = "1";
	queryList(type,monthKey,pageNum);
	//查询业务
}

function searchClick(obj){
	
	var monthKey = null;
	if(getMonth() != null){
	    monthKey = getMonth(); // 选中文本;
	}
	var type = getTypeIndex();
	var pageNum = "1";
	queryList(type,monthKey,pageNum);
	//查询业务
}




//ajax查询刷新 公共入口方法
//筛选 排序 关键字查询搜索 都是调用这个函数
function queryList(type,monthKey,pageNum)
{	
	
	var user_id = $("#user_id").val();
	var param = {"type":type, "monthKey":monthKey,"pageNum":pageNum,"pageSize":pageSize,"user_id":user_id};	
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/shopManage/acct/acctBalanceTotalPostData",
		   data: param, //服务器只能接收json字符串
		   async: false,
		   success: function(data){
//			  取数值
//		    alert(data);	
		    setSum(data);
		   }
		});
	
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/shopManage/acct/acctBalancePagePostData",
		   data: param, //服务器只能接收json字符串
		   async: false,
		   success: function(data){
//			   alert(data);
			 $('#datagrid').html(data);
		     	resetListStyle();
		   }
		});
	

		
}
//
function loadMoreData(type,monthKey,pageNum)
{	
	var user_id = $("#user_id").val();
	var param = {"type":type, "monthKey":monthKey,"pageNum":pageNum,"pageSize":pageSize,"user_id":user_id};	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/shopManage/acct/acctBalancePagePostData",
		   data: param, //服务器只能接收json字符串
		   async: false,
		   success: function(data){
		     $('#datagrid').append(data);
		 		resetListStyle();
		   }
		});
}




function resetListStyle() {
//	得到两个 元素数组。
	var nums =document.getElementsByName("row_right_num");
	var audits =document.getElementsByName("row_right_audit");	
	if(getTypeIndex() == 2 )
	{
		   for(var i=0;i<nums.length;i++){
		        num =nums[i];
		        num.setAttribute("class", "row_right_num_audit"); 
		    }
		    for(var i=0;i<audits.length;i++){
		    	audit =audits[i];
		    	audit.style.display= "block"; 
				var content=audit.innerHTML;
				if(content == "审核中"){
					audit.style.color = "#FF9900";
				}else if(content == "审核已通过"){
					audit.style.color = "#35DC25";
				}else if(content == "审核未通过"){
					audit.style.color = "#FF1A24";
				}else if(content == "已打款"){
					audit.style.color = "#4060ff";
				}				
		    }	    
	}else{
			for(var i=0;i<nums.length;i++){
				num =nums[i];
				num.setAttribute("class", "row_right_num_normal"); 
			}
			for(var i=0;i<audits.length;i++){
				audit =audits[i];
				audit.style.display= "none"; 
			}
		
	}
	
}
function setSum(sum) {
	var totle = null;
	if(getTypeIndex() == 0){
		totle = "总收入";
	}else if(getTypeIndex() == 1){
		totle = "总支出";
	}else if(getTypeIndex() == 2){
		totle = "累计提现";
	}
	if(getMonth()!=null){
		totle = "当月"+ totle;
	}	
	$('#sumTitle').text(totle);
	$('#sumNum').text(sum);
	if(sum == -1){
		$('#sumNum').text("0");
	}

}


function setMonthNull() {
	$("#search_select").val(null);
}

function getMonth() {
	if($("#search_select").val()){
		return $("#search_select").val()
	}
	return null;
}

function setTypeIndex(obj) {
	$('#income_a').attr("class","topbar_a_nomal topbar_a rel");
	$('#spending_a').attr("class","topbar_a_nomal topbar_a rel");
	$('#withdrawal_a').attr("class","topbar_a_nomal topbar_a rel");
	obj.setAttribute("class", "topbar_a_selected topbar_a rel"); 	
}


function getTypeIndex(){	
    if($('#income_a')[0].className == "topbar_a_selected topbar_a rel"){
    	return 0;
    }else if($('#spending_a')[0].className == "topbar_a_selected topbar_a rel"){
    	return 1;
    }else if($('#withdrawal_a')[0].className == "topbar_a_selected topbar_a rel"){
    	return 2;
    }
}


function leftClick(param)
{
	window.location.href='/esp/shopManage/acct/myAcct/'+$("#user_id").val();
}








