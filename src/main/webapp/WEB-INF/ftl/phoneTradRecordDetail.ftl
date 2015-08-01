<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>详情</title>
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="${resRoot}/css/phoneTradRecordDetail.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="${resRoot}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${resRoot}/js/phoneTradRecordDetail.js"></script>

</head>
<body style="background-color:transparent">
    <input type="hidden" id="baseRoot" value="${base}"></input>
    <input type="hidden" id="user_id" value="${user_id}"></input>
   		  <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	      </div> 

<div class="divContainer">
    <div class="detailContainer">
        <#list topUpDetail as info>			
       	<div class="title border_bottom">付款金额
            <span id = "topayMoney" class="fright sum" topayMoney = ${info.topayMoney} >￥${info.topayMoney}</span>
        </div>
        
        <ul>
            <li>
                <span class="li_title">商  品</span>
                <span id = "phoneNumber" phoneNumber = ${info.phoneNumber}  class="fright li_content">${info.goodsName} － ${info.phoneNumber}</span>
            </li>

            <li>
                <span class="li_title">用户名称</span>
                <span class="fright li_content">沃掌柜</span>
            </li>

            <li>
                <span class="li_title">当前状态</span>
                	<#if (info.orderState =='00')>
                		<span id = "status" class="fright li_content">未支付</span>
                	<#elseif (info.orderState =='01' || info.orderState =='02')>
                		<span id = "status" class="fright li_content">支付成功</span>
                	</#if>  
            </li>

            <li>
                <span class="li_title">时&nbsp间</span>
                <span class="fright li_content">${info.createTime}</span>
            </li>

            <li>
                <span class="li_title">支付方式</span>
                   	<#if (info.orderFrom =='00')>
               			 <span class="fright li_content">Web支付</span>
                	<#elseif (info.orderFrom =='01')>
                		 <span class="fright li_content">微信支付</span>
                	<#else>
                		 <span class="fright li_content">未知</span>
                	</#if>  
            </li>

            <li>
                <span class="li_title">订 单 号</span>
                <span id = "orderId" class="fright li_content">${info.orderId}</span>
            </li>

        </ul>
       			 
		</#list>  
    
    
        

	<!-- 根据数据判断是否显示 -->
        <ul id = "cardInfo" class=" border_top">
            <li>
                <span class="li_title">充值卡号</span>
                <span class="fright li_content">1274928773889283737</span>
            </li>

            <li>
                <span class="li_title">密码</span>
                <span class="fright li_content">1274928773889283737</span>
            </li>
        </ul>
    </div>
    
    <div id = "payDivId" class="payDiv">去支付

    </div>
    
    <div id = "checkDetailId" class="checkDetail">查看进度 >

    </div>
    
    
    
    


</div>
</body>
</html>