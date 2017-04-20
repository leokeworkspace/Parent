package com.cs.util;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class JqgridResponse<T extends Serializable> {

	//Current page
	private String page;
	
	//Total pages
	private String total;
	
	//總筆數
	private String records;
	
	//actual data
	private List<T> rows;

	//other data
	private Map<String, String> dataMap;
	
	/**
	 * @param currentPage 回傳頁面顯示頁數
	 * @param rowsPerPage 每頁顯示筆數
	 * @param queryTotalSize 查詢結果總筆數
	 */
	public void setQueryPageParameter(int currentPage, int rowsPerPage, int queryTotalSize){
		setPage(String.valueOf(currentPage));
		setTotal(String.valueOf((queryTotalSize % rowsPerPage == 0)? queryTotalSize / rowsPerPage : queryTotalSize / rowsPerPage + 1));
		setRecords(String.valueOf(queryTotalSize));
	}
	
	public JqgridResponse() {
		
	}
	

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}


	public String getPage() {
		return page;
	}


	public void setPage(String page) {
		this.page = page;
	}


	public String getTotal() {
		return total;
	}


	public void setTotal(String total) {
		this.total = total;
	}


	public String getRecords() {
		return records;
	}


	public void setRecords(String records) {
		this.records = records;
	}


	public Map<String, String> getDataMap() {
		return dataMap;
	}


	public void setDataMap(Map<String, String> dataMap) {
		this.dataMap = dataMap;
	}
}