package com.cs.controller.backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.servlet.ModelAndView;

import com.cs.util.JqgridFindRequest;
import com.cs.util.JqgridResponse;
import com.cs.model.springsecurity.SecurityPage;
import com.cs.service.backend.ActionService;
import com.cs.service.springsecurity.SecurityPageService;
import com.cs.service.springsecurity.SecurityService;
import com.cs.service.springsecurity.SecurityUserService;
import com.cs.util.RequestParameterUtil;
import com.cs.util.RestTemplateUtil;


@Controller
public class CompetenceController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CompetenceController.class);
	
	@Autowired
	private SecurityUserService		securityUserService;
	@Autowired
	private SecurityService			securityService;
	@Autowired
	private SecurityPageService		securityPageService;	
	@Autowired
	private ActionService actionService;
	
//	@Autowired
//	GetHttpURLConnection getHttpURLConnection;
			
	@RequestMapping(value="/competence/action" , method = RequestMethod.GET)
	public ModelAndView action(ModelAndView mav){
		mav.setViewName("/competence/action");		
		return mav;
	}
	

	@RequestMapping(value="/competence/actionQuery" , method = RequestMethod.POST)
	public @ResponseBody String actionQuery(HttpServletRequest request, @RequestBody String jsonString){
		
		try{
			JSONObject reJso= JSONObject.fromObject(jsonString);
			JqgridFindRequest jqgridFindRequest = new JqgridFindRequest(reJso);
			JqgridResponse<SecurityPage> securityPageList = actionService.findByQuery(jqgridFindRequest);
			System.out.println(securityPageList.getRows().size());
			return JSONObject.fromObject(securityPageList).toString();
			
		}catch(NullPointerException n){
			return null;
		}
		
	}
	
	@RequestMapping(value="/competence/actionEdit" , method = RequestMethod.POST)
	public @ResponseBody String actionEdit(HttpServletRequest request, @RequestBody String jsonString){
		
		try{
			JSONObject reJso= JSONObject.fromObject(jsonString);
			JqgridFindRequest jqgridFindRequest = new JqgridFindRequest(reJso);
			JqgridResponse<SecurityPage> securityPageList = actionService.findByQuery(jqgridFindRequest);
			System.out.println(securityPageList.getRows().size());
			return JSONObject.fromObject(securityPageList).toString();
			
		}catch(NullPointerException n){
			return null;
		}
		
	}
	
	@RequestMapping(value="/competence/actionSelectList" , method = RequestMethod.POST)
	public @ResponseBody String actionSelectList(HttpServletRequest request, @RequestBody String jsonString){
		
		try{
			
			String value = "0:主選單;1:功能";
			
			return value;
			
		}catch(NullPointerException n){
			return null;
		}
		
	}
	
	
	
	@RequestMapping(value="/competence/users" , method = RequestMethod.GET)
	public ModelAndView users(ModelAndView mav){
		mav.setViewName("/competence/users");		
		return mav;
	}
	
	@RequestMapping(value="/competence/tasks" , method = RequestMethod.GET)
	public ModelAndView tasks(ModelAndView mav){
		mav.setViewName("/competence/tasks");		
		return mav;
	}
	
}
