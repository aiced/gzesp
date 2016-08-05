<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="format-detection" content="telephone=no">


    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain2.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain3.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/selectNumber.css?v=${resVer}" rel="stylesheet">    
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet"> 
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/goodDetail.js?v=${resVer}"></script>
    <script src="${resRoot}/js/selectNumber.js?v=${resVer}"></script>   
    <script src="${resRoot}/js/hammer.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/jquery.hammer.js?v=${resVer}"></script>     
    
    <style type="text/css">
    	.carousel-indicators
		{
			bottom:-2%;
		}
    </style>
  </head>

  <body>
<textarea id="resp" class="form-control" rows="5"></textarea>
  
<!-- test12 -->
<!-- 
<h4>12. updateOrderPsptNo 读身份证 接口</h4>  
<form class="form-horizontal">
  <div class="form-group">
    <label for="order_id" class="col-sm-2 control-label">order_id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="order_id" placeholder="order_id" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="pspt_no" class="col-sm-2 control-label">pspt_no</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="pspt_no" placeholder="pspt_no" value="320282198401162411">
    </div>
  </div>
  <div class="form-group">
    <label for="cust_name" class="col-sm-2 control-label">cust_name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="cust_name" placeholder="cust_name" value="奚敏辉">
    </div>
  </div>  
                                 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm12()">submit</button>
    </div>
  </div>
</form>
-->
<!-- test13 -->

<h4>13. bssOpenAll 开户 接口</h4>  
<form class="form-horizontal">
  <div class="form-group">
    <label for="user_id" class="col-sm-2 control-label">user_id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="user_id" placeholder="user_id" value="2015051509073611">
    </div>
  </div>
  <div class="form-group">
    <label for="pspt_id" class="col-sm-2 control-label">pspt_id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="pspt_id" placeholder="pspt_id" value="320282198401162411">
    </div>
  </div>  
  <div class="form-group">
    <label for="order_id" class="col-sm-2 control-label">order_id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="order_id" placeholder="order_id" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="cust_name" class="col-sm-2 control-label">cust_name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="cust_name" placeholder="cust_name" value="奚敏辉">
    </div>
  </div>  
  <div class="form-group">
    <label for="phone_number" class="col-sm-2 control-label">phone_number</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="phone_number" placeholder="phone_number" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="developer_code" class="col-sm-2 control-label">developer_code</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="developer_code" placeholder="developer_code" value="8503473074">
    </div>
  </div>
  <div class="form-group">
    <label for="developer_name" class="col-sm-2 control-label">developer_name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="developer_name" placeholder="developer_name" value="aaa">
    </div>
  </div>
  <div class="form-group">
    <label for="channel_code" class="col-sm-2 control-label">channel_code</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="channel_code" placeholder="channel_code" value="85b0ffi">
    </div>
  </div>
  <div class="form-group">
    <label for="channel_name" class="col-sm-2 control-label">channel_name</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="channel_name" placeholder="channel_name" value="asdf">
    </div>
  </div>      
                                   
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm13()">submit</button>
    </div>
  </div>
</form>

<script type="text/javascript">
	function submitForm1()
	{
	    var param = {"user_id":$('#user_id').val(), "order_id":$('#order_id').val(),
	                 "phone_number":$('#phone_number').val(), "is_ok":$('#is_ok').val(),
	                 "start_day":$('#start_day').val(), "end_day":$('#end_day').val(),
	                 "pageNum":$('#pageNum').val(), "pageSize":$('#pageSize').val()};            
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/app/offline/queryBssOrderList", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		         $('#resp').val(data);
		      }
			    }) ;            
	}
	
	function submitForm2()
	{
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "CertType":$('#CertType').val(),
	                 "CertNum":$('#CertNum').val(), "ServiceType":$('#ServiceType').val()
	                 };            
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfCheckCust", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}
	
	function submitForm3()
	{
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "ServiceType":$('#ServiceType').val()
	                 };            
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfUserCheck", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}
	
	function submitForm4()
	{
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "SerType":$('#SerType').val(),
	                 "QueryType":$('#QueryType').val(), "QueryPara1":$('#QueryPara1').val(),
	                 "ProductID":$('#ProductID').val()
	                 };            
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfNumQuery", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}
	
	function submitForm5()
	{
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "ResourcesType":$('#ResourcesType').val(),
	                 "ResourcesCode":$('#ResourcesCode').val(), "OccupiedFlag":$('#OccupiedFlag').val()
	                 };            
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfCheckRes", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}
	
	function submitForm6()
	{
	    var discountList = ["99048632", "99400294", "99401322", "99401321"]; 	    
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "NumID":$('#NumID').val(),
	                 "GuarantorType":$('#GuarantorType').val(), "GuaratorID":$('#GuaratorID').val(),
	                 "GroupFlag":$('#GroupFlag').val(), "SerType":$('#SerType').val(),
	                 "ProductID":$('#ProductID').val(), "discountList":discountList
	                 };
	                                
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfCheckRule", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}
	
	function submitForm7()
	{
	    var discountList = ["99048632", "99400294", "99401322", "99401321"]; 	    
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "NumID":$('#NumID').val(),
	                 "CertTag":$('#CertTag').val(), "SerType":$('#SerType').val(),
	                 "GroupFlag":$('#GroupFlag').val(), "SerType":$('#SerType').val(),
	                 "FirstMonBillMode":$('#FirstMonBillMode').val(), "RealNameType":$('#RealNameType').val(),
	                 "CustomerID":$('#CustomerID').val(), "CustomerType":$('#CustomerType').val(),
	                 "CustomerLevel":$('#CustomerLevel').val(), "CustomerLoc":$('#CustomerLoc').val(),
	                 "CustomerName":$('#CustomerName').val(), "CustomerPasswd":$('#CustomerPasswd').val(),
	                 "ReleOfficeID":$('#ReleOfficeID').val(), "CertExpireDate":$('#CertExpireDate').val(),
	                 "ContactPhone":$('#ContactPhone').val(), "CustomerSex":$('#CustomerSex').val(),
	                 "ProductID":$('#ProductID').val(), "OrdersID":$('#orderId').val(), 
	                 "CertType":$('#CertType').val(), "CertNum":$('#CertNum').val(), 
	                 "discountList":discountList
	                 };
	                                
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfAccount", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}

	function submitForm8()
	{
	    var discountList = ["99048632", "99400294", "99401322", "99401321"]; 
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "ProvOrderID":$('#ProvOrderID').val(),
	                 "orderID":$('#orderID').val(), "discountList":discountList
	                 };
	                                
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfOrderSub", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}	
	
	function submitForm9()
	{
	    var param = {"UserNum":$('#UserNum').val(), "SimCard":$('#SimCard').val(),
	                 "EparchyCode":$('#EparchyCode').val(), "CustName":$('#CustName').val(),
	                 "PsptId":$('#PsptId').val(), "ProductId":$('#ProductId').val(),
	                 "BusiType":$('#BusiType').val(), "CardType":$('#CardType').val(),
	                 "UserType":$('#UserType').val(), "ProcId":$('#ProcId').val(),
	                 "StaffId":$('#StaffId').val(), "DepartId":$('#DepartId').val()
	                 };
	                                
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfGetCardData", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}	
	
	function submitForm10()
	{
	    var param = {"UserNum":$('#UserNum').val(), "Iccid":$('#Iccid').val(),
	                 "Imsi":$('#Imsi').val(), "EparchyCode":$('#EparchyCode').val(),
	                 "UpdateTime":$('#UpdateTime').val(), "ProcId2":$('#ProcId2').val(),
	                 "OperRst":$('#OperRst').val(), "OperComm":$('#OperComm').val(),
	                 "StaffId":$('#StaffId').val(), "DepartId":$('#DepartId').val()
	                 };
	                                
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/test/callIntfWriteCard", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}		
	
	function submitForm12()
	{
	    var param = {"order_id":$('#order_id').val(), "pspt_no":$('#pspt_no').val(),
	                 "cust_name":$('#cust_name').val()
	                 };
	                                
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/app/offline/updateOrderPsptNo", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}	
	
	function submitForm13()
	{
	    var param = {"user_id":$('#user_id').val(), "pspt_id":$('#pspt_id').val(),
	                 "order_id":$('#order_id').val(), "phone_number":$('#phone_number').val(),
	                 "cust_name":$('#cust_name').val(),
	                 "developer_code":$('#developer_code').val(), "developer_name":$('#developer_name').val(),
	                 "channel_code":$('#channel_code').val(), "channel_name":$('#channel_name').val()
	                 };
	                                
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: "${base}/app/offline/bssOpenAll", 
		      dataType:"json", //预期服务器返回的数据类型
		      data: JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		          $('#resp').val(data);
		      }
			    }) ;            
	}										
</script>
	
  </body>
</html>
