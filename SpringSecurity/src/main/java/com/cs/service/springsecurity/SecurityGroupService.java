package com.cs.service.springsecurity;

import com.cs.model.springsecurity.SecurityGroup;


public interface SecurityGroupService {
	SecurityGroup saveOrUpdate(SecurityGroup group);

    SecurityGroup findByGroupId(int groupId);
    
    void delSecurityGroup(SecurityGroup group);
}
