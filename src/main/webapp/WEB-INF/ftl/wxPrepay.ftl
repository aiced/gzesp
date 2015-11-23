<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>微信支付</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>   
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
     <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
     
     
    <script type="text/javascript">
    
	    $(function(){
	    	
	    	if (typeof WeixinJSBridge == "undefined"){
	    		   if( document.addEventListener ){
	    		       document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
	    		   }else if (document.attachEvent){
	    		       document.attachEvent('WeixinJSBridgeReady', onBridgeReady); 
	    		       document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
	    		   }
	    		}else{
	    		   onBridgeReady();
	    		} 
	    });
	    
	  	function onBridgeReady(){
	  		// alert("123");
			 WeixinJSBridge.invoke('getBrandWCPayRequest',{
	  		 "appId" : "${appId}",
	  		 "timeStamp" : "${timeStamp}", 
	  		 "nonceStr" : "${nonceStr}", 
	  		 "package" : "${package}",
	  		 "signType" : "${signType}", 
	  		 "paySign" : "${paySign}" 
	   			},function(res){
					WeixinJSBridge.log(res.err_msg);
					//alert(res.err_code + res.err_desc + res.err_msg);
		            if(res.err_msg == "get_brand_wcpay_request:ok"){  
		                //alert("微信支付成功!");  
		            	 $('.modal-title').html('支付成功');
					      $('#btn_other').hide();
					      $('#btn_qry').show();
					      $('#btn_home').show();
		            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
		                //alert("用户取消支付!");
		            	$('.modal-title').html('取消支付');
					      $('#btn_other').show();
					      $('#btn_qry').hide();
					      $('#btn_home').hide();
		            }else{
		               //alert("支付失败!");
		            	 $('.modal-title').html('支付失败');
					      $('#btn_other').show();
					      $('#btn_qry').hide();
					      $('#btn_home').hide();
		            }  
		            
		          //弹出支付结果框
				    $('#payResult').modal({
	                  keyboard: false,
	                  backdrop: 'static'
	                });
				})
			}
  </script>
  
  </head>

  <body>
   <!-- 支付结果弹出框 -->    
    <div id="payResult" class="modal fadebs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">支付结果</h4>
          </div>
          <div class="modal-body">
            <p id="payOrderInfo">订单编号：${order_id}，金额：${(fee?number/1000)?string('#.##')}元</p>
          </div>
          <div class="modal-footer">
            <a id="btn_other" class="btn btn-warning" href="${base}/pay/selectPayMode/${order_id}/${fee}" role="button">选择其他支付方式</a>
            <a id="btn_qry" class="btn btn-warning" href="${base}/customer/custOrderQuery" role="button">订单查询</a>
            <a id="btn_home" class="btn btn-warning" href="${base}/pay/goToWeShopIndex/${order_id}" role="button">再去逛逛</a>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->   
  </body>
</html>
