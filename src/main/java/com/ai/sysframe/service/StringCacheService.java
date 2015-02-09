package com.ai.sysframe.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
* @ClassName: StringCacheService
* @Description: 字符串操作缓存服务
* @author linyl linyuliang.85@gmail.com
*/
@Service("stringCacheService")
@Scope("singleton")
public class StringCacheService {
    /**
    * @Title: cacheSplitString
    * @Description: 缓存字符串split结果
    * @param str 字符串
    * @param seperater split分隔符
    * @return 分隔后的字符串数组
    */
    @Cacheable(value = { "StringUtil.cacheSplitString" })
    public String[] cacheSplitString(final String str, final String seperater) {
        return str.split(seperater);
    }

    /**
    * @Title: findLeftMatchKey
    * @Description: 从Map的keySet中，找出最大的左边开始匹配串
    * @param keySet Map的keySet
    * @param path 需要判断的字符串
    * @return 如果List长度大于0，则找到匹配，第一个为匹配串，第二个为后半部分串
    */
    @Cacheable(value = { "StringUtil.findLeftMatchKey" })
    public List<String> findLeftMatchKey(final Set<String> keySet, final String path) {
        String checkPath = path;
        int i = checkPath.lastIndexOf("/");
        boolean needReplace = false;
        while (i > 0) {
            checkPath = checkPath.substring(0, i);
            if (keySet.contains(checkPath)) {
                needReplace = true;
                break;
            }
            i = checkPath.lastIndexOf("/");
        }
        final List<String> apartStr = new ArrayList<String>();
        if(needReplace)
        {
            apartStr.add(checkPath);
            apartStr.add(path.substring(i));
        }
        return apartStr;
    }

    @Cacheable(value = { "StringUtil.appendTwoString" })
    public String appendTwoString(final String str1,final String str2)
    {
        return str1+str2;
    }
}
