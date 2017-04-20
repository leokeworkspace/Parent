package com.cs.controller.csLog;

import java.text.SimpleDateFormat;
import java.util.Date;

//import net.sf.json.JSONObject;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.servlet.ModelAndView;








import com.cs.dao.cassandraEntity.PersonRepo;
import com.cs.model.cassandraEntity.Person;
import com.cs.service.csLog.TestService;
//import com.cs.service.csLog.TestService;
import com.cs.util.IdWorker;
//import com.cs.util.RestTemplateUtil;


@Controller("TestController")
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
//	@Autowired
//	GetHttpURLConnection getHttpURLConnection;
	
	@Autowired
	private TestService testService;
	
	
//	@RequestMapping(value="/getServerList" , method = RequestMethod.POST)
//	public String getServerList(){
//		LOG.debug("in getServerList at :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//		return null;
//	}
//	
//	@RequestMapping(value="/login" , method = RequestMethod.POST)
//	public void login(){
//		HttpURLConnection  connection = getHttpURLConnection.getConnection("");
//		LOG.debug("in check at :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//	}
	
	@RequestMapping(value="/test" , method = RequestMethod.GET)
	public @ResponseBody String test(){
//		LOG.debug("in check at :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));		
//		String _result="";
//		String _url="";
//		String _value="";
//		RestTemplateUtil restTemplateUtil = new RestTemplateUtil();
//		_result = restTemplateUtil.sendGet(_url,_value);
////		_result = restTemplateUtil.sendPost(_url,_value);
//		_result = restTemplateUtil.sendPut(_url,_value);
//		_result = restTemplateUtil.sendDelete(_url,_value);
//		Person person = testService.queryPerson("123");
//		LOG.debug("person:"+JSONObject.fromObject(person).toString());
//		LOG.debug("end check at :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
//		LOG.info("-------------------------------------------------------------------------------------------------:");
//		IdWorker idWorker = new IdWorker(1);
//		Date startTime = new Date();
//		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
//		LOG.info("startTime:" + sdFormat.format(startTime));
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(int i=0; i<1; i++){
//			Person person = new Person(String.valueOf(idWorker.nextId()), "test1"+0, "0", 0 );
//////			System.out.println("person:"+person.getId());
//			testService.insertPerson(person);
//			personRepo.save(person);
//		}
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		Date endTime = new Date();
//		LOG.info("endTime:" + sdFormat.format(endTime));
		LOG.info("-------------------------------------------------------------------------------------------------:");
		for(int i=0; i<10; i++){
			Thread t = new ThreadExample1(testService); // 產生Thread物件
			t.start(); // 開始執行t.run()
		}
		LOG.info("-------------------------------------------------------------------------------------------------:");
		return "ok";
	}
	
	
	class ThreadExample1 extends Thread {
		TestService testServiceThread;
		
		public ThreadExample1(TestService testService){
			this.testServiceThread = testService;
		}
	    public void run() { // override Thread's run()
	    	try{
	    		LOG.info("-------------------------------------------------------------------------------------------------:");
				Date startTime = new Date();
				SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
				LOG.info("startTime:" + sdFormat.format(startTime));
				for(int i=0; i<10000000; i++){
					Person person = new Person(String.valueOf(new IdWorker(1).nextId()), "test1"+i, "0", i );
					person = testService.insertPerson(person);
				}
				Thread.sleep(5);
				Date endTime = new Date();
				LOG.info("endTime:" + sdFormat.format(endTime));
				LOG.info("-------------------------------------------------------------------------------------------------:");
	    	}catch(Exception e){
	    		LOG.info(" Thread GG SO stop & back for foreach");
	    	}
	    	
	    }
	    
	}
	
}
