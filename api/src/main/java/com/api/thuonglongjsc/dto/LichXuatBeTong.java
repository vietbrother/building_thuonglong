package com.api.thuonglongjsc.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class LichXuatBeTong {
	private String ID;
	private Timestamp NgayThang;
	private Time GioXuat;
	private String TenChiNhanh;
	private String TenCongTrinh;
	private String TenNhaCungCap;
	private String TenMacBeTong;
	private String TenLoaiDa;
	private String TenDoSut;
	private String TenYCDB;
	private String TenHinhThucBom;
	private Double KLThucXuat;
	private Double KLKhachHang;
	private String TrangThaiText;
	private String NguoiTao;
	private Timestamp NgayTao;
	private String IDChiNhanh;
	private Integer TrangThai;

	public LichXuatBeTong() {
		super();
	}

	public LichXuatBeTong(String iD, Timestamp ngayThang, Time gioXuat, String tenChiNhanh, String tenCongTrinh,
			String tenNhaCungCap, String tenMacBeTong, String tenLoaiDa, String tenDoSut, String tenYCDB,
			String tenHinhThucBom, Double kLThucXuat, Double kLKhachHang, String trangThaiText, String nguoiTao,
			Timestamp ngayTao, String iDChiNhanh, Integer trangThai) {
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
		IDChiNhanh = iDChiNhanh;
		TrangThai = trangThai;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Timestamp getNgayThang() {
		return NgayThang;
	}

	public void setNgayThang(Timestamp ngayThang) {
		NgayThang = ngayThang;
	}

	public Time getGioXuat() {
		return GioXuat;
	}

	public void setGioXuat(Time gioXuat) {
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

	public Double getKLThucXuat() {
		return KLThucXuat;
	}

	public void setKLThucXuat(Double kLThucXuat) {
		KLThucXuat = kLThucXuat;
	}

	public Double getKLKhachHang() {
		return KLKhachHang;
	}

	public void setKLKhachHang(Double kLKhachHang) {
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
		return "LichXuatBeTong [ID=" + ID + ", NgayThang=" + NgayThang + ", GioXuat=" + GioXuat + ", TenChiNhanh="
				+ TenChiNhanh + ", TenCongTrinh=" + TenCongTrinh + ", TenNhaCungCap=" + TenNhaCungCap
				+ ", TenMacBeTong=" + TenMacBeTong + ", TenLoaiDa=" + TenLoaiDa + ", TenDoSut=" + TenDoSut
				+ ", TenYCDB=" + TenYCDB + ", TenHinhThucBom=" + TenHinhThucBom + ", KLThucXuat=" + KLThucXuat
				+ ", KLKhachHang=" + KLKhachHang + ", TrangThaiText=" + TrangThaiText + ", NguoiTao=" + NguoiTao
				+ ", NgayTao=" + NgayTao + ", IDChiNhanh=" + IDChiNhanh + ", TrangThai=" + TrangThai + "]";
	}

}
