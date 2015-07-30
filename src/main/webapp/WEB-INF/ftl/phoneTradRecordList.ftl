<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>交易记录</title>
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="${resRoot}/css/phoneTradRecordList.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="${resRoot}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${resRoot}/js/phoneTradRecordList.js"></script>

</head>
<body style="background-color:transparent">
    <input type="hidden" id="baseRoot" value="${base}"></input>
    <input type="hidden" id="user_id" value="${user_id}"></input>
    <input type="hidden" id="parentPath" value="${parentPath}"></input>
    
   		  <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	      </div> 
	      
	      <!-- 加载列表，点击，分页 -->
<div class="divContainer">
    <ul>
       		<#list topUpDealList as info>			
	            <li class="rel" orderId = "${info.orderId}"}>
           			 <p class="title"> ${info.goodsName} － ${info.phoneNumber} </p>

					<#if (info.orderState =='00')>
  				        <p class="status"> 未支付 </p>
                	<#elseif (info.orderState =='02')>
			 			 <p class="status"> 支付成功 </p> 
                	</#if>          			 
           			 <p class="date"> ${info.createTime} </p>
            		<span class="abs"> ￥${info.topayMoney} </span>
       			 </li>
			</#list>    
    </ul>

</div>

</body>
</html>