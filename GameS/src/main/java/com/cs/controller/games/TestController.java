package com.cs.controller.games;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.cs.handler.quartz.QuartzHandler;
import com.cs.util.AddressUtil;
import com.cs.util.RestTemplateUtil;


@Controller
@RequestMapping("/test")
public class TestController {
	
	private static final Logger LOG = LoggerFactory.getLogger(TestController.class);
	
//	@Autowired
//	private QuartzHandler quartzHandler;
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
	
	@RequestMapping(value = "checkRequest", method = { RequestMethod.POST })
	public @ResponseBody JSONObject checkRequest(HttpServletRequest request) {
		JSONObject jso = new JSONObject();
		try {
			LOG.debug("============================================");
			@SuppressWarnings("rawtypes")
			Map map = request.getParameterMap();
			for (Object key : map.keySet()) {
				String keyStr = (String) key;
				String[] value = (String[]) map.get(keyStr);
				LOG.debug("Key " + (String) key);
				for (int i = 0; i < value.length; i++) {
					LOG.debug("	value: " + value[i]);
				}
			}
			LOG.debug("============================================");
//			String account = request.getParameter("account").trim();
			int count = 1;
			
			if (count > 0) {
				jso.put("rs", false);
			}
			else {
				jso.put("rs", true);
			}
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
			jso.put("rs", false);
		}
		return jso;
	}
	
	@RequestMapping(value = "checkRequestJson", method = { RequestMethod.POST })
	public @ResponseBody JSONObject checkRequestJson(@RequestBody String jsonBody) {
		JSONObject jso = new JSONObject();
		try {
			LOG.debug("============================================");
			LOG.debug("	jsonBody: " + jsonBody);
			LOG.debug("============================================");
//			String account = request.getParameter("account").trim();
			int count = 1;
			
			if (count > 0) {
				jso.put("rs", false);
			}
			else {
				jso.put("rs", true);
			}
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
			jso.put("rs", false);
		}
		return jso;
	}
	
	@RequestMapping(value = "getServerAddress", method = { RequestMethod.GET })
	public @ResponseBody String getServerAddress(@RequestBody String jsonBody) {
		JSONObject jso = new JSONObject();
		String serverAddress = "";
		try {
			LOG.debug("============================================");
			AddressUtil addressUtil = new AddressUtil();
			serverAddress = addressUtil.getServerAddress();
			LOG.debug("	serverAddress: " + serverAddress);
			LOG.debug("============================================");
//			quartzHandler.initQuartz();
//			String account = request.getParameter("account").trim();
			int count = 1;
			
			if (count > 0) {
				jso.put("ip", serverAddress);
			}
			else {
				jso.put("ip", serverAddress);
			}
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
			jso.put("rs", false);
		}
		return jso.toString();
	}
	
	
	public String testServerAddress() {
		JSONObject jso = new JSONObject();
		String serverAddress = "";
		try {
			LOG.debug("============================================");
			AddressUtil addressUtil = new AddressUtil();
			serverAddress = addressUtil.getServerAddress();
			LOG.debug("	serverAddress: " + serverAddress);
			LOG.debug("============================================");
//			String account = request.getParameter("account").trim();
			int count = 1;
			
			if (count > 0) {
				jso.put("ip", serverAddress);
			}
			else {
				jso.put("ip", serverAddress);
			}
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
			jso.put("rs", false);
		}
		return jso.toString();
	}
	
}
