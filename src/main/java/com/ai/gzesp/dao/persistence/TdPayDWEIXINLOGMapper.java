package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdPayDWEIXINLOG;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdPayDWEIXINLOGMapper
* @Description: PAY_D_WEIXIN_LOG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdPayDWEIXINLOGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.countByExample
    * @Description: 根据查询条件，计算PAY_D_WEIXIN_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.deleteByExample
    * @Description: 根据查询条件，删除PAY_D_WEIXIN_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除PAY_D_WEIXIN_LOG
    * @param logId logId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long logId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.insert
    * @Description: 插入一个PAY_D_WEIXIN_LOG
    * @param record PAY_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    int insert(TdPayDWEIXINLOG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.insertSelective
    * @Description: 插入一个只有部分字段的PAY_D_WEIXIN_LOG
    * @param record 只含部分字段的PAY_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdPayDWEIXINLOG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.selectByExample
    * @Description: 根据查询条件类，返回PAY_D_WEIXIN_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdPayDWEIXINLOG>PAY_D_WEIXIN_LOG结果集
     */
    List<TdPayDWEIXINLOG> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回PAY_D_WEIXIN_LOG
    * @param logId logId
    * @return TdPayDWEIXINLOG bean对象
     */
    TdPayDWEIXINLOG selectByPrimaryKey(Long logId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新PAY_D_WEIXIN_LOG部分字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdPayDWEIXINLOG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.updateByExample
    * @Description: 根据查询条件更新PAY_D_WEIXIN_LOG全表字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdPayDWEIXINLOG record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新PAY_D_WEIXIN_LOG部分字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdPayDWEIXINLOG record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdPayDWEIXINLOGMapper.updateByPrimaryKey
    * @Description: 根据主键更新PAY_D_WEIXIN_LOG全部字段
    * @param record 要更新成为的TdPayDWEIXINLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdPayDWEIXINLOG record);
}