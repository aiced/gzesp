var pageSize = 9;

$(document).ready(function (){  
//	//滚动加载
	$(window).scroll(function () {
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		var height = scrollTop + windowHeight;
		 
		if (scrollTop + windowHeight == scrollHeight) {
				var type = getypeIndex();
				var monthKey = null;
				var index = search_select.selectedIndex; // 选中索引
				if(index != 0){
				    monthKey = search_select.options[index].text; // 选中文本;
				}
				//页码请求算法,得到所有的li的个数。
				var pageNum;
				var rowNum = $("li");
				if(rowNum.length%pageSize ==0 ){
					 pageNum = rowNum.length/pageSize +1;
					 queryList(type,monthKey,pageNum);					
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
	resetHeader(obj);	
	var type = getypeIndex();
	var monthKey = null;
	var pageNum = "1";
	queryList(type,monthKey,pageNum);
	//查询业务
}
function searchClick(obj){
	var search_select = document.getElementById("search_select"); //定位id
	var index = search_select.selectedIndex; // 选中索引
	if(index == 0){
		return;
	}
	var monthKey = search_select.options[index].text; // 选中文本;
	var type = getypeIndex();
	var pageNum = "1";
	queryList(type,monthKey,pageNum);
	//查询业务
}


function resetHeader(obj) {
//	var income_a = document.getElementById("income_a");
//	var spending_a = document.getElementById("spending_a");
//	var withdrawal_a  = document.getElementById("withdrawal_a");
//	income_a.setAttribute("class", "topbar_a_nomal topbar_a rel"); 
//	spending_a.setAttribute("class", "topbar_a_nomal topbar_a rel"); 
//	withdrawal_a.setAttribute("class", "topbar_a_nomal topbar_a rel"); 
	
	$('#income_a').attr("class","topbar_a_nomal topbar_a rel");
	$('#spending_a').attr("class","topbar_a_nomal topbar_a rel");
	$('#withdrawal_a').attr("class","topbar_a_nomal topbar_a rel");
	obj.setAttribute("class", "topbar_a_selected topbar_a rel"); 

		
}

//ajax查询刷新 公共入口方法
//筛选 排序 关键字查询搜索 都是调用这个函数
function queryList(type,monthKey,pageNum)
{	
	var param = {"type":type, "monthKey":monthKey,"pageNum":pageNum,"pageSize":pageSize};	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/test/acct/acctBalance/2",
		   data: param, //服务器只能接收json字符串
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
//	var withdrawal_a  = document.getElementById("withdrawal_a");
	var withdrawal_a = $("#withdrawal_a")[0];

	if(withdrawal_a.className == "topbar_a_selected topbar_a rel")
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

function getypeIndex(){	
    if($('#income_a')[0].className == "topbar_a_selected topbar_a rel"){
    	alert($('#income_a')[0].className);
    	return 0;
    }else if($('#spending_a')[0].className == "topbar_a_selected topbar_a rel"){
    	alert($('#spending_a')[0].className);
    	return 1;
    }else if($('#withdrawal_a')[0].className == "topbar_a_selected topbar_a rel"){
    	alert($('#withdrawal_a')[0].className);
    	return 2;
    }
}










