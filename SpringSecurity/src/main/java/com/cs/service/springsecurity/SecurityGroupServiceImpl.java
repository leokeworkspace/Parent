package com.cs.service.springsecurity;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cs.dao.springsecurity.SecurityGroupDao;
import com.cs.model.springsecurity.SecurityGroup;


@Service
public class SecurityGroupServiceImpl implements SecurityGroupService {

    @Autowired
    private SecurityGroupDao securityGroupDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public SecurityGroup saveOrUpdate(SecurityGroup group){
    	return securityGroupDao.save(group);
    }

    @Override
    public SecurityGroup findByGroupId(int groupId){
    	return securityGroupDao.findByGroupId(groupId);
    }
    
    @Override
    public void delSecurityGroup(SecurityGroup group){
    	securityGroupDao.delete(group);
    }
    
}
