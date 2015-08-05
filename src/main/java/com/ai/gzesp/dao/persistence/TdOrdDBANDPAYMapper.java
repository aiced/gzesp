package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBANDPAY;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDBANDPAYMapper
* @Description: ORD_D_BAND_PAY表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDBANDPAYMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDBANDPAYMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_BAND_PAY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_BAND_PAY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_BAND_PAY
    * @param orderId orderId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long orderId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDBANDPAYMapper.insert
    * @Description: 插入一个ORD_D_BAND_PAY
    * @param record ORD_D_BAND_PAY的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDBANDPAY record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_BAND_PAY
    * @param record 只含部分字段的ORD_D_BAND_PAY的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDBANDPAY record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDBANDPAYMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_BAND_PAY结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDBANDPAY>ORD_D_BAND_PAY结果集
     */
    List<TdOrdDBANDPAY> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_BAND_PAY
    * @param orderId orderId
    * @return TdOrdDBANDPAY bean对象
     */
    TdOrdDBANDPAY selectByPrimaryKey(Long orderId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_BAND_PAY部分字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDBANDPAY record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_BAND_PAY全表字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDBANDPAY record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_BAND_PAY部分字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDBANDPAY record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDBANDPAYMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_BAND_PAY全部字段
    * @param record 要更新成为的TdOrdDBANDPAY对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDBANDPAY record);
}