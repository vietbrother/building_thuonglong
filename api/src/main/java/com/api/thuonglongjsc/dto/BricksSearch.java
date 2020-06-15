package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class BricksSearch {

	private String IDChiNhanh;
	private String IDNhaCungCap;
	private String TuNgay;
	private String DenNgay;
	private String idHopDong;
	private String idTrangThai;
	private String TrangThaiText;

	public BricksSearch() {
		super();
	}

	public BricksSearch(String iDChiNhanh, String iDNhaCungCap, String tuNgay, String denNgay, String idHopDong,
			String idTrangThai, String trangThaiText) {
		super();
		IDChiNhanh = iDChiNhanh;
		IDNhaCungCap = iDNhaCungCap;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		this.idHopDong = idHopDong;
		this.idTrangThai = idTrangThai;
		TrangThaiText = trangThaiText;
	}

	public String getIDChiNhanh() {
		return IDChiNhanh;
	}

	public void setIDChiNhanh(String iDChiNhanh) {
		IDChiNhanh = iDChiNhanh;
	}

	public String getIDNhaCungCap() {
		return IDNhaCungCap;
	}

	public void setIDNhaCungCap(String iDNhaCungCap) {
		IDNhaCungCap = iDNhaCungCap;
	}

	public String getTuNgay() {
		return TuNgay;
	}

	public void setTuNgay(String tuNgay) {
		TuNgay = tuNgay;
	}

	public String getDenNgay() {
		return DenNgay;
	}

	public void setDenNgay(String denNgay) {
		DenNgay = denNgay;
	}

	public String getIdHopDong() {
		return idHopDong;
	}

	public void setIdHopDong(String idHopDong) {
		this.idHopDong = idHopDong;
	}

	public String getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(String idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	@Override
	public String toString() {
		return "BricksSearch [IDChiNhanh=" + IDChiNhanh + ", IDNhaCungCap=" + IDNhaCungCap + ", TuNgay=" + TuNgay
				+ ", DenNgay=" + DenNgay + ", idHopDong=" + idHopDong + ", idTrangThai=" + idTrangThai
				+ ", TrangThaiText=" + TrangThaiText + "]";
	}

}
