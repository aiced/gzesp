
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
	
	$('#netInfoBtn').bind("click",function(){
		saveClick(null);
		$('#netInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	$('#receiveInfoBtn').bind("click",function(){
		$('#receiveInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	$('#payInfoBtn').bind("click",function(){
		$('#payInfo').css({ "display":"none" });
		$('#orderMain').css({ "display":"block" });
		return false;
	});
	$('#otherInfoBtn').bind("click",function(){
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
//	        $(".mask").show().height($(document).height());
//	        $(".upload-wrongImg").show().vCenter();
//	        //清空file
//	        $this.wrap('<form>').closest('form').get(0).reset();
//	        $this.unwrap();

//	        inputFile = $this;
	        return;
	    }
	    var reader = new FileReader();
	    $(reader).load(function() {
	    	 var dataURL = this.result;
	    	 var preview = $this.siblings("img");
	    	 preview.attr("src", dataURL);
	    });
//	    reader.onload = (function (f) {
//	        return function (e) {
//
//	            //获取照片的URL对象（base64）
//	            var dataURL = e.target.result;
//	            var preview = $this.siblings("img.upload-imgs");
//
//	            //创建Image对象
//	            var image = new Image();
//	            image.src = dataURL;
//
//	            image.onload = function() {
//	                var resized = resizeMe(image);
//	                //删除原来的图片
//	                $this.siblings(".upload-files").remove();
//	                var newinput = $("<input>");
//	                //将canvas的返回结果(base64的图片数据)放到新建的input中
//	                newinput.attr("type", "text").attr("style","display:none")
//	                    .attr("value", resized).attr("class", "upload-files")
//	                    .attr("id", $this.attr("id")+"2");
//	                $this.parent().append(newinput);
//	                //预览图片
//	                preview.attr("src", resized);
//
////	                var imgIcon = $this.parent(".img-w");
////	                imgIcon.find(".camera").hide();
////	                imgIcon.find(".camera-edit").show();
////	                imgIcon.find(".watermark").show();
////	                $this.attr("suc",true);
////	                $(".mask").hide();
////	                $this.wrap('<form>').closest('form').get(0).reset();
////	                $this.unwrap();
//	            }
//	        };
//	    })(f);
	    //读取文件的缓冲数组流，读取完毕后执行onload
	    reader.readAsDataURL(f);
	});
	
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
	//wenhui_newReceiveAddress_确定按钮
	$("#receiveInfoBtn").click(function(){
		if(!addres_checkData())
		{
			return false;
		}
		else {
			return true;
		}
	});
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
	//wenhui_otherOrderInfo_确定按钮
	$("#otherInfoBtn").click(function(){
		if(!otherOrder_checkData())
		{
			return false;
		}
		else {
			return true;
		}
	});
})

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
