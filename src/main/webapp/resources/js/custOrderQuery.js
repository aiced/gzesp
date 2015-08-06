$(function(){
    initBind();
});

function initBind(){
//  普通订单
    $("#regularOrderId").bind('click',function(){
    	//topBar样式改变
    	$("#regularOrderId").attr("class","regularOrderSelected");
    	$("#topUpOrderId").attr("class","topUpOrderUnselected");
    	$("#renewalOrderId").attr("class","renewalUnselected");
    	//显示身份证
    	$("#inputPassportDiv").show();
    	$("#tapIndex").val(1);

    	
    });
	
//  一卡充订单
    $("#topUpOrderId").bind('click',function(){
    	$("#topUpOrderId").attr("class","topUpOrderSelected");
    	$("#regularOrderId").attr("class","regularOrderUnselected");
    	$("#renewalOrderId").attr("class","renewalUnselected");
    	//隐藏身份证
    	$("#inputPassportDiv").hide();   
    	$("#tapIndex").val(2);

    	
    });
//  宽带续约订单
    $("#renewalOrderId").bind('click',function(){
    	$("#renewalOrderId").attr("class","renewalSelected");
    	$("#topUpOrderId").attr("class","topUpOrderUnselected");
    	$("#regularOrderId").attr("class","regularOrderUnselected");
    	//隐藏身份证
    	$("#inputPassportDiv").hide(); 
    	$("#tapIndex").val(3);

    });
    
}
