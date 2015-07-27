	function leftClick(param)
	{
		window.location.href='/esp/order/fillOrderMain';
	}
	
	function checkData(param1,param2)
	{
		var reg = /^\d*$/;
		if(!reg.test($(param1).val()))
		{
			alert("密码只能是数字");
			$(param1).val("");
			return false;
		}
		else
		{
			$(param2).focus();
			return true;
		}
	}
	function clearTextVal()
	{
		for (var i = 1; i < 7; i++) {
    		$("#txt"+i).val("");
		}
	}
	
	function doFocus(param)
	{
		$(param).val("");
	}
	
	
	var acct_flag=1; //初始值 1 ：使用账户 0： 不使用账户
	var coupon_falg=0;//初始值1：使用代金券 0：不使用代金券
	var order_flag=1; //初始值1：银行卡支付 0:不用银行卡支付
	
    function goToPay2(){
       var pay_type = "01";
       var pay_mode = "15";
       
       
       
       
       
       var param = [
                     {
                    	 "pay_order":"3", "pay_type":pay_type, "pay_mode":'10', pay_fee:$("#hide_left_money").val(),bank_no:$('#selBank').val()
                     },
                     {
                    	 "pay_order":"2", "pay_type":pay_type, "pay_mode":'51', pay_fee:$("#hide_balance").val()
                     }/*,
                     {
                    	 "pay_order":"1", "pay_type":pay_type, "pay_mode":'53', pay_fee:"" 代金券
                     }
                     */
                     ]; 
        $.ajax({
	      type: "POST",
	      contentType:"application/json", //发送给服务器的内容编码类型
	      url: '${base}/pay/insteadPay/postData/'+$('#hide_user_id').val()+"/"+$('#hide_order_id').val(), // 支付接口调用前预先工作
	      dataType:"json", //预期服务器返回的数据类型
	      data: JSON.stringify(param), //服务器只能接收json字符串
	      success: function(data){
	    	  
	    	alert(data);
/*		        if(pay_type == '01'){
		        	url="${base}/pay/insteadPay/postData/"+$('#hide_user_id').val()+"/"+$('#hide_order_id').val()+"/"+$('#selBank').val();
		        }
		        else{
		           url = '${base}/pay/unionPay/input/${order_id}/${fee}'; //货到付款
		        }
		        window.location.href = url;		*/	    
	      }
	    });  
    } 
	//
	//1:代金券点击
	//2:微账户点击
	//3：确认支付点击
	//4:弹出框点击确定
	function doClick(param,flag)
	{
		switch(flag)
		{
			case 1:
				alert("敬请期待～");
				break;
			case 2:
				var images = ['/esp/resources/image/myacct/off.png', '/esp/resources/image/myacct/on.png'] 
				
				if($(param).attr("class")=="off") //关闭
				{ 
					$(param).attr("src",images[1]); 
					$(param).removeClass(); 
				
					$("#lab_left_money").html("还需支付￥"+($("#hide_topay_money").val()-$("#hide_balance").val()));
				}
				else //打开
				{ 
					$(param).attr("src",images[0]); 
					$(param).addClass("off"); 
					$("#lab_left_money").html("还需支付￥"+$("#hide_topay_money").val());
				} 
				break;
			case 3:
				break;
			case 4: //弹出框 确定按钮
	    		var txtpwd="";
	    		for (var i = 1; i < 7; i++) {
	    			txtpwd=txtpwd+$("#txt"+i).val();
				}
	    		if (txtpwd.length!=6)
	    		{
	    			alert("请输入6位支付密码！");
	    			return;
	    		}

	    		//判断输入的密码是否正确
				var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':txtpwd};
				$.ajax({
				 type: "POST",
				 url: '/esp/shopManage/acct/myBankCardList/checkPwd',
				 data: parms,
				 success: function(data){
					if(!data)
					{
						alert("输入密码有误，请重新输入！");
						clearTextVal();
						window.location.href='/esp/pay/insteadPay/'+$("#hide_user_id").val()+"/"+$('#hide_order_id').val();
						//return 
					}
					//goToPay2();
					//window.location.href='/esp/shopManage/acct/addBankCardInput1/'+$("#hide_user_id").val();
				 }
			});
		}
	}