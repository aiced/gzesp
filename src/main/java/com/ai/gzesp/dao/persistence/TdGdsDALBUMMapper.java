package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDALBUM;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsDALBUMMapper
* @Description: GDS_D_ALBUM表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsDALBUMMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsDALBUMMapper.countByExample
    * @Description: 根据查询条件，计算GDS_D_ALBUM个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsDALBUMMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ALBUM
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdGdsDALBUMMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除GDS_D_ALBUM
    * @param albumId albumId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long albumId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsDALBUMMapper.insert
    * @Description: 插入一个GDS_D_ALBUM
    * @param record GDS_D_ALBUM的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsDALBUM record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsDALBUMMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ALBUM
    * @param record 只含部分字段的GDS_D_ALBUM的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsDALBUM record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsDALBUMMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ALBUM结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDALBUM>GDS_D_ALBUM结果集
     */
    List<TdGdsDALBUM> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdGdsDALBUMMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回GDS_D_ALBUM
    * @param albumId albumId
    * @return TdGdsDALBUM bean对象
     */
    TdGdsDALBUM selectByPrimaryKey(Long albumId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsDALBUMMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ALBUM部分字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsDALBUM record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsDALBUMMapper.updateByExample
    * @Description: 根据查询条件更新GDS_D_ALBUM全表字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsDALBUM record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdGdsDALBUMMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新GDS_D_ALBUM部分字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdGdsDALBUM record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdGdsDALBUMMapper.updateByPrimaryKey
    * @Description: 根据主键更新GDS_D_ALBUM全部字段
    * @param record 要更新成为的TdGdsDALBUM对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdGdsDALBUM record);
}