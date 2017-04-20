package com.cs.service.springsecurity;

import com.cs.model.springsecurity.SecurityUser;


public interface SecurityUserService {
    SecurityUser saveOrUpdate(SecurityUser user);

    SecurityUser findByAccount(String account);
    
    SecurityUser findByAccountAndPw(String account, String password);
}
