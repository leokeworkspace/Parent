package com.cs.service.springsecurity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService{
	
	private static final Logger LOG = LoggerFactory.getLogger(SecurityServiceImpl.class);
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedInAccount() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if (userDetails instanceof UserDetails) {
            return ((UserDetails)userDetails).getUsername();
        }

        return null;
    }

    @Override
    public void autologin(String account, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(account);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
//        authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        LOG.trace("autologin:"+usernamePasswordAuthenticationToken.isAuthenticated());
        if (usernamePasswordAuthenticationToken.isAuthenticated()) {
        	
            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//            SecurityContextHolder.getContext().setAuthentication(authentication);;
            LOG.info(String.format("Auto login %s successfully!", account));
        }
    }
}