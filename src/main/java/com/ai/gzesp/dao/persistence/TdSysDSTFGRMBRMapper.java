package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTFGRMBR;
import com.ai.gzesp.dao.beans.TdSysDSTFGRMBRKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysDSTFGRMBRMapper
* @Description: SYS_D_STFGR_MBR表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysDSTFGRMBRMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.countByExample
    * @Description: 根据查询条件，计算SYS_D_STFGR_MBR个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STFGR_MBR
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除SYS_D_STFGR_MBR
    * @param key key
    * @return int  删除个数
     */
    int deleteByPrimaryKey(TdSysDSTFGRMBRKey key);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.insert
    * @Description: 插入一个SYS_D_STFGR_MBR
    * @param record SYS_D_STFGR_MBR的bean对象
    * @return int  插入个数
     */
    int insert(TdSysDSTFGRMBR record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STFGR_MBR
    * @param record 只含部分字段的SYS_D_STFGR_MBR的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysDSTFGRMBR record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STFGR_MBR结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTFGRMBR>SYS_D_STFGR_MBR结果集
     */
    List<TdSysDSTFGRMBR> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回SYS_D_STFGR_MBR
    * @param key key
    * @return TdSysDSTFGRMBR bean对象
     */
    TdSysDSTFGRMBR selectByPrimaryKey(TdSysDSTFGRMBRKey key);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STFGR_MBR部分字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysDSTFGRMBR record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.updateByExample
    * @Description: 根据查询条件更新SYS_D_STFGR_MBR全表字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysDSTFGRMBR record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新SYS_D_STFGR_MBR部分字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdSysDSTFGRMBR record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdSysDSTFGRMBRMapper.updateByPrimaryKey
    * @Description: 根据主键更新SYS_D_STFGR_MBR全部字段
    * @param record 要更新成为的TdSysDSTFGRMBR对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdSysDSTFGRMBR record);
}