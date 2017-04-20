package com.cs.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 從request取得 資料判斷是否為空值
 * 
 * @author Leo
 */
public class RequestParameterUtil implements AutoCloseable {
	private static final Logger	LOG	= LoggerFactory.getLogger(RequestParameterUtil.class);

	/**
	 * 從request取得 boolean 型態資料
	 * @param request 請求
	 * @param parameterName 解析資料名稱
	 * @return boolean (parameterName==null) false  || (parameterName!=null) 取出的值
	 */
	public static boolean getBooleanParameter(HttpServletRequest request, String parameterName) {
		
		try{
			boolean rs = Boolean.valueOf(request.getParameter(parameterName)!=null?request.getParameter(parameterName):"false").booleanValue(); 
			return rs;
		}catch(NullPointerException n){
			LOG.debug("parameterName is null ===>["+parameterName+"]<===");
			return false;
		}
	}
	
	/**
	 * 從request取得 String 型態資料
	 * @param request 請求
	 * @param parameterName 解析資料名稱
	 * @return String (parameterName==null) 空字串  || (parameterName!=null) 取出的值
	 */
	public static String getStringParameter(HttpServletRequest request, String parameterName) {
		try{
			String rs = request.getParameter(parameterName)!=null?request.getParameter(parameterName):""; 
			return rs;
		}catch(NullPointerException n){
			LOG.debug("parameterName is null ===>["+parameterName+"]<===");
			return "";
		}
	}
	
	/**
	 * 從request取得 int 型態資料
	 * @param request 請求
	 * @param parameterName 解析資料名稱
	 * @return int (parameterName==null) 空字串  || (parameterName!=null) 取出的值
	 */
	public static int getIntParameter(HttpServletRequest request, String parameterName) {
		try{
			int rs = Integer.valueOf(request.getParameter(parameterName)!=null?request.getParameter(parameterName):"0").intValue(); 
			return rs;
		}catch(NullPointerException n){
			LOG.debug("parameterName is null ===>["+parameterName+"]<===");
			return 0;
		}
	}

	
	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
}
