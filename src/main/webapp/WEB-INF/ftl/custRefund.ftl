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
    
    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/baseJs.js?v=${resVer}"></script>
    
    <style type="text/css">
        .top_container
        {
            margin:30px 10px 10px 10px;
            height: 100px;
        }
        .top_container div{
            font-size: 12px;
            padding: 2px;
        }
        .mid_container
        {
            margin:30px 5px 5px 5px;
            font-size: 14px;
        }
        .div1
        {
            float: left;
            width: 10%;
            height: 34px;
            line-height: 34px;
        }
        .div2
        {
            float: left;
            width: 111px;
            height: 34px;
            line-height: 34px;
        }
        .div3
        {
            float: left;
            width: 50%;
        }
        .div_clear
        {
            clear: both;
        }
        .divstart
        {
            text-align: center;
            margin: 20px;
            color: #666666;
        }
    </style>
    <script type="text/javascript">
    
    var bRet1=false;
	var bRet2=false;
	var bRet3=false;
	//判断输入的是否是手机号
	function isPhoneNum(strPhoneNum)
	{
		if(strPhoneNum && /^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0-9]|170)\d{8}$/.test(strPhoneNum)){
		    return true;//是手机号
		} else{
		    return false; //不是手机号
		}
	}

	function checkData()
	{		
		if(!bRet1)
		{
			alert("请输入姓名");
			return false;
		}
		if(!bRet2)
		{
			return false;
		}
		if(!bRet3)
		{
			alert("请退款原因");
			return false;    			
		}

		return true;
		
	}
    
    
	$(document).ready(function(){ 
 		  //[下一步]按钮点击
		  $("#btnsubmit").click(function(){
			//在这里操作 [下一步]按钮点击
			if(!checkData())
			{
				//数据校验错误
				return false;
			}
			else 
			{
				////数据校验正确
				//location.href='step2';
				return true;
			}	
		  });
 		  
		  //[姓名]文本框失去焦点
		  $("#txtname").blur(function(){
		  	//在这里操作 姓名 文本框失去焦点
		  	if(!$("#txtname").val())
		  	{
		  		$("#div_txtname").addClass("has-error");
		  		bRet1=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_txtname").removeClass("has-error");
		  		$("#div_txtname").addClass("has-success");

		  		bRet1=true;
		  		return;
		  	}
		  });
		  //[手机号]文本框失去焦点
		  $("#txtphone").blur(function(){
			  	if(!$("#txtphone").val())
			  	{
			  		$("#div_txtphone").addClass("has-error");
			  		bRet2=false;
			  		return;
			  	}
			  	else
			  	{
					var bRet=isPhoneNum($("#txtphone").val());
						
					if(!bRet)
					{
					  	alert("手机号格式不对，请重新输入。");
					  	$("#div_txtphone").addClass("has-error");
					  	bRet2=false;
					  	return;
					}
					else if(!checkPhoneNum($("#txtphone").val()))
					{
						  $("#div_txtphone").addClass("has-error");
						  bRet2=false;
						  return;
					}
					else
					{
				  		$("#div_txtphone").removeClass("has-error");
				  		$("#div_txtphone").addClass("has-success");
				  		bRet2=true;
				  		return;
					}
			  	}
			});
		  //[姓名]文本框失去焦点
		  $("#txtreason").blur(function(){
		  	//在这里操作 姓名 文本框失去焦点
		  	if(!$("#txtreason").val())
		  	{
		  		$("#div_txtreason").addClass("has-error");
		  		bRet3=false;
		  		return;
		  	}
		  	else
		  	{
		  		$("#div_txtreason").removeClass("has-error");
		  		$("#div_txtreason").addClass("has-success");

		  		bRet3=true;
		  		return;
		  	}
		  });
		  
	});
    </script>
 
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
	    <div class="container-fluid">
	        <form action="insertRefund" method="post">
	            <div class="top_container">
	                <div>订单编号：${refundInfo.order_id}</div>
	                <div>退款金额：${refundInfo.unit_price}元</div>
	                <div style="font-weight: bolder">退款方式：</div>
	                <div>原路返回（按照您原来支付的方式进行原来退回退款）</div>
	                <input type="hidden" value='${refundInfo.order_id}' id="hide_order_id" name="hide_order_id">
	                <input type="hidden" value='${refundInfo.unit_price}' id="hide_unit_price" name="hide_unit_price">
	                <input type="hidden" value='${refundInfo.Partition_Id}' id="hide_Partition_Id" name="hide_Partition_Id">
	                <input type="hidden" value='${refundInfo.order_no}' id="hide_order_no" name="hide_order_no">
	                <input type="hidden" value='${refundInfo.create_time}' id="hide_create_time" name="hide_create_time">
	                <input type="hidden" value='${refundInfo.order_from}' id="hide_order_from" name="hide_order_from">
	                <input type="hidden" value='${refundInfo.order_time}' id="hide_order_time" name="hide_order_time">
	                <input type="hidden" value='${refundInfo.order_state}' id="hide_order_state" name="hide_order_state">
	            </div>
	            <div class="mid_container">
	                <div class="input-group">
	                    <div class="div1"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16"></div>
	                    <div class="div2">申请人姓名：</div>
	                    <div class="div3" id="div_txtname"> <input type="text" class="form-control" id="txtname" name="txtname" placeholder="请输入姓名"></div>
	                </div>
	                <br/>
	                <div class="input-group">
	                    <div class="div1"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16"></div>
	                    <div class="div2">手机号码：</div>
	                    <div class="div3" id="div_txtphone"><input type="text" class="form-control" id="txtphone" name="txtphone" placeholder="请输入手机号"></div>
	                </div>
	                <br/>
	                <div class="input-group">
	                    <div class="div1"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16"></div>
	                    <div class="div2">退款原因：</div>
	                    <div class="div3" id="div_txtreason"><input type="text" class="form-control" id="txtreason" name="txtreason" placeholder="请退款原因"></div>
	                </div>
	            </div>
	            <div class="div_clear"></div>
	            <div class="divstart"><img src="${resRoot}/image/custRefund/bixuan.png" height="16" width="16">为必填选项</div>
	            <br/>
	            <br/>
	            <button class="btn btn-warning btn-block " type="submit" name="btnsubmit" id="btnsubmit">提交申请</button>
	        </form>
	    </div>
	</div>

    

</body>
</html>