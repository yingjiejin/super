package utils;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public final class DateUtil {

	public static final String YEAR = "year";
	public static final String MON = "month";
	public static final String DAY = "day";
	public static final String HOUR = "hour";
	public static final String MIN = "minute";
	public static final String SECOND = "second";
	public static final String MILLIS = "millisecond";
	public static final String DATE_STRING_FORMAT = "yyyy-MM-dd";
	public static final String SHORT_DATE_STRING_FORMAT = "yyyyMMdd";
	private static final String TIME_STRING_FORMAT = "yyyy-MM-dd HH:mm:ss";
	public static final String TIME_STRING_FORMAT2 = "yyyy-MM-dd HH:mm";

	private DateUtil() {
	}

	/**
	 * 根据预告日期得出预告的周
	 *
	 * @param date
	 * @return
	 */
	public static String getWeekByDate(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_STRING_FORMAT);
		SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE", Locale.CHINA);
		String week = "";
		if (null != date && !"".equals(date)) {
			try {
				Date tempDate = dateFormat.parse(date);
				week = weekFormat.format(tempDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return week;
	}

	/**
	 * 格式化日期 (格式:yyyy-MM-dd HH:mm:ss)
	 *
	 * @param inDate 要格式化的日期
	 * @return 格式化后的日期
	 */
	public final static String formatDate2Str(Date inDate) {
		if (DataUtil.isValidData(inDate)) {
			SimpleDateFormat sf = new SimpleDateFormat(TIME_STRING_FORMAT);
			return sf.format(inDate);
		}
		return null;
	}

	/**
	 * 格式化日期 (格式:yyyy-MM-dd HH:mm:ss)
	 *
	 * @return 格式化后的日期
	 */
	public final static String formatDate2Str() {
		return formatDate2Str(new Date(), TIME_STRING_FORMAT);
	}

	/**
	 * 根据指定都日期格式格式化日期 格式化日期 (格式:yyyy-MM-dd HH:mm:ss)
	 *
	 * @param inDate 要格式化的日期
	 * @return 格式化后的日期
	 */
	public final static String formatDate2Str(Date inDate, String format) {
		if (DataUtil.isValidData(inDate)) {
			SimpleDateFormat sf = new SimpleDateFormat(format);
			return sf.format(inDate);
		}
		return null;
	}

	public final static String formatDate2Date(String inDate)
		throws ParseException {
		return formatDate2Date(inDate, DATE_STRING_FORMAT);
	}

	/**
	 * 格式化日期 (格式:format)
	 *
	 * @param inDate 要格式化的日期
	 * @param format 格式化的格式
	 * @return 格式化后的日期
	 * @throws ParseException
	 */
	public final static String formatDate2Date(String inDate, String format)
		throws ParseException {
		Date date = string2Date(inDate);
		SimpleDateFormat sf = new SimpleDateFormat(format);
		String strDate = sf.format(date);
		return strDate;
	}

	/**
	 * 得到当前日期
	 *
	 * @return String型日期
	 */
	public final static String getDayStr() {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(DATE_STRING_FORMAT);
		return sf.format(date);
	}

	/**
	 * 得到当前日期
	 *
	 * @return Date型日期
	 * @throws ParseException
	 */
	public final static Date getDate() throws ParseException {
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat(DATE_STRING_FORMAT);
		String strDate = sf.format(date);
		return sf.parse(strDate);
	}

	/**
	 * Calendar转化为Date
	 *
	 * @return Date型日期
	 */
	public final static Date calendar2Date() {
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();
		return date;
	}

	/**
	 * Date转化为Calendar
	 *
	 * @return Calendar型日期
	 */
	public final static Calendar date2Calendar() {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}

	/**
	 * UtilDate转化为SqlDate
	 *
	 * @return SqlDate型日期
	 */
	public final static java.sql.Date UtilDate2SqlDate(Date date) {
		return new java.sql.Date(date.getTime());
	}

	/**
	 * 将字符串类型的日期转换为一个Date（java.sql.Date）
	 *
	 * @param dateString 需要转换为Date的字符串
	 * @return dataTime Date
	 */
	public final static java.sql.Date string2SqlDate(String dateString)
		throws Exception {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(DATE_STRING_FORMAT, Locale.ENGLISH);
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());// sql类型
		return dateTime;
	}

	/**
	 * 将字符串类型的日期转换为一个Date（java.util.Date）
	 *
	 * @param dateString 需要转换为Date的字符串
	 * @return dataTime Date
	 */
	public final static Date string2Date(String dateString) throws ParseException {
		if (DataUtil.isValidData(dateString)) {
			// 若只有年月日则加上时分秒
			if (dateString.trim().length() == 10) {
				dateString += " 00:00:00";
			}
		}
		return string2Date(dateString,DATE_STRING_FORMAT);
	}

	/**
	 * 将字符串类型的日期转换为一个Date（java.util.Date）
	 *
	 * @param dateString 需要转换为Date的字符串
	 * @param format     格式化的格式
	 * @return dataTime Date
	 * @throws ParseException
	 */
	public final static Date string2Date(String dateString
		, String format) throws ParseException {

		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat(format);
		dateFormat.setLenient(false);
		Date timeDate = null;
		try {
			timeDate = dateFormat.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return timeDate;
	}

	/**
	 * 将字符串类型的日期转换为一个timestamp（时间戳记java.sql.Timestamp）
	 *
	 * @param dateString 需要转换为timestamp的字符串
	 * @return dataTime timestamp
	 */
	public final static java.sql.Timestamp string2Time(String dateString)
		throws ParseException {
		DateFormat dateFormat;
		dateFormat = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss.SSS",
			Locale.ENGLISH);// 设定格式
		dateFormat.setLenient(false);
		Date timeDate = dateFormat.parse(dateString);// util类型
		java.sql.Timestamp dateTime = new java.sql.Timestamp(timeDate.getTime());// Timestamp类型,timeDate.getTime()返回一个long型
		return dateTime;
	}

	/**
	 * 计算两个任意时间中间的间隔天数（这个比较常用）
	 *
	 * @param startday Calendar型起始日期
	 * @param endday   Calendar型终止日期
	 * @return int 天数
	 */
	public final static int getIntervalDays(Calendar startday, Calendar endday) {
		if (startday.after(endday)) {
			Calendar cal = startday;
			startday = endday;
			endday = cal;
		}
		long sl = startday.getTimeInMillis();
		long el = endday.getTimeInMillis();

		long ei = el - sl;
		return (int) (ei / (1000 * 60 * 60 * 24));
	}

	/**
	 * 计算两个任意时间中间的间隔天数（这个比较常用）
	 *
	 * @param startday Date型起始日期
	 * @param endday   Date型终止日期
	 * @return int 天数
	 */
	public final static int getIntervalDays(Date startday, Date endday) {
		if (startday.after(endday)) {
			Date cal = startday;
			startday = endday;
			endday = cal;
		}
		long sl = startday.getTime();
		long el = endday.getTime();
		long ei = el - sl;
		return (int) (ei / (1000 * 60 * 60 * 24));
	}
	
	/**
	 * 计算 时间差距 不交换开始时间和结束时间顺序
	 */
	public final static int getIntervalDaysNochangeOrder(Date startday, Date endday) {
		
		long sl = startday.getTime();
		long el = endday.getTime();
		long ei = el - sl;
		return (int) (ei / (1000 * 60 * 60 * 24));
	}
	/**
	 * 计算两个任意时间中间的间隔天数 改进精确计算相隔天数的方法
	 *
	 * @param d1 Calendar型日期
	 * @param d2 Calendar型日期
	 * @return int 天数
	 */
	public final static int getDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) {
			Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(Calendar.DAY_OF_YEAR) - d1.get(Calendar.DAY_OF_YEAR);
		int y2 = d2.get(Calendar.YEAR);
		if (d1.get(Calendar.YEAR) != y2) {
			d1 = (Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(Calendar.DAY_OF_YEAR);// 得到当年的实际天数
				d1.add(Calendar.YEAR, 1);
			} while (d1.get(Calendar.YEAR) != y2);
		}
		return days;
	}

	/**
	 * 计算两个任意时间中间的间隔 （根据type返回天数、小时数、分钟数、秒数与毫秒数）
	 *
	 * @param startDay Date型起始日期
	 * @param endDay   Date型终止日期
	 * @param type     类型
	 * @return int 天数、小时数、分钟数、秒数与毫秒数
	 */
	public final static int getIntervalNo(Date startDay, Date endDay,
																				String type) {
		if (startDay.after(endDay)) {
			Date cal = startDay;
			startDay = endDay;
			endDay = cal;
		}
		int no = 0;
		long sl = startDay.getTime();
		long el = endDay.getTime();
		long ei = el - sl;
		// 返回天数
		if (DAY.equals(type)) {
			no = (int) (ei / (1000 * 60 * 60 * 24));
		}
		// 返回小时数
		else if (HOUR.equals(type)) {
			no = (int) (ei / (1000 * 60 * 60));
		}
		// 返回分钟数
		else if (MIN.equals(type)) {
			no = (int) (ei / (1000 * 60));
		}
		// 返回秒数
		else if (SECOND.equals(type)) {
			no = (int) (ei / (1000));
		}
		// 返回毫秒数
		else {
			no = (int) ei;
		}

		return no;
	}

	/**
	 * 计算一当前时间前与现在的间隔
	 *
	 * @param dateString String型日期
	 * @return String 天数、小时数、分钟数、秒数与毫秒数
	 */
	public final static String getIntervalNow(String dateString) {
		String strback = "";
		Date now = new Date();
		try {
			Date date = string2Date(dateString);
			int no = 0;
			if (date.after(now)) {
				strback = "所传时间在当前时间之前，所传时间不正确。";
			} else {
				// 判断天数
				no = getIntervalNo(date, now, "day");
				if (no != 0) {
					strback = no + "天前";
				} else {
					// 判断小时数
					no = getIntervalNo(date, now, "hour");
					if (no != 0) {
						strback = no + "小时前";
					} else {
						// 判断分钟数
						no = getIntervalNo(date, now, "minute");
						if (no != 0) {
							strback = no + "分钟前";
						} else {
							// 判断秒数
							no = getIntervalNo(date, now, "second");
							strback = no + "秒";
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return strback;
	}

	/**
	 * 得到现在的年
	 *
	 * @return
	 */
	public static Integer getYear() {
		Calendar calendar = Calendar.getInstance();
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 得到现在的月
	 *
	 * @return
	 */
	public static Integer getMonth() {
		Calendar calendar = Calendar.getInstance();
		int month = calendar.get(Calendar.MONTH);
		return month + 1;
	}

	/**
	 * 得到现在的日
	 *
	 * @return
	 */
	public static Integer getDay() {
		Calendar calendar = Calendar.getInstance();

		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	public static Integer getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * the sourceDate is the small one and destDate is the big one
	 * @param sourceDate the small one
	 * @param destDate   the big one
	 * @return boolean
	 */
	public static boolean compareTo(Date sourceDate, Date destDate) {
		return sourceDate.getTime() < destDate.getTime();
	}

	/**
	 * 得到本月第一天日期
	 */
	public static Date getFirstDayMonth() {
		// 本月的第一天
		Calendar calendar = new GregorianCalendar();
		Date time = calendar.getTime();
		String date2Str = formatDate2Str(time, DATE_STRING_FORMAT) + " 00:00:00";
		try {
			Date date00 = string2Date(date2Str, TIME_STRING_FORMAT);
			return getFirstDayMonth(date00);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到给定日期当月的第一天
	 *
	 * @param date
	 * @return
	 */
	public static Date getFirstDayMonth(Date date) {
		// 本月的第一天
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		return calendar.getTime();
	}

	/**
	 * 得到本月最后一天
	 *
	 * @return
	 */
	public static Date getLastDayMonth() {
		Calendar calendar = new GregorianCalendar();
		Date time = calendar.getTime();
		String date2Str = formatDate2Str(time, DATE_STRING_FORMAT) + " 23:59:59";
		try {
			Date date23 = string2Date(date2Str, TIME_STRING_FORMAT);
			return getLastDayMonth(date23);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 得到指定日期月的最后一天日期
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastDayMonth(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DATE, 1);
		calendar.roll(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * get the first second of special date
	 *
	 * @param date
	 * @return
	 */
	public static Date getFirstSecondOfThisHour(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * get the last second of special date
	 *
	 * @param date
	 * @return
	 */
	public static Date getLastSecondOfThisHour(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	public static Date getFirstSecondOfThisMinute(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getFirstSecondOfThisDate(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getLastSecondOfThisDate(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	public static Date getDayOfLastDate(Date date) {
		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH,
			calendar.get(Calendar.DAY_OF_MONTH) - 1);
		return calendar.getTime();
	}

	public static Date getFirstSecondOfSomeMinutesLater(Date date
		, Integer offset) {

		if (date == null) {
			date = new Date();
		}
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + offset);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	public static Date getGMTDate(Date date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));

		try {
			return df.parse(df.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date someDaysLater(Date date, int day) {
		DateTime dateTime = new DateTime(date);
		return dateTime.plusDays(day).toDate();
	}
}
