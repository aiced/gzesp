package com.ai.sysframe.utils;

import java.sql.Timestamp;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.ai.sysframe.exception.BaseException;
import com.ai.sysframe.utils.enums.WeekCnEnum;

/**
 * @ClassName: DateUtil
 * @Description: 日期工具类
 * @author linyl linyuliang.85@gmail.com
 */
public class DateUtil {
    
    /**
     * @Fields DD : 日期格式
     */
    public static final String DD = "dd";
    /**
     * @Fields MM : 日期格式
     */
    public static final String MM = "MM";
    /**
     * @Fields YYYY : 日期格式
     */
    public static final String YYYY = "yyyy";
    /**
     * @Fields YYYYMM : 日期格式
     */
    public static final String YYYYMM = "yyyyMM";
    /**
     * @Fields YYYYMMDD : 日期格式
     */
    public static final String YYYYMMDD = "yyyyMMdd";
    
    /**
     * @Fields DEFAULT_PATTERN : 默认日期格式化类
     */
    public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
    
    /**
     * @Fields ORACLE_PATTERN : Oracle日期格式化用
     */
    public static final String ORACLE_PATTERN = "yyyy-MM-dd  HH24:mi:ss";
    /**
     * @Fields ONE_DAY : 一天对应的long值
     */
    public static final long ONE_DAY = 86400000;
    /**
     * @Fields mFormatYear : yyyy格式
     */
    public static final SimpleDateFormat FORMAT_YYYY = new SimpleDateFormat(YYYY);
    
    /**
     * @Fields DEFAULT_LOCALE : 默认的语言环境
     */
    private static final Locale DEFAULT_LOCALE = Locale.getDefault();
    
    /**
     * 简单转换日期类型到字符串类型，本地信息设为UK
     * @param date 日期
     * @return 日期 指定日期格式的日期
     */
    public static Date getDate(final String date) {
        final String format = getTimestampFormat(date);
        if (format == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(format).parse(date);
        } catch (final ParseException e) {
            throw new BaseException("42", e, new Object[] { date, format });
        }
    }
    
    /**
     * 简单转换日期类型到字符串类型，本地信息设为UK
     * @param date 日期
     * @return 日期 指定日期格式的日期
     */
    public static String getDateString(final String date) {
        final String format = getTimestampFormat(date);
        return new SimpleDateFormat(format, DEFAULT_LOCALE).format(date);
    }
    
    /**
     * 简单转换日期类型到字符串类型，本地信息设为UK
     * @param date 日期
     * @param format 格式化pattern,例如YYYYMMDD
     * @return String 格式化好的日期字符串
     */
    public static String getFomartDate(final Date date, final String format) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(format, DEFAULT_LOCALE).format(date);
    }
    
    /**
     * Descrption:取得当前数据库日期时间
     * @return 当前时间
     */
    public static Date getNow() {
    /*    CommonDao commonDao = (CommonDao) SpringBeanService.getBean("commonDao");
        return commonDao.selectDBSysTime();*/
        return new Date();
    }
    
    /**
     * Descrption:取得当前日期时间,格式为:yyyyMMddHHmmss
     * @return String格式化好的当前日期字符串
     */
    public static String getNowyyyyMMddHHmmss() {
        final SimpleDateFormat sdfLongTime = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdfLongTime.format(getNow());
    }
    
    /**
     * Descrption:取得当前日期,格式为:yyyyMMdd
     * @return String 格式化好的当前日期字符串
     */
    public static String getNowyyyyMMdd() {
        final SimpleDateFormat sdfShort = new SimpleDateFormat(YYYYMMDD);
        return sdfShort.format(getNow());
    }
    
    /**
     * Descrption:取得当前日期,格式为:YYYY-MM-DD
     * @return String 格式化好的当前日期字符串
     */
    public static String getNowFormateDate() {
        final SimpleDateFormat sdfLong = new SimpleDateFormat("yyyy-MM-dd");
        return sdfLong.format(getNow());
    }
    
    /**
     * Descrption:取得当前日期,格式为:yyyy-MM-dd HH:mm:ss
     * @return String 格式化好的当前日期字符串
     */
    public static String getNowPlusTime() {
        final SimpleDateFormat sdfLongTimePlus = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfLongTimePlus.format(getNow());
    }
    
    /**
     * Descrption:取得当前日期到毫秒极,格式为:yyyyMMddHHmmssSSSS
     * @return String 格式化好的日期字符串
     */
    public static String getNowPlusTimeMill() {
        final SimpleDateFormat sdfLongTimePlusMill = new SimpleDateFormat("yyyyMMddHHmmssSSSS");
        return sdfLongTimePlusMill.format(getNow());
    }
    
    /**
     * Descrption:取得日期,格式为:yyyy-MM-dd HH:mm:ss
     * @param date 需要格式化的日期
     * @return 格式化好的日期
     */
    public static String getPlusTime(final Date date) {
        final SimpleDateFormat sdfLongTimePlus = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfLongTimePlus.format(date);
    }
    
    /**
     * Descrption:取得日期,格式为:yyyy-MM-dd HH:mm:ss
     * @param time long型时间
     * @return String 格式化好的日期字符串
     */
    public static String getPlusLong(final Long time) {
        final Date date = new Date(time);
        return getFomartDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    
    /**
     * 得到当前年份值:1900
     * @return String 格式化好的日期字符串
     */
    public static String getNowYear() {
        final String strTemp = getNowyyyyMMdd();
        return strTemp.substring(0, 4);
    }
    
    /**
     * 得到当前月份值:12
     * @return String 格式化好的日期字符串
     */
    public static String getNowMonth() {
        final String strTemp = getNowyyyyMMdd();
        return strTemp.substring(4, 6);
    }
    
    /**
     * 得到当前日期值:30
     * @return String 格式化好的日期字符串
     */
    public static String getNowDay() {
        final String strTemp = getNowyyyyMMdd();
        return strTemp.substring(6, 8);
    }
    
    /**
     * 得到当前小时值:23
     * @return String 格式化好的日期字符串
     */
    public static String getNowHour() {
        final String strTemp = getNowPlusTimeMill();
        return strTemp.substring(8, 10);
    }
    
    /**
     * 根据秒数返回时分秒
     * @param second 秒数
     * @return String 格式化好的日期字符串
     */
    public static String getTimeBySecond(final String second) {
        String returnTime = "";
        long longHour = 0;
        long longMinu = 0;
        long longSec = 0;
        longSec = Long.parseLong(second);
        if (longSec == 0) {
            returnTime = "0时0分0秒";
            return returnTime;
        }
        longHour = longSec / 3600; // 取得小时数
        longSec = longSec % 3600; // 取得余下的秒
        longMinu = longSec / 60; // 取得分数
        longSec = longSec % 60; // 取得余下的秒
        returnTime = longHour + "时" + longMinu + "分" + longSec + "秒";
        return returnTime;
        
    }
    
    /**
     * 得到日期中的年份
     * @param date 日期
     * @param pattern 要转换的格式
     * @return yyyy格式的年份
     */
    public static String formatDateByPattern(final Date date, final String pattern) {
        final SimpleDateFormat df = new SimpleDateFormat(pattern, new DateFormatSymbols());
        return df.format(date);
    }
    
    /**
     * 获得中文星期几
     * @return 星期几
     */
    public static String getCurrentCnDayOfWeek() {
        final Calendar cal = Calendar.getInstance();
        final int week = cal.get(Calendar.DAY_OF_WEEK);
        return WeekCnEnum.getVal(String.valueOf(week));
    }
    
    /**
     * 获取当前年月的字符串
     * @return 当前年月，yyyyMM格式
     */
    public static String getCurrentYearMonth() {
        final Calendar cal = Calendar.getInstance();
        final String currentYear = new Integer(cal.get(Calendar.YEAR)).toString();
        String currentMonth = null;
        if (cal.get(Calendar.MONTH) < 9) {
            currentMonth = "0" + new Integer(cal.get(Calendar.MONTH) + 1).toString();
        } else {
            currentMonth = new Integer(cal.get(Calendar.MONTH) + 1).toString();
        }
        return currentYear + currentMonth;
    }
    
    /**
     * 获取当前年为整型
     * @return 获取当前日期中的年，int型
     */
    public static int getCurrentYear() {
        final Calendar cal = Calendar.getInstance();
        final int currentYear = cal.get(Calendar.YEAR);
        return currentYear;
    }
    
    /**
     * 根据身份证号码获取年龄
     * @param id 身份证号 身份证号错误时发生
     * @return int - 年龄
     */
    public static int getAge(final String id) {
        int age = -1;
        final int length = id.length();
        String birthday = "";
        if (length == 15) {
            birthday = id.substring(6, 8);
            birthday = "19" + birthday;
        } else if (length == 18) {
            birthday = id.substring(6, 10);
        } else {
            throw new BaseException("44");
        }
        final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        age = currentYear - new Integer(birthday).intValue();
        return age;
    }
    
    /**
     * 根据年龄获取出生年份
     * @param age int 年龄
     * @return Date - 出生年份
     */
    public static java.sql.Date getDateByAge(final int age) {
        final Calendar calendar = Calendar.getInstance(Locale.CHINESE);
        calendar.set(calendar.get(Calendar.YEAR) - age, calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
        return new java.sql.Date(calendar.getTimeInMillis());
    }
    
    /**
     * 比较两个日期(年月型，格式为YYYYMM)之间相差月份
     * @param dealMonth - 开始年月
     * @param alterMonth - 结束年月
     * @return alterMonth-dealMonth相差的月数
     */
    public static int calBetweenTwoMonth(final String dealMonth, final String alterMonth) {
        int length = 0;
        if (dealMonth.length() != 6 || alterMonth.length() != 6) {
            // 比较年月字符串的长度不正确
            length = -1;
            
        } else {
            final int dealInt = Integer.parseInt(dealMonth);
            final int alterInt = Integer.parseInt(alterMonth);
            if (dealInt < alterInt) {
                // 第一个年月变量应大于或等于第二个年月变量
                length = -2;
            } else {
                final int dealYearInt = Integer.parseInt(dealMonth.substring(0, 4));
                final int dealMonthInt = Integer.parseInt(dealMonth.substring(4, 6));
                final int alterYearInt = Integer.parseInt(alterMonth.substring(0, 4));
                final int alterMonthInt = Integer.parseInt(alterMonth.substring(4, 6));
                length = (dealYearInt - alterYearInt) * 12 + dealMonthInt - alterMonthInt;
            }
        }
        
        return length;
    }
    
    /**
     * 得到两个日期之间相差的天数
     * @param newDate 大的日期
     * @param oldDate 小的日期
     * @return newDate-oldDate相差的天数
     */
    public static int daysBetweenDates(final Date newDate, final Date oldDate) {
        int days = 0;
        final Calendar calo = Calendar.getInstance();
        final Calendar caln = Calendar.getInstance();
        calo.setTime(oldDate);
        caln.setTime(newDate);
        final int oday = calo.get(Calendar.DAY_OF_YEAR);
        final int nyear = caln.get(Calendar.YEAR);
        int oyear = calo.get(Calendar.YEAR);
        while (nyear > oyear) {
            calo.set(Calendar.MONTH, 11);
            calo.set(Calendar.DATE, 31);
            days = days + calo.get(Calendar.DAY_OF_YEAR);
            oyear = oyear + 1;
            calo.set(Calendar.YEAR, oyear);
        }
        final int nday = caln.get(Calendar.DAY_OF_YEAR);
        days = days + nday - oday;
        
        return days;
    }
    
    /**
     * 取得与原日期相差一定天数的日期，返回Date型日期
     * @param date 原日期
     * @param intBetween 相差的天数
     * @return date加上intBetween天后的日期
     */
    public static Date getDateBetween(final Date date, final int intBetween) {
        final Calendar calo = Calendar.getInstance();
        calo.setTime(date);
        calo.add(Calendar.DATE, intBetween);
        return calo.getTime();
    }
    
    /**
     * 得到将年月型字符串增加1月后的日期字符串
     * @param yearMonth yyyyMM格式
     * @return yearMonth增加一个月后的日期，yyyyMM格式
     */
    public static String increaseYearMonth(final String yearMonth) {
        final int year = new Integer(yearMonth.substring(0, 4)).intValue();
        int month = new Integer(yearMonth.substring(4, 6)).intValue();
        month = month + 1;
        if (month <= 12 && month >= 10) {
            return yearMonth.substring(0, 4) + new Integer(month).toString();
        } else if (month < 10) {
            return yearMonth.substring(0, 4) + "0" + new Integer(month).toString();
        } else {
            // if(month>12)
            return new Integer(year + 1).toString() + "0" + new Integer(month - 12).toString();
        }
        
    }
    
    /**
     * 得到将年月型字符串增加指定月数后的日期字符串
     * @param yearMonth yyyyMM格式日期
     * @param addMonth 增加指定月数
     * @return yearMonth 增加addMonth个月后的日期，yyyyMM格式
     */
    public static String increaseYearMonth(final String yearMonth, final int addMonth) {
        int year = new Integer(yearMonth.substring(0, 4)).intValue();
        int month = new Integer(yearMonth.substring(4, 6)).intValue();
        month = month + addMonth;
        year = year + month / 12;
        month = month % 12;
        if (month <= 12 && month >= 10) {
            return year + new Integer(month).toString();
        } else {
            return year + "0" + new Integer(month).toString();
        }
        
    }
    
    /**
     * 得到将年月型字符串减去1月后的日期字符串
     * @param yearMonth - yyyyMM格式
     * @return - yearMonth减少一个月的日期，yyyyMM格式
     */
    public static String descreaseYearMonth(final String yearMonth) {
        final int year = new Integer(yearMonth.substring(0, 4)).intValue();
        int month = new Integer(yearMonth.substring(4, 6)).intValue();
        month = month - 1;
        if (month >= 10) {
            return yearMonth.substring(0, 4) + new Integer(month).toString();
        } else if (month > 0 && month < 10) {
            return yearMonth.substring(0, 4) + "0" + new Integer(month).toString();
        } else {
            // if(month>12)
            return new Integer(year - 1).toString() + new Integer(month + 12).toString();
        }
        
    }
    
    /**
     * 字串6位，前4代表年，后2代表月， 返回给定日期中的月份中的最后一天 param term(YYYYMMDD)
     * @param term - 年月，格式为yyyyMM
     * @return String 格式化好的日期字符串 指定年月中该月份的天数
     */
    public static String getLastDay(final String term) {
        
        final int getYear = Integer.parseInt(term.substring(0, 4));
        final int getMonth = Integer.parseInt(term.substring(4, 6));
        
        String getLastDay = "";
        
        if (getMonth == 2) {
            if (getYear % 4 == 0 && getYear % 100 != 0 || getYear % 400 == 0) {
                getLastDay = "29";
            } else {
                getLastDay = "28";
            }
        } else if (getMonth == 4 || getMonth == 6 || getMonth == 9 || getMonth == 11) {
            getLastDay = "30";
        } else {
            getLastDay = "31";
        }
        return String.valueOf(getYear) + "年" + String.valueOf(getMonth) + "月" + getLastDay + "日";
    }
    
    /**
     * 返回两个年月(例如：200206)之间相差的月数，年月格式为yyyyMM
     * @param strDateBegin - String
     * @param strDateEnd String
     * @return String 格式化好的日期字符串 strDateEnd-strDateBegin相差的月数
     */
    public static String getMonthBetween(final String strDateBegin, final String strDateEnd) {
        int intMonthBegin;
        int intMonthEnd;
        String strOut;
        if (strDateBegin.equals("") || strDateEnd.equals("") || strDateBegin.length() != 6 || strDateEnd.length() != 6) {
            strOut = "";
        } else {
            intMonthBegin = Integer.parseInt(strDateBegin.substring(0, 4)) * 12 + Integer.parseInt(strDateBegin.substring(4, 6));
            intMonthEnd = Integer.parseInt(strDateEnd.substring(0, 4)) * 12 + Integer.parseInt(strDateEnd.substring(4, 6));
            strOut = String.valueOf(intMonthBegin - intMonthEnd);
        }
        return strOut;
        
    }
    
    /**
     * 将yyyyMMDD格式的日期转换为yyyy-MM-DD格式的日期 返回带'-'的日期(例如：20020612 转换为 2002-06-12)
     * @param strDate String yyyyMMDD格式的日期
     * @return String 格式化好的日期字符串 - yyyy-MM-DD格式的日期
     */
    public static String getStrHaveAcross(final String strDate) {
        return strDate.substring(0, 4) + "-" + strDate.substring(4, 6) + "-" + strDate.substring(6, 8);
    }
    
    /**
     * 取得当前日期的下一个月的第一天
     * @return 当前日期的下个月的第一天，格式为yyyyMMDD
     */
    public static String getFirstDayOfNextMonth() {
        return increaseYearMonth(getNowyyyyMMdd().substring(0, 6)) + "01";
    }
    
    /**
     * 取得当前日期的下一个月的第一天
     * @return 当前日期的下个月的第一天，格式为yyyyMMDD
     */
    public static String getFirstDayOfThisMonth() {
        return getNowyyyyMMdd().substring(0, 6) + "01";
    }
    
    /**
     * 将yyyyMM各式转换成yyyy年MM月格式
     * @param yearMonth 年月类型的字符串
     * @return String 格式化好的日期字符串
     */
    public static String getYearAndMonth(final String yearMonth) {
        if (null == yearMonth) {
            return "";
        }
        final String ym = yearMonth.trim();
        if (6 != ym.length()) {
            return ym;
        }
        final String year = ym.substring(0, 4);
        final String month = ym.substring(4);
        return new StringBuffer(year).append("年").append(month).append("月").toString();
    }
    
    /**
     * 将输入的Integer类型的月数转化成"X年X月"格式的字符串
     * @param month Integer
     * @return String 格式化好的日期字符串
     */
    public static String month2YearMonth(final String month) {
        String yearMonth = "";
        int smonth = 0;
        int year = 0;
        int rmonth = 0;
        
        if (null == month || "0".equals(month) || "".equals(month.trim())) {
            return "0月";
        }
        
        smonth = Integer.parseInt(month);
        year = smonth / 12;
        rmonth = smonth % 12;
        
        if (year > 0) {
            yearMonth = year + "年";
        }
        if (rmonth > 0) {
            yearMonth += rmonth + "个月";
        }
        
        return yearMonth;
    }
    
    /**
     * 将yyyyMM各式转换成yyyy年MM月格式
     * @param month 月
     * @return 返回年月型格式的日期
     */
    public static String getYearMonthByMonth(final String month) {
        if (null == month) {
            return null;
        }
        final String ym = month.trim();
        if (6 != ym.length()) {
            return ym;
        }
        final String year = ym.substring(0, 4);
        final String month1 = ym.substring(4);
        return new StringBuffer(year).append("年").append(month1).append("月").toString();
    }
    
    /**
     * 得到将date增加指定月数后的date
     * @param date 日期
     * @param intBetween 增加的月份
     * @return date 加上intBetween月数后的日期
     */
    public static Date increaseMonth(final Date date, final int intBetween) {
        final Calendar calo = Calendar.getInstance();
        calo.setTime(date);
        calo.add(Calendar.MONTH, intBetween);
        return calo.getTime();
    }
    
    /**
     * 得到将date增加指定天数后的date
     * @param date 日期
     * @param intBetween 增加的天数
     * @return date 加上intBetween天数后的日期
     */
    public static Date increaseDay(final Date date, final int intBetween) {
        final Calendar calo = Calendar.getInstance();
        calo.setTime(date);
        calo.add(Calendar.DATE, intBetween);
        return calo.getTime();
    }
    
    /**
     * 得到将date增加指定分钟后的date
     * @param date 日期
     * @param intBetween 增加的分钟
     * @return date 加上intBetween分钟后的日期
     */
    public static Date increaseMinute(final Date date, final int intBetween) {
        final Calendar calo = Calendar.getInstance();
        calo.setTime(date);
        calo.add(Calendar.MINUTE, intBetween);
        return calo.getTime();
    }
    
    /**
     * 得到将date增加指定秒后的date
     * @param date 日期
     * @param intBetween 增加的秒
     * @return date 加上intBetween分钟后的日期
     */
    public static Date increaseSecond(final Date date, final int intBetween) {
        final Calendar calo = Calendar.getInstance();
        calo.setTime(date);
        calo.add(Calendar.SECOND, intBetween);
        return calo.getTime();
    }
    
    /**
     * 得到将date增加指定年数后的date
     * @param date 日期
     * @param intBetween 增加的年数
     * @return date加上intBetween年数后的日期
     */
    public static Date increaseYear(final Date date, final int intBetween) {
        final Calendar calo = Calendar.getInstance();
        calo.setTime(date);
        calo.add(Calendar.YEAR, intBetween);
        return calo.getTime();
    }
    
    /**
     * 比较两个时间先后
     * @param str1 传入的字符串
     * @param str2 传入的字符串
     * @return int negative integer, zero, or a positive integer as str1 is less
     *         than, equal to, or greater than str2
     */
    public static int compareDate(final String str1, final String str2) {
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date1;
        Date date2;
        try {
            date1 = formatter.parse(str1);
        } catch (final ParseException e) {
            throw new BaseException("42", e, new Object[] { str1, "yyyy/MM/dd HH:mm:ss" });
        }
        try {
            date2 = formatter.parse(str2);
        } catch (final ParseException e) {
            throw new BaseException("42", e, new Object[] { str1, "yyyy/MM/dd HH:mm:ss" });
        }
        return date1.compareTo(date2);
    }
    
    /**
     * 得到当前日期，格式yyyy-MM-dd。
     * @return String 格式化好的日期字符串 格式化的日期字符串
     */
    public static String getYesterday() {
        final Date cDate = getNow();
        cDate.setTime(cDate.getTime() - 24 * 3600 * 1000);
        final SimpleDateFormat cSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return cSimpleDateFormat.format(cDate);
    }
    
    /**
     * 得到当前日期，格式yyyy-MM-dd。
     * @return String 格式化好的日期字符串 格式化的日期字符串
     */
    public static String getTomorrow() {
        final Date cDate = getNow();
        cDate.setTime(cDate.getTime() + 24 * 3600 * 1000);
        final SimpleDateFormat cSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return cSimpleDateFormat.format(cDate);
    }
    
    /**
     * 得到当前日期，格式yyyy-MM-dd。
     * @return String 格式化好的日期字符串 格式化的日期字符串
     */
    public static Date getTodayLastSecond(Date d) {
        
        d.setTime(d.getTime() + 24 * 3600 * 1000 - 1000);
        return d;
    }
    
    /**
     * 返回默认的功能生效的时间，1900/01/01。
     * @return String 格式化好的日期字符串 默认的实效时间字符串
     */
    public static String getDefaultValidDate() {
        return "1900-01-01";
    }
    
    /**
     * 返回默认的功能失效的时间，2099/12/31。
     * @return String 格式化好的日期字符串 默认的实效时间字符串
     */
    public static String getDefaultExpireDate() {
        return "2099-12-31";
    }
    
    /**
     * 得到指定的日期，如一年三个月零九天后(以yyyy/MM/dd格式显示)参数为("yyyy/MM/dd",1,3,9)
     * @param strFormat strFormat
     * @param iYear iYear
     * @param iMonth iMonth
     * @param iDate iDate
     * @return String 格式化好的日期字符串
     */
    public static String getSpecDate(final String strFormat, final int iYear, final int iMonth, final int iDate) {
        final Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.YEAR, rightNow.get(Calendar.YEAR) + iYear);
        rightNow.set(Calendar.MONTH, rightNow.get(Calendar.MONTH) + iMonth);
        rightNow.set(Calendar.DATE, rightNow.get(Calendar.DATE) + iDate);
        final SimpleDateFormat df = new SimpleDateFormat(strFormat);
        return df.format(rightNow.getTime());
    }
    
    /**
     * 得出两个日期之间的间隔天数
     * @param strFromDate 格式为yyyyMMdd
     * @param strToDate 格式为yyyyMMdd
     * @return int
     */
    public static int getBetweenDays(final String strFromDate, final String strToDate) {
        final Calendar clFrom = new GregorianCalendar();
        int iYear = Integer.parseInt(strFromDate.substring(0, 4));
        int iMonth = Integer.parseInt(strFromDate.substring(4, 6));
        int iDay = Integer.parseInt(strFromDate.substring(6, 8));
        clFrom.set(iYear, iMonth, iDay, 0, 0, 0);
        final Calendar clTo = new GregorianCalendar();
        iYear = Integer.parseInt(strToDate.substring(0, 4));
        iMonth = Integer.parseInt(strToDate.substring(4, 6));
        iDay = Integer.parseInt(strToDate.substring(6, 8));
        clTo.set(iYear, iMonth, iDay, 0, 0, 0);
        final long llTmp = clTo.getTime().getTime() - clFrom.getTime().getTime();
        return new Long(llTmp / 1000 / 3600 / 24).intValue();
    }
    
    /**
     * @Title: getEndOfDay
     * @Description:获取一天的最后一毫秒时间，凌晨
     * @param day 日期
     * @return 一天的结束
     */
    public static Date getEndOfDay(final Date day) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMaximum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMaximum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMaximum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMaximum(Calendar.MILLISECOND));
        return cal.getTime();
    }
    
    /**
     * @Title: getStartOfDay
     * @Description: 获取一天的开始
     * @param day 日期
     * @return 一天的开始
     */
    public static Date getStartOfDay(final Date day) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }
    
    /**
     * @Title: getNoonOfDay
     * @Description: 获取一天的中午
     * @param day 日期
     * @return 一天的中午
     */
    public static Date getNoonOfDay(final Date day) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
        cal.set(Calendar.SECOND, cal.getMinimum(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, cal.getMinimum(Calendar.MILLISECOND));
        return cal.getTime();
    }
    
    /**
     * @Title: now
     * @Description: 返回当前时间，java.sql.Timestamp
     * @return java.sql.Timestamp
     */
    public static Timestamp now() {
        return new Timestamp(getNow().getTime());
    }
    
    /**
     * 获得该日期的月的天数
     * @param date 日期
     * @return 当月多少天
     */
    public static int getDaysOfMonth(final Date date) {
        final Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        final int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 天数
        return days;
    }
    
    /**
     * 获得当前月
     * @param date 日期
     * @return 当前月
     */
    public static int getMonthFromDate(final Date date) {
        final Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        final int month = calendar.get(Calendar.MONTH) + 1; // 月份
        return month;
    }
    
    /**
     * 获得每月第一天
     * @param date 日期
     * @return 每月开始
     */
    public static String getBeginOfMonth(final Date date) {
        final int year = Integer.parseInt(formatDateByPattern(date, YYYY));
        final int month = getMonthFromDate(date);
        final String result = year + "-" + month + "-01 00:00:00";
        return result;
    }
    
    /**
     * 获取每月结束
     * @param date 日期
     * @return 每月结束
     */
    public static String getEndOfMonth(final Date date) {
        final int year = Integer.parseInt(formatDateByPattern(date, YYYY));
        final int month = getMonthFromDate(date);
        final int days = getDaysOfMonth(date);
        final String result = year + "-" + month + "-" + days + " 23:59:59";
        return result;
    }
    
    /**
     * @Title: getTimestampFormat
     * @Description: 根据字符长度判断日期的格式化类型
     * @param value 日期字符串
     * @return String 日期的格式
     */
    public static String getTimestampFormat(final String value) {
        String targetFormat = null;
        if (value.contains("-")) {
            if (value.lastIndexOf("-") > 4) {
                if (value.contains(" ")) {
                    if (value.contains(":")) {
                        if (value.indexOf(":") < value.lastIndexOf(":")) {
                            if (value.contains(".")) {
                                targetFormat = "yyyy-MM-dd HH:mm:ss.S";
                            } else {
                                targetFormat = "yyyy-MM-dd HH:mm:ss";
                            }
                        } else {
                            targetFormat = "yyyy-MM-dd HH:mm";
                        }
                    } else {
                        targetFormat = "yyyy-MM-dd HH";
                    }
                } else {
                    targetFormat = "yyyy-MM-dd";
                }
            } else {
                targetFormat = "yyyy-MM";
            }
        } else {
            switch (value.length()) {
            case 4: // '\004'
                targetFormat = "yyyy";
                break;
            case 6: // '\006'
                targetFormat = "yyyyMM";
                break;
            case 8: // '\b'
                targetFormat = "yyyyMMdd";
                break;
            case 12:
                targetFormat = "yyyyMMddHHmm";
                break;
            case 14:
                targetFormat = "yyyyMMddHHmmss";
                break;
            default:
                targetFormat = null;
                break;
            }
        }
        return targetFormat;
    }
    
    public static int getCurrentMonth()
    {
    	return Calendar.getInstance().get(Calendar.MONTH);
    }
}
