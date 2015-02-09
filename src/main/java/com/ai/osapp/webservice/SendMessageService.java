package com.ai.osapp.webservice;

import java.util.Map;

import com.ai.osapp.webservice.entity.Request;

public interface SendMessageService {
	
	public Map<String, Object> sendMessageToApp (Request req);
	public String sayHello();
	
}
