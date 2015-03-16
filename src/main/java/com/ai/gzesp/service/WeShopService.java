package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dao.WeShopDao;

@Service
public class WeShopService {

    @Autowired
    private WeShopDao weShopDao;
    
    /**
     * 功能描述: 根据能人id查询能人的名字手机微信等信息<br>
     *
     * @param user_id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Map<Object, Object> getDevloperInfo(String user_id){
        return weShopDao.getDevloperInfo(user_id);
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
    

    /**
     * 功能描述: 查询店长推荐的商品信息<br>
     *
     * @param developerId
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getDztj(String user_id){
        return weShopDao.getDztj(user_id);
    }
    
    /**
     * 功能描述: 查询热销合约的商品信息<br>
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getRxhy(){
        return weShopDao.getRxhy();
    }
    
    /**
     * 功能描述: 查询热销网卡的商品信息<br>
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getRxwk(){
        return weShopDao.getRxwk();
    }
    
    /**
     * 功能描述: 查询商品的图片集<br>
     *
     * @param goods_id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getGoodPhotos(String goods_id){
        return weShopDao.getGoodPhotos(goods_id);
    }    
    
    /**
     * 功能描述: 根据商品id和能人id 查询商品的图片link 名称 价格 自定义活动<br>
     *
     * @param goods_id
     * @param user_id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Map<Object, Object> getGoodDetail(String goods_id, String user_id){
        return weShopDao.getGoodDetail(goods_id, user_id);
    }
    
    /**
     * 功能描述: 获取城市下拉列表<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getCitys(){
        return weShopDao.getCitys();
    }
    

    /**
     * 功能描述: 通过商品关联物品获取物品属性：版本 颜色 内存 优惠活动<br>
     *
     * @param goods_id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Map<Object, List<Object>> getAttrs(String goods_id){
        List<Map<Object, Object>> rows = weShopDao.getAttrs(goods_id);
        //attrs是个map，map里含n个list，每个list都是一组属性，比如各种颜色是一组list，各种内存容量是一组list
        Map<Object, List<Object>> attrs = new HashMap<Object, List<Object>>();
        
        for(Map<Object, Object> row: rows){
            //如果map里已经存在该属性的list，就直接list里面add一行
            if(attrs.containsKey(row.get(Constants.COL_ATTR_CODE))){
                //韦文泱确认 属性描述取 ATTR_VAL_CODE字段，ATTR_VAL_NAME字段长度不够
                attrs.get(row.get(Constants.COL_ATTR_CODE)).add(row.get(Constants.COL_ATTR_VAL_CODE));
            }
            //如果map里不存在该属性的list,先new一个list
            else{
                List<Object> attr = new ArrayList<Object>();
                attr.add(row.get(Constants.COL_ATTR_VAL_CODE));
                attrs.put(row.get(Constants.COL_ATTR_CODE), attr);
            }
        }
        
        return attrs;
    }
    
    /**
     * 功能描述: 根据商品类型，页数，每页数量查询商品列表<br>
     *
     * @param ctlgArray
     * @param pageNum
     * @param pageSize
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> queryPlanListByPage(String[] ctlgArray, int pageNum, int pageSize){
        return weShopDao.queryPlanListByPage(ctlgArray, pageNum, pageSize);
    }
}
