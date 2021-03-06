package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdITFDWEIXINLOG;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdITFDWEIXINLOGMapper
* @Description: ITF_D_WEIXIN_LOG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdITFDWEIXINLOGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdITFDWEIXINLOGMapper.countByExample
    * @Description: 根据查询条件，计算ITF_D_WEIXIN_LOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdITFDWEIXINLOGMapper.deleteByExample
    * @Description: 根据查询条件，删除ITF_D_WEIXIN_LOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdITFDWEIXINLOGMapper.insert
    * @Description: 插入一个ITF_D_WEIXIN_LOG
    * @param record ITF_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    int insert(TdITFDWEIXINLOG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdITFDWEIXINLOGMapper.insertSelective
    * @Description: 插入一个只有部分字段的ITF_D_WEIXIN_LOG
    * @param record 只含部分字段的ITF_D_WEIXIN_LOG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdITFDWEIXINLOG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdITFDWEIXINLOGMapper.selectByExample
    * @Description: 根据查询条件类，返回ITF_D_WEIXIN_LOG结果集
    * @param example 通用查询条件类
    * @return List<TdITFDWEIXINLOG>ITF_D_WEIXIN_LOG结果集
     */
    List<TdITFDWEIXINLOG> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdITFDWEIXINLOGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ITF_D_WEIXIN_LOG部分字段
    * @param record 要更新成为的TdITFDWEIXINLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdITFDWEIXINLOG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdITFDWEIXINLOGMapper.updateByExample
    * @Description: 根据查询条件更新ITF_D_WEIXIN_LOG全表字段
    * @param record 要更新成为的TdITFDWEIXINLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdITFDWEIXINLOG record, @Param("example") Criteria criteria);
}