package com.ai.gzesp.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.gzesp.common.Constants;
import com.ai.gzesp.dao.WeShopDao;
import com.ai.gzesp.dto.GoodsDetailResult;
import com.ai.gzesp.unionpay.TradeType;

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
    	//如果在 wap通用参数表 SYS_D_ESPPARAM里配置了需要优先展示的热销产品，则不用按销量排名取前4的产品
    	List<Map<Object, Object>> rxhy = weShopDao.getRxhySpecial();
    	if(CollectionUtils.isNotEmpty(rxhy)){
    		//如果配置参数表里小于4条，那还要去销量里面补足4个产品，页面共展示4个产品
    		if (rxhy.size() < 4){
    			String[] goodsArray = new String[rxhy.size()];
    			for(int i = 0; i < rxhy.size(); i++){
    				goodsArray[i] = (String)rxhy.get(i).get("GOODS_ID");
    			}
    			List<Map<Object, Object>> rxhy2 = weShopDao.getRxhyRest(goodsArray, 4-rxhy.size());
    			rxhy.addAll(rxhy2);//加到一起
    		}
    		return rxhy;
    	}
    	else{
    		return weShopDao.getRxhyRest(null, 4); //如果rxhy空，则取销量前4商品
    	}
    }
    /**
     * 功能描述: 查询热销套餐的商品信息<br>
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getRxtc(){
        //return weShopDao.getRxtc();
    	//如果在 wap通用参数表 SYS_D_ESPPARAM里配置了需要优先展示的热销产品，则不用按销量排名取前4的产品
    	List<Map<Object, Object>> rxtc = weShopDao.getRxtcSpecial();
    	if(CollectionUtils.isNotEmpty(rxtc)){
    		//如果配置参数表里小于4条，那还要去销量里面补足4个产品，页面共展示4个产品
    		if (rxtc.size() < 4){
    			String[] goodsArray = new String[rxtc.size()];
    			for(int i = 0; i < rxtc.size(); i++){
    				goodsArray[i] = (String)rxtc.get(i).get("GOODS_ID");
    			}
    			List<Map<Object, Object>> rxtc2 = weShopDao.getRxtcRest(goodsArray, 4-rxtc.size());
    			rxtc.addAll(rxtc2);//加到一起
    		}
    		return rxtc;
    	}
    	else{
    		return weShopDao.getRxtcRest(null, 4); //如果rxtc空，则取销量前4商品
    	}
    }    
    
    
    /**
     * 功能描述: 查询热销网卡的商品信息<br>
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> getRxwk(){
        //return weShopDao.getRxwk();
    	//如果在 wap通用参数表 SYS_D_ESPPARAM里配置了需要优先展示的热销产品，则不用按销量排名取前4的产品
    	List<Map<Object, Object>> rxwk = weShopDao.getRxwkSpecial();
    	if(CollectionUtils.isNotEmpty(rxwk)){
    		//如果配置参数表里小于4条，那还要去销量里面补足4个产品，页面共展示4个产品
    		if (rxwk.size() < 4){
    			String[] goodsArray = new String[rxwk.size()];
    			for(int i = 0; i < rxwk.size(); i++){
    				goodsArray[i] = (String)rxwk.get(i).get("GOODS_ID");
    			}
    			List<Map<Object, Object>> rxwk2 = weShopDao.getRxwkRest(goodsArray, 4-rxwk.size());
    			rxwk.addAll(rxwk2);//加到一起
    		}
    		return rxwk;
    	}
    	else{
    		return weShopDao.getRxwkRest(null, 4); //如果rxwk空，则取销量前4商品
    	}
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
    public GoodsDetailResult getGoodDetail(String goods_id, String user_id){
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
    public Map<Object, List<Map<Object, Object>>> getAttrs(String goods_id){
        List<Map<Object, Object>> rows = weShopDao.getAttrs(goods_id);
        //attrs是个map，map里含n个list，每个list都是一组属性，比如各种颜色是一组list，各种内存容量是一组list
        Map<Object, List<Map<Object, Object>>> attrs = new HashMap<Object, List<Map<Object, Object>>>();
        
        for(Map<Object, Object> row: rows){
            //如果map里已经存在该属性的list，就直接list里面add一行
            if(attrs.containsKey(row.get(Constants.COL_ATTR_CODE))){
                //属性描述取values字段， ATTR_VAL_CODE字段，ATTR_VAL_NAME字段，最终订单里需要这3个字段信息
                attrs.get(row.get(Constants.COL_ATTR_CODE)).add(row);
            }
            //如果map里不存在该属性的list,先new一个list
            else{
                List<Map<Object, Object>> attr = new ArrayList<Map<Object, Object>>();
                attr.add(row);
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
     * @param keyword
     * @param sort
     * @param sortCol
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public List<Map<Object, Object>> queryGoodListByPage(String[] ctlgArray, int pageNum, int pageSize, String keyword, String sort, String sortCol){
        return weShopDao.queryGoodListByPage(ctlgArray, pageNum, pageSize, keyword, sort, sortCol);
    }
    
    //edit_by_wenh_2015_4_18
    public int insertVisitLog(@Param("user_id") String user_id)
    {
    	String log_id=getVisitLogNo();
    	String store_id=user_id;
    	
        Calendar cal = Calendar.getInstance();
        int month = cal.get(Calendar.MONTH) + 1;
        String partition_id=String.valueOf(month);
        
    	return weShopDao.insertVisitLog(log_id, partition_id, store_id, user_id);
    }
    
    
    /**
     * 记录页面访问日志
     * @return
     */
    public String getVisitLogNo(){
        StringBuffer sb = new StringBuffer(16);
        sb.append(System.currentTimeMillis()); //13位
        Random random = new Random();
        sb.append(random.nextInt(4)); //加1位随机整数
        return sb.toString();
    }
    
    /**
     * 根据商品id查询库存数量
     * @param goods_id
     * @return
     */
    public Map<Object, Object> getStoreNum(String goods_id){
        return weShopDao.getStoreNum(goods_id);
    }
    
    /**
     * 根据商品id获取商品类目
     *
     * @param goods_id
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public Map<String, String> getCtlgCode(String goods_id){
        return weShopDao.getCtlgCode(goods_id);
    } 
    
    /**
     * 根据商品id数组查询出商品信息
     * @param goods_list
     * @return
     */
    public List<Map<Object, Object>> queryGoodListById(String[] goods_list){
    	return weShopDao.queryGoodListById(goods_list);
    }
    
}
