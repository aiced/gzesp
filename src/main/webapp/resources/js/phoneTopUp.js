/**
 * Created by xinjunwang on 15-6-18.
 */
$(function () {
    initBind();

});
function initBind() {
//    输入号码失焦点 绑定
    $('#phoneNumId').blur(function ()
    {

    });

//    点击金额绑定
    var cards=$('[name=cardName]');
    for(var i=0;i<cards.length;i++){
        var card = cards[i];
        var $card=$(card);
        $card.bind("click" , function(){
            //alert($(this).attr('price'));
            //清空所有格式
            clearCardStyle();
            $(this).attr("class","cardSelected");
            //设置优惠价格

        })
    }

//    输入金额失焦点 绑定
//    $('#phoneNumId').focus(function ()
//    {
//    });
    $('#amountId').blur(function ()
    {
        //alert("buyCardId");
    });
//    点击充值 绑定
    $("#topUpId").bind("click",function(){
        alert("topUpId");

    });

//    点击购买充值卡绑定
    $("#buyCardId").bind("click",function(){
        alert("buyCardId");

    });

//    点击交易记录查询绑定
    $("#dealListId").bind("click",function(){
        alert("dealListId");

    });


}

function clearCardStyle(){
    var cards=$('[name=cardName]');
    for(var i=0;i<cards.length;i++){
        var card = cards[i];
        var $card=$(card);
        $card.attr("class","card");

    }
}
