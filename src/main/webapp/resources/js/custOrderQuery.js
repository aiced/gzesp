$(function(){
    initBind();
});

function initBind(){
//  普通订单
    $("#regularOrderId").bind('click',function(){
    	//topBar样式改变
    	$("#regularOrderId").attr("class","regularOrderSelected");
    	$("#topUpOrderId").attr("class","topUpOrderUnselected");
    	//显示身份证
    	$("#inputPassportDiv").show();
    });
	
//  一卡充订单
    $("#topUpOrderId").bind('click',function(){
    	$("#topUpOrderId").attr("class","regularOrderSelected");
    	$("#regularOrderId").attr("class","regularOrderUnselected");
    	//隐藏身份证
    	$("#inputPassportDiv").hide();    	
    });
}
