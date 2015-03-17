
//selectState--0:selectedNone, 1:selectedCon, 2:selectedNum
var selectState;

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
	
	selectState =  $("#selectState").val();
		
	if(selectState==0) {
		 $("#selectContractTab").addClass("info-li-on").siblings().removeClass("info-li-on");
	} else if(selectState==1) {
		 $("#selectNumberTab").addClass("info-li-on").siblings().removeClass("info-li-on");
	} else if(selectState==2) {
		$("#amountTab").siblings().removeClass("info-li-on");
	}
})

function toSelectNumberPage() {
    		var parms = {'fromPage':'newNumberJoin' };
			
			 $.commonFormSubmit({  
    	        action : 'selectNumber', 
				data: parms,
    	        success : function(rtdata, status) { 
    	        }  
    	    }); 
    	}
    	
function toSelectContractPage() {
	var parms = {'fromPage':'newNumberJoin' };
	
	 $.commonFormSubmit({  
        action : 'selectContract', 
		data: parms,
        success : function(rtdata, status) { 
        }  
    }); 
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