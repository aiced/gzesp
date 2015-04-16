package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdAurDAUTHINFO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdAurDAUTHINFOMapper
* @Description: AUR_D_AUTHINFO表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdAurDAUTHINFOMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdAurDAUTHINFOMapper.countByExample
    * @Description: 根据查询条件，计算AUR_D_AUTHINFO个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.deleteByExample
    * @Description: 根据查询条件，删除AUR_D_AUTHINFO
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除AUR_D_AUTHINFO
    * @param id id
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdAurDAUTHINFOMapper.insert
    * @Description: 插入一个AUR_D_AUTHINFO
    * @param record AUR_D_AUTHINFO的bean对象
    * @return int  插入个数
     */
    int insert(TdAurDAUTHINFO record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.insertSelective
    * @Description: 插入一个只有部分字段的AUR_D_AUTHINFO
    * @param record 只含部分字段的AUR_D_AUTHINFO的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdAurDAUTHINFO record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdAurDAUTHINFOMapper.selectByExample
    * @Description: 根据查询条件类，返回AUR_D_AUTHINFO结果集
    * @param example 通用查询条件类
    * @return List<TdAurDAUTHINFO>AUR_D_AUTHINFO结果集
     */
    List<TdAurDAUTHINFO> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回AUR_D_AUTHINFO
    * @param id id
    * @return TdAurDAUTHINFO bean对象
     */
    TdAurDAUTHINFO selectByPrimaryKey(Long id);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.updateByExampleSelective
    * @Description: 根据查询条件更新AUR_D_AUTHINFO部分字段
    * @param record 要更新成为的TdAurDAUTHINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdAurDAUTHINFO record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.updateByExample
    * @Description: 根据查询条件更新AUR_D_AUTHINFO全表字段
    * @param record 要更新成为的TdAurDAUTHINFO对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdAurDAUTHINFO record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新AUR_D_AUTHINFO部分字段
    * @param record 要更新成为的TdAurDAUTHINFO对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdAurDAUTHINFO record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdAurDAUTHINFOMapper.updateByPrimaryKey
    * @Description: 根据主键更新AUR_D_AUTHINFO全部字段
    * @param record 要更新成为的TdAurDAUTHINFO对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdAurDAUTHINFO record);
}