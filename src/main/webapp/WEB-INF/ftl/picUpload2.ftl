<!DOCTYPE html>
<html lang="zh-cn">
  <head>
	 <style type="text/css">	 
	 	 * {margin:0;padding:0;} 
		html,body{
	 		background-color:#E8E9E8; 
		}
		 html, body , p {
		  margin:0; 
		  padding:0; 
	   	  list-style:none;
		 }
		
		.img-w {
		    position: relative;
		    overflow: hidden;
		    width: 100%;
		    padding: 20px;
		    margin-bottom: 15px;
		    background-color: #F0F0F0;
		    text-align: center;
		}
		.file-input {
		    opacity: 0;
		    width: 100%;
		    height: 100%;
		    position: absolute;
		    bottom: 0px;
		    left: 0px;
		    z-index: 999;
		}
		
		.well {
	  min-height: 20px;
	  padding: 19px;
	  margin-top: 5px;
	  margin-bottom: 5px;
	  background-color: #f5f5f5;
	  border: 1px solid #e3e3e3;
	  border-radius: 4px;
	  -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
	  box-shadow: inset 0 1px 1px rgba(0,0,0,.05);
	}
	 	.list-arr{
	 	float:right;width:6px;height:10px;margin-top:5px;margin-right:5px;background:url(/esp/resources/image/order/arr_down.png) no-repeat;-webkit-background-size:6px 10px;-moz-background-size:6px 10px;background-size:6px 10px;}
	 	
	 	
	 	a:focus {
		text-decoration: none;
	}
	</style>
  
   <script src="http://res.wx.qq.com/open/js/jweixin-1.0.0.js"></script>
	<script>
	  /*
	   * 注意：
	   * 1. 所有的JS接口只能在公众号绑定的域名下调用，公众号开发者需要先登录微信公众平台进入“公众号设置”的“功能设置”里填写“JS接口安全域名”。
	   * 2. 如果发现在 Android 不能分享自定义内容，请到官网下载最新的包覆盖安装，Android 自定义分享接口需升级至 6.0.2.58 版本及以上。
	   * 3. 常见问题及完整 JS-SDK 文档地址：http://mp.weixin.qq.com/wiki/7/aaa137b55fb2e0456bf8dd9148dd613f.html
	   *
	   * 开发中遇到问题详见文档“附录5-常见错误及解决办法”解决，如仍未能解决可通过以下渠道反馈：
	   * 邮箱地址：weixin-open@qq.com
	   * 邮件主题：【微信JS-SDK反馈】具体问题
	   * 邮件内容说明：用简明的语言描述问题所在，并交代清楚遇到该问题的场景，可附上截屏图片，微信团队会尽快处理你的反馈。
	   */
	  wx.config({
	    debug: true,
	    appId: '${appId}',
	    timestamp: ${timestamp},
	    nonceStr: '${nonceStr}',
	    signature: '${signature}',
	    jsApiList: [
	      // 所有要调用的 API 都要加到这个列表中
	      	'chooseImage',
	        'previewImage',
	        'uploadImage'
	    ]
	  });
	
	  wx.ready(function () {
	    // 在这里调用 API
		  console.log("success---");
		  console.log(location.href.split('#')[0]);
		  console.log('${url}');
// 		  var images = {
// 		  		    localId: [],
// 		  		    serverId: []
//   		  };
		  $('.file-input').bind("click",function(){
			 var img = $(this).siblings("img");
			  wx.chooseImage({
	  		      success: function (res) {
// 	  		        images.localId = res.localIds;
	  		      	console.log(res.localIds);
	  		       	//alert(res.localIds);
	  		      	img.attr("src", res.localIds[0]);
	  		      }
	  		    });
		  });
		  
//   		  document.querySelector('#chooseImage').onclick = function () {
//   		    wx.chooseImage({
//   		      success: function (res) {
//   		        images.localId = res.localIds;
//   		      	console.log(res.localIds);
//   		       	alert(res.localIds);
// 	 	    	$('#firstCard').attr("src", res.localIds[0]);
//   		      }
//   		    });
//   		  };


//   		  document.querySelector('#uploadImage').onclick = function () {
//   		    if (images.localId.length == 0) {
//   		      return;
//   		    }
//   		    var i = 0, length = images.localId.length;
//   		    images.serverId = [];
//   		    function upload() {
//   		      wx.uploadImage({
//   		        localId: images.localId[i],
//   		        success: function (res) {
//   		          i++;
//   		          images.serverId.push(res.serverId);
//   		          if (i < length) {
//   		            upload();
//   		          }
//   		        },
//   		        fail: function (res) {
//   		          alert(JSON.stringify(res));
//   		        }
//   		      });
//   		    }
//   		    upload();
//   		  };
	  });
	  
	  wx.error(function(res){

		    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
			console.log("error---"+res);
		});
	</script>
  </head>

  <body >
<!--标题   -->
   	<div id="top">
       	<div id="netInfoBackBtn"><div id="top_left"><span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span></div></div>
       	<div id="top_middle">${title}</div>
       	<div id="top_right"></div>
    </div>
	<div id="dv_clear"></div>
    <!-- 主机号，身份证号 -->
     <div class="container">
      		<br/>
      		 <input id = "userName" type="text" placeholder="机主姓名"  class="form-control" required>
			 <br/>
			 <input id = "userCard" type="text" placeholder="身份证号" class="form-control" required>
			  <br/>
     </div> 

     <!-- 工信部实名登记规定 start-->
     <div class="container">
       <a id="ruwangxieyi" onclick="proxyClick()" class="btn-block" style="border-bottom: solid 1px #ccc;" data-toggle="collapse" href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
             	《入网协议》<b class="list-arr"></b>
       </a>  
         
       <div class="collapse" id="collapseExample">
         <div class="well">
                   根据国家工信部<a href="#renda" data-toggle="modal" data-target="#lawTip">《电话用户真实身份信息登记规定》（工业和信息化部令25号）</a>要求，用户在贵州联通沃掌柜办理电话开户过户等入网手续需进行实名制登记。中国联通将保证此<strong class="cf60 ">身份证照片</strong>仅用于本次入网使用。
         </div>
         <div class="well">
                   在您签收时，请入网人持本人<strong class="cf60">身份证件原件</strong>签收，严禁代收，请您提前准备好<strong class="cf60">复印件</strong>，并可在<strong class="cf60">复印件</strong>上标注“仅限中国联通入网使用”字样及日期，中国联通将保证此<strong class="cf60">复印件</strong>仅用于本次入网使用。
         </div>

       </div>
     </div> 
     <!-- 工信部实名登记规定 end--> 
     <!-- 《电话用户真实身份信息登记规定》（工业和信息化部令25号） -->    
     <div id="lawTip" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
      <div class="modal-dialog modal-lg">
        <div class="modal-content" style="padding:5px;height:1550px;text-align:center">
            <div class="modal-header" style="padding:0px;">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		    	<h5 class="modal-title" id="myModalLabel" style="visibility: hidden;">Modal title</h5>
		    </div>
            
            <p><strong class="cf60">《全国人民代表大会常务委员会关于加强网络信息保护的决定》</strong></p>
            <p><strong class="cf60">（２０１２年１２月２８日第十一届全国人民代表大会常务委员会第三十次会议通过）</strong></p>
            <p>为了保护网络信息安全，保障公民、法人和其他组织的合法权益，维护国家安全和社会公共利益，特作如下决定： </p>

            <p>一、国家保护能够识别公民个人身份和涉及公民个人隐私的电子信息。</p>

            <p>任何组织和个人不得窃取或者以其他非法方式获取公民个人电子信息，不得出售或者非法向他人提供公民个人电子信息。</p>

            <p>二、网络服务提供者和其他企业事业单位在业务活动中收集、使用公民个人电子信息，应当遵循合法、正当、必要的原则，明示收集、使用信息的目的、方式和范围，并经被收集者同意，不得违反法律、法规的规定和双方的约定收集、使用信息。</p>

            <p>网络服务提供者和其他企业事业单位收集、使用公民个人电子信息，应当公开其收集、使用规则。</p>

            <p>三、网络服务提供者和其他企业事业单位及其工作人员对在业务活动中收集的公民个人电子信息必须严格保密，不得泄露、篡改、毁损，不得出售或者非法向他人提供。</p>

            <p>四、网络服务提供者和其他企业事业单位应当采取技术措施和其他必要措施，确保信息安全，防止在业务活动中收集的公民个人电子信息泄露、毁损、丢失。在发生或者可能发生信息泄露、毁损、丢失的情况时，应当立即采取补救措施。</p>

            <p>五、网络服务提供者应当加强对其用户发布的信息的管理，发现法律、法规禁止发布或者传输的信息的，应当立即停止传输该信息，采取消除等处置措施，保存有关记录，并向有关主管部门报告。</p>

            <p>六、网络服务提供者为用户办理网站接入服务，办理固定电话、移动电话等入网手续，或者为用户提供信息发布服务，应当在与用户签订协议或者确认提供服务时，要求用户提供真实身份信息。</p>

            <p>七、任何组织和个人未经电子信息接收者同意或者请求，或者电子信息接收者明确表示拒绝的，不得向其固定电话、移动电话或者个人电子邮箱发送商业性电子信息。</p>

            <p>八、公民发现泄露个人身份、散布个人隐私等侵害其合法权益的网络信息，或者受到商业性电子信息侵扰的，有权要求网络服务提供者删除有关信息或者采取其他必要措施予以制止。</p>

            <p>
                九、任何组织和个人对窃取或者以其他非法方式获取、出售或者非法向他人提供公民个人电子信息的违法犯罪行为以及其他网络信息违法犯罪行为，有权向有关主管部门举报、控告；接到举报、控告的部门应当依法及时处理。被侵权人可以依法提起诉讼。</p>

            <p>
                十、有关主管部门应当在各自职权范围内依法履行职责，采取技术措施和其他必要措施，防范、制止和查处窃取或者以其他非法方式获取、出售或者非法向他人提供公民个人电子信息的违法犯罪行为以及其他网络信息违法犯罪行为。有关主管部门依法履行职责时，网络服务提供者应当予以配合，提供技术支持。</p>

            <p>国家机关及其工作人员对在履行职责中知悉的公民个人电子信息应当予以保密，不得泄露、篡改、毁损，不得出售或者非法向他人提供。</p>

            <p>
                十一、对有违反本决定行为的，依法给予警告、罚款、没收违法所得、吊销许可证或者取消备案、关闭网站、禁止有关责任人员从事网络服务业务等处罚，记入社会信用档案并予以公布；构成违反治安管理行为的，依法给予治安管理处罚。构成犯罪的，依法追究刑事责任。侵害他人民事权益的，依法承担民事责任。</p>

            <p> 十二、本决定自公布之日起施行。</p>  




        </div>
      </div>
     </div>
     <!-- 《电话用户真实身份信息登记规定》（工业和信息化部令25号） -->  
     <br/>
     <div class="container">
     <!--上传文字  -->
     	<div style="height:70px;" >
     			<div style="background-color:#5B5B5B; float:left;width:5px;height:12px;margin-top:8px;margin-left:8px;">
     			</div>
     			 <p style="color:#5B5B5B;float:left;margin-top:8px;margin-left:8px;width:100px;height:12px ;line-height:12px;font-size:14px;"> 证件照片 </p> 	
     			<div style="color:#818181; float:left;width:100%;height:15px;margin-top:8px;margin-bottom:8px;text-align:center;font-size:9px;">
     				请上传身份证正、反两面照片，头像要求、照片、姓名、地址文字、头像清晰     				
     			</div>     		
     	</div>
      <!--上传图片  -->
       
<!--        <div id="picsHolder"> -->
<!-- 			       <img id="viewImg" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABIAAAAfCAYAAADqUJ2JAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyZpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuNi1jMDE0IDc5LjE1Njc5NywgMjAxNC8wOC8yMC0wOTo1MzowMiAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENDIDIwMTQgKFdpbmRvd3MpIiB4bXBNTTpJbnN0YW5jZUlEPSJ4bXAuaWlkOkE3MkQ2NDI0QkU1RDExRTQ5QzBFOUI4QTc4RDQ5Q0UxIiB4bXBNTTpEb2N1bWVudElEPSJ4bXAuZGlkOkE3MkQ2NDI1QkU1RDExRTQ5QzBFOUI4QTc4RDQ5Q0UxIj4gPHhtcE1NOkRlcml2ZWRGcm9tIHN0UmVmOmluc3RhbmNlSUQ9InhtcC5paWQ6QTcyRDY0MjJCRTVEMTFFNDlDMEU5QjhBNzhENDlDRTEiIHN0UmVmOmRvY3VtZW50SUQ9InhtcC5kaWQ6QTcyRDY0MjNCRTVEMTFFNDlDMEU5QjhBNzhENDlDRTEiLz4gPC9yZGY6RGVzY3JpcHRpb24+IDwvcmRmOlJERj4gPC94OnhtcG1ldGE+IDw/eHBhY2tldCBlbmQ9InIiPz5aNbEVAAABoklEQVR42pyVzytEURTH3zxDSPZ2zL9hMSTR5FcyouwICSGj+QcskEhCfpdYKIQw6kUWVhY2FjbvWYhSSkpvsPK903k1nW65Z7716TWn1+e9ue+ec0Ou69ZZlrUJ8sEo2LUEiUQimWsYbIEyqu+AIrBuCWOz3yGwCnpzEfWDXyZbobpIdALiGtmSRBb8NSVrBmmNbEC6RinQBHwmWwSD0sV2QAx8MdkCGJaIVG5APfhksnkwIhGp3IJa8MFkc2BMIlK5AzXgndVndTL7nzW8B9XgTSMbl4hUHkAVeGX1GTAhEak8gih4ZvUpz/OSmQVE90s6oQJcgXJWT9rC3nwCCU1dLKoEG6ymerRHIopSG5UySSeG24GpSG3Oc1DCJB2QHJp+tRhNh2ImaQdHpp+/hW4uZJI2cGy6IdUT90EBk7SCU9MW6QJ7dLIE+aE3PDNt2m6wDfI0kgvTMdIH1pjkmyQp08E2BJZp7gRJm0iyRQkap9kSnySXJhstTG8yzeo+nSqO6bZXokmNpJG6XHRAvjBJg1QSiOLUAg6N1Wsrh/wJMABVKF1HcKrwSAAAAABJRU5ErkJggg==" style="max-width:500px"/> -->
<!--        </div> -->
      <div style="padding:5px" >
      			<div class="img-w">
	     		     <img id ="firstCard" src="${resRoot}/image/order/card01.png" style="display:block;width:175px;height:110px;margin:0px auto;">
	     		     <button  class="file-input" id="file-front" name="uploadFile"></button>			
     			  </div>
     			     
     			 <div class="img-w"> 
     	        	 <img id ="secondCard" src="${resRoot}/image/order/card02.png" style="display:block;width:175px;height:110px;margin:0px auto;" />
     	        	 <button  class="file-input" id="file-back" name="uploadFile"></button>
       		 	</div>
       		 	
<!--        		     <button id="netInfoBtn" class="btn btn-warning btn-block " type="submit" >同意协议并确定</button> -->
       		     <button id="netInfoBtn" class="btn btn-warning btn-block " type="submit" >上传证件照</button>
    	</div>
     	
     </div>
    
  </body>
</html>