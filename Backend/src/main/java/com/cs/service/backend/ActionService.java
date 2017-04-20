package com.cs.service.backend;

import java.util.List;
import java.util.TreeMap;

import com.cs.model.springsecurity.SecurityPage;
import com.cs.util.JqgridFindRequest;
import com.cs.util.JqgridResponse;

public interface ActionService {

	JqgridResponse<SecurityPage> findByQuery(JqgridFindRequest jqgridFindRequest);
	
}
