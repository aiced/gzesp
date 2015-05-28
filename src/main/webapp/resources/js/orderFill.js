
var orderStat = {
		netInfoStat:0,
		receiveInfoStat:0,
		payInfoStat:0,
		otherInfoStat:0
}

var orderFormParams = {
		token:"",
		isAndroidWeiXin:"",
		
		orderFrom:"01",
//		originalPrice:"",
		couponMoney:"",
		manMadeMoney:"",
		topayMoney:"",
		custRemark:"",
		sellerRemark:"",
		
		custName:"",
		phoneNum:"",
		idCardNum:"",
		cardPic1:"",
		cardPic2:"",
		
		userId:"",
		userName:"",
		devlpId:"123456",
		devlpName:"asiainfo_ced",
		phoneNum:"",
		invoiceTitle:"",
		
		payType:"",
		payMode:"",
		
		deliverTypeCode:"",
		deliverTimeCode:"",
		receiverName:"",
		receiverPsptType:"",
		receiverPsptNo:"",
		phoneNum:"",
		postAddr:"",
		provinceCode:"",
		cityCode:"",
		districtCode:"",
		postRemark:"",
		expressCompany:"",
		
		goodsId:"",
		goodsName:"",
		unitPrice:"",
		saleNum:"1",
		topayFee:"",
		derateFee:"",
		derateReason:"",
		recvFee:"",
		goodsDisc:"",
		ctlgCode:"",
		originalPrice:"",
		albumId:"",
		verNo:"",
		merchantId:"",
		createTime:"",
		createStaffId:"",
		goodsState:"",
		recomTag:"",
		priceRule:"",
		beginTime:"",
		endTime:"",
		simpDesc:"",
		
		resAttr:""
};

// 初始化按钮点击事件
$(function() {
	


	
	
	$('#netInfoTab').bind("click",function(){
  	  $('#netInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
  	  return false;
    });
	$('#receiveInfoTab').bind("click",function(){
		$('#receiveInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
		return false;
	});
//	$('#payInfoTab').bind("click",function(){
//		$('#payInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
//		return false;
//	});
	$('#otherInfoTab').bind("click",function(){
		$('#otherInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
		return false;
	});
	
	//子页确认事件
	$('#netInfoBtn').bind("click",function(){
		if(netInfo_checkData()) {
			uploadPic(this);
		}
		
		return false;
	});
	//子页面返回按钮
	$('#netInfoBackBtn').bind("click",function(){
		$('#netInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	
	$('#receiveInfoBtn').bind("click",function(){
		if(addres_checkData()) {
			orderStat.receiveInfoStat = 1;
			$('#receiveInfo').css({ "display":"none" });
			$('#orderMain').css({ "display":"block" });
		}
		
		return false;
	});
	$('#receiveInfoBackBtn').bind("click",function(){
		$('#receiveInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	
//	$('#payInfoBtn').bind("click",function(){
//		orderStat.payInfoStat = 1;
//		setPayText();
//		$('#payInfo').css({ "display":"none" });
//		$('#orderMain').css({ "display":"block" });
//		return false;
//	});
//	$('#payInfoBackBtn').bind("click",function(){
//		$('#payInfo').css({ "display":"none" });
//		$('#orderMain').css({ "display":"block" });
//		return false;
//	});
	$('#otherInfoBtn').bind("click",function(){
//		if(otherOrder_checkData()) {
			orderStat.otherInfoStat = 1;
//			$('#otherInfoTab').find('img:first').addClass("hide");
//			$('#otherInfoTab').find('img:last').removeClass("hide");
			$('#otherInfo').css({ "display":"none" });
			$('#orderMain').css({ "display":"block" });
//		}
		return false;
	});
	$('#otherInfoBackBtn').bind("click",function(){
		$('#otherInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	
	//配送方式
	$('#deliver-select a').find('.selected').bind("click",function(){
  	  $(this).addClass("selected").siblings().removeClass("selected");
		if($('#deliver-select-post').hasClass("selected")){
			$('#postInfoTab').css({ "display":"block" });
    	}else{
    		$('#postInfoTab').css({ "display":"none" });
    	}
  	  return false;
    });
	
	//物流选择
	$('#post-select a').bind("click",function(){
		$(this).addClass("selected").siblings().removeClass("selected");
		return false;
	});
	
	//首月资费
	$('#firstMonthFee-select a').bind("click",function(){
  	  $(this).addClass("selected").siblings().removeClass("selected");
  	  var descId = $(this).attr("data-descId");
  	  $('#'+descId).removeClass("hide").siblings().addClass("hide");
  	  
  	  return false;
    });
	
	
	//选择文件
	$(':file').change(function(event){
    	if(this.files.length == 0){
	        return;
	    }
	    var f = this.files[0],thisFileEle = $(this), type = this.value.substr(this.value.lastIndexOf(".")).toLowerCase() ,type2 = f.type;
	    
	    //选择的图片非bmp、jpg、jpeg时，清空文件选择，展示提示框
	    if(!(type == ".jpg" || type == ".png" || type == ".bmp" || /^image\/(jpeg|jpg|png|bmp)$/.test(type2))){
	    	alert('只能选择jpg、png格式图片');
	        return;
	    }
	    var reader = new FileReader();
	    reader.onload = function(event){ 
//	    	$('#picsHolder').append(event.target.result) ;
	    	var dataURL = this.result;
//	    	 alert(dataURL.length);
	    	if(!dataURL.match(/^data:image/)) {
	    		dataURL = dataURL.replace(/^data:/,"data:image/"+type+";");
	    	}
	    	 var preview = thisFileEle.siblings("img");
//	    	 alert(dataURL.length);
	    	 preview.attr('title', f.name).attr("src", dataURL);
	    	 
//	    	console.log($.isCanvasSupported());
	    };
	    //读取文件的缓冲数组流，读取完毕后执行onload
        reader.readAsDataURL(f);
	});
	
	
	//省、市、区联动
	$('#selCity').change(function(){
		var cityCode = $(this).children('option:selected').val();
		getDistrictListByCityCode(cityCode);
	});
	
	initSelect();
	
	

	
})
//edit_by_wenh_2015_5_8 入网资料-入网协议
//toggle替代方法
var proxyflag=1;
function proxyClick()
{
    if(proxyflag==1){
    	proxyflag=0;
    	$("#ruwangxieyi b").css("background-image","url(/esp/resources/image/order/arr_up.png)");
    }else{
    	proxyflag=1;
        $("#ruwangxieyi b").css("background-image","url(/esp/resources/image/order/arr_down.png)");

    }
}


function initSelect() {
	var cityCode = $("#selCity").val();
	getDistrictListByCityCode(cityCode);
}

function getDistrictListByCityCode(cityCode) {
	var param = {"cityCode":cityCode}; 
	$.ajax({
		   type: "POST",
		   contentType:"application/json", //发送给服务器的内容编码类型
		   url: "getDistrictListByCityCode",
		   data: JSON.stringify(param), //服务器只能接收json字符串
		   success: function(data){
			   $('#selectDistrictDiv').html(data);
		   }
		});	
}

function isPhoneNum(strPhoneNum)
{
	if(strPhoneNum && /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|170)\d{8}$/.test(strPhoneNum)){
	    return true;//是手机号
	} else{
	    return false; //不是手机号
	}
}

//wenhui_newReceiveAddress_数值校验
function addres_checkData()
{
	if(!$("#txtname").val())
	{
		alert("请填写收件人姓名");
		return false;
	}
	if(!$("#txtphone").val())
	{
		alert("请输入手机号码");
		return false;
	} else {
		var flag = isPhoneNum($("#txtphone").val());
		if(!flag) {
			alert("手机号码格式错误");
			return false;
		}
	}
	if(!$("#txtaddress").val())
	{
		alert("请填写详细地址");
		return false;
	}
	return true;
}
//wenhui_otherOrderInfo_数据校验
function otherOrder_checkData() 
{
	if(!$("#txtbilltitle").val())
	{
		alert("请输入发票抬头");
		return false;
	}
	if(!$("#txtcash").val())
	{
		alert("请输入代金券");
		return false;
	}
	if(!$("#txtreferences").val())
	{
		alert("请输入推荐人姓名");
		return false;
	}
	if(!$("#txtrecommphone").val())
	{
		alert("请输入推荐人手机号");
		return false
	}
	return true;
}

//入网信息验证
function netInfo_checkData() {
//	userName  姓名
//	userCard  身份证号
//	card01    第一张
//	card02	  第二张	
	var userName = document.getElementById('userName');
	var userCard = document.getElementById('userCard');    

    if (userName.value.length == 0){
    	alert("姓名不能为空");   	
    	return false;
    }else if(userCard.value.length == 0){
//    	身份证验证
    	alert("身份证号不能为空");   	
    	return false;
    }
    if(isCardNo(userCard.value) === false)
	 {
		 alert("您输入的身份证号码不正确，请重新输入");
		 return false;
	 }
    

    if($('#firstCard').attr("src") =='/esp/resources/image/order/card01.png'){
    	alert("证件照片不能为空");   	
    	return false;
    }else if($('#secondCard').attr("src") =='/esp/resources/image/order/card02.png'){
    	alert("证件照片不能为空");   	
    	return false;
    }
    return true;
}
//	
function checkPostSelect() {
//	快递配送
	if($('#deliver-select-post').hasClass("selected")){
    	if($('#post-select-none').hasClass("selected")){
//        	alert('###'+$('#post-select-none').attr("value"));
    		return $('#post-select-none').attr("value");
       	}else if($('#post-select-shunfeng').hasClass("selected")){
    		return $('#post-select-shunfeng').attr("value");
    	}
    }else{
//   自提
    	
    }

}

//function setPayText() {
//	var text;
//	text = $('input[name="pay_mode"]:checked').attr("data-text");
//	switch ($("input[name=pay_mode]:checked").attr("id"))  {
//         case "pay_mode_1":
//        	 text = text +" " +$('input[name="pay_mode_style"]:checked').val();
//        	 break;
//         case "pay_mode_2":
//        	 text = text +" " + $('#paySelector option:selected').text();
//        	 break;
//    }
//	$('#payText').text(text);
//}


function getParams() {
	orderFormParams.token = $('#token').val();
	orderFormParams.isAndroidWeiXin = $('#isAndroidWeiXin').val();
	
	orderFormParams.custName = $('#userName').val();
	orderFormParams.idCardNum = $('#userCard').val();
	
	orderFormParams.originalPrice = $('#originalPrice').val();
	orderFormParams.couponMoney = $('#couponMoney').val();
	orderFormParams.manMadeMoney = orderFormParams.originalPrice;
	orderFormParams.topayMoney = $('#totalPrice').val();
	
	orderFormParams.userId = $('#userId').val();
	//orderFormParams.invoiceTitle = $('#invoiceTitle').val();
	orderFormParams.invoiceTitle = "默认为您的姓名"; //edit_by_wenh_2015_5_19
//	orderFormParams.payType = $('input[name="pay_mode"]:checked').val();
//	switch ($("input[name=pay_mode]:checked").attr("id"))  {
//         case "pay_mode_1":
//        	 orderFormParams.payMode = $('input[name="pay_mode_style"]:checked').val();
//        	 break;
//         case "pay_mode_2":
//        	 orderFormParams.payMode = $('#paySelector').val();
//        	 break;
//    }
	
	orderFormParams.deliverTypeCode = $('#deliver-select').find('a.selected').attr("value");
	orderFormParams.expressCompany = $('#post-select').find('a.selected').attr("value");
	orderFormParams.receiverName = $('#txtname').val();
	orderFormParams.phoneNum = $('#txtphone').val();
	orderFormParams.postAddr = $('#txtaddress').val();
	orderFormParams.provinceCode= $('#selProvince').val();
	orderFormParams.cityCode=$("#selCity").val();
	orderFormParams.districtCode=$("#selDistrict").val();
	
	if($('#fMonthDResId').val().length != 0 && $('#fMonthDResId').val() != "-1") {
		var fMonthDVal = $('#firstMonthFee-select').find('a.selected').attr("value");
		var fMonthD_attrVal=$('#fMonthDResId').val()+"|"+"FMONTHD"+"|"+ fMonthDVal +"|"+fMonthDVal;
		orderFormParams.resAttr = $('#attrVal').val() + '^' + fMonthD_attrVal;
		orderFormParams.goodsDisc= $('#goodsDisc').val()+ ','
			+ $('#serialNumber').val() + ',' 
			+ $('#conPeriod').val() + ',' 
			+ $('#conType').val() + ','
			+ fMonthDVal;
	} else {
		orderFormParams.resAttr = $('#attrVal').val();
		orderFormParams.goodsDisc= $('#goodsDisc').val()+ ','
			+ $('#serialNumber').val() + ',' 
			+ $('#conPeriod').val() + ',' 
			+ $('#conType').val();
	}
	
	orderFormParams.goodsId= $('#goodsId').val();
	orderFormParams.goodsName= $('#goodsName').val();
	
	orderFormParams.ctlgCode= $('#ctlgCode').val();
//	orderFormParams.originalPrice= $('#originalPrice').val();
	orderFormParams.albumId= $('#albumId').val();
	orderFormParams.verNo= $('#verNo').val();
	orderFormParams.merchantId= $('#merchantId').val();
	orderFormParams.createTime= $('#createTime').val();
	orderFormParams.createStaffId= $('#createStaffId').val();
	orderFormParams.goodsState= $('#goodsState').val();
	orderFormParams.recomTag= $('#recomTag').val();
	orderFormParams.priceRule= $('#priceRule').val();
	orderFormParams.beginTime= $('#beginTime').val();
	orderFormParams.endTime= $('#endTime').val();
	orderFormParams.simpDesc= $('#simpDesc').val();
	
	orderFormParams.unitPrice = $('#goodsPrice').val();
	orderFormParams.topayFee= $('#goodsPrice').val();
}

function upload(picId, rtnVal) {
    wx.uploadImage({
      localId: picId,
      success: function (res) {
    	  rtnVal = res.serverId;
      },
      fail: function (res) {
        alert(JSON.stringify(res));
      }
    });
  }



function uploadPic(btn){
	
	if(orderFormParams.cardPic1.length != 0
			&& orderFormParams.cardPic2 != 0) {
		//alert('照片已经上传');
		$('#netInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return;
	}
	
	$(btn).attr('disabled', true);
	
	var params = {
			"idCardNum": $('#userCard').val()
	};
	
	if($('#isAndroidWeiXin').val()) {
		var localIds = [$('#firstCard').attr("src"), $('#secondCard').attr("src")];
		var serverIds = [];
		var i=0;
		function upload() {
			   wx.uploadImage({
			     localId: localIds[i],
			     success: function (res) {
			       i++;
			       serverIds.push(res.serverId);
			       if (i < length) {
			         upload();
			       } else {
			    	   orderFormParams.cardPic1 = serverIds[0];
			   	    	orderFormParams.cardPic2 = serverIds[1];
			   	    	
			   	    	$(btn).removeAttr("disabled"); 
		        		
		        		orderStat.netInfoStat = 1;
		    			$('#netInfo').css({ "display":"none" });
		    			$('#orderMain').css({ "display":"block" });
			       }
			     },
			     fail: function (res) {
			       alert(JSON.stringify(res));
			       
			       alert('网络不给力哦,请重新上传');
	        		$(btn).removeAttr("disabled"); 
			     }
			   });
			 }
		upload();
	    
	} else {
		 $.ajaxFileUpload({
		        url : "../common/uploadFile", 
		        async:false, 
		        secureuri : false,  
		        fileElementIds : ["file-front", "file-back"],  
		        dataType : 'json',
				data: params,
		        success : function(rtdata, status) { 
		        	//alert(rtdata);
		        	if(rtdata.rspCode=='0000') {
		        		orderFormParams.cardPic1 = rtdata.fileInfoList[0].url;
		        		orderFormParams.cardPic2 = rtdata.fileInfoList[1].url;
		        		$(btn).removeAttr("disabled"); 
		        		
		        		orderStat.netInfoStat = 1;
		    			$('#netInfo').css({ "display":"none" });
		    			$('#orderMain').css({ "display":"block" });
		        		//formSubmit();
		        	} else {
		        		alert('网络不给力哦,请重新上传');
		        		$(btn).removeAttr("disabled"); 
		        	}
		        },  
		    });  
	}
};

function nextPage() {
	
	if(orderStat.netInfoStat==0) {
		alert('请完整入网资料');
		return;
	}
	if(orderStat.receiveInfoStat==0) {
		alert('请完整收货信息');
		return;
	}
//	if(orderStat.payInfoStat==0) {
//		alert('请完整支付信息');
//		return;
//	}
//	if(orderStat.otherInfoStat==0) {
//		alert('请完整其他信息');
//		return;
//	}
//	var postStyle = checkPostSelect();
//	if(postStyle !=null ){
////		alert(postStyle);
//		return;
//	}
	
//	$('#submitOrdBtn').attr('disabled', true);
//	uploadPic();
	formSubmit();
}

function formSubmit() {
	var tmp = {'fromPage':'orderFill' };
	getParams();
    var parms = $.extend({}, tmp, orderFormParams);
	
	 $.commonFormSubmit({
	        action : 'submitFilledOrder', 
	        data:  parms,
	        success : function(rtdata, status) { 
	        }
	 });  
}
