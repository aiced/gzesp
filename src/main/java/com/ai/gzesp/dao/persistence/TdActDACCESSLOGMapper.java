package com.ai.gzesp.dao.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdActDACCESSLOG;

/**
 * @ClassName: TdActDACCESSLOGMapper
* @Description: ACT_D_ACCESS_LOG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdActDACCESSLOGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdActDACCESSLOGMapper.countByExample
    * @Description: 根据查询条件，计算ACT_D_ACCESS_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.deleteByExample
    * @Description: 根据查询条件，删除ACT_D_ACCESS_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ACT_D_ACCESS_LOG
    * @param logId logId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long logId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdActDACCESSLOGMapper.insert
    * @Description: 插入一个ACT_D_ACCESS_LOG
    * @param record ACT_D_ACCESS_LOG的bean对象
    * @return int  插入个数
     */
    int insert(TdActDACCESSLOG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.insertSelective
    * @Description: 插入一个只有部分字段的ACT_D_ACCESS_LOG
    * @param record 只含部分字段的ACT_D_ACCESS_LOG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdActDACCESSLOG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdActDACCESSLOGMapper.selectByExample
    * @Description: 根据查询条件类，返回ACT_D_ACCESS_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdActDACCESSLOG>ACT_D_ACCESS_LOG结果集
     */
    List<TdActDACCESSLOG> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ACT_D_ACCESS_LOG
    * @param logId logId
    * @return TdActDACCESSLOG bean对象
     */
    TdActDACCESSLOG selectByPrimaryKey(Long logId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ACT_D_ACCESS_LOG部分字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdActDACCESSLOG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.updateByExample
    * @Description: 根据查询条件更新ACT_D_ACCESS_LOG全表字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdActDACCESSLOG record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ACT_D_ACCESS_LOG部分字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdActDACCESSLOG record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdActDACCESSLOGMapper.updateByPrimaryKey
    * @Description: 根据主键更新ACT_D_ACCESS_LOG全部字段
    * @param record 要更新成为的TdActDACCESSLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdActDACCESSLOG record);
    
    int insertReverseAccessLog(TdActDACCESSLOG record);
    
    int updateReverseAccessLog(String orderId);
}