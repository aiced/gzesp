package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.service.OrderService;

@Controller
@RequestMapping("/order")
public class selectNumber {

    @Autowired
    private OrderService orderService;
    
    /**
     * 三级页面：新号入网-选择号码 <br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/selectNumber")
    public ModelAndView selectNumber(){
        ModelAndView mav = new ModelAndView("selectNumber.ftl");
        //从数据库获取信息赋值
        //数据库获取地市
        ArrayList<HashMap<String, String>> citys = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> city1 = new HashMap<String, String>();
        city1.put("city_code", "0510");
        city1.put("city_name", "贵阳");
        HashMap<String, String> city2 = new HashMap<String, String>();
        city2.put("city_code", "0511");
        city2.put("city_name", "遵义");  
        citys.add(city1);
        citys.add(city2);
        mav.addObject("citys", citys);
        
        //数据库分页获取号码列表 默认第一页
        ArrayList<HashMap<String, String>> numbers = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> number1 = new HashMap<String, String>();
        number1.put("number", "18651885061");
        number1.put("fee", "0");
        HashMap<String, String> number2 = new HashMap<String, String>();
        number2.put("number", "18651885062");
        number2.put("fee", "0");
        HashMap<String, String> number3 = new HashMap<String, String>();
        number3.put("number", "18651885063");
        number3.put("fee", "100");
        numbers.add(number1);
        numbers.add(number2);
        numbers.add(number3);
        mav.addObject("numbers", numbers);
        
        return mav;
    }
    
    /**
     * 三级页面：新号入网-选择号码 <br>
     * 输入尾号搜索 ajax刷新号码列表
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/queryNumbersByAjax")
    public ModelAndView queryNumbersByAjax(){
        //返回数据表格子页面
        ModelAndView mav = new ModelAndView("selectNumberSub.ftl"); 
        //从数据库获取信息赋值
        //数据库分页获取号码列表 默认第一页
        ArrayList<HashMap<String, String>> numbers = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> number1 = new HashMap<String, String>();
        number1.put("number", "13851885061");
        number1.put("fee", "0");
        HashMap<String, String> number2 = new HashMap<String, String>();
        number2.put("number", "13851885062");
        number2.put("fee", "0");
        HashMap<String, String> number3 = new HashMap<String, String>();
        number3.put("number", "13851885063");
        number3.put("fee", "100");
        numbers.add(number1);
        numbers.add(number2);
        numbers.add(number3);
        mav.addObject("numbers", numbers);
        
        return mav;
    }
}
