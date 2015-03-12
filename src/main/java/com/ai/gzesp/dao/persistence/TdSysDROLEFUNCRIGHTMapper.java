package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDROLEFUNCRIGHT;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysDROLEFUNCRIGHTMapper
* @Description: SYS_D_ROLE_FUNCRIGHT表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysDROLEFUNCRIGHTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysDROLEFUNCRIGHTMapper.countByExample
    * @Description: 根据查询条件，计算SYS_D_ROLE_FUNCRIGHT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysDROLEFUNCRIGHTMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_ROLE_FUNCRIGHT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysDROLEFUNCRIGHTMapper.insert
    * @Description: 插入一个SYS_D_ROLE_FUNCRIGHT
    * @param record SYS_D_ROLE_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    int insert(TdSysDROLEFUNCRIGHT record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysDROLEFUNCRIGHTMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_ROLE_FUNCRIGHT
    * @param record 只含部分字段的SYS_D_ROLE_FUNCRIGHT的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysDROLEFUNCRIGHT record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysDROLEFUNCRIGHTMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_ROLE_FUNCRIGHT结果集
    * @param example 通用查询条件类
    * @return List<TdSysDROLEFUNCRIGHT>SYS_D_ROLE_FUNCRIGHT结果集
     */
    List<TdSysDROLEFUNCRIGHT> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysDROLEFUNCRIGHTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_ROLE_FUNCRIGHT部分字段
    * @param record 要更新成为的TdSysDROLEFUNCRIGHT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysDROLEFUNCRIGHT record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysDROLEFUNCRIGHTMapper.updateByExample
    * @Description: 根据查询条件更新SYS_D_ROLE_FUNCRIGHT全表字段
    * @param record 要更新成为的TdSysDROLEFUNCRIGHT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysDROLEFUNCRIGHT record, @Param("example") Criteria criteria);
}