<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>${title}</title>

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
  </head>
  <body style = "background-color:rgb(240, 240, 240)">
<p>
    &nbsp &nbsp <span style="font-size: 24px; font-family: arial, helvetica, sans-serif;">菜鸟掌柜——销售进阶之道！</span><br/>
</p>

<blockquote class="wxqq-borderTopColor wxqq-borderRightColor wxqq-borderBottomColor wxqq-borderLeftColor" style="margin-left: 10px;margin-right: 10px; padding: 15px; border: 1px solid rgb(235, 164, 50);">
    <p style="white-space: normal; text-align: center;line-height: 15px;width:100%;height:15px;display:block;">
        <span style="color: rgb(89, 89, 89); font-size: 14px;">说不完的江湖风云，叨不尽的赚钱秘籍</span>
    </p>
    <p style="white-space: normal; text-align: center;line-height: 15px;width:100%;height:15px;display:block;">
        <span style="color: rgb(89, 89, 89); font-size: 14px;">各种销售推广大招轮番来袭</span>
    </p>
    <p style="white-space: normal; text-align: center;line-height: 15px;width:100%;height:15px;display:block;">
        ☞<span style="color: rgb(89, 89, 89); font-size: 14px;">菜鸟掌柜的升级进阶指南</span>
    </p>
</blockquote>


<p>
    <img style="width: 100%; height: auto !important;" src="http://mmbiz.qpic.cn/mmbiz/icsOibyiaScKichtH5FB3ts3skaghFOyhPRZP6v4V3STNKcwgTuh838PbQg5Lgw0QRud69vbV12nNGGVTLrOH7kbwg/0"/>
</p>

		<#list salelist as info>			
			<div class="wxqq-borderTopColor wxqq-borderRightColor wxqq-borderBottomColor wxqq-borderLeftColor" style="margin: 10px; padding: 0px; border: 1px solid rgb(199, 205, 210);">
		 	<a style=" padding: 0px;display: block;" href="${info.link}">
 			 <p class="wxqq-color wxqq-borderLeftColor" style="border-width: 0px 0px 0px 5px; margin: 5px  0px 13px 20px; padding: 0px 10px; color: rgb(235, 164, 50); line-height: 25px; font-family: 微软雅黑; font-size: 16px; border-left-color: rgb(235, 164, 50); border-left-style: solid; white-space: normal; -webkit-font-smoothing: antialiased;">
    			<span style="color: rgb(247, 150, 70);"><strong><span style="font-family: arial, helvetica, sans-serif; font-size: 14px;">${info.subtitle}</span></strong></span><span style="font-family: arial, helvetica, sans-serif; font-size: 14px; color: rgb(89, 89, 89);">&nbsp;&nbsp;</span>
			</p>
			<p style="text-align:center">
    			<img style="width: 90%; height: 120px;" src=${info.image_address} alt="3.png" width="529" height="166" style="width: 529px; height: 166px;"/>
			</p>
			<p>	
    			<span style="color: rgb(89, 89, 89); font-family: arial, helvetica, sans-serif; font-size: 14px; line-height: 15px;width:100%;height:15px;display:block;">&nbsp; &nbsp; &nbsp;${info.create_date} &nbsp;${info.title}</span>
			</p>
			 <p>
  			  <span style="color: rgb(89, 89, 89); font-family: arial, helvetica, sans-serif; font-size: 14px; line-height: 15px;width:100%;height:15px;display:block;"&nbsp; &nbsp; &nbsp;>&nbsp; &nbsp; &nbsp;查看详情 &nbsp;&gt;</span>
			</p>
 			 </a>
 			 
 			</div>
		</#list>


 <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
     <script src="${resRoot}/js/goodsManager/goodsManagerGoodAdd.js?v=${resVer}"></script>
    
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
     <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
	<script>
		function itemClick(obj) {
		           window.location.href=obj; 
				}
	 </script>

  </body>
</html>
