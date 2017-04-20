package com.cs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系統辨認工具
 * 
 * @author leo
 */
public class OSValidator implements AutoCloseable {
	private static final Logger	LOG	= LoggerFactory.getLogger(OSValidator.class);

	public boolean isWindows() {
		String os = System.getProperty("os.name").toLowerCase();
		LOG.debug(" is windows:" + (os.indexOf("win") >= 0));
		// windows
		return (os.indexOf("win") >= 0);
	}

	public boolean isMac() {
		String os = System.getProperty("os.name").toLowerCase();
		LOG.debug(" is mac:" + (os.indexOf("mac") >= 0));
		// Mac
		return (os.indexOf("mac") >= 0);
	}

	public boolean isUnix() {
		String os = System.getProperty("os.name").toLowerCase();
		LOG.debug(" is mac:" + (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0));
		// linux or unix
		return (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0);
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
}
