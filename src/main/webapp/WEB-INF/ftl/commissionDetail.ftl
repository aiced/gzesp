<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
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
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>

	<script type="text/javascript">
		$(function() {
			setTimeout("changeDivStyle();", 10); // 0.1秒后展示结果，因为HTML加载顺序，先加载脚本+样式，再加载body内容。所以加个延时
		
			
			$(".div2").click(function(){
		    	//ajax 操作，刷新本界面数据   
		    	var orderid=$(".div2 u a").text();
				var parms = {'ORDER_ID':orderid};
				$.commonFormSubmit({
				 type: "POST",
				 action: '${base}/shopManage/orderDetail',
				 data: parms,
				 success: function(data){
				  	 //history.back();
				  	 //alert("ok");
				  	 //return;
				  	 //alert(data);
				  	 return;
				 }
				});
				
				
			});
		});
	function changeDivStyle(){
	//		var o_status = $("#o_status").val();	//获取隐藏框值
		var o_status = 2;
		if(o_status==0){
			$('#first').css('background', '#00cc66');
			$('.stepInfo li').css('background','#999999');
			$('#second').css('background', '#999999');
			$('#third').css('background', '#999999');
		}else if(o_status==1){
			$('#first').css('background', '#00cc66');
			$('#second').css('background', '#00cc66');
			$('.stepInfo li:eq(1)').css('background','#999999');
			$('#third').css('background', '#999999');
		}else if(o_status==2){
			$('#first').css('background', '#00cc66');
			$('#second').css('background', '#00cc66');
			$('#third').css('background', '#00cc66');
			$('.stepInfo li').css('background','#00cc66');
		}
	}

	</script>

	<style type="text/css">
	*{margin:0;padding:0;list-style-type:none;}
	a,img{border:0;}
	.div1{
		height: 40px;
		margin: 10px;
		font-weight: bold;
		font-size: 14px;
		line-height:40px;
	}
	.div2
	{
		height: 20px;
		text-align: right;
		line-height:20px;
		font-size: 14px;
		margin: 10px;
		font-weight: bold;
	}
	.div2 a{
		color: #fac390;
	}
	.div3{
		height: 40px;
		margin: 10px;
		font-weight: bold;
		font-size: 14px;
		line-height:40px;
	}
	.div4
	{
		margin: 20px;
		font-size: 12px;
		color: #666666;
	}

	/* stepInfo
		border-radius：0为正方形，0~N，由正方形向圆形转化，N越大越圆。
		padding：图形的内边距
		background：图形背景色
		text-align：文本对齐
		line-height：行高
		color：文字颜色
		position：定位
		width：宽度
		height：高度
	*/
	.stepInfo{
		position:relative;
		background:#f2f2f2;
		margin:40px;
		width:auto;
	}
	.stepInfo li{float:left;width:48%;height:0.7em;background:#00cc66;}
	.stepIco{border-radius:2em;padding:0.03em;background:#00cc66;text-align:center;line-height:5em;color:#fff; position:absolute;width:1.8em;height:1.8em;}
	.stepIco1{top:-0.7em;left:-1%;}
	/*.stepIco2{top:-0.7em;left:21%;}*/
	.stepIco3{top:-0.7em;left:46%;}
	/*.stepIco4{top:-0.7em;left:71%;}*/
	.stepIco5{top:-0.7em;left:95%;}
	.stepText{color:#666;margin-top:-0.5em;width:4em;text-align:center;margin-left:-1em;font-size: 12px;}
	.stepText_top{color:#666;margin-top:-4.5em;width:4em;text-align:center;margin-left:-1em;font-size: 12px;}

	</style>

</head>

<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
		<div class="div1">商品名称：Iphone6合约机</div>
		<div class="div2">订单号：<u><a>2311</a></u></div>
		<div class="div3">佣金收益</div>
		<br/>
		<br/>


		<div class="stepInfo">
			<ul>
				<li></li>
				<li></li>
			</ul>
			<!--<div class="stepIco_top stepIco1">-->
			<!--<div class="stepText stepIco1" id="firstText_top">1111</div>-->
			<!--</div>-->

			<div class="stepIco stepIco1" id="first" >

				<div class="stepText_top" id="firstText_top">用户激活</div>
				<div class="stepText" id="firstText">开始计算</div>
			</div>
			<!--<div class="stepIco stepIco2" id="check">2-->
			<!--<div class="stepText" id="checkText">审核订单</div>-->
			<!--</div>-->
			<!--<div class="stepIco_top ">-->
			<!--<div class="stepText stepIco3" id="secondText_top">2222</div>-->
			<!--</div>-->

			<div class="stepIco stepIco3" id="second">
				<div class="stepText_top" id="secondText_top">一次佣金</div>
				<div class="stepText" id="secondText">10元</div>
			</div>
			<!--<div class="stepIco stepIco4" id="delivery">4-->
			<!--<div class="stepText" id="deliveryText">配送</div>-->
			<!--</div>-->
			<!--<div class="stepIco_top">-->
			<!--<div class="stepText stepIco5" id="thirdText_top">3333</div>-->
			<!--</div>-->

			<div class="stepIco stepIco5" id="third">
				<div class="stepText_top" id="thirdText_top">分成佣金</div>
				<div class="stepText" id="thirdText">40元</div>
			</div>
		</div><!--stepInfo_end-->
		<br/>
		<br/>
		<br/>
		<br/>
		<div class="div4">
			备注：用户未激活/未到结算日/用户离网，分成佣金扣除。当到达相应环境时，圆圈进度变为绿色，未达到或进行过程时会灰色。
		</div>
	</div>
</body>
</html>
