package com.cs.util;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/***
 * use Command ( windows or linux ) 執行指令 完畢後自動關閉檔案
 * 
 * @author childhood-leo
 */
public class SystemCommand implements AutoCloseable {
	private static final Logger	LOG	= LoggerFactory.getLogger(SystemCommand.class);

	public void ExecCommand(String cmd) {
		LOG.debug("Exec command: " + cmd);
		try {
			Process pro = null;
			Runtime runTime = Runtime.getRuntime();
			if (runTime == null) {
				LOG.debug("Create runtime false!");
				throw new RuntimeException("Create runtime false!");
			}
			pro = runTime.exec(cmd);
			BufferedReader input = new BufferedReader(new InputStreamReader(pro.getInputStream()));
			PrintWriter output = new PrintWriter(new OutputStreamWriter(pro.getOutputStream()));
			String line;
			while ((line = input.readLine()) != null) {
				LOG.debug(line);
			}
			input.close();
			output.close();
			pro.destroy();
		}
		catch (IOException e) {
			e.printStackTrace();
			LOG.error(e.getMessage(), e);
			throw new RuntimeException("run command error!");
		}
		LOG.debug("Exec command: " + cmd + " finish.");
	}

	@Override
	public void close() throws Exception {
	}
}