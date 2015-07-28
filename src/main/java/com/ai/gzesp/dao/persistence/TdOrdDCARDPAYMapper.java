package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDCARDPAY;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDCARDPAYMapper
* @Description: ORD_D_CARD_PAY表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDCARDPAYMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDCARDPAYMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_CARD_PAY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDCARDPAYMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_CARD_PAY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDCARDPAYMapper.insert
    * @Description: 插入一个ORD_D_CARD_PAY
    * @param record ORD_D_CARD_PAY的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDCARDPAY record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDCARDPAYMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_CARD_PAY
    * @param record 只含部分字段的ORD_D_CARD_PAY的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDCARDPAY record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDCARDPAYMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_CARD_PAY结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDCARDPAY>ORD_D_CARD_PAY结果集
     */
    List<TdOrdDCARDPAY> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDCARDPAYMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_CARD_PAY部分字段
    * @param record 要更新成为的TdOrdDCARDPAY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDCARDPAY record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDCARDPAYMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_CARD_PAY全表字段
    * @param record 要更新成为的TdOrdDCARDPAY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDCARDPAY record, @Param("example") Criteria criteria);
}