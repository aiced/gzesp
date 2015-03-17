<!DOCTYPE html>
<html>
<head lang="en">
    
    <style type="text/css">
        .container-fluid
        {
            margin: 15px;
            border: 1px solid #000000;
            height: 200px;
        }
        .div_clear
        {
            clear:both;
        }
        .payInfo
        {
            text-align: center;
            margin-top: 20px;
        }
        #pay_mode_1_detail
        {
            height: 100px;
            display: none;
            margin: 15px;
            font-size: 12px;
        }
        #pay_mode_2_detail
        {
            height: 100px;
            display: none;
            margin: 15px;
            font-size: 12px;
        }
        .div_line
        {
            background: #cccccc;
            margin: 5px;
            height: 1px;
        }
        .mode_1
        {
            margin: 10px;
            line-height: 30px;
            background:#ffffff;
        }
        .row
        {
            margin: 10px;
        }
        .form-control
        {
            font-size: 12px;
        }
    </style>

    <script type="text/javascript">
        $(function(){
            showPayMode();
            $("input[name=pay_mode]").click(function(){
                showPayMode();
            });
        });
        function showPayMode()
        {
            switch ($("input[name=pay_mode]:checked").attr("id"))
            {
                case "pay_mode_1":
                    $("#pay_mode_1_detail").show();
                    $("#pay_mode_2_detail").hide();
                    break;
                case "pay_mode_2":
                    $("#pay_mode_1_detail").hide();
                    $("#pay_mode_2_detail").show();
                    break;
                default:
                    break;
            }
        }
    </script>
</head>
<body>
    <div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
        <div class="container-fluid">
            <div class="payInfo">
                <!--<ul class="choosepaymode">-->
                    <!--<li id="pay_mode_1">-->
                        <!--<input type="radio" name="pay_mode" id="pay_mode_one">-->
                    <!--</li>-->
                    <!--<li id="pay_mode_2">-->
                        <!--<input type="radio" name="pay_mode" id="pay_mode_two">-->
                    <!--</li>-->
                <!--</ul>-->
                <label class="radio-inline">
                    <input type="radio" name="pay_mode" id="pay_mode_1" value="pay_mode_1" checked="checked">在线支付
                </label>
                <label class="radio-inline">
                    <input type="radio" name="pay_mode" id="pay_mode_2" value="pay_mode_2">货到付款
                </label>
            </div>
            <div id="pay_mode_1_detail">
                <div class="pay_mode_1_info">
                    	在线支付，支持信用卡，储蓄卡，支付宝支付
                </div>
                <div class="div_line">
                </div>
                <div>
                    <div class="mode_1">
                            <img src="${resRoot}/image/selectPayMode/zhifubao.png" width="45" height="30"/>&nbsp;&nbsp;支付宝快捷支付&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="pay_mode_style" id="zhifubao" value="zhifubao" checked>
                    </div>
                    <div class="mode_1">
                            <img src="${resRoot}/image/selectPayMode/unionpay.png" width="45" height="30"/>&nbsp;&nbsp;财付通快捷支付&nbsp;&nbsp;&nbsp;
                            <input type="radio" name="pay_mode_style" id="caifutong" value="caifutong">
                    </div>
                </div>
            </div>
            <div id="pay_mode_2_detail">
                <div class="pay_mode_2_info">
                    	需先确认地址信息才能选择货到付款，请您验货后付款。
                </div>
                <div class="div_line">

                </div>
                <div class="row">
                    <div class="col-xs-5 col-sm-5">
                        <label style="height: 34px;line-height: 34px">付款方式</label>
                    </div>
                    <div class="col-xs-7 col-sm-7">
                        <select class="form-control">
                            <option>现金支付</option>
                            <option>POS刷卡</option>
                        </select>
                    </div>
                </div>
            </div>
        </div>
        <br/>
        <div id="payInfoBtn" style="margin: 15px">
            <button class="btn btn-warning btn-block" type="submit">确定</button>
        </div>

    </div>


</body>
</html>