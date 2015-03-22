package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPROD;
import com.ai.gzesp.dao.beans.TdOrdDPRODKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDPRODMapper
* @Description: ORD_D_PROD表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDPRODMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDPRODMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_PROD个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDPRODMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PROD
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDPRODMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_PROD
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdOrdDPRODKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDPRODMapper.insert
    * @Description: 插入一个ORD_D_PROD
    * @param record ORD_D_PROD的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDPROD record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDPRODMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PROD
    * @param record 只含部分字段的ORD_D_PROD的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDPROD record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDPRODMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PROD结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPROD>ORD_D_PROD结果集
     */
    List<TdOrdDPROD> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDPRODMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_PROD
    * @param key key
    * @return TdOrdDPROD bean对象
     */
    TdOrdDPROD selectByPrimaryKey(TdOrdDPRODKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPRODMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PROD部分字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDPROD record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDPRODMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_PROD全表字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDPROD record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPRODMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_PROD部分字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDPROD record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDPRODMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_PROD全部字段
    * @param record 要更新成为的TdOrdDPROD对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDPROD record);
}