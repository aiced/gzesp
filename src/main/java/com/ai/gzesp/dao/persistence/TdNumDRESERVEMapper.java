package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdNumDRESERVE;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdNumDRESERVEMapper
* @Description: NUM_D_RESERVE表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdNumDRESERVEMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdNumDRESERVEMapper.countByExample
    * @Description: 根据查询条件，计算NUM_D_RESERVE个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdNumDRESERVEMapper.deleteByExample
    * @Description: 根据查询条件，删除NUM_D_RESERVE
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdNumDRESERVEMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除NUM_D_RESERVE
    * @param serialNumber serialNumber
    * @return int  删除个数
     */
    int deleteByPrimaryKey(String serialNumber);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdNumDRESERVEMapper.insert
    * @Description: 插入一个NUM_D_RESERVE
    * @param record NUM_D_RESERVE的bean对象
    * @return int  插入个数
     */
    int insert(TdNumDRESERVE record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdNumDRESERVEMapper.insertSelective
    * @Description: 插入一个只有部分字段的NUM_D_RESERVE
    * @param record 只含部分字段的NUM_D_RESERVE的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdNumDRESERVE record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdNumDRESERVEMapper.selectByExample
    * @Description: 根据查询条件类，返回NUM_D_RESERVE结果集
    * @param example 通用查询条件类
    * @return List<TdNumDRESERVE>NUM_D_RESERVE结果集
     */
    List<TdNumDRESERVE> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdNumDRESERVEMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回NUM_D_RESERVE
    * @param serialNumber serialNumber
    * @return TdNumDRESERVE bean对象
     */
    TdNumDRESERVE selectByPrimaryKey(String serialNumber);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdNumDRESERVEMapper.updateByExampleSelective
    * @Description: 根据查询条件更新NUM_D_RESERVE部分字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdNumDRESERVE record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdNumDRESERVEMapper.updateByExample
    * @Description: 根据查询条件更新NUM_D_RESERVE全表字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdNumDRESERVE record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdNumDRESERVEMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新NUM_D_RESERVE部分字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdNumDRESERVE record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdNumDRESERVEMapper.updateByPrimaryKey
    * @Description: 根据主键更新NUM_D_RESERVE全部字段
    * @param record 要更新成为的TdNumDRESERVE对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdNumDRESERVE record);
}