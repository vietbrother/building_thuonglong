package com.api.thuonglongjsc.model;

import java.util.List;

public class Status {
	private long statusCode;
	private String serverStatusCode;
	private String statusDesc;
	private List<AdditionalStatus> additionalStatus;

	public Status() {
		super();
	}
	

	public Status(long statusCode, String statusDesc) {
		super();
		this.statusCode = statusCode;
		this.statusDesc = statusDesc;
	}


	public Status(String serverStatusCode, String statusDesc) {
		super();
		this.serverStatusCode = serverStatusCode;
		this.statusDesc = statusDesc;
	}

	public Status(long statusCode, String serverStatusCode, String statusDesc,
			List<AdditionalStatus> additionalStatus) {
		super();
		this.statusCode = statusCode;
		this.serverStatusCode = serverStatusCode;
		this.statusDesc = statusDesc;
		this.additionalStatus = additionalStatus;
	}

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

	public List<AdditionalStatus> getAdditionalStatus() {
		return additionalStatus;
	}

	public void setAdditionalStatus(List<AdditionalStatus> additionalStatus) {
		this.additionalStatus = additionalStatus;
	}
}
