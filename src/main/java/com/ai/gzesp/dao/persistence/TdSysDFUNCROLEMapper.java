package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDFUNCROLE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysDFUNCROLEMapper
* @Description: SYS_D_FUNCROLE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysDFUNCROLEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysDFUNCROLEMapper.countByExample
    * @Description: 根据查询条件，计算SYS_D_FUNCROLE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysDFUNCROLEMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_FUNCROLE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysDFUNCROLEMapper.insert
    * @Description: 插入一个SYS_D_FUNCROLE
    * @param record SYS_D_FUNCROLE的bean对象
    * @return int  插入个数
     */
    int insert(TdSysDFUNCROLE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysDFUNCROLEMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_FUNCROLE
    * @param record 只含部分字段的SYS_D_FUNCROLE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysDFUNCROLE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysDFUNCROLEMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_FUNCROLE结果集
    * @param example 通用查询条件类
    * @return List<TdSysDFUNCROLE>SYS_D_FUNCROLE结果集
     */
    List<TdSysDFUNCROLE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysDFUNCROLEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_FUNCROLE部分字段
    * @param record 要更新成为的TdSysDFUNCROLE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysDFUNCROLE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysDFUNCROLEMapper.updateByExample
    * @Description: 根据查询条件更新SYS_D_FUNCROLE全表字段
    * @param record 要更新成为的TdSysDFUNCROLE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysDFUNCROLE record, @Param("example") Criteria criteria);
}