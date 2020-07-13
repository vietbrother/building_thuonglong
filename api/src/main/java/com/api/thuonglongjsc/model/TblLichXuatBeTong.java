//package com.api.thuonglongjsc.model;
//
//import java.sql.Time;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "tblLichXuatBeTong", schema = "dbo")
//public class TblLichXuatBeTong {
//	private String ID;
//	private Time GioXuat;
//	private Date NgayThang;
//	private String IDChiNhanh;
//	private String IDNhaCungCap;
//	private String IDCongTrinh;
//	private String MacBeTong;
//	private String IDHopDong;
//	private String HangMuc;
//	private String HinhThucBom;
//	private String IDHopDongBom;
//	private Double KLThucXuat;
//	private Double KLKhachHang;
//	private Double CuLyVanChuyen;
//	private Integer TrangThai;
//	private String TrangThaiText;
//	private String NguoiDuyet;
//	private String NguoiXoa;
//	private Date NgayTao;
//	private String NguoiTao;
//	private String MoTa;
//	private String TrangThaiHoanThanh;
//	private Double KLDaXuat;
//	private Double KLDaBan;
//	private String IDNVKD;
//	private String IDChiTietKinhDoanh;
//	private String KyThuat;
//	private String NguoiThuTien;
//
//	public TblLichXuatBeTong() {
//		super();
//	}
//
//	public TblLichXuatBeTong(String iD, Time gioXuat, Date ngayThang, String iDChiNhanh, String iDNhaCungCap,
//			String iDCongTrinh, String macBeTong, String iDHopDong, String hangMuc, String hinhThucBom,
//			String iDHopDongBom, Double kLThucXuat, Double kLKhachHang, Double cuLyVanChuyen, Integer trangThai,
//			String trangThaiText, String nguoiDuyet, String nguoiXoa, Date ngayTao, String nguoiTao, String moTa,
//			String trangThaiHoanThanh, Double kLDaXuat, Double kLDaBan, String iDNVKD, String iDChiTietKinhDoanh,
//			String kyThuat, String nguoiThuTien) {
//		super();
//		ID = iD;
//		GioXuat = gioXuat;
//		NgayThang = ngayThang;
//		IDChiNhanh = iDChiNhanh;
//		IDNhaCungCap = iDNhaCungCap;
//		IDCongTrinh = iDCongTrinh;
//		MacBeTong = macBeTong;
//		IDHopDong = iDHopDong;
//		HangMuc = hangMuc;
//		HinhThucBom = hinhThucBom;
//		IDHopDongBom = iDHopDongBom;
//		KLThucXuat = kLThucXuat;
//		KLKhachHang = kLKhachHang;
//		CuLyVanChuyen = cuLyVanChuyen;
//		TrangThai = trangThai;
//		TrangThaiText = trangThaiText;
//		NguoiDuyet = nguoiDuyet;
//		NguoiXoa = nguoiXoa;
//		NgayTao = ngayTao;
//		NguoiTao = nguoiTao;
//		MoTa = moTa;
//		TrangThaiHoanThanh = trangThaiHoanThanh;
//		KLDaXuat = kLDaXuat;
//		KLDaBan = kLDaBan;
//		IDNVKD = iDNVKD;
//		IDChiTietKinhDoanh = iDChiTietKinhDoanh;
//		KyThuat = kyThuat;
//		NguoiThuTien = nguoiThuTien;
//	}
//
//	public String getID() {
//		return ID;
//	}
//
//	public void setID(String iD) {
//		ID = iD;
//	}
//
//	public Time getGioXuat() {
//		return GioXuat;
//	}
//
//	public void setGioXuat(Time gioXuat) {
//		GioXuat = gioXuat;
//	}
//
//	public Date getNgayThang() {
//		return NgayThang;
//	}
//
//	public void setNgayThang(Date ngayThang) {
//		NgayThang = ngayThang;
//	}
//
//	public String getIDChiNhanh() {
//		return IDChiNhanh;
//	}
//
//	public void setIDChiNhanh(String iDChiNhanh) {
//		IDChiNhanh = iDChiNhanh;
//	}
//
//	public String getIDNhaCungCap() {
//		return IDNhaCungCap;
//	}
//
//	public void setIDNhaCungCap(String iDNhaCungCap) {
//		IDNhaCungCap = iDNhaCungCap;
//	}
//
//	public String getIDCongTrinh() {
//		return IDCongTrinh;
//	}
//
//	public void setIDCongTrinh(String iDCongTrinh) {
//		IDCongTrinh = iDCongTrinh;
//	}
//
//	public String getMacBeTong() {
//		return MacBeTong;
//	}
//
//	public void setMacBeTong(String macBeTong) {
//		MacBeTong = macBeTong;
//	}
//
//	public String getIDHopDong() {
//		return IDHopDong;
//	}
//
//	public void setIDHopDong(String iDHopDong) {
//		IDHopDong = iDHopDong;
//	}
//
//	public String getHangMuc() {
//		return HangMuc;
//	}
//
//	public void setHangMuc(String hangMuc) {
//		HangMuc = hangMuc;
//	}
//
//	public String getHinhThucBom() {
//		return HinhThucBom;
//	}
//
//	public void setHinhThucBom(String hinhThucBom) {
//		HinhThucBom = hinhThucBom;
//	}
//
//	public String getIDHopDongBom() {
//		return IDHopDongBom;
//	}
//
//	public void setIDHopDongBom(String iDHopDongBom) {
//		IDHopDongBom = iDHopDongBom;
//	}
//
//	public Double getKLThucXuat() {
//		return KLThucXuat;
//	}
//
//	public void setKLThucXuat(Double kLThucXuat) {
//		KLThucXuat = kLThucXuat;
//	}
//
//	public Double getKLKhachHang() {
//		return KLKhachHang;
//	}
//
//	public void setKLKhachHang(Double kLKhachHang) {
//		KLKhachHang = kLKhachHang;
//	}
//
//	public Double getCuLyVanChuyen() {
//		return CuLyVanChuyen;
//	}
//
//	public void setCuLyVanChuyen(Double cuLyVanChuyen) {
//		CuLyVanChuyen = cuLyVanChuyen;
//	}
//
//	public Integer getTrangThai() {
//		return TrangThai;
//	}
//
//	public void setTrangThai(Integer trangThai) {
//		TrangThai = trangThai;
//	}
//
//	public String getTrangThaiText() {
//		return TrangThaiText;
//	}
//
//	public void setTrangThaiText(String trangThaiText) {
//		TrangThaiText = trangThaiText;
//	}
//
//	public String getNguoiDuyet() {
//		return NguoiDuyet;
//	}
//
//	public void setNguoiDuyet(String nguoiDuyet) {
//		NguoiDuyet = nguoiDuyet;
//	}
//
//	public String getNguoiXoa() {
//		return NguoiXoa;
//	}
//
//	public void setNguoiXoa(String nguoiXoa) {
//		NguoiXoa = nguoiXoa;
//	}
//
//	public Date getNgayTao() {
//		return NgayTao;
//	}
//
//	public void setNgayTao(Date ngayTao) {
//		NgayTao = ngayTao;
//	}
//
//	public String getNguoiTao() {
//		return NguoiTao;
//	}
//
//	public void setNguoiTao(String nguoiTao) {
//		NguoiTao = nguoiTao;
//	}
//
//	public String getMoTa() {
//		return MoTa;
//	}
//
//	public void setMoTa(String moTa) {
//		MoTa = moTa;
//	}
//
//	public String getTrangThaiHoanThanh() {
//		return TrangThaiHoanThanh;
//	}
//
//	public void setTrangThaiHoanThanh(String trangThaiHoanThanh) {
//		TrangThaiHoanThanh = trangThaiHoanThanh;
//	}
//
//	public Double getKLDaXuat() {
//		return KLDaXuat;
//	}
//
//	public void setKLDaXuat(Double kLDaXuat) {
//		KLDaXuat = kLDaXuat;
//	}
//
//	public Double getKLDaBan() {
//		return KLDaBan;
//	}
//
//	public void setKLDaBan(Double kLDaBan) {
//		KLDaBan = kLDaBan;
//	}
//
//	public String getIDNVKD() {
//		return IDNVKD;
//	}
//
//	public void setIDNVKD(String iDNVKD) {
//		IDNVKD = iDNVKD;
//	}
//
//	public String getIDChiTietKinhDoanh() {
//		return IDChiTietKinhDoanh;
//	}
//
//	public void setIDChiTietKinhDoanh(String iDChiTietKinhDoanh) {
//		IDChiTietKinhDoanh = iDChiTietKinhDoanh;
//	}
//
//	public String getKyThuat() {
//		return KyThuat;
//	}
//
//	public void setKyThuat(String kyThuat) {
//		KyThuat = kyThuat;
//	}
//
//	public String getNguoiThuTien() {
//		return NguoiThuTien;
//	}
//
//	public void setNguoiThuTien(String nguoiThuTien) {
//		NguoiThuTien = nguoiThuTien;
//	}
//
//	@Override
//	public String toString() {
//		return "TblLichXuatBeTong [ID=" + ID + ", GioXuat=" + GioXuat + ", NgayThang=" + NgayThang + ", IDChiNhanh="
//				+ IDChiNhanh + ", IDNhaCungCap=" + IDNhaCungCap + ", IDCongTrinh=" + IDCongTrinh + ", MacBeTong="
//				+ MacBeTong + ", IDHopDong=" + IDHopDong + ", HangMuc=" + HangMuc + ", HinhThucBom=" + HinhThucBom
//				+ ", IDHopDongBom=" + IDHopDongBom + ", KLThucXuat=" + KLThucXuat + ", KLKhachHang=" + KLKhachHang
//				+ ", CuLyVanChuyen=" + CuLyVanChuyen + ", TrangThai=" + TrangThai + ", TrangThaiText=" + TrangThaiText
//				+ ", NguoiDuyet=" + NguoiDuyet + ", NguoiXoa=" + NguoiXoa + ", NgayTao=" + NgayTao + ", NguoiTao="
//				+ NguoiTao + ", MoTa=" + MoTa + ", TrangThaiHoanThanh=" + TrangThaiHoanThanh + ", KLDaXuat=" + KLDaXuat
//				+ ", KLDaBan=" + KLDaBan + ", IDNVKD=" + IDNVKD + ", IDChiTietKinhDoanh=" + IDChiTietKinhDoanh
//				+ ", KyThuat=" + KyThuat + ", NguoiThuTien=" + NguoiThuTien + "]";
//	}
//
//}
