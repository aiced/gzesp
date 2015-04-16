package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDREFUND;
import com.ai.gzesp.dao.beans.TdOrdDREFUNDKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDREFUNDMapper
* @Description: ORD_D_REFUND表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDREFUNDMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDREFUNDMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_REFUND个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_REFUND
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_REFUND
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdOrdDREFUNDKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDREFUNDMapper.insert
    * @Description: 插入一个ORD_D_REFUND
    * @param record ORD_D_REFUND的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDREFUND record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_REFUND
    * @param record 只含部分字段的ORD_D_REFUND的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDREFUND record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDREFUNDMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_REFUND结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDREFUND>ORD_D_REFUND结果集
     */
    List<TdOrdDREFUND> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_REFUND
    * @param key key
    * @return TdOrdDREFUND bean对象
     */
    TdOrdDREFUND selectByPrimaryKey(TdOrdDREFUNDKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_REFUND部分字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDREFUND record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_REFUND全表字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDREFUND record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_REFUND部分字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDREFUND record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDREFUNDMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_REFUND全部字段
    * @param record 要更新成为的TdOrdDREFUND对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDREFUND record);
}