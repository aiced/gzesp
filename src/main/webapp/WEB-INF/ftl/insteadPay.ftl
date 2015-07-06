<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>支付</title>
    
    <!-- Bootstrap -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/myacct.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/buttonStyle.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/modaldialogStyle.css?v=${resVer}" rel="stylesheet">

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
	<script type="text/javascript">
	
	function leftClick(param)
	{
		window.location.href='/esp/shopManage/weShopHome?userid='+$("#hide_user_id").val();
	}
	
	function checkData(param1,param2)
	{
		var reg = /^\d*$/;
		if(!reg.test($(param1).val()))
		{
			alert("密码只能是数字");
			$(param1).val("");
			return false;
		}
		else
		{
			$(param2).focus();
			return true;
		}
	}
	function clearTextVal()
	{
		for (var i = 1; i < 7; i++) {
    		$("#txt"+i).val("");
		}
	}
	
	function doFocus(param)
	{
		$(param).val("");
	}
	//
	//1:代金券点击
	//2:微账户点击
	//3：确认支付点击
	//4:弹出框点击确定
	function doClick(param,flag)
	{
		switch(flag)
		{
			case 1:
				alert("敬请期待～");
				break;
			case 2:
				var images = ['${resRoot}/image/myacct/off.png', '${resRoot}/image/myacct/on.png'] 
				
				if($(param).attr("class")=="off") //关闭
				{ 
					$(param).attr("src",images[1]); 
					$(param).removeClass(); 
				
					$("#lab_left_money").html("还需支付￥"+($("#hide_topay_money").val()-$("#hide_balance").val()));
				
				}
				else //打开
				{ 
					$(param).attr("src",images[0]); 
					$(param).addClass("off"); 
					$("#lab_left_money").html("还需支付￥"+$("#hide_topay_money").val());
				} 
				break;
			case 3:
				break;
			case 4: //弹出框 确定按钮
	    		var txtpwd="";
	    		for (var i = 1; i < 7; i++) {
	    			txtpwd=txtpwd+$("#txt"+i).val();
				}
	    		if (txtpwd.length!=6)
	    		{
	    			alert("请输入6位支付密码！");
	    			return;
	    		}
	    		
/* 				var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':txtpwd,'bank_no':$('#hide_bank_no').val()};
				$.ajax({
				 type: "POST",
				 url: '/esp/shopManage/acct/bankCardDetail/undindingBankCard',
				 data: parms,
				 success: function(data){
					 
					 switch(data)
					 {
					 case 1: //密码错误
						alert("输入密码有误，请重新输入！");
						clearTextVal();
					 	break;
					 case 2://删除失败
					 	alert("删除失败，请重新操作");
					 	break;
					 case 3: //操作成功
					 	alert("操作成功");
						break;
					 }
					window.location.href='/esp/shopManage/acct/myBankCardList/'+$("#hide_user_id").val();
				 }
				}); */
				break;
		}
	}
	</script>
</head>
<body>
    <!--top_start-->
    <div id="top">
        <div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
        <div id="top_middle">支付</div>
        <div id="top_right"></div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
    <div class="div_container_top">
        <label>选择支付方式</label>
    </div>
    <div class="div_container_top1">
        <div class="div_container_top2" onclick="doClick(this,1);">
            <img src="${resRoot}/image/myacct/daijinquan.png" width=16 height=16><span class="sp1">代金券</span><span class="sp2">你有0张优惠券<img src="${resRoot}/image/shopHome/jiantou.png" width="9" height="20"></span>
        </div>
        <div class="dv_clear"></div>
        <div class="div_line"></div>
        <div class="dv_clear"></div>
        <div class="div_container_top2">
            <img src="${resRoot}/image/myacct/qiandai.png" width=16 height=16><span class="sp1">微账户 <span id="span_balance">可用余额${acctinfo.BALANCE}</span></span><span class="sp2"><img onclick="doClick(this,2);" src="${resRoot}/image/myacct/off.png" width="64" height="31" class="off"></span>
        </div>
    </div>
    <div class="div_container_top">
        <label id="lab_left_money">还需支付￥${left_money}</label>
    </div>
    <div class="div_container_top">
      <!--开户银行-->
      <div class="form-group">
          <select class="form-control" name="selBank" id="selBank">
          	<option value="请选择开户银行">请选择支付银行</option>
  			<#if (acctbankinfolist?size==0)>
				<option value="数据加载失败">数据加载失败</option>
    		<#else>
				<#list acctbankinfolist as item>						
			    	<option value="${item.param_code}">
						${item.PARAM_VALUE}
					</option>
				</#list>
			</#if>
          </select>
      </div>
    </div>

    <div class="div_container_top3">
        <span class="sp3">实付款</span>
        <span class="sp4" id='span_topay_money'>￥${topay_money}</span>
    </div>

    <div class="div_container">
        <button class="btn btn-warning btn-block " type="submit" data-toggle="modal" data-target="#myModal">确认支付</button>
    </div>
    <input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
    <input type="hidden" id="hide_order_id" name="hide_order_id" value=${order_id}>
    <input type="hidden" id="hide_left_money" name="hide_left_money" value=${left_money}>
    <input type="hidden" id="hide_topay_money" name="hide_topay_money" value=${topay_money}>
    <input type="hidden" id="hide_balance" name="hide_balance" value=${acctinfo.BALANCE}>
    
   <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close" onclick="clearTextVal();"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入支付密码</h4>
                </div>
                <div class="modal-body">
<!--                     <span>交通银行<span>尾号2878储蓄卡</span></span>
                    <br> -->
                    <div class="pwd_container">
                        <div>
                            <input type="password" class="form-control" id="txt1" placeholder="" maxlength="1" onkeyup="checkData(this,txt2);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt2" placeholder="" maxlength="1" onkeyup="checkData(this,txt3);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt3" placeholder="" maxlength="1" onkeyup="checkData(this,txt4);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt4" placeholder="" maxlength="1" onkeyup="checkData(this,txt5);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt5" placeholder="" maxlength="1" onkeyup="checkData(this,txt6);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt6" placeholder="" maxlength="1" onkeyup="checkData(this,btnok);" onfocus="doFocus(this);">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default modal-button" name="btnclear" id="btnclear" onclick="clearTextVal();">清空</button>
                    <button type="button" class="btn btn-warning modal-button" name="btnok" id="btnok" onclick="doClick(this,4);">确定</button>
                </div>
            </div>
        </div>
    </div>
</body>
</html>