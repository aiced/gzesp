package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdPayDWOPAYLOG;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdPayDWOPAYLOGMapper
* @Description: PAY_D_WOPAY_LOG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdPayDWOPAYLOGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.countByExample
    * @Description: 根据查询条件，计算PAY_D_WOPAY_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.deleteByExample
    * @Description: 根据查询条件，删除PAY_D_WOPAY_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除PAY_D_WOPAY_LOG
    * @param logId logId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long logId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.insert
    * @Description: 插入一个PAY_D_WOPAY_LOG
    * @param record PAY_D_WOPAY_LOG的bean对象
    * @return int  插入个数
     */
    int insert(TdPayDWOPAYLOG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.insertSelective
    * @Description: 插入一个只有部分字段的PAY_D_WOPAY_LOG
    * @param record 只含部分字段的PAY_D_WOPAY_LOG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdPayDWOPAYLOG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.selectByExample
    * @Description: 根据查询条件类，返回PAY_D_WOPAY_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdPayDWOPAYLOG>PAY_D_WOPAY_LOG结果集
     */
    List<TdPayDWOPAYLOG> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回PAY_D_WOPAY_LOG
    * @param logId logId
    * @return TdPayDWOPAYLOG bean对象
     */
    TdPayDWOPAYLOG selectByPrimaryKey(Long logId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新PAY_D_WOPAY_LOG部分字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdPayDWOPAYLOG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.updateByExample
    * @Description: 根据查询条件更新PAY_D_WOPAY_LOG全表字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdPayDWOPAYLOG record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新PAY_D_WOPAY_LOG部分字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdPayDWOPAYLOG record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdPayDWOPAYLOGMapper.updateByPrimaryKey
    * @Description: 根据主键更新PAY_D_WOPAY_LOG全部字段
    * @param record 要更新成为的TdPayDWOPAYLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdPayDWOPAYLOG record);
}