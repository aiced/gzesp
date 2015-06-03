<!DOCTYPE html>
<html>
<head lang="zh-cn">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>${title}</title>
    
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/weShopLoginIndex.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
	<script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	<script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![end if]-->

	<style type="text/css">

	</style>
	


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/bankCardCheck.js?v=${resVer}"></script>
  
	<script type="text/javascript">
	
	var bRet1=true;
	var bRet2=false;
	var bRet3=false;
	var bRet4=false;
	var bRet5=false;
	var bRet6=false;
	var bRet7=false;
	
	var bRet8=false;
	var bRet9=false;
	var bRet10=false;
	var bRet11=false;
	var bRet12=false;
	var bRet13=false;
	
	var tabActive=1;//记录当前处于激活状态的 1，信用卡 2 储蓄卡
	
	//判断输入的是否是手机号
	function isPhoneNum(strPhoneNum)
	{
		if(strPhoneNum && /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|170)\d{8}$/.test(strPhoneNum)){
		    return true;//是手机号
		} else{
		    return false; //不是手机号
		}
	}
	
	
	function checkData()
	{
		if(tabActive == 1) //信用卡数据校验
		{
			if(!bRet1)
			{
				return false;
			}
			if(!bRet2)
			{
				return false;
			}
			if(!bRet3)
			{
				return false;
			}
			if(!bRet4)
			{
				alert("信用卡背面后三位不能为空");
				return false;
			}
			if(!bRet5)
			{
				return false;
			}
			if(!bRet6)
			{
				//alert("请再次输入登录密码");
				return false;
			}
			if(!bRet7)
			{
				alert("验证码不能为空");
				return false;
			}
			return true;
		}
		else if(tabActive == 2) //存储卡数据校验
		{
			if(!bRet8)
			{
				return false;
			}
			if(!bRet9)
			{
				return false;
			}
			if(!bRet10)
			{
				return false;
			}
			if(!bRet11)
			{
				return false;
			}
			if(!bRet12)
			{
				return false;
			}
			if(!bRet13)
			{
				alert("验证码不能为空");
				return false;
			}
			return true;
		}
	}
	
	function getNowDate()
	{
	  var d = new Date();
	  var vYear = d.getFullYear();
	  var vMon = d.getMonth() + 1;
	  var vDay = d.getDate();
	  var h = d.getHours(); 
	  var m = d.getMinutes(); 
	  var se = d.getSeconds(); 
	  s=vYear+(vMon<10 ? "0" + vMon : vMon)+(vDay<10 ? "0"+ vDay : vDay)+(h<10 ? "0"+ h : h)+(m<10 ? "0" + m : m)+(se<10 ? "0" +se : se);
	  return s;	
	}
	
	$(document).ready(function(){
		
		//默认先获得焦点
		//$("#txtXYname").focus();
		  //[下一步]按钮点击
/* 		  $("#btnXYSubmit").click(function(){
			//在这里操作 [下一步]按钮点击
			if(!checkData())
			{
				//数据校验错误
				return false;
			}
			else 
			{
				////数据校验正确
				//location.href='step2';
				return true;
			}	
		  }); */

    	
    	//[信用卡——姓名]文本框失去焦点
    	$("#txtXYname").blur(function(){
    		if(!$("#txtXYname").val())
    		{
		  		$("#div_txtXYname").addClass("has-error");
		  		bRet1=false;
		  		return;
    		}
    		else
    		{
		  		$("#div_txtXYname").removeClass("has-error");
		  		$("#div_txtXYname").addClass("has-success");
		  		bRet1=true;
		  		return;
    		}
    	});
    	//[信用卡——身份证号]文本框失去焦点
		  $("#txtXYPersonId").blur(function(){
		  	//在这里操作 身份证号 文本框失去焦点
		  	if(!$("#txtXYPersonId").val())
		  	{
		  		$("#div_txtXYPersonId").addClass("has-error");
		  		bRet2=false;
		  		return;
		  	}
		  	else
		  	{
	    		if(!checkEnergyCard($("#txtXYPersonId").val()))
	    		{
			  		$("#div_txtXYPersonId").addClass("has-error");
			  		bRet2=false;
	    			return;
	    		}
		  		
		  		$("#div_txtXYPersonId").removeClass("has-error");
		  		$("#div_txtXYPersonId").addClass("has-success");
	
		  		bRet2=true;
		  		return;
		  	}
		  });
    	
		//[信用卡——银行卡号]文本框失去焦点
		  $("#txtXYCardCode").blur(function(){
		  	//在这里操作 银行卡号 文本框失去焦点
		  	if(!$("#txtXYCardCode").val())
		  	{
		  		$("#div_txtXYCardCode").addClass("has-error");
		  		bRet3=false;
		  		return;
		  	}
		  	else
		  	{
	    		if (!luhmCheck($("#txtXYCardCode").val())) {
			  		$("#div_txtXYCardCode").addClass("has-error");
			  		bRet3=false;
					return;
				}
	    		
		  		$("#div_txtXYCardCode").removeClass("has-error");
		  		$("#div_txtXYCardCode").addClass("has-success");

		  		bRet3=true;
		  		return;
		  	}
		  });
	    	//[信用卡——有效期]文本框失去焦点
	    	$("#txtXYDate").blur(function(){
	    		if(!$("#txtXYDate").val())
	    		{
			  		$("#div_txtXYDate").addClass("has-error");
			  		bRet4=false;
			  		return;
	    		}
	    		else
	    		{
			  		$("#div_txtXYDate").removeClass("has-error");
			  		$("#div_txtXYDate").addClass("has-success");
			  		bRet4=true;
			  		return;
	    		}
	    	});
	    	//[信用卡——后三位]文本框失去焦点
	    	$("#txtXYCardCode3").blur(function(){
	    		if(!$("#txtXYCardCode3").val())
	    		{
			  		$("#div_txtXYCardCode3").addClass("has-error");
			  		bRet4=false;
			  		return;
	    		}
	    		else
	    		{
			  		$("#div_txtXYCardCode3").removeClass("has-error");
			  		$("#div_txtXYCardCode3").addClass("has-success");
			  		bRet4=true;
			  		return;
	    		}
	    	});
    	
			  //[信用卡——手机号]文本框失去焦点
			  $("#txtXYphonenum").blur(function(){
				  	if(!$("#txtXYphonenum").val())
				  	{
				  		$("#div_txtXYphonenum").addClass("has-error");
				  		bRet5=false;
				  		return;
				  	}
				  	else
				  	{
						var bRet=isPhoneNum($("#txtXYphonenum").val());
							
						if(!bRet)
						{
						  	alert("手机号格式不对，请重新输入。");
						  	$("#div_txtXYphonenum").addClass("has-error");
						  	bRet5=false;
						  	return;
						}
						//else if(!checkPhoneNum($("#txtXYphonenum").val()))
						//{
							//  $("#div_txtXYphonenum").addClass("has-error");
							//  bRet5=false;
							//  return;
						//}
						else
						{
					  		$("#div_txtXYphonenum").removeClass("has-error");
					  		$("#div_txtXYphonenum").addClass("has-success");
					  		bRet5=true;
					  		return;
						}
				  	}
				});
			   //[信用卡——获取验证码]按钮点击
			  $("#btnXYCode").click(function(){  
				  //在这里操作获取验证码
				  //alert("发送验证码");
				  
				  $("#hide_code_date").val(getNowDate());
				  
				  var bRet=isPhoneNum($("#txtXYphonenum").val());
					
				  if(!bRet)
				  {
				  	alert("手机号格式不对，请重新输入。");
				  	bRet6=false;
				  	return;
				  }
				  //else if(!checkPhoneNum($("#txtXYphonenum").val()))
				  //{
				//	  bRet6=false;
				//	  return;
				  //}
				  else
				  {
				  	//这里开始做验证码操作
				  	bRet6=sendMessage($("#txtXYphonenum").val(),"#btnXYCode","1");
				  	return;
				  }
			  });
			  //[信用卡——验证码]文本框失去焦点  
			  $("#XYyanzhengma").blur(function(){
			  	if(!$("#XYyanzhengma").val())
			  	{
			  		$("#div_XYyanzhengma").addClass("has-error");
			  		bRet7=false;
			  		return;
			  	}
			  	else if($("#XYyanzhengma").val()!=code)
			  	{
			  		alert("输入的验证码与短信中的验证码不匹配");
			  		$("#div_XYyanzhengma").addClass("has-error");
			  		bRet7=false;
			  		return;
			  	}
			  	else if(getNowDate() - $("#hide_code_date").val()>1800)
			  	{
			  		$("#div_XYyanzhengma").addClass("has-error");
			  		alert("验证码过期");
			  		bRet7=false;
			  		return;
			  	}
			  	else
			  	{
			  		$("#div_XYyanzhengma").removeClass("has-error");
			  		$("#div_XYyanzhengma").addClass("has-success");
			  		bRet7=true;
			  		return;
			  	}
			  }); 
			   
		    	//[存储卡——姓名]文本框失去焦点
		    	$("#txtCCname").blur(function(){
		    		if(!$("#txtCCname").val())
		    		{
				  		$("#div_txtCCname").addClass("has-error");
				  		bRet8=false;
				  		return;
		    		}
		    		else
		    		{
				  		$("#div_txtCCname").removeClass("has-error");
				  		$("#div_txtCCname").addClass("has-success");
				  		bRet8=true;
				  		return;
		    		}
		    	});
		    	
		      //[存储卡——身份证号]文本框失去焦点
			  $("#txtCCPersonId").blur(function(){
			  	//在这里操作 身份证号 文本框失去焦点
			  	if(!$("#txtCCPersonId").val())
			  	{
			  		$("#div_txtCCPersonId").addClass("has-error");
			  		bRet9=false;
			  		return;
			  	}
			  	else
			  	{
		    		if(!checkEnergyCard($("#txtCCPersonId").val()))
		    		{
				  		$("#div_txtCCPersonId").addClass("has-error");
				  		bRet9=false;
		    			return;
		    		}
			  		
			  		$("#div_txtCCPersonId").removeClass("has-error");
			  		$("#div_txtCCPersonId").addClass("has-success");
		
			  		bRet9=true;
			  		return;
			  	}
			  });
			  //[存储卡——银行卡号]文本框失去焦点
			  $("#txtCCCardCode").blur(function(){
			  	//在这里操作 银行卡号 文本框失去焦点
			  	if(!$("#txtCCCardCode").val())
			  	{
			  		$("#div_txtCCCardCode").addClass("has-error");
			  		bRet10=false;
			  		return;
			  	}
			  	else
			  	{
		    		if (!luhmCheck($("#txtCCCardCode").val())) {
				  		$("#div_txtCCCardCode").addClass("has-error");
				  		bRet10=false;
						return;
					}
		    		
			  		$("#div_txtCCCardCode").removeClass("has-error");
			  		$("#div_txtCCCardCode").addClass("has-success");

			  		bRet10=true;
			  		return;
			  	}
			  });
			  //[储蓄卡——手机号]文本框失去焦点
			  $("#txtCCphonenum").blur(function(){
				  	if(!$("#txtCCphonenum").val())
				  	{
				  		$("#div_txtCCphonenum").addClass("has-error");
				  		bRet11=false;
				  		return;
				  	}
				  	else
				  	{
						var bRet=isPhoneNum($("#txtCCphonenum").val());
							
						if(!bRet)
						{
						  	alert("手机号格式不对，请重新输入。");
						  	$("#div_txtCCphonenum").addClass("has-error");
						  	bRet11=false;
						  	return;
						}
						//else if(!checkPhoneNum($("#txtCCphonenum").val()))
						//{
						//	  $("#div_txtCCphonenum").addClass("has-error");
						//	  bRet11=false;
						//	  return;
						//}
						else
						{
					  		$("#div_txtCCphonenum").removeClass("has-error");
					  		$("#div_txtCCphonenum").addClass("has-success");
					  		bRet11=true;
					  		return;
						}
				  	}
				});
			   //[储蓄卡——获取验证码]按钮点击
			  $("#btnCCCode").click(function(){  
				  //在这里操作获取验证码
				  //alert("发送验证码");
				  
				  $("#hide_code_date").val(getNowDate());
				  
				  var bRet=isPhoneNum($("#txtCCphonenum").val());

				  if(!bRet)
				  {
				  	alert("手机号格式不对，请重新输入。");
				  	bRet12=false;
				  	return;
				  }
				  //else if(!checkPhoneNum($("#txtCCphonenum").val()))
				  //{
					//  bRet12=false;
					//  return;
				  //}
				  else
				  {
				  	//这里开始做验证码操作
				  	bRet12=sendMessage($("#txtCCphonenum").val(),"#btnCCCode","1");
				  	return;
				  }
			  });
			  //[信用卡——验证码]文本框失去焦点  
			  $("#CCyanzhengma").blur(function(){
			  	if(!$("#CCyanzhengma").val())
			  	{
			  		$("#div_CCyanzhengma").addClass("has-error");
			  		bRet13=false;
			  		return;
			  	}
			  	else if($("#CCyanzhengma").val()!=code)
			  	{
			  		alert("输入的验证码与短信中的验证码不匹配");
			  		$("#div_CCyanzhengma").addClass("has-error");
			  		bRet13=false;
			  		return;
			  	}
			  	else if(getNowDate() - $("#hide_code_date").val()>1800)
			  	{
			  		$("#div_CCyanzhengma").addClass("has-error");
			  		alert("验证码过期");
			  		bRet13=false;
			  		return;
			  	}
			  	else
			  	{
			  		$("#div_CCyanzhengma").removeClass("has-error");
			  		$("#div_CCyanzhengma").addClass("has-success");
			  		bRet13=true;
			  		return;
			  	}
			  }); 
			  
			  
				//判断选中的是哪个标签页
				$("li").click(function () {
			        if($(this).text()=="信用卡")
			        {
			        	tabActive=1;
			           	//window.setTimeout (function(){ document.getElementById ('txtXYname'). select();},0 ); 

			        }
			        if($(this).text()=="储蓄卡")
			        {
			        	tabActive=2;
			        	//window.setTimeout (function(){ document.getElementById ('txtCCname'). select();},0 );

			        }
			    });
			  

			  

	});
	
        function unionPayPay(card_type){
        	
        	if (!checkData())
        	{
        		return;
        	}
            //01信用卡 02 储蓄卡
            var param;
            if(card_type == '01'){
              param = {"order_id":${order_id}, "fee":${fee}, "card_type":card_type, bank_card_no:$('#txtXYCardCode').val(), 
                           bank_card_expire_date:$('#txtXYDate').val(), bank_card_cvn:$('#txtXYCardCode3').val(), 
                           id_card_no:$('#txtXYPersonId').val(), phone_no:$('#txtXYphonenum').val(), full_name:$('#txtXYname').val()};
            }
            else{
              param = {"order_id":${order_id}, "fee":${fee}, "card_type":card_type, bank_card_no:$('#txtCCCardCode').val(), 
                           id_card_no:$('#txtCCPersonId').val(), phone_no:$('#txtCCphonenum').val(), full_name:$('#txtCCname').val()};            
            }
            //弹出gif动画，支付中请等待
            $('#paying').modal({
               keyboard: false,
               backdrop: 'static'
            }) ;            
	
	        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/pay/unionPay/payNew", // 全要素支付接口路径 /unionPay/payNew
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
			    $('#paying').modal('toggle'); //关闭gif
			    //alert(data.detail);
			    //修改支付结果 失败的时候显示 选择其他方式支付 按钮，成功的时候显示 查询订单 和 再去逛逛 2个按钮
			    if(data.status == '00'){
			      $('.modal-title').html('支付成功');
			      $('#btn_other').hide();
			      $('#btn_qry').show();
			      $('#btn_home').show();
			    }else{
			      $('.modal-title').html('支付失败');
			      $('#btn_other').show();
			      $('#btn_qry').hide();
			      $('#btn_home').hide();
			      //$('#payResultTip').html('亲，由于银联通道故障，此订单失败作废，请重新下单并换其他银行卡支付，造成不便，请谅解'); 
			    }
			    $('#payResultDetail').html(data.status + ':' + data.detail); //修改支付状态和支付结果描述
			    //弹出支付结果框
			    $('#payResult').modal({
                  keyboard: false,
                  backdrop: 'static'
                }) ;            
		      }
		    });
        }		
	</script>
</head>

<body>
	<div>
    	<!--top_start-->
	    <div id="top">
	      <div id="top_left">
	        <a href="javascript:history.back(-1);">
	          <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
	        </a>
	      </div>
	      <div id="top_middle">${title}</div>
	      <div id="top_right"></div>
	    </div>   
		<!--top_end-->
		<br/>
		<div role="tabpanel">
			<!-- Nav tabs -->
			<ul class="nav nav-tabs" role="tablist">
				<li role="presentation" class="active"><a href="#xinyongka" aria-controls="xinyongka" role="tab" data-toggle="tab">信用卡</a></li>
				<li role="presentation"><a href="#chuxuka" aria-controls="chuxuka" role="tab" data-toggle="tab">储蓄卡</a></li>
			</ul>
			<!-- 用于校验验证码失效时间 -->
		 	<input type="hidden" value='' id="hide_code_date" name="hide_code_date">
			<!-- Tab panes -->
			<div class="tab-content">
				<div role="tabpanel" class="tab-pane active" id="xinyongka">
					<br/>
					<div class="container-fluid">
						<form>
							<!--输入姓名-->
							<div class="input-group-lg" id="div_txtXYname">
								<label for="txtXYname" class="sr-only"></label>
								<input type="text" class="form-control" id="txtXYname" name="txtXYname" placeholder="请输入姓名">
							</div>
							<br/>
							<!--输入身份证号-->
							<div class="input-group-lg" id="div_txtXYPersonId">
								<label for="txtXYPersonId" class="sr-only"></label>
								<input type="text" class="form-control" id="txtXYPersonId" placeholder="请输入身份证号">
							</div>
							<br/>
							<!--输入卡号-->
							<div class="input-group-lg" id="div_txtXYCardCode">
								<label for="txtXYCardCode" class="sr-only"></label>
								<input type="text" class="form-control" id="txtXYCardCode" placeholder="请输入卡号">
							</div>
							<br/>
							<!--输入背面三位数-->
							<div class="form-group-lg" id="div_txtXYCardCode3">
								<label for="txtXYCardCode3" class="sr-only"></label>
								<input type="text" class="form-control" id="txtXYCardCode3" placeholder="请输入背面三位数">
							</div>
							<br/>
							<!--输入有效期-->
							<div class="form-group-lg" id="div_txtXYDate">
								<label for="txtXYDate" class="sr-only"></label>
								<input type="text" class="form-control" id="txtXYDate" placeholder="信用卡有效期年份月份如:1504" >
							</div>
							<br/>
							<!--输入手机号-->
							<div class="form-group-lg" id="div_txtXYphonenum">
							    <label for="txtXYphonenum" class="sr-only"></label>
								<input type="text" class="form-control" id="txtXYphonenum"aria-describedby="txtXYnum" placeholder="请输入银行预留手机号">
							</div>
							<br/>
							<!-- 短信验证码-->
							<div class="form-group-lg">
								<div class="row">
									<div class="col-xs-6 col-sm-6">
										<div class="form-group" id="div_XYyanzhengma">
											<label for="XYyanzhengma" class="sr-only"></label>
								            <input type="text" class="form-control" id="XYyanzhengma" placeholder="输入验证码">
										</div><!-- /input-group -->
									</div>
									<div class="col-xs-6 col-sm-6">
										<button class="btn btn-primary btn-block form-control" type="button" id="btnXYCode">获取验证码</button>
									</div>
								</div>
							</div>														
							<button class="btn btn-lg btn-warning btn-block" type="button" id="btnXYSubmit" onclick="unionPayPay('01')">确认支付</button>
						</form>
					</div>
					<br/>
					<br/>
				</div>
				<div role="tabpanel" class="tab-pane" id="chuxuka">
					<br/>
					<div class="container-fluid">
						<form>
							<!--输入姓名-->
							<div class="input-group-lg" id="div_txtCCname">
								<label for="txtCCname" class="sr-only"></label>
								<input type="text" class="form-control" id="txtCCname" placeholder="请输入姓名">
							</div>
							<br/>
							<!--输入身份证号-->
							<div class="input-group-lg" id="div_txtCCPersonId">
								<label for="txtCCPersonId" class="sr-only"></label>
								<input type="text" class="form-control" id="txtCCPersonId" placeholder="请输入身份证号">
							</div>
							<br/>
							<!--输入卡号-->
							<div class="input-group-lg" id="div_txtCCCardCode">
								<label for="txtCCCardCode" class="sr-only"></label>
								<input type="text" class="form-control" id="txtCCCardCode" placeholder="请输入卡号">
							</div>
							<br/>
							<!--银行预留手机号 -->
							<div class="form-group-lg" id="div_txtCCphonenum">
								<label for="txtCCphonenum" class="sr-only"></label>
								<input type="text" class="form-control" id="txtCCphonenum" placeholder="请输入银行预留手机号">
							</div>
							<br/>	
							<!--输入验证码-->
							<div class="form-group-lg" id="div_CCyanzhengma">
								<div class="row">
									<div class="col-xs-6 col-sm-6">
										<div class="form-group">
											<input type="text" class="form-control" id="CCyanzhengma" placeholder="输入验证码">
										</div><!-- /input-group -->
									</div>
									<div class="col-xs-6 col-sm-6">
										<button class="btn btn-primary btn-block form-control" type="button" id="btnCCCode">获取验证码</button>
									</div>
								</div>
							</div>
							<button class="btn btn-lg btn-warning btn-block " type="button" onclick="unionPayPay('02')">确认支付</button>
						</form>
					</div>
				</div>
			</div>
		
		</div>
	</div>

    <!-- 正在支付弹出框 -->    
    <div id="paying" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content" style="padding:5px;height:200px;text-align:center">
            <img src="${resRoot}/image/paying.gif" alt="" />
        </div>
      </div>
    </div>
    <!-- 支付结果弹出框 -->    
    <div id="payResult" class="modal fadebs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">支付结果</h4>
          </div>
          <div class="modal-body">
            <p id="payOrderInfo">订单编号：${order_id}，金额：${(fee?number/1000)?string('#.##')}元</p>
            <p id="payResultDetail" ></p>
            <#-- <p id="payResultTip" style="color:red"></p> -->
          </div>
          <div class="modal-footer">
            <a id="btn_other" class="btn btn-warning" href="${base}/pay/selectPayMode/${order_id}/${fee}" role="button">选择其他支付方式</a>
            <#--<a id="btn_other" class="btn btn-warning" href="${base}/pay/goToWeShopIndex/${order_id}" role="button">重新购买</a>-->
            <a id="btn_qry" class="btn btn-warning" href="${base}/customer/custOrderQuery" role="button">订单查询</a>
            <a id="btn_home" class="btn btn-warning" href="${base}/pay/goToWeShopIndex/${order_id}" role="button">再去逛逛</a>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->    
           
</body>
</html>
