package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPWEBCITY;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysPWEBCITYMapper
* @Description: SYS_P_WEB_CITY表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysPWEBCITYMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysPWEBCITYMapper.countByExample
    * @Description: 根据查询条件，计算SYS_P_WEB_CITY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysPWEBCITYMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_WEB_CITY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysPWEBCITYMapper.insert
    * @Description: 插入一个SYS_P_WEB_CITY
    * @param record SYS_P_WEB_CITY的bean对象
    * @return int  插入个数
     */
    int insert(TdSysPWEBCITY record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysPWEBCITYMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_WEB_CITY
    * @param record 只含部分字段的SYS_P_WEB_CITY的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysPWEBCITY record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysPWEBCITYMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_WEB_CITY结果集
    * @param example 通用查询条件类
    * @return List<TdSysPWEBCITY>SYS_P_WEB_CITY结果集
     */
    List<TdSysPWEBCITY> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysPWEBCITYMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_WEB_CITY部分字段
    * @param record 要更新成为的TdSysPWEBCITY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysPWEBCITY record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysPWEBCITYMapper.updateByExample
    * @Description: 根据查询条件更新SYS_P_WEB_CITY全表字段
    * @param record 要更新成为的TdSysPWEBCITY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysPWEBCITY record, @Param("example") Criteria criteria);
}