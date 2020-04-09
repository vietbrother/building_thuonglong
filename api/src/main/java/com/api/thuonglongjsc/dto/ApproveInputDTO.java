package com.api.thuonglongjsc.dto;

public class ApproveInputDTO {
	private String contractId;
	private String username;
	private String type;
	private String approveStateId;

	public ApproveInputDTO() {
		super();
	}

	public ApproveInputDTO(String contractId, String username, String type, String approveStateId) {
		super();
		this.contractId = contractId;
		this.username = username;
		this.type = type;
		this.approveStateId = approveStateId;
	}

	public String getContractId() {
		return contractId;
	}

	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getApproveStateId() {
		return approveStateId;
	}

	public void setApproveStateId(String approveStateId) {
		this.approveStateId = approveStateId;
	}

	@Override
	public String toString() {
		return "ApproveInputDTO [contractId=" + contractId + ", username=" + username + ", type=" + type
				+ ", approveStateId=" + approveStateId + "]";
	}

}
