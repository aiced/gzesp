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

	
        function unionPayPay(){
        var param = [{"pay_order":"1", "pay_type":"01", "pay_mode":"60", "pay_fee":"1", "coupon_id":"12345678"},
                     {"pay_order":"2", "pay_type":"01", "pay_mode":"51", "pay_fee":"2"},	
                     {"pay_order":"3", "pay_type":"01", "pay_mode":"10", "pay_fee":"3", "bank_no":"1234567"} 
                    ]
           ;
	        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/test2", // 全要素支付接口路径 /unionPay/payNew
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		         alert('ok');
		      }
		    });
        }		
	</script>
</head>

<body>
<button class="btn btn-lg btn-warning btn-block " type="button" onclick="unionPayPay()">确认支付</button>
           
</body>
</html>
