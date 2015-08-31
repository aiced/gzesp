<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
<title>修改银行卡信息</title>
	 <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
	<link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link rel="stylesheet" href="${resRoot}/css/base.css?v=${resVer}" rel="stylesheet">  
    <link rel="stylesheet" href="${resRoot}/css/addBankCardInput.css?v=${resVer}" rel="stylesheet"> 
    <link href="${resRoot}/css/modaldialogStyle.css?v=${resVer}" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
         
	<script type="text/javascript" src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
	<script type="text/javascript" src="${resRoot}/js/addBankCardInput.js?v=${resVer}"></script>	
	<script src="${resRoot}/js/formSubmit.js?v=${resVer}"></script>
	<script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    <script src="${resRoot}/js/bankCardCheck.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>

	<script src="${resRoot}/js/jquery.min.js"></script>
    <script src="${resRoot}/js/mobiscroll_002.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_004.js" type="text/javascript"></script>
	<link href="${resRoot}/css/mobiscroll_002.css" rel="stylesheet" type="text/css">
	<link href="${resRoot}/css/mobiscroll.css" rel="stylesheet" type="text/css">
	<script src="${resRoot}/js/mobiscroll.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_003.js" type="text/javascript"></script>
	<script src="${resRoot}/js/mobiscroll_005.js" type="text/javascript"></script>
	<link href="${resRoot}/css/mobiscroll_003.css" rel="stylesheet" type="text/css">

    <script type="text/javascript">
    	
    	function checkData2(param1,param2)
    	{
    		var reg = /^\d*$/;
    		if(!reg.test($(param1).val()))
    		{
    			alert("密码只能是数字");
    			$(param1).val("");
    			return false;
    		}
    		else if ($(param1).val().length==6) {
    			$(param2).focus();
    			$(param1).select();
    			param1.setSelectionRange(0,0);
    			return true;
			}
    	}
    	
       function funcType(funcType){
	     
	     //因为解除绑定和 保存修改都需要弹出密码输入框
	     //确定按钮需要区分是什么功能，调用不同的function
	     $('#btnok').attr('funcType', funcType); 
	
   
        }    	

    	function doClick()
    	{
    	   //根据funcType属性值判断是 解绑银行卡 还是 修改银行卡
    	   var funcType = $('#btnok').attr('funcType');
    	   if(funcType == '1'){
    	      saveBankCardInfo(); //此函数在 addBankCardInput.js里
    	   }
    	   else if(funcType == '2'){
    	      undindingBankCard();
    	   }
    	}    	
    	
    	//解绑银行卡
    	function undindingBankCard()
    	{
    		//ajax请求
    		
/*     		var txtpwd="";
    		for (var i = 1; i < 7; i++) {
    			txtpwd=txtpwd+$("#txt"+i).val();
			} */
			$("#btnok").attr('disabled',"true");
    		if ($('#txtsecuritypwd').val().length!=6)
    		{
    			alert("请输入6位安全密码！");
    			$("#btnok").removeAttr("disabled");
    			return;
    		}
    		
			var parms = {'user_id':$('#hide_user_id').val(),'user_pwd':$('#txtsecuritypwd').val(),'bank_no':$('#txtcardno').val()};
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
				 	alert("操作失败，请重新操作");
				 	break;
				 case 3: //操作成功
				 	alert("操作成功");
					break;
				default:
					alert("未知错误");
					break;
				 }
				window.location.href='/esp/shopManage/acct/myBankCardList/'+$("#hide_user_id").val();
			 }
			});
    	}
    	 
    	function clearTextVal()
    	{
/*     		for (var i = 1; i < 7; i++) {
        		$("#txt"+i).val("");
			} */
    		$('#txtsecuritypwd').val("");
    	}
    	function doFocus(param)
    	{
    		$(param).val("");
    	}
    	function leftClick(param)
    	{
    		window.location.href='/esp/shopManage/acct/myBankCardList/'+$("#hide_user_id").val();
    	}
    </script>    
</head>

<body style="background-color:transparent">
    <!--top_start-->
    <div id="top">
       	<div id="top_left" onclick="leftClick(this);"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div>
       	<div id="top_middle">完善银行卡信息</div>
       	<div id="top_right" onclick="rightClick(this)">
		</div>
    </div>
    <div class="dv_clear"></div>
    <!--top_end-->
	<div class = "divContainer">
		<p class = "header">请绑定持卡人本人的银行卡</p>
		<ul class = "border_top border_bottom">
			
			<li class = "border_bottom">
				<em> 持卡人 </em>	
				<input class="input_normal" type="text"  placeholder="" id="txtusername"  value="${acctbankinfo.NAME}" />				
			</li>
			
			<li class = "border_bottom" >
				<em> 身份证 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="txtpersonalid" value="${acctbankinfo.CERTIFICATE_CODE}" />				
			</li>
			
			<li class = "border_bottom">
				<em> 开户银行 </em>			
                <select  name="band_select" id="band_select" tabindex="1">
                	<option value="请选择开户银行">请选择开户银行</option>
		      		<#if (bankList?size==0)>
						<option value="数据加载失败">数据加载失败</option>
		        	<#else>
						<#list bankList as item>
						    <option value="${item.param_code}" <#if acctbankinfo.BANK_TYPE==item.param_code>  selected="true" </#if> >
							${item.param_value}
							</option>
						</#list>
		 			</#if>
                </select>
			</li>
			
			<li class = "border_bottom">
				<em> 开户支行 </em>			
                <input class="input_normal" type="text"  placeholder="如：中国建设银行贵阳市南明支行" id="bank_branch" value="${acctbankinfo.BANK_BRANCH}" />
			</li>
			
			<li class = "border_bottom">
				<em>银行省份</em>			
                <select name="province_select" id="province_select" tabindex="1" onchange="changeProvince();">
                   <option value="开户银行省份">开户银行省份</option>
                   <#if provinceList??>
						<#list provinceList as item>						
						    <option value="${item.PROVINCE_CODE}" <#if acctbankinfo.PROVINCE_CODE==item.PROVINCE_CODE>  selected="true" </#if> >
							${item.PROVINCE_NAME}
							</option>
						</#list>
				   </#if>
                </select>
			</li>	

			<li class = "border_bottom">
				<em>银行地市</em>			
                <select  name="eparchy_select" id="eparchy_select" tabindex="1" onchange="changeEparchy();">
                    <option value="开户银行地市">开户银行地市</option>
		      		<#if eparchyList??>
						<#list eparchyList as item>						
						    <option value="${item.EPARCHY_CODE}" <#if acctbankinfo.EPARCHY_CODE==item.EPARCHY_CODE>  selected="true" </#if> >
							${item.EPARCHY_NAME}
							</option>
						</#list>
		 			</#if>
                </select>
			</li>
			
			<li class = "border_bottom">
				<em>银行区县</em>			
                <select  name="city_select" id="city_select" tabindex="1">
                    <option value="开户银行区县">开户银行区县</option>
		      		<#if cityList??>
						<#list cityList as item>						
						    <option value="${item.CITY_CODE}" <#if acctbankinfo.CITY_CODE==item.CITY_CODE>  selected="true" </#if> >
							${item.CITY_NAME}
							</option>
						</#list>
		 			</#if>
                </select>                                  
			</li>												
			
			<li class = "border_bottom">
				<em> 卡类型 </em>	
				<select id = "cardType_select" class= "" name="cardType_select" tabindex="0" >
					<option value="--选择卡类型--">--选择卡类型--</option>
					<option value="02" <#if acctbankinfo.CARD_TYPE=='02'>  selected="true" </#if>>借记卡</option>
					<option value="01" <#if acctbankinfo.CARD_TYPE=='01'>  selected="true" </#if>>信用卡</option>
				</select> 			
			</li>
			
			<li id = "validity_li" class = "border_bottom" <#if acctbankinfo.CARD_TYPE=='02'>  style="display : none" </#if> >
				<em class = "em_normal"> 有效期 </em>	
				<input value="${acctbankinfo.EXPIRE_DATE}" class="" readonly="readonly" name="date_select" id="date_select" type="text" value="${acctbankinfo.EXPIRE_DATE}" />
			</li>
			
			<li id = "CVN2_li" class = "border_bottom"  <#if acctbankinfo.CARD_TYPE=='02'>  style="display : none" </#if> >
				<em class = "em_long"> CVN2 <em>(卡背后三位)</em> </em>	
				<input  class= "input_normal input_validation" type="text"  placeholder="" id="txtcord" name="txtcord" value="${acctbankinfo.CVN2}" />				
			</li>
			
			<li class = "border_bottom">
				<em> 卡号 </em>	
				<input class="input_normal"  type="text"  placeholder="" id="txtcardno" name='txtcardno' value="${acctbankinfo.BANK_NO}" disabled="disabled" />				
			</li>
			
			<li class = "border_bottom">
				<em class = "em_long"> 银行预留手机 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="" id="txtphone" value="${acctbankinfo.PHONE}" />				
			</li>
			
			<li class = "border_bottom">
				<em class = "em_normal"> 验证码 </em>	
				<input class= "input_normal input_validation" type="text"  placeholder="输入验证码" id="txtverify" onfocus="doFocus(this);" onblur="doBlur(this);" />				
				<a id = "validation" class = "fright" onclick="getCode();" onblur="doBlur(this);"> 获取验证码 </a	>		
			</li>
		</ul>
		
		<div style = "margin:15px 15px;font-size:14px;">
			<input id="chkRight" type="checkbox" checked="true" name="chkRight">
			同意   
			<a style="color:green" href="regProtocol">《用户协议》</a>
		</div> 
		
		<div class="div_container">
            <button class="btn btn-success btn-block " type="submit" data-toggle="modal" data-target="#myModal" onclick="funcType('1')" >保存修改</button>
        </div>
		<br>        
		<div class="div_container">
            <button class="btn btn-warning btn-block " type="submit" data-toggle="modal" data-target="#myModal" onclick="funcType('2')">解除绑定</button>
        </div>
        
		
		<input type="hidden" id="hide_user_id" name="hide_user_id" value=${user_id}>
		<input type="hidden" value='' id="hide_code_date" name="hide_code_date">
	</div>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">请输入安全密码</h4>
                </div>
                <div class="modal-body">
                	<#if (acctbankinfo?exists)>
                		<span>${acctbankinfo.PARAM_VALUE}
                			<span>
                				尾号${acctbankinfo.BANK_NO?substring((acctbankinfo.BANK_NO?length)-4,acctbankinfo.BANK_NO?length)}
                			</span>
                		</span>
                	 <#else>
 						<center>您还没有绑定银行卡</center>
        			</#if>
                    
                    <br>
                    <div class="pwd_container">
                    	<div>
                     		<input type="password" value="" name="txtsecuritypwd" id="txtsecuritypwd" maxlength="6" size="6" class="form-control" >
                        </div>
<!--                         <div>
                            <input type="password" class="form-control" id="txt1" placeholder="" onkeyup="checkData(this,txt2);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt2" placeholder="" onkeyup="checkData(this,txt3);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt3" placeholder="" onkeyup="checkData(this,txt4);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt4" placeholder="" onkeyup="checkData(this,txt5);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt5" placeholder="" onkeyup="checkData(this,txt6);" onfocus="doFocus(this);">
                        </div>
                        <div>
                            <input type="password" class="form-control" id="txt6" placeholder="" onkeyup="checkData(this,btnok);" onfocus="doFocus(this);">
                        </div> -->
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default modal-button" name="btnclear" id="btnclear" onclick="clearTextVal();">清空</button>
                    <button type="button" class="btn btn-warning modal-button" name="btnok" id="btnok" onclick="doClick();" funcType="">确定</button>
                </div>
                
            </div>
        </div>
    </div>
    
</body>
</html>
