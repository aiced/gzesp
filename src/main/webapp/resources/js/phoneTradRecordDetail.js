/**
 * Created by xinjunwang on 15-6-18.
 */

$(function(){
    initBind();

});

function initBind(){
	$("#cardInfo").hide();

	if($("#status").html() == "未支付"){
		$("#cardInfo").hide();
		$("#checkDetailId").hide();		
				
	}else if($("#status").html() == "支付成功"){
		$("#payDivId").hide();
		$("#checkDetailId").show();		
	}
    
    $("#payDivId").bind("click",function(){
      	window.location.href=$('#baseRoot').val() + '/pay/selectPayMode/' + $("#orderId").text()+'/'+ $("#topayMoney").attr('topayMoney')*1000;   
    });
    
    $("#checkDetailId").bind("click",function(){
           	window.location.href=$('#baseRoot').val() + '/customer/custOrderStateDetails/' + $("#orderId").text();   
    });
    
    $("#top_left").bind("click",function(){
    	if($("#from").val() == "renewal"){
        	window.location.href=$('#baseRoot').val() + '/renewal/renewalList/' + $("#searchNumber").attr('searchNumber');
    	}else{
        	window.location.href=$('#baseRoot').val() + '/topUp/phoneTradRecordList/'+ $("#searchNumber").attr('searchNumber');   
    	}
    	
});
    
}
