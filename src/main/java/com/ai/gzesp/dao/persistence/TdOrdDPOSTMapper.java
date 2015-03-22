package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDPOST;
import com.ai.gzesp.dao.beans.TdOrdDPOSTKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDPOSTMapper
* @Description: ORD_D_POST表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDPOSTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDPOSTMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_POST个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDPOSTMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_POST
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDPOSTMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_POST
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdOrdDPOSTKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDPOSTMapper.insert
    * @Description: 插入一个ORD_D_POST
    * @param record ORD_D_POST的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDPOST record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDPOSTMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_POST
    * @param record 只含部分字段的ORD_D_POST的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDPOST record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDPOSTMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_POST结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDPOST>ORD_D_POST结果集
     */
    List<TdOrdDPOST> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDPOSTMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_POST
    * @param key key
    * @return TdOrdDPOST bean对象
     */
    TdOrdDPOST selectByPrimaryKey(TdOrdDPOSTKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPOSTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_POST部分字段
    * @param record 要更新成为的TdOrdDPOST对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDPOST record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDPOSTMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_POST全表字段
    * @param record 要更新成为的TdOrdDPOST对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDPOST record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDPOSTMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_POST部分字段
    * @param record 要更新成为的TdOrdDPOST对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDPOST record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDPOSTMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_POST全部字段
    * @param record 要更新成为的TdOrdDPOST对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDPOST record);
}