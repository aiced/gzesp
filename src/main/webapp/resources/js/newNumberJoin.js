
//selectState--0:selectedNone, 1:selectedCon, 2:selectedNum
var selectState = 0;

var contract = {
		contractType : "",
	    conPeriod : "",
	    proValue : "",
	    proType : "4GMain",
	    brand : "",
	    model : "",
	    color : ""
	};

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
	
	$('#selectContractPage').css({ "display":"none" });
	$('#mianPage').css({ "display":"block" });
	$('#ctrct-unchoose').css({ "display":"none" });
	$('#ctrct-choosed').css({ "display":"block" });
}

function back2Main() {
	selectState = 2;
	changeSatate();
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
	var parms = {'fromPage':'newNumberJoin' };
	
	 $.commonFormSubmit({  
        action : 'fillOrderMain', 
		data: parms,
        success : function(rtdata, status) { 
        }  
    });  
}