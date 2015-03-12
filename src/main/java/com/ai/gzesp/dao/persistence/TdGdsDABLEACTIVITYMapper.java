package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDABLEACTIVITY;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsDABLEACTIVITYMapper
* @Description: GDS_D_ABLE_ACTIVITY表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsDABLEACTIVITYMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsDABLEACTIVITYMapper.countByExample
    * @Description: 根据查询条件，计算GDS_D_ABLE_ACTIVITY个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsDABLEACTIVITYMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ABLE_ACTIVITY
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsDABLEACTIVITYMapper.insert
    * @Description: 插入一个GDS_D_ABLE_ACTIVITY
    * @param record GDS_D_ABLE_ACTIVITY的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsDABLEACTIVITY record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsDABLEACTIVITYMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ABLE_ACTIVITY
    * @param record 只含部分字段的GDS_D_ABLE_ACTIVITY的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsDABLEACTIVITY record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsDABLEACTIVITYMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ABLE_ACTIVITY结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDABLEACTIVITY>GDS_D_ABLE_ACTIVITY结果集
     */
    List<TdGdsDABLEACTIVITY> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsDABLEACTIVITYMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ABLE_ACTIVITY部分字段
    * @param record 要更新成为的TdGdsDABLEACTIVITY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsDABLEACTIVITY record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsDABLEACTIVITYMapper.updateByExample
    * @Description: 根据查询条件更新GDS_D_ABLE_ACTIVITY全表字段
    * @param record 要更新成为的TdGdsDABLEACTIVITY对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsDABLEACTIVITY record, @Param("example") Criteria criteria);
}