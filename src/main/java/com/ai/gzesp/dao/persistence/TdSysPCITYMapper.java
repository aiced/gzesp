package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPCITY;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysPCITYMapper
* @Description: SYS_P_CITY表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysPCITYMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysPCITYMapper.countByExample
    * @Description: 根据查询条件，计算SYS_P_CITY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysPCITYMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_CITY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysPCITYMapper.insert
    * @Description: 插入一个SYS_P_CITY
    * @param record SYS_P_CITY的bean对象
    * @return int  插入个数
     */
    int insert(TdSysPCITY record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysPCITYMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_CITY
    * @param record 只含部分字段的SYS_P_CITY的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysPCITY record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysPCITYMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_CITY结果集
    * @param example 通用查询条件类
    * @return List<TdSysPCITY>SYS_P_CITY结果集
     */
    List<TdSysPCITY> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysPCITYMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_CITY部分字段
    * @param record 要更新成为的TdSysPCITY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysPCITY record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysPCITYMapper.updateByExample
    * @Description: 根据查询条件更新SYS_P_CITY全表字段
    * @param record 要更新成为的TdSysPCITY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysPCITY record, @Param("example") Criteria criteria);
}