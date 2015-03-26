<!DOCTYPE html>
<html lang="zh-cn">

  <body>
    <!-- nav bar -->
     <div id="top">
       	<div id="selectContractBackBtn"><div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div></div>
       	<div id="top_middle">${title}</div>
       	<div id="top_right"></div>
     </div>
    
    <div class="container-fluid">
	    <div class="row" >
		    <div class="col-xs-6" >
		     	<button class="btn btn-default btn-lg btn-block dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
				    <span id="packName">套餐资费选择</span>
				    <span class="caret"></span>
			 	 </button>
	           <ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
	           			<#if (pkgList?? && pkgList?size>0)>
		        	  	<#list pkgList as item>  
							<li role="presentation" onclick="javascript:showActPkg(this)">
						  		 <a role="menuitem" tabindex="-1" href="javascript:void(0)">${item.name}</a>
						         <input type="hidden" id="goodsId_hidden" value="${item.goodsId}">
						         <input type="hidden" id="pkgType_hidden" value="${item.name}">
						         <input type="hidden" id="resId_hidden" value="${item.resId}">
						         <input type="hidden" id="packVal_hidden" value="${item.val}">
							  </li>
						</#list>   
						</#if>
					</ul>
	        </div>
	        <div class="col-xs-6 ">
	       		<button class="btn btn-default  btn-lg btn-block dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-expanded="true">
				    <span id="pageName">合约期限选择</span>
				    <span class="caret"></span>
			 	 </button>
	        		<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu2">
	        			<#if (peroidList?? && peroidList?size>0)>
	        			<#list peroidList as item>  
							  <li role="presentation"	onclick="javascript:selectPeriod(this)">
							   <a role="menuitem" tabindex="-1" href="javascript:void(0)">${item.name}</a>
							  <input type="hidden" id="resId_hidden" value="${item.resId}">
						      <input type="hidden" id="pageName_hidden" value="${item.name}">
						      <input type="hidden" id="pageVal_hidden" value="${item.val}">
							  </li>
						</#list> 
						</#if> 
					</ul>
	        </div> 
        </div>     
     </div>
     <div class="container-fluid" style="position:absolute; bottom:6%; width:100%">
     	<button id="selectConOkBtn" type="button" class="btn btn-warning  btn-lg btn-block" >确定合约</button>
      </div>
      

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
     <script src="${resRoot}/js/selectContract.js?v=${resVer}"></script>
  </body>
</html>
