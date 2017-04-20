package com.cs.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * RESTful Web服務
 * 
 * @author Leo
 */
public class RestTemplateUtil implements AutoCloseable {
	private static final Logger	LOG	= LoggerFactory.getLogger(RestTemplateUtil.class);

	/**
	 * 送出 Get 請求
	 * 
	 * @param url 網址
	 * @param value 傳送資料
	 */
	public String sendGet(String url, String value) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		// 方法1
		// String result = restTemplate.getForObject("http://example.com/hotels/{hotel}/bookings/{booking}", String.class,"42", "21");
		// 方法2
		// Map<String, String> vars = Collections.singletonMap("hotel", "42");
		try {
			LOG.info("sendGet url" + url);
			String result = restTemplate.getForObject(url, String.class);
			LOG.info("sendGet result" + result);
			return result;
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
			return null;
		}
		// 方法3
		// String result = restTemplate.getForObject("http://localhost:8080/yongbarservice/appstore/appgoods/restTemplate?name=zhaoshijie&id=80", String.class );
		// String result = restTemplate.getForObject("http://127.0.0.1/test.php", String.class);
	}

	/**
	 * 送出 POST 請求
	 * 
	 * @param url 網址
	 * @param value 傳送資料
	 */
	public String sendPost(String url, Map<String, String> value) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
		// 方法1
		// MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<String, String>();
		// bodyMap.setAll(urlVariables);
		// ResponseClass responseClass = restTemplate.postForObject(CAR_CES_URL, bodyMap, ResponseClass.class);
		// 方法2
		HttpHeaders headers = new HttpHeaders();
		// headers.add("X-Auth-Token", "e348bc22-5efa-4299-9142-529f07a18ac9");
		MultiValueMap<String, String> postParameters = new LinkedMultiValueMap<String, String>();
		for (Entry<String, String> var : value.entrySet()) {
			postParameters.add(var.getKey(), var.getValue());
		}
		HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(postParameters, headers);
		String _rs = null;
		try {
			_rs = restTemplate.postForObject(url, requestEntity, String.class);
			LOG.info(_rs.toString());
		}
		catch (RestClientException e) {
			LOG.error(e.getMessage(), e);
		}
		// 方法3
		// DomainParam domainParam = new DomainParam();
		// domainParam.setCustomerId(1);
		// LOG.info("....");
		// restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		// restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
		// String responseResult = restTemplate.postForObject(url, domainParam, String.class);
		return _rs;
	}

	/**
	 * 送出 JSON POST 請求
	 * 
	 * @param url 網址
	 * @param value 傳送資料
	 */
	public String sendJSONPost(String url, String jsonStr) {
		String result = null;
		try {
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(jsonStr, headers);
			RestTemplate restTemplate = new RestTemplate();
			result = restTemplate.postForObject(url, entity, String.class);
			LOG.info("sendJSON result:" + result);
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return result;
	}

	/**
	 * 送出 PUT 請求
	 * 
	 * @param url 網址
	 * @param value 傳送資料
	 */
	public String sendPut(String url, String value) {
		// RestTemplate restTemplate = new RestTemplate();
		// restTemplate.put("http://localhost:8080/yongbarservice/appstore/appgoods/restTemplate?name=zhaoshijie&id=80" ,null);
		return "";
	}

	/**
	 * 送出 DEL 請求
	 * 
	 * @param url 網址
	 * @param value 傳送資料
	 */
	public String sendDelete(String url, String value) {
		// delete方法（注意：delete方法没有返回值，说明，id=0这个参数在服务器端可以不定义该参数，直接使用request获取）
		// restTemplate.delete("http://localhost:8080/yongbarservice/appstore/appgoods/deleteranking?id=0");
		return "";
	}

	/**
	 * 送出 SSL 請求
	 * 
	 * @param goUrl 網址
	 * @param RequestMethod GET, POST
	 * @return String 回傳內容 Null:失敗
	 */
	public String sendSSL(String goUrl, String RequestMethod, JSONObject jsonObject) throws Exception {
		String _charset = "UTF-8";
		try {
			URL url = null;
			url = new java.net.URL(goUrl);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			connection.setRequestProperty("Accept-Charset", _charset);
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + _charset);
			connection.setRequestMethod(RequestMethod);
			connection.setDoOutput(true);
			connection.setAllowUserInteraction(false);
			if ("POST".equals(RequestMethod)) {
				PrintStream ps = new PrintStream(connection.getOutputStream());
				ps.print(jsonObject.toString());
				ps.close();
			}
			// Call the service
			BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			// Extract response
			String str;
			StringBuffer sb = new StringBuffer();
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
			String response = sb.toString();
			return response;
		}
		catch (Exception e) {
			return null;
		}
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
	}
}
