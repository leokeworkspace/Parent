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


@Controller("WebViewController")
public class WebViewController {
	
	private static final Logger LOG = LoggerFactory.getLogger(WebViewController.class);
	
//	@Autowired
//	GetHttpURLConnection getHttpURLConnection;
			
	@RequestMapping(value="/blank" , method = RequestMethod.GET)
	public ModelAndView blank(ModelAndView mav){
		LOG.debug( "enter blank " );
		mav.setViewName("/blank");
		
		return mav;
	}
	@RequestMapping(value="/buttons" , method = RequestMethod.GET)
	public ModelAndView buttons(ModelAndView mav){
		LOG.debug( "enter buttons " );
		mav.setViewName("/buttons");
		
		return mav;
	}
	@RequestMapping(value="/flot" , method = RequestMethod.GET)
	public ModelAndView flot(ModelAndView mav){
		LOG.debug( "enter flot " );
		mav.setViewName("/flot");
		
		return mav;
	}
	@RequestMapping(value="/forms" , method = RequestMethod.GET)
	public ModelAndView forms(ModelAndView mav){
		LOG.debug( "enter forms " );
		mav.setViewName("/forms");
		
		return mav;
	}
	@RequestMapping(value="/grid" , method = RequestMethod.GET)
	public ModelAndView grid(ModelAndView mav){
		LOG.debug( "enter grid " );
		mav.setViewName("/grid");
		
		return mav;
	}
	@RequestMapping(value="/icons" , method = RequestMethod.GET)
	public ModelAndView icons(ModelAndView mav){
		LOG.debug( "enter icons " );
		mav.setViewName("/icons");
		
		return mav;
	}
	@RequestMapping(value="/index" , method = RequestMethod.GET)
	public ModelAndView index(ModelAndView mav){
		LOG.debug( "enter index " );
		mav.setViewName("/index");
		
		return mav;
	}
//	@RequestMapping(value="/login" , method = RequestMethod.GET)
//	public ModelAndView login(ModelAndView mav){
//		LOG.debug( "enter login " );
//		mav.setViewName("/login");
//		
//		return mav;
//	}
	@RequestMapping(value="/morris" , method = RequestMethod.GET)
	public ModelAndView morris(ModelAndView mav){
		LOG.debug( "enter morris " );
		mav.setViewName("/morris");
		
		return mav;
	}
	@RequestMapping(value="/notifications" , method = RequestMethod.GET)
	public ModelAndView notifications(ModelAndView mav){
		LOG.debug( "enter notifications " );
		mav.setViewName("/notifications");
		
		return mav;
	}
	@RequestMapping(value="/panels-wells" , method = RequestMethod.GET)
	public ModelAndView panelswells(ModelAndView mav){
		LOG.debug( "enter panels-wells " );
		mav.setViewName("/panels-wells");
		
		return mav;
	}
	@RequestMapping(value="/tables" , method = RequestMethod.GET)
	public ModelAndView tables(ModelAndView mav){
		LOG.debug( "enter tables " );
		mav.setViewName("/tables");
		
		return mav;
	}
	@RequestMapping(value="/typography" , method = RequestMethod.GET)
	public ModelAndView typography(ModelAndView mav){
		LOG.debug( "enter typography " );
		mav.setViewName("/typography");
		
		return mav;
	}
	
}
