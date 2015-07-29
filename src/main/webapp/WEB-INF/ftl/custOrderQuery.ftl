<!DOCTYPE html>
<html>
<head lang="zh-cn">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>${title}</title>
    
    <!-- Bootstrap core CSS -->
    <link href="${resRoot}/bootstrap/css/bootstrap.min.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/baseStyle.css?v=${resVer}" rel="stylesheet">
    <link href="${resRoot}/css/custOrderQuery.css?v=${resVer}" rel="stylesheet">
    
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
    <script src="${resRoot}/js/jquery.validate.js?v=${resVer}"></script>
    <script src="${resRoot}/bootstrap/js/bootstrap.min.js?v=${resVer}"></script>
    <script src="${resRoot}/js/custOrderQuery.js?v=${resVer}"></script>
    
    <script>
    $(function(){
    	
    		$("#custOrderQueryForm").validate({
    			//focusInvalid : false,
    			//onfocusout: false,
    			 onkeyup: false,
    			 rules: {
 					// simple rule, converted to {required:true}
 					inputMobile: {
 						required: true,
 						number: true
 					},
 					// compound rule
 					inputPassport: {
	    					required: true
 					}
 				},
 				errorPlacement : function(error, element) {  
 	                //element.parent('div').append(error+"--12313123123");  
 	            },
    			 submitHandler: function(form) {
    				    var phone = $('#inputMobile').val();
    		        	var passport = $('#inputPassport').val();
    		        	// add by wangxinjun 
    		        	if($('#inputPassportDiv').hide()){
    		        	   	location.href = "phoneTradRecordList/"+phone;   		     
    		        	}else{
    		        	   	location.href = "custMyOrder/"+phone+"/"+passport;   		     
    		        	}
    		        	
    				 },
    				 highlight : function(element) {  
    		                $(element).parent('.form-group').addClass('has-error');  
    		         },  
    		  
   		            success : function(label, element) {  
   		            	$(element).parent('.form-group').removeClass('has-error');  
   		            }
    				
    		});
    })
    
//     	$('#custOrderQueryForm').submit(function() {
//     		var phone = $('#inputMobile').val();
//         	var passport = $('#inputPassport').val();
//         	//alert(phone + passport);
//         	location.href = "custMyOrder/"+phone+"/"+passport;
//         	return false;
//     	});


   
//     function onBtnSubmit() {
//     	var phone = $('#inputMobile').val();
//     	var passport = $('#inputPassport').val();
//     	location.href = "custMyOrder/"+phone+"/"+passport;
//     	return false;
//     }
    
    </script>
</head>
<body>
    <div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
		
		<!--
		<div class = "topBar" >
        		<div id = "regularOrderId" class = "regularOrderSelected" > 普通订单 </div>
        		<div id = "topUpOrderId" class = "topUpOrderUnselected"  > 一卡充订单 </div>
		</div>
		-->
		

		
        <div class="container">
        		<!--添加 topBar-->					
            <form  id="custOrderQueryForm" class="form-signin" method="post">
                <br/>
                <br/>
                <div class="form-group">
	                <label for="inputMobile" class="sr-only"></label>
	                <input type="text"  id="inputMobile" name="inputMobile" class="form-control" placeholder="输入您的手机号"   autofocus>
                </div>
                <br/>
                <div class="form-group" id = "inputPassportDiv" >
	                <label for="inputPassport" class="sr-only"></label>
	                <input type="text" id="inputPassport" name="inputPassport" class="form-control" placeholder="输入您的证件号" >
                </div>
                <br/>
                <br/>
                <button class="btn btn-warning btn-block "  name="btnSubmit" id="btnSubmit" >提交</button>
            </form>
        </div> 
    </div>
</body>


</html>