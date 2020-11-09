package com.api.thuonglongjsc.model;

public class RequestMessage {
	private String rquid;
	private String username;
	private String password;
	private String clientDt;
	private String channel;
	private String reftype;
	private String refid;
	private String sessionkey;
	private String spname;
	private Object data;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getClientDt() {
		return clientDt;
	}

	public void setClientDt(String clientDt) {
		this.clientDt = clientDt;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getReftype() {
		return reftype;
	}

	public void setReftype(String reftype) {
		this.reftype = reftype;
	}

	public String getRefid() {
		return refid;
	}

	public void setRefid(String refid) {
		this.refid = refid;
	}

	public String getSessionkey() {
		return sessionkey;
	}

	public void setSessionkey(String sessionkey) {
		this.sessionkey = sessionkey;
	}

	public String getSpname() {
		return spname;
	}

	public void setSpname(String spname) {
		this.spname = spname;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getRquid() {
		return rquid;
	}

	public void setRquid(String rquid) {
		this.rquid = rquid;
	}

	@Override
	public String toString() {
		return "RequestMessage [rquid=" + rquid + ", username=" + username + ", password=" + password + ", clientDt="
				+ clientDt + ", channel=" + channel + ", reftype=" + reftype + ", refid=" + refid + ", sessionkey="
				+ sessionkey + ", spname=" + spname + ", data=" + data + "]";
	}

}
