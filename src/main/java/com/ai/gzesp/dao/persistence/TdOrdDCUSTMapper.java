package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDCUST;
import com.ai.gzesp.dao.beans.TdOrdDCUSTKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDCUSTMapper
* @Description: ORD_D_CUST表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDCUSTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDCUSTMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_CUST个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDCUSTMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_CUST
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDCUSTMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_CUST
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdOrdDCUSTKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDCUSTMapper.insert
    * @Description: 插入一个ORD_D_CUST
    * @param record ORD_D_CUST的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDCUST record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDCUSTMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_CUST
    * @param record 只含部分字段的ORD_D_CUST的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDCUST record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDCUSTMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_CUST结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDCUST>ORD_D_CUST结果集
     */
    List<TdOrdDCUST> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDCUSTMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_CUST
    * @param key key
    * @return TdOrdDCUST bean对象
     */
    TdOrdDCUST selectByPrimaryKey(TdOrdDCUSTKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDCUSTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_CUST部分字段
    * @param record 要更新成为的TdOrdDCUST对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDCUST record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDCUSTMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_CUST全表字段
    * @param record 要更新成为的TdOrdDCUST对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDCUST record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDCUSTMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_CUST部分字段
    * @param record 要更新成为的TdOrdDCUST对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDCUST record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDCUSTMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_CUST全部字段
    * @param record 要更新成为的TdOrdDCUST对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDCUST record);
}