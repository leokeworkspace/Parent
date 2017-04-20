package com.cs.service.quartz;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cs.dao.quartz.ScheduleJobDao;
import com.cs.model.quartz.Schedulejob;
/** 
 * 排程資料 DB Service 實作
 * @author Leo 
 */
@Transactional
@Service
public class ScheduleJobServiceImpl implements ScheduleJobService{

	@Autowired
	private ScheduleJobDao scheduleJobDao;
	
	/** 
     * 依據狀態 查詢排程
     * @param status 狀態 0停用 1啟用 2刪除
     * @return List<ScheduleJob> 排程資料
     */
	@Override
	public List<Schedulejob> queryScheduleJobData(int status) {
		return scheduleJobDao.queryScheduleJobData(status);
	}

	@Override
	public List<Schedulejob> querySchedulejobData(int status) {
		// TODO Auto-generated method stub
		return scheduleJobDao.queryScheduleJobData(status);
	}

	@Override
	public void delete(Schedulejob schedulejob) {
		// TODO Auto-generated method stub
		scheduleJobDao.delete(schedulejob);
	}

	@Override
	public void update(Schedulejob schedulejob) {
		// TODO Auto-generated method stub
		scheduleJobDao.save(schedulejob);
	}

	@Override
	public Schedulejob get(int jobId) {
		// TODO Auto-generated method stub
		return scheduleJobDao.getOne(jobId);
	}
	
	


}
