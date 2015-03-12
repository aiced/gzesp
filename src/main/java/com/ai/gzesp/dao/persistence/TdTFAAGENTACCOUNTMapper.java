package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdTFAAGENTACCOUNT;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdTFAAGENTACCOUNTMapper
* @Description: TF_A_AGENT_ACCOUNT表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdTFAAGENTACCOUNTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.countByExample
    * @Description: 根据查询条件，计算TF_A_AGENT_ACCOUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.deleteByExample
    * @Description: 根据查询条件，删除TF_A_AGENT_ACCOUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除TF_A_AGENT_ACCOUNT
    * @param agentId agentId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer agentId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.insert
    * @Description: 插入一个TF_A_AGENT_ACCOUNT
    * @param record TF_A_AGENT_ACCOUNT的bean对象
    * @return int  插入个数
     */
    int insert(TdTFAAGENTACCOUNT record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.insertSelective
    * @Description: 插入一个只有部分字段的TF_A_AGENT_ACCOUNT
    * @param record 只含部分字段的TF_A_AGENT_ACCOUNT的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdTFAAGENTACCOUNT record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.selectByExample
    * @Description: 根据查询条件类，返回TF_A_AGENT_ACCOUNT结果集
    * @param example 通用查询条件类
    * @return List<TdTFAAGENTACCOUNT>TF_A_AGENT_ACCOUNT结果集
     */
    List<TdTFAAGENTACCOUNT> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回TF_A_AGENT_ACCOUNT
    * @param agentId agentId
    * @return TdTFAAGENTACCOUNT bean对象
     */
    TdTFAAGENTACCOUNT selectByPrimaryKey(Integer agentId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新TF_A_AGENT_ACCOUNT部分字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdTFAAGENTACCOUNT record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.updateByExample
    * @Description: 根据查询条件更新TF_A_AGENT_ACCOUNT全表字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdTFAAGENTACCOUNT record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新TF_A_AGENT_ACCOUNT部分字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdTFAAGENTACCOUNT record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdTFAAGENTACCOUNTMapper.updateByPrimaryKey
    * @Description: 根据主键更新TF_A_AGENT_ACCOUNT全部字段
    * @param record 要更新成为的TdTFAAGENTACCOUNT对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdTFAAGENTACCOUNT record);
}