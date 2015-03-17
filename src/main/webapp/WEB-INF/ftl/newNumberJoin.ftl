<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    
    <style>
    	.info-li{position:relative;overflow:hidden;display:block;padding:10px 0;margin-bottom:-1px;border:1px solid #d4d3d3;border-color:#d4d3d3 transparent;}
	    .info-li-on{z-index:100;border:1px solid #ed6d00;}
		.info-li .list-arr{float:none;position:absolute;top:50%;right:3px;margin-top:-5px;}
		.info-li-on .list-arr{background-image:url(${resRoot}/image/common/arr_2.gif);}
		
		
		.ctct-info p {
		    line-height: 20px;
		    padding-left: 5px;
		    font-size: 15px;
		    font-weight: bold;
		    color: #888;
		}

		.info-li-c label {
		    display: block;
		    margin-bottom: 5px;
		    font-weight: bold;
		    font-size: 15px;
		    line-height: 20px;
		    color: #333;
		}
		
		.info-li-c p {
		    line-height: 15px;
		    font-size: 13px;
		    color: #333;
		}

		.order-fee {
		    display: block;
		    margin: 15px 5px 5px;
		    font-size: 15px;
		    font-weight: bold;
		    color: #F60;
		    text-align: right;
		}
		
		.fee-detail {
		    margin: 0px 5px 15px;
		    font-size: 13px;
		    color: #999;
		    text-align: right;
		}
	</style>
	
	
  </head>

  <body>
    <!-- nav bar -->
     <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
	        	<div id="top_middle">${title}</div>
	        	<div id="top_right"></div>
	        </div>
    
    <div class="container-fluid" style="padding:5px">
	    <ul class="list-group">
		  <li class="list-group-item">
		  	 <div id="process-one" class="ctct-info">
                <p>已选手机:<span class="selected-info">${selectedPhone}</span></p>
            </div>
		  </li>
		  <li id="selectContractTab" class="list-group-item" onclick="toSelectContractPage()">
			   <b class="list-arr"></b>
                <section class="info-li-c">
				   <label>选择合约</label>
	               <p id="ctrct-unchoose">根据您的月消费，选择一个合适的合约计划</p>
	               <div id="ctrct-choosed" style="display:none;">
	                   <p>已选合约:<span class="selected-info">iPhone156元套餐  12月合约</span></p>
	                   <div class="pack-detail" id="packageDetail">
	                       <span class="pack-call"><i></i><label>50分钟</label></span>
	                       <span class="pack-msg"><i></i><label>0条</label></span>
	                       <span class="pack-flow"><i></i><label>300M</label></span>
	                   </div>
	                   <p>合约总价：4699元（含话费3400元）</p>
	               </div>
               </section>
		  </li>
		  <li id="selectNumberTab" class="list-group-item" onclick="toSelectNumberPage()">
<!-- 		  	<h3>选择号码</br><small>请选择一个入网号码，如果您选择的是靓号，需要预存靓号预存款</small></h3> -->
		  	 <b class="list-arr"></b>
                <section class="info-li-c">
                    <label>选择号码</label>
                    <p id="new-num">请选择一个入网号码，如果您选择的是靓号，需要预存靓号预存款</p>
                    <p id="old-num" style="display:none;">输入我的联通号码</p>
                    <div id="num-choosed" style="display:none;">
                        <p id="user-num-info">已选号码:<span class="selected-info">18801918888</span><em class='cf60'>（合肥）</em></p>
                        <p id="num-prefee">号码预存1800元，分12个月返还</p>
                    </div>
                </section>
		  </li>
		  <li id="amountTab" class="list-group-item">
		  	 	<strong class="order-fee">商品金额：${goods_price}</strong>
                <p class="fee-detail">（其中：合约机4699元+预存话费1200元）</p>
		  </li>
		</ul>
    </div>
    
     <div class="container-fluid" style="padding:5px">
<!--      	<button type="button" class="btn btn-warning  btn-lg btn-block"  -->
<!--      		data-toggle="popover" data-trigger="focus" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?" -->
<!--      	 	onclick='nextPage()'>下一步</button> -->
     	 	
     	 	<button  type="button" class="btn btn-warning  btn-lg btn-block" onclick='nextPage()'>下一步</button>
      </div>
      
      <input type="hidden" id="selectState" value=${selectState}>
      

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    <script src="${resRoot}/js/newNumberJoin.js?v=${resVer}"></script>
    <script>
    	
	</script>
  </body>
</html>
