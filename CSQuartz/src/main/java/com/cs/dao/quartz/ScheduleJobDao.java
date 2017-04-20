package com.cs.dao.quartz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cs.model.quartz.Schedulejob;


/** 
 * 排程資料DB Dao 介面
 */ 
public interface ScheduleJobDao extends JpaRepository<Schedulejob, Integer> {
	

	/** 
     * 依據狀態 查詢排程
     * @param status 狀態 0停用 1啟用 2刪除
     * @return List<ScheduleJob> 排程資料
     */
	@Query(value = " select * from scheduleJob where jobStatus  = ?1 order by jobId  ASC", nativeQuery = true)
	public List<Schedulejob> queryScheduleJobData(int status);
	
}
