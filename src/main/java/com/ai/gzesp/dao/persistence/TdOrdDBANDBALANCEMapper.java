package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBANDBALANCE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDBANDBALANCEMapper
* @Description: ORD_D_BANDBALANCE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDBANDBALANCEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_BANDBALANCE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_BANDBALANCE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_BANDBALANCE
    * @param logId logId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(String logId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.insert
    * @Description: 插入一个ORD_D_BANDBALANCE
    * @param record ORD_D_BANDBALANCE的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDBANDBALANCE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_BANDBALANCE
    * @param record 只含部分字段的ORD_D_BANDBALANCE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDBANDBALANCE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_BANDBALANCE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDBANDBALANCE>ORD_D_BANDBALANCE结果集
     */
    List<TdOrdDBANDBALANCE> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_BANDBALANCE
    * @param logId logId
    * @return TdOrdDBANDBALANCE bean对象
     */
    TdOrdDBANDBALANCE selectByPrimaryKey(String logId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_BANDBALANCE部分字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDBANDBALANCE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_BANDBALANCE全表字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDBANDBALANCE record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_BANDBALANCE部分字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDBANDBALANCE record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDBANDBALANCEMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_BANDBALANCE全部字段
    * @param record 要更新成为的TdOrdDBANDBALANCE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDBANDBALANCE record);
}