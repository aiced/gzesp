package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdCmsPGOODSRULE;
import com.ai.gzesp.dao.beans.TdCmsPGOODSRULEKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdCmsPGOODSRULEMapper
* @Description: CMS_P_GOODS_RULE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdCmsPGOODSRULEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.countByExample
    * @Description: 根据查询条件，计算CMS_P_GOODS_RULE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.deleteByExample
    * @Description: 根据查询条件，删除CMS_P_GOODS_RULE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除CMS_P_GOODS_RULE
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdCmsPGOODSRULEKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.insert
    * @Description: 插入一个CMS_P_GOODS_RULE
    * @param record CMS_P_GOODS_RULE的bean对象
    * @return int  插入个数
     */
    int insert(TdCmsPGOODSRULE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.insertSelective
    * @Description: 插入一个只有部分字段的CMS_P_GOODS_RULE
    * @param record 只含部分字段的CMS_P_GOODS_RULE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdCmsPGOODSRULE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.selectByExample
    * @Description: 根据查询条件类，返回CMS_P_GOODS_RULE结果集
    * @param example 通用查询条件类
    * @return List<TdCmsPGOODSRULE>CMS_P_GOODS_RULE结果集
     */
    List<TdCmsPGOODSRULE> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回CMS_P_GOODS_RULE
    * @param key key
    * @return TdCmsPGOODSRULE bean对象
     */
    TdCmsPGOODSRULE selectByPrimaryKey(TdCmsPGOODSRULEKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新CMS_P_GOODS_RULE部分字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdCmsPGOODSRULE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.updateByExample
    * @Description: 根据查询条件更新CMS_P_GOODS_RULE全表字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdCmsPGOODSRULE record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新CMS_P_GOODS_RULE部分字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdCmsPGOODSRULE record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdCmsPGOODSRULEMapper.updateByPrimaryKey
    * @Description: 根据主键更新CMS_P_GOODS_RULE全部字段
    * @param record 要更新成为的TdCmsPGOODSRULE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdCmsPGOODSRULE record);
}