package com.ai.gzesp.dao.persistence;

import com.ai.gzesp.dao.beans.Criteria;
import com.ai.gzesp.dao.beans.TdGdsPCTLG;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName: TdGdsPCTLGMapper
* @Description: GDS_P_CTLG表对应的dao操作Mapper映射类
* @author: linyl linyuliang.85@gmail.com
 */
public interface TdGdsPCTLGMapper {
    /**
     * 根据条件查询记录总数
     */
    /**
    * @Title TdGdsPCTLGMapper.countByExample
    * @Description: 根据查询条件，计算GDS_P_CTLG个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    int countByExample(Criteria example);

    /**
     * 根据条件删除记录
     */
    /**
    * @Title TdGdsPCTLGMapper.deleteByExample
    * @Description: 根据查询条件，删除GDS_P_CTLG
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    int deleteByExample(Criteria example);

    /**
     * 保存记录,不管记录里面的属性是否为空
     */
    /**
    * @Title TdGdsPCTLGMapper.insert
    * @Description: 插入一个GDS_P_CTLG
    * @param record GDS_P_CTLG的bean对象
    * @return int  插入个数
     */
    int insert(TdGdsPCTLG record);

    /**
     * 保存属性不为空的记录
     */
    /**
    * @Title TdGdsPCTLGMapper.insertSelective
    * @Description: 插入一个只有部分字段的GDS_P_CTLG
    * @param record 只含部分字段的GDS_P_CTLG的bean对象
    * @return int  插入个数
     */
    int insertSelective(TdGdsPCTLG record);

    /**
     * 根据条件查询记录集
     */
    /**
    * @Title TdGdsPCTLGMapper.selectByExample
    * @Description: 根据查询条件类，返回GDS_P_CTLG结果集
    * @param example 通用查询条件类
    * @return List<TdGdsPCTLG>GDS_P_CTLG结果集
     */
    List<TdGdsPCTLG> selectByExample(Criteria example);

    /**
     * 根据条件更新属性不为空的记录
     */
    /**
    * @Title TdGdsPCTLGMapper.updateByExampleSelective
    * @Description: 根据查询条件更新GDS_P_CTLG部分字段
    * @param record 要更新成为的TdGdsPCTLG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExampleSelective(@Param("record") TdGdsPCTLG record, @Param("example") Criteria criteria);

    /**
     * 根据条件更新记录
     */
    /**
    * @Title TdGdsPCTLGMapper.updateByExample
    * @Description: 根据查询条件更新GDS_P_CTLG全表字段
    * @param record 要更新成为的TdGdsPCTLG对象
    * @param criteria 更新记录的查询条件
    * @return int 更新记录数
     */
    int updateByExample(@Param("record") TdGdsPCTLG record, @Param("example") Criteria criteria);
}