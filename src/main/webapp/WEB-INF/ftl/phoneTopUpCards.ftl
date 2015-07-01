<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>购买充值卡</title>
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css" type="text/css" media="screen"/>
    <link rel="stylesheet" href="${resRoot}/css/phoneTopUpCards.css" type="text/css" media="screen"/>
    <script type="text/javascript" src="${resRoot}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${resRoot}/js/phoneTopUpCards.js"></script>

</head>
<body>
    <input type="hidden" id="baseRoot" value="${base}"></input>
    <input type="hidden" id="user_id" value="${user_id}"></input>
   		  <div id="top">
	        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
	        	<div id="top_middle">${title}</div>
	      </div> 
<div class="divContainer">
    <div class="src">
        <img src="${resRoot}/image/phoneTopUp/0.png">
    </div>
    <div class="cardsContainer">
        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$30" >
                <p class="price">$10</p>

                <p class="realPrice">售价为29.87</p>
            </a>
        </div>

        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$31">
                <p class="price">$30</p>

                <p class="realPrice">售价为29.87</p>
            </a>
        </div>

        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$32">
                <p class="price">$50</p>

                <p class="realPrice">售价为29.87</p>
            </a>
        </div>

        <div class="cardContainer  fleft">
            <a class="card" name = "cardName" price="$33">
                <p class="price">$100</p>

                <p class="realPrice">售价为29.87</p>
            </a>
        </div>


        <div class="clearBoth"></div>

    </div>

    <div class="buyInfo rel">
       <span class="abs">购买数量： </span>
        <div class="numContainer rel">
            <a id="removeId" class="remove left">  </a>
            <div id="numId" class="num"> 1 </div>
            <a id="addId" class="add fright">  </a>
        </div>

        <span class="abs">支付金额： </span>
        <div id="totleAmount" class="payNum"> 29.8 </div>


        <div class="inputContainer">
            <input id="inputId" class="standardInputStyle2" type="tel"  placeholder="请输入接收卡密短信的手机号码" >
        </div>

    </div>
    <div class="top-upContainer">
        <a id="top-upId" class="standard_a_Style1" >立即充值</a>
    </div>





</div>


</body>
</html>