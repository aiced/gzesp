package com.ai.osapp.dao.service;

import java.util.List;

import com.ai.osapp.dao.beans.Criteria;

/**
 * @ClassName: ITableDao
 * @Description: Dao操作接口类
 * @author linyl linyuliang.85@gmail.com
 */
public abstract class ITableDao {
    /**
     * @Title countByExample
     * @Description: 根据查询条件，计算个数
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public int countByExample(final Criteria example){
        return 0;
    }
    
    /**
     * @Title countByExample
     * @Description: 根据查询条件，计算个数
     * @param example 通用查询条件类
     * @return int 结果个数
     */
    public int countByLike(final Criteria example){
        return 0;
    }

    /**
     * @Title selectByExample
     * @Description: 根据查询条件类，返回结果集
     * @param example 通用查询条件类
     * @return List<？> 结果集
     */
    public List<?> selectByExample(final Criteria example){
        return null;
    }
    
    /**
     * @Title selectByLike
     * @Description: 根据查询条件类，返回结果集
     * @param example 通用查询条件类
     * @return List<？> 结果集
     */
    public List<?> selectByLike(final Criteria example){
        return null;
    }

    /**
     * @Title: deleteByExample
     * @Description: 根据查询条件，删除记录
     * @param example 通用查询条件类
     * @return int 删除个数
     */
    public int deleteByExample(final Criteria example)
    {
        return 0;
    }
}
