/**
 * Created by xinjunwang on 15-6-18.
 */
//  一处赋数，多处取值
var phoneNumalidation =false;

$(function () {
    initBind();
});

function initBind() {
//    输入号码失焦点 绑定
	$('#phoneDetailId').hide();
	
    $('#phoneNumId').blur(function ()
    {
    	phoneNumalidation = false;

    	var phoneNum = $('#phoneNumId').val();
    	//本地验证请求
    	phoneNumalidation = isPhoneNum(phoneNum);
    	if(phoneNumalidation){
        	queryAccountInfo(phoneNum);
    	}else{
    		$('#phoneNumId').val("");
    		alert("手机号码有误，请重新输入");
    	}
    });

//    点击金额绑定
    var cards=$('[name=cardName]');
    for(var i=0;i<cards.length;i++){
        var card = cards[i];
        var $card=$(card);
        $card.bind("click" , function(){          
            //清空所有格式
            clearCardStyle();
            $(this).attr("class","cardSelected");
            //清空输入金额  设置优惠价格
            clearInputNum();
            refreshTotleAmount($(this).attr('realPrice'));
        });
    }

//    输入金额失焦点 绑定
    $('#amountId').blur(function ()
    {
		var inputNum = $('#amountId').val();
    	if(inputNum != null && inputNum != "" && inputNum !=0){
    		//无效金额返回
    		inputNum = parseInt(inputNum);
    		if(inputNum%10 != 0){
    			clearInputNum();
    			alert("输入金额必须为10的整数倍");
    			return;
    			}
    		//  有效金额 清除卡标识  更新总金额
             clearCardStyle();
     		 inputNum = inputNum *0.98;
             refreshTotleAmount(inputNum);
    	}
        //alert("buyCardId");
    });
//    点击充值 绑定
    $("#topUpId").bind("click",function(){
    	//号码判断
    	if(!phoneNumalidation){
            alert("输入的号码无效");
    		return;
    	}
        //金额判断
    	var preferential =  $("#preferentialId").html();
    	if(preferential == null && preferential == ""){
            alert("输入的金额不能为空");
            return;
    	}
    	
    	  var r=confirm("充值号码: " + $('#phoneNumId').val());
          if (r==true)
          {
              alert("You pressed OK!");
//          	window.location.href='/esp/shopManage/weShopHome?userid='+$("#hide_user_id").val();    	
          }
          else
          {
        	  return;
          }
    	
    	// 数据组装，跳转界面
    });

//    点击购买充值卡绑定
    $("#buyCardId").bind("click",function(){
    	alert("敬请期待！");
//    	window.location.href='/esp/set/phoneTopUpCards';   
    });

//    点击交易记录查询绑定
    $("#dealListId").bind("click",function(){
    	window.location.href='/esp/set/phoneTradRecordSearch';   
    });
}


function phoneDetailId(data){
	//根据返回数据，判断一下
	if(!phoneNumalidation){
		$('#phoneDetailId').hide();
		return;
	}

	$('#phoneDetailId').show();
	$('#realTopUpId').html();
    alert("oooo" + $('#realTopUpId').html() + "oooo"  + $('#creditId').html()+ "oooo"  + $('#balanceId').html());
	//加载数据
}



function clearCardStyle(){
    var cards=$('[name=cardName]');
    for(var i=0;i<cards.length;i++){
        var card = cards[i];
        var $card=$(card);
        $card.attr("class","card");
    }
}

function clearInputNum(){
	$('#amountId').val(null);
}


function refreshTotleAmount(realPrice) {
	var text = "优惠价："+ realPrice;
	$("#preferentialId").html(text);
}


//匹配国内电话号码(0511-4405222 或 021-87888822)
function istell(str)
{
	var result=str.match(/\d{3}-\d{8}|\d{4}-\d{7}/);
	if(result==null) return false;
	return true;
}


function isPhoneNum(strPhoneNum)
{
	if(strPhoneNum && /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|170)\d{8}$/.test(strPhoneNum)){
	    return true;  //是手机号
	} else{
	    return false; //不是手机号
	}
}



//查询 账户信息
function queryAccountInfo(phoneNum)
{		
	var user_id = $("#user_id").val();
	var param = {"phoneNum":phoneNum,"user_id":user_id};	

//	$.ajax({
//		   type: "POST",
//		   contentType:"application/json", //发送给服务器的内容编码类型
//		   url: $('#baseRoot').val() + "/shopManage/acct/acctBalanceTotalPostData",
//		   data: param, //服务器只能接收json字符串
//		   async: false,
//		   success: function(data){
//			//			  取数值
//		    alert(data);	
//	    	phoneDetailId(data);
//		   }
//		});
	
	
}



function leftClick(param)
{
//	点击返回
//	window.location.href='/esp/shopManage/acct/myAcct/'+$("#user_id").val();
}
