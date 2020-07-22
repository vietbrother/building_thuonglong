package com.api.thuonglongjsc.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class LichBanGach {
	private String ID;

	private Timestamp NgayThang;

	private String GioXuat;

	private String TenChiNhanh;

	private String TenCongTrinh;

	private String HangMuc;

	private String TenNhaCungCap;
	private String DiaChi;
	private String SoDienThoai;

	private String TenLoaiVatLieu;

	private String TenDonViTinh;

	private String TenNhanVien;

	private String NguoiThuTien;

	private Double KLThucXuat;

	private Double KLKhachHang;

	private Double CuLyVanChuyen;

	private String TrangThaiHoanThanh;

	private String TrangThaiText;

	private Double KLDaBan;

	private Double KLDaXuat;

	private String NguoiTao;

	private Timestamp NgayTao;

	private String IDChiNhanh;
	private Integer TrangThai;

	private String IDNhaCungCap;
	private String IDLoaiVatLieu;
	private String IDCongTrinh;
	private String IDNVKD;
	private String IDDonViTinh;
	private String IDNhomVatLieu;
	private String TenNhomVatLieu;

	public LichBanGach() {
		super();
	}

	public LichBanGach(String iD, Timestamp ngayThang, String gioXuat, String tenChiNhanh, String tenCongTrinh,
			String hangMuc, String tenNhaCungCap, String diaChi, String soDienThoai, String tenLoaiVatLieu,
			String tenDonViTinh, String tenNhanVien, String nguoiThuTien, Double kLThucXuat, Double kLKhachHang,
			Double cuLyVanChuyen, String trangThaiHoanThanh, String trangThaiText, Double kLDaBan, Double kLDaXuat,
			String nguoiTao, Timestamp ngayTao, String iDChiNhanh, Integer trangThai, String iDNhaCungCap,
			String iDLoaiVatLieu, String iDCongTrinh, String iDNVKD, String iDDonViTinh, String iDNhomVatLieu,
			String tenNhomVatLieu) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		GioXuat = gioXuat;
		TenChiNhanh = tenChiNhanh;
		TenCongTrinh = tenCongTrinh;
		HangMuc = hangMuc;
		TenNhaCungCap = tenNhaCungCap;
		DiaChi = diaChi;
		SoDienThoai = soDienThoai;
		TenLoaiVatLieu = tenLoaiVatLieu;
		TenDonViTinh = tenDonViTinh;
		TenNhanVien = tenNhanVien;
		NguoiThuTien = nguoiThuTien;
		KLThucXuat = kLThucXuat;
		KLKhachHang = kLKhachHang;
		CuLyVanChuyen = cuLyVanChuyen;
		TrangThaiHoanThanh = trangThaiHoanThanh;
		TrangThaiText = trangThaiText;
		KLDaBan = kLDaBan;
		KLDaXuat = kLDaXuat;
		NguoiTao = nguoiTao;
		NgayTao = ngayTao;
		IDChiNhanh = iDChiNhanh;
		TrangThai = trangThai;
		IDNhaCungCap = iDNhaCungCap;
		IDLoaiVatLieu = iDLoaiVatLieu;
		IDCongTrinh = iDCongTrinh;
		IDNVKD = iDNVKD;
		IDDonViTinh = iDDonViTinh;
		IDNhomVatLieu = iDNhomVatLieu;
		TenNhomVatLieu = tenNhomVatLieu;
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

	public String getHangMuc() {
		return HangMuc;
	}

	public void setHangMuc(String hangMuc) {
		HangMuc = hangMuc;
	}

	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
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

	public String getTenNhanVien() {
		return TenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}

	public String getNguoiThuTien() {
		return NguoiThuTien;
	}

	public void setNguoiThuTien(String nguoiThuTien) {
		NguoiThuTien = nguoiThuTien;
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

	public String getTrangThaiHoanThanh() {
		return TrangThaiHoanThanh;
	}

	public void setTrangThaiHoanThanh(String trangThaiHoanThanh) {
		TrangThaiHoanThanh = trangThaiHoanThanh;
	}

	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
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

	public String getIDNhaCungCap() {
		return IDNhaCungCap;
	}

	public void setIDNhaCungCap(String iDNhaCungCap) {
		IDNhaCungCap = iDNhaCungCap;
	}

	public String getIDLoaiVatLieu() {
		return IDLoaiVatLieu;
	}

	public void setIDLoaiVatLieu(String iDLoaiVatLieu) {
		IDLoaiVatLieu = iDLoaiVatLieu;
	}

	public String getIDCongTrinh() {
		return IDCongTrinh;
	}

	public void setIDCongTrinh(String iDCongTrinh) {
		IDCongTrinh = iDCongTrinh;
	}

	public String getIDNVKD() {
		return IDNVKD;
	}

	public void setIDNVKD(String iDNVKD) {
		IDNVKD = iDNVKD;
	}

	public String getIDDonViTinh() {
		return IDDonViTinh;
	}

	public void setIDDonViTinh(String iDDonViTinh) {
		IDDonViTinh = iDDonViTinh;
	}

	public String getIDNhomVatLieu() {
		return IDNhomVatLieu;
	}

	public void setIDNhomVatLieu(String iDNhomVatLieu) {
		IDNhomVatLieu = iDNhomVatLieu;
	}

	public String getTenNhomVatLieu() {
		return TenNhomVatLieu;
	}

	public void setTenNhomVatLieu(String tenNhomVatLieu) {
		TenNhomVatLieu = tenNhomVatLieu;
	}

	@Override
	public String toString() {
		return "LichBanGach [ID=" + ID + ", NgayThang=" + NgayThang + ", GioXuat=" + GioXuat + ", TenChiNhanh="
				+ TenChiNhanh + ", TenCongTrinh=" + TenCongTrinh + ", HangMuc=" + HangMuc + ", TenNhaCungCap="
				+ TenNhaCungCap + ", DiaChi=" + DiaChi + ", SoDienThoai=" + SoDienThoai + ", TenLoaiVatLieu="
				+ TenLoaiVatLieu + ", TenDonViTinh=" + TenDonViTinh + ", TenNhanVien=" + TenNhanVien + ", NguoiThuTien="
				+ NguoiThuTien + ", KLThucXuat=" + KLThucXuat + ", KLKhachHang=" + KLKhachHang + ", CuLyVanChuyen="
				+ CuLyVanChuyen + ", TrangThaiHoanThanh=" + TrangThaiHoanThanh + ", TrangThaiText=" + TrangThaiText
				+ ", KLDaBan=" + KLDaBan + ", KLDaXuat=" + KLDaXuat + ", NguoiTao=" + NguoiTao + ", NgayTao=" + NgayTao
				+ ", IDChiNhanh=" + IDChiNhanh + ", TrangThai=" + TrangThai + ", IDNhaCungCap=" + IDNhaCungCap
				+ ", IDLoaiVatLieu=" + IDLoaiVatLieu + ", IDCongTrinh=" + IDCongTrinh + ", IDNVKD=" + IDNVKD
				+ ", IDDonViTinh=" + IDDonViTinh + ", IDNhomVatLieu=" + IDNhomVatLieu + ", TenNhomVatLieu="
				+ TenNhomVatLieu + "]";
	}

	

}
