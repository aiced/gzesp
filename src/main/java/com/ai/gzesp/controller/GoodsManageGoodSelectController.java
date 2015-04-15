package com.ai.gzesp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.service.TdGdsDABLERCDDao;
import com.ai.gzesp.dao.service.TdOrdDBASEDao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageGoodSelectController {
    
    @Autowired
    private WeShopService weShopService;
    @Resource 
    GoodsSql goodsSql;
    @Resource 
    TdGdsDABLERCDDao tdGdsDABLERCDDao;
    
    @RequestMapping("/goodsManageGoodSelect")
    public ModelAndView goodsManageGoodSelect(@RequestBody String inputParam, HttpServletRequest request){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	//String name = paramsMap.get("index");
    	String strUserID = paramsMap.get("userId");
        //inputParam如果娶不到userId,表示是从/goodsManageGoodAddInsert这个controller 重定向过来的
        if(strUserID == null){
            strUserID = request.getParameter("userId");
        }
    	
/*    	if(strUserID == null){
    		strUserID = "333";
    	}
    	
    	//根据index 检索数据库，加载数据。
    	String goodsId = paramsMap.get("goodsId");
    	if(goodsId != null){
        	Criteria criteria = new Criteria();
        	criteria.createConditon().andEqualTo("GOODS_ID", goodsId);
        	int res = tdGdsDABLERCDDao.deleteByExample(criteria);   
    	}*/

    	
    	List<Map<String, Object>> rcdlist = goodsSql.GetRcdList(strUserID);   
    	Map rspMap = new HashMap();  
    	rspMap.put("userId", strUserID);   
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "");   
    	rspMap.put("total", rcdlist.size());   
    	rspMap.put("title", "选择商品");
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("rcdlist", rcdlist);  
    	rspMap.put("hideTag", 0);      	
    	return new ModelAndView("goodsManageGoodSelect.ftl", rspMap);

    }
    
    @RequestMapping("/goodsManageGoodSelectDelete")
    @ResponseBody

    public void goodsManageGoodSelectDelete(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	//根据index 检索数据库，加载数据。
    	String goodsId = paramsMap.get("goodsId");
    	String userId = paramsMap.get("userId");
    	if(goodsId != null){
        	Criteria criteria = new Criteria();
        	criteria.createConditon().andEqualTo("GOODS_ID", goodsId);
        	criteria.createConditon().andEqualTo("USER_ID", userId);
        	int res = tdGdsDABLERCDDao.deleteByExample(criteria);   
    	}
    }
    
}
