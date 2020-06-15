package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class BricksTicket {
	private String ID;

	private Integer SoPhieu;

	private String TenBienSoXe;

	private String TenLaiXe;

	private Timestamp NgayThang;

	private String TenChiNhanh;

	private String TenNhaCungCap;

	private String CongTrinh;

	private String TenNhomVatLieu;

	private String TenLoaiVatLieu;

	private String TenDonViTinh;

	private Double SoLuongThucXuat;

	private Double SoLuongNhan;

	private BigDecimal DonGiaCoThue;

	private BigDecimal DonGiaKhongThue;

	private BigDecimal ThanhTienCoThue;

	private BigDecimal ThanhTienKhongThue;

	private String TrangThaiText;

	private String NguoiDuyet;

	private String NguoiXoa;

	private Timestamp NgayTao;

	private String NguoiTao;

	private String MoTa;

	private String IDChiNhanh;

	private Integer TrangThai;

	public BricksTicket() {
		super();
	}

	public BricksTicket(String iD, Integer soPhieu, String tenBienSoXe, String tenLaiXe, String tenChiNhanh,
			String tenNhaCungCap, String congTrinh, String tenNhomVatLieu, String tenLoaiVatLieu, String tenDonViTinh,
			Double soLuongThucXuat, Double soLuongNhan, BigDecimal donGiaCoThue, BigDecimal donGiaKhongThue,
			BigDecimal thanhTienCoThue, BigDecimal thanhTienKhongThue, String trangThaiText, String nguoiDuyet,
			String nguoiXoa, Timestamp ngayTao, String nguoiTao, String moTa, String iDChiNhanh, Integer trangThai) {
		super();
		ID = iD;
		SoPhieu = soPhieu;
		TenBienSoXe = tenBienSoXe;
		TenLaiXe = tenLaiXe;
		TenChiNhanh = tenChiNhanh;
		TenNhaCungCap = tenNhaCungCap;
		CongTrinh = congTrinh;
		TenNhomVatLieu = tenNhomVatLieu;
		TenLoaiVatLieu = tenLoaiVatLieu;
		TenDonViTinh = tenDonViTinh;
		SoLuongThucXuat = soLuongThucXuat;
		SoLuongNhan = soLuongNhan;
		DonGiaCoThue = donGiaCoThue;
		DonGiaKhongThue = donGiaKhongThue;
		ThanhTienCoThue = thanhTienCoThue;
		ThanhTienKhongThue = thanhTienKhongThue;
		TrangThaiText = trangThaiText;
		NguoiDuyet = nguoiDuyet;
		NguoiXoa = nguoiXoa;
		NgayTao = ngayTao;
		NguoiTao = nguoiTao;
		MoTa = moTa;
		IDChiNhanh = iDChiNhanh;
		TrangThai = trangThai;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Integer getSoPhieu() {
		return SoPhieu;
	}

	public void setSoPhieu(Integer soPhieu) {
		SoPhieu = soPhieu;
	}

	public String getTenBienSoXe() {
		return TenBienSoXe;
	}

	public void setTenBienSoXe(String tenBienSoXe) {
		TenBienSoXe = tenBienSoXe;
	}

	public String getTenLaiXe() {
		return TenLaiXe;
	}

	public void setTenLaiXe(String tenLaiXe) {
		TenLaiXe = tenLaiXe;
	}

	public Timestamp getNgayThang() {
		return NgayThang;
	}

	public void setNgayThang(Timestamp ngayThang) {
		NgayThang = ngayThang;
	}

	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
	}

	public String getCongTrinh() {
		return CongTrinh;
	}

	public void setCongTrinh(String congTrinh) {
		CongTrinh = congTrinh;
	}

	public String getTenNhomVatLieu() {
		return TenNhomVatLieu;
	}

	public void setTenNhomVatLieu(String tenNhomVatLieu) {
		TenNhomVatLieu = tenNhomVatLieu;
	}

	public String getTenLoaiVatLieu() {
		return TenLoaiVatLieu;
	}

	public void setTenLoaiVatLieu(String tenLoaiVatLieu) {
		TenLoaiVatLieu = tenLoaiVatLieu;
	}

	public String getTenDonViTinh() {
		return TenDonViTinh;
	}

	public void setTenDonViTinh(String tenDonViTinh) {
		TenDonViTinh = tenDonViTinh;
	}

	public Double getSoLuongThucXuat() {
		return SoLuongThucXuat;
	}

	public void setSoLuongThucXuat(Double soLuongThucXuat) {
		SoLuongThucXuat = soLuongThucXuat;
	}

	public Double getSoLuongNhan() {
		return SoLuongNhan;
	}

	public void setSoLuongNhan(Double soLuongNhan) {
		SoLuongNhan = soLuongNhan;
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

	public BigDecimal getThanhTienCoThue() {
		return ThanhTienCoThue;
	}

	public void setThanhTienCoThue(BigDecimal thanhTienCoThue) {
		ThanhTienCoThue = thanhTienCoThue;
	}

	public BigDecimal getThanhTienKhongThue() {
		return ThanhTienKhongThue;
	}

	public void setThanhTienKhongThue(BigDecimal thanhTienKhongThue) {
		ThanhTienKhongThue = thanhTienKhongThue;
	}

	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	public String getNguoiDuyet() {
		return NguoiDuyet;
	}

	public void setNguoiDuyet(String nguoiDuyet) {
		NguoiDuyet = nguoiDuyet;
	}

	public String getNguoiXoa() {
		return NguoiXoa;
	}

	public void setNguoiXoa(String nguoiXoa) {
		NguoiXoa = nguoiXoa;
	}

	public Timestamp getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(Timestamp ngayTao) {
		NgayTao = ngayTao;
	}

	public String getNguoiTao() {
		return NguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		NguoiTao = nguoiTao;
	}

	public String getMoTa() {
		return MoTa;
	}

	public void setMoTa(String moTa) {
		MoTa = moTa;
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
		return "BricksTicket [ID=" + ID + ", SoPhieu=" + SoPhieu + ", TenBienSoXe=" + TenBienSoXe + ", TenLaiXe="
				+ TenLaiXe + ", TenChiNhanh=" + TenChiNhanh + ", TenNhaCungCap=" + TenNhaCungCap + ", CongTrinh="
				+ CongTrinh + ", TenNhomVatLieu=" + TenNhomVatLieu + ", TenLoaiVatLieu=" + TenLoaiVatLieu
				+ ", TenDonViTinh=" + TenDonViTinh + ", SoLuongThucXuat=" + SoLuongThucXuat + ", SoLuongNhan="
				+ SoLuongNhan + ", DonGiaCoThue=" + DonGiaCoThue + ", DonGiaKhongThue=" + DonGiaKhongThue
				+ ", ThanhTienCoThue=" + ThanhTienCoThue + ", ThanhTienKhongThue=" + ThanhTienKhongThue
				+ ", TrangThaiText=" + TrangThaiText + ", NguoiDuyet=" + NguoiDuyet + ", NguoiXoa=" + NguoiXoa
				+ ", NgayTao=" + NgayTao + ", NguoiTao=" + NguoiTao + ", MoTa=" + MoTa + ", IDChiNhanh=" + IDChiNhanh
				+ ", TrangThai=" + TrangThai + "]";
	}
}
