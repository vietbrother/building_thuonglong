package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class ChartDataDetail {
	private String IDChiNhanh;
	private String TenChiNhanh;
	private Integer total;
	private Timestamp TuNgay;
	private Timestamp DenNgay;
	private String TrangThai;
	private String TrangThaiText;

	public ChartDataDetail() {
		super();
	}

	public ChartDataDetail(String iDChiNhanh, String tenChiNhanh, Integer total) {
		super();
		IDChiNhanh = iDChiNhanh;
		TenChiNhanh = tenChiNhanh;
		this.total = total;
	}


	public ChartDataDetail(String iDChiNhanh, String tenChiNhanh, Integer total, Timestamp tuNgay, Timestamp denNgay,
			String trangThai, String trangThaiText) {
		super();
		IDChiNhanh = iDChiNhanh;
		TenChiNhanh = tenChiNhanh;
		this.total = total;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		TrangThai = trangThai;
		TrangThaiText = trangThaiText;
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

	public Timestamp getTuNgay() {
		return TuNgay;
	}

	public void setTuNgay(Timestamp tuNgay) {
		TuNgay = tuNgay;
	}

	public Timestamp getDenNgay() {
		return DenNgay;
	}

	public void setDenNgay(Timestamp denNgay) {
		DenNgay = denNgay;
	}

	public String getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(String trangThai) {
		TrangThai = trangThai;
	}

	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	@Override
	public String toString() {
		return "ChartDataDetail [IDChiNhanh=" + IDChiNhanh + ", TenChiNhanh=" + TenChiNhanh + ", total=" + total
				+ ", TuNgay=" + TuNgay + ", DenNgay=" + DenNgay + ", TrangThai=" + TrangThai + ", TrangThaiText="
				+ TrangThaiText + "]";
	}



}
