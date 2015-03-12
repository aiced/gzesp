package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.dao.WeShopDao;

@Service
public class WeShopService {

    @Autowired
    private WeShopDao weShopDao;
    
    /**
     * 功能描述: 根据能人id查询能人的名字手机微信等信息<br>
     *
     * @param developerId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getDevloperInfo(String developerId){
        return weShopDao.getDevloperInfo(developerId);
    }
    
    /**
     * 功能描述: 获取 我的店铺 banners 图片地址和链接<br>
     * 因为数据库里取出来是下面这种格式 图片链接;图片地址
     * http://tech.qq.com/;http://img3.cache.netease.com/photo/0001/2015-03-12/AKH6LI1F57KT0001.jpg
     * 所以要分割一下 , 而且这里配置的是绝对url，页面里不用再拼接 ${imageRoot}
     *  
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<String, String>> getBanners(){
        List<Map<Object, Object>> rows = weShopDao.getBanners();
        List<Map<String, String>> banners = new ArrayList<Map<String, String>>();
        
        for (Map<Object, Object> row : rows) {
            String[] arrays = ((String)row.get("CONTENT")).split(";");
            Map<String, String> banner = new HashMap<String, String>();
            banner.put("banner_href", arrays[0]);
            banner.put("banner_url", arrays[1]);
            banners.add(banner);
        }
        
        return banners;
    }
}
