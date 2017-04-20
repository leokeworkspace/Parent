package com.cs.service.quartz;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




import com.cs.model.quartz.Schedulejob;
import com.cs.util.quartz.ApplicationContextHelper;


/**
 * 排程執行任務 接口
 * @author Leo 
 */
public class QuartzJobService implements Job {

	private static final Logger LOG = LoggerFactory.getLogger(QuartzJobService.class);
	
	/**
	 * 執行排程任務 
	 * @param context 要執行排成的任務
	 */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOG.debug("----------------> 執行排程任務  <----------------");
        Schedulejob scheduleJob = (Schedulejob) context.getMergedJobDataMap().get("scheduleJob");
        LOG.debug("----------------> 執行排程名稱 = [" + scheduleJob.getJobName() + "]  time:[" + scheduleJob.getCronExpression() +"] <----------------");
        //判断是否有注入  或者是单纯的反射方法
        Object object = ApplicationContextHelper.getBean(scheduleJob.getBeanName());
        try {
	    	if(object!=null){
	    	  
				Class<?> amfClass = object.getClass();
				Method method = amfClass.getMethod(scheduleJob.getBeanMethod()) ;
			    method.invoke(amfClass.newInstance());
				LOG.debug(  scheduleJob.getBeanName() + " is Autowired ");
				LOG.debug("----------------> 執行排程任務 Bean: "+scheduleJob.getBeanName() + " is Autowired  <----------------");
			
	    	} else{
	    		Class<?> amfClass =  Class.forName(scheduleJob.getBeanAdderss());
	    		Method method = amfClass.getMethod(scheduleJob.getBeanMethod()) ;
			    method.invoke(amfClass.newInstance());
			    LOG.debug("----------------> 執行排程任務 Bean: "+scheduleJob.getBeanName() + " is new Class  <----------------");
	    	}
	      
	      
        } catch (NoSuchMethodException e) {
			LOG.error("QuartzJobService execute NoSuchMethodException ", e);
		} catch (SecurityException e) {
			LOG.error("QuartzJobService execute SecurityException ", e);
		} catch (IllegalAccessException e) {
			LOG.error("QuartzJobService execute IllegalAccessException", e);
		} catch (IllegalArgumentException e) {
			LOG.error("QuartzJobService execute IllegalArgumentException", e);
		} catch (InvocationTargetException e) {
			LOG.error("QuartzJobService execute InvocationTargetException", e);
		} catch (InstantiationException e) {
			LOG.error("QuartzJobService execute InstantiationException", e);
		} catch (ClassNotFoundException e) {
			LOG.error("QuartzJobService execute ClassNotFoundException", e);
		}
        
    }
}