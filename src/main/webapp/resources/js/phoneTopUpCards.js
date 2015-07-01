/**
 * Created by xinjunwang on 15-6-18.
 */
$(function () {
    initBind();

});
function initBind() {
//    点击金额绑定
    var cards = $('[name=cardName]');
    for (var i = 0; i < cards.length; i++) {
        var card = cards[i];
        var $card = $(card);
        $card.bind("click", function () {
            //alert($(this).attr('price'));
            //清空所有格式
            clearCardStyle();
            $(this).attr("class", "cardSelected");
            //设置可数量为1，刷新金额
            refreshTotleAmount(100.32, 1);

        })
    }
    //点击减号
    $("#removeId").bind("click", function () {
        var num = parseInt($("#numId").html());
        if (num == 1) {
            return;
        }
        num = num - 1;
        $("#numId").html(num);

        //    刷新金额
        refreshTotleAmount(100.32, num);


    });
    //点击加号
    $("#addId").bind("click", function () {
        var num = parseInt($("#numId").html());
        num = num + 1;
        $("#numId").html(num);
        refreshTotleAmount(100.32, num);

        //    刷新金额
    });

    //    输入号码判断
    $("#inputId").blur(function () {
        alert("111");
    })

    //     立即充值
    $("#top-upId").bind("click", function () {
        alert("222");
    });


}


function clearCardStyle() {
    var cards = $('[name=cardName]');
    for (var i = 0; i < cards.length; i++) {
        var card = cards[i];
        var $card = $(card);
        $card.attr("class", "card");
    }
}


function refreshTotleAmount(price, num) {
    var totleAmount = price * num;
    totleAmount = Math.round(totleAmount * 100) / 100;
    $("#totleAmount").html(totleAmount);
}