package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPAY;
import com.ai.gzesp.dao.beans.TdOrdDPAYKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDPAYMapper
* @Description: ORD_D_PAY表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDPAYMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDPAYMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_PAY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDPAYMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PAY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDPAYMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_PAY
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdOrdDPAYKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDPAYMapper.insert
    * @Description: 插入一个ORD_D_PAY
    * @param record ORD_D_PAY的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDPAY record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDPAYMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PAY
    * @param record 只含部分字段的ORD_D_PAY的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDPAY record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDPAYMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PAY结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPAY>ORD_D_PAY结果集
     */
    List<TdOrdDPAY> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDPAYMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_PAY
    * @param key key
    * @return TdOrdDPAY bean对象
     */
    TdOrdDPAY selectByPrimaryKey(TdOrdDPAYKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPAYMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PAY部分字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDPAY record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDPAYMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_PAY全表字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDPAY record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPAYMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_PAY部分字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDPAY record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDPAYMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_PAY全部字段
    * @param record 要更新成为的TdOrdDPAY对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDPAY record);
}