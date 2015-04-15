
package com.ai.gzesp.utils;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;


/**
 * 日期时间工具类<br> 
 * 〈功能详细描述〉
 *
 * @author xmh
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public class DateUtils {

    /**
     * yyyy-MM-dd格式日期正则式
     */
    public static final String DATE_PATTERN = "\\d{4}\\-\\d{1,2}\\-\\d{1,2}";

    /**
     * 年月日：yyyy-MM-dd
     */
    public static final String DATE_FORMAT = "yyyy-MM-dd";

    /**
     * HH:mm:ss 格式时间正则式
     */
    public static final String TIME_PATTERN = "\\d{1,2}\\:\\d{1,2}\\:\\d{1,2}";

    /**
     * 时分秒： HH:mm:ss
     */
    public static final String TIME_FORMAT = "HH:mm:ss";

    /**
     * 时分秒： hhmmss
     */
    public static final String TIME_NUM_PATTERN = "\\d{6}";

    /**
     * yyyy-MM-dd HH:mm:ss 格式日期+时间的正则式
     */
    public static final String TIMESTAMP_PATTERN = "\\d{4}\\-\\d{1,2}\\-\\d{1,2} \\d{1,2}\\:\\d{1,2}\\:\\d{1,2}";

    /**
     * 年月日时分秒： yyyy-MM-dd HH:mm:ss
     */
    public static final String TIMESTAMP_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * yyyyMMdd 格式日期正则式
     */
    public static final String SHORT_DATE_PATTERN = "\\d{8}";

    /**
     * yyyy-MM-dd HH:mm:ss.S CST 格式日期+时间的完整正则式
     */
    public static final String TIMESTAMP_PATTERN_MM = "\\d{4}\\-\\d{1,2}\\-\\d{1,2}"
            + " \\d{1,2}\\:\\d{1,2}\\:\\d{1,2}.\\d{1} CST";

    /**
     * 年月日时分秒微秒： yyyy-MM-dd HH:mm:ss.S
     */
    public static final String TIMESTAMP_FORMAT_MM = "yyyy-MM-dd HH:mm:ss.S";

    /**
     * EEE MMM dd HH:mm:ss zzz yyyy 格式的正则式
     */
    public static final String TIMESTAMP_PATTERN_EN = "\\w{3}\\ \\w{3}\\ \\d{1,2}"
            + " \\d{1,2}\\:\\d{1,2}\\:\\d{1,2} CST \\d{4}";

    /**
     * EEE MMM dd HH:mm:ss zzz yyyy
     */
    public static final String TIMESTAMP_FORMAT_EN = "EEE MMM dd HH:mm:ss zzz yyyy";

    /** 9999年12月31日 */
    public static final Date MAX_DATE_YMD = parse("99991231");

    /**
     * 年月日：yyyyMMdd
     */
    public static final String PATTERN = "yyyyMMdd";

    /**
     * HHmmss 格式时间正则式
     */
    private static final String TIME_NUM_FORMAT = "HHmmss";

    /**
     * 日志管理器
     */
    private static final Logger LOGGER = Logger.getLogger(DateUtils.class); 

    /**
     * 
     * 功能描述: <br>
     * 根据默认格式yyyyMMdd 将字符串参数转为日期对象输出
     * 
     * @param str
     * @return Date
     */
    public static Date parse(final String str) {
        DateFormat format = new SimpleDateFormat(PATTERN);
        try {
            return format.parse(str);
        } catch (ParseException e) {
            LOGGER.error(str + " is not a valid Date String.", e);
        }
        return null;
    }

    /**
     * 根据指定格式将字符串转为日期格式
     * 
     * @param str
     * @param dateFormat
     * @return Date
     */
    public static Date parse(final String str, String dateFormat) {
        DateFormat format = new SimpleDateFormat(dateFormat);
        try {
            return format.parse(str);
        } catch (ParseException e) {
            LOGGER.error(str + " is not a valid Date String.", e);
        }
        return null;
    }

    /**
     * 根据默认格式HH:mm:ss解析字符串转为日期对象
     * 
     * @param str
     * @return Date
     */
    public static Date parseTime(final String str) {
        DateFormat format = new SimpleDateFormat(TIME_FORMAT);
        try {
            return format.parse(str);
        } catch (ParseException e) {
            LOGGER.error(str + " is not a valid Date String.", e);
        }
        return null;
    }

    /**
     * 默认将日期转为yyyyMMdd格式字符串
     * 
     * @param date
     * @return String
     */
    public static String format(final Date date) {
        DateFormat format = new SimpleDateFormat(PATTERN);
        if (date != null) {
            return format.format(date);
        }
        return null;
    }
    /**
     * 默认将日期转为yyyy-MM-dd格式字符串
     * 
     * @param date
     * @return String
     * @throws ParseException 
     */
    public static String formatDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat(PATTERN);
        Date d = format.parse(date);
        DateFormat format1 = new SimpleDateFormat(DATE_FORMAT);
        return format1.format(d);
    }

    /**
     * 根据指定格式转换日期到字符串
     * 
     * @param date
     * @param patterm
     * @return String
     */
    public static String formatDate(Date date, String patterm) {
        DateFormat format = new SimpleDateFormat(patterm);
        if (date != null) {
            return format.format(date);
        }
        return null;
    }

    /**
     * 
     * 功能描述: <br>
     * 不同日期字符串转换成日期对象 〈功能详细描述〉
     * 
     * @param dateStr
     * @return Date
     * @throws ParseException
     */
    public static Date parseDate(String dateStr) throws ParseException {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        Matcher matcher = pattern.matcher(dateStr);
        SimpleDateFormat sdf = null;
        Date date = null;
        // 匹配yyyy-MM-dd格式日期
        if (matcher.matches()) {
            sdf = new SimpleDateFormat(DATE_FORMAT);
            date = sdf.parse(dateStr);
        } else {
            pattern = Pattern.compile(TIME_PATTERN);
            matcher = pattern.matcher(dateStr);
            // 匹配HH:mm:ss格式时间
            if (matcher.matches()) {
                sdf = new SimpleDateFormat(TIME_FORMAT);
                date = sdf.parse(dateStr);
            } else {
                pattern = Pattern.compile(TIMESTAMP_PATTERN);
                matcher = pattern.matcher(dateStr);
                // yyyy-MM-dd HH:mm:ss 格式日期+时间
                if (matcher.matches()) {
                    sdf = new SimpleDateFormat(TIMESTAMP_FORMAT);
                    date = sdf.parse(dateStr);
                } else {
                    pattern = Pattern.compile(SHORT_DATE_PATTERN);
                    matcher = pattern.matcher(dateStr);
                    // 匹配yyyyMMdd 格式日期
                    if (matcher.matches()) {
                        sdf = new SimpleDateFormat(PATTERN);
                        date = sdf.parse(dateStr);
                    }
                }
            }
        }

        // 如果还没匹配上，按西文格式时间匹配
        if (date == null) {
            pattern = Pattern.compile(TIMESTAMP_PATTERN_EN);
            matcher = pattern.matcher(dateStr);
            // 按EEE MMM dd HH:mm:ss zzz yyyy 格式匹配
            if (matcher.matches()) {
                sdf = new SimpleDateFormat(TIMESTAMP_FORMAT_EN, Locale.US);
                date = sdf.parse(dateStr);
            } else {
                pattern = Pattern.compile(TIMESTAMP_PATTERN_MM);
                matcher = pattern.matcher(dateStr);
                // 按yyyy-MM-dd HH:mm:ss.S CST 格式匹配
                if (matcher.matches()) {
                    sdf = new SimpleDateFormat(TIMESTAMP_FORMAT_MM);
                    date = sdf.parse(dateStr);
                }
            }
        }
        return date;
    }

    /**
     * 获取当前时间戳
     * 
     * @return Timestamp
     */
    public static Timestamp getCurrentTimestamp() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        return ts;
    }
    
    
    /**
     * 获取当前时间戳 yyyyMMddHHmmss<br>
     * 〈功能详细描述〉
     *
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getCurentTime(){
        return new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
    }

    /**
     * 获取当前日期
     * 
     * @return Date
     */
    public static Date getCurrentDate() {
        return new Date();
    }


    /**
     * 
     * 功能描述:字符串转化为java.sql.time <br>
     * 〈功能详细描述〉
     * 
     * @param timeStr
     * @return
     * @throws ParseException
     */
    public static Time parseTime4Sql(String timeStr) throws ParseException {
        Time time = null;
        Pattern pattern = Pattern.compile(TIME_PATTERN);
        Matcher matcher = pattern.matcher(timeStr);
        if (matcher.matches()) {
            time = Time.valueOf(timeStr);
        } else {
            pattern = Pattern.compile(TIME_NUM_PATTERN);
            matcher = pattern.matcher(timeStr);
            if (matcher.matches()) {
                DateFormat format = new SimpleDateFormat(TIME_NUM_FORMAT);
                Date date = format.parse(timeStr);
                time = new Time(date.getTime());
            }
        }
        return time;
    }

    /**
     * 功能描述: 获得指定日期date的指定偏移量days天数的日期<br>
     * 
     * @param date
     * @param days
     */
    public static Date addDay(Date date, int days) {
        return org.apache.commons.lang3.time.DateUtils.addDays(date, days);
    }

    /**
     * 功能描述:获得指定日期date的指定偏移量hours小时的日期 <br>
     *
     * @param date
     * @param hours
     * @return
     */
    public static Date addHour( Date date , int hours ){
        return org.apache.commons.lang3.time.DateUtils.addHours(date, hours);
    }
    
    /**
     * 功能描述：获取与当前时间相差N天的时间 输入参数：<按照参数定义顺序>
     * 
     * @param 参数说明 返回值: 类型 <说明>
     * @return 返回值
     * @throw 异常描述
     * @see 需要参见的其它内容
     */
    public static String getCertainFormatTime(int days) {

        DateFormat format = new SimpleDateFormat(TIMESTAMP_FORMAT);
        Date date = addDay(getCurrentDate(), days);
        return format.format(date);

    }

    /**
     * 多values的SQL专用<br>
     * 解析可能为空的时间对象：<br>
     * 当Date为null时返回null串；<br>
     * 不为null时，返回单引号括起来的时间
     * 
     * @param date 日期对象
     * @return
     */
    public static String procDateStr(Date date) {

        if (null == date) {
            return "null";
        } else {
            return "'" + formatDate(date, DATE_FORMAT) + "'";
        }
    }
    
    public static int getCurrentHour()
    {
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
    }
}
