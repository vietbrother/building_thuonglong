package com.api.thuonglongjsc.model;

public class ResponseMessage {
	private String RqUID;
	private Status status;
	private Object data;

	public ResponseMessage() {
		super();
	}

	public ResponseMessage(String rqUID, Status status, Object data) {
		super();
		RqUID = rqUID;
		this.status = status;
		this.data = data;
	}

	public String getRqUID() {
		return RqUID;
	}

	public void setRqUID(String rqUID) {
		RqUID = rqUID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseMessage [RqUID=" + RqUID + ", status=" + status + ", data=" + data + "]";
	}
}
