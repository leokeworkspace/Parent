package com.cs.model.quartz;

import java.io.Serializable;
import javax.persistence.*;


/**
 * 排程資料表
 * @param jobId 任務編號
 * @param jobName 名稱
 * @param jobGroup 群組.
 * @param jobStatus 狀態 0停用 1啟用 2刪除
 * @param cronExpression 運行時間
 * @param desc 描述說明
 * @param beanAdderss class 位置
 * @param beanName 注入的bean 名稱
 * @param beanMethod 要執行方法
 * @author Leo
 */
@Entity
@Table(name="schedulejob")
@NamedQuery(name="Schedulejob.findAll", query="SELECT s FROM Schedulejob s")
public class Schedulejob implements Serializable {
	private static final long serialVersionUID = 1L;
	private int jobId;
	private String beanAdderss;
	private String beanMethod;
	private String beanName;
	private String cronExpression;
	private String desc;
	private String jobGroup;
	private String jobName;
	private int jobStatus;

	public Schedulejob() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getJobId() {
		return this.jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	@Column(nullable=false, length=256)
	public String getBeanAdderss() {
		return this.beanAdderss;
	}

	public void setBeanAdderss(String beanAdderss) {
		this.beanAdderss = beanAdderss;
	}


	@Column(nullable=false, length=256)
	public String getBeanMethod() {
		return this.beanMethod;
	}

	public void setBeanMethod(String beanMethod) {
		this.beanMethod = beanMethod;
	}


	@Column(nullable=false, length=256)
	public String getBeanName() {
		return this.beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}


	@Column(nullable=false, length=128)
	public String getCronExpression() {
		return this.cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}


	@Column(nullable=false, length=256)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	@Column(nullable=false, length=11)
	public String getJobGroup() {
		return this.jobGroup;
	}

	public void setJobGroup(String jobGroup) {
		this.jobGroup = jobGroup;
	}


	@Column(nullable=false, length=128)
	public String getJobName() {
		return this.jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}


	@Column(nullable=false)
	public int getJobStatus() {
		return this.jobStatus;
	}

	public void setJobStatus(int jobStatus) {
		this.jobStatus = jobStatus;
	}

}