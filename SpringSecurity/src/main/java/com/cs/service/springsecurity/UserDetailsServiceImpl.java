package com.cs.service.springsecurity;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.springsecurity.SecurityUserDao;
import com.cs.model.springsecurity.SecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    @Autowired
    private SecurityUserDao securityUserDao;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String account) throws UsernameNotFoundException {
    	LOG.debug("loadUserByUsername:"+account);
        SecurityUser user = securityUserDao.findByAccount(account);
        LOG.debug("user.getAccount:"+user.getAccount());
        LOG.debug("user.Password:"+user.getPassword());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        org.springframework.security.core.userdetails.User springUser =  new org.springframework.security.core.userdetails.User(user.getAccount(), user.getPassword(), grantedAuthorities);
        
        return springUser;
    }
}