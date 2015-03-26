<!DOCTYPE html>
<html>
<head lang="en">
   
  

</head>
<body>

    	<!--top_start-->
        <div id="top">
        	<div id="receiveInfoBackBtn"><div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div></div>
        	<div id="top_middle">${title}</div>
        	<div id="top_right"></div>
        </div>
		<div id="dv_clear"></div>
		<!--top_end-->
        <div class="container-fluid">
                <!--输入收件人-->
                <div class="form-group">
                    <label for="txtname" class="sr-only"></label>
                    <input type="text" class="form-control" id="txtname" name="txtname" placeholder="收件人">
                </div>
                <!--输入手机号-->
                <div class="form-group">
                    <label for="txtphone" class="sr-only"></label>
                    <input type="text" class="form-control" id="txtphone" name="txtphone" placeholder="请输入手机号">
                </div>
                
                     <div class="input-group ">
                          <span class="input-group-addon" id="sizing-addon1">省</span>
		                <select name="selProvince" id="selProvince" class="form-control" placeholder="请选择地区" aria-describedby="sizing-addon1">
			      			<option value="贵州">贵州</option>
		                </select>
                     </div>
                      <br/>
                     
                      <div class="input-group ">
		                <span class="input-group-addon" id="sizing-addon2">市</span>
		                <select name="selCity" id="selCity" class="form-control" placeholder="请选择地区" aria-describedby="sizing-addon2">
			      		<#if (citys?? && citys?size>0)>
							<#list citys as item>
								<option value="${item.city_code}">${item.city_name}</option>
							</#list>
			        	<#else>
							<option value="数据加载失败">数据加载失败</option>
			 			</#if>
		                </select>
		            </div>
             		<br/>
            
                     <div class="input-group ">
                          <span class="input-group-addon" id="sizing-addon3">区</span>
		                <select name="selDistrict" id="selDistrict" class="form-control" placeholder="请选择地区" aria-describedby="sizing-addon3">
			      		<#if (districts?? && districts?size>0)>
							<#list districts as item>
								<option value="${item.district_code}">${item.district_name}</option>
							</#list>
			        	<#else>
							<option value="数据加载失败">数据加载失败</option>
			 			</#if>
		                </select>
                     </div>
                <br/>
                <!--输入详细地址-->
                <div class="form-group">
                    <textarea class="form-control" rows="3" id="txtaddress" placeholder="请输入详细地址"></textarea>

                </div>
                <br/>
                <button id="receiveInfoBtn" class="btn btn-warning btn-block " type="button" name="receiveInfoBtn" >确定</button>
        </div>


</body>
</html>