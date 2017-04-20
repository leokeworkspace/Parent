package com.cs.controller.springsecurity;

import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cs.model.springsecurity.SecurityPage;
import com.cs.model.springsecurity.SecurityUser;
import com.cs.service.springsecurity.SecurityPageService;
import com.cs.service.springsecurity.SecurityService;
import com.cs.service.springsecurity.SecurityUserService;

@Controller
public class SecurityUserController {
	private static final Logger		LOG	= LoggerFactory.getLogger(SecurityUserController.class);
	@Autowired
	private SecurityUserService		securityUserService;
	@Autowired
	private SecurityService			securityService;
	@Autowired
	private SecurityPageService		securityPageService;

	@RequestMapping(value = "/loginUser", method = {RequestMethod.POST, RequestMethod.GET})
	public String loginUser(HttpServletRequest request) {
				
		if (isCurrentAuthenticationAnonymous()) {
			try {
				String account = request.getParameter("account").trim();
				String password = request.getParameter("password").trim();
				LOG.debug(" loginUser userName:" + account + "," + "password:" + password);
				if (StringUtils.isNotBlank(account) == true && StringUtils.isNotBlank(password) == true) {
					LOG.debug(" loginUser:" + account + " StringUtils.isNotBlank ");
					SecurityUser user = securityUserService.findByAccountAndPw(account, password);
					LOG.debug(" loginUseris account:" + account + " is null:" + user);
					if (user != null) {
						securityService.autologin(account, password);
						System.out.println("user.getPages():"+user.getPages());
						TreeMap <Integer, TreeMap <Integer, SecurityPage>> securityPageList = securityPageService.findByPageInPageIdList(user.getPages());

						System.out.println("size:"+securityPageList.size());
						request.getSession().setAttribute("menuList", securityPageList);
						return "redirect:/index"; 
					}
				}
			}
			catch (Exception e) {
				
			}
			return "/login";
	    } else {
	    	return "redirect:/index";  
	    }
				
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		if (isCurrentAuthenticationAnonymous()) {
			return "/login";
	    } else {
	    	return "redirect:/index";  
	    }
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("message", "You have been logged out successfully.");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		LOG.debug(" logout userName:" + auth.getName());
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			LOG.debug(" logout success ");
		}
		return "/login";
	}
	
	private boolean isCurrentAuthenticationAnonymous() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object authData = authentication.getPrincipal();
        boolean auth = authData.equals("anonymousUser")?true:false;
        return auth;
    }
}
