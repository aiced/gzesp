<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
	
  </head>

  <body>
    <!-- nav bar -->
     <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right"></div>
	        </div>
    
    <div class="container-fluid" style="padding:5px">
	    <div class="row" style="margin:0px;">
	        <div style="float: left;">
	        	  <ul id="p-tab" class="list-group p-tab">
	        	 	 <#list pkgList as pkg>  
	        	 	 <#if pkg_index == 0>
						  <li class="selected">
					 <#else>
						  <li>
					 </#if> 
					  	<h5>${pkg.price}</h5>
					  	<input type="hidden" id="nationalminutes_hidden" value="${pkg.nationalminutes}">
					  	<input type="hidden" id="nationalthroughtput_hidden" value="${pkg.nationalthroughtput}">
					  	<input type="hidden" id="totalFee_hidden" value="${pkg.totalFee}">
					  	<input type="hidden" id="returnFee_hidden" value="${pkg.returnFee}">
					  	<input type="hidden" id="monthRtnFee_hidden" value="${pkg.monthRtnFee}">
					  </li>
					</#list>   
				</ul>
	        </div>
	        <div  style="padding: 10px 0px 0px 70px;">
	          <p>1.确认套餐资费</p>
	          <ul class="list-group">
					  <table class="table table-bordered">
						  <tr>
						  	<td style="width:50%">国内语音</td>
						  	<td><lable id="nationalminutes"></lable></td>
						  </tr>
						  <tr>
						  	<td>国内流量</td>
						  	<td><lable id="nationalthroughtput"></lable></td>
						  </tr>
						  <tr>
						  	<td colspan=2>
							    <div  data-toggle="collapse" data-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
								  套餐超出及其他业务资费
								  <span class="caret"></span>
								</div>
					  			  <div id="collapseOne" class="collapse">

											国内接听免费，包含来电显示</br>
											
											国内语音拨打0.15元/分钟</br>
											
											套外流量不足1GB按MB计费,0.3元/MB,每超出200MB即按照60元/GB计费,以此类推</br>
											
											短、彩信0.10元/条</br>
											
											其他业务执行标准资费</br>

								    </div>
							    
							</td>
						  </tr>
						</table>
				</ul>
				
				
	          <p>2.确认适合您的合约期限</p>
	          <div id="period-select" class="p-list">
                        <a href="javascript:void(0);"  value="12" actType="4" class="selected">12个月</a>
                        <a href="javascript:void(0);"  value="24" actType="4" >24个月</a>
                        <a href="javascript:void(0);"  value="36" actType="4" >36个月</a>
                    </div>
				
				 <table class="table table-bordered">
				 		<tr>
						  	<td colspan=2></td>
						  </tr>
						  <tr>
						  	<td style="width:50%">合约机总价（折前）</td>
						  	<td><lable id="totalFee"></lable></td>
						  </tr>
						  <tr>
						  	<td >返款总金额</td>
						  	<td><lable id="returnFee"></lable></td>
						  </tr>
						  <tr>
						  	<td >每月返还金额</td>
						  	<td><lable id="monthRtnFee"></lable></td>
						  </tr>
				</table>
	        </div>        
	      </div>
	  
    </div>
    
     <div class="container-fluid" style="padding:5px">
     	 <p> 您已选择： </p>
		<span>月消费396元 12个月合约</span>
      </div>
      
     <div class="container-fluid" style="padding:5px">
     	<button type="button" class="btn btn-warning  btn-lg btn-block" onclick='nextPage()'>确定合约</button>
      </div>
      

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
     <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
     <script src="${resRoot}/js/selectContract.js?v=${resVer}"></script>
  </body>
</html>