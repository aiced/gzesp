/**
 * Created by xinjunwang on 15-6-18.
 */
$(function(){
    initBind();

});
function initBind(){

    $("#searchId").bind("click",function(){
        var inputValue =  $("#inputId").val();
        alert(inputValue);
    });
}