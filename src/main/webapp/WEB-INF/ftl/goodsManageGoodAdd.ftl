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

         
  </head>
 
 <style type="text/css">	 
 	* {margin:0;padding:0;} 
	
	html{
/*  		background-color:gray;
 */		}
	
	body {
	/*	默认有个高度 20px */
/* 		 background-color:red;
 */		 }
     html, body , p ,img{
	  margin:0; 
	  padding:0; 
	  border:0;
   	  list-style:none;
	 }
	 

table{
/*     margin:0px auto;
 */
 	border-collapse: collapse;
    margin-top: 0px;
    margin-bottom:0px;
    width: 100%;
	
}
.td_first{
	width: 11%;
	vertical-align: middle; 
	background-color:#E8E9E8;
	text-align:center;  
	
}
.td_second{
	width: 89%;
	vertical-align: middle; 
	background-color:#E8E9E8;
	text-align:center;  
	
}

</style>
 
 <body >
	<!--标题   -->
 		   <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right">
	        			<#list goodsList as info>
						 <#if (info_index<=0) > 
						   <a style="color:#fff;width:40px;height:20px ;line-height:20px;display: block;text-align:center;font-size:14px;float:right;margin-top:20px;margin-right:10px;border:1px solid #fff" onclick="saveClick(${goodsList?size}); return false;"> 确定 </a>	
						 </#if>

	        			</#list>
	        
	        	</div>
	        </div>
    <!--搜索  -->
    <div style="background-color:white;width:100%;overflow:hidden;margin-top:20px;">
  			 <input id = "searchInput" type="text" placeholder="请输入商品关键字" style ="width:60%;height:30px;margin-top:10px;float:left;margin-bottom:10px;margin-left:20px;padding-left:15px;border:1px solid #A6A6A6;font-size:14px">
 			 <a style="width:60px;height:30px;display:block;text-align:center;float:left;line-height:30px;margin-top:10px;margin-bottom:10px;margin-left:20px;border:1px solid #A6A6A6;font-size:12px;" onclick="searchWord(this); return false;">搜索</a>
	</div >
    <!--选择  -->
	<div style="background-color:white;width:100%;height:32px;margin-bottom:0px;position:relative;">
		<div style="float:left;width:150px;height:30px;">
			 <a style="width:80px;height:30px;display:block;text-align:center;float:left;line-height:30px;margin-left:20px;font-size:15px;color:#818181" onclick="multipleSoft(this); return false;" >综合排序</a>
			 <img src="${resRoot}/image/goodsManager/xiaLaSanJiao.png" style="width:10px;height:10px;float:left;margin-left:0px;margin-top:10px;"></img>
		</div>
		<div style="float:right;width:150px;height:30px">
			 <a style="width:60px;height:30px;display:block;text-align:center;float:left;line-height:30px;margin-left:20px;font-size:15px;color:#818181" onclick="showFlowView(this); return false;">筛选</a>
			 <img src="${resRoot}/image/goodsManager/xiaLaSanJiao.png" style="width:10px;height:10px;float:left;margin-left:0px;margin-top:10px;"></img>
		</div>
		<div style="background-color:gray;float:left;width:100%;height:1px;margin-top:0px">
		</div>
		<!-- 筛选条件 -->
		<div id="searchMark" style="float:left;width:100%;height:600px;top:31px;display:none;position:absolute;margin:auto;z-index:100;">
			    	<div id="searchMarkSub" style="background-color:white;width:260px;height:180px;margin:auto;;border:1px solid #A6A6A6;">
			    		<p style="width:60px;height:20px;line-height:20px;margin-top:10px;margin-left:5px;float:left;font-size:13px;color:#807E7E">奖励区间 </p> 
			    	    <input id="startInput" type="text" style ="width:68px;height:20px;margin-top:10px;float:left;margin-left:0px;padding-left:5px;border:1px solid #7A7A7A;font-size:14px">
			    		<div style="background-color:#C7C7C7;float:left;width:15px;float:left;height:1px;margin-left:10px;margin-top:19px">
						</div>
			    		<input id="endInput" type="text" style ="width:68px;height:20px;margin-top:10px;float:left;margin-left:10px;padding-left:5px;border:1px solid #7A7A7A;font-size:14px">
			    		<!-- 商品类型 -->
			    		<p style="width:100%;height:20px;line-height:20px;margin-top:10px;margin-left:5px;float:left;font-size:13px;color:#807E7E">商品类型 </p> 
			    		<div style="background-color:#C2C2C2;float:left;width:100%;float:left;height:1px;margin-left:0px;margin-top:1px">
						</div>
						<a style="color:#7E7D7D;width:60px;height:20px ;line-height:20px; float:left;display: block;text-align:center;margin-left:5px;margin-top:10px;border:1px solid #7E7D7D;font-size:11px;" onclick="setTagCondition(4); return false;">合约购机</a>	
						<a style="color:#7E7D7D;width:60px;height:20px ;line-height:20px; float:left;display:block;text-align:center;margin:auto;margin-top:10px;margin-left:35px;border:1px solid #7E7D7D;font-size:11px;" onclick="setTagCondition(6); return false;">上网卡</a>	
						<a style="color:#7E7D7D;width:60px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:5px;margin-top:10px;border:1px solid #7E7D7D;font-size:11px;" onclick="setTagCondition(7); return false;">宽带续约</a>	
						
						<a style="color:#7E7D7D;width:65px;height:20px ;line-height:20px; float:left;display: block;text-align:center;margin-left:5px;margin-top:20px;border:1px solid #7E7D7D;font-size:11px;" onclick="setTagCondition(8); return false;">流量包</a>							
						<div style="float:left;margin-top:20px;width:100%;float:left;height:20px;margin-left:0px">
						<a style="background-color:#4171BC;color:white;width:60px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:5px;font-size:11px " onclick="searchPrice(this); return false;">确定</a>	
						<a style="background-color:#D0D0D0;color:#808080;width:60px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:5px;border:1px solid #7E7D7D;font-size:11px;resetPrice(this)" onclick="resetPrice(this); return false;">重置</a>	
						</div>

			    	</div>
		</div>	
		
	</div>
	
	<!--列表  -->
	  <div style="background-color:blue;width:100%;overflow:hidden">
		<table>
			<tbody id = "datagrid">			
			
				<#list goodsList as info>			
				<tr style=" height:100px;">
					<td class = "td_first" style="position:relative; height:100px;" >
							<a style="width:15px;height:15px;display: block;position:absolute;;left:10px;top:35px" onclick="showSelectedView(${info_index},${goodsList?size});return false;">
								<img id="unSelected" src=${resRoot}/image/goodsManager/unSelected.png style="width:15px;height:15px;display: block;position:absolute;">
							</a>
							
							<a  style="width:20px;height:20px;display: block;position:absolute;;left:12px;top:28px" onclick="showSelectedView(${info_index},${goodsList?size});return false;">
								<img id="leftItemSelected_${info_index}" src=${resRoot}/image/goodsManager/itemSelected.png style="width:20px;height:20px;display:block;visibility:hidden; position:absolute;" >							
							</a>
							
					</td>
					<td class = "td_second">
							<a id="itemSelected_${info_index}" style="background-color:white;display:block; width:100%;height:70px;margin-top:15px;margin-bottom:15px" onclick='itemClick(${info.goodsId})'>
         	     				<img src='${info.photoLinks}' style="display:block;width:75px;height:50px;float:left;margin-left:10px;margin-top:10px">
								<div style="float:left;width:170px;float:left;height:50px;margin-left:15px;margin-top:10px;text-overflow:clip | ellipsis">								
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;color:#807E7E">总部商品－${info.goodsCtlgName}</p> 
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;background-color:red;color:#807E7E;overflow: hidden; white-space: nowrap; text-overflow: ellipsis;">${info.goodsName}</p> 
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;background-color:blue;color:#807E7E">合约机:${info.addPrice}</p> 									
								</div>
							</a>
					</td>
				</tr>
				</#list>
			
			</tbody>
		</table>
	 </div >
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
     <script src="${resRoot}/js/goodsManager/goodsManagerGoodAdd.js?v=${resVer}"></script>
    
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
     <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
	 <script type="text/javascript">
		$(document).ready(function(){  
		});
   	</script>
	
	
	
	 <script>
		function itemClick(obj) {
			var parms = {'goodsId':obj};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodDetail', 
				data: parms,
     	        success : function(rtdata, status) { 
     	        }  
     	    });  
		}
	</script>
	
	
	 <script>
		function saveClick(obj) {
		
			var goodsIndex = null;
			var goodsId = null;
			for(var i = 0;i<obj;i++){
				var id = "leftItemSelected_" + i;
				if (getComputedStyle(document.getElementById(id)).visibility == "visible"){
					  goodsIndex = i;
					  break;
				}
			}	
			
	      	<#list goodsList as info>
	      		if(${info_index}==goodsIndex){
	      				goodsId = ${info.goodsId};
	      				
		  		  }	
			</#list>

			if(goodsId == null){
				history.back();
			}
			
			
		     //ajax 操作，刷新本界面数据     	  		
		  	 	var parms = {'goodsId':goodsId};
				$.ajax({
		  			 type: "POST",
		  			 url: "goodsManageGoodAddInsert",
		  			 data: parms,
		 			 success: function(data){
				   	window.history.go(-1);
					window.location.reload()
		  			   
		 		  }
				});		
		}
	 </script>

    
    
  </body>
</html>