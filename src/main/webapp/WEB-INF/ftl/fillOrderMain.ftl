<!DOCTYPE html>
<html>
<head lang="en">
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
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/jquery.json.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/orderFill.js?v=${resVer}"></script>

	
    <style type="text/css">
        .div_contain
        {
            margin: 15px;
        }
        .list-group
        {
            font-size: 12px;
        }
        .list_gou
        {
            float: right;
            text-align: right;
        }
        .label-sm
        {
            margin-left: 20px;
            color: #c0c0c0;
        }
    </style>
</head>
<body>
	
	<!-- 订单填写主页 -->
	<div id="orderMain">
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
	    <div class="div_contain">
	         <div class="row" style="margin:0 0 10px 0;padding:0px;background-color:#ffffff;" >
         		 <div class="col-xs-4" style="padding:1px;">
	                	 <img src="${imageRoot}${PHOTOLINKS}" alt="" class="img-responsive" /> 
	            </div>
         		 <div class="col-xs-8" style="padding:5px;">
	                <h4 class="media-heading">${goodsName}</h4>
	            </div>
	        </div>
	        <br/>
	        <ul class="list-group">
	            <!--入网资料-->
	            <a id="netInfoTab" href="#" class="list-group-item">
	                <label>入网资料</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	            <!--配送方式-->
	            <div id="deliverInfoTab" class="list-group-item">
	                <label>配送方式</label>
	                <div id="deliver-select" class="p-list">
                        <a id="deliver-select-post" href="javascript:void(0);"  value="01"  class="selected">快递配送</a>
                        <a href="javascript:void(0);"  value="02" class="disabled" >自提</a>
                    </div>
<!--                     <div> -->
<!--                         <p style="display: none;" id="express-tip" class="line">中国联通免费为您配送</p> -->
<!--                         <p id="fetch-tip" class="line" style="display: block;">请等待客户经理通知自提</p> -->
<!--                     </div> -->
	            </div>
	            <!--物流公司-->
	            <div id="postInfoTab" class="list-group-item">
	                <label>物流公司</label>
	          
	                <div id="post-select" class="p-list">
                        <a id="post-select-none" href="javascript:void(0);"  value="2"  class="selected">宅急送</a>
                        <a id="post-select-shunfeng" href="javascript:void(0);"  value="1"   >顺丰速运</a>
                    </div>
                    <div style="font-size: 12px;color:#c0c0c0;">我们会优先使用您选择的物流公司发货，因配送范围每家物流公司有所不同，如无法送到我们将为您另行安排。</div>
	            </div>
	            
	            <!--收获信息-->
	            <a id="receiveInfoTab" href="#" class="list-group-item">
	                <label>收货信息</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	            
	            <!--其他-->
	            <a id="otherInfoTab" href="#" class="list-group-item">
	                <label>其他</label><label class="label-sm">发票 代金券 备注 推荐人</label><span class="list_gou"><img src="${resRoot}/image/fillOrderMain/jiantou.png" width="9" height="15"></span>
	            </a>
	        </ul>
	
	        <div class="list-group">
	            <a href="javascript:void(0)" class="list-group-item">
	                <label class="label-sm">商品金额</label><span class="list_gou">￥ ${goodsPrice}</span>
	            </a>
	            <a href="javascript:void(0)" class="list-group-item">
	            	<input id="postFee" type="hidden" value="0">
	                <label class="label-sm">运费</label><span class="list_gou">+ ￥00.00</span>
	            </a>
	            <a href="javascript:void(0)" class="list-group-item">
	            	<input id="couponMoney" type="hidden" value="0">
	                <label class="label-sm">代金券</label><span class="list_gou">- ￥00.00</span>
	            </a>
	            <a href="javascript:void(0)" class="list-group-item">
	            	<input id="topayMoney" type="hidden" value="">
	                <label class="label-sm">应付总额</label><span class="list_gou">￥ ${goodsPrice}</span>
	            </a>
	        </div>
	        <br/>
	
	        <div style="font-size: 12px;text-align: center;"><a href="#"><u>为保障您的权益，下单请阅读并确定相关协议</u></a></div>
	        <br/>
	        <button class="btn btn-warning btn-block " type="button" onclick="nextPage()">提交订单</button>
	    </div>
	    
	    <input type="hidden" id="userId"  value="${userId}">
		<input type="hidden" id="goodsId" value="${goodsId}">
		<input type="hidden" id="goodsName" value="${goodsName}">
	    <input type="hidden" id="goodsDisc" value="${goodsDisc}">
	    <input type="hidden" id="goodsPrice" value="${goodsPrice}">
	    <input type="hidden" id="attrVal" value="${attrVal}">
	    <input type="hidden" id="serialNumber" value="${serialNumber}">
	    <#if conPeriod?exists>
	    	<input type="hidden" id="conPeriod" value="${conPeriod}">
    	<#else>
	    	<input type="hidden" id="conPeriod" value="">
	    </#if>
	    
	    <#if conType?exists>
	   		 <input type="hidden" id="conType" value="${conType}">
	    <#else>
	    	<input type="hidden" id="conType" value="">
	    </#if>
	</div>
	
	<!-- 入网资料页 -->
	<div id="netInfo" style="display:none" >
		<#include "picUpload.ftl"> 
	</div>
	
	<!-- 收货信息页 -->
	<div id="receiveInfo" style="display:none" >
		<#include "newReceiveAddress.ftl"> 
	</div>
		
	
	<!-- 其他信息页 -->
	<div id="otherInfo" style="display:none" >
		<#include "otherOrderInfo.ftl"> 
	</div>
</body>
</html>
