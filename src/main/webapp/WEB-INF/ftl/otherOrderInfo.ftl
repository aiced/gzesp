<!DOCTYPE html>
<html>
<head lang="en">
    <style type="text/css">
        .container-fluid
        {
            margin: 15px;
        }
    </style>
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
            <form>
                <!--输入发票抬头-->
                <div class="form-group">
                    <label for="txtbilltitle" class="sr-only"></label>
                    <input type="text" class="form-control" id="txtbilltitle" placeholder="请输入发票抬头">
                </div>
                <!--输入代金券-->
                <div class="form-group">
                    <label for="txtcash" class="sr-only">Password</label>
                    <input type="text" class="form-control" id="txtcash" placeholder="请选择代金券">
                </div>
                <!--推荐人-->
                <div class="form-group">
                    <label for="txtreferences" class="sr-only">Password</label>
                    <input type="text" class="form-control" id="txtreferences" placeholder="请输入推荐人">
                </div>
                <!--手机号码-->
                <!--推荐人-->
                <div class="form-group">
                    <label for="txtphone" class="sr-only">Password</label>
                    <input type="text" class="form-control" id="txtphone" placeholder="请输入手机号码">
                </div>
                <button id="otherInfoBtn" class="btn btn-warning btn-block " type="submit">确定</button>
            </form>
        </div>
    </div>


</body>
</html>