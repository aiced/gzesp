<!DOCTYPE html>
<html lang="zh-cn">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <title>test</title>
 	<script src="${resRoot}/js/jquery.min.js?v=${resVer}"></script>
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
		  var images = {
		  		    localId: [],
		  		    serverId: []
  		  };
  		  document.querySelector('#chooseImage').onclick = function () {
  		    wx.chooseImage({
  		      success: function (res) {
  		        images.localId = res.localIds;
  		      	console.log(res.localIds);
  		       	alert(res.localIds);
	 	    	$('#firstCard').attr("src", res.localIds[0]);
  		      }
  		    });
  		  };


  		  document.querySelector('#uploadImage').onclick = function () {
  		    if (images.localId.length == 0) {
  		      return;
  		    }
  		    var i = 0, length = images.localId.length;
  		    images.serverId = [];
  		    function upload() {
  		      wx.uploadImage({
  		        localId: images.localId[i],
  		        success: function (res) {
  		          i++;
  		          images.serverId.push(res.serverId);
  		          if (i < length) {
  		            upload();
  		          }
  		        },
  		        fail: function (res) {
  		          alert(JSON.stringify(res));
  		        }
  		      });
  		    }
  		    upload();
  		  };
	  });
	  
	  wx.error(function(res){

		    // config信息验证失败会执行error函数，如签名过期导致验证失败，具体错误信息可以打开config的debug模式查看，也可以在返回的res参数中查看，对于SPA可以在这里更新签名。
			console.log("error---"+res);
		});
	</script>

  </head>

  <body>

    
         
    <div class="container-fluid" style="background-color:#ffffff;margin:15px;">
  
      <span class="desc">拍照或从手机相册中选图接口</span>
      <button class="btn btn_primary" id="chooseImage">chooseImage</button>

      <span class="desc">上传图片接口</span>
      <button class="btn btn_primary" id="uploadImage">uploadImage</button>
      
      <img id ="firstCard" src="${resRoot}/image/order/card01.png" style="display:block;width:175px;height:110px;margin:0px auto;">
      <img id ="ss" src="weixin://resourceid/64a9aad7be62565da5f9e3f55b37852e" style="display:block;width:175px;height:110px;margin:0px auto;">
      <div>
  </body>
</html>
