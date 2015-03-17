<!DOCTYPE html>
<html>
<head lang="en">
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
    
    <style type="text/css">
		.btn{
			padding: 1px 5px;
			font-size: 12px;
			line-height: 1.5; 
		}
    </style>

</head>
<body>
	<div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>返回</div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
	    <div class="container">
	        <form action="findpwd_step1_postdata" method="post">
	            <br>
	            <br>
	            <div class="row">
	                <div class="col-xs-8 col-sm-8">
	                    <input type="text" class="form-control" id="txtphonenum" name="txtphonenum" aria-describedby="txtnum" placeholder="请输入联通手机号"  required autofocus>
	                </div>
	                <div class="col-xs-4 col-sm-4">
	                    <button class="btn btn-primary btn-block form-control" type="button" name="btnCode" id="btnCode">获取验证码</button>
	                </div>
	            </div>
	            <br>
	            <!--输入验证码-->
	            <div class="form-group">
	                <label for="txtyanzhengma" class="sr-only"></label>
	                <input type="text" class="form-control" id="txtyanzhengma" placeholder="请输入验证码"  required>
	            </div>
	            <br/>
	            <button class="btn-sm btn-warning btn-block" type="submit" id="btnStep1">下一步</button>
	        </form>
	    </div> <!-- /container -->
	</div>
	
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js"></script>

	<script type="text/javascript">
		//判断输入的是否是手机号
		function isPhoneNum(strPhoneNum)
		{
			if(strPhoneNum && /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|170)\d{8}$/.test(strPhoneNum)){
			    return true;//是手机号
			} else{
			    return false; //不是手机号
			}
		}

		//校验输入数值是否正确
		function checkData()
		{
		  	if(!isPhoneNum($("#txtphonenum").val()))
		  	{
				alert("手机号格式不对，请重新输入。");
				return false;
		  	}
		  	if(!$("#txtyanzhengma").val())
		  	{
				alert("请输入验证码");
				return false;
		  	}
			return true;
		}
		
		$(document).ready(function(){  
			   //[获取验证码]按钮点击
			  $("#btnCode").click(function(){  
				  //在这里操作获取验证码
				  //alert("发送验证码");
				  var bRet=isPhoneNum($("#txtphonenum").val());
					
				  if(!bRet)
				  {
				  	alert("手机号格式不对，请重新输入。");
				  	return false;
				  }
				  else
				  {
				  	//这里开始做验证码操作
				  	sendMessage($("#txtphonenum").val(),"#btnCode");
					//按钮禁用
				  	//$("#btnCode").attr('disabled',true);
				  	return true;
				  }
			  });
			//[验证码]文本框失去焦点  
			$("#txtyanzhengma").blur(function(){
			  	//在这里操作 验证码 文本框失去焦点
			  	if(!$("#txtyanzhengma").val())
			  	{
					//alert($("#txtyanzhengma").val());
			  	}
			  	else
			  	{
			  	}
			});
		 	//[下一步]按钮点击
		 	$("#btnStep1").click(function(){
				//在这里操作 [下一步]按钮点击
				if(!checkData())
				{
					//数据校验错误
					return false;
				}
				else 
				{
					//数据校验正确
					//location.href='step2';
					return true;
				}	
		 	}); 
		});
	</script>
</body>
</html>