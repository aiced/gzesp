/**
 * Created by xinjunwang on 15-6-18.
 */
$(function(){
    initBind();

});

function initBind(){
    $("#searchId").bind("click",function(){
        var inputValue =  $("#inputId").val();
        if(inputValue == null || inputValue == ""){
            alert("搜索内容不能为空");
            return;
        }        
//        跳转界面 传入 inputValue 存储当前路径
        var path = "/topUp/phoneTradRecordSearch/"+$("#user_id").val();;
		 localStorage.setItem("phoneTradRecordListBackPath",path);
    	 window.location.href=$('#baseRoot').val() + '/topUp/phoneTradRecordList/'+ inputValue;   
    });
    
    $("#top_left").bind("click",function(){
    	location.href=document.referrer;
    	window.location.href=$('#baseRoot').val() + '/topUp/phoneTopUp/'+ $("#user_id").val();   
});
}