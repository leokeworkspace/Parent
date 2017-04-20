package com.cs.model.springsecurity;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the security_user database table.
 * 
 */
@Entity
@Table(name="security_user")
@NamedQuery(name="SecurityUser.findAll", query="SELECT s FROM SecurityUser s")
public class SecurityUser implements Serializable {
	private static final long serialVersionUID = 1L;

	private String account;

	private Integer group;

	@Id
	private Integer id;

	@Column(name="login_time")
	private Timestamp loginTime;

	private String name;

	@Lob
	private String pages;

	private String password;

	@Column(name="reg_time")
	private Timestamp regTime;

	private byte status;

	public SecurityUser() {
	}

	public String getAccount() {
		return this.account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getGroup() {
		return this.group;
	}

	public void setGroup(Integer group) {
		this.group = group;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getLoginTime() {
		return this.loginTime;
	}

	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPages() {
		return this.pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getRegTime() {
		return this.regTime;
	}

	public void setRegTime(Timestamp regTime) {
		this.regTime = regTime;
	}

	public byte getStatus() {
		return this.status;
	}

	public void setStatus(byte status) {
		this.status = status;
	}

}