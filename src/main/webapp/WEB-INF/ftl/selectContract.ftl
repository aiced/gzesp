<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
	
	<style type="text/css">
	.p-list{overflow:hidden;}
	.p-list a{float:left;width:32%;height:32px;line-height:32px;margin:0 2% 10px 0;text-align:center;border:1px solid #ccc;font-weight:bold;font-size:13px;color:#2f3e46;background:#fff;
		-moz-box-sizing:border-box;-webkit-box-sizing:border-box;box-sizing:border-box;
		-moz-border-radius:4px;-webkit-border-radius:4px;border-radius:4px;
		text-decoration:none;
	}
	.p-list a:nth-child(3n){margin-right:0;}
	.p-list a.selected{border:1px solid #ec661b;color:#e8742b;
		background:url(${resRoot}/image/common/selected.png) no-repeat right bottom #fff;
		background-size:20px 16px;
	}
	.p-list a.disabled{cursor:default;background:#dcdcdc;color:#aaa;}
	.p-list a:visited{color:#2F3E46;}
	.p-list a.disabled:visited{color:#999;}
	.p-list a.mrg-r-0{margin-right:0;}
	
	.p-tab li{
		list-style-type:none; 
		display: block;
		width: 55px;
		height: 40px;
		line-height: 40px;
		padding-top: 5px;
		padding-left: 10px;
		border-right: 1px solid #DDD;
		border-bottom: 1px solid #E6E6E6;
		text-align: left;
		background: none repeat scroll 0% 0% #FFF4D8;
		font-size: 15px;
		color: #333;
		box-shadow: 0px 1px 1px #DDD;}
	.p-tab li.selected{
		border-left: 5px solid #E8742B;
		border-right-color: #FFF;
		color: #E8742B;
		background: none repeat scroll 0% 0% #FFC;
		box-shadow: -1px 1px 1px #DDD;}
	</style>
  </head>

  <body>
    <!-- nav bar -->
     <div id="top">
        	<div id="top_left"></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
    
    <div class="container-fluid" style="padding:5px">
	    <div class="row" style="margin:0px;">
	        <div style="float: left;">
	        	  <ul id="p-tab" class="p-tab list-group">
	        	 	 <#list pkgList as pkg>  
	        	 	 <#if pkg_index == 0>
						  <li class="selected">
					 <#else>
						  <li >
					 </#if> 
					  	<h5>${pkg.price}</h5>
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
						  	<td></td>
						  </tr>
						  <tr>
						  	<td>国内流量</td>
						  	<td></td>
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
						  	<td></td>
						  </tr>
						  <tr>
						  	<td >返款总金额</td>
						  	<td></td>
						  </tr>
						  <tr>
						  	<td >每月返还金额</td>
						  	<td></td>
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
    <script>
	    $(function() {
	    	$('#period-select a').bind("click",function(){
	    	    	  $(this).addClass("selected").siblings().removeClass("selected");
	    	    	  return false;
	    	      });
	    	
	    	$('#p-tab li').bind("click",function(){
	    	    	  $(this).addClass("selected").siblings().removeClass("selected");
	    	    	  return false;
	    	      });
	    })
	    
		function nextPage() {
			var parms = {'name':'leoxu', 'age':'1' };
			
			 $.commonFormSubmit({  
     	        action : '${base}/weShop/index', 
				data: parms,
     	        success : function(rtdata, status) { 
     	        }  
     	    });  
		}
	</script>
  </body>
</html>
