function toSelectNumberPage() {
    		var parms = {'fromPage':'newNumberJoin' };
			
			 $.commonFormSubmit({  
    	        action : '${base}/order/selectNumber', 
				data: parms,
    	        success : function(rtdata, status) { 
    	        }  
    	    }); 
    	}
    	
    	function toSelectContractPage() {
    		var parms = {'fromPage':'newNumberJoin' };
			
			 $.commonFormSubmit({  
    	        action : '${base}/order/selectContract', 
				data: parms,
    	        success : function(rtdata, status) { 
    	        }  
    	    }); 
    	}
    	
		function nextPage() {
			var parms = {'name':'leoxu', 'age':'1' };
			
			 $.commonFormSubmit({  
     	        action : '${base}/order/selectContract', 
				data: parms,
     	        success : function(rtdata, status) { 
     	        }  
     	    });  
		}