package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPCOUNTY;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysPCOUNTYMapper
* @Description: SYS_P_COUNTY表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysPCOUNTYMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysPCOUNTYMapper.countByExample
    * @Description: 根据查询条件，计算SYS_P_COUNTY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysPCOUNTYMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_COUNTY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysPCOUNTYMapper.insert
    * @Description: 插入一个SYS_P_COUNTY
    * @param record SYS_P_COUNTY的bean对象
    * @return int  插入个数
     */
    int insert(TdSysPCOUNTY record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysPCOUNTYMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_COUNTY
    * @param record 只含部分字段的SYS_P_COUNTY的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysPCOUNTY record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysPCOUNTYMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_COUNTY结果集
    * @param example 通用查询条件类
    * @return List<TdSysPCOUNTY>SYS_P_COUNTY结果集
     */
    List<TdSysPCOUNTY> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysPCOUNTYMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_COUNTY部分字段
    * @param record 要更新成为的TdSysPCOUNTY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysPCOUNTY record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysPCOUNTYMapper.updateByExample
    * @Description: 根据查询条件更新SYS_P_COUNTY全表字段
    * @param record 要更新成为的TdSysPCOUNTY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysPCOUNTY record, @Param("example") Criteria criteria);
}