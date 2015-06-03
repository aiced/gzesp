<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <title>${title}</title>

    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>    
    
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
        function goToPay(){
	        var url;
            var pay_mode = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
	        //alert(pay_mode);
            if(pay_mode == '01'){
               var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
               //alert(pay_mode_style);
               if(pay_mode_style == "微信支付"){
                 url = '${base}/pay/wxPay/prepay_step1/${order_id}/${fee}?state=${goods_name}'; //微信支付
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
        function goToPay2(){
            var pay_type = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
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
                 url = '${base}/pay/wxPay/prepay_step1/${order_id}/${fee}?state=encodeURIComponent(${goods_name})'; //微信支付
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
            if(pay_mode == '00'){
               var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
               url = '${base}/pay/wxPay/prepay_step1/${order_id}/10?state=encodeURIComponent(${goods_name})'; //微信支付
            }
            
	        window.location.href = url;  
        }  
        function testWoPay(){
	        var url;
            var pay_mode = $('input[name=pay_mode]:checked').val(); //线上支付还是货到付款
	        //alert(pay_mode);
            if(pay_mode == '00'){
               var pay_mode_style = $('input[name=pay_mode_style]:checked').val();
               url = '${base}/pay/wopay/orderPost/${order_id}/${fee}'; //沃支付
            }
            
	        window.location.href = url;  
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
             <span class="font-song-12">支持信用卡、储蓄卡、微信支付、沃支付</span>
          </div>
          <div class="row" id="pay_mode_2_detail" style="margin:5px 10px 10px 20px;">
             <span class="font-song-12">需先确认地址信息才能选择货到付款，请您验货后付款。</span>
          </div>
          
          <div class="div_line"></div> 
                   
          <!-- 选择支付渠道-->
          <div class="row" style="margin:10px 10px 0px 10px;">
            <div class="radio" style="padding-left:5px;">
             <label class="radio">
               <input type="radio" name="pay_mode_style" id="weixin" value="微信支付" style="margin-top:18px;" disabled>
               <img src="${resRoot}/image/selectPayMode/pay_weixin.png" width="95%" height="30%"/>
             </label>
            </div>
            <div class="radio" style="padding-left:5px;">
             <label class="radio">
               <input type="radio" name="pay_mode_style" id="wo" value="沃支付" style="margin-top: 18px;" disabled>
               <img src="${resRoot}/image/selectPayMode/pay_wo.png" width="95%" height="30%"/>
             </label>
            </div>
            <div class="radio" style="padding-left:5px;">
             <label class="radio">
               <input type="radio" name="pay_mode_style" id="unionpay" value="银联支付" checked="checked" style="margin-top: 18px;">
               <img src="${resRoot}/image/selectPayMode/pay_unionpay.png" width="95%" height="30%"/>
             </label>              
            </div>
          </div>          
          
          <!-- 选择银联后展示提示信息-->
          <div class="row" id="pay_mode_3_detail" style="margin:5px 10px 10px 20px;">
            <div style="font-size: 12px;margin: 10px;line-height: 20px;">
			  <b style="font-size: 14px;">已接入银行</b></br>
			  <b>储蓄卡：</b>工商银行、农业银行、光大银行、邮储银行等</br>
			  <b>信用卡：</b>中国银行等</br>
			  <i><b>其他银行陆续接入<a onclick="testWoPay()">,</a></b>敬请期待<a onclick="testWeiXinPay()">～</a></b></i>
            </div>
          </div>
          
          <!-- 提交-->
          <div id="payInfoBtn" style="margin: 15px">
            <button class="btn btn-warning btn-block" id="btnsubmit" onclick="goToPay2()">确定</button>
          </div>
    </div>


</body>
</html>