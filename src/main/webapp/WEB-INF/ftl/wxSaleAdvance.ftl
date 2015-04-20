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
    <strong><span style="font-size: 20px; font-family: arial, helvetica, sans-serif;">菜鸟掌柜——销售进阶之道！</span></strong><br/>
</p>
<fieldset class="wxqq-borderTopColor wxqq-borderRightColor wxqq-borderBottomColor wxqq-borderLeftColor" style="margin: 10px; padding: 5px; border: 1px solid rgb(235, 164, 50);">
    <legend style="margin: 0px 10px; text-align: center;">
        <span class="wxqq-bg" style="padding: 5px 10px; border-top-left-radius: 5px; border-top-right-radius: 5px; border-bottom-right-radius: 5px; border-bottom-left-radius: 5px; color: rgb(255, 255, 255); font-size: 14px; font-weight: bold; background-color: rgb(235, 164, 50);">销售进阶</span>
    </legend>
    <blockquote style="margin: 0px; padding: 10px;">
        <p style="line-height: normal; text-align: center;">
            <span style="color: rgb(89, 89, 89); font-size: 14px;">说不完的江湖风云，叨不尽的赚钱秘籍</span>
        </p>
        <p style="line-height: normal; text-align: center;">
            <span style="color: rgb(89, 89, 89); font-size: 14px;">各种销售推广大招轮番来袭</span>
        </p>
        <p style="line-height: normal; text-align: center;">
            ☞<strong><span style="color: rgb(89, 89, 89); font-size: 14px;">菜鸟掌柜的升级进阶指南</span></strong>
        </p>
    </blockquote>
</fieldset>
<p>
    <span style="font-size: 14px; color: rgb(89, 89, 89);"></span>
</p>
<p>
    <img style="width: 100%; height: auto !important;" src="http://mmbiz.qpic.cn/mmbiz/icsOibyiaScKichtH5FB3ts3skaghFOyhPRZP6v4V3STNKcwgTuh838PbQg5Lgw0QRud69vbV12nNGGVTLrOH7kbwg/0"/>
</p>





		<#list salelist as info>			
			<div class="wxqq-borderTopColor wxqq-borderRightColor wxqq-borderBottomColor wxqq-borderLeftColor" style="margin: 10px; padding: 0px; border: 1px solid rgb(199, 205, 210);">
		 	<a style="margin:0px; padding: 0px;display: block;" href="${info.link}">
 			 <p class="wxqq-color wxqq-borderLeftColor" style="border-width: 0px 0px 0px 5px; margin: 5px 0px 13px; padding: 0px 10px; color: rgb(235, 164, 50); line-height: 25px; font-family: 微软雅黑; font-size: 16px; border-left-color: rgb(235, 164, 50); border-left-style: solid; white-space: normal; -webkit-font-smoothing: antialiased;">
    			<span style="color: rgb(247, 150, 70);"><strong><span style="font-family: arial, helvetica, sans-serif; font-size: 14px;">${info.subtitle}</span></strong></span><span style="font-family: arial, helvetica, sans-serif; font-size: 14px; color: rgb(89, 89, 89);">&nbsp;&nbsp;</span>
			</p>
			<p style="text-align:center">
    			<img style="width: 90%; height: auto !important;" src=${info.image_address} alt="3.png" width="529" height="166" style="width: 529px; height: 166px;"/>
			</p>
			<p>	
    			<span style="color: rgb(89, 89, 89); font-family: arial, helvetica, sans-serif; font-size: 14px; line-height: 25px;width:100%;height:25px;text-align:center; display:block;">&nbsp; &nbsp; &nbsp; &nbsp;${info.create_date} &nbsp;${info.title}</span>
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
