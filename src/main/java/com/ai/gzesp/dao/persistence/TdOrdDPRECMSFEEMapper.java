package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPRECMSFEE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDPRECMSFEEMapper
* @Description: ORD_D_PRECMSFEE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDPRECMSFEEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDPRECMSFEEMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_PRECMSFEE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDPRECMSFEEMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_PRECMSFEE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDPRECMSFEEMapper.insert
    * @Description: 插入一个ORD_D_PRECMSFEE
    * @param record ORD_D_PRECMSFEE的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDPRECMSFEE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDPRECMSFEEMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_PRECMSFEE
    * @param record 只含部分字段的ORD_D_PRECMSFEE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDPRECMSFEE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDPRECMSFEEMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_PRECMSFEE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPRECMSFEE>ORD_D_PRECMSFEE结果集
     */
    List<TdOrdDPRECMSFEE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPRECMSFEEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_PRECMSFEE部分字段
    * @param record 要更新成为的TdOrdDPRECMSFEE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDPRECMSFEE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDPRECMSFEEMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_PRECMSFEE全表字段
    * @param record 要更新成为的TdOrdDPRECMSFEE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDPRECMSFEE record, @Param("example") Criteria criteria);
}