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
        .lableFontSize label{
            font-size: 16px;
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
	        <ul class="list-group lableFontSize">
	            <!--入网资料-->
	            <a id="netInfoTab" href="#" class="list-group-item">
	                <label>入网资料 <#if (offline_flag=0)>（必填）<#else>（有二代证读卡器可后续补录身份证）</#if> </label>
	                <span class="list_gou">
	                	<img src="${resRoot}/image/fillOrderMain/jiantou2.png" width="9" height="18">
                	</span>
	            </a>
	            <!--配送方式-->
	            <div id="deliverInfoTab" class="list-group-item">
	                <label>配送方式</label>
	                <div id="deliver-select" class="p-list">
                        <#if (offline_flag=1)>
	                        <a id="deliver-select-post" href="javascript:void(0);"  value="01"  >快递配送</a>
	                        <a href="javascript:void(0);"  value="03" class="selected">现场写卡</a>
                        <#else>
                        	<a id="deliver-select-post" href="javascript:void(0);"  value="01"  class="selected">快递配送</a>
                        </#if>
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
                        <a id="post-select-none" href="javascript:void(0);"  value="2"  >宅急送</a>
                        <a id="post-select-shunfeng" href="javascript:void(0);"  value="1"  class="selected" >顺丰速运</a>
                    </div>
                    <div style="font-size: 12px;color:#c0c0c0;">我们会优先使用您选择的物流公司发货，因配送范围每家物流公司有所不同，如无法送到我们将为您另行安排。</div>
	            </div>
	            
	            <!--收获信息-->
	            <a id="receiveInfoTab" href="#" class="list-group-item">
	                <label>收货信息<#if (offline_flag=0)>（必填）<#else>（现场写卡的可不填）</#if> </label>
	                 <span class="list_gou">
	                	<img  src="${resRoot}/image/fillOrderMain/jiantou2.png" width="9" height="18">
                	</span>
	            </a>
	            
	            <!--其他-->
	            <a id="otherInfoTab" href="#" class="list-group-item">
	                <label>其他</label><label class="label-sm">发票  备注 推荐人</label>
	                 <span class="list_gou">
	                	<img src="${resRoot}/image/fillOrderMain/jiantou2.png" width="9" height="18">
                	</span>
	            </a>
	            
	            <#if showFMonthD?exists && showFMonthD && fMonthDList>
	            <!--首月资费-->
	            <div id="firstMonthFeeInfoTab" href="#" class="list-group-item">
	                <label>套餐生效时间</label>
	                <div id="firstMonthFee-select" class="p-list">
	        	  	<#list fMonthDList as item>
		        	  	<#if item_index == 0>
	                        <a href="javascript:void(0);" data-descId="fMonthDesc_${item_index}" value="${item.attrValCode}"  class="selected">${item.attrValName}</a>
                        <#else>
	                        <a href="javascript:void(0);" data-descId="fMonthDesc_${item_index}" value="${item.attrValCode}" >${item.attrValName}</a>
		        	  	</#if>
               		</#list> 
                    </div>
                    <div>
                    <#list fMonthDList as item>
		        	  	<#if item_index == 0>
	                        <p id="fMonthDesc_${item_index}" style="font-size: 12px;color:#c0c0c0;">${item.values1}</p>
		        	  	<#else>
	                        <p id="fMonthDesc_${item_index}" style="font-size: 12px;color:#c0c0c0;" class="hide" >${item.values1}</p>
		        	  	</#if>
               		</#list>
                    </div>
	            </div>
	            </#if>
	            
	        </ul>
	
	        <div class="list-group">
	            <a href="javascript:void(0)" class="list-group-item">
	                <label class="label-sm">商品金额</label><span class="list_gou">￥ ${totalPrice}</span>
	            </a>
	            <a href="javascript:void(0)" class="list-group-item">
	            	<input id="postFee" type="hidden" value="0">
	                <label class="label-sm">运费</label><span class="list_gou">+ ￥00.00</span>
	            </a>
	            <input id="couponMoney" type="hidden" value="0">
	            <!-- <a href="javascript:void(0)" class="list-group-item">
	                <label class="label-sm">代金券</label><span class="list_gou">- ￥00.00</span>
	            </a> -->
	            <a href="javascript:void(0)" class="list-group-item">
	            	<input id="topayMoney" type="hidden" value="">
	                <label class="label-sm">应付总额</label><span class="list_gou">￥ ${totalPrice}</span>
	            </a>
	        </div>
	        <br/>
	
	        <div style="font-size: 12px;text-align: left;border:dashed 1px #F0AD4E;color:red;padding:15px;font-weight: bold;">号码选定后我们只为您保留30分钟，请在提交订单后尽快完成支付!</div>
	        <br/>
	        <button id="submitOrdBtn" class="btn btn-warning btn-block " type="button" onclick="nextPage()">提交订单</button>
	    </div>
	    
	     <input type="hidden" id="token" name="token" value="${token}" />
	    <input type="hidden" id="userId"  value="${userId}">
		<input type="hidden" id="goodsId" value="${goodsId}">
		<input type="hidden" id="goodsName" value="${goodsName}">
	    <input type="hidden" id="goodsDisc" value="${goodsDisc}">
	    <input type="hidden" id="goodsPrice" value="${goodsPrice}">
	    <input type="hidden" id="totalPrice" value="${totalPrice}">
	    <input type="hidden" id="attrVal" value="${attrVal}">
	    <input type="hidden" id="serialNumber" value="${serialNumber}">
	    
	    <input type="hidden" id="ctlgCode" value="${ctlgCode}"></input>
	    <input type="hidden" id="originalPrice"  value="${originalPrice}"></input>
	    <input type="hidden" id="albumId"  value="${albumId}"></input>
	    <input type="hidden" id="verNo"  value="${verNo}"></input>
	    <input type="hidden" id="merchantId"  value="${merchantId}"></input>
	    <input type="hidden" id="createTime"  value="${createTime}"></input>
	    <input type="hidden" id="createStaffId" value="${createStaffId}"></input>
	    <input type="hidden" id="goodsState"  value="${goodsState}"></input>
	    <input type="hidden" id="recomTag"  value="${recomTag}"></input>
	    <input type="hidden" id="priceRule"  value="${priceRule}"></input>
	    <input type="hidden" id="beginTime" value="${beginTime}"></input>
	    <input type="hidden" id="endTime"  value="${endTime}"></input>
	    <input type="hidden" id="simpDesc" value="${simpDesc}"></input>
	    <input type="hidden" id="offline_flag" value="${offline_flag}"></input>
	    
	    <#if showFMonthD?exists && showFMonthD>
	   		<input type="hidden" id="fMonthDResId" value="${fMonthDResId}">
    	<#else>
	    	<input type="hidden" id="fMonthDResId" value="">
	    </#if>
	    
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
	    
	    <input type="hidden" id="isAndroidWeiXin" value="${isAndroidWeiXin}">
	</div>
	
	<!-- 入网资料页 -->
	<div id="netInfo" style="display:none" >
		<#if isAndroidWeiXin?exists && isAndroidWeiXin>
			<#include "picUpload2.ftl"> 
		<#else>
			<#include "picUpload.ftl"> 
	    </#if>
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
