package com.cs.controller.backend;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cs.util.RestTemplateUtil;


@Controller("TestController")
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
//	@Autowired
//	GetHttpURLConnection getHttpURLConnection;
	
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
		LOG.debug("in check at :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));		
		String _result="";
		String _url="";
		String _value="";
		RestTemplateUtil restTemplateUtil = new RestTemplateUtil();
		_result = restTemplateUtil.sendGet(_url,_value);
//		_result = restTemplateUtil.sendPost(_url,_value);
		_result = restTemplateUtil.sendPut(_url,_value);
		_result = restTemplateUtil.sendDelete(_url,_value);
		LOG.debug("end check at :"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		return _result;
	}
	
	
}
