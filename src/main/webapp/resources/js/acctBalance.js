//$(document).ready(function (){  
////	//滚动加载
//	
//});  

$(function(){
	initBind();
	
});
function initBind(){
	var income_a = document.getElementById("income_a");
	var spending_a = document.getElementById("spending_a");
	var withdrawal_a  = document.getElementById("withdrawal_a");
	income_a.onclick = function() {
	    return topBarClick(this);
	};
	spending_a.onclick = function() {
	    return topBarClick(this);
	};
	withdrawal_a.onclick = function() {
	    return topBarClick(this);
	};	
	var search_a = document.getElementById("search_a");
	search_a.onclick = function() {
	    return searchClick(this);
	};	
	
}

function topBarClick(obj){
	queryList();
	resetHeader(obj);	
	//查询业务
	resetListStyle();
}
function searchClick(obj){
	var search_select = document.getElementById("search_select"); //定位id
	var index = search_select.selectedIndex; // 选中索引
	if(index == 0){
		return;
	}
	var text = search_select.options[index].text; // 选中文本
	alert(text);
	//查询业务
	resetListStyle();
}


function resetHeader(obj) {
	var income_a = document.getElementById("income_a");
	var spending_a = document.getElementById("spending_a");
	var withdrawal_a  = document.getElementById("withdrawal_a");
	income_a.setAttribute("class", "topbar_a_nomal topbar_a rel"); 
	spending_a.setAttribute("class", "topbar_a_nomal topbar_a rel"); 
	withdrawal_a.setAttribute("class", "topbar_a_nomal topbar_a rel"); 
	obj.setAttribute("class", "topbar_a_selected topbar_a rel"); 
}

//ajax查询刷新 公共入口方法
//筛选 排序 关键字查询搜索 都是调用这个函数
function queryList()
{
	var param = {"eparchy_code":"eparchy_code", "nice_rule":"nice_rule"};
	
	alert($('#baseRoot').val() + "/test/acct/acctBalance/21");
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/test/acct/acctBalance/2",
		   data: param, //服务器只能接收json字符串
		   success: function(data){
			   alert(data);
//		     $('#datagrid').html(data);
		   }
		});
}



function resetListStyle() {
//	得到两个 元素数组。
	var nums =document.getElementsByName("row_right_num");
	var audits =document.getElementsByName("row_right_audit");	
	var withdrawal_a  = document.getElementById("withdrawal_a");

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










