package com.cs.model.springsecurity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the security_page database table.
 * 
 */
@Entity
@Table(name="security_page")
@NamedQuery(name="SecurityPage.findAll", query="SELECT s FROM SecurityPage s")
public class SecurityPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="page_id")
	private Integer pageId;

	@Column(name="page_name")
	private String pageName;

	@Column(name="page_switch")
	private Integer pageSwitch;

	private Integer sort;

	private Integer type;

	@Column(name="view_icon")
	private String viewIcon;

	@Column(name="view_url")
	private String viewUrl;

	public SecurityPage() {
	}

	public Integer getPageId() {
		return this.pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	public String getPageName() {
		return this.pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public Integer getPageSwitch() {
		return this.pageSwitch;
	}

	public void setPageSwitch(Integer pageSwitch) {
		this.pageSwitch = pageSwitch;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getViewIcon() {
		return this.viewIcon;
	}

	public void setViewIcon(String viewIcon) {
		this.viewIcon = viewIcon;
	}

	public String getViewUrl() {
		return this.viewUrl;
	}

	public void setViewUrl(String viewUrl) {
		this.viewUrl = viewUrl;
	}

}