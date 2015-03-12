package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDATTRVAL;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsDATTRVALMapper
* @Description: GDS_D_ATTRVAL表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsDATTRVALMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsDATTRVALMapper.countByExample
    * @Description: 根据查询条件，计算GDS_D_ATTRVAL个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsDATTRVALMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ATTRVAL
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsDATTRVALMapper.insert
    * @Description: 插入一个GDS_D_ATTRVAL
    * @param record GDS_D_ATTRVAL的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsDATTRVAL record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsDATTRVALMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ATTRVAL
    * @param record 只含部分字段的GDS_D_ATTRVAL的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsDATTRVAL record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsDATTRVALMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ATTRVAL结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDATTRVAL>GDS_D_ATTRVAL结果集
     */
    List<TdGdsDATTRVAL> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsDATTRVALMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ATTRVAL部分字段
    * @param record 要更新成为的TdGdsDATTRVAL对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsDATTRVAL record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsDATTRVALMapper.updateByExample
    * @Description: 根据查询条件更新GDS_D_ATTRVAL全表字段
    * @param record 要更新成为的TdGdsDATTRVAL对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsDATTRVAL record, @Param("example") Criteria criteria);
}