package com.cs.aop.aspect.backend;

import net.sf.json.JSONArray;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 遊戲log 紀錄工具
 * 
 * @author childhood-leo
 */
@Aspect
@Component
public class BackendLogAspect {
	private static final Logger	LOG	= LoggerFactory.getLogger(BackendLogAspect.class);

	/**
	 * 在method執行之前會先執行此段程式
	 * 
	 * @param joinPoint
	 */
	@Before("execution(* com.cs.db.service.user.*.find*(..))")
	public void before(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		LOG.debug("before() is running!");
		LOG.debug("call Method : " + joinPoint.getSignature().getName());
		LOG.debug("logAround:" + JSONArray.fromObject(args).toString());
		LOG.debug("before() is running end!");
	}

	// 方法一
	// @Around("execution(* com.shacom.tfe.schedule.service.BidOpeningService.executeBidOpening(..)) || " +
	// "execution(* com.shacom.tfe.schedule.service.NextPeriodBidPassCheckService.executeCheck(..))  " )
	// 方法二
	// @Around("execution(* com.cs.db.service.user.*.find*(..))")// 統整設定
	/**
	 * 在method執行前 & 執行後的攔截方法 & 並可修改回傳值
	 * 
	 * @param joinPoint 連接對象
	 */
	@Around("execution(* com.cs.db.service.user.*.find*(..))")
	// 統整設定
	public int logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 傳入參數
		Object[] args = joinPoint.getArgs();
		try {
			LOG.debug("logAround() is running!");
			LOG.debug("logAround:" + JSONArray.fromObject(args).toString());
			LOG.debug("call Method : " + joinPoint.getSignature().getName());
			LOG.debug("call proceed() Before");
			// proceed 為回傳值 return
			int count = (int) joinPoint.proceed();
			LOG.debug("call proceed() After");
			count = 0;
			LOG.debug("logAround() is running end!");
			return count;
		}
		catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return 0;
	}

	/**
	 * 在method執行完後會執行此段程式
	 * 
	 * @param joinPoint
	 */
	@After("execution(* com.cs.db.service.user.*.find*(..)) ")
	public void after(JoinPoint joinPoint) {
		Object[] args = joinPoint.getArgs();
		LOG.debug("after() is running!");
		LOG.debug("call Method : " + joinPoint.getSignature().getName());
		LOG.debug("logAround:" + JSONArray.fromObject(args).toString());
		LOG.debug("after() is running end!");
	}

	/**
	 * 在method執行完並且有成功return時會執行此段程式
	 * 
	 * @param joinPoint 連接對象
	 * @param result 回傳值
	 */
	@AfterReturning(pointcut = "execution(* com.cs.db.service.user.*.find*(..))", returning = "result")
	public void logAfterReturning(JoinPoint joinPoint, Object result) {
		// 傳入參數
		Object[] args = joinPoint.getArgs();
		LOG.debug("logAfterReturning() is running!");
		LOG.debug("call Method : " + joinPoint.getSignature().getName());
		LOG.debug("logAround:" + JSONArray.fromObject(args).toString());
		LOG.debug("Method returned value is : " + result);
		LOG.debug("logAfterReturning() is running end!");
	}

	/**
	 * 在method執行中拋出Exception時會執行此段程式
	 * 
	 * @param joinPoint 連接對象
	 * @param error 例外訊息
	 */
	@AfterThrowing(pointcut = "execution(* com.cs.db.service.user.*.find*(..)) ", throwing = "error")
	public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		// 傳入參數
		Object[] args = joinPoint.getArgs();
		LOG.debug("logAfterThrowing() is running!");
		LOG.debug("call Method : " + joinPoint.getSignature().getName());
		LOG.debug("logAround:" + JSONArray.fromObject(args).toString());
		LOG.debug("Exception : " + error);
		LOG.debug("logAfterThrowing() is running end!");
	}
}
