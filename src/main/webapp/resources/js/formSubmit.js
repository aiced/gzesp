
jQuery.extend({
	

    createSubmitIframe: function(id, uri)
	{
			//create frame
            var frameId = 'jSubmitFrame' + id;
            var iframeHtml = '<iframe id="' + frameId + '" name="' + frameId + '" style="position:absolute; top:-9999px; left:-9999px"';
			if(window.ActiveXObject)
			{
                if(typeof uri== 'boolean'){
					iframeHtml += ' src="' + 'javascript:false' + '"';

                }
                else if(typeof uri== 'string'){
					iframeHtml += ' src="' + uri + '"';

                }	
			}
			iframeHtml += ' />';
			jQuery(iframeHtml).appendTo(document.body);

            return jQuery('#' + frameId).get(0);			
    },
    createSubmitForm: function(id, action, data, method)
	{
		//create form	
		var formId = 'jSubmitForm' + id;
//		var fileId = 'jSubmitFile' + id;
		var form = jQuery('<form  action="'+ action +'" method="'+ method +'" name="' + formId + '" id="' + formId + '" ></form>');	
		if(data)
		{
			for(var i in data)
			{
				if((typeof data[i]=='object') && data[i].constructor == Array) {
//					var len = data[i].length;
//					for(var j=0; j<len; j++) {
////						jQuery('<input type="hidden" name="' + i +'['+j+']' + '" value="' + data[i][j] + '" />').appendTo(form);
//						if(typeof data[i][j]=='object') {
//							for(var k in data[i][j]) {
//								jQuery('<input type="hidden" name="' + i +'['+j+'].'+ k + '" value="' + data[i][j][k] + '" />').appendTo(form);
//							}
//						} else {
//							jQuery('<input type="hidden" name="' + i +'[]'+ '" value="' + encodeURI(data[i][j]) + '" />').appendTo(form);
//						}
//					}
					jQuery('<input type="hidden" name="' + i +'[]'+ '" value="' + encodeURI($.toJSON(data[i])) + '" />').appendTo(form);
				} else if(((typeof data[i]=='number') && data[i].constructor == Number)
					 || ((typeof data[i]=='string') && data[i].constructor == String)) {
					jQuery('<input type="hidden" name="' + i + '" value="' + data[i] + '" />').appendTo(form);
				}
			}			
		}		

		
		//set attributes
		jQuery(form).css('position', 'absolute');
		jQuery(form).css('top', '-1200px');
		jQuery(form).css('left', '-1200px');
		jQuery(form).appendTo('body');		
		return form;
    },
    
    
    commonFormSubmit: function(s) {
    	var form = jQuery.createSubmitForm((typeof(s.formId)=='undefined'?"commonForm":s.formId), s.action, (typeof(s.data)=='undefined'?false:s.data), (typeof(s.method)=='undefined'?"POST":s.method));
    	 form.submit();
    }
   
    /*
     		* howto use
 			var parms = {'name':'leoxu', 'age':'1', 'xxx':$('xxx').val(); };
			
			 $.commonFormSubmit({  
     	        action : '${base}/weShop/index', 
				data: parms,
     	        success : function(rtdata, status) { 
     	        }  
     	    });  
     */
})

