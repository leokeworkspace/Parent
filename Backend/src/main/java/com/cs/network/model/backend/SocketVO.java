package com.cs.network.model.backend;

/**
 * 封包協定
 * 
 * @param methodName 方法名稱
 * @param paramObject 訊息內容(內容型態為JSONbject)
 * @author Leo 最後更新時間:2015年3月18日 上午11:43:28
 */
public class SocketVO {
	// 方法名稱
	private String	methodName	= null;
	// 訊息內容
	private Object	paramObject	= null;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object getParamObject() {
		return paramObject;
	}

	public void setParamObject(Object paramObject) {
		this.paramObject = paramObject;
	}
}
