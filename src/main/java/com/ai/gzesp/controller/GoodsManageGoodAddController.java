package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.TdGdsDABLERCD;
import com.ai.gzesp.dao.service.TdGdsDABLERCDDao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageGoodAddController {
    
    @Autowired
    private WeShopService weShopService;
	List<Map<String, Object>> goodsNotInRcdList;
    
    StringBuffer sb;
    List<Map<String, Object>> rcdlist;
    @Resource 
    GoodsSql goodsSql;
    @Resource 
    TdGdsDABLERCDDao tdGdsDABLERCDDao;
    
    
    @RequestMapping("/goodsManageGoodAdd")
    public ModelAndView goodsManageGoodAdd(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String strUserID = paramsMap.get("userId");
    	
    	Subject subject = SecurityUtils.getSubject();
		org.apache.shiro.session.Session session = subject.getSession(true);
		String mchId = (String)session.getAttribute("mchId");

    	rcdlist = goodsSql.GetRcdList(strUserID); //根据能人id 查询店长推荐的列表
    	List<Map<String, Object>> goodsList = null;
		sb = new StringBuffer();

		if(rcdlist.size() != 0){
			sb.append("(");
			for(Map<String, Object> map : rcdlist){ 
				for (String k : map.keySet())  
			      {  
			        if(k.equals("GOODSID")){
						sb.append(","+map.get(k));
				        System.out.println(k + " : " + map.get(k));  
			        }
			      }  
	        }
			sb.append(")");
			sb.deleteCharAt(1);
			goodsNotInRcdList = goodsSql.getGoodsListNotIn(sb.toString(), mchId);   
		}else{
			goodsNotInRcdList = goodsSql.getGoodsList(mchId);   			
		}

    	Map rspMap = new HashMap(); 
    	rspMap.put("userId", strUserID);   
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("total", goodsNotInRcdList.size());     	
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("goodsList", goodsNotInRcdList);  
    	rspMap.put("rcdlist", rcdlist);  

    	rspMap.put("title", "选择商品"); 
    	return new ModelAndView("goodsManageGoodAdd.ftl", rspMap);
     }
    
    @RequestMapping("/goodsManageGoodAddInsert")
    //@ResponseBody
    public ModelAndView goodsManageGoodAddInsert(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String goodsIdStr = paramsMap.get("goodsId");
    	String userId = paramsMap.get("userId"); 
    	String partitionIdStr = goodsIdStr.substring(14); //取商品id后两位做分区id，商品id共16位
    	Long goodsId = Long.parseLong(goodsIdStr);
    	Short seqNum = 1;
    	//Short userId = 1;
    	Short partitionId = Short.parseShort(partitionIdStr);
    	TdGdsDABLERCD tdGdsDABLERCD = new TdGdsDABLERCD();
    	tdGdsDABLERCD.setGoodsId(goodsId);
    	tdGdsDABLERCD.setPartitionId(partitionId);
    	tdGdsDABLERCD.setUserId(userId);
    	tdGdsDABLERCD.setSeqNum(seqNum);    	
    	tdGdsDABLERCDDao.insertSelective(tdGdsDABLERCD);
    	
    	//保存完数据库后再重定向到上一步商品添加页面
    	ModelMap mmap = new ModelMap();
    	mmap.addAttribute("userId", userId);
        return new ModelAndView("redirect:/shopManage/goodsManageGoodSelect", mmap);
    	
    }
    
    
    @RequestMapping("/queryGoodsByAjax")
	public ModelAndView queryGoodsByAjax(@RequestBody String inputParam){
		//返回数据表格子页面
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String searchKey = paramsMap.get("searchKey");
    	String searchType1 = paramsMap.get("searchType1");
    	String searchType2 = paramsMap.get("searchType2");

    	
    	String searchLowPrice = paramsMap.get("searchLowPrice");
    	String searchHightPrice = paramsMap.get("searchHightPrice");

    	Map<String, Object> rspMap = new HashMap<String, Object>();  

    	if(searchKey!=null){
    		rspMap.put("searchKey",searchKey);
    	}else if(searchType1!=null ||searchLowPrice !=null){
    		if(searchType1 !=null){
        		rspMap.put("searchType1",searchType1);
        		rspMap.put("searchType2",searchType2);    			

    		}
    		if(searchLowPrice!=null){
        		rspMap.put("searchLowPrice",searchLowPrice);
        		rspMap.put("searchHightPrice",searchHightPrice);
    		}
    	}  
    		List<Map<String, Object>>goodsList = goodsSql.getGoodsListWithCondition(rspMap);
    		List<Map<String, Object>>goodsNotInList = new ArrayList<Map<String, Object>>();
        	//除去已经选中的元素。
    		if(rcdlist.size() != 0){
    			for(Map<String, Object> mapGoodsList : goodsList){ 
    				Boolean isTrue = false;
    				Map<String, Object> mapIndex = mapGoodsList;
    				for (String kGoodsList : mapGoodsList.keySet())  
    			      { 
    					if(kGoodsList.equals("GOODSID")){
    						//遍历子list;
    						for(Map<String, Object> map : rcdlist){ 
    							for (String k : map.keySet())  
    						      { 
    						        if(k.equals("GOODSID")){
    						        	System.out.println(mapGoodsList.get(kGoodsList));
    						        	System.out.println(map.get(k));						        	
    						        	if(mapGoodsList.get(kGoodsList).equals(map.get(k))){
    							        	isTrue = true;
    							        }
    						        	break;
    						        }
    						      }  
    							if(isTrue == true){
    								break;
    							}
    				        }
    						if(isTrue == false){
    							goodsNotInList.add(mapIndex);
    						}
    						break;
    			        }

    			      }  
    	        }	
    			goodsList = goodsNotInList;
    		}		

    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("total", goodsList.size());     	
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("goodsList", goodsList);  
    	rspMap.put("title", "选择商品"); 
    	return new ModelAndView("goodsManageGoodAddSub.ftl", rspMap);
}
    
}

	


