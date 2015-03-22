<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>欢迎来到${name}的微店</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain2.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/orderMain3.css?v=${resVer}" rel="stylesheet">
    
  </head>
 <style type="text/css">	 
 	* {margin:0;padding:0;} 
	
	html{
		}
	
	body {
		 }
     html, body , p ,img{
	  margin:0; 
	  padding:0; 
	  border:0;
   	  list-style:none;
	 }

</style>
  
 
 <body >
	<!--标题   -->
 	<div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
				<div id="top_right">
	        	    	<a style="color:#fff;width:40px;height:20px ;line-height:20px;display: block;text-align:center;font-size:14px;float:right;margin-top:20px;margin-right:10px;border:1px solid #fff;text-decoration:none" onclick="saveClick(this); return false;"> 确定 </a>	
	        	</div>	
	</div>
    <!--图片  -->
     <!-- Carousel 广告轮播-->	
    <div id="myCarousel" class="carousel slide" data-ride="carousel" style="background-color:#f1791a">
      <ol class="carousel-indicators">
        <#list goodsDetailPhotosList as item>  
          <#if item_index=0>
            <li data-target="#myCarousel" data-slide-to="${item_index}" class="active"></li>
          <#else>
            <li data-target="#myCarousel" data-slide-to="${item_index}"></li>
          </#if>  
        </#list>  
      </ol>
      <div class="carousel-inner" role="listbox">
        <#list goodsDetailPhotosList as item>
          <#if item_index=0>
            <div class="item active">
          <#else>
            <div class="item">
          </#if>
              <img src='${imageRoot}${item.photoLinks}' onerror="this.src='http://s8.51cto.com/wyfs02/M00/12/34/wKiom1L9bvvxg3qRAAEf2nVs_4E709.png'" alt="" />
              <div class="container">
                <div class="carousel-caption">
              </div>
            </div>
        </div>
        </#list>
      </div>
      
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a> 
      
      </div>
    

     <!--文字  -->
     <div style="margin-bottom:0px;padding-top:10px;padding-bottom:20px;" > 
     	 <#list goodsDetailList as info>	
     	  	 <#if (info_index<=0) > 
							<p style="margin-left:5px;margin-right:5px;margin-bottom:5px;font-size:16px;color:#33333">套餐名称：${info.goodsName}</p>
     						<div style=" width:100%;height:25px;float:none;margin-bottom:10px;">
     		     				<p style="padding:5px;margin-bottom:0px;font-size:15px;color:#717171;float:left;">合约价:</p>	<p style="padding:5px;margin-bottom:0px;float:left; font-size:17px;color:red">¥${info.goodsPrice}（最高返5900）</p>	  
     						</div>
     						<!--
     						<div style=" width:100%;height:25px;float:none;">
     		     				<p style="padding:5px;margin-bottom:0px;font-size:15px;color:#717171;float:left;">商品佣金:</p> <p style="padding:5px;margin-bottom:0px;float:left; font-size:17px;color:red">¥${info.goodsPrice}</p>	    	    		
     						</div>  
     						 -->
     								
     					  <input id = "hideTag" type = "hidden" name = 'hideTag' value = ${info.goodsId}>
     							
 			 </#if>

		</#list> 
     			    		
     </div>
     <!-- 自定义活动 -->
      <div style="width:100%;margin-bottom:20px;padding-top:0px;padding-bottom:20px;" >  
     	    	<p style="background-color:gray; width:100%;height:1px ;margin:auto;"> </p> 
       	    	<p style="margin:10px;font-size:17px;color:#484848">自定义活动 </p> 
       	    		<#if (goodsActivityList?size>0) > 
						 <#list goodsActivityList as info>	
       	  				  <#if (info_index<=0) > 
							<div style="width:100%;height:50px;margin-bottom:10px;padding-top:10px;">
       	   						<p style="width:60px;height:30px;line-height:30px;margin-left:10px;margin-bottom:10px;float:left;color:#878787">活动标题 </p> 
       	   						<input id="title" style="width:70%;height:30px;margin-right:30px;float:right;padding-left:10px;"  type="tel" placeholder="赠品：虎牌保温杯" value=${info.atyTitle}></input>    	   			
       	   					</div>
       	   				<!--活动详情  -->
       	   					<div style="width:100%;height:150px;margin-bottom:10px;padding-top:10px;padding-bottom:10px;">
       	   							<p style="width:60px;height:20px;margin-left:10px;margin-bottom:10px;float:left;color:#878787">活动详情 </p> 
       	   							<textarea id="content" style="width:70%;height:120px;margin-right:30px;float:right;padding:10px;" >${info.atyContent}</textarea>     	   			
       	   					</div>  			
 							 </#if>

						</#list> 
 					<#else>						
					<!--活动标题  -->
							<div style="width:100%;height:50px;margin-bottom:10px;padding-top:10px;">
       	   						<p style="width:60px;height:30px;line-height:30px;margin-left:10px;margin-bottom:10px;float:left;color:#878787">活动标题 </p> 
       	   						<input id="title" style="width:70%;height:30px;margin-right:30px;float:right;padding-left:10px;"  type="tel" placeholder="赠品：虎牌保温杯" value=''></input>    	   			
       	   					</div>
       	   			<!--活动详情  -->
       	   					<div style="width:100%;height:150px;margin-bottom:10px;padding-top:10px;padding-bottom:10px;">
       	   							<p style="width:60px;height:20px;margin-left:10px;margin-bottom:10px;float:left;color:#878787">活动详情 </p> 
       	   							<textarea id="content" style="width:70%;height:120px;margin-right:30px;float:right;padding:10px;" ></textarea>     	   			
       	   					</div>  
					</#if>
 		 	    		
     </div>
     
     
 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
 	<script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
     <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    
     <script>
   			  function saveClick(obj) {
					//	title  标题
					//	content 内容
					var title = document.getElementById('title');					
					if(title.value.length == 0){
						alert('活动标题不能为空');
						return;
					}
					var content = document.getElementById('content');  
					if(content.value.length == 0){
						alert('活动详情不能为空');
						return;
					}
					var goodsId = $("#hideTag").val();
					 //ajax 操作，刷新本界面数据   
		  	 		var parms = {'goodsId':goodsId,'title':title.value,'content':content.value};
				
					//ajax 操作，刷新本界面数据     	  		
					$.ajax({
		  				 type: "POST",
		  				 url: "goodsManageGoodDetailUpdate",
		  				 data: parms,
		 				 success: function(data){
		  			     history.back();	  			   
		 			  }
					});		
					}	
	  </script>     

  </body>
</html>
