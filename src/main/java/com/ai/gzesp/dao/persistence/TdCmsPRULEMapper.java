package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdCmsPRULE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdCmsPRULEMapper
* @Description: CMS_P_RULE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdCmsPRULEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdCmsPRULEMapper.countByExample
    * @Description: 根据查询条件，计算CMS_P_RULE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdCmsPRULEMapper.deleteByExample
    * @Description: 根据查询条件，删除CMS_P_RULE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdCmsPRULEMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除CMS_P_RULE
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdCmsPRULEMapper.insert
    * @Description: 插入一个CMS_P_RULE
    * @param record CMS_P_RULE的bean对象
    * @return int  插入个数
     */
    int insert(TdCmsPRULE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdCmsPRULEMapper.insertSelective
    * @Description: 插入一个只有部分字段的CMS_P_RULE
    * @param record 只含部分字段的CMS_P_RULE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdCmsPRULE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdCmsPRULEMapper.selectByExample
    * @Description: 根据查询条件类，返回CMS_P_RULE结果集
    * @param example 通用查询条件类
    * @return List<TdCmsPRULE>CMS_P_RULE结果集
     */
    List<TdCmsPRULE> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdCmsPRULEMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回CMS_P_RULE
    * @param id id
    * @return TdCmsPRULE bean对象
     */
    TdCmsPRULE selectByPrimaryKey(Long id);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdCmsPRULEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新CMS_P_RULE部分字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdCmsPRULE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdCmsPRULEMapper.updateByExample
    * @Description: 根据查询条件更新CMS_P_RULE全表字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdCmsPRULE record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdCmsPRULEMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新CMS_P_RULE部分字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdCmsPRULE record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdCmsPRULEMapper.updateByPrimaryKey
    * @Description: 根据主键更新CMS_P_RULE全部字段
    * @param record 要更新成为的TdCmsPRULE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdCmsPRULE record);
}