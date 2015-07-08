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
	
	
	
	   function goToPay2(){
	       var pay_type = "01";
	        var pay_mode = "15";
	        
	/*        51 能人现金可提账户支付
	        52 能人现金不可提账户支付
	        53 能人非现金账户支付*/
	        var param = [
	                     {
	                    	 "pay_order":"1", "pay_type":pay_type, "pay_mode":'15', pay_fee:$("#hide_left_money").val()
	                     },
	                     {
	                    	 "pay_order":"1", "pay_type":pay_type, "pay_mode":'51', pay_fee:$("#hide_balance").val()
	                     },
	                     {
	                    	 "pay_order":"1", "pay_type":pay_type, "pay_mode":'53', pay_fee:""
	                     }
	                     
	                     ]; 
	        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: '${base}/pay/prePayReq/${order_id}/${fee}', // 支付接口调用前预先工作
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
	        if(pay_type == '01'){
	        	url="${base}/pay/insteadPay/postData/"+$('#hide_user_id').val()+"/"+$('#hide_order_id').val()+"/"+$('#selBank').val();
	        }
	        else{
	           url = '${base}/pay/unionPay/input/${order_id}/${fee}'; //货到付款
	        }
	        
	        window.location.href = url;			    
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
				var images = ['${resRoot}/image/myacct/off.png', '${resRoot}/image/myacct/on.png'] 
				
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
	    		
	    		goToPay2();
		}
	}