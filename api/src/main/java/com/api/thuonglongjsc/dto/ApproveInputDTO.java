package com.api.thuonglongjsc.dto;

public class ApproveInputDTO extends BaseDTO {
	private String contractId;
	private String username;
	private String type;
	private String approveStateId;
	private Integer pageSize;
	private Integer pageNumber;

	public ApproveInputDTO() {
		super();
	}

	public ApproveInputDTO(String contractId, String username, String type, String approveStateId, Integer pageSize,
			Integer pageNumber) {
		super();
		this.contractId = contractId;
		this.username = username;
		this.type = type;
		this.approveStateId = approveStateId;
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	@Override
	public String toString() {
		return "ApproveInputDTO [contractId=" + contractId + ", username=" + username + ", type=" + type
				+ ", approveStateId=" + approveStateId + ", pageSize=" + pageSize + ", pageNumber=" + pageNumber + "]";
	}

}
