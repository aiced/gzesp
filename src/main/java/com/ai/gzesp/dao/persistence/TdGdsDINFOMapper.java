package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsDINFO;
import com.ai.gzesp.dao.beans.TdGdsDINFOKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsDINFOMapper
* @Description: GDS_D_INFO表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsDINFOMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsDINFOMapper.countByExample
    * @Description: 根据查询条件，计算GDS_D_INFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsDINFOMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_D_INFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdGdsDINFOMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除GDS_D_INFO
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdGdsDINFOKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsDINFOMapper.insert
    * @Description: 插入一个GDS_D_INFO
    * @param record GDS_D_INFO的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsDINFO record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsDINFOMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_D_INFO
    * @param record 只含部分字段的GDS_D_INFO的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsDINFO record);

    /**
     * 根据条件查询记录集
     */
    List<TdGdsDINFO> selectByExampleWithBLOBs(Criteria example);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsDINFOMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_D_INFO结果集
    * @param example 通用查询条件类
    * @return List<TdGdsDINFO>GDS_D_INFO结果集
     */
    List<TdGdsDINFO> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdGdsDINFOMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回GDS_D_INFO
    * @param key key
    * @return TdGdsDINFO bean对象
     */
    TdGdsDINFO selectByPrimaryKey(TdGdsDINFOKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsDINFOMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_D_INFO部分字段
    * @param record 要更新成为的TdGdsDINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsDINFO record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    int updateByExampleWithBLOBs(@Param("record") TdGdsDINFO record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsDINFOMapper.updateByExample
    * @Description: 根据查询条件更新GDS_D_INFO全表字段
    * @param record 要更新成为的TdGdsDINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsDINFO record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdGdsDINFOMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新GDS_D_INFO部分字段
    * @param record 要更新成为的TdGdsDINFO对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdGdsDINFO record);

    /**
     * 根据主键更新记录
     */
    int updateByPrimaryKeyWithBLOBs(TdGdsDINFO record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdGdsDINFOMapper.updateByPrimaryKey
    * @Description: 根据主键更新GDS_D_INFO全部字段
    * @param record 要更新成为的TdGdsDINFO对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdGdsDINFO record);
}