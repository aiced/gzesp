    <style type="text/css">
     .div-mask {display: none; position: absolute; top: 0%; left: 0%; width: 100%; height: 300%; background-color: black; z-index:1001; -moz-opacity: 0.9; opacity:.90; filter: alpha(opacity=90); text-align:center;}
     .div-mask img {margin-bottom:15px;}
    </style>
    
    <!-- 如果是安卓手机&&当前是微信内置浏览器 则弹出遮罩层提示更换浏览器 begin -->
    <div class="div-mask" >
      <img src="http://res.mall.10010.com/mall/mobile/images/weixin-mask.png?resVer=20150507220914" width="283px">
      <a onclick="hideMask()"><img src="http://res.mall.10010.com/mall/mobile/images/iknow-btn.png?resVer=20150507220914" width="93px"></a>
    </div>
    <!-- 如果是安卓手机&&当前是微信内置浏览器 则弹出遮罩层提示更换浏览器 end -->
    
    <script>
    var u = window.navigator.userAgent;
    //alert(u);
//    alert(" 是否为移动终端: "+(!!u.match(/AppleWebKit.*Mobile.*/)||!!u.match(/AppleWebKit/)) + 
//          " ios终端: "+(!!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/)) +
//          " android终端: "+(u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) + 
//          " 是否为iPhone: "+(u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1) +
//          " 是否iPad: "+(u.indexOf('iPad') > -1) + 
//          " 是否微信浏览器: "+(u.indexOf('MicroMessenger') > -1) 
//          );
    
    //如果是安卓手机&&当前是微信内置浏览器 则弹出遮罩层提示更换浏览器
    if((u.indexOf('Android') > -1 || u.indexOf('Linux') > -1) && (u.indexOf('MicroMessenger') > -1)){
       $('.div-mask').show();
    }
    
    //隐藏mask
    function hideMask(){
       $('.div-mask').hide();
    }
    </script>            