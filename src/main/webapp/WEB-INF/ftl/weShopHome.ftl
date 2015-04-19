<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
   
    <title>欢迎来到${storename}</title>
   
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
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/jquery.zclip.min.js?v=${resVer}"></script>
	<script src="${resRoot}/js/jquery.zclip.js?v=${resVer}"></script>
	
	<script type="text/javascript">
		$(document).ready(function(){  
		   //[导航-右边]按钮点击
		  $("#top_right").click(function(){  
		  //在这里操作导航-右边操作
		  	location.href = "weShopSet?userid="+${userid};
		  });  
		  //[进入店铺]按钮点击
		  $("#btnGoIntoShop").click(function(){  
		  //在这里操作进入店铺操作
		  	location.href = "../weShop/index/"+${userid};
		  }); 
		  
          //[点击订单列表]
          $(".head_bottom_show").zclip({
  				path:"${resRoot}/js/ZeroClipboard.swf",
  				copy:function(){
					return window.location.href;
  				},
  				afterCopy:function(){
  					alert("复制成功");
  				}
           });
		});
	</script>


    <style type="text/css">
        .head_top
        {
            height: 120px;
            background: #f66326;
            color: #ffffff;
        }
        .head_bottom
        {
            height: 50px;
            background: #ffffff;
        }
        .head_bottom_show{
            float: right;
            margin-top: 10px;
        }
        .head_bottom_line
        {
            float:right;
            background: #cccccc;
            width: 1px;
            height: 30px;
            margin:10px 10px 10px 10px;
        }
        .head_bottom_share{
            float: right;
            margin-top: 10px;
            margin-right:15px ;
        }
        .head_user
        {
            width: 90px;
            height: 90px;
            top:100px;
            left:15px;
            position:absolute;
        }
        .head_title
        {
            margin-left: 15px;
            margin-top: 15px;
            margin-bottom: 15px;
        }
        .detail_info
        {
            margin: 15px;
            background: #ffffff;
        }
        .yesterday_view
        {
            font-size:14px;
            color: #9EC7FF;
        }
        .month_view
        {
            font-size:14px;
            color:#759EE7;
        }
        .total_view
        {
            font-size:14px;
            color:#385B8A;
        }
        .yesterday_sale
        {
            font-size:14px;
            color:#ffB878
        }
        .month_sale
        {
        	font-size:14px;
            color:#DB9A5F;
        }
        .total_sale
        {
            font-size:14px;
            color:#96653A;
        }

        .yesterday_money
        {
            font-size:14px;
            color:#ff7878;
        }
        .month_money
        {
            font-size:14px;
            color:#ce4141;
        }
        .total_money
        {
            font-size:14px;
            color: #742525;
        }
        .list-group
        {
            margin: 15px;
        }
        .list_gou
        {
            float: right;
            text-align: right;
        }
        .head_top_logo
        {
            margin-left: 20px;
            padding-top: 10px;
        }
        .head_top_info
        {
            height: 100%;
            margin-left: 120px;
        }
        .head_top_info_details
        {
            margin-left: 10px;
        }
        .shopname
        {
            font-weight: bold;
        }

    </style>
</head>
<body>
	<div>
	    <div>
	    	<!--top_start-->
	        <div id="top">
	        	<div style="float:left;width:20%;height:40px;font-size:14px;"></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
	        </div>
			<div id="dv_clear"></div>
			<!--top_end-->
	        <div>
	            <div class="head_top">
	                <div class="head_top_logo">
	                    <img src="${resRoot}/image/shopHome/wo_logo_white.png" width="65" height="20"/>
	                </div>
	                <div class="head_top_info">
	                    <div class="head_top_info_details">
	                        <div class="shopname">${storename}</div>
	                        <div class="shoptel"><img src="${resRoot}/image/shopHome/tel.png" width="21" height="21"/>&nbsp;&nbsp;${phone}</div>
	                        <div class="shopweixin"><img src="${resRoot}/image/shopHome/weixin.png" width="21" height="21"/>&nbsp;&nbsp;${weixin}</div>
	                    </div>
	                </div>
	            </div>
	            <div class="head_bottom">
	                <div class="head_bottom_share"><a href="#" data-toggle="modal" data-target="#myModal"><img src="${resRoot}/image/shopHome/shopshare.png" width="24" height="24">店铺分享<img/></a></div>
	                <div class="head_bottom_line"></div>
	                <div class="head_bottom_show"><a href="#" id="copyUrl" ><img src="${resRoot}/image/shopHome/shoppreview.png" width="24" height="24">复制链接</a></div>
	            </div>
	            <div class="head_user"><img src="${imageRoot}${userimage}" alt="头像" class="img-circle" width="90" height="90"></div>
	        </div>
	        
	        <!-- 分享到弹出框 -->    
		    <div id="myModal" class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
		      <div class="modal-dialog modal-lg">
		        <div class="modal-content" style="padding:5px;height:80px;">
		    	    分享到：
		          <!-- Baidu Button BEGIN -->
		          <div class="bdsharebuttonbox">
		            <a class="bds_more" href="#" data-cmd="more"></a>
		            <a title="分享到QQ空间" class="bds_qzone" href="#" data-cmd="qzone"></a>
		            <a title="分享到新浪微博" class="bds_tsina" href="#" data-cmd="tsina"></a>
		            <a title="分享到腾讯微博" class="bds_tqq" href="#" data-cmd="tqq"></a>
		            <a title="分享到人人网" class="bds_renren" href="#" data-cmd="renren"></a>
		            <a title="分享到微信" class="bds_weixin" href="#" data-cmd="weixin"></a>
		          </div>
		          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdUrl":"http://wap.gz10010.xyz/esp/weShop/index/${userid}","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"32"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>
		          <!-- Baidu Button END -->   
		        </div>
		      </div>
		    </div>  
	        
	        <div class="head_title">
	           <div style="width:8px;height: 20px;background: #CFCFCF;float: left;margin-right:5px;"></div><h5>店铺发展信息</h5>
	        </div>
	        <div class="detail_info">
	            <table class="table table-striped table-condensed">
	                <tr>
	                	<#if viewcountlist?size==0>
		                    <td class="yesterday_view">昨日访问(次)<br/><div style="text-align: center;">0</div></td>
		                    <td class="month_view">本月访问(次)<br/><div style="text-align: center;">0</div></td>
		                    <td class="total_view">累计访问(次)<br/><div style="text-align: center;">0</div></td>
		                <#else>
	                		<#list viewcountlist as item>
	                	    	<td class="yesterday_view">昨日访问(次)<br/><div style="text-align: center;">${item.yesterday_view}</div></td>
	                    		<td class="month_view">本月访问(次)<br/><div style="text-align: center;">${item.month_view}</div></td>
	                    		<td class="total_view">累计访问(次)<br/><div style="text-align: center;">${item.total_count}</div></td>
	                		</#list>
	                	</#if>
					</tr>

	                <tr>
	                	<#if saleList?size==0>
		                    <td class="yesterday_sale">昨日销售(件)<br/><div style="text-align: center;">0</div></td>
		                    <td class="month_sale">本月销售(件)<br/><div style="text-align: center;">0</div></td>
		                    <td class="total_sale">累计销售(件)<br/><div style="text-align: center;">0</div></td>          		
		                <#else>
	                		<#list saleList as item>
	                	    	<td class="yesterday_sale">昨日销售(件)<br/><div style="text-align: center;">${item.yesterday_count}</div></td>
	                    		<td class="month_sale">本月销售(件)<br/><div style="text-align: center;">${item.month_count}</div></td>
	                    		<td class="total_sale">累计销售(件)<br/><div style="text-align: center;">${item.total_count}</div></td>
	                		</#list>
	                	</#if>
					</tr>
					<tr>
	                	<#if commissionList?size==0>
		                    <td class="yesterday_money">昨日收益(元)<br/><div style="text-align: center;">0</div></td>
		                    <td class="month_money">本月收益(元)<br/><div style="text-align: center;">0</div></td>
		                    <td class="total_money">累计收益(元)<br/><div style="text-align: center;">0</div></td>	                		
		                <#else>
	                		<#list commissionList as item>
	                	    	<td class="yesterday_money">昨日收益(元)<br/><div style="text-align: center;">${item.yesterday_commison}</div></td>
	                    		<td class="month_money">本月收益(元)<br/><div style="text-align: center;">${item.month_commison}</div></td>
	                    		<td class="total_money">累计收益(元)<br/><div style="text-align: center;">${item.total_count}</div></td>
	                		</#list>
	                	</#if>
					</tr>
	
	            </table>
	        </div>
	        <div class="list-group">
	            <a href="goodsManageRecommend?userid=${userid}" class="list-group-item">商品管理<span class="list_gou"><img src="${resRoot}/image/shopHome/jiantou.png" width="9" height="15"></span></a>
	            <a href="ordersQuery?userid=${userid}&fromPage=shopHome" class="list-group-item">订单查询 <span class="list_gou"><img src="${resRoot}/image/shopHome/jiantou.png" width="9" height="15"></span></a>
	            <a href="commissionQuery?userid=${userid}" class="list-group-item">收益查询 <span class="list_gou"><img src="${resRoot}/image/shopHome/jiantou.png" width="9" height="15"></span></a>
	        </div>
	        <br/>
	        <div class="list-group">
	            <button class="btn btn-warning btn-block" type="button" id="btnGoIntoShop" name="btnGoIntoShop">进入店铺主页</button>
	        </div>
	    </div>
	</div>



</body>
</html>