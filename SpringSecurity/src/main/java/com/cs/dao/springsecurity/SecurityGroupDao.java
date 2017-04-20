package com.cs.dao.springsecurity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.model.springsecurity.SecurityGroup;

public interface SecurityGroupDao extends JpaRepository<SecurityGroup, Integer> {
	    
	@Query(value="select g from SecurityGroup g where g.groupId = ?1")
    SecurityGroup findByGroupId(int groupId);

}
