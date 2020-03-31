package com.api.thuonglongjsc.dto;

public class HopDongBeTong {
	private String ID;
	private String TenChiNhanh;
	private String TenCongTrinh;
	private String TenNhaCungCap;
	private String TenMacBeTong;
	private String TenLoaiDa;
	private String TenDoSut;
	private String TenYCDB;
	private String DonGiaHoaDon;
	private String DonGiaThanhToan;
	private String TuNgay;
	private String DenNgay;
	private String TrangThaiText;
	private String NguoiTao;
	private String NgayTao;

	public HopDongBeTong() {
		super();
	}

	public HopDongBeTong(String iD, String tenChiNhanh, String tenCongTrinh, String tenNhaCungCap, String tenMacBeTong,
			String tenLoaiDa, String tenDoSut, String tenYCDB, String donGiaHoaDon, String donGiaThanhToan,
			String tuNgay, String denNgay, String trangThaiText, String nguoiTao, String ngayTao) {
		super();
		ID = iD;
		TenChiNhanh = tenChiNhanh;
		TenCongTrinh = tenCongTrinh;
		TenNhaCungCap = tenNhaCungCap;
		TenMacBeTong = tenMacBeTong;
		TenLoaiDa = tenLoaiDa;
		TenDoSut = tenDoSut;
		TenYCDB = tenYCDB;
		DonGiaHoaDon = donGiaHoaDon;
		DonGiaThanhToan = donGiaThanhToan;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		TrangThaiText = trangThaiText;
		NguoiTao = nguoiTao;
		NgayTao = ngayTao;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	public String getTenCongTrinh() {
		return TenCongTrinh;
	}

	public void setTenCongTrinh(String tenCongTrinh) {
		TenCongTrinh = tenCongTrinh;
	}

	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
	}

	public String getTenMacBeTong() {
		return TenMacBeTong;
	}

	public void setTenMacBeTong(String tenMacBeTong) {
		TenMacBeTong = tenMacBeTong;
	}

	public String getTenLoaiDa() {
		return TenLoaiDa;
	}

	public void setTenLoaiDa(String tenLoaiDa) {
		TenLoaiDa = tenLoaiDa;
	}

	public String getTenDoSut() {
		return TenDoSut;
	}

	public void setTenDoSut(String tenDoSut) {
		TenDoSut = tenDoSut;
	}

	public String getTenYCDB() {
		return TenYCDB;
	}

	public void setTenYCDB(String tenYCDB) {
		TenYCDB = tenYCDB;
	}

	public String getDonGiaHoaDon() {
		return DonGiaHoaDon;
	}

	public void setDonGiaHoaDon(String donGiaHoaDon) {
		DonGiaHoaDon = donGiaHoaDon;
	}

	public String getDonGiaThanhToan() {
		return DonGiaThanhToan;
	}

	public void setDonGiaThanhToan(String donGiaThanhToan) {
		DonGiaThanhToan = donGiaThanhToan;
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

	public String getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(String ngayTao) {
		NgayTao = ngayTao;
	}

	@Override
	public String toString() {
		return "HopDongBeTong [ID=" + ID + ", TenChiNhanh=" + TenChiNhanh + ", TenCongTrinh=" + TenCongTrinh
				+ ", TenNhaCungCap=" + TenNhaCungCap + ", TenMacBeTong=" + TenMacBeTong + ", TenLoaiDa=" + TenLoaiDa
				+ ", TenDoSut=" + TenDoSut + ", TenYCDB=" + TenYCDB + ", DonGiaHoaDon=" + DonGiaHoaDon
				+ ", DonGiaThanhToan=" + DonGiaThanhToan + ", TuNgay=" + TuNgay + ", DenNgay=" + DenNgay
				+ ", TrangThaiText=" + TrangThaiText + ", NguoiTao=" + NguoiTao + ", NgayTao=" + NgayTao + "]";
	}
}
