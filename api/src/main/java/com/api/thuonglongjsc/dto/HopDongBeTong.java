package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class HopDongBeTong {
	private String ID;
	private Integer SoHD;
	private String TenChiNhanh;
	private String CongTrinh;
	private String TenNhaCungCap;
	private String NhaCungCap;
	private String MacBeTong;
	private BigDecimal DonGiaCoThue;
	private BigDecimal DonGiaKhongThue;
	private Double KhoiLuongDuKien;
	private Timestamp TuNgay;
	private Timestamp DenNgay;
	private String TrangThaiText;
	private String NguoiTao;
	private Timestamp NgayTao;
	private String IDChiNhanh;
	private Integer TrangThai;

	public HopDongBeTong() {
		super();
	}

	public HopDongBeTong(String iD, Integer soHD, String tenChiNhanh, String congTrinh, String tenNhaCungCap,
			String nhaCungCap, String MacBeTong, BigDecimal donGiaCoThue, BigDecimal donGiaKhongThue,
			Double khoiLuongDuKien, Timestamp tuNgay, Timestamp denNgay, String trangThaiText, String nguoiTao,
			Timestamp ngayTao, String iDChiNhanh, Integer trangThai) {
		super();
		ID = iD;
		SoHD = soHD;
		TenChiNhanh = tenChiNhanh;
		CongTrinh = congTrinh;
		TenNhaCungCap = tenNhaCungCap;
		NhaCungCap = nhaCungCap;
		MacBeTong = MacBeTong;
		DonGiaCoThue = donGiaCoThue;
		DonGiaKhongThue = donGiaKhongThue;
		KhoiLuongDuKien = khoiLuongDuKien;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		TrangThaiText = trangThaiText;
		NguoiTao = nguoiTao;
		NgayTao = ngayTao;
		IDChiNhanh = iDChiNhanh;
		TrangThai = trangThai;
	}

	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Integer getSoHD() {
		return SoHD;
	}

	public void setSoHD(Integer soHD) {
		SoHD = soHD;
	}

	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	public String getCongTrinh() {
		return CongTrinh;
	}

	public void setCongTrinh(String congTrinh) {
		CongTrinh = congTrinh;
	}

	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
	}

	public String getNhaCungCap() {
		return NhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		NhaCungCap = nhaCungCap;
	}

	public String getMacBeTong() {
		return MacBeTong;
	}

	public void setMacBeTong(String MacBeTong) {
		MacBeTong = MacBeTong;
	}

	public BigDecimal getDonGiaCoThue() {
		return DonGiaCoThue;
	}

	public void setDonGiaCoThue(BigDecimal donGiaCoThue) {
		DonGiaCoThue = donGiaCoThue;
	}

	public BigDecimal getDonGiaKhongThue() {
		return DonGiaKhongThue;
	}

	public void setDonGiaKhongThue(BigDecimal donGiaKhongThue) {
		DonGiaKhongThue = donGiaKhongThue;
	}

	public Double getKhoiLuongDuKien() {
		return KhoiLuongDuKien;
	}

	public void setKhoiLuongDuKien(Double khoiLuongDuKien) {
		KhoiLuongDuKien = khoiLuongDuKien;
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

	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	public String getNguoiTao() {
		return NguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		NguoiTao = nguoiTao;
	}

	public Timestamp getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		NgayTao = ngayTao;
	}

	public String getIDChiNhanh() {
		return IDChiNhanh;
	}

	public void setIDChiNhanh(String iDChiNhanh) {
		IDChiNhanh = iDChiNhanh;
	}

	public Integer getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Integer trangThai) {
		TrangThai = trangThai;
	}

	@Override
	public String toString() {
		return "HopDongBeTong [ID=" + ID + ", SoHD=" + SoHD + ", TenChiNhanh=" + TenChiNhanh + ", CongTrinh="
				+ CongTrinh + ", TenNhaCungCap=" + TenNhaCungCap + ", NhaCungCap=" + NhaCungCap + ", MacBeTong="
				+ MacBeTong + ", DonGiaCoThue=" + DonGiaCoThue + ", DonGiaKhongThue=" + DonGiaKhongThue
				+ ", KhoiLuongDuKien=" + KhoiLuongDuKien + ", TuNgay=" + TuNgay + ", DenNgay=" + DenNgay
				+ ", TrangThaiText=" + TrangThaiText + ", NguoiTao=" + NguoiTao + ", NgayTao=" + NgayTao
				+ ", IDChiNhanh=" + IDChiNhanh + ", TrangThai=" + TrangThai + "]";
	}

}
