package com.cs.service.springsecurity;

import java.util.List;
import java.util.TreeMap;

import com.cs.model.springsecurity.SecurityPage;

public interface SecurityPageService {
	SecurityPage saveOrUpdate(SecurityPage securityPage);

	SecurityPage findByPageId(int pageId);

	void delSecuritySecurityPage(SecurityPage securityPage);

	List<SecurityPage> findBySecurityPage(int pageSwitch);

	List<SecurityPage> findBySecurityPageAll();

	TreeMap<Integer, TreeMap<Integer, SecurityPage>> findByPageInPageIdList(String pageIdList);
}
