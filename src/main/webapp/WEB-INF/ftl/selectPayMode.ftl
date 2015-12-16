<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <title>${title}</title>

    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/myacct.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/modaldialogStyle.css?v=${resVer}" rel="stylesheet">    
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>    
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    
    <style type="text/css">
    body{
      background-color:#eeedeb;
    }
    
    .font-song-bold-16
    {
	  font-family: 'NSimSun';
      font-size: 16px;
      font-weight: bold;
    }
    .font-song-bold-14
    {
	  font-family: 'NSimSun';
      font-size: 14px;
      font-weight: bold;
    }    
    .font-song-12
    {
	  font-family: 'NSimSun';
      font-size: 13px;
    }    
    .div_line
    {
       background: #cccccc;
       margin: 10px;
       height: 1px;
    }
    </style>

    <script type="text/javascript">
        $(function(){
            showPayMode();
            $("input[name=pay_mode]").click(function(){
                showPayMode();
            });

            
        });
        function showPayMode()
        {
            switch ($("input[name=pay_mode]:checked").attr("id"))
            {
                case "pay_mode_1":
                    $("#pay_mode_1_detail").show();
                    $("#pay_mode_2_detail").hide();
                    break;
                case "pay_mode_2":
                    $("#pay_mode_1_detail").hide();
                    $("#pay_mode_2_detail").show();
                    break;
                default:
                    break;
            }
        }
        //当选中微帐户支付时，校验账户余额是否足以支付商品应付价格，在进入后台后还会校验一次
        function checkAcctBalance()
        {
               if($('#hide_topay_money').val() > $('#hide_balance').val()){
                  //$('#acctpay').removeAttr("checked"); //取消选中微帐户支付
                  //$('input[name=pay_mode_style]:eq(1)').attr('checked', 'checked'); //默认选择银联支付
                  return false;
               }
               
               return true;
        }      
          
        function goToPay(){
	        var url;
            var pay_mode = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
	        //alert(pay_mode);
            if(pay_mode == '01'){
               var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
               //alert(pay_mode_style);
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
        //点击确定支付按钮触发
        function goToPay2(){
            var pay_mode;
            var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
               //alert(pay_mode_style);
               if(pay_mode_style == "微信支付"){
                 pay_mode = '30';
                 itfPay(pay_mode_style, pay_mode);
               }
               else if(pay_mode_style == "沃支付"){
                 pay_mode = '40';
                 itfPay(pay_mode_style, pay_mode);
               }
               else if(pay_mode_style == "银联支付"){
                 pay_mode = '15'; //此刻无法区分信用卡和储蓄卡
                 itfPay(pay_mode_style, pay_mode);
               }
               else if(pay_mode_style == "微帐户支付"){
                 pay_mode = '51'; //能人现金可提账户支付
                 if(checkAcctBalance()){
                   popPwdModel();
                 } //检查账户余额是否够，不严谨，应该从调接口实时查询
                 else{
                   alert('账户余额不足，请选择其他支付方式！');
                 }
               }
            
  
        }
        //选择微帐户支付，点确定，弹出密码输入模态框
        function popPwdModel(){
           //$(".div_container button").attr("data-target","#myModal"); //弹出密码输入模态框
			    $('#myModal').modal({
                  keyboard: false,
                  backdrop: 'static'
                }) ;  
        }  
        //微帐户支付，模态框里密码输入后点确定，不需要调用接口
        function acctPay(){
				$("#btnok").attr('disabled',"true");
	    		if ($('#txtsecuritypwd').val().length!=6)
	    		{
	    			alert("请输入6位安全密码！");
	    			$("#btnok").removeAttr("disabled");
	    			return;
	    		}

                //参数
                var pay_type = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
                var pay_mode = '51';
				var param = {"user_id":$('#hide_user_id').val(), "user_pwd":$('#txtsecuritypwd').val(),
				             "pay_order":"1", "pay_type":pay_type, "pay_mode":pay_mode, pay_fee:${fee}
				             };
            
				$.ajax({
				 type: "POST",
				 contentType:"application/json", //发送给服务器的内容编码类型
				 url: '/esp/shopManage/acctPay/${order_id}/${fee}',
				 dataType:"json", //预期服务器返回的数据类型
				 data: JSON.stringify(param), //服务器只能接收json字符串,
				 success: function(data){
				    //$('#paying').modal('toggle'); //不管支付结果返回成功失败都关闭gif
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
			      
			      clearTextVal(); //清空密码输入框
				  $("#btnok").removeAttr("disabled"); //防止重复支付
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
        //除微帐户支付外其他支付需要调用接口    
        function itfPay(pay_mode_style, pay_mode){
            var pay_type = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
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
		    });        
        }  
        function testWeiXinPay(){
	        var url;
            var pay_mode = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
	        //alert(pay_mode);
            if(pay_mode == '01'){
               var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
               url = '${base}/pay/wxPay/prepay_step1/${order_id}/10?state='+ encodeURIComponent('${goods_name}'); //微信支付
            }
            
	        window.location.href = url;  
        }  
        function testWoPay(){
	        var url;
            var pay_mode = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
	        //alert(pay_mode);
            if(pay_mode == '01'){
               var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
               url = '${base}/pay/wopay/orderPost/${order_id}/${fee}'; //沃支付
            }
            
	        window.location.href = url;        
        } 
    //检查密码是否正确
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
		//for (var i = 1; i < 7; i++) {
    	//	$("#txt"+i).val("");
		//}
		$("#txtsecuritypwd").val("");
	}
	
	function doFocus(param)
	{
		$(param).val("");
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
		
		<!-- 选择支付方式-->
        <div class="container-fluid">
          <div class="row" style="margin:15px 10px 0px 10px;">
            <span class="font-song-bold-16">选择支付方式</span>
          </div>
        
          
          <!-- 选择在线支付还是 货到付款-->
          <div class="row" style="margin:15px 10px 0px 20px;">
                <label class="radio-inline">
                    <input type="radio" name="pay_mode" id="pay_mode_1" value="01" checked="checked" data-text="在线支付">
                    <span class="font-song-bold-14">在线支付</span>
                </label>
                <label class="radio-inline">
                    <input type="radio" name="pay_mode" id="pay_mode_2" value="02" data-text="货到付款" disabled>
                    <span class="font-song-bold-14">货到付款</span>
                </label>
          </div>
          <div class="row" id="pay_mode_1_detail" style="margin:5px 10px 10px 20px;">
             <span class="font-song-12">支持信用卡、储蓄卡、微信支付</span>
          </div>
          <div class="row" id="pay_mode_2_detail" style="margin:5px 10px 10px 20px;">
             <span class="font-song-12">需先确认地址信息才能选择货到付款，请您验货后付款。</span>
          </div>
          
          <div class="div_line"></div> 
    
          <!-- 选择支付渠道-->
          <input type="hidden" id="isInstead" name="isInstead" value=${isInstead}>
          
          <div class="row" style="margin:10px 10px 0px 10px;">
           <#if (isInstead)>
            <input type="hidden" id="hide_user_id" name="hide_user_id" value=${acctinfo.USER_ID}>
            <input type="hidden" id="hide_topay_money" name="hide_topay_money" value=${topay_money}>
            <input type="hidden" id="hide_balance" name="hide_balance" value=${acctinfo.BALANCE}>
            <div class="radio" style="padding-left:5px;">
             <label class="radio">
               <input type="radio" name="pay_mode_style" id="acctpay" value="微帐户支付" style="margin-top: 18px;">
               <!-- 微帐户支付-->      
               <div style="width:95%;background-color:#ffffff;height:53px;line-height:53px;">
                 <img src="${resRoot}/image/myacct/qiandai.png" width=32 height=32/>
           	     <span class="sp1">微账户 <span id="span_balance">可用余额${acctinfo.BALANCE}元</span></span>
               </div>
             </label>              
            </div>
           </#if>          
            <div class="radio" style="padding-left:5px;">
             <label class="radio">
               <input type="radio" name="pay_mode_style" id="unionpay" value="银联支付"  style="margin-top: 18px;">
               <#--<img src="${resRoot}/image/selectPayMode/pay_bank.png" width="95%" height="30%"/>-->
               <img src="${resRoot}/image/selectPayMode/pay_unionpay.png" width="95%" height="30%"/>
               <#-- <img src="${resRoot}/image/selectPayMode/pay_wo.png" width="95%" height="30%"/> -->
             </label>              
            </div>          
            <div class="radio" style="padding-left:5px;">
             <label class="radio">
               <input type="radio" name="pay_mode_style" id="weixin" value="微信支付" checked="checked" style="margin-top:18px;">
               <img src="${resRoot}/image/selectPayMode/pay_weixin.png" width="95%" height="30%"/>
             </label>
            </div>
            <#--
            <div class="radio" style="padding-left:5px;">
             <label class="radio">
               <input type="radio" name="pay_mode_style" id="wo" value="沃支付" style="margin-top: 18px;" disabled>
               <img src="${resRoot}/image/selectPayMode/pay_wo.png" width="95%" height="30%"/>
             </label>
            </div>
            -->

          </div>          
          
          <!-- 选择银联后展示提示信息-->
          <div class="row" id="pay_mode_3_detail" style="margin:5px 10px 10px 20px;">
            <div style="font-size: 12px;margin: 10px;line-height: 20px;">
			 <!--  <b style="font-size: 14px;">已接入银行</b></br> -->
<!-- 			  <b>储蓄卡：</b>工商银行、农业银行、光大银行、邮储银行等</br>
			  <b>信用卡：</b>中国银行等</br> -->
<!-- 			  <b>
			  	工商银行、农业银行、中国银行、建设银行、交通银行、邮储银行、光大银行、贵阳银行等～
			  </b> -->
			  <br/>
			  <#--<i><b>其他银行陆续接入<a onclick="testWoPay()">,</a></b>敬请期待<a onclick="testWeiXinPay()">～</a></b></i>-->
			  <!-- <i><b>其他银行陆续接入,</b>敬请期待～</b></i> -->
            </div>
          </div>
          
          <!-- 提交-->
          <div id="div_container" style="margin: 15px">
            <button class="btn btn-warning btn-block" id="btnsubmit" data-toggle="modal" onclick="goToPay2()">确定</button>
          </div>
    </div>

   <!-- 支付密码弹出 Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="clearTextVal();"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入支付密码</h4>
                </div>
                <div class="modal-body">
<!--                     <span>交通银行<span>尾号2878储蓄卡</span></span>
                    <br> -->
                    <div class="pwd_container">
                    	<div>
                     		<input type="password" value="" name="txtsecuritypwd" id="txtsecuritypwd" maxlength="6" size="6" class="form-control" onkeyup="checkData(this,btnok);" >
                        </div>
                        <!-- <div>
                            <input type="password" class="form-control" id="txt2" placeholder="" maxlength="1" onkeyup="checkData(this,txt3);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt3" placeholder="" maxlength="1" onkeyup="checkData(this,txt4);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt4" placeholder="" maxlength="1" onkeyup="checkData(this,txt5);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt5" placeholder="" maxlength="1" onkeyup="checkData(this,txt6);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt6" placeholder="" maxlength="1" onkeyup="checkData(this,btnok);" onfocus="doFocus(this);">
                        </div> -->
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default modal-button" name="btnclear" id="btnclear" onclick="clearTextVal();">清空</button>
                    <button type="button" class="btn btn-warning modal-button" name="btnok" id="btnok" onclick="acctPay();">确定</button>
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