package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysPWEBPROVINCE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysPWEBPROVINCEMapper
* @Description: SYS_P_WEB_PROVINCE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysPWEBPROVINCEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysPWEBPROVINCEMapper.countByExample
    * @Description: 根据查询条件，计算SYS_P_WEB_PROVINCE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysPWEBPROVINCEMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_P_WEB_PROVINCE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysPWEBPROVINCEMapper.insert
    * @Description: 插入一个SYS_P_WEB_PROVINCE
    * @param record SYS_P_WEB_PROVINCE的bean对象
    * @return int  插入个数
     */
    int insert(TdSysPWEBPROVINCE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysPWEBPROVINCEMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_P_WEB_PROVINCE
    * @param record 只含部分字段的SYS_P_WEB_PROVINCE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysPWEBPROVINCE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysPWEBPROVINCEMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_P_WEB_PROVINCE结果集
    * @param example 通用查询条件类
    * @return List<TdSysPWEBPROVINCE>SYS_P_WEB_PROVINCE结果集
     */
    List<TdSysPWEBPROVINCE> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysPWEBPROVINCEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_P_WEB_PROVINCE部分字段
    * @param record 要更新成为的TdSysPWEBPROVINCE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysPWEBPROVINCE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysPWEBPROVINCEMapper.updateByExample
    * @Description: 根据查询条件更新SYS_P_WEB_PROVINCE全表字段
    * @param record 要更新成为的TdSysPWEBPROVINCE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysPWEBPROVINCE record, @Param("example") Criteria criteria);
}