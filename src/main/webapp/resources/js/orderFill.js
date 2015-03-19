
//var ordResInfo = {
//		resId:"",
//		resAttrCode:"",
//		resAttrVal:""
//}

//var ordResArr=new Array();

//var ordResInfo = new Object();
//ordResInfo.resId = "";
//ordResInfo.resAttrCode = "";
//ordResInfo.resAttrVal = "";
//ordResArr.push(ordResInfo);

var orderStat = {
		netInfo:0,
		netInfo:0,
		netInfo:0,
		netInfo:0,
		netInfo:0
}

var orderFormParams = {
		orderFrom:"weixin微信",
		originalPrice:"",
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
		devlpId:"",
		devlpName:"",
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
		
		goodsId:"",
		goodsName:"",
		unitPrice:"",
		saleNum:"",
		topayFee:"",
		derateFee:"",
		derateReason:"",
		recvFee:"",
		
		resAttr:""
};


$(function() {
	
	$('#netInfoTab').bind("click",function(){
  	  $('#netInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
  	  return false;
    });
	$('#receiveInfoTab').bind("click",function(){
		$('#receiveInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
		return false;
	});
	$('#payInfoTab').bind("click",function(){
		$('#payInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
		return false;
	});
	$('#otherInfoTab').bind("click",function(){
		$('#otherInfo').css({ "display":"block" }).siblings().css({ "display":"none" });
		return false;
	});
	
	//子页确认事件
	$('#netInfoBtn').bind("click",function(){
		if(saveClick()) {
			$('#netInfo').css({ "display":"none" });
			$('#orderMain').css({ "display":"block" });
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
	$('#payInfoBtn').bind("click",function(){
		$('#payInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	$('#payInfoBackBtn').bind("click",function(){
		$('#payInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	$('#otherInfoBtn').bind("click",function(){
		if(otherOrder_checkData()) {
			$('#otherInfo').css({ "display":"none" });
			$('#orderMain').css({ "display":"block" });
		}
		return false;
	});
	$('#otherInfoBackBtn').bind("click",function(){
		$('#otherInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	
	//配送方式
	$('#deliver-select a').bind("click",function(){
  	  $(this).addClass("selected").siblings().removeClass("selected");
  	  return false;
    });
	
	//物流选择
	$('#post-select a').bind("click",function(){
		$(this).addClass("selected").siblings().removeClass("selected");
		return false;
	});
	
	
	//选择文件
	$("input[type='file']").change(function(evt){
	    if(evt.target.files.length == 0){
	        return;
	    }
//	    $(".mask").show().height($(document).height());
	    var f = evt.target.files[0], $this = $(this), type = this.value.substr(this.value.lastIndexOf(".")).toLowerCase() ,type2 = f.type;
	    if(type2==""){
//	        $(".mask").show().height($(document).height());
//	        $(".img-select-wrong").show().vCenter();
	        return;
	    }
	    //选择的图片非bmp、jpg、jpeg时，清空文件选择，展示提示框
	    if(!(type == ".jpg" || type == ".bmp" || /^image\/(jpeg|jpg|bmp)$/.test(type2))){
	        return;
	    }
	    var reader = new FileReader();
	    $(reader).load(function() {
	    	 var dataURL = this.result;
	    	 var preview = $this.siblings("img");
	    	 preview.attr("src", dataURL);
	    });
	    //读取文件的缓冲数组流，读取完毕后执行onload
	    reader.readAsDataURL(f);
	});
	
	
})

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
	}
	if(!$("#txtaddress").val())
	{
		alert("请填写详细地址");
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

function getParams() {
	orderFormParams.custName = $('#userName').val();
	orderFormParams.idCardNum = $('#userCard').val();
//	orderFormParams.idCardPicUp = $('#firstCard').attr("src").val();
//	orderFormParams.idCardPicDown = $('#secondCard').attr("src").val();

	 
	
	var ordResArr=new Array();
	var ordResInfo = new Object();
	ordResInfo.resId = "1";
	ordResInfo.resAttrCode = "颜色";
	ordResInfo.resAttrVal = "红色";
//	ordResArr.push($.toJSON(ordResInfo));
	ordResArr.push(ordResInfo);
	
	ordResInfo = new Object();
	ordResInfo.resId = "2";
	ordResInfo.resAttrCode = "重量";
	ordResInfo.resAttrVal = "100g";
	ordResArr.push(ordResInfo);
	
	orderFormParams.resAttr = ordResArr;
}


function nextPage() {
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
