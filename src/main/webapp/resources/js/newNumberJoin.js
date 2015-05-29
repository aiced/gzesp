
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
	//$('#conDesc').text(data.packVal);
	
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
	
	var attrVal=$('#num_resId').val()+"|"+"NUMBERS"+"|"+ data.serial_number +"|"+data.serial_number;
	$('#attr_number').val(attrVal);
	
	var totalPrice = $('#goods_price').val()*1 + data.nice_fee*1;
	$('#topayFeeSpan').html(totalPrice);
	
	var tmp = {serialNumber:data.serial_number, totalPrice:totalPrice};
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

function checkSelState() {
	//selectState--0:selectedNone, 1:selectedCon, 2:selectedNum
	if(selectState == 0) {
		alert('请选择合约');
		return false;
	} else if(selectState == 1) {
		alert('请选择号码');
		return false;
	}
	return true;
}

function nextPage() {
//	var tmp = {'fromPage':'newNumberJoin' };
	
	if(!checkSelState()) {
		return;
	}
	
	var tmp = new Object();
	tmp.fromPage = 'newNumberJoin' ;
	tmp.userId = $('#user_id').val();
	tmp.goodsId = $('#goods_id').val();
	tmp.goodsName = $('#goods_name').val();
	tmp.goodsPrice = $('#goods_price').val();
	tmp.goodsDisc = $('#goods_disc').val();
	tmp.attrVal = $('#attr_val').val()+"^"+$('#attr_contract').val()+"^"+$('#attr_number').val();
	
	tmp.ctlgCode = $('#ctlg_code').val();
	tmp.originalPrice = $('#original_price').val();
	tmp.albumId = $('#album_id').val();
	tmp.verNo = $('#ver_no').val();
	tmp.merchantId = $('#merchant_id').val();
	tmp.createTime = $('#create_time').val();
	tmp.createStaffId = $('#create_staff_id').val();
	tmp.goodsState = $('#goods_state').val();
	tmp.recomTag = $('#recom_tag').val();
	tmp.priceRule = $('#price_rule').val();
	tmp.beginTime = $('#begin_time').val();
	tmp.endTime = $('#end_time').val();
	tmp.simpDesc = $('#simp_desc').val();
	
	params = $.extend({}, params, tmp );
	 $.commonFormSubmit({  
        action : 'fillOrderMain', 
		data: params,
        success : function(rtdata, status) { 
        }  
    });  
}