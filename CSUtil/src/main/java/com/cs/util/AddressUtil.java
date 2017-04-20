package com.cs.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 取得server or client IP
 * 
 * @author Leo
 */
public class AddressUtil implements AutoCloseable {
	private static final Logger	LOG	= LoggerFactory.getLogger(AddressUtil.class);

	/**
	 * 取得ServerIp
	 */
	public String getServerAddress() {
		try {
			InetAddress ip;
			ip = InetAddress.getLocalHost();
			LOG.debug(" ServerAddress IP address : " + ip.getHostAddress());
			return ip.getHostAddress();
		}
		catch (UnknownHostException e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
	}

	/**
	 * 取得ClientIp
	 */
	public String getClientAddress(HttpServletRequest request) {
		String ipAddress = request.getRemoteAddr();
		// is client behind something?
		ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			ipAddress = request.getRemoteAddr();
		}
		LOG.debug(" ClientAddress IP address : " + ipAddress);
		return ipAddress;
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
}
