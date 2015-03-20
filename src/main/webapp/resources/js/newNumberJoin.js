
//selectState--0:selectedNone, 1:selectedCon, 2:selectedNum
var selectState = 0;

var params;

$(function() {
	changeSatate();
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
//    		var parms = {'fromPage':'newNumberJoin' };
//			
//			 $.commonFormSubmit({  
//    	        action : 'selectNumber', 
//				data: parms,
//    	        success : function(rtdata, status) { 
//    	        }  
//    	    }); 
			 
			$('#selectNumberPage').css({ "display":"block" }).siblings().css({ "display":"none" });
}



function selConBack2Main(data) {
	selectState = 1;
	changeSatate();
    $('#goodsName').text(data.goodsName);
	$('#conType').text(data.conType);
	$('#conPeriod').text(data.conPeriod);
	
	var tmp = {
			goodsName:data.goodsName,
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
	
	var tmp = {serial_number:data.serial_number};
	params = $.extend({}, params, tmp );
	
	
	$('#selectNumberPage').css({ "display":"none" });
	$('#mianPage').css({ "display":"block" });
	$('#new-num').css({ "display":"none" });
	$('#num-choosed').css({ "display":"block" });
}

function toSelectContractPage() {
//	var parms = {'fromPage':'newNumberJoin' };
//	
//	 $.commonFormSubmit({  
//        action : 'selectContract', 
//		data: parms,
//        success : function(rtdata, status) { 
//        }  
//    }); 
	 $('#selectContractPage').css({ "display":"block" }).siblings().css({ "display":"none" });
}

function nextPage() {
	var tmp = {'fromPage':'newNumberJoin' };
	
	params = $.extend({}, params, tmp );
	 $.commonFormSubmit({  
        action : 'fillOrderMain', 
		data: params,
        success : function(rtdata, status) { 
        }  
    });  
}