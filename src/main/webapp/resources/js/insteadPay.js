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
		else if ($(param1).val().length==6) {
			$(param2).focus();
			$(param1).select();
			param1.setSelectionRange(0,0);
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
       var pay_orderindex=0;//默认是0 1 代金券 2 账户 3 银行卡支付
       var flag="000";//从左往右 第一位代金券是否使用 第二位账户是否使用 第三位银行卡
       var strcoupon;//记录代金券参数
       var stracct;//记录账户参数
       var strorder;//记录银行卡支付参数

		var str=$("#lab_left_money").html();
		var str_left_money=str.substring(5);
       
       var sb = new StringBuilder();

//代金券预留——不要删除
//       if(是否使用代金券：使用)
//       {
//    	   	pay_orderindex=pay_orderindex+1;      
//       	strcoupon='"pay_order":'+pay_orderindex+', "pay_type":01, "pay_mode":60, pay_fee:1, coupon_id:12345678';
//       }
       sb.append("[");
       if ($("#imgswitch").attr("class")=="on") //使用账户
       {
    	   pay_orderindex=pay_orderindex+1;
    	   if ($("#hide_left_money").val()>0) //账户的钱不足 fee 直接传递账户的数值全部使用
    	   {
    		   stracct='"pay_order":"'+pay_orderindex+'", "pay_type":"01", "pay_mode":"51", "pay_fee":"'+$("#hide_balance").val()+'"';
    		   flag="011"; //不用代金券 用账户 用银行卡
    		   sb.append("{"+stracct+"}");
    	   }
    	   else    //账户的钱足够 fee 直接传递商品的价格
    	   {
    		   stracct='"pay_order":"'+pay_orderindex+'", "pay_type":"01", "pay_mode":"51", "pay_fee":"'+$("#hide_topay_money").val()+'"';
    		   flag="010"; //不用代金券 用账户 不用银行卡
    		   sb.append("{"+stracct+"}");
    	   }
       } 
       //"pay_order":"3", "pay_type":01, "pay_mode":10, pay_fee:3, bank_no:1234567
       if (flag=="011") //不用代金券 用账户 用银行卡
       {
    	   pay_orderindex=pay_orderindex+1;
    	   strorder='"pay_order":"'+pay_orderindex+'", "pay_type":"01", "pay_mode":"10", "pay_fee":"'+str_left_money+'", "bank_no":"'+$('#selBank').val()+'"'
   		   sb.append(",{"+strorder+"}");
       }
       else if(flag=="010")//不用代金券 用账户 不用银行卡
       {
    	   
       }
       else //不用代金券 不用账户 用银行
       {
    	   pay_orderindex=pay_orderindex+1;
    	   strorder='"pay_order":"'+pay_orderindex+'", "pay_type":"01", "pay_mode":"10", "pay_fee":"'+str_left_money+'", "bank_no":"'+$('#selBank').val()+'"'
   		   sb.append("{"+strorder+"}");
       }
       sb.append("]");  
       console.log(sb.toString());
       var param=sb.toString();
        $.ajax({
	      type: "POST",
	      contentType:"application/json", //发送给服务器的内容编码类型
	      url: '/esp/pay/insteadPay/postData/'+$('#hide_user_id').val()+"/"+$('#hide_order_id').val(), // 支付接口调用前预先工作
	      dataType:"json", //预期服务器返回的数据类型
	      data: param, //服务器只能接收json字符串
	      success: function(data){
	    	alert(data);
	        if(pay_type == '01'){
	        	url="${base}/pay/insteadPay/postData/"+$('#hide_user_id').val()+"/"+$('#hide_order_id').val();
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
			case 1: //代金券
				alert("敬请期待～");
				break;
			case 2://是否使用账户按钮
				var images = ['/esp/resources/image/myacct/off.png', '/esp/resources/image/myacct/on.png'] 
				
				if($(param).attr("class")=="off") //关闭
				{ 
					if ($("#hide_balance").val()==0) {
						alert("您的账户余额为0！");
						return;
					}
					
					
					$(param).attr("src",images[1]); 
					$(param).removeClass(); 
				
					$("#lab_left_money").html("还需支付￥"+(($("#hide_topay_money").val()-$("#hide_balance").val())<0?0:($("#hide_topay_money").val()-$("#hide_balance").val())));
				}
				else //打开
				{ 
					$(param).attr("src",images[0]); 
					$(param).removeClass(); 
					$(param).addClass("off"); 
					$("#lab_left_money").html("还需支付￥"+$("#hide_topay_money").val());
				} 
				break;
			case 3:
				var str=$("#lab_left_money").html();
				var str_left_money=str.substring(5);
				if ($("#selBank").val() == "请选择开户银行" && str_left_money!=0)
				{
					alert("请选择开户银行");
					$(".div_container button").attr("data-target","");
				}
				else
				{
					$(".div_container button").attr("data-target","#myModal");
				}
				break;
			case 4: //弹出框 确定按钮
				$("#btnok").attr('disabled',"true");
	    		if ($('#txtsecuritypwd').val().length!=6)
	    		{
	    			alert("请输入6位安全密码！");
	    			$("#btnok").removeAttr("disabled");
	    			return;
	    		}

	    		//判断输入的密码是否正确
				var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtsecuritypwd').val()};
				$.ajax({
				 type: "POST",
				 url: '/esp/shopManage/acct/myBankCardList/checkPwd',
				 data: parms,
				 success: function(data){
					if(!data)
					{
						alert("输入密码有误，请重新输入！");
						clearTextVal();
						$("#btnok").removeAttr("disabled");
						window.location.href='/esp/pay/insteadPay/'+$("#hide_user_id").val()+"/"+$('#hide_order_id').val();
						//return 
					}
					goToPay2();
					//window.location.href='/esp/shopManage/acct/addBankCardInput1/'+$("#hide_user_id").val();
				 }
				});
				break;
		}
	}