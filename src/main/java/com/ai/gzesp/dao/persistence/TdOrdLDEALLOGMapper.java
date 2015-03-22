package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdOrdLDEALLOG;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdOrdLDEALLOGMapper
* @Description: ORD_L_DEALLOG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdOrdLDEALLOGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdOrdLDEALLOGMapper.countByExample
    * @Description: 根据查询条件，计算ORD_L_DEALLOG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.deleteByExample
    * @Description: 根据查询条件，删除ORD_L_DEALLOG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ORD_L_DEALLOG
    * @param operateLogid operateLogid
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long operateLogid);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdOrdLDEALLOGMapper.insert
    * @Description: 插入一个ORD_L_DEALLOG
    * @param record ORD_L_DEALLOG的bean对象
    * @return int  插入个数
     */
    int insert(TdOrdLDEALLOG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.insertSelective
    * @Description: 插入一个只有部分字段的ORD_L_DEALLOG
    * @param record 只含部分字段的ORD_L_DEALLOG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdOrdLDEALLOG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdOrdLDEALLOGMapper.selectByExample
    * @Description: 根据查询条件类，返回ORD_L_DEALLOG结果集
    * @param example 通用查询条件类
    * @return List<TdOrdLDEALLOG>ORD_L_DEALLOG结果集
     */
    List<TdOrdLDEALLOG> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ORD_L_DEALLOG
    * @param operateLogid operateLogid
    * @return TdOrdLDEALLOG bean对象
     */
    TdOrdLDEALLOG selectByPrimaryKey(Long operateLogid);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ORD_L_DEALLOG部分字段
    * @param record 要更新成为的TdOrdLDEALLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdOrdLDEALLOG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.updateByExample
    * @Description: 根据查询条件更新ORD_L_DEALLOG全表字段
    * @param record 要更新成为的TdOrdLDEALLOG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdOrdLDEALLOG record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ORD_L_DEALLOG部分字段
    * @param record 要更新成为的TdOrdLDEALLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdOrdLDEALLOG record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdOrdLDEALLOGMapper.updateByPrimaryKey
    * @Description: 根据主键更新ORD_L_DEALLOG全部字段
    * @param record 要更新成为的TdOrdLDEALLOG对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdOrdLDEALLOG record);
}