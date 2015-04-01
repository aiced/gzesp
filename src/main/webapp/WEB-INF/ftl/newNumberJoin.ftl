<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
    <script src="${resRoot}/js/newNumberJoin.js?v=${resVer}"></script>
    <script src="${resRoot}/js/selectNumber.js?v=${resVer}"></script>

	
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/selectNumber.css?v=${resVer}" rel="stylesheet">
    
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
		
		 .list_gou {
            float: right;
            text-align: right;
            position:absolute;
            bottom: 2px;
            right:15px;
        }
         .label-sm {
            margin-left: 5px;
            color: #c0c0c0;
        }
        
		.pack-detail{width:100%;font-size:13px;overflow:hidden;}
		.pack-detail span{float:left;margin-right:3px;margin-bottom:10px;}
		.pack-detail span i{display:inline-block;width:19px;height:17px;margin-right:3px;-webkit-background-size:19px 17px;-moz-background-size:19px 17px;background-size:19px 17px;vertical-align:middle;}
		.pack-detail span.pack-call i{background-image:url(${resRoot}/image/common/phone.png);}
		.pack-detail span.pack-msg i{background-image:url(${resRoot}/image/common/msg.png);}
		.pack-detail span.pack-flow i{background-image:url(${resRoot}/image/common/flow.png);}
	</style>
	
	
  </head>

  <body>
 	 <div id="mianPage" >
	    <!-- nav bar -->
	     <div id="top">
		        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
		        	<div id="top_middle">${title}</div>
		        	<div id="top_right"></div>
		        </div>
	    
	    <div class="container-fluid" style="padding:5px">
		    <ul class="list-group">
			  <li class="list-group-item">
			  	 <div id="process-one" class="ctct-info">
	                <p>已选手机:<span class="selected-info">${goods_name}</span></p>
	            </div>
			  </li>
			  <li id="selectContractTab" class="list-group-item" onclick="toSelectContractPage()">
	                <section class="info-li-c">
					   <label>选择合约</label>
		               <p id="ctrct-unchoose" >根据您的月消费，选择一个合适的合约计划</p>
		               <div id="ctrct-choosed" style="display:none">
		               		<p><div > <span id="conType"></span>套餐  <span id="conPeriod"></span>合约</div></p>
<!-- 		                   <div class="pack-detail" id="packageDetail"> -->
<!-- 		                       <span class="pack-call"><i></i></span><span id="call"></span><span></span> -->
<!-- 		                       <span class="pack-msg"><i></i></span><span id="msg"></span><span></span> -->
<!-- 		                       <span class="pack-flow"><i></i></span><span id="flow"></span> -->
<!-- 		                   </div> -->
		                   <div id="conDesc"></div>
		               </div>
	               </section>
			  </li>
			  <li id="selectNumberTab" class="list-group-item" onclick="toSelectNumberPage()">
	                <section class="info-li-c">
	                    <label>选择号码</label>
	                    <p id="new-num">请选择一个入网号码，如果您选择的是靓号，需要预存靓号预存款</p>
	                    <p id="old-num" style="display:none;">输入我的联通号码</p>
	                    <div id="num-choosed" style="display:none;">
	                        <p id="user-num-info">已选号码:<span class="selected-info" id="serial_number"></span><em class='cf60'></em></p>
	                    </div>
	                </section>
			  </li>
			  <li id="amountTab" class="list-group-item">
			  	 	<strong class="order-fee">商品金额：${goods_price}</strong>
<!-- 	                <p class="fee-detail">（其中：合约机4699元+预存话费1200元）</p> -->
			  </li>
			</ul>
	    </div>
	    
	     <div class="container-fluid" style="padding:5px">
	<!--      	<button type="button" class="btn btn-warning  btn-lg btn-block"  -->
	<!--      		data-toggle="popover" data-trigger="focus" title="Dismissible popover" data-content="And here's some amazing content. It's very engaging. Right?" -->
	<!--      	 	onclick='nextPage()'>下一步</button> -->
	     	 	
	     	 	<button  type="button" class="btn btn-warning  btn-lg btn-block" onclick='nextPage()'>下一步</button>
	      </div>
      </div>
      
      <!-- 选合约页 -->
	<div id="selectContractPage" style="display:none" >
		<#include "selectContract.ftl"> 
	</div>
      
      <!-- 选号页 -->
	<div id="selectNumberPage"  style="display:none">
		<#include "selectNumber.ftl"> 
	</div>
	
	<input type="hidden" id="user_id" value="${user_id}"></input>
	<input type="hidden" id="goods_id" value="${goods_id}"></input>
    <input type="hidden" id="goods_disc" value="${goods_disc}"></input>
    <input type="hidden" id="goods_name" value="${goods_name}"></input>
    <input type="hidden" id="goods_price" value="${goods_price}"></input>
    <input type="hidden" id="attr_val" value="${attr_val}"></input>
    <input type="hidden" id="num_resId" value="${num_resId}"></input>
    <input type="hidden" id="attr_contract" ></input>
    <input type="hidden" id="attr_number"></input>
      
  </body>
</html>
