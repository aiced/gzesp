package com.ai.osapp.remote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.sysframe.utils.PushUtil;
import com.ai.sysframe.utils.jpush.PushMsgInfo;
*/
@Controller
@RequestMapping(value="${adminPath}/sendMessage")
public class SendMessageController {
	
/*	
	@RequestMapping(value="/sendMessageToApp")
	@ResponseBody
	public Map<String,Object> sendMessageToApp(@RequestBody Map<String,Object> inputParam)
	{
		
		Map<String,Object> rspMap = new HashMap<String,Object>();
		
		final String message = (String) inputParam.get("message");
		final String userNumber = (String) inputParam.get("userNumber");
		final String UserToken = (String) inputParam.get("UserToken");
		final String FromSystem = (String) inputParam.get("FromSystem");
		
		PushMsgInfo pushMsgInfo = new PushMsgInfo();
		pushMsgInfo.setAlter(message);
		pushMsgInfo.setMsgContent(message);
		pushMsgInfo.setTitle("消息");

//    	Criteria crit = new Criteria(); 
//    	crit.createConditon().andEqualTo("LOGIN_NAME", userNumber);
//		List<TdMUser> list = userDao.selectByExample(crit);
//		
		if(userNumber != null) 
    	{
//    		TdMUser tdMUser = list.get(0); 

     		pushMsgInfo.setUserAlias(UserToken);
    		
    		PushUtil.push(pushMsgInfo, FromSystem);
    		
    		rspMap.put("rspCode", "0");
    		rspMap.put("rspDesc", "成功");
    	}
		else 
		{

    		rspMap.put("rspCode", "-1");
    		rspMap.put("rspDesc", "失败");
		}
		
		return rspMap;
	}
	*/
}
