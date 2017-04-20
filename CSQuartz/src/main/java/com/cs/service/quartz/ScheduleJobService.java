package com.cs.service.quartz;

import java.util.List;

import com.cs.model.quartz.Schedulejob;


/** 
 * 排程資料 Service 介面
 * @author Leo 
 */ 
public interface ScheduleJobService {

	/** 
     * 依據狀態 查詢排程
     * @param status 狀態 0停用 1啟用 2刪除
     * @return List<ScheduleJob> 排程資料
     */
	List<Schedulejob> queryScheduleJobData(int status);

	List<Schedulejob> querySchedulejobData(int status);

	void delete(Schedulejob schedulejob);

	void update(Schedulejob schedulejob);

	Schedulejob get(int jobId);


	
}
