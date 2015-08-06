<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>产品选择</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/bandGoodSelect.css?v=${resVer}" rel="stylesheet">
  </head>

  <body>
  	<!-- nav bar -->
    <div class="container-fluid" style="background-color:#21292c;height:38px;">
      <div class="row" style="margin-top:8px;margin-left:5px;">
        <div class="col-xs-2" style="margin-top:5px;padding:0px;">
    	  <a class="left carousel-control" href="javascript:history.back(-1);" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">back</span>
          </a>
    	</div>
        <div class="col-xs-8">
    	  <p class="text-center navbar-p">产品选择 </p>
    	</div>
      </div>      
    </div> 
    
    <!-- 账户基本信息 -->
    <div class="container-fluid" style="background-color:#ffffff;margin:10px;padding-top: 10px;">
      <p>宽带账户：${bandAcct}</p>
      <hr align="center"  color="#f4f4f4" size="1" style="margin:0" noShade>
      <p>姓名：${userCheckReq_Res.custName}</p>
      <hr align="center"  color="#f4f4f4" size="1" style="margin:0" noShade>
      <#list userCheckReq_Res.currProductList as item>
      	<#if (item_index == 0)>
			<p>当前产品：${item.currProductName}元包年</p>
			<input type="hidden" id="hide_oldproductcode" name="hide_oldproductcode" value=${item.currProductCode}>    			
		</#if>
      </#list>     
     
      
      <hr align="center"  color="#f4f4f4" size="1" style="margin:0" noShade>
      <p>状态：${userCheckReq_Res.userStatus}</p>
      <hr align="center"  color="#f4f4f4" size="1" style="margin:0" noShade>
      <#list userCheckReq_Res.currProductList as item>
      	<#if (item_index == 0)>
 		<p>有效期：${item.productActiveTime}---${item.productInActiveTime}</p>	            
      	</#if>
      </#list>
    </div>
    
    <p style="margin:10px;font-size: 15px;font-weight:bold;">选择产品</p>  
    
    
    <#list userCheckReq_Res.productList as item>
	    <div class="container-fluid" style="background-color:#ffffff;margin:10px;padding-left: 20px;" onclick="doClick(${item.productCode},${item.productFee},${item.discntReq.discntValue},$('#hide_oldproductcode').val());">
	    	<div class="row">
	        <div class="col-xs-4" style="background-color:#9bd8ff;width:60px;height:60px;text-align:center;margin:10px;padding:15px;padding-left:0px;padding-right:0px;">
	        	<p style="color:#ffffff;font-size:18px;font-weight:normal">${item.productRate}</p>
	        </div>
	        <div class="col-xs-8" style="padding:15px">
	        	<p style="font-size:18px;font-weight:normal">${item.productRate} &nbsp; ${item.productFee}元/年</p>
	        	<p style="font-size:18px;font-weight:normal;color:#ff0000">￥${item.productFee}</p>
	        </div>     		
	      </div>            
	    </div>
    </#list>
                
    <input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>   
    <input type="hidden" id="hide_bandAcct" name="hide_bandAcct" value=${bandAcct}>    

    <!-- Bootstrap core JavaScript -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
 	<script type="text/javascript" src="${resRoot}/js/bandGoodSelect.js?v=${resVer}"></script>	
  	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
  </body>
</html>
