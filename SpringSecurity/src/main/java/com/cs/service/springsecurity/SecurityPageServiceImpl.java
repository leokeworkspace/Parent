package com.cs.service.springsecurity;


import java.util.List;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.springsecurity.SecurityPageDao;
import com.cs.model.springsecurity.SecurityPage;

@Transactional
@Service
public class SecurityPageServiceImpl implements SecurityPageService {

    @Autowired
    private SecurityPageDao securityPageDao;
   
    @Override
    public SecurityPage saveOrUpdate(SecurityPage securityPage){
    	return securityPageDao.save(securityPage);
    }

    @Override
    public SecurityPage findByPageId(int pageId){
    	return securityPageDao.findOne(pageId);
    }
    
    @Override
    public void delSecuritySecurityPage(SecurityPage securityPage){
    	securityPageDao.delete(securityPage);
    }
    
    @Override
    public List<SecurityPage> findBySecurityPage(int pageSwitch){
    	return securityPageDao.findByPageSwitch(pageSwitch);
    }
    
    @Override
    @Transactional(readOnly=true)
    public List<SecurityPage> findBySecurityPageAll(){
    	return securityPageDao.findAll();
    }
    
    @Override
    public TreeMap <Integer, TreeMap <Integer, SecurityPage>> findByPageInPageIdList(String pageIdList){
    	System.out.println("pageIdList:"+pageIdList);
    	List<SecurityPage> securityPageList = securityPageDao.findByPageInPageIdList(pageIdList);
    	TreeMap <Integer, TreeMap <Integer, SecurityPage>> menuMap = new TreeMap <Integer, TreeMap <Integer, SecurityPage>>();
    	
    	for(int i=0; i<securityPageList.size(); i++){
    		SecurityPage securityPage = securityPageList.get(i);
    		if(securityPage.getType().intValue() == 0){//找出目錄階層
    			TreeMap <Integer, SecurityPage>  menuList = menuMap.get(securityPage.getSort().intValue());
    			if(menuList == null){
    				menuList = new TreeMap <Integer, SecurityPage>();
    				menuList.put(0, securityPage);
    				menuMap.put(securityPage.getSort().intValue(), menuList);
    			}
    		}
    	}
    	
    	for(int i=0; i<securityPageList.size(); i++){
    		SecurityPage securityPage = securityPageList.get(i);
    		if(securityPage.getType().intValue() != 0){//
    			TreeMap <Integer, SecurityPage>  menuList = menuMap.get(securityPage.getType().intValue());
    			if(menuList != null){
    				menuList.put(securityPage.getSort().intValue(), securityPage);
    			}
    		}
    	}
    	
    	
//    	TreeMap <Integer, SecurityPage> actionSort;
    	
    	
    	return menuMap;
    }
    
    
}
