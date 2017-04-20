package com.cs.dao.quartz;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/** 
 * 排程資料DB Dao 介面
 */ 
@Repository
public class ScheduleJobDaoImpl  {

	private static final Logger	LOG	= LoggerFactory.getLogger(ScheduleJobDaoImpl.class);
	@PersistenceContext
	private EntityManager		entityManager;
	
	
}
