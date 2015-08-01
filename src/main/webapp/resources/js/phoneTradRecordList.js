/**
 * Created by xinjunwang on 15-6-18.
 */
var pageSize = 10;

$(document).ready(function (){  
//	//滚动加载
	$(window).scroll(function () {
		var scrollTop = $(this).scrollTop();
		var scrollHeight = $(document).height();
		var windowHeight = $(this).height();
		var height = scrollTop + windowHeight;
		 
		if (scrollTop + windowHeight == scrollHeight) {
				//页码请求算法,得到所有的li的个数。
				var pageNum =null;
				var rowNum = $("li");
				if(rowNum.length%pageSize ==0 ){
					 pageNum = rowNum.length/pageSize;
					 loadMoreData(pageNum);					
				}				
		}
    }); 
}); 

$(function(){
    initBind();
});

function initBind(){
    $("ul").delegate("li", "click", function(){
    	window.location.href=$('#baseRoot').val() + '/topUp/phoneTradRecordDetail/' +  $(this).attr('orderId');   
    });
    
    $("#top_left").bind("click",function(){
    	
	  	if(localStorage)
		 {
	  		var phoneTradRecordListBackPath=  localStorage.getItem("phoneTradRecordListBackPath");
	    	window.location.href=$('#baseRoot').val() + phoneTradRecordListBackPath;   
		 }
    });
}

function loadMoreData(pageNum)
{	
	var phoneNumber = $("#phoneNumber").val();	
	var param = {"pageNum":pageNum,"phoneNumber":phoneNumber};	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/topUp/phoneTradRecordListSub",
		   data: param, //服务器只能接收json字符串
		   async: false,
		   success: function(data){
		     $('#datagrid').append(data);
		   }
		});
}
