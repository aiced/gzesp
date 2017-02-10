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
<form class="form-horizontal">  
请求url:
<textarea id="reqUrl" class="form-control" rows="1"></textarea>  
请求参数json, 可以用RechargeService的main方法获取加密的reqParam字符串：
<textarea id="reqJson" class="form-control" rows="5"></textarea>
返回：  
<textarea id="resp" class="form-control" rows="5"></textarea>

<button type="button" class="btn btn-success" onclick="submitForm()">submit</button>
</form>
  
<!-- test8 -->
<!--
<h4>8. callIntfOrderSub 订单提交  接口</h4>  
<form class="form-horizontal">
  <div class="form-group">
    <label for="OperatorID" class="col-sm-2 control-label">OperatorID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="OperatorID" placeholder="OperatorID" value="AGYDZSW5">
    </div>
  </div>
  <div class="form-group">
    <label for="Province" class="col-sm-2 control-label">Province</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="Province" placeholder="Province" value="85">
    </div>
  </div>
  <div class="form-group">
    <label for="City" class="col-sm-2 control-label">City</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="City" placeholder="City" value="850">
    </div>
  </div>
  <div class="form-group">
    <label for="District" class="col-sm-2 control-label">District</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="District" placeholder="District" value="850">
    </div>
  </div>
  <div class="form-group">
    <label for="ChannelID" class="col-sm-2 control-label">ChannelID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ChannelID" placeholder="ChannelID" value="76D91">
    </div>
  </div>
  <div class="form-group">
    <label for="ChannelType" class="col-sm-2 control-label">ChannelType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ChannelType" placeholder="ChannelType" value="1020400">
    </div>
  </div>
  <div class="form-group">
    <label for="AccessType" class="col-sm-2 control-label">AccessType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="AccessType" placeholder="AccessType" value="03">
    </div>
  </div>
  <div class="form-group">
    <label for="ProvOrderID" class="col-sm-2 control-label">ProvOrderID
    </label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProvOrderID" placeholder="预提交接口返回的订单id" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="orderID" class="col-sm-2 control-label">orderID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="orderID" placeholder="esp订单id" value="">
    </div>
  </div>
                           
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm8()">submit</button>
    </div>
  </div>
</form>
-->

<script type="text/javascript">
	function submitForm()
	{
	    var url = $('#reqUrl').val();
	    var param = $('#reqJson').val();  
	       
        $.ajax({
		      type: "POST",
		      contentType:"application/json", //发送给服务器的内容编码类型
		      url: url, 
		      dataType:"json", //预期服务器返回的数据类型
		      data: param, //JSON.stringify(param), //服务器只能接收json字符串
		      success: function(data){
		         $('#resp').val(JSON.stringify(data));
		      }
			    }) ;            
	}

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
