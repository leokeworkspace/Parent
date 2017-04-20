package com.cs.service.backend;


import java.util.List;
import java.util.TreeMap;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.util.JqgridFindRequest;
import com.cs.dao.springsecurity.SecurityPageDao;
import com.cs.model.springsecurity.SecurityPage;
import com.cs.util.JqgridResponse;

@Transactional
@Service
public class ActionServiceServiceImpl implements ActionService {

    @Autowired
    private SecurityPageDao securityPageDao;
   
        
    @Override
    public JqgridResponse<SecurityPage> findByQuery(JqgridFindRequest jqgridFindRequest){
    	
    	JqgridResponse<SecurityPage> acrionList = securityPageDao.findByQuery(jqgridFindRequest.getPage(), jqgridFindRequest.getRows(), jqgridFindRequest.getSidx(), jqgridFindRequest.getSord());

    	return acrionList;
    }
    
   
    
    
}
