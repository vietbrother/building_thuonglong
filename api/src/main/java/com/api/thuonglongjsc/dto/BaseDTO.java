package com.api.thuonglongjsc.dto;

public class BaseDTO {
	private Integer pageSize;
	private Integer pageNumber;

	public BaseDTO() {
		super();
	}

	public BaseDTO(Integer pageSize, Integer pageNumber) {
		super();
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
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
		return "BaseDTO [pageSize=" + pageSize + ", pageNumber=" + pageNumber + "]";
	}

}
