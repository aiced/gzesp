package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDABLERCD;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsDABLERCDMapper
* @Description: GDS_D_ABLE_RCD表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsDABLERCDMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsDABLERCDMapper.countByExample
    * @Description: 根据查询条件，计算GDS_D_ABLE_RCD个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsDABLERCDMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_ABLE_RCD
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsDABLERCDMapper.insert
    * @Description: 插入一个GDS_D_ABLE_RCD
    * @param record GDS_D_ABLE_RCD的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsDABLERCD record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsDABLERCDMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_ABLE_RCD
    * @param record 只含部分字段的GDS_D_ABLE_RCD的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsDABLERCD record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsDABLERCDMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_ABLE_RCD结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDABLERCD>GDS_D_ABLE_RCD结果集
     */
    List<TdGdsDABLERCD> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsDABLERCDMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_ABLE_RCD部分字段
    * @param record 要更新成为的TdGdsDABLERCD对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsDABLERCD record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsDABLERCDMapper.updateByExample
    * @Description: 根据查询条件更新GDS_D_ABLE_RCD全表字段
    * @param record 要更新成为的TdGdsDABLERCD对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsDABLERCD record, @Param("example") Criteria criteria);
}