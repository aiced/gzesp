/**
 * Created by xinjunwang on 15-6-18.
 */

var preferentialPrice;
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
//            var realPrice = parseFloat();
            preferentialPrice = $(this).attr('realPrice');
            refreshTotleAmount($(this).attr('realPrice'),1);
        });
    }
    //点击减号
    $("#removeId").bind("click", function () {
        var num = parseInt($("#numId").html());
        if (num == 1) {
            return;
        }
        num = num - 1;
        //    刷新金额
        refreshTotleAmount(preferentialPrice, num);


    });
    //点击加号
    $("#addId").bind("click", function () {
        var num = parseInt($("#numId").html());
        num = num + 1;
        refreshTotleAmount(preferentialPrice, num);
        //    刷新金额
    });

    //    输入号码判断
    $("#inputId").blur(function () {
    	var phoneNum = $("#inputId").val();
        if(phoneNum == null || phoneNum == ""){
          	alert("充值号码不能为空");
        	return;
        }else {
        	checkPhoneNum(phoneNum);
        }
    });

    	//     立即充值
    $("#top-upId").bind("click", function () {
    	//        充值判断 充值金额 号码有效性
        var num = $("#numId").html();
        if(num == null || num == "" || num == 0){
        	alert("充值卡金额不能为空");
        	return;
        }

        var phoneNum = $("#inputId").val();
        if(phoneNum == null || phoneNum == ""){
          	alert("充值号码不能为空");
        	return;
        }else {
        	checkPhoneNum(phoneNum);
        }
        
        //判断结束 界面跳转;
//        var  totleAmount =  $("#totleAmount").html();
//        alert(num);
//        alert(phoneNum);
//        alert(totleAmount);

    });
}
function checkPhoneNum(phoneNum) {
//	alert(phoneNum);
	
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
    $("#numId").html(num);
}


