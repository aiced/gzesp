<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>欢迎来到${name}的微店</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
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
    <div style="background-color:#1D2427; width:100%;height:44px;margin-left:0px;margin-bottom:0px;" >   	
     	<a style="color:#fff;width:60px;height:44px ;line-height:44px; float:left;display: block;text-align:center;margin-left:1px"> 返回 </a>	
    	<a style="color:#fff;width:40px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:10px;margin-top:12px;border:1px solid #fff"> 编辑 </a>	
    	<p style="color:#fff;width:60px;height:44px ;line-height:44px;margin:auto;"> 商品管理 </p> 	
    </div>
    <!--搜索  -->
    <div style="background-color:white;width:100%;overflow:hidden">
  			 <input type="text" placeholder="请输入商品关键字" style ="width:60%;height:30px;margin-top:10px;float:left;margin-bottom:10px;margin-left:20px;padding-left:15px;border:1px solid #A6A6A6;font-size:14px">
 			 <a style="width:60px;height:30px;display:block;text-align:center;float:left;line-height:30px;margin-top:10px;margin-bottom:10px;margin-left:20px;border:1px solid #A6A6A6;font-size:12px">搜索</a>
	</div >
    <!--选择  -->
	<div style="background-color:white;width:100%;height:32px;margin-bottom:0px;position:relative;">
		<div style="float:left;width:150px;height:30px;">
			 <a style="width:80px;height:30px;display:block;text-align:center;float:left;line-height:30px;margin-left:20px;font-size:15px;color:#818181">综合排序</a>
			 <img src="${resRoot}/image/goodsManager/xiaLaSanJiao.png" style="width:10px;height:10px;float:left;margin-left:0px;margin-top:10px;"></img>
		</div>
		<div style="float:right;width:150px;height:30px">
			 <a style="width:60px;height:30px;display:block;text-align:center;float:left;line-height:30px;margin-left:20px;font-size:15px;color:#818181" onclick="showFlowView(this); return false;">筛选</a>
			 <img src="${resRoot}/image/goodsManager/xiaLaSanJiao.png" style="width:10px;height:10px;float:left;margin-left:0px;margin-top:10px;"></img>
		</div>
		<div style="background-color:gray;float:left;width:100%;height:1px;margin-top:0px">
		</div>
		<!-- 筛选条件 -->
		<div id="searchMark" style="float:left;width:100%;height:180px;top:31px;display:none;position:absolute;margin:auto;z-index:100;">
			    	<div style="background-color:white;width:260px;height:180px;margin:auto;;border:1px solid #A6A6A6;">
			    		<p style="width:60px;height:20px;line-height:20px;margin-top:10px;margin-left:5px;float:left;font-size:13px;color:#807E7E">奖励区间 </p> 
			    	    <input type="text" style ="width:68px;height:20px;margin-top:10px;float:left;margin-left:0px;padding-left:5px;border:1px solid #7A7A7A;font-size:14px">
			    		<div style="background-color:#C7C7C7;float:left;width:15px;float:left;height:1px;margin-left:10px;margin-top:19px">
						</div>
			    		<input type="text" style ="width:68px;height:20px;margin-top:10px;float:left;margin-left:10px;padding-left:5px;border:1px solid #7A7A7A;font-size:14px">
			    		<!-- 商品类型 -->
			    		<p style="width:100%;height:20px;line-height:20px;margin-top:10px;margin-left:5px;float:left;font-size:13px;color:#807E7E">商品类型 </p> 
			    		<div style="background-color:#C2C2C2;float:left;width:100%;float:left;height:1px;margin-left:0px;margin-top:1px">
						</div>
						<a style="color:#7E7D7D;width:60px;height:20px ;line-height:20px; float:left;display: block;text-align:center;margin-left:5px;margin-top:10px;border:1px solid #7E7D7D;font-size:11px">新网入号</a>	
						<a style="color:#7E7D7D;width:60px;height:20px ;line-height:20px; float:left;display:block;text-align:center;margin:auto;margin-top:10px;margin-left:35px;border:1px solid #7E7D7D;font-size:11px">合约购机</a>	
						<a style="color:#7E7D7D;width:60px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:5px;margin-top:10px;border:1px solid #7E7D7D;font-size:11px">上网卡</a>	
						
						<a style="color:#7E7D7D;width:65px;height:20px ;line-height:20px; float:left;display: block;text-align:center;margin-left:5px;margin-top:20px;border:1px solid #7E7D7D;font-size:2px;}">特色流量包</a>	
						<a style="color:#7E7D7D;width:60px;height:20px ;line-height:20px; float:left;display:block;text-align:center;margin:auto;margin-top:20px;margin-left:30px;border:1px solid #7E7D7D;font-size:11px">宽带续约</a>	
						
						<div style="float:left;margin-top:20px;width:100%;float:left;height:20px;margin-left:0px">
						<a style="background-color:#4171BC;color:white;width:60px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:5px;font-size:11px">确定</a>	
						<a style="background-color:#D0D0D0;color:#808080;width:60px;height:20px ;line-height:20px; float:right;display: block;text-align:center;margin-right:5px;border:1px solid #7E7D7D;font-size:11px">重置</a>	
						</div>

			    	</div>
		</div>	
		
	</div>
	
	<!--列表  -->
	  <div style="background-color:blue;width:100%;overflow:hidden">
		<table>
			<tbody>			
			
				<#list list as info>			
				<tr style="background-color:red; height:100px;">
					<td class = "td_first" style="position:relative; height:100px;" onclick="test(1)" >
							<a style="width:15px;height:15px;display: block;position:absolute;;left:10px;top:35px" onclick="showSelectedView(${info_index});return false;">
								<img id="unSelected" src=${resRoot}/image/goodsManager/unSelected.png style="width:15px;height:15px;display: block;position:absolute;">
							</a>
							
							<a id="itemSelected_${info_index}" style="width:20px;height:20px;display: block;position:absolute;;left:12px;top:28px" onclick="showSelectedView(${info_index});return false;">
								<img src=${resRoot}/image/goodsManager/itemSelected.png style="width:20px;height:20px;display: block;position:absolute;" >							
							</a>
							
					</td>
					<td class = "td_second" onclick="test(2)" >
							<div id="first_row"  style="background-color:white; width:100%;height:70px;margin-top:15px;margin-bottom:15px">
         	     				<img src="${resRoot}/image/dztj/dztj_iphone6.jpg" style="background-color:red;display:block;width:75px;height:50px;float:left;margin-left:10px;margin-top:10px">
								<div style="float:left;width:170px;float:left;height:50px;margin-left:15px;margin-top:10px">								
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;color:#807E7E">总部商品－合约特惠</p> 
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;color:#807E7E">苹果（Apple）iPhone 6 16G</p> 
									<p align=left style="width:100%;height:16px;line-height:16px;padding-left:5px;float:left;font-size:10px;color:#807E7E">合约机:5288 &nbsp<font color="#F70909">商品佣金:1000</font></p> 
								</div>
							</div>
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
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    <script type="text/javascript">
		$(document).ready(function(){  
		   //[获取验证码]按钮点击
		  $("#first_row").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'name':'leoxu', 'age':'1', 'index':'1'};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodDetail', 
				data: parms
     	    });  
		  }); 
		   $("#second_row").click(function(){  
		  //在这里操作获取验证码
		  	var parms = {'name':'leoxu', 'age':'1', 'index':'1'};
			 $.commonFormSubmit({  
     	        action : '${base}/shopManage/goodsManageGoodDetail', 
				data: parms
     	    });  
		  }); 
		  
		});
	</script>
    
    
  </body>
</html>