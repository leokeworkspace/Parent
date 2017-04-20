package com.cs.data.dataPool.game;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cs.handler.quartz.QuartzHandler;

/**
 * 初始化線上玩家資料
 * 
 * @author Leo 最後更新時間:2015年3月18日 上午11:43:28
 */
@Component
public class InitUserDataPool implements InitializingBean {
	private static final Logger	LOG	= LoggerFactory.getLogger(InitUserDataPool.class);

	@Autowired
	private QuartzHandler quartzHandler;
	// 初始化順序 Constructor > @PostConstruct > InitializingBean > init-method
	// Spring 允许在 Bean 在初始化完成后以及 Bean 销毁前执行特定的操作，常用的设定方式有以下三种：
	// 通过实现 InitializingBean/DisposableBean 接口来定制初始化之后/销毁之前的操作方法；
	// 通过 <bean> 元素的 init-method/destroy-method属性指定初始化之后 /销毁之前调用的操作方法；
	// 在指定方法上加上@PostConstruct 或@PreDestroy注解来制定该方法是在初始化之后还是销毁之前调用。
	/**
	 * 初始化方法
	 */
	public InitUserDataPool() {
		LOG.info(" init InitUserDataPool InitSystemDataPool ");
	}

	/**
	 * spring 初始化方法
	 */
	@PostConstruct
	public void postConstruct() {
		LOG.info(" init InitUserDataPool postConstruct ");
	}

	/**
	 * spring 初始化方法(afterPropertiesSet是直接执行的，效率較高但init-method消除了bean对Spring依赖)
	 */
	@Override
	public void afterPropertiesSet() throws Exception {// initializing
		LOG.info(" init InitUserDataPool afterPropertiesSet ");
		init();
	}

	/**
	 * spring 初始化方法(init-method是通过反射執行的，效率比afterPropertiesSet差 )
	 */
	public void initMethod() {
		LOG.info(" init InitUserDataPool initMethod ");
	}

	/**
	 * spring 初始化方法(與PostConstruct 相反)
	 */
	@PreDestroy
	public void preDestroy() {
		LOG.info(" init InitUserDataPool postConstruct ");
	}

	/**
	 * 自定義初始化方法
	 */
	public void init() throws Exception {
		LOG.info(" init InitUserDataPool init() ");
		LOG.debug("=============> init InitUserDataPool init() <================");
		quartzHandler.initQuartz();
		LOG.debug("=============> quartzHandler.initQuartz() <================");
		LOG.debug("=============> init InitUserDataPool init() <================");
	}
}
