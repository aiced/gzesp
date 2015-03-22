package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdCmsDMDYLOG;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdCmsDMDYLOGMapper
* @Description: CMS_D_MDY_LOG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdCmsDMDYLOGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdCmsDMDYLOGMapper.countByExample
    * @Description: 根据查询条件，计算CMS_D_MDY_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdCmsDMDYLOGMapper.deleteByExample
    * @Description: 根据查询条件，删除CMS_D_MDY_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdCmsDMDYLOGMapper.insert
    * @Description: 插入一个CMS_D_MDY_LOG
    * @param record CMS_D_MDY_LOG的bean对象
    * @return int  插入个数
     */
    int insert(TdCmsDMDYLOG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdCmsDMDYLOGMapper.insertSelective
    * @Description: 插入一个只有部分字段的CMS_D_MDY_LOG
    * @param record 只含部分字段的CMS_D_MDY_LOG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdCmsDMDYLOG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdCmsDMDYLOGMapper.selectByExample
    * @Description: 根据查询条件类，返回CMS_D_MDY_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdCmsDMDYLOG>CMS_D_MDY_LOG结果集
     */
    List<TdCmsDMDYLOG> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdCmsDMDYLOGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新CMS_D_MDY_LOG部分字段
    * @param record 要更新成为的TdCmsDMDYLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdCmsDMDYLOG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdCmsDMDYLOGMapper.updateByExample
    * @Description: 根据查询条件更新CMS_D_MDY_LOG全表字段
    * @param record 要更新成为的TdCmsDMDYLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdCmsDMDYLOG record, @Param("example") Criteria criteria);
}