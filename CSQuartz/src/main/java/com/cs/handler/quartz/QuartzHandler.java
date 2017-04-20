package com.cs.handler.quartz;

import java.util.List;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import com.cs.model.quartz.Schedulejob;
import com.cs.service.quartz.QuartzJobService;
import com.cs.service.quartz.ScheduleJobService;



 
/**
 * 任務處理
 * @author Leo
 */
@Component
public class QuartzHandler {
 
	private static final Logger LOG = LoggerFactory.getLogger(QuartzHandler.class);
	
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    
    @Autowired
    private ScheduleJobService scheduleJobService;
          
    /**
     * 建立排程任務(沒有就建立先的任務，已存在就更新資料)
     * @param job 任務資訊
     */
    public void addQuartz(Schedulejob job){
         
        try {
        	SchedulerFactoryBean schedulerFactory = new SchedulerFactoryBean(); 
            Scheduler scheduler = schedulerFactoryBean.getScheduler();
             
            if(null!=job){
                 
                //取得觸發的trigger的key
                TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
                LOG.debug("triggerKey:"+triggerKey.toString());
                //取得觸發的trigger
                CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
                LOG.debug("trigger==null:"+(trigger==null));
                //判斷排程任務不存在的話 
                if(null==trigger){
                     
                    //建立新任務
                    JobDetail jobDetail = JobBuilder.newJob(QuartzJobService.class).withIdentity(job.getJobName(), job.getJobGroup()).build();
                     
                    jobDetail.getJobDataMap().put("Schedulejob", job);
                     
                    //比達是調度建構器
                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                     
                    //按新的cronExpression表达式构建一个新的trigger
                    trigger = TriggerBuilder.newTrigger()
                            .withIdentity(job.getJobName(), job.getJobGroup())
                            .withSchedule(scheduleBuilder)
                            .build();
                   
                    scheduler.scheduleJob(jobDetail, trigger);
                     
                    //把任务插入数据库
//                    int result = quartzBS.add(job);
//                    if(result!=0){
//                        model.addAttribute("msg", "您的任务创建成功！");
//                    }else{
//                        model.addAttribute("msg", "您的任务创建失败！");
//                    }
                     
                }else{//存在任务
                	                     
//                    // Trigger已存在，那么更新相应的定时设置
//                    //表达式调度构建器
//                    CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
//                    LOG.debug("job.getCronExpression():"+job.getCronExpression()); 
//                    //按新的cronExpression表达式重新构建trigger
//                    trigger = trigger.getTriggerBuilder()
//                            .withIdentity(triggerKey)
//                            .withSchedule(scheduleBuilder)
//                            .build();
//
//                    //按新的trigger重新设置job执行
////                  scheduler.reSchedulejob(triggerKey, trigger);
//                    //更新数据库中的任务
////                  int result = quartzBS.update(job);
////                  if(result==1){
////                      model.addAttribute("msg", "您的任务更新成功！");
////                  }else{
////                      model.addAttribute("msg", "您的任务更新失败！");
////                  }
                }
                 
            }
             
        } catch (SchedulerException e) {
            LOG.error("addQuartz error ",e);
        }
         
    }
     
     
    /**
     * 暫停任務
     * @param job 任務資訊
     */
    public void pauseQuartz(Schedulejob Schedulejob){
 
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(Schedulejob.getJobName(), Schedulejob.getJobGroup());
        try {
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("pauseQuartz error ",e);
        }
 
        
    }
     
     
    /**
     * 恢復任務
     * @param Schedulejob
     * @return
     */
    public void resumeQuartz(Schedulejob Schedulejob){
 
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(Schedulejob.getJobName(), Schedulejob.getJobGroup());
        try {
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            LOG.error("resumeQuartz error ",e);
        }
 
        
    }
     
     
    /**
     * 刪除任務
     * @param job 任務資訊
     */
    public void deleteQuartz(Schedulejob Schedulejob){
 
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(Schedulejob.getJobName(), Schedulejob.getJobGroup());
        try {
            scheduler.deleteJob(jobKey);
            LOG.debug("remove Quartz Job Name:["+Schedulejob.getJobName()+"]");
        } catch (SchedulerException e) {
        	 LOG.error("deleteQuartz error ",e);
        }

    }
    
    /**
     * 刪除任務
     * @param id 編號
     * @param name 名稱
     * @param group 群組.
     * @param status 狀態 0停用 1啟用 2刪除
     * @param cronExpression 運行時間
     * @param desc 描述說明
     * @param beanAdderss class 位置
     * @param beanName 注入的bean 名稱
     * @param beanMethod 要執行方法
     * @return Schedulejob;
     */
    public Schedulejob joinQuartz(int id, String name, String group, int status, String cronExpression, String desc, String beanAdderss, String beanName, String beanMethod){
 
    	Schedulejob Schedulejob  = new Schedulejob ();    	
    	Schedulejob.setJobId(id);
    	Schedulejob.setJobName(name);
    	Schedulejob.setJobGroup(group);
    	Schedulejob.setJobStatus(status);
    	//"0/10 * * * * ?"
    	Schedulejob.setCronExpression(cronExpression);
    	Schedulejob.setDesc(desc);
    	Schedulejob.setBeanAdderss(beanAdderss);
    	Schedulejob.setBeanName(beanName);
    	Schedulejob.setBeanMethod(beanMethod);
		return Schedulejob;
    	
    
    }
    
    /**
     * 組合任務時間
     * @param year 年(目前無效果)
     * @param month 月
     * @param day 日
     * @param hour 時
     * @param minute 分
     * @param second 秒	
     * @return String 組合出的時間;
     * <pre> 	
     * 範例及說明	
     * 		字段   允許值   允許的特殊字符 
     * 		秒    0-59    , - * / 
     * 		分    0-59    , - * / 
     * 		小時    0-23    , - * / 
     * 		日期    1-31    , - * ? / L W C 
     * 		月份    1-12 或者 JAN-DEC    , - * / 
     * 		星期    1-7 或者 SUN-SAT    , - * ? / L C # 
     * 		年（可選）或   留空白, 1970-2099    , - * /
     * 		0 0 10,14,16 * * ?  每天上午10點，下午2點，4點 
     * 		0 0/30 9-17 * * ?    朝九晚五工作时间内每半小时 
     * 		0 0 12 ? * WED     表示每个星期三中午12點 
     * 		0 0 12 * * ?             每天中午12點觸發
     * 		0 15 10 ? * *           每天上午10:15觸發
     * 		0 15 10 * * ?           每天上午10:15觸發
     * 		0 15 10 * * ? *         每天上午10:15觸發
     * 		0 15 10 * * ? 2005  2005年的每天上午10:15觸發
     * 		0 * 14 * * ?  在每天下午2點到下午2:59期間的每1分鐘觸發
     * 		0 0/5 14 * * ? 在每天下午2點到下午2:55期間的每5分鐘觸發
     * 		0 0/5 14,18 * * ?  在每天下午2點到2:55期間和下午6點到6:55期間的每5分鐘觸發
     * 		0 0-5 14 * * ?  在每天下午2點到下午2:05期間的每1分鐘觸發
     * 		0 10,44 14 ? 3 WED   每年三月的星期三的下午2:10和2:44觸發
     * 		0 15 10 ? * MON-FRI  周一至周五的上午10:15觸發
     * 		0 15 10 15 * ?  每月15日上午10:15觸發
     * 		0 15 10 L * ? 每月最後一日的上午10:15觸發
     * 		0 15 10 ? * 6L  每月的最後一个星期五上午10:15觸發
     * 		0 15 10 ? * 6L 2002-2005  2002年至2005年的每月的最後一个星期五上午10:15觸發
     * 		0 15 10 ? * 6#3 每月的第三个星期五上午10:15觸發
     * </pre>
     */
    public String changeCronExpression(String year, String month, String day, String hour, String minute, String second){
    	String cronExpression = ""+second+" "+minute+" "+hour+" "+" "+day+" "+month+" ?";
		return cronExpression;
    }
    
    
    /**
     * 取得排程任務清單
     * @param status 狀態 0停用 1啟用 2刪除
     * @return Schedulejob 排程
     */
    public Schedulejob getQuartz(int jobId){
    	Schedulejob Schedulejob = scheduleJobService.get(jobId);
		return Schedulejob;
    }
    
    /**
     * 更新排程資訊
     * @param status 狀態 0停用 1啟用 2刪除
     * @return Schedulejob 排程
     */
    public void upQuartz(Schedulejob Schedulejob){
    	scheduleJobService.update(Schedulejob);
    }
    
    /**
     * 刪除排程
     * @param status 狀態 0停用 1啟用 2刪除
     * @return Schedulejob 排程
     */
    public void delQuartz(int jobId){
    	Schedulejob Schedulejob = this.getQuartz(jobId);
    	scheduleJobService.delete(Schedulejob);
    }
    
    /**
     * 取得排程任務清單
     * @param status 狀態 0停用 1啟用 2刪除
     * @return List<Schedulejob> 排程清單
     */
    public List<Schedulejob> getQuartzList(int status){
    	List<Schedulejob>  SchedulejobList = scheduleJobService.querySchedulejobData(status);
		return SchedulejobList;
    }
    
    
    /**
	 * 初始化 排程器任務
	 */
	public void initQuartz() {
		try {
			List<Schedulejob> scheduleJobList = this.getQuartzList(1);
			LOG.debug(" initQuartz ");
			LOG.debug(" scheduleJobList size "+scheduleJobList.size());
//			quartzHandler.addQuartz(quartzHandler.joinQuartz(1, "RankHandler", "1", 1, "0 0 * * * ?", "測試 RankHandler", "cs.server.handler.RankHandler", "RankHandler", "calculate"));
			for(int i=0; i<scheduleJobList.size(); i++){
				this.addQuartz(scheduleJobList.get(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
}
