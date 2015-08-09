package com.ai.gzesp.dao.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdActDACCOUNT;

/**
 * @ClassName: TdActDACCOUNTMapper
* @Description: ACT_D_ACCOUNT表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdActDACCOUNTMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdActDACCOUNTMapper.countByExample
    * @Description: 根据查询条件，计算ACT_D_ACCOUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdActDACCOUNTMapper.deleteByExample
    * @Description: 根据查询条件，删除ACT_D_ACCOUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 根据主键删除记录
     */
    /**
    * @Title TdActDACCOUNTMapper.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ACT_D_ACCOUNT
    * @param acctId acctId
    * @return int  删除个数
     */
    int deleteByPrimaryKey(String acctId);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdActDACCOUNTMapper.insert
    * @Description: 插入一个ACT_D_ACCOUNT
    * @param record ACT_D_ACCOUNT的bean对象
    * @return int  插入个数
     */
    int insert(TdActDACCOUNT record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdActDACCOUNTMapper.insertSelective
    * @Description: 插入一个只有部分字段的ACT_D_ACCOUNT
    * @param record 只含部分字段的ACT_D_ACCOUNT的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdActDACCOUNT record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdActDACCOUNTMapper.selectByExample
    * @Description: 根据查询条件类，返回ACT_D_ACCOUNT结果集
    * @param example 通用查询条件类
    * @return List<TdActDACCOUNT>ACT_D_ACCOUNT结果集
     */
    List<TdActDACCOUNT> selectByExample(Criteria example);

    /**
     * 根据主键查询记录
     */
    /**
    * @Title TdActDACCOUNTMapper.selectByPrimaryKey
    * @Description: 根据主键类，返回ACT_D_ACCOUNT
    * @param acctId acctId
    * @return TdActDACCOUNT bean对象
     */
    TdActDACCOUNT selectByPrimaryKey(String acctId);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdActDACCOUNTMapper.updateByExampleSelective
    * @Description: 根据查询条件更新ACT_D_ACCOUNT部分字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdActDACCOUNT record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdActDACCOUNTMapper.updateByExample
    * @Description: 根据查询条件更新ACT_D_ACCOUNT全表字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdActDACCOUNT record, @Param("example") Criteria criteria);

    /**
     * 根据主键更新属性不为空的记录
     */
    /**
    * @Title TdActDACCOUNTMapper.updateByPrimaryKeySelective
    * @Description: 根据主键更新ACT_D_ACCOUNT部分字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @return int 更新记录数
     */
    int updateByPrimaryKeySelective(TdActDACCOUNT record);

    /**
     * 根据主键更新记录
     */
    /**
    * @Title TdActDACCOUNTMapper.updateByPrimaryKey
    * @Description: 根据主键更新ACT_D_ACCOUNT全部字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @return int 更新记录数
     */
    int updateByPrimaryKey(TdActDACCOUNT record);
    
    TdActDACCOUNT selectAccountInfoByOrderId(String orderId);
    
    int updateAcctVersion(TdActDACCOUNT record);
    
    int updateReverseAcct(@Param("acctId")String acctId, @Param("orderId")String orderId);
}