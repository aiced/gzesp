package com.ai.gzesp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dto.NumberConResult;
import com.ai.gzesp.dto.SelectNumberQueryCon;
import com.ai.gzesp.service.SelectNumberService;
import com.ai.gzesp.service.WeShopService;

@Controller
@RequestMapping("/order")
public class SelectNumberController {

    @Autowired
    private SelectNumberService selectNumberService;
    
    @Autowired
    private WeShopService weShopService;
    
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
        
        //商品归属地市下拉框  
        List<Map<Object, Object>> citys = weShopService.getCitys();
        mav.addObject("citys", citys);
        
        //获取靓号规则下拉框
        List<Map<Object, Object>> rules = selectNumberService.getNumberRules();
        mav.addObject("rules", rules);
        
        //数据库分页获取号码列表，默认归属贵阳,预存0-10000，第一页,一页20个,
        List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(null, null, 0, 10000, 1, 20, null, null, null);
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
    public ModelAndView queryNumbersByAjax(@RequestBody SelectNumberQueryCon con){
        // 返回数据表格子页面
        ModelAndView mav = new ModelAndView("selectNumberSub.ftl");
        // 从数据库按分页查询，默认第一页,一页5个 注意参数转成了小写
        List<Map<Object, Object>> numbers = selectNumberService.queryNumberListByPage(con.getEparchy_code(),
                con.getNice_rule(), con.getNice_fee_start(), con.getNice_fee_end(), con.getPageNum(),
                con.getPageSize(), con.getKeyword(), con.getSort(), con.getSortCol());
        mav.addObject("numbers", numbers);

        return mav;
    }
    
    /**
     * 功能描述: 选择号码页面点击号码后，需要预占号码，变更号码状态<br>
     *
     * @param con
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    @RequestMapping("/updateNumberState")
    @ResponseBody
    public NumberConResult updateNumberState(@RequestBody NumberConResult con){
        // 号码预占
        String status = Constants.STATUS_FAILD;
        int i = selectNumberService.updateNumberState(con.getSerial_number()); //更新成功的记录数
        if(i > 0){
            status = Constants.STATUS_SUCCESS;
        }
        
        NumberConResult result = new NumberConResult();
        result.setSerial_number(con.getSerial_number());
        result.setStatus(status);
        return result;
    }
}
