/**
 * Created by xinjunwang on 15-6-18.
 */

$(function(){
    initBind();

});

function initBind(){
	
	if($("#status").html() == "未支付"){
		$("#checkDetailId").hide();
		$("#cardInfo").hide();
				
	}else if($("#status").html() == "支付成功"){
		$("#payDivId").hide();
	}
    
    $("#payDivId").bind("click",function(){
    	  alert("payDivId"); 
    });
    
    $("#checkDetailId").bind("click",function(){
    	  alert("checkDetailId"); 
    });
}


function leftClick(param)
{
//	点击返回
//	window.location.href='/esp/shopManage/acct/myAcct/'+$("#user_id").val();
}