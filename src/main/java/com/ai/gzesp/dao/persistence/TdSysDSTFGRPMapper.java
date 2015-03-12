package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdSysDSTFGRP;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdSysDSTFGRPMapper
* @Description: SYS_D_STFGRP表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdSysDSTFGRPMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdSysDSTFGRPMapper.countByExample
    * @Description: 根据查询条件，计算SYS_D_STFGRP个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.deleteByExample
    * @Description: 根据查询条件，删除SYS_D_STFGRP
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除SYS_D_STFGRP
    * @param stfgrpId stfgrpId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(Integer stfgrpId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdSysDSTFGRPMapper.insert
    * @Description: 插入一个SYS_D_STFGRP
    * @param record SYS_D_STFGRP的bean对象
    * @return int  插入个数
     */
    int insert(TdSysDSTFGRP record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.insertSelective
    * @Description: 插入一个只有部分字段的SYS_D_STFGRP
    * @param record 只含部分字段的SYS_D_STFGRP的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdSysDSTFGRP record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdSysDSTFGRPMapper.selectByExample
    * @Description: 根据查询条件类，返回SYS_D_STFGRP结果集
    * @param example 通用查询条件类
    * @return List<TdSysDSTFGRP>SYS_D_STFGRP结果集
     */
    List<TdSysDSTFGRP> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回SYS_D_STFGRP
    * @param stfgrpId stfgrpId
    * @return TdSysDSTFGRP bean对象
     */
    TdSysDSTFGRP selectByPrimaryKey(Integer stfgrpId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.updateByExampleSelective
    * @Description: 根据查询条件更新SYS_D_STFGRP部分字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdSysDSTFGRP record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.updateByExample
    * @Description: 根据查询条件更新SYS_D_STFGRP全表字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdSysDSTFGRP record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新SYS_D_STFGRP部分字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdSysDSTFGRP record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdSysDSTFGRPMapper.updateByPrimaryKey
    * @Description: 根据主键更新SYS_D_STFGRP全部字段
    * @param record 要更新成为的TdSysDSTFGRP对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdSysDSTFGRP record);
}