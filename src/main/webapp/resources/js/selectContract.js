var contract = {
    	    actType : "",
    	    conPeriod : "",
    	    proValue : "",
    	    proType : "4GMain",
    	    brand : "",
    	    model : "",
    	    color : ""
    	};

$(function() {
	$('#period-select a').bind("click",function(){
	    	  $(this).addClass("selected").siblings().removeClass("selected");
	    	  selectPeriod(this);
	    	  return false;
	      });
	
	$('#p-tab li').bind("click",function(){
	    	  $(this).addClass("selected").siblings().removeClass("selected");
	    	  showActPkg(this);
	    	  return false;
	      });
	
	showActPkg($('#p-tab li:first'));
})

function selectPeriod(selectedPeriod) {
//	contract.conPeriod = 12;
	alert($(selectedPeriod).val());
}

function showActPkg(selectedTab) {
// 	alert($(selectedTab).find('#nationalminutes_hidden').val());
// 	alert($(selectedTab).find('#nationalthroughtput_hidden').val());
//  	alert($(selectedTab).find('#returnDesc_hidden').val());
// 	alert($(selectedTab).find('#totalFee_hidden').val());
// 	alert($(selectedTab).find('#returnFee_hidden').val());
// 	alert($(selectedTab).find('#monthRtnFee_hidden').val());
	var pkgType_val = $(selectedTab).find('#pkgType_hidden').val()
	contract.actType = pkgType_val;
	
	var nationalminutes_val = $(selectedTab).find('#nationalminutes_hidden').val()
	$('#nationalminutes').html(nationalminutes_val);
	var nationalthroughtput_val = $(selectedTab).find('#nationalthroughtput_hidden').val()
	$('#nationalthroughtput').html(nationalthroughtput_val);
	var totalFee_val = $(selectedTab).find('#totalFee_hidden').val()
	$('#totalFee').html(totalFee_val);
	var returnFee_val = $(selectedTab).find('#returnFee_hidden').val()
	$('#returnFee').html(returnFee_val);
	var monthRtnFee_val = $(selectedTab).find('#monthRtnFee_hidden').val()
	$('#monthRtnFee').html(monthRtnFee_val);
}

function nextPage() {
//	var parms = {'name':'leoxu', 'age':'1' };
	
	 $.commonFormSubmit({  
	        action : 'newNumberJoin', 
	        data: contract,
	        success : function(rtdata, status) { 
	        }  
	    });  
}