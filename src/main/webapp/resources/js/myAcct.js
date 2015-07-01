  function isSetPwd(param)
    {
 		if (!$("#hide_update_time").val())
  		{
  			alert("请先点击右上角进行安全设置！");
  			$(param).attr('href', '#'); 
  			return false;
  		}  
    }
    function rightClick(param)
    {
    	window.location.href='../acctSecurity/'+$("#hide_user_id").val();
    	
    }
    function leftClick(param)
    {
    	window.location.href='/esp/shopManage/weShopHome?userid='+$("#hide_user_id").val();
    }