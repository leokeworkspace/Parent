package com.cs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;





import com.cs.junit.JUnit4ClassRunner;
import com.cs.model.cassandraEntity.Person;
import com.cs.service.csLog.TestService;

@RunWith(JUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/*.xml" })
public class WenSocketTest {
	
	private static final Logger	LOG	= LoggerFactory.getLogger(WenSocketTest.class);
	
	@Autowired
	private TestService testService;

	@Test
	public void scheduleTest() {
//		LOG.info("*************************************************************");
//		Thread t = new ThreadExample1(testService); // 產生Thread物件
//		Thread t2 = new ThreadExample1(testService); // 產生Thread物件
//		Thread t3 = new ThreadExample1(testService); // 產生Thread物件
//		Thread t4 = new ThreadExample1(testService); // 產生Thread物件
//		Thread t5 = new ThreadExample1(testService); // 產生Thread物件
//		Thread t6 = new ThreadExample1(testService); // 產生Thread物件
//
//		t.start(); // 開始執行t.run()
//        t2.start(); // 開始執行t.run()
//        t3.start(); // 開始執行t.run()
//        t4.start(); // 開始執行t.run()
//        t5.start(); // 開始執行t.run()
//        t6.start(); // 開始執行t.run()
//        LOG.info("*************************************************************");
		LOG.info("-------------------------------------------------------------------------------------------------:");
		Date startTime = new Date();
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
		LOG.info("startTime:" + sdFormat.format(startTime));
		for(int i=0; i<100000; i++){
			Person person = new Person(String.valueOf(new IdWorker(1).nextId()), "test1"+i, "0", i );
			testService.insertPerson(person);
		}
		Date endTime = new Date();
		LOG.info("endTime:" + sdFormat.format(endTime));
		LOG.info("-------------------------------------------------------------------------------------------------:");
            
		// String fileName = LogFileUtils.getScheduleLogFileName(TFEFunction.BH024, startTime);
//		int count = userService.findUidCount("1");
//		LOG.debug("count:" + count);
		// Base64Util base64Util = new Base64Util();
		// LOG.debug(" Start Base64Util ");
		// String encodeBASE64String = base64Util.getEncodeBASE64String("test");
		// LOG.debug("encodeBASE64String:"+encodeBASE64String);
		// String decodeBASE64String = base64Util.getDecodeBASE64String(encodeBASE64String);
		// LOG.debug("decodeBASE64String:"+decodeBASE64String);
		//
		// LOG.debug(" End Base64Util ");
		// bankAccountStatementService.executeBankAccountStatementGenerator(220, fileName, startTime);
		// startTime = new Date();
		// LOG.debug("end Time:" + startTime);
		// //
		// String userId = "1";
		// String account = "leo";
		// String userName = "LeoKe";
		// // LOG.debug("start addOrUpdateUser:"+startTime);
		// // User user = new User();
		// // user.setAccount(account+"10");
		// // user.setPwd(account+"10");
		// // user.setUserName(userName);
		// // user = userService.addOrUpdateUser(user);
		// // LOG.debug("user:"+JSONObject.fromObject(user));
		// // LOG.debug("end addOrUpdateUser:"+startTime);
		// // LOG.debug("start findAccountByUid:"+startTime);
		// // userService.delUser(user);
		// // LOG.debug("end findAccountByUid:"+startTime);
		// LOG.debug("start findAccountByUid:" + startTime);
		// LOG.debug("findAccountByUid:" + JSONObject.fromObject(userService.findAccountByUid(userId)));
		// LOG.debug("end findAccountByUid:" + startTime);
		// LOG.debug("start getUserByAccount:" + startTime);
		// LOG.debug("getUserByAccount:" + JSONObject.fromObject(userService.getUserByAccount(account + "2")));
		//
		// LOG.debug("end getUserByAccount:" + startTime);
		// LOG.debug("start getAllAccounts:" + startTime);
		// LOG.debug("getAllAccounts:" + JSONArray.fromObject(userService.getAllAccounts()));
		//
		// LOG.debug("end getAllAccounts:" + startTime);
	}
	
	class ThreadExample1 extends Thread {
		TestService testServiceThread;
		
		public ThreadExample1(TestService testService){
			this.testServiceThread = testService;
		}
	    public void run() { // override Thread's run()
	    	LOG.info("-------------------------------------------------------------------------------------------------:");
			Date startTime = new Date();
			SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
			LOG.info("startTime:" + sdFormat.format(startTime));
			for(int i=0; i<100000; i++){
				Person person = new Person(String.valueOf(new IdWorker(1).nextId()), "test1"+i, "0", i );
				testService.insertPerson(person);
			}
			Date endTime = new Date();
			LOG.info("endTime:" + sdFormat.format(endTime));
			LOG.info("-------------------------------------------------------------------------------------------------:");
	    }
	    
	}
}
