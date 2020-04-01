package com.api.thuonglongjsc.dto;

public class ResultDTO {
	private String code;
	private String message;
	private String id;
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ResultDTO() {
		super();
	}

	public ResultDTO(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public ResultDTO(String code, String message, String id) {
		super();
		this.code = code;
		this.message = message;
		this.id = id;
	}

	@Override
	public String toString() {
		return "ResultDTO [code=" + code + ", message=" + message + "]";
	}

}
