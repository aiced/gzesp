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
  
<!-- test7 -->
<h4>7. callIntfAccount 开户预提交  接口</h4>  
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
    <label for="NumID" class="col-sm-2 control-label">NumID
    </label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="NumID" placeholder="NumID" value="占用的号码">
    </div>
  </div>
  <div class="form-group">
    <label for="CertTag" class="col-sm-2 control-label">CertTag</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CertTag" placeholder="CertTag" value="0">
    </div>
  </div>
  <div class="form-group">
    <label for="SerType" class="col-sm-2 control-label">SerType 1-后付费 2-预付费
    </label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="SerType" placeholder="SerType" value="1">
    </div>
  </div>  
  <div class="form-group">
    <label for="FirstMonBillMode" class="col-sm-2 control-label">FirstMonBillMode</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="FirstMonBillMode" placeholder="FirstMonBillMode" value="01">
    </div>
  </div>
  <div class="form-group">
    <label for="RealNameType" class="col-sm-2 control-label">RealNameType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="RealNameType" placeholder="RealNameType" value="0">
    </div>
  </div>

  <div class="form-group">
    <label for="CustomerID" class="col-sm-2 control-label">CustomerID 客户验证接口返回的id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerID" placeholder="CustomerID" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="CustomerType" class="col-sm-2 control-label">CustomerType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerType" placeholder="CustomerType" value="01">
    </div>
  </div> 
  <div class="form-group">
    <label for="CustomerLevel" class="col-sm-2 control-label">CustomerLevel</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerLevel" placeholder="CustomerLevel" value="1">
    </div>
  </div> 
  <div class="form-group">
    <label for="CustomerLoc" class="col-sm-2 control-label">CustomerLoc</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerLoc" placeholder="CustomerLoc" value="850">
    </div>
  </div>
  <div class="form-group">
    <label for="CertNum" class="col-sm-2 control-label">CertNum</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CertNum" placeholder="CertNum" value="320282198401162411">
    </div>
  </div>     
  <div class="form-group">
    <label for="CustomerName" class="col-sm-2 control-label">CustomerName</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerName" placeholder="CustomerName" value="奚敏辉">
    </div>
  </div>   
  <div class="form-group">
    <label for="CustomerName" class="col-sm-2 control-label">CustomerName</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerName" placeholder="CustomerName" value="奚敏辉">
    </div>
  </div>
  <div class="form-group">
    <label for="CustomerPasswd" class="col-sm-2 control-label">CustomerPasswd</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerPasswd" placeholder="CustomerPasswd" value="123456">
    </div>
  </div> 
  <div class="form-group">
    <label for="ReleOfficeID" class="col-sm-2 control-label">ReleOfficeID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ReleOfficeID" placeholder="ReleOfficeID" value="76D91">
    </div>
  </div> 
  <div class="form-group">
    <label for="CertExpireDate" class="col-sm-2 control-label">CertExpireDate 随便填的</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CertExpireDate" placeholder="CertExpireDate" value="20251231">
    </div>
  </div> 
  <div class="form-group">
    <label for="ContactPhone" class="col-sm-2 control-label">ContactPhone</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ContactPhone" placeholder="ContactPhone" value="18651885060">
    </div>
  </div>
  <div class="form-group">
    <label for="CustomerSex" class="col-sm-2 control-label">CustomerSex 随便填的</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustomerSex" placeholder="CustomerSex" value="1">
    </div>
  </div> 
  <div class="form-group">
    <label for="ProductID" class="col-sm-2 control-label">ProductID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProductID" placeholder="ProductID" value="20528022">
    </div>
  </div>    
  <div class="form-group">
    <label for="orderId" class="col-sm-2 control-label">orderId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="orderId" placeholder="orderId" value="esp1234567890">
    </div>
  </div>
                                        
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm7()">submit</button>
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
</script>
	
  </body>
</html>
