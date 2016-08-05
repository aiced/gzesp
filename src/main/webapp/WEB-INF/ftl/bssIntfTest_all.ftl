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
  
<!-- test1 -->
<h4>queryBssOrderList 接口</h4>  
<form class="form-horizontal">
  <div class="form-group">
    <label for="user_id" class="col-sm-2 control-label">user_id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="user_id" placeholder="user_id" value="2015051509073611">
    </div>
  </div>
  <div class="form-group">
    <label for="order_id" class="col-sm-2 control-label">order_id</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="order_id" placeholder="order_id" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="phone_number" class="col-sm-2 control-label">phone_number</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="phone_number" placeholder="phone_number" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="is_ok" class="col-sm-2 control-label">is_ok</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="is_ok" placeholder="is_ok" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="start_day" class="col-sm-2 control-label">start_day</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="start_day" placeholder="start_day" value="2016-01-01">
    </div>
  </div>
  <div class="form-group">
    <label for="end_day" class="col-sm-2 control-label">end_day</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="end_day" placeholder="end_day" value="2016-12-01">
    </div>
  </div>
  <div class="form-group">
    <label for="pageNum" class="col-sm-2 control-label">pageNum</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="pageNum" placeholder="pageNum" value="1">
    </div>
  </div>
  <div class="form-group">
    <label for="pageSize" class="col-sm-2 control-label">pageSize</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="pageSize" placeholder="pageSize" value="20">
    </div>
  </div>          
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm1()">submit</button>
    </div>
  </div>
</form>

<!-- test2 -->
<h4>2. callIntfCheckCust 客户校验 接口</h4>  
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
    <label for="CertType" class="col-sm-2 control-label">CertType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CertType" placeholder="CertType" value="02">
    </div>
  </div>
  <div class="form-group">
    <label for="CertNum" class="col-sm-2 control-label">CertNum</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CertNum" placeholder="CertNum" value="320282198401162411">
    </div>
  </div>
  <div class="form-group">
    <label for="ServiceType" class="col-sm-2 control-label">ServiceType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ServiceType" placeholder="ServiceType" value="01">
    </div>
  </div>                
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm2()">submit</button>
    </div>
  </div>
</form>

<!-- test3 -->
<h4>3. callIntfUserCheck 用户校验 接口</h4>  
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
    <label for="ServiceType" class="col-sm-2 control-label">ServiceType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ServiceType" placeholder="ServiceType" value="01">
    </div>
  </div>                
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm3()">submit</button>
    </div>
  </div>
</form>

<!-- test4 -->
<h4>4. callIntfNumQuery 号码查询 接口</h4>  
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
    <label for="SerType" class="col-sm-2 control-label">SerType1-后付费 2-预付费
    </label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="SerType" placeholder="SerType" value="1">
    </div>
  </div>
  <div class="form-group">
    <label for="QueryType" class="col-sm-2 control-label">QueryType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="QueryType" placeholder="QueryType" value="03">
    </div>
  </div>
  <div class="form-group">
    <label for="QueryPara1" class="col-sm-2 control-label">QueryPara1</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="QueryPara1" placeholder="QueryPara1" value="186">
    </div>
  </div>
  <div class="form-group">
    <label for="ProductID" class="col-sm-2 control-label">ProductID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProductID" placeholder="ProductID" value="20528022">
    </div>
  </div>                       
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm4()">submit</button>
    </div>
  </div>
</form>


<!-- test5 -->
<h4>5. callIntfCheckRes 资源占用 接口</h4>  
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
    <label for="ResourcesType" class="col-sm-2 control-label">ResourcesType
    </label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ResourcesType" placeholder="ResourcesType" value="02">
    </div>
  </div>
  <div class="form-group">
    <label for="ResourcesCode" class="col-sm-2 control-label">ResourcesCode</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ResourcesCode" placeholder="要占用的号码" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="OccupiedFlag" class="col-sm-2 control-label">OccupiedFlag</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="OccupiedFlag" placeholder="OccupiedFlag" value="2">
    </div>
  </div>                      
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm5()">submit</button>
    </div>
  </div>
</form>

<!-- test6 -->
<h4>6. callIntfCheckRule 订购信息合法性  接口</h4>  
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
    <label for="GuarantorType" class="col-sm-2 control-label">GuarantorType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="GuarantorType" placeholder="GuarantorType" value="04">
    </div>
  </div>
  <div class="form-group">
    <label for="GuaratorID" class="col-sm-2 control-label">GuaratorID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="GuaratorID" placeholder="GuaratorID" value="0">
    </div>
  </div>
  <div class="form-group">
    <label for="GroupFlag" class="col-sm-2 control-label">GroupFlag</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="GroupFlag" placeholder="GroupFlag" value="0">
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
    <label for="ProductID" class="col-sm-2 control-label">ProductID</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProductID" placeholder="ProductID" value="20528022">
    </div>
  </div>                           
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm6()">submit</button>
    </div>
  </div>
</form>

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

<!-- test8 -->
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

<!-- test9 -->
<h4>9. callIntfGetCardData 获取写卡数据  接口</h4>  
<form class="form-horizontal">
  <div class="form-group">
    <label for="UserNum" class="col-sm-2 control-label">UserNum</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="UserNum" placeholder="UserNum" value="18608508612">
    </div>
  </div>
  <div class="form-group">
    <label for="SimCard" class="col-sm-2 control-label">SimCard</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="SimCard" placeholder="SimCard" value="8986011588501119228">
    </div>
  </div>
  <div class="form-group">
    <label for="EparchyCode" class="col-sm-2 control-label">EparchyCode</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="EparchyCode" placeholder="EparchyCode" value="0851">
    </div>
  </div>
  <div class="form-group">
    <label for="CustName" class="col-sm-2 control-label">CustName</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CustName" placeholder="CustName" value="奚敏辉">
    </div>
  </div>
  <div class="form-group">
    <label for="PsptId" class="col-sm-2 control-label">PsptId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="PsptId" placeholder="PsptId" value="320282198401162411">
    </div>
  </div>
  <div class="form-group">
    <label for="ProductId" class="col-sm-2 control-label">ProductId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProductId" placeholder="ProductId" value="20528022">
    </div>
  </div>
  <div class="form-group">
    <label for="BusiType" class="col-sm-2 control-label">BusiType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="BusiType" placeholder="BusiType" value="32">
    </div>
  </div>
  <div class="form-group">
    <label for="CardType" class="col-sm-2 control-label">CardType
    </label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="CardType" placeholder="CardType" value="04">
    </div>
  </div>
  <div class="form-group">
    <label for="UserType" class="col-sm-2 control-label">UserType</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="UserType" placeholder="UserType" value="01">
    </div>
  </div>
  <div class="form-group">
    <label for="ProcId" class="col-sm-2 control-label">ProcId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProcId" placeholder="ProcId" value="">
    </div>
  </div>
  <div class="form-group">
    <label for="StaffId" class="col-sm-2 control-label">StaffId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="StaffId" placeholder="StaffId" value="AGYDZSW5">
    </div>
  </div>
  <div class="form-group">
    <label for="DepartId" class="col-sm-2 control-label">DepartId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="DepartId" placeholder="DepartId" value="76D91">
    </div>
  </div>
                                 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm9()">submit</button>
    </div>
  </div>
</form>

<!-- test10 -->
<h4>10. callIntfWriteCard 写卡结果通知  接口</h4>  
<form class="form-horizontal">
  <div class="form-group">
    <label for="UserNum" class="col-sm-2 control-label">UserNum</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="UserNum" placeholder="UserNum" value="18608508612">
    </div>
  </div>
  <div class="form-group">
    <label for="Iccid" class="col-sm-2 control-label">Iccid</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="Iccid" placeholder="Iccid" value="8986011588501119228">
    </div>
  </div>
  <div class="form-group">
    <label for="Imsi" class="col-sm-2 control-label">Imsi</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="Imsi" placeholder="Imsi" value="">
    </div>
  </div>  
  <div class="form-group">
    <label for="EparchyCode" class="col-sm-2 control-label">EparchyCode</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="EparchyCode" placeholder="EparchyCode" value="0851">
    </div>
  </div>
  <div class="form-group">
    <label for="UpdateTime" class="col-sm-2 control-label">UpdateTime</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="UpdateTime" placeholder="UpdateTime" value="2016-07-05 10:47:56">
    </div>
  </div>
  <div class="form-group">
    <label for="ProcId2" class="col-sm-2 control-label">ProcId2</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProcId2" placeholder="ProcId2" value="320282198401162411">
    </div>
  </div>
  <div class="form-group">
    <label for="OperRst" class="col-sm-2 control-label">OperRst</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="ProductId" placeholder="OperRst" value="0">
    </div>
  </div>
  <div class="form-group">
    <label for="StaffId" class="col-sm-2 control-label">StaffId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="StaffId" placeholder="StaffId" value="AGYDZSW5">
    </div>
  </div>
  <div class="form-group">
    <label for="DepartId" class="col-sm-2 control-label">DepartId</label>
    <div class="col-sm-6">
      <input type="text" class="form-control" id="DepartId" placeholder="DepartId" value="76D91">
    </div>
  </div>
                                 
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-success" onclick="submitForm10()">submit</button>
    </div>
  </div>
</form>

<!-- test12 -->
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
	    var param = {"OperatorID":$('#OperatorID').val(), "Province":$('#Province').val(),
	                 "City":$('#City').val(), "District":$('#District').val(),
	                 "ChannelID":$('#ChannelID').val(), "ChannelType":$('#ChannelType').val(),
	                 "AccessType":$('#AccessType').val(), "ProvOrderID":$('#ProvOrderID').val(),
	                 "orderID":$('#orderID').val()
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
