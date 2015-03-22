package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdDBASE;
import com.ai.gzesp.dao.beans.TdOrdDBASEKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdDBASEMapper
* @Description: ORD_D_BASE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdDBASEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdDBASEMapper.countByExample
    * @Description: 根据查询条件，计算ORD_D_BASE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdDBASEMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_D_BASE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdDBASEMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_D_BASE
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdOrdDBASEKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdDBASEMapper.insert
    * @Description: 插入一个ORD_D_BASE
    * @param record ORD_D_BASE的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdDBASE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdDBASEMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_D_BASE
    * @param record 只含部分字段的ORD_D_BASE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdDBASE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdDBASEMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_D_BASE结果集
    * @param example 通用查询条件类
    * @return List<TdOrdDBASE>ORD_D_BASE结果集
     */
    List<TdOrdDBASE> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdDBASEMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_D_BASE
    * @param key key
    * @return TdOrdDBASE bean对象
     */
    TdOrdDBASE selectByPrimaryKey(TdOrdDBASEKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdDBASEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_D_BASE部分字段
    * @param record 要更新成为的TdOrdDBASE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdDBASE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdDBASEMapper.updateByExample
    * @Description: 根据查询条件更新ORD_D_BASE全表字段
    * @param record 要更新成为的TdOrdDBASE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdDBASE record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdDBASEMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_D_BASE部分字段
    * @param record 要更新成为的TdOrdDBASE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdDBASE record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdDBASEMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_D_BASE全部字段
    * @param record 要更新成为的TdOrdDBASE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdDBASE record);
}