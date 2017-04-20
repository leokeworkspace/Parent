package com.cs.util;

import net.sf.json.JSONObject;

public class JqgridFindRequest {

	
	/**
	 * 目前頁面
	 */
	private int page;
	
	/**
	 * 每頁顯示比數
	 */
	private int rows;
	
	/**
	 * 排序欄位
	 */
	private String sidx;
	
	/**
	 * 排序欄位 asc or desc
	 */
	private String sord;
	
	/**
	 * 是否要查詢
	 * true or false
	 */
	private boolean search;
	
	/**
	 * 查詢欄位(find=true)
	 */
	private String searchField;
	
	/**
	 * 查詢傳入資料(find=true)
	 */
	private String searchString;
	
	/**
	 * 查詢條件(find=true)
	 * <pre>
	 * eq 等於  
	 * ne 不等於  
	 * bw 開始於  
	 * bn 不開始於  
	 * ew 結束於  
	 * en 不結束於  
	 * cn 包含  
	 * nc 不包含  
	 * nu is null 
	 * nn is not null 
	 * in 在其中  
	 * ni 不在其中
	 * </pre>
	 */
	private String searchOper;
	
	public JqgridFindRequest(){		
		this.search = false;
		this.searchField = null;
		this.searchString = null;
		this.searchOper = null;
	}
	
	/**
	 * 一般查詢
	 * @param page
	 * @param rows
	 * @param sidx
	 * @param sord
	 */
	public JqgridFindRequest(JSONObject rsJso){
		this.page = rsJso.getInt("page");
		this.rows = rsJso.getInt("rows");
		this.sidx = rsJso.getString("sidx");
		this.sord = rsJso.getString("sord");
		this.search = rsJso.getBoolean("_search");
		if(search){			
			this.searchField = rsJso.getString("searchField");
			this.searchString = rsJso.getString("searchString");
			this.searchOper = rsJso.getString("searchOper");
		}
	}
	
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public String getSidx() {
		return sidx;
	}
	public void setSidx(String sidx) {
		this.sidx = sidx;
	}
	public String getSord() {
		return sord;
	}
	public void setSord(String sord) {
		this.sord = sord;
	}
	public boolean isSearch() {
		return search;
	}
	public void setSearch(boolean search) {
		this.search = search;
	}
	public String getSearchField() {
		return searchField;
	}
	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	public String getSearchString() {
		return searchString;
	}
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}
	public String getSearchOper() {
		return searchOper;
	}
	public void setSearchOper(String searchOper) {
		this.searchOper = searchOper;
	}

	
}