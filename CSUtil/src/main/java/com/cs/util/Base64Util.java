package com.cs.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Base64相關工具
 * 
 * @author leo
 */
public class Base64Util implements AutoCloseable {
	private static final Logger	LOG	= LoggerFactory.getLogger(Base64Util.class);

	/**
	 * 將字串編成 Base64 回傳
	 * 
	 * @param String str
	 * @return
	 */
	public String getEncodeBASE64String(String str) {
		if (str == null) {
			return null;
		}
		// 使用Base64進行字串解碼
		Base64 base64 = new Base64();
		String encodeString = new String(base64.encode(str.getBytes()));
		LOG.debug(" EncodeBASE64 :" + encodeString);
		return encodeString;
	}

	/**
	 * 將 Base64字串解碼回傳
	 * 
	 * @param String str
	 * @return
	 */
	public String getDecodeBASE64String(String str) {
		if (str == null) {
			return null;
		}
		// 使用Base64進行字串解碼
		Base64 base64 = new Base64();
		String decodeString = new String(base64.decode(str.getBytes()));
		LOG.debug(" DecodeBASE64 :" + decodeString);
		return decodeString;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
}
