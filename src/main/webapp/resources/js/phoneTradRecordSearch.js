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
//        跳转界面 传入 inputValue
    	window.location.href='/esp/set/phoneTradRecordList';       
    });
}


function leftClick(param)
{
//	点击返回
//	window.location.href='/esp/shopManage/acct/myAcct/'+$("#user_id").val();
}