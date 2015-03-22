package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPAYLOG;
import com.ai.gzesp.dao.beans.TdOrdDPAYLOGKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDPAYLOGMapper
* @Description: ORD_D_PAYLOG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDPAYLOGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDPAYLOGMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_PAYLOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PAYLOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_PAYLOG
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdOrdDPAYLOGKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDPAYLOGMapper.insert
    * @Description: 插入一个ORD_D_PAYLOG
    * @param record ORD_D_PAYLOG的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDPAYLOG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PAYLOG
    * @param record 只含部分字段的ORD_D_PAYLOG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDPAYLOG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDPAYLOGMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PAYLOG结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPAYLOG>ORD_D_PAYLOG结果集
     */
    List<TdOrdDPAYLOG> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_PAYLOG
    * @param key key
    * @return TdOrdDPAYLOG bean对象
     */
    TdOrdDPAYLOG selectByPrimaryKey(TdOrdDPAYLOGKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PAYLOG部分字段
    * @param record 要更新成为的TdOrdDPAYLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDPAYLOG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_PAYLOG全表字段
    * @param record 要更新成为的TdOrdDPAYLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDPAYLOG record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_PAYLOG部分字段
    * @param record 要更新成为的TdOrdDPAYLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDPAYLOG record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDPAYLOGMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_PAYLOG全部字段
    * @param record 要更新成为的TdOrdDPAYLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDPAYLOG record);
}