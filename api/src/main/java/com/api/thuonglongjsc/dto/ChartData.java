package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class ChartData {
	private String IDChiNhanh;
	private String TenChiNhanh;
	private Integer total;
	

	public ChartData() {
		super();
	}

	public ChartData(String iDChiNhanh, String tenChiNhanh, Integer total) {
		super();
		IDChiNhanh = iDChiNhanh;
		TenChiNhanh = tenChiNhanh;
		this.total = total;
	}

	public String getIDChiNhanh() {
		return IDChiNhanh;
	}

	public void setIDChiNhanh(String iDChiNhanh) {
		IDChiNhanh = iDChiNhanh;
	}

	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "ChartTotalData [IDChiNhanh=" + IDChiNhanh + ", TenChiNhanh=" + TenChiNhanh + ", total=" + total + "]";
	}

}
