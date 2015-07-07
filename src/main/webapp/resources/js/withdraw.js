    function leftClick(param)
    {
		window.location.href='/esp/shopManage/acct/myAcct/'+$("#hide_user_id").val();
    }
    
	function doClick(param)
	{
		//alert($(param)[0].tagName);
		//var id=$(param).attr("id");
		//var a=$("#"+id+" :input").attr("checked","checked");
		
		var txt=$("input[name='optionsRadios']:checked").next("label").text();
		if (txt.indexOf("信用卡") > 0 ) {
			alert("不支持信用卡提现，如没有绑定其他储蓄卡，请先绑定储蓄卡再次进行提现！");
			return;
		}
		
		$("#span_modal").html($("input[name='optionsRadios']:checked").next("label").text());
		
	}

	function doBlur(param)
	{
		var reg = /^\d*$/;
		if(!reg.test($(param).val()))
		{
			iRet=11;
	  		return opReturn(iRet);
		}
		iRet=00;
		return opReturn(iRet);
	}
	
	
	function checkData()
	{
		if (!$("#txtbalance").val()) {
			iRet=12;
	  		return opReturn(iRet);
		}
		
		var reg = /^\d*$/;
		if(!reg.test($("#txtbalance").val()))
		{
			iRet=11;
	  		return opReturn(iRet);
		}
		
		if ($("#txtbalance").val()>$("#hide_balance").val()) {
			iRet=13;
	  		return opReturn(iRet);
		}
		
		iRet=00;
		return opReturn(iRet);
	}
	
	//返回错误码：
	//默认：-1
	//00：成功！
	//11：金额必须是数字
	//12：金额不能为空
	//13：提取金额必须小于余额
	//21:请选择银行卡
	var bRet=-1;
	function opReturn(iRet)
	{
		switch (iRet) {
		case 00:
			//alert("操作成功！");
			return true;
		case 11:
			alert("持卡人不能为空!");
			return false;
		default:
			return false;
		}
	}
	
	
    function goToPay2(){
        /*var pay_type = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
        var pay_mode;
        var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
           //alert(pay_mode_style);
           if(pay_mode_style == "微信支付"){
             pay_mode = '30';
           }
           else if(pay_mode_style == "沃支付"){
             pay_mode = '40';
           }
           else if(pay_mode_style == "银联支付"){
             pay_mode = '15'; //此刻无法区分信用卡和储蓄卡
           }
        var param = [{"pay_order":"1", "pay_type":pay_type, "pay_mode":pay_mode, pay_fee:${fee}}]; 
        $.ajax({
	      type: "POST",
	      contentType:"application/json", //发送给服务器的内容编码类型
	      url: '${base}/pay/prePayReq/${order_id}/${fee}', // 支付接口调用前预先工作
	      dataType:"json", //预期服务器返回的数据类型
	      data: JSON.stringify(param), //服务器只能接收json字符串
	      success: function(data){
        if(pay_type == '01'){
           if(pay_mode_style == "微信支付"){
             url = '${base}/pay/wxPay/prepay_step1/${order_id}/${fee}?state='+ encodeURIComponent('${goods_name}'); //微信支付
           }
           else if(pay_mode_style == "沃支付"){
             url = '${base}/pay/wopay/orderPost/${order_id}/${fee}'; //沃支付
           }
           else if(pay_mode_style == "银联支付"){
             url = '${base}/pay/unionPay/input/${order_id}/${fee}'; //银联支付
           }
        }
        else{
           url = '${base}/pay/unionPay/input/${order_id}/${fee}'; //货到付款
        }
        
        window.location.href = url;			    
	      }
	    });      */      

    } 
	
	
	
	
	
	
	function doSubmit(param)
	{
		if (!checkData()) {
			return;
		}
		goToPay2();
	}
	
	
	