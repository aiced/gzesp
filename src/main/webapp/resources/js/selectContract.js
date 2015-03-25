var contract = {
			resId:"",
			conType : "",
    	    conPeriod : "",
    	    pageVal: "",
    	    packVal: ""
    	};

$(function() {
//	$('#period-select a').bind("click",function(){
//	    	  $(this).addClass("selected").siblings().removeClass("selected");
//	    	  selectPeriod(this);
//	    	  return false;
//	      });
	
//	$('#p-tab li').bind("click",function(){
//	    	  $(this).addClass("selected").siblings().removeClass("selected");
//	    	  showActPkg(this);
//	    	  return false;
//	});
	
	$('#selectConOkBtn').bind("click",function(){
		var tmp = {'fromPage':'selectContract' };
	    var parms = $.extend({}, tmp, contract);
	    selConBack2Main(parms);
    });
	
//	showActPkg($('#p-tab li:first'));
})

function selectPeriod(selectedPeriod) {
	var pageVal = $(selectedPeriod).attr("pageVal_hidden")
	contract.pageVal = pageVal;
	
	var pageName = $(selectedPeriod).find('#pageName_hidden').val();
	contract.conPeriod = pageName;
	
	$('#pageName').text(pageName);
}

function showActPkg(selectedTab) {
	var pkgName = $(selectedTab).find('#pkgType_hidden').val();
	contract.conType = pkgName;
	
	var goodsId = $(selectedTab).find('#goodsId_hidden').val();
	
	var packVal = $(selectedTab).find('#packVal_hidden').val();
	contract.packVal = packVal;
	$('#packName').text(pkgName);
	
	var resId = $(selectedTab).find('#resId_hidden').val();
	contract.resId = resId;
}


function queryPageInfo(goodsId, resId) {
	var param = {"goodsId": goodsId, "resId":resId };
	
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: $('#baseRoot').val() + "/order/queryPageInfoListById",
		   //dataType:"json", //预期服务器返回的数据类型
		   data: JSON.stringify(param), //服务器只能接收json字符串
		   success: function(data){
//			  alert(data);
//			   disablePeriodTab();
//			  for(var i in data) {
//				  alert(i);
//				  alert(data[i].PAGENAME);
//				  alert( $('#period-select a').attr("value");
//			  }
		     $('#datagrid').html(data);
		     initPeriodTabEvent();
		     $("#period-select a:first").click();
		   }
		});
}

function initPeriodTabEvent() {
	$('#period-select a').bind("click",function(){
  	  $(this).addClass("selected").siblings().removeClass("selected");
  	  selectPeriod(this);
  	  return false;
    });
}

function disablePeriodTab() {
	$('#period-select a').unbind('click');
}