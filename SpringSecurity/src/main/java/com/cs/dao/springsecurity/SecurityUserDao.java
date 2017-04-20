package com.cs.dao.springsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.model.springsecurity.SecurityUser;

public interface SecurityUserDao extends JpaRepository<SecurityUser, Integer> {
	
	@Query(value="select u from SecurityUser u where u.account = ?1")
    SecurityUser findByAccount(String account);
	
	@Query(value="select u from SecurityUser u where u.account = ?1 and u.password= ?2")
    SecurityUser findByAccountAndPw(String account, String password);
    
}
