package com.cs.data.dataPool.game;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/** 
 * 初始化系統資料
 */ 
@Component("InitSystemDataPool")
public class InitSystemDataPool implements InitializingBean{

	private static final Logger LOG = LoggerFactory.getLogger(InitSystemDataPool.class);
	
	
	//初始化順序  Constructor > @PostConstruct > InitializingBean > init-method
	//Spring 允许在 Bean 在初始化完成后以及 Bean 销毁前执行特定的操作，常用的设定方式有以下三种：
	//通过实现 InitializingBean/DisposableBean 接口来定制初始化之后/销毁之前的操作方法；
	//通过 <bean> 元素的 init-method/destroy-method属性指定初始化之后 /销毁之前调用的操作方法；
	//在指定方法上加上@PostConstruct 或@PreDestroy注解来制定该方法是在初始化之后还是销毁之前调用。
	
	/**
	 * 初始化方法
	 */
	public InitSystemDataPool() {
		LOG.info(" init InitSystemDataPool InitSystemDataPool ");
		LOG.debug("====> init InitSystemDataPool <====");
	}
	   
	/**
	 * spring 初始化方法
	 */
	@PostConstruct
	public void postConstruct() {
		LOG.info(" init InitSystemDataPool postConstruct ");
		LOG.debug("====> init postConstruct <====");
	}
	
	/**
	 * spring 初始化方法(afterPropertiesSet是直接执行的，效率較高但init-method消除了bean对Spring依赖)
	 */
	@Override
	public void afterPropertiesSet() throws Exception {//initializing
		LOG.info(" init InitSystemDataPool afterPropertiesSet ");
		LOG.debug("====> init afterPropertiesSet <====");
		init();
	}
	
	/**
	 * spring 初始化方法(init-method是通过反射執行的，效率比afterPropertiesSet差 )
	 */
	public void initMethod() {
		LOG.info(" init InitSystemDataPool initMethod ");
		LOG.debug("====> init initMethod <====");
	}
	
	/**
	 * spring 初始化方法(與PostConstruct 相反)
	 */
	@PreDestroy
	public void preDestroy() {
		LOG.info(" init InitSystemDataPool postConstruct ");
		LOG.debug("====> init preDestroy <====");
	}
	
	/**
	 * 自定義初始化方法
	 */
	public void init() throws Exception {
		LOG.info(" init InitSystemDataPool init() ");
	}
	
	

}
