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
import com.ai.gzesp.dao.beans.TdGdsDABLEACTIVITY;
import com.ai.gzesp.dao.beans.TdGdsDABLERCD;
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.service.TdGdsDABLEACTIVITYDao;
import com.ai.gzesp.dao.service.TdGdsDABLERCDDao;
import com.ai.gzesp.dao.service.TdGdsDINFODao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.service.WeShopService;
import com.ai.sysframe.utils.CommonUtil;
import com.ai.sysframe.utils.DateUtil;
import com.ai.sysframe.utils.StringUtil;

@Controller
@RequestMapping("/shopManage")
public class GoodsManageGoodDetailController {
    
    private static final String TdGdsDABLEACTIVITY = null;

	@Autowired
    private WeShopService weShopService;
	
    @Resource 
    GoodsSql goodsSql;
    
    @Resource 
    TdGdsDABLEACTIVITYDao tdGdsDABLEACTIVITYDao;
    
    @RequestMapping("/goodsManageGoodDetail")
    public ModelAndView goodsManageGoodDetail(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);    	
    	String goodsId = paramsMap.get("goodsId");
    	
    	List<Map<String, Object>> goodsDetailList = goodsSql.GetGoodsDetail(goodsId);  
    	List<Map<String, Object>> goodsDetailPhotosList = goodsSql.GetGoodsDetailPhotos(goodsId);       	
    	List<Map<String, Object>> goodsActivityList = goodsSql.GetGoodsDetailActivity(goodsId);  

    	
        List<String> banners = new ArrayList<String>();
        banners.add("banner_iphone6.png");
        banners.add("banner_honer_x1.png");

    	
    	Map rspMap = new HashMap();    
    	rspMap.put("rspCode", "0000");   
    	rspMap.put("name", "weidian");   
    	rspMap.put("total", goodsDetailPhotosList.size());     	
    	rspMap.put("rspDesc", CommonUtil.getMvcMsg("successMsg"));
    	rspMap.put("goodsDetailList", goodsDetailList); 
    	rspMap.put("goodsDetailPhotosList", goodsDetailPhotosList); 
    	rspMap.put("goodsActivityList", goodsActivityList); 

    	
//    	rspMap.put("banners", banners);  

    	rspMap.put("title", "选择商品"); 
    	return new ModelAndView("goodsManageGoodDetail.ftl", rspMap);

    }
    
    
    @RequestMapping("/goodsManageGoodDetailUpdate")
    @ResponseBody
    public void goodsManageGoodDetailUpdate(@RequestBody String inputParam){
    	Map<String, String> paramsMap = StringUtil.params2Map(inputParam);
    	String goodsIdStr = paramsMap.get("goodsId");
    	Long goodsId = Long.parseLong(goodsIdStr);
    	String titleStr = paramsMap.get("title");
    	String contentStr = paramsMap.get("content");
    	String partitionIdStr = CommonUtil.getPartitionId(goodsIdStr);
    	Short partitionId = (short) Integer.parseInt(partitionIdStr);
    	
    	TdGdsDABLEACTIVITY tdGdsDABLEACTIVITY = new TdGdsDABLEACTIVITY();
    	tdGdsDABLEACTIVITY.setGoodsId(goodsId);
    	tdGdsDABLEACTIVITY.setAtyTitle(titleStr);
    	tdGdsDABLEACTIVITY.setAtyContent(contentStr);
    	tdGdsDABLEACTIVITY.setPartitionId(partitionId);
    	tdGdsDABLEACTIVITY.setUserId(goodsIdStr);

    	
    	Criteria example = new Criteria();
    	example.createConditon().andEqualTo("GOODS_ID", goodsId);
    	List<TdGdsDABLEACTIVITY> list = tdGdsDABLEACTIVITYDao.selectByExample(example);
    	if(list.size()==0){
        	tdGdsDABLEACTIVITYDao.insertSelective(tdGdsDABLEACTIVITY);
    	}else{
    		tdGdsDABLEACTIVITYDao.updateByExampleSelective(tdGdsDABLEACTIVITY, example);
    	}
    
    }
    
}
