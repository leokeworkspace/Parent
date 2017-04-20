package com.cs.model.springsecurity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the security_group database table.
 * 
 */
@Entity
@Table(name="security_group")
@NamedQuery(name="SecurityGroup.findAll", query="SELECT s FROM SecurityGroup s")
public class SecurityGroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="group_desc")
	private String groupDesc;
	
	@Id
	@Column(name="group_id")
	private Integer groupId;

	@Column(name="group_name")
	private String groupName;

	@Column(name="group_status")
	private Integer groupStatus;

	@Lob
	private String pages;

	public SecurityGroup() {
	}

	public String getGroupDesc() {
		return this.groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Integer getGroupStatus() {
		return this.groupStatus;
	}

	public void setGroupStatus(Integer groupStatus) {
		this.groupStatus = groupStatus;
	}

	public String getPages() {
		return this.pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

}