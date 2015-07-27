<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>手机充值</title>
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="${resRoot}/css/phoneTopUp.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="${resRoot}/css/phoneTopUpCards.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="${resRoot}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${resRoot}/js/phoneTopUp.js"></script>

</head>

<body style="background-color:transparent">
    <input type="hidden" id="baseRoot" value="${base}"></input>
    <input type="hidden" id="user_id" value="${user_id}"></input>
   		  <div id="top">
       			<div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	      </div> 
<div class="divContainer">
    <div class="phoneNumContainer">
        <div class="top-upNumber">
        <!--
                    <span> 充值号码 </span>
         -->
			 <select id = "numSelected">
                <option value="1">手机 </option>>
                <option value="2">固话 </option>
                <option value="3">宽带 </option>>
            </select>
             <div class="fright">
                <input id="phoneNumId" type="tel" placeholder="只限贵州地区号码">
            </div>
        </div>

		 <div class="phoneDetail" id = "phoneDetailId">
            <div class="name border_bottom"> 王伟（江苏联通）</div>
            <div class="name"> 实时话费
                <span class="fright real-timeCalls " id = "realTopUpId">92.00 元 </span>
            </div>
            
            <div class="name"> 信用额度
                <span class="fright credit " id = "creditId">192.00 元 </span>
            </div>
            
            <div class="name"> 话费余额
                <span class="fright balances " id = "balanceId">292.00 元 </span>
            </div>
        </div>
    </div>

    <div class="error hide">
        <span class="fright"> 此号码归属地非贵州联通 </span>

        <div class="clearBoth"></div>
    </div>


    <div class="cardHeader">选择充值金额：</div>
    <div class="cardsContainer">
        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$10" realPrice="$9.9" >
                <p class="price">$10</p>
                <p class="realPrice" >售价为9.9</p>
            </a>
        </div>

        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$30" realPrice="$29.9">
                <p class="price">$30</p>
                <p class="realPrice" >售价为29.9</p>
            </a>
        </div>

        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$50" realPrice="$49.9" >
                <p class="price">$50</p>
                <p class="realPrice" >售价为49.9</p>
            </a>
        </div>

        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$100"  realPrice="$99.9">
                <p class="price">$100</p>
                <p class="realPrice">售价为99.9</p>
            </a>
        </div>
        <div class="clearBoth"></div>

    </div>
    <!-- 其他金额-->
    <div class="otherAmount">
        <span> 其他金额</span>

        <div class="fright">
            <input id="amountId" class="standardInputStyle2" type="tel" placeholder="请输入10的整数倍">
        </div>
        <div class="clearBoth"></div>
    </div>

    <div class ="preferential" id = "preferentialId"></div>

    <div class="orderContainer">
        <a id="topUpId" class="standard_a_Style1">立即充值</a>
    </div>

    <div class="footer">
        <a id="buyCardId" class="left">购买充值卡 </a>
        <a id="dealListId" class="fright">交易记录查询 </a>
    </div>

</div>
</body>
</html>