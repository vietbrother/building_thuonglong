package com.api.thuonglongjsc.dto;

public class LichXuatBeTong {
	private String ID;
	private String NgayThang;
	private String GioXuat;
	private String TenChiNhanh;
	private String TenCongTrinh;
	private String TenNhaCungCap;
	private String TenMacBeTong;
	private String TenLoaiDa;
	private String TenDoSut;
	private String TenYCDB;
	private String TenHinhThucBom;
	private String KLThucXuat;
	private String KLKhachHang;
	private String TrangThaiText;
	private String NguoiTao;
	private String NgayTao;

	public LichXuatBeTong() {
		super();
	}

	public LichXuatBeTong(String iD, String ngayThang, String gioXuat, String tenChiNhanh, String tenCongTrinh,
			String tenNhaCungCap, String tenMacBeTong, String tenLoaiDa, String tenDoSut, String tenYCDB,
			String tenHinhThucBom, String kLThucXuat, String kLKhachHang, String trangThaiText, String nguoiTao,
			String ngayTao) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		GioXuat = gioXuat;
		TenChiNhanh = tenChiNhanh;
		TenCongTrinh = tenCongTrinh;
		TenNhaCungCap = tenNhaCungCap;
		TenMacBeTong = tenMacBeTong;
		TenLoaiDa = tenLoaiDa;
		TenDoSut = tenDoSut;
		TenYCDB = tenYCDB;
		TenHinhThucBom = tenHinhThucBom;
		KLThucXuat = kLThucXuat;
		KLKhachHang = kLKhachHang;
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

	public String getNgayThang() {
		return NgayThang;
	}

	public void setNgayThang(String ngayThang) {
		NgayThang = ngayThang;
	}

	public String getGioXuat() {
		return GioXuat;
	}

	public void setGioXuat(String gioXuat) {
		GioXuat = gioXuat;
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

	public String getTenHinhThucBom() {
		return TenHinhThucBom;
	}

	public void setTenHinhThucBom(String tenHinhThucBom) {
		TenHinhThucBom = tenHinhThucBom;
	}

	public String getKLThucXuat() {
		return KLThucXuat;
	}

	public void setKLThucXuat(String kLThucXuat) {
		KLThucXuat = kLThucXuat;
	}

	public String getKLKhachHang() {
		return KLKhachHang;
	}

	public void setKLKhachHang(String kLKhachHang) {
		KLKhachHang = kLKhachHang;
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
		return "LichXuatBeTong [ID=" + ID + ", NgayThang=" + NgayThang + ", GioXuat=" + GioXuat + ", TenChiNhanh="
				+ TenChiNhanh + ", TenCongTrinh=" + TenCongTrinh + ", TenNhaCungCap=" + TenNhaCungCap
				+ ", TenMacBeTong=" + TenMacBeTong + ", TenLoaiDa=" + TenLoaiDa + ", TenDoSut=" + TenDoSut
				+ ", TenYCDB=" + TenYCDB + ", TenHinhThucBom=" + TenHinhThucBom + ", KLThucXuat=" + KLThucXuat
				+ ", KLKhachHang=" + KLKhachHang + ", TrangThaiText=" + TrangThaiText + ", NguoiTao=" + NguoiTao
				+ ", NgayTao=" + NgayTao + "]";
	}

}
