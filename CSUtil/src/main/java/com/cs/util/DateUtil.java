package com.cs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.shacom.common.constant.TFEConstant;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
public class DateUtil implements AutoCloseable {
	private static final Logger	LOG										= LoggerFactory.getLogger(DateUtil.class);
	public static final String	EMPTY_STRING							= "";
	// Date format(西元)
	public static final String	DATE_FORMAT_STRING_yyyyMMddHHmmssSSS	= "yyyyMMddHHmmssSSSS";
	public static final String	DATE_FORMAT_STRING_yyyyMMddHHmmss		= "yyyyMMddHHmmss";
	public static final String	DATE_FORMAT_STRING_yyyyMMddHHmm			= "yyyyMMddHHmm";
	public static final String	DATE_FORMAT_STRING_yyyyMMddHHmmss_SLASH	= "yyyy/MM/dd HH:mm:ss";
	public static final String	DATE_FORMAT_STRING_yyyyMMdd				= "yyyyMMdd";
	public static final String	DATE_FORMAT_STRING_yyyyMMddHH			= "yyyyMMddHH";
	public static final String	DATE_FORMAT_STRING_yyyyMM				= "yyyyMM";
	public static final String	DATE_FORMAT_STRING_MMdd					= "MMdd";

	/**
	 * 字串轉成日期格式
	 * 
	 * @param dateString 要解析日期字串
	 * @param formatString 格式化樣式
	 * @return Date 日期
	 * @throws ParseException
	 */
	public static Date convertToDate(String dateString, String formatString) throws ParseException {
		Date returnDate = null;
		if (null != dateString && null != formatString && !EMPTY_STRING.equals(dateString) && !EMPTY_STRING.equals(formatString)) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatString);
			returnDate = sdf.parse(dateString);
		}
		return returnDate;
	}

	/**
	 * 日期轉成字串格式
	 * 
	 * @param date 日期
	 * @param formatString 格式化樣式
	 * @return String 字串
	 */
	public static String convertToString(Date date, String formatString) {
		String returnString = EMPTY_STRING;
		if (null != date && null != formatString && !EMPTY_STRING.equals(formatString)) {
			SimpleDateFormat sdf = new SimpleDateFormat(formatString);
			returnString = sdf.format(date);
		}
		LOG.debug(" convertToString:" + returnString);
		return returnString;
	}

	/**
	 * 為特定時間增加天數
	 * 
	 * @param date 日期
	 * @param increment 增加天數
	 * @return Date 日期
	 */
	public static Date addDate(Date date, int increment) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		dateCal.add(Calendar.DATE, increment);
		return dateCal.getTime();
	}

	/**
	 * 為特定時間增加月數
	 * 
	 * @param date 日期
	 * @param increment 增加月數
	 * @return Date 日期
	 */
	public static Date addMonth(Date date, int increment) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		dateCal.add(Calendar.MONTH, increment);
		return dateCal.getTime();
	}

	/**
	 * 為特定時間增加年數
	 * 
	 * @param date 日期
	 * @param increment 增加年數
	 * @return Date 日期
	 */
	public static Date addYear(Date date, int increment) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		dateCal.add(Calendar.YEAR, increment);
		return dateCal.getTime();
	}

	/**
	 * 為特定時間增加分鐘數
	 * 
	 * @param date 日期
	 * @param increment 增加分鐘數
	 * @return Date 日期
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		dateCal.add(Calendar.MINUTE, minute);
		return dateCal.getTime();
	}

	/**
	 * 為特定字串時間增加天數
	 * 
	 * @param dateString 要解析日期字串
	 * @param formatString 格式化樣式
	 * @param increment 增加天數
	 * @return String 日期字串
	 * @throws ParseException
	 */
	public static String addDateToString(String dateString, String formatString, int increment) throws ParseException {
		Date date = convertToDate(dateString, formatString);
		date = addDate(date, increment);
		return convertToString(date, formatString);
	}

	/**
	 * 為特定字串時間增加天數
	 * 
	 * @param dateString 要解析日期字串
	 * @param formatString 格式化樣式
	 * @param increment 增加天數
	 * @return Date 日期
	 * @throws ParseException
	 */
	public static Date addDateForString(String dateString, String formatString, int increment) throws ParseException {
		Date date = convertToDate(dateString, formatString);
		date = addDate(date, increment);
		return date;
	}

	/**
	 * 為特定字串時間增加天數
	 * 
	 * @param Date 日期
	 * @param formatString 格式化樣式
	 * @param increment 增加天數
	 * @return String 日期字串
	 * @throws ParseException
	 */
	public static String addDateConvertToString(Date date, String formatString, int increment) throws ParseException {
		date = addDate(date, increment);
		return convertToString(date, formatString);
	}

	/**
	 * 取得差異天數
	 * 
	 * @param endDate
	 * @param startDate
	 * @return long 差異天數
	 */
	public static long getDateDifference(Date endDate, Date startDate) {
		Calendar dateCal1 = Calendar.getInstance();
		dateCal1.setTime(endDate);
		Calendar dateCal2 = Calendar.getInstance();
		dateCal2.setTime(startDate);
		long difference = dateCal1.getTimeInMillis() - dateCal2.getTimeInMillis();
		long day = difference / (3600 * 24 * 1000);
		return day;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
}
