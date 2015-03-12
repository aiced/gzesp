package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdTFFAGENTSTAFFINFO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdTFFAGENTSTAFFINFOMapper
* @Description: TF_F_AGENT_STAFF_INFO表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdTFFAGENTSTAFFINFOMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdTFFAGENTSTAFFINFOMapper.countByExample
    * @Description: 根据查询条件，计算TF_F_AGENT_STAFF_INFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdTFFAGENTSTAFFINFOMapper.deleteByExample
    * @Description: 根据查询条件，删除TF_F_AGENT_STAFF_INFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdTFFAGENTSTAFFINFOMapper.insert
    * @Description: 插入一个TF_F_AGENT_STAFF_INFO
    * @param record TF_F_AGENT_STAFF_INFO的bean对象
    * @return int  插入个数
     */
    int insert(TdTFFAGENTSTAFFINFO record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdTFFAGENTSTAFFINFOMapper.insertSelective
    * @Description: 插入一个只有部分字段的TF_F_AGENT_STAFF_INFO
    * @param record 只含部分字段的TF_F_AGENT_STAFF_INFO的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdTFFAGENTSTAFFINFO record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdTFFAGENTSTAFFINFOMapper.selectByExample
    * @Description: 根据查询条件类，返回TF_F_AGENT_STAFF_INFO结果集
    * @param example 通用查询条件类
    * @return List<TdTFFAGENTSTAFFINFO>TF_F_AGENT_STAFF_INFO结果集
     */
    List<TdTFFAGENTSTAFFINFO> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdTFFAGENTSTAFFINFOMapper.updateByExampleSelective
    * @Description: 根据查询条件更新TF_F_AGENT_STAFF_INFO部分字段
    * @param record 要更新成为的TdTFFAGENTSTAFFINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdTFFAGENTSTAFFINFO record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdTFFAGENTSTAFFINFOMapper.updateByExample
    * @Description: 根据查询条件更新TF_F_AGENT_STAFF_INFO全表字段
    * @param record 要更新成为的TdTFFAGENTSTAFFINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdTFFAGENTSTAFFINFO record, @Param("example") Criteria criteria);
}