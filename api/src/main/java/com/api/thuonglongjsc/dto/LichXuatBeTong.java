package com.api.thuonglongjsc.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class LichXuatBeTong {
	private String ID;
	private Timestamp NgayThang;
	private String GioXuat;
	private String TenChiNhanh;
	private String TenCongTrinh;
	private String TenNhaCungCap;
	private String DiaChi;
	private String SoDienThoai;
	private String TenMacBeTong;

	private String TenHinhThucBom;
	private String TenNhanVien;
	private String KyThuat;
	private String NguoiThuTien;

	private String TenLoaiDa;
	private String TenDoSut;
	private String TenYCDB;

	private Double KLThucXuat;
	private Double KLKhachHang;
	private Double CuLyVanChuyen;
	private Double KLDaBan;
	private Double KLDaXuat;

	private String TrangThaiText;
	private String NguoiTao;
	private Timestamp NgayTao;

	private String IDChiNhanh;
	private Integer TrangThai;

	private String TrangThaiHoanThanh;

	private String IDCongTrinh;
	private String IDNhaCungCap;
	private String IDMacBeTong;
	private String IDHinhThucBom;
	private String IDNhanVien;

	public LichXuatBeTong() {
		super();
	}

	public LichXuatBeTong(String iD, Timestamp ngayThang, String gioXuat, String tenChiNhanh, String tenCongTrinh,
			String tenNhaCungCap, String diaChi, String soDienThoai, String tenMacBeTong, String tenHinhThucBom,
			String tenNhanVien, String kyThuat, String nguoiThuTien, String tenLoaiDa, String tenDoSut, String tenYCDB,
			Double kLThucXuat, Double kLKhachHang, Double cuLyVanChuyen, Double kLDaBan, Double kLDaXuat,
			String trangThaiText, String nguoiTao, Timestamp ngayTao, String iDChiNhanh, Integer trangThai,
			String trangThaiHoanThanh, String iDCongTrinh, String iDNhaCungCap, String iDMacBeTong,
			String iDHinhThucBom, String iDNhanVien) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		GioXuat = gioXuat;
		TenChiNhanh = tenChiNhanh;
		TenCongTrinh = tenCongTrinh;
		TenNhaCungCap = tenNhaCungCap;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		TenMacBeTong = tenMacBeTong;
		TenHinhThucBom = tenHinhThucBom;
		TenNhanVien = tenNhanVien;
		KyThuat = kyThuat;
		NguoiThuTien = nguoiThuTien;
		TenLoaiDa = tenLoaiDa;
		TenDoSut = tenDoSut;
		TenYCDB = tenYCDB;
		KLThucXuat = kLThucXuat;
		KLKhachHang = kLKhachHang;
		CuLyVanChuyen = cuLyVanChuyen;
		KLDaBan = kLDaBan;
		KLDaXuat = kLDaXuat;
		TrangThaiText = trangThaiText;
		NguoiTao = nguoiTao;
		NgayTao = ngayTao;
		IDChiNhanh = iDChiNhanh;
		TrangThai = trangThai;
		TrangThaiHoanThanh = trangThaiHoanThanh;
		IDCongTrinh = iDCongTrinh;
		IDNhaCungCap = iDNhaCungCap;
		IDMacBeTong = iDMacBeTong;
		IDHinhThucBom = iDHinhThucBom;
		IDNhanVien = iDNhanVien;
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

	public void setTenMacBeTong(String TenMacBeTong) {
		TenMacBeTong = TenMacBeTong;
	}

	public String getTenHinhThucBom() {
		return TenHinhThucBom;
	}

	public void setTenHinhThucBom(String tenHinhThucBom) {
		TenHinhThucBom = tenHinhThucBom;
	}

	public String getTenNhanVien() {
		return TenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}

	public String getKyThuat() {
		return KyThuat;
	}

	public void setKyThuat(String kyThuat) {
		KyThuat = kyThuat;
	}

	public String getNguoiThuTien() {
		return NguoiThuTien;
	}

	public void setNguoiThuTien(String nguoiThuTien) {
		NguoiThuTien = nguoiThuTien;
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

	public Double getCuLyVanChuyen() {
		return CuLyVanChuyen;
	}

	public void setCuLyVanChuyen(Double cuLyVanChuyen) {
		CuLyVanChuyen = cuLyVanChuyen;
	}

	public Double getKLDaBan() {
		return KLDaBan;
	}

	public void setKLDaBan(Double kLDaBan) {
		KLDaBan = kLDaBan;
	}

	public Double getKLDaXuat() {
		return KLDaXuat;
	}

	public void setKLDaXuat(Double kLDaXuat) {
		KLDaXuat = kLDaXuat;
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

	public String getTrangThaiHoanThanh() {
		return TrangThaiHoanThanh;
	}

	public void setTrangThaiHoanThanh(String trangThaiHoanThanh) {
		TrangThaiHoanThanh = trangThaiHoanThanh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getIDCongTrinh() {
		return IDCongTrinh;
	}

	public void setIDCongTrinh(String iDCongTrinh) {
		IDCongTrinh = iDCongTrinh;
	}

	public String getIDNhaCungCap() {
		return IDNhaCungCap;
	}

	public void setIDNhaCungCap(String iDNhaCungCap) {
		IDNhaCungCap = iDNhaCungCap;
	}

	public String getIDMacBeTong() {
		return IDMacBeTong;
	}

	public void setIDMacBeTong(String iDMacBeTong) {
		IDMacBeTong = iDMacBeTong;
	}

	public String getIDHinhThucBom() {
		return IDHinhThucBom;
	}

	public void setIDHinhThucBom(String iDHinhThucBom) {
		IDHinhThucBom = iDHinhThucBom;
	}

	public String getIDNhanVien() {
		return IDNhanVien;
	}

	public void setIDNhanVien(String iDNhanVien) {
		IDNhanVien = iDNhanVien;
	}

	@Override
	public String toString() {
		return "LichXuatBeTong [ID=" + ID + ", NgayThang=" + NgayThang + ", GioXuat=" + GioXuat + ", TenChiNhanh="
				+ TenChiNhanh + ", TenCongTrinh=" + TenCongTrinh + ", TenNhaCungCap=" + TenNhaCungCap + ", DiaChi="
				+ DiaChi + ", SoDienThoai=" + SoDienThoai + ", TenMacBeTong=" + TenMacBeTong + ", TenHinhThucBom="
				+ TenHinhThucBom + ", TenNhanVien=" + TenNhanVien + ", KyThuat=" + KyThuat + ", NguoiThuTien="
				+ NguoiThuTien + ", TenLoaiDa=" + TenLoaiDa + ", TenDoSut=" + TenDoSut + ", TenYCDB=" + TenYCDB
				+ ", KLThucXuat=" + KLThucXuat + ", KLKhachHang=" + KLKhachHang + ", CuLyVanChuyen=" + CuLyVanChuyen
				+ ", KLDaBan=" + KLDaBan + ", KLDaXuat=" + KLDaXuat + ", TrangThaiText=" + TrangThaiText + ", NguoiTao="
				+ NguoiTao + ", NgayTao=" + NgayTao + ", IDChiNhanh=" + IDChiNhanh + ", TrangThai=" + TrangThai
				+ ", TrangThaiHoanThanh=" + TrangThaiHoanThanh + ", IDCongTrinh=" + IDCongTrinh + ", IDNhaCungCap="
				+ IDNhaCungCap + ", IDMacBeTong=" + IDMacBeTong + ", IDHinhThucBom=" + IDHinhThucBom + ", IDNhanVien="
				+ IDNhanVien + "]";
	}

}
