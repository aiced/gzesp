package com.ai.gzesp.controller;

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
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.service.TdGdsDABLERCDDao;
import com.ai.gzesp.dao.service.TdGdsDINFODao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageGoodDetailController {
    
    @Autowired
    private WeShopService weShopService;

    @Resource 
    GoodsSql goodsSql;
    
    @RequestMapping("/goodsManageGoodDetail")
    public ModelAndView goodsManageGoodDetail(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String goodsIdStr = paramsMap.get("goodsId");
    	
    	String goodsId = paramsMap.get("goodsId");
    	List<Map<String, Object>> goodsList = goodsSql.getGoodsList();   

    	
    	Map rspMap = new HashMap();    
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("total", infolist.size());     	
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("list", infolist);  
    	rspMap.put("title", "选择商品"); 
    	return new ModelAndView("goodsManageGoodDetail.ftl", rspMap);

    }
    
    
    @RequestMapping("/goodsManageGoodDetailUpdate")
    @ResponseBody
    public void goodsManageGoodDetailUpdate(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String goodsIdStr = paramsMap.get("goodsId");
    	Long goodsId = Long.parseLong(goodsIdStr);
    	Short seqNum = 1;
    	Short userId = 1;
    	TdGdsDINFO tdGdsDINFO = new TdGdsDINFO();
    	tdGdsDINFO.setGoodsId(goodsId);
    	tdGdsDINFO.setPartitionId(userId);
    	tdGdsDINFO.setSimpDesc("1");
    	tdGdsDINFO.setSeqNum(seqNum);
    	
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("GOODS_ID", goodsId);
    	
    	tdGdsDINFODao.updateByExample(tdGdsDINFO,example);
    	
    	

//    	List<Map<String, Object>> rcdlist = goodsSql.GetRcdList();   
//    	Map rspMap = new HashMap();    
//    	rspMap.put("rspCode", "0000");   
//    	rspMap.put("name", "weidian");   
//    	rspMap.put("total", rcdlist.size());   
//    	rspMap.put("title", "选择商品"); 
//    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
//    	rspMap.put("rcdlist", rcdlist);  
//    	return new ModelAndView("goodsManageGoodSelect.ftl", rspMap);
    	
    	
    }
}
