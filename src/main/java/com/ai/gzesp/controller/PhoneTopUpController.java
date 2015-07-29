/**
 * 
 */
package com.ai.gzesp.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDABLEACTIVITY;
import com.ai.gzesp.dao.beans.TdGdsDABLERCD;
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.service.TdGdsDABLERCDDao;
import com.ai.gzesp.dao.service.TdGdsDINFODao;
import com.ai.gzesp.dao.sql.GoodsSql;
import com.ai.gzesp.dao.sql.PhoneTopUpSql;
import com.ai.gzesp.service.WeShopService;

/**
 * @author xinjunwang
 *
 */
@Controller
@RequestMapping("/TopUp")
public class PhoneTopUpController {

    @Autowired
    private WeShopService weShopService;
    
    @Resource 
    TdGdsDINFODao tdGdsDinfoDao;
    
    @Resource 
    PhoneTopUpSql phoneTopUpSql;   
    

    @RequestMapping("/phoneTopUp/{user_id}")
    public ModelAndView phoneTopUp(@PathVariable("user_id") String user_id){
//    	Criteria example = new Criteria();
//    	example.createConditon().andEqualTo("CTLG_CODE", 17);
//    	List<TdGdsDINFO> list = tdGdsDinfoDao.selectByExample(example);
    	List<Map<String, Object>> topUpList = phoneTopUpSql.GetTopUpList();
    	Map<String, Object> rspMap = new HashMap<String, Object>(); 
    	rspMap.put("topUpList", topUpList);  
    	rspMap.put("title", "手机充值"); 
    	rspMap.put("user_id", user_id); 
        return new ModelAndView("phoneTopUp.ftl", rspMap);
    }
}
