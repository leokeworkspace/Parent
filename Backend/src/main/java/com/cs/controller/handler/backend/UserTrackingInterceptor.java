/**
 * 
 */
package com.cs.controller.handler.backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.apache.axis2.transport.http.HTTPConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class UserTrackingInterceptor extends HandlerInterceptorAdapter {
	private static final Logger	LOG	= LoggerFactory.getLogger(UserTrackingInterceptor.class);

	/**
	 * preHandle中，可以进行编码、安全控制等处理
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String url=request.getRequestURL().toString();
		LOG.debug("======> preHandle <======", "[url="+url+"]");
		HttpSession session = request.getSession();
		SecurityContext ctx = SecurityContextHolder.getContext()==null?null:(SecurityContext)SecurityContextHolder.getContext();
		if(ctx!=null && ctx.getAuthentication().getPrincipal() != null ){
			ctx.getAuthentication();
		}
		return true;
	}

	/**
	 * postHandle中，有机会修改ModelAndView
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(response.getStatus() >= 500){
			String url=request.getRequestURL().toString();
			LOG.error("======> postHandle error [url="+url+"]<======");
		}
		
	}

	/**
	 * afterCompletion中，可以根据ex是否为null判断是否发生了异常，进行日志记录
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {		
		if(ex != null){
			String url=request.getRequestURL().toString();
			LOG.error("======> afterCompletion error [url="+url+"]<======",ex);
			response.setStatus(404);
		}
	}
	// @Override
	// public boolean preHandle(HttpServletRequest request,
	// HttpServletResponse response, Object handler) throws Exception {
	//
	// HttpSession session = null;
	// SecurityContext ctx = null ;
	// UserInfo info = null ;
	// ArrayList pathList = null ;
	// session = request.getSession();
	// //ctx =session.getAttribute("SPRING_SECURITY_CONTEXT")==null?null:(SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
	// ctx = SecurityContextHolder.getContext()==null?null:(SecurityContext)SecurityContextHolder.getContext();
	// //SecurityContext ctx2 = SecurityContextHolder.getContext()==null?null:(SecurityContext)SecurityContextHolder.getContext();
	// if(ctx!=null && ctx.getAuthentication().getPrincipal() != null && ! ctx.getAuthentication().getPrincipal().equals("anonymousUser")){
	// info =ctx.getAuthentication().getPrincipal()==null?null:(UserInfo)ctx.getAuthentication().getPrincipal();
	// if(info != null){
	//
	// pathList = (ArrayList) info.getPathList() ;
	// }
	// }
	//
	// if(handler instanceof org.directwebremoting.spring.DwrController){
	//
	// return true;
	// }else{
	// //method = (HandlerMethod) handler;
	//
	// String reqMethod = request.getMethod();
	// if(reqMethod!=null && reqMethod.equals("GET")){
	// String requestUrl = request.getRequestURI().substring(request.getContextPath().length()+1);
	//
	// if(requestUrl !=null && (requestUrl.equals("prelog") || requestUrl.equals("login") || requestUrl.equals("authFail") )){
	//
	// // do something
	// }else{
	// if(pathList!=null && requestUrl!=null && (pathList.contains(requestUrl) ||
	// requestUrl.equals("index") || requestUrl.equals("login") )){
	//
	// // do something
	// }else{
	//
	// // production
	// //return false;
	//
	// //testing
	// return true;
	// }
	// }
	// }
	// return true;
	//
	// }
	// return true;
	// }
	//
	// @Override
	// public void postHandle(HttpServletRequest request, HttpServletResponse response,
	// Object handler, ModelAndView modelAndView) throws Exception {
	//
	// UtiLog vo ;
	// String pk = "" ;
	// String serial_number = null;
	// String userID = null;
	// String request_uri = "";
	// String action_name = "";
	// String action_method = "";
	// String machine_ip = "";
	// String data = "" ;
	// HttpSession session = null;
	// SecurityContext ctx = null ;
	// UserInfo info = null ;
	// Enumeration names = null;
	// StringBuffer strBuff = null ;
	// String paraName = "";
	// String paraValue = "";
	// HandlerMethod method = null ;
	// sf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	// String ret = "" ;
	// Date d= null ;
	// try{
	//
	// if(daom!=null){
	// //serial_number = pk("LOG")+this.i;
	// session = request.getSession(false);
	// ctx =session.getAttribute("SPRING_SECURITY_CONTEXT")==null?null:(SecurityContext)session.getAttribute("SPRING_SECURITY_CONTEXT");
	// if(ctx!=null){
	// //auth = ctx.getAuthentication();
	// info =ctx.getAuthentication().getPrincipal()==null?null:(UserInfo)ctx.getAuthentication().getPrincipal();
	// if(info != null){
	// userID = info.getUserID() ;
	// }
	// }
	//
	// machine_ip = request.getRemoteAddr();
	// request_uri = request.getRequestURI();
	// if(handler instanceof org.directwebremoting.spring.DwrController){
	// DwrController dwr = (DwrController)handler;
	// action_name = dwr.getClass().getName();
	//
	// action_method = "org.directwebremoting.spring.DwrController";
	// }else{
	// method = (HandlerMethod) handler;
	//
	// action_method = method.getMethod().getName() ;
	// action_name = method.getMethod().getDeclaringClass().getName() ;
	// }
	//
	// strBuff = new StringBuffer();
	// // 前端參數
	// names = request.getParameterNames();
	// while (names.hasMoreElements()) {
	// paraName = (String) names.nextElement();
	// // LOG.debug("paraName=="+paraName);
	// paraValue = request.getParameter(paraName);
	// strBuff.append(paraName);
	// strBuff.append("=");
	// strBuff.append(paraValue);
	// strBuff.append("::");
	// }
	//
	// //if(serial_number!=null){
	// vo = new UtiLog();
	//
	// try {
	// d = new Date();
	// ret = sf.format(d);
	// } finally {
	// d = null;
	// }
	//
	// //vo.setSerial_number(serial_number);
	// //vo.setLog_date(serial_number.substring(3));
	// vo.setLog_date(ret);
	// vo.setUser_id(userID);
	// vo.setAction_name(action_name);
	// vo.setAction_method(action_method);
	// vo.setMachine_ip(machine_ip);
	// //vo.setLog_data(transString(strBuff.toString()));
	// vo.setLog_data(strBuff.toString());
	// vo.setRequest_uri(request_uri);
	// //
	// daom.insert("uti_log.abatorgenerated_insert", vo) ;
	// //this.i++ ;
	// //}
	// }
	// }catch(Exception e){
	// LOG.debug(e);
	// //logger.error(e);
	// }
	//
	// }
}
