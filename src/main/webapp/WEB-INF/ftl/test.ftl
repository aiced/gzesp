<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>test</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    
    <script type="text/javascript">
	  	function callpay(){
			 WeixinJSBridge.invoke('getBrandWCPayRequest',{
	  		 "appId" : "<%=appId%>","timeStamp" : "<%=timeStamp%>", "nonceStr" : "<%=nonceStr%>", "package" : "<%=packageValue%>","signType" : "MD5", "paySign" : "<%=paySign%>" 
	   			},function(res){
					WeixinJSBridge.log(res.err_msg);
	// 				alert(res.err_code + res.err_desc + res.err_msg);
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

    
         
    <div class="container-fluid" style="background-color:#ffffff;margin:15px;">
      <div>
      </div>
      <button  class="btn btn-warning btn-block " type="submit" onclick="location.href='test1'" >走你</button>
    </div>
    
    
  </body>
</html>
