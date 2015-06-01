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
	  		alert("123");
			 WeixinJSBridge.invoke('getBrandWCPayRequest',{
	  		 "appId" : "${appId}",
	  		 "timeStamp" : "${timeStamp}", 
	  		 "nonceStr" : "${nonceStr}", 
	  		 "package" : "${package}",
	  		 "signType" : "${signType}", 
	  		 "paySign" : "${paySign}" 
	   			},function(res){
					WeixinJSBridge.log(res.err_msg);
					alert(res.err_code + res.err_desc + res.err_msg);
		            if(res.err_msg == "get_brand_wcpay_request:ok"){  
		                alert("微信支付成功!");  
		            }else if(res.err_msg == "get_brand_wcpay_request:cancel"){  
		                alert("用户取消支付!");
		            }else{
		               alert("支付失败!");
		            }  
				})
			}
  </script>
  
  </head>

  <body>
  </body>
</html>
