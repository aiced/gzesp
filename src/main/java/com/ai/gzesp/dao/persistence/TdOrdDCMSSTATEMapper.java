package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDCMSSTATE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDCMSSTATEMapper
* @Description: ORD_D_CMSSTATE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDCMSSTATEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDCMSSTATEMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_CMSSTATE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDCMSSTATEMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_CMSSTATE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDCMSSTATEMapper.insert
    * @Description: 插入一个ORD_D_CMSSTATE
    * @param record ORD_D_CMSSTATE的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDCMSSTATE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDCMSSTATEMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_CMSSTATE
    * @param record 只含部分字段的ORD_D_CMSSTATE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDCMSSTATE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDCMSSTATEMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_CMSSTATE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDCMSSTATE>ORD_D_CMSSTATE结果集
     */
    List<TdOrdDCMSSTATE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDCMSSTATEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_CMSSTATE部分字段
    * @param record 要更新成为的TdOrdDCMSSTATE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDCMSSTATE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDCMSSTATEMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_CMSSTATE全表字段
    * @param record 要更新成为的TdOrdDCMSSTATE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDCMSSTATE record, @Param("example") Criteria criteria);
}