package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/test")
public class Test {

    @RequestMapping("/test1")
    public ModelAndView test1(){
    	
        ModelAndView mav = new ModelAndView("test1.ftl");
        return mav;
    }
    
    @RequestMapping("/test2")
    @ResponseBody
    public Map<String, String> test2(@RequestBody List<Map<String, String>> paramList)
    {
    	//返回map
    	Map<String, String> result = new HashMap<String, String>();
    	
    	
    	return result;
    }    
}
