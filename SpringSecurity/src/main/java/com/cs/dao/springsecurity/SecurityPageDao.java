package com.cs.dao.springsecurity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs.model.springsecurity.SecurityPage;
import com.cs.util.JqgridResponse;

public interface SecurityPageDao extends JpaRepository<SecurityPage, Integer> {
	    
	List<SecurityPage> findByPageSwitch(int pageSwitch);
	
	List<SecurityPage> findByPageInPageIdList(String pageId);
	
	JqgridResponse<SecurityPage> findByQuery(int page, int rows, String sidx, String sord);

}
