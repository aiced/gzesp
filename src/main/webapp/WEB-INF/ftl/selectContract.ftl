<!DOCTYPE html>
<html lang="zh-cn">

  <body>
    <!-- nav bar -->
     <div id="top">
       	<div id="selectContractBackBtn"><div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div></div>
       	<div id="top_middle">选择合约</div>
       	<div id="top_right"></div>
     </div>
    
    <div class="container-fluid" style="background-color:#e5e5e5;margin-top:1px;padding:3px">
	    <div class="row" >
		    <div class="col-xs-6" style="border-right:solid 1px #f4f4f4;" >
 		     	<button style="padding:2px;margin-top:3px;width:100%;height:36px;display: block;text-align:center;background-color:#e5e5e5;" class="btn dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true"> 
			    	<label id="packName" class="text-center label-sm">套餐资费选择</label>
					<span ><img src="${resRoot}/image/fillOrderMain/jiantou4.png" width="10" height="10"></span>
 			 	 </button> 
	           <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1" style="margin:-1px 0px 0px 2px;background-color:#e5e5e5;">
	           			<#if (pkgList?? && pkgList?size>0)>
		        	  	<#list pkgList as item>  
							<li role="presentation"  onclick="javascript:showActPkg(this)">
						  		 <a style=" line-height:1;vertical-align:middle;" role="menuitem" tabindex="-1" href="javascript:void(0)">${item.name}</a>
						         <input type="hidden" id="goodsId_hidden" value="${item.goodsId}">
						         <input type="hidden" id="pkgType_hidden" value="${item.name}">
						         <input type="hidden" id="resId_hidden" value="${item.resId}">
						         <input type="hidden" id="packVal_hidden" value="${item.val}">
							  </li>
							  <#if item_has_next>
								  <li role="presentation" class="divider" style="background-color:white"></li>
							  </#if>
						</#list> 
						<#else>
								 <a  style=" vertical-align:middle;width:100%;height:40px;display: block;text-align:center;color:black" role="menuitem" tabindex="-1" href="javascript:void(0)"><无选项></a>
						</#if>
					</ul>
	        </div>
	        <div class="col-xs-6"  style="line-height:1;padding-left:2px">
	         	<button style="padding:2px;margin-top:3px;width:100%;height:36px;display: block;text-align:center;background-color:#e5e5e5;" class="btn dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-expanded="true"> 
			    	<label id="pageName" class="text-center label-sm">合约期限选择</label>
			    	<span ><img src="${resRoot}/image/fillOrderMain/jiantou4.png" width="10" height="10"></span>
		    </button> 
		    	
<!-- 	       		<button class="btn btn-default  btn-lg btn-block dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-expanded="true"> -->
<!-- 				    <span id="pageName">合约期限选择</span> -->
<!-- 				    <span class="caret"></span> -->
<!-- 			 	 </button> -->
	        		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2" style="margin:0px 0px 0px -2px;background-color:#e5e5e5;">
	        			<#if (peroidList?? && peroidList?size>0)>
	        			<#list peroidList as item>  
							  <li role="presentation"	onclick="javascript:selectPeriod(this)" >
							   <a  style="line-height:1;vertical-align:middle;" role="menuitem" tabindex="-1" href="javascript:void(0)">${item.name}</a>
							  <input type="hidden" id="resId_hidden" value="${item.resId}">
						      <input type="hidden" id="pageName_hidden" value="${item.name}">
						      <input type="hidden" id="pageVal_hidden" value="${item.val}">
							  </li>
							   <#if item_has_next>
								  <li role="presentation" class="divider" style="background-color:white"></li>
							  </#if>
						</#list> 						
						<#else>
								 <a  style=" line-height:1;vertical-align:middle;width:100%;height:40px;display: block;text-align:center;color:black" role="menuitem" tabindex="-1" href="javascript:void(0)"><无选项></a>
						</#if> 
					</ul>
	        </div> 
        </div>  
         <div class="row" >
		    <div class="col-xs-12" >${simpDesc}</div>
		</div>   
     </div>
<!--      <div class="container-fluid" style="position:absolute; bottom:6%; width:100%"> -->
<!--      	<button id="selectConOkBtn" type="button" class="btn btn-warning  btn-lg btn-block" >确定合约</button> -->
<!--       </div> -->
      

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="${resRoot}/js/selectContract.js?v=${resVer}"></script>
  </body>
</html>
