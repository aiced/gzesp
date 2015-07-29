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
					 pageNum = rowNum.length/pageSize +1;
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
        alert( $(this).index());
    	window.location.href='/esp/set/phoneTradRecordDetail';       
    });
}

function loadMoreData(pageNum)
{	
	var user_id = $("#user_id").val();
	var param = {"pageNum":pageNum,"pageSize":pageSize,"user_id":user_id};	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/shopManage/acct/acctBalancePagePostData",
		   data: param, //服务器只能接收json字符串
		   async: false,
		   success: function(data){
		     $('#datagrid').append(data);
		   }
		});
}


function leftClick(param)
{
//	点击返回
//	window.location.href='/esp/shopManage/acct/myAcct/'+$("#user_id").val();
}