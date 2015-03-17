<!DOCTYPE html>
<html>
<head lang="en">
   
    <style type="text/css">
        .container-fluid
        {
            margin: 15px;
        }
        .form-control
        {
            font-size: 10px;
            padding:3px 3px;
        }

    </style>
</head>
<body>

    <div>
    	<!--top_start-->
        <div id="top">
        	<div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true">返回</span></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
        <div class="container-fluid">
            <form>
                <!--输入收件人-->
                <div class="form-group">
                    <label for="txtname" class="sr-only"></label>
                    <input type="text" class="form-control" id="txtname" placeholder="收件人">
                </div>
                <!--输入手机号-->
                <div class="form-group">
                    <label for="txtphone" class="sr-only"></label>
                    <input type="text" class="form-control" id="txtphone" placeholder="请输入手机号">
                </div>
                <div class="row">
                    <div class="col-xs-4 col-sm-4">
                        <div class="input-group">
                            <select class="form-control" placeholder="省">
                                <option>贵州</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4">
                        <div class="input-group">
                            <select class="form-control" placeholder="市">
                                <option>贵州</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4">
                        <div class="input-group">
                            <select class="form-control" placeholder="区">
                                <option>贵州</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                                <option>5</option>
                            </select>
                        </div>
                    </div>
                </div>
                <br/>
                <!--输入详细地址-->
                <div class="form-group">
                    <textarea class="form-control" rows="3" id="txtaddress" placeholder="请输入详细地址"></textarea>

                </div>
                <br/>
                <button id="receiveInfoBtn" class="btn btn-warning btn-block " type="submit">确定</button>
            </form>
        </div>
    </div>


</body>
</html>