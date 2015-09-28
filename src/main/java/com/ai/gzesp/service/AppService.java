package com.ai.gzesp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.AppDao;

@Service
public class AppService {
	
	@Autowired
	private AppDao appDao;
	
	

}
