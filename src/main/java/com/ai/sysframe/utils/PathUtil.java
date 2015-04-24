package com.ai.sysframe.utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.ai.sysframe.exception.BaseException;

public class PathUtil {

    /**
     * @Fields WEB_ROOT_PATH : web工程的根目录
     */
    public static final String WEB_ROOT_PATH = getWebRoot();
    public static final String WEB_ROOT_PARENT_PATH = getWebParentPath();
    /**
     * @Fields WEB_INFO_PATH : web工程的web-inf目录
     */
    public static final String WEB_INFO_PATH = getWebInfPath();
    /**
     * @Fields WEB_UPLOAD_PATH : web工程文件上传根目录
     */

    public static final String fileseparator="/";

    public static final String WEB_UPLOAD_PATH =  "uploadfile/uploader/idCardNum" + fileseparator;

    public static final String WEB_TYPE = "mappUpload";
    
    private static Map<String,String> pathMap = new HashMap();
    
    /**
     * @Fields FONT_PATH : web工程的字体目录
     */
    public static final String FONT_PATH = WEB_ROOT_PATH + "resources" + fileseparator + "fonts" + fileseparator;
    
    /**
     * @Title: getWebRoot
     * @Description: 获取web工程的根目录
     * @return web工程的根目录
     */
    private static String getWebRoot() {
        String path = getWebClassesPath(PathUtil.class);
        if (path.indexOf("WEB-INF") > 0) {
            path = path.substring(0, path.indexOf("WEB-INF/classes"));
        } else {
            throw new BaseException("43", new Object[] { "WEB-INF/classes", path });
        }
        return path;
    }
    private static String getWebParentPath() {
    	String path = getWebClassesPath(PathUtil.class);
    	if (path.indexOf("esp/WEB-INF") > 0) {
    		path = path.substring(0, path.indexOf("esp/WEB-INF"));
    	} else {
    		throw new BaseException("43", new Object[] { "esp/WEB-INF", path });
    	}
    	return path;
    }
    
    /**
     * @Title: getWebClassesPath
     * @Description: 获取某个类的全路径
     * @param clas 类的class
     * @return 类的全路径，包含class名称
     */
    public static String getWebClassesPath(final Class<?> clas) {
        final String path = clas.getProtectionDomain().getCodeSource().getLocation().getPath();
        return path;

    }
    
    /**
     * @Title: getWebInfPath
     * @Description: 获取web工程的web-inf目录
     * @return web工程的web-inf目录
     */
    private static String getWebInfPath() {
        String path = getWebClassesPath(PathUtil.class);
        final String inf = "WEB-INF";
        final int offset = 8;
        if (path.indexOf(inf) > 0) {
            path = path.substring(0, path.indexOf(inf) + offset);
        } else {
            throw new BaseException("43", new Object[] { "WEB-INF", path });
        }
        return path;
    }
    
    /**
     * @Title: createDir
     * @Description: 如果文件夹不存在，则先创建文件夹
     * @param file 要创建的文件
     * @throws BaseException 安全权限限制异常
     */
    public static void createDir(final File file) throws BaseException {
        final File parent = file.getParentFile();
        if (parent != null) {
            try {
                parent.mkdirs();
            } catch (final SecurityException e) {
                throw new BaseException("33", e, new Object[] { file.getPath() });
            }
        }
    }
    
    public static String getFileUploadPath(final String paramType,final String paramName) 
    {
//        String pathValue =  pathMap.get(paramType + paramName);
    	String pathValue =  pathMap.get(paramType + paramName);
    	
//        if(CommonUtil.isNull(pathValue)) 
//        {
//            Criteria crit = new Criteria();
//            crit.createConditon().andEqualTo("PARAM_TYPE", paramType).andEqualTo("PARAM_NAME", paramName);
//            List<TdAppSysParam> list = paramDao.selectByExample(crit);
//            
//            if(list.size() == 0) {
//                throw new BaseException("43", new Object[] { "WEB-INF/classes", paramName });
//            }else 
//            {
//                pathValue = list.get(0).getV1();
//                pathMap.put(paramType + paramName, list.get(0).getV1());
//            }           
//        }
        
        final StringBuffer path = new StringBuffer("");
        path.append(PathUtil.WEB_UPLOAD_PATH);
        path.append(pathValue);
        path.append(DateUtil.getNowyyyyMMdd());
        path.append(fileseparator);
        return path.toString();
    }
}
