package com.ai.gzesp.dao.service;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdActDACCOUNT;
import com.ai.gzesp.dao.persistence.TdActDACCOUNTMapper;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @ClassName: TdActDACCOUNTDao
* @Description: ACT_D_ACCOUNT表对应dao操作接口实现类
* @author: linyl linyuliang.85@gmail.com
 */
@Service
public class TdActDACCOUNTDao extends ITableDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TdActDACCOUNTDao.class);

    /**
     * @Fields TdActDACCOUNT表的Mybatis Mapper操作映射类
     */
    @Resource
    private TdActDACCOUNTMapper tdActDACCOUNTMapper;

    /**
    * @Title TdActDACCOUNTDao.countByExample
    * @Description: 根据查询条件，计算ACT_D_ACCOUNT个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tdActDACCOUNTMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TdActDACCOUNTDao.selectByPrimaryKey
    * @Description: 根据主键类，返回ACT_D_ACCOUNT
    * @param acctId acctId
    * @return TdActDACCOUNT bean对象
     */
    public TdActDACCOUNT selectByPrimaryKey(String acctId) {
        return this.tdActDACCOUNTMapper.selectByPrimaryKey(acctId);
    }

    /**
    * @Title TdActDACCOUNTDao.selectByExample
    * @Description: 根据查询条件类，返回ACT_D_ACCOUNT结果集
    * @param example 通用查询条件类
    * @return List<TdActDACCOUNT>ACT_D_ACCOUNT结果集
     */
    public List<TdActDACCOUNT> selectByExample(Criteria example) {
        return this.tdActDACCOUNTMapper.selectByExample(example);
    }

    /**
    * @Title TdActDACCOUNTDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除ACT_D_ACCOUNT
    * @param acctId acctId
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(String acctId) {
        return this.tdActDACCOUNTMapper.deleteByPrimaryKey(acctId);
    }

    /**
    * @Title TdActDACCOUNTDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新ACT_D_ACCOUNT部分字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TdActDACCOUNT record) {
        return this.tdActDACCOUNTMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TdActDACCOUNTDao.updateByPrimaryKey
    * @Description: 根据主键更新ACT_D_ACCOUNT全部字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TdActDACCOUNT record) {
        return this.tdActDACCOUNTMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TdActDACCOUNTDao.deleteByExample
    * @Description: 根据查询条件，删除ACT_D_ACCOUNT
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tdActDACCOUNTMapper.deleteByExample(example);
    }

    /**
    * @Title TdActDACCOUNTDao.updateByExampleSelective
    * @Description: 根据查询条件更新ACT_D_ACCOUNT部分字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TdActDACCOUNT record, Criteria example) {
        return this.tdActDACCOUNTMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TdActDACCOUNTDao.updateByExample
    * @Description: 根据查询条件更新ACT_D_ACCOUNT全表字段
    * @param record 要更新成为的TdActDACCOUNT对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TdActDACCOUNT record, Criteria example) {
        return this.tdActDACCOUNTMapper.updateByExample(record, example);
    }

    /**
    * @Title TdActDACCOUNTDao.insert
    * @Description: 插入一个ACT_D_ACCOUNT
    * @param record ACT_D_ACCOUNT的bean对象
    * @return int  插入个数
     */
    public int insert(TdActDACCOUNT record) {
        return this.tdActDACCOUNTMapper.insert(record);
    }

    /**
    * @Title TdActDACCOUNTDao.insertSelective
    * @Description: 插入一个只有部分字段的ACT_D_ACCOUNT
    * @param record 只含部分字段的ACT_D_ACCOUNT的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TdActDACCOUNT record) {
        return this.tdActDACCOUNTMapper.insertSelective(record);
    }
    
    
    public TdActDACCOUNT selectAccountInfoByOrderId(String orderId) {
    	 return this.tdActDACCOUNTMapper.selectAccountInfoByOrderId(orderId);
    }
    
    public int updateAcctVersion(TdActDACCOUNT record) {
    	 return this.tdActDACCOUNTMapper.updateAcctVersion(record);
    }
    
    public int updateReverseAcct(String acctId, String orderId) {
    	return this.tdActDACCOUNTMapper.updateReverseAcct(acctId, orderId);
    	
    }
}