<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>订单状态明细</title>
    
    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">

    <link href="${resRoot}/css/custOrderStateDetails.css?v=${resVer}" rel="stylesheet">


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
	<script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/custOrderStateDetails.js?v=${resVer}"></script>

</head>
<body>
<!-- 代码 开始 -->
<!--top_start-->
<div id="top">
	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	<div id="top_middle">订单状态明细</div>
	<div id="top_right"></div>
</div>
<div id="dv_clear"></div>
<!--top_end-->

<#if (listdealloginfo?exists)>
<div class="main">
  <div class="history">
    <div class="history-date">
      <ul>
      
        <li class="green">
          <dl>
            <dt class='dt1'>待支付
	        </dt>
          </dl>
        </li>
		<#list listdealloginfo as item>
					
	        <li class="green">
	          <h3>${item.HOUR_MINUTE}<span>${item.MONTH_DAY}</span><span>${item.YEAR}</span></h3>
	          <dl>
	            <dt class='dt2'>${item.DEAL_CONTENT}
		        </dt>
	          </dl>
	        </li>
	        <li class="green">
              <dl>
                  <dt class='dt1'>${item.CURRENT_STATE_CONTENT}
                  </dt>
              </dl>
	        </li>
   		</#list>
      </ul>
    </div>
  </div>
</div>
<#else>
	<center>暂时没有订单状态详情</center>
</#if>
<!--         <li class="green">
          <h3>10.08<span>2012</span></h3>
          <dl>
            <dt>发布全新的极速浏览器6.0版本
	        </dt>
          </dl>
        </li>
          <li>
              <dl>
                  <dt>发布全新的极速浏览器6.0版本
                  </dt>
              </dl>
          </li>
          <li class="green">
              <h3>10.08<span>2012</span></h3>
              <dl>
                  <dt>发布全新的极速浏览器6.0版本
                  </dt>
              </dl>
          </li>
       <li>
         <h3>07.19<span>2012</span></h3>
          <dl>
            <dt>升级极速内核到20.0
	<span>HTML5支持度全球最好，达到469分，测试页面： </span>
	</dt>
          </dl>
        </li>

         <li>
          <h3>07.02<span>2012</span></h3>
          <dl>
            <dt>升级极速内核到19.0
	<span>支持网络摄像头，浏览器可直接访问摄像头</span>
	</dt>
          </dl>
        </li>

       <li class="green">
          <h3>06.27<span>2012</span></h3>
          <dl>
            <dt>发布国内首个HTML5实验室
	<span>大力推广HTML5</span>
	</dt>
          </dl>
        </li>
        <li>
          <h3>06.15<span>2012</span></h3>
          <dl>
            <dt>新增了下载文件前扫描下载链接安全性的功能</dt>
          </dl>
        </li>
        <li>
          <h3>06.05<span>2012</span></h3>
          <dl>
            <dt>W3C联盟首席执行官访华，首站访问360公司
	</dt>
          </dl>
        </li>
        <li>
          <h3>05.12<span>2012</span></h3>
          <dl>
            <dt>360受邀出席W3C联盟成员见面会议</dt>
          </dl>
        </li>
        <li>
          <h3>05.11<span>2012</span></h3>
          <dl>
            <dt>升级极速内核到18.0
	<span>新增多用户使用浏览器的功能</span>
	</dt>
          </dl>
        </li>
        <li>
          <h3>05.03<span>2012</span></h3>
          <dl>
            <dt>360极速浏览器用户数突破5000万，活跃用户超2000万
	</dt>
          </dl>
        </li>
        <li>
          <h3>03.08<span>2012</span></h3>
          <dl>
            <dt>升级极速内核到17.0，提升浏览器速度、增强安全性
	<span>新增HTTP管线化技术，大幅提升网页加载速度</span>
	</dt>
          </dl>
        </li>
        <li>
          <h3>01.29<span>2012</span></h3>
          <dl>
            <dt>国内率先加入W3C联盟HTML工作组，参与HTML5标准制定</span>
	</dt>
          </dl>
        </li> -->

</body>
</html>