package com.api.thuonglongjsc.dto;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class TblLichBanGach {
	private String ID;
	private String GioXuat;
	private String NgayThang;
	private String IDChiNhanh;
	private String IDNhaCungCap;
	private String IDCongTrinh;
	private String IDNhomVatLieu;
	private String IDLoaiVatLieu;
	private String IDDonViTinh;
	private String IDHopDong;
	private String HangMuc;
	private String KLThucXuat;
	private String KLKhachHang;
	private String CuLyVanChuyen;
	private String TrangThai;
	private String TrangThaiText;
	private String NguoiDuyet;
	private String NguoiXoa;
	private String NgayTao;
	private String NguoiTao;
	private String MoTa;
	private String TrangThaiHoanThanh;
	private String KLDaXuat;
	private String KLDaBan;
	private String IDNVKD;
	private String IDChiTietKinhDoanh;
	private String NguoiThuTien;

	public TblLichBanGach() {
		super();
	}

	public TblLichBanGach(String iD, String gioXuat, String ngayThang, String iDChiNhanh, String iDNhaCungCap,
			String iDCongTrinh, String iDNhomVatLieu, String iDLoaiVatLieu, String iDDonViTinh, String iDHopDong,
			String hangMuc, String kLThucXuat, String kLKhachHang, String cuLyVanChuyen, String trangThai,
			String trangThaiText, String nguoiDuyet, String nguoiXoa, String ngayTao, String nguoiTao, String moTa,
			String trangThaiHoanThanh, String kLDaXuat, String kLDaBan, String iDNVKD, String iDChiTietKinhDoanh,
			String nguoiThuTien) {
		super();
		ID = iD;
		GioXuat = gioXuat;
		NgayThang = ngayThang;
		IDChiNhanh = iDChiNhanh;
		IDNhaCungCap = iDNhaCungCap;
		IDCongTrinh = iDCongTrinh;
		IDNhomVatLieu = iDNhomVatLieu;
		IDLoaiVatLieu = iDLoaiVatLieu;
		IDDonViTinh = iDDonViTinh;
		IDHopDong = iDHopDong;
		HangMuc = hangMuc;
		KLThucXuat = kLThucXuat;
		KLKhachHang = kLKhachHang;
		CuLyVanChuyen = cuLyVanChuyen;
		TrangThai = trangThai;
		TrangThaiText = trangThaiText;
		NguoiDuyet = nguoiDuyet;
		NguoiXoa = nguoiXoa;
		NgayTao = ngayTao;
		NguoiTao = nguoiTao;
		MoTa = moTa;
		TrangThaiHoanThanh = trangThaiHoanThanh;
		KLDaXuat = kLDaXuat;
		KLDaBan = kLDaBan;
		IDNVKD = iDNVKD;
		IDChiTietKinhDoanh = iDChiTietKinhDoanh;
		NguoiThuTien = nguoiThuTien;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getGioXuat() {
		return GioXuat;
	}

	public void setGioXuat(String gioXuat) {
		GioXuat = gioXuat;
	}

	public String getNgayThang() {
		return NgayThang;
	}

	public void setNgayThang(String ngayThang) {
		NgayThang = ngayThang;
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

	public String getIDCongTrinh() {
		return IDCongTrinh;
	}

	public void setIDCongTrinh(String iDCongTrinh) {
		IDCongTrinh = iDCongTrinh;
	}

	public String getIDNhomVatLieu() {
		return IDNhomVatLieu;
	}

	public void setIDNhomVatLieu(String iDNhomVatLieu) {
		IDNhomVatLieu = iDNhomVatLieu;
	}

	public String getIDLoaiVatLieu() {
		return IDLoaiVatLieu;
	}

	public void setIDLoaiVatLieu(String iDLoaiVatLieu) {
		IDLoaiVatLieu = iDLoaiVatLieu;
	}

	public String getIDDonViTinh() {
		return IDDonViTinh;
	}

	public void setIDDonViTinh(String iDDonViTinh) {
		IDDonViTinh = iDDonViTinh;
	}

	public String getIDHopDong() {
		return IDHopDong;
	}

	public void setIDHopDong(String iDHopDong) {
		IDHopDong = iDHopDong;
	}

	public String getHangMuc() {
		return HangMuc;
	}

	public void setHangMuc(String hangMuc) {
		HangMuc = hangMuc;
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

	public String getCuLyVanChuyen() {
		return CuLyVanChuyen;
	}

	public void setCuLyVanChuyen(String cuLyVanChuyen) {
		CuLyVanChuyen = cuLyVanChuyen;
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

	public String getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(String ngayTao) {
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

	public String getTrangThaiHoanThanh() {
		return TrangThaiHoanThanh;
	}

	public void setTrangThaiHoanThanh(String trangThaiHoanThanh) {
		TrangThaiHoanThanh = trangThaiHoanThanh;
	}

	public String getKLDaXuat() {
		return KLDaXuat;
	}

	public void setKLDaXuat(String kLDaXuat) {
		KLDaXuat = kLDaXuat;
	}

	public String getKLDaBan() {
		return KLDaBan;
	}

	public void setKLDaBan(String kLDaBan) {
		KLDaBan = kLDaBan;
	}

	public String getIDNVKD() {
		return IDNVKD;
	}

	public void setIDNVKD(String iDNVKD) {
		IDNVKD = iDNVKD;
	}

	public String getIDChiTietKinhDoanh() {
		return IDChiTietKinhDoanh;
	}

	public void setIDChiTietKinhDoanh(String iDChiTietKinhDoanh) {
		IDChiTietKinhDoanh = iDChiTietKinhDoanh;
	}

	public String getNguoiThuTien() {
		return NguoiThuTien;
	}

	public void setNguoiThuTien(String nguoiThuTien) {
		NguoiThuTien = nguoiThuTien;
	}

	@Override
	public String toString() {
		return "TblLichBanGach [ID=" + ID + ", GioXuat=" + GioXuat + ", NgayThang=" + NgayThang + ", IDChiNhanh="
				+ IDChiNhanh + ", IDNhaCungCap=" + IDNhaCungCap + ", IDCongTrinh=" + IDCongTrinh + ", IDNhomVatLieu="
				+ IDNhomVatLieu + ", IDLoaiVatLieu=" + IDLoaiVatLieu + ", IDDonViTinh=" + IDDonViTinh + ", IDHopDong="
				+ IDHopDong + ", HangMuc=" + HangMuc + ", KLThucXuat=" + KLThucXuat + ", KLKhachHang=" + KLKhachHang
				+ ", CuLyVanChuyen=" + CuLyVanChuyen + ", TrangThai=" + TrangThai + ", TrangThaiText=" + TrangThaiText
				+ ", NguoiDuyet=" + NguoiDuyet + ", NguoiXoa=" + NguoiXoa + ", NgayTao=" + NgayTao + ", NguoiTao="
				+ NguoiTao + ", MoTa=" + MoTa + ", TrangThaiHoanThanh=" + TrangThaiHoanThanh + ", KLDaXuat=" + KLDaXuat
				+ ", KLDaBan=" + KLDaBan + ", IDNVKD=" + IDNVKD + ", IDChiTietKinhDoanh=" + IDChiTietKinhDoanh
				+ ", NguoiThuTien=" + NguoiThuTien + "]";
	}

}
