
//selectState--0:selectedNone, 1:selectedCon, 2:selectedNum
var selectState = 0;

var params;

$(function() {
	changeSatate();
	
	//子页面返回按钮
	$('#selectContractBackBtn').bind("click",function(){
		$('#selectContractPage').css({ "display":"none" });
		$('#mianPage').css({ "display":"block" });
		return false;
	});
})

function changeSatate() {
	if(selectState==0) {
		 $("#selectContractTab").addClass("info-li-on").siblings().removeClass("info-li-on");
	} else if(selectState==1) {
		 $("#selectNumberTab").addClass("info-li-on").siblings().removeClass("info-li-on");
	} else if(selectState==2) {
		$("#amountTab").siblings().removeClass("info-li-on");
	}
}


function toSelectNumberPage() {
			$('#selectNumberPage').css({ "display":"block" }).siblings().css({ "display":"none" });
}



function selConBack2Main(data) {
	selectState = 1;
	changeSatate();
	$('#conType').text(data.conType);
	$('#conPeriod').text(data.conPeriod);
	
//	var tmp = data.packVal.split("　"); 
//	$('#call').text(tmp[0]);
//	$('#msg').text(tmp[1]);
//	$('#flow').text(tmp[2]);
	$('#conDesc').text(data.packVal);
	
	var conAttrVal1=data.resId+"|"+"PACKRES"+"|"+data.conType+"|"+data.packVal;
	var conAttrVal2=data.resId+"|"+"PAGERES"+"|"+data.conPeriod+"|"+data.pageVal;
	$('#attr_contract').val(conAttrVal1+"^"+conAttrVal2);
	
	var tmp = {
			conType:data.conType,
			conPeriod:data.conPeriod,
			};
	params = $.extend({}, params, tmp );
	
	$('#selectContractPage').css({ "display":"none" });
	$('#mianPage').css({ "display":"block" });
	$('#ctrct-unchoose').css({ "display":"none" });
	$('#ctrct-choosed').css({ "display":"block" });
}

function afterUpdateNumber(data) {
	selectState = 2;
	changeSatate();
	$('#serial_number').html(data.serial_number);
	
//	var attrVal=data.resId+"|"+"NUMBERS"+"|"+ "号码" +"|"+data.serial_number;
//	$('#attr_number').val(attrVal);
	
	var tmp = {serialNumber:data.serial_number};
	params = $.extend({}, params, tmp );
	
	
	$('#selectNumberPage').css({ "display":"none" });
	$('#mianPage').css({ "display":"block" });
	$('#new-num').css({ "display":"none" });
	$('#num-choosed').css({ "display":"block" });
}

function back2Main() {
	$('#selectNumberPage').css({ "display":"none" });
	$('#mianPage').css({ "display":"block" });
}

function toSelectContractPage() {
	 $('#selectContractPage').css({ "display":"block" }).siblings().css({ "display":"none" });
}

function nextPage() {
//	var tmp = {'fromPage':'newNumberJoin' };
	var tmp = new Object();
	tmp.fromPage = 'newNumberJoin' ;
	tmp.userId = $('#user_id').val();
	tmp.goodsId = $('#goods_id').val();
	tmp.goodsName = $('#goods_name').val();
	tmp.goodsPrice = $('#goods_price').val();
	tmp.goodsDisc = $('#goods_disc').val();
	tmp.attrVal = $('#attr_val').val()+"^"+$('#attr_contract').val()+"^"+$('#attr_number').val();
	
	params = $.extend({}, params, tmp );
	 $.commonFormSubmit({  
        action : 'fillOrderMain', 
		data: params,
        success : function(rtdata, status) { 
        }  
    });  
}