package com.api.thuonglongjsc.model;

public class AdditionalStatus{
	private long statusCode;
	private String serverStatusCode;
	private String statusDesc;
	
	public long getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(long statusCode) {
		this.statusCode = statusCode;
	}
	public String getServerStatusCode() {
		return serverStatusCode;
	}
	public void setServerStatusCode(String serverStatusCode) {
		this.serverStatusCode = serverStatusCode;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
}
