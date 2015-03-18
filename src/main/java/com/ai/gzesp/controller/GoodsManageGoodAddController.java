package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDABLERCD;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.service.TdGdsDABLERCDDao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageGoodAddController {
    
    @Autowired
    private WeShopService weShopService;
    @Resource 
    GoodsSql goodsSql;
    @Resource 
    TdGdsDABLERCDDao tdGdsDABLERCDDao;
    
    
    @RequestMapping("/goodsManageGoodAdd")
    public ModelAndView goodsManageGoodAdd(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String name = paramsMap.get("index");
    	List<Map<String, Object>> goodsList = goodsSql.getGoodsList();   
    	
    	List<Map<String, Object>> rcdlist = goodsSql.GetRcdList();   

    	Map rspMap = new HashMap();    
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("total", goodsList.size());     	
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("goodsList", goodsList);  
    	rspMap.put("rcdlist", rcdlist);  

    	rspMap.put("title", "选择商品"); 
    	return new ModelAndView("goodsManageGoodAdd.ftl", rspMap);
    	
//        ModelAndView mav = new ModelAndView("goodsManageGoodAdd.ftl");
//        //从数据库获取信息赋值
//        mav.addObject("name", "喻露露");
//        mav.addObject("phone", "18685292522"); 
//        mav.addObject("weixin", "1306520198@qq.com"); 
//        return mav;
    }
    
    @RequestMapping("/goodsManageGoodAddInsert")
    @ResponseBody
    public void goodsManageGoodAddInsert(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String goodsIdStr = paramsMap.get("goodsId");
    	Long goodsId = Long.parseLong(goodsIdStr);
    	Short seqNum = 1;
    	Short userId = 1;
    	TdGdsDABLERCD tdGdsDABLERCD = new TdGdsDABLERCD();
    	tdGdsDABLERCD.setGoodsId(goodsId);
    	tdGdsDABLERCD.setPartitionId(userId);
    	tdGdsDABLERCD.setUserId("1");
    	tdGdsDABLERCD.setSeqNum(seqNum);    	
    	tdGdsDABLERCDDao.insertSelective(tdGdsDABLERCD);
    	
    }
    
    
    @RequestMapping("/queryGoodsByAjax")
	public ModelAndView queryGoodsByAjax(@RequestBody String inputParam){
		//返回数据表格子页面
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String searchKey = paramsMap.get("searchKey");
    	
    	String searchType = paramsMap.get("searchType");
    	String searchLowPrice = paramsMap.get("searchLowPrice");
    	String searchHightPrice = paramsMap.get("searchHightPrice");

    	Map rspMap = new HashMap();  

    	if(searchKey!=null){
    		rspMap.put("searchKey",searchKey);
    	}else if(searchType!=null ||searchLowPrice !=null){
    		if(searchType !=null){
        		rspMap.put("searchType",searchType);    			
    		}
    		if(searchLowPrice!=null){
        		rspMap.put("searchLowPrice",searchLowPrice);
        		rspMap.put("searchHightPrice",searchHightPrice);
    		}
    	}  
    	
    	List<Map<String, Object>>goodsList = goodsSql.getGoodsListWithCondition(rspMap); 
    	
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("total", goodsList.size());     	
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("goodsList", goodsList);  
    	rspMap.put("title", "选择商品"); 
    	return new ModelAndView("goodsManageGoodAddSub.ftl", rspMap);

//		ModelAndView mav = new ModelAndView("goodsManageGoodAddSub.ftl"); 
		//从数据库获取信息赋值
		//数据库分页获取号码列表 默认第一页
//		ArrayList<HashMap<String, String>> numbers = new ArrayList<HashMap<String, String>>();
//		HashMap<String, String> number1 = new HashMap<String, String>();
//		number1.put("number", "13851885061");
//		number1.put("fee", "0");
//		HashMap<String, String> number2 = new HashMap<String, String>();
//		number2.put("number", "13851885062");
//		number2.put("fee", "0");
//		HashMap<String, String> number3 = new HashMap<String, String>();
//		number3.put("number", "13851885063");
//		number3.put("fee", "100");
//		numbers.add(number1);
//		numbers.add(number2);
//		numbers.add(number3);
//		mav.addObject("numbers", numbers);
//		return mav;
}
    
    
}

	


