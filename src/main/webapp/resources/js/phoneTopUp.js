/**
 * Created by xinjunwang on 15-6-18.
 */
//  一处赋数，多处取值
var phoneNumalidation =false;
var ADD_PRICE = null;
var ORIGINAL_PRICE= null;
var GOODS_ID= null;




$(function () {
    initBind();
});

function initBind() {
//    输入号码失焦点 绑定
	$('#phoneDetailId').hide();
	$("#rotateG_01").hide();
	
    $('#phoneNumId').blur(function ()
    {
    	phoneNumalidation = false;
    	verificationNum(true);    	
    });
    
    $("#numSelected").change(function(){
    	phoneNumalidation = false;
		$('#phoneNumId').val("");
    	verificationNum(false);
   });

//    点击金额绑定
    var cards=$('[name=cardName]');
    for(var i=0;i<cards.length;i++){
        var card = cards[i];
        var $card=$(card);
       	if($card.attr('clickAble') == "no"){
       		$card.css("background-color","#ECECEC");
       		$card.attr("class","noAvalibleCard");       		
    	}else{
            $card.bind("click" , function(){ 
                //清空所有格式
                clearCardStyle();
                $(this).attr("class","cardSelected");
                //清空输入金额  设置优惠价格
                clearInputNum();
                refreshTotleAmount($(this).attr('realPrice'),$(this).attr('originalPrice'),$(this).attr('goodsId'));
            });
    	}
        

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
       	if(!$("#rotateG_01").is(":hidden")){
    		return;
    	}
       	
    	//号码判断
    	if(!phoneNumalidation){
            alert("输入的号码无效,请重新输入！");
    		$('#phoneNumId').val("");
    		return;
    	}
        //金额判断
    	if(ADD_PRICE == null || ADD_PRICE == ""){
            alert("输入的金额不能为空");
            return;
    	}
    	// 判断号码的有效 bss
    	$("#rotateG_01").show();
    	var path ="/recharge/rechargeCheck/" + $('#phoneNumId').val() + "/"  +  $("#numSelected").val();
    	var param = {"serial_number":$('#phoneNumId').val(),"serial_number_type":$("#numSelected").val()};	
    	$.ajax({
 		   type: "POST",
 		   contentType:"application/json", //发送给服务器的内容编码类型
 		   url: $('#baseRoot').val() + path,
 		   data: param, //服务器只能接收json字符串
 		   async: false,
 		   success: function(data){
 		    	$("#rotateG_01").hide();
//			     * 返回 json 成功：{"status":"00000", "detail":"成功"}， 失败 {"status":"xxx", "detail":"失败原因"}
// 			   var obj = eval(data);    			   
// 			   if(obj.status == "00000"){
//  			  	  var r=confirm("充值号码: " + $('#phoneNumId').val());
// 		          if (r==true)
// 		          {
// 		            	var userId = $("#user_id").val();
// 		        	  	var parms = {'USER_ID':userId,'PHONE_NUMBER':$('#phoneNumId').val(),'TOPAY_MONEY':ADD_PRICE,'ORIGINAL_PRICE':ORIGINAL_PRICE,'ORDER_FROM':'01','GOODS_ID':GOODS_ID,'NUMBER_TYPE':$("#numSelected").val()};
// 		        	  	$.commonFormSubmit({  
// 		        	        action :$('#baseRoot').val() + "/order/submitRecharge", 
// 		        			data: parms
// 		        	    });         
// 		          }
// 		          else
// 		          {
// 		        	  return;
// 		          }     
// 			   }else {
//     			   alert(obj.detail);    
//		           return;
// 			   }
 		    	
 		    	var r=confirm("充值号码: " + $('#phoneNumId').val());
		          if (r==true)
		          {
		            	var userId = $("#user_id").val();
		        	  	var parms = {'USER_ID':userId,'PHONE_NUMBER':$('#phoneNumId').val(),'TOPAY_MONEY':ADD_PRICE,'ORIGINAL_PRICE':ORIGINAL_PRICE,'ORDER_FROM':'01','GOODS_ID':GOODS_ID,'NUMBER_TYPE':$("#numSelected").val()};
		        	  	$.commonFormSubmit({  
		        	        action :$('#baseRoot').val() + "/order/submitRecharge", 
		        			data: parms
		        	    });         
		          }
		          else
		          {
		        	  return;
		          }    
// 			     			      			   
 		     }
 		});

    	

    	// 数据组装，跳转界面
    });
//    点击购买充值卡绑定
    $("#buyCardId").bind("click",function(){
    	alert("敬请期待！");
//    	window.location.href='/esp/set/phoneTopUpCards';   
    });

//    点击交易记录查询绑定
    $("#dealListId").bind("click",function(){
    	window.location.href=$('#baseRoot').val() + '/topUp/phoneTradRecordSearch/' + $("#user_id").val();   
    });
    
    $("#top_left").bind("click",function(){
    	window.location.href=$('#baseRoot').val() + '/weShop/index/'+$("#user_id").val();   
    });
}

function verificationNum(istrue){
	var phoneNum = $('#phoneNumId').val();
	var selectedValue =  $("#numSelected").val();
	
	if(selectedValue == 1){
    	//本地验证请求
    	phoneNumalidation = isPhoneNum(phoneNum);
    	if(phoneNumalidation){
        	queryAccountInfo(phoneNum);
    	}else{
    		if(istrue == true){
        		$('#phoneNumId').val("");
        		alert("手机号码有误，请重新输入");
    		}
    	}
		
	}else if(selectedValue == 2){
    	phoneNumalidation = istell(phoneNum);
    	if(phoneNumalidation){
        	queryAccountInfo(phoneNum);
    	}else{
       		if(istrue == true){
        		$('#phoneNumId').val("");
        		alert("固定电话有误，请重新输入");
    		}

    	}

	}else if(selectedValue == 3){
    	phoneNumalidation = isBroadband(phoneNum);
    	if(phoneNumalidation){
        	queryAccountInfo(phoneNum);
    	}else{
      		if(istrue == true){
        		$('#phoneNumId').val("");
        		alert("宽带号码有误，请重新输入");
    		}

    	}		
	}
	
}


function phoneDetailId(data){
	//根据返回数据，判断一下
	if(!phoneNumalidation){
		$('#phoneDetailId').hide();
		return;
	}

	$('#phoneDetailId').show();
	$('#realTopUpId').html();
//    alert("oooo" + $('#realTopUpId').html() + "oooo"  + $('#creditId').html()+ "oooo"  + $('#balanceId').html());
	//加载数据
}



function clearCardStyle(){
    var cards=$('[name=cardName]');
    for(var i=0;i<cards.length;i++){
        var card = cards[i];
        var $card=$(card);
        
        if($card.attr('clickAble') == "no"){
       		$card.css("background-color","#ECECEC");
       		$card.attr("class","noAvalibleCard");       		
    	}else{
            $card.attr("class","card");
    	}
        
    }
}

function clearInputNum(){
	$('#amountId').val(null);
}


function refreshTotleAmount(realPrice,originalPrice,goodsId) {
	var text = "优惠价："+ realPrice;
	$("#preferentialId").html(text);
	ADD_PRICE = realPrice;
	ORIGINAL_PRICE = originalPrice;
	GOODS_ID = goodsId;
}


//匹配国内电话号码(0511-4405222 或 021-87888822)
function istell(str)
{
	var result=str.match(/\d{3}-\d{8}|\d{4}-\d{7}/);
	if(result==null) return false;
	return true;
}

function isBroadband(str)
{
	if(str && str != null && str){
		var b = /^[0-9a-zA-Z]*$/g;
		return b.test(str);;
	}
	 return false;
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
