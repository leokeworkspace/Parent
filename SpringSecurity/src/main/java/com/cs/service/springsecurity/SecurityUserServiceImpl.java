package com.cs.service.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cs.dao.springsecurity.SecurityUserDao;
import com.cs.model.springsecurity.SecurityUser;

@Service
public class SecurityUserServiceImpl implements SecurityUserService {
	@Autowired
	private SecurityUserDao			securityUserDao;
	@Autowired
	private BCryptPasswordEncoder	bCryptPasswordEncoder;

	@Override
	public SecurityUser saveOrUpdate(SecurityUser user) {
		SecurityUser securityUser = securityUserDao.save(user);
		return securityUser;
	}

	@Override
	public SecurityUser findByAccount(String account) {
		return securityUserDao.findByAccount(account);
	}

	@Override
	public SecurityUser findByAccountAndPw(String account, String password) {
		return securityUserDao.findByAccountAndPw(account, password);
	}
}
