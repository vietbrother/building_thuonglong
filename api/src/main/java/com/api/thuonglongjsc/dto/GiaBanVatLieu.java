package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class GiaBanVatLieu {

	private String ID;
	private String TenChiNhanh;
	private String CongTrinh;
	private String NhaCungCap;
	private String NhomVatLieu;
	private String LoaiVatLieu;
	private String DonViTinh;
	private BigDecimal DonGiaCoThue;
	private BigDecimal DonGiaKhongThue;
	private Date TuNgay;
	private Date DenNgay;
	private String TrangThaiText;
	private String NguoiTao;
	private Timestamp NgayTao;
	private Integer TrangThai;
	private String IDChiNhanh;

	public GiaBanVatLieu() {
		super();
	}

	public GiaBanVatLieu(String iD, String tenChiNhanh, String congTrinh, String nhaCungCap, String nhomVatLieu,
			String loaiVatLieu, String donViTinh, BigDecimal donGiaCoThue, BigDecimal donGiaKhongThue, Date tuNgay,
			Date denNgay, String trangThaiText, String nguoiTao, Timestamp ngayTao) {
		super();
		ID = iD;
		TenChiNhanh = tenChiNhanh;
		CongTrinh = congTrinh;
		NhaCungCap = nhaCungCap;
		NhomVatLieu = nhomVatLieu;
		LoaiVatLieu = loaiVatLieu;
		DonViTinh = donViTinh;
		DonGiaCoThue = donGiaCoThue;
		DonGiaKhongThue = donGiaKhongThue;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		TrangThaiText = trangThaiText;
		NguoiTao = nguoiTao;
		NgayTao = ngayTao;
	}
	
	

	public GiaBanVatLieu(String iD, String tenChiNhanh, String congTrinh, String nhaCungCap, String nhomVatLieu,
			String loaiVatLieu, String donViTinh, BigDecimal donGiaCoThue, BigDecimal donGiaKhongThue, Date tuNgay,
			Date denNgay, String trangThaiText, String nguoiTao, Timestamp ngayTao, Integer trangThai,
			String iDChiNhanh) {
		super();
		ID = iD;
		TenChiNhanh = tenChiNhanh;
		CongTrinh = congTrinh;
		NhaCungCap = nhaCungCap;
		NhomVatLieu = nhomVatLieu;
		LoaiVatLieu = loaiVatLieu;
		DonViTinh = donViTinh;
		DonGiaCoThue = donGiaCoThue;
		DonGiaKhongThue = donGiaKhongThue;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		TrangThaiText = trangThaiText;
		NguoiTao = nguoiTao;
		NgayTao = ngayTao;
		TrangThai = trangThai;
		IDChiNhanh = iDChiNhanh;
	}

	public void setDonGiaCoThue(BigDecimal donGiaCoThue) {
		DonGiaCoThue = donGiaCoThue;
	}

	public void setDonGiaKhongThue(BigDecimal donGiaKhongThue) {
		DonGiaKhongThue = donGiaKhongThue;
	}

	public void setTuNgay(Date tuNgay) {
		TuNgay = tuNgay;
	}

	public void setDenNgay(Date denNgay) {
		DenNgay = denNgay;
	}

	public void setNgayTao(Timestamp ngayTao) {
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

	public String getCongTrinh() {
		return CongTrinh;
	}

	public void setCongTrinh(String congTrinh) {
		CongTrinh = congTrinh;
	}

	public String getNhaCungCap() {
		return NhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		NhaCungCap = nhaCungCap;
	}

	public String getNhomVatLieu() {
		return NhomVatLieu;
	}

	public void setNhomVatLieu(String nhomVatLieu) {
		NhomVatLieu = nhomVatLieu;
	}

	public String getLoaiVatLieu() {
		return LoaiVatLieu;
	}

	public void setLoaiVatLieu(String loaiVatLieu) {
		LoaiVatLieu = loaiVatLieu;
	}

	public String getDonViTinh() {
		return DonViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
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

	public BigDecimal getDonGiaCoThue() {
		return DonGiaCoThue;
	}

	public BigDecimal getDonGiaKhongThue() {
		return DonGiaKhongThue;
	}

	public Date getTuNgay() {
		return TuNgay;
	}

	public Date getDenNgay() {
		return DenNgay;
	}

	public Timestamp getNgayTao() {
		return NgayTao;
	}

	
	public Integer getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Integer trangThai) {
		TrangThai = trangThai;
	}

	public String getIDChiNhanh() {
		return IDChiNhanh;
	}

	public void setIDChiNhanh(String iDChiNhanh) {
		IDChiNhanh = iDChiNhanh;
	}

	@Override
	public String toString() {
		return "GiaBanVatLieu [ID=" + ID + ", TenChiNhanh=" + TenChiNhanh + ", CongTrinh=" + CongTrinh + ", NhaCungCap="
				+ NhaCungCap + ", NhomVatLieu=" + NhomVatLieu + ", LoaiVatLieu=" + LoaiVatLieu + ", DonViTinh="
				+ DonViTinh + ", DonGiaCoThue=" + DonGiaCoThue + ", DonGiaKhongThue=" + DonGiaKhongThue + ", TuNgay="
				+ TuNgay + ", DenNgay=" + DenNgay + ", TrangThaiText=" + TrangThaiText + ", NguoiTao=" + NguoiTao
				+ ", NgayTao=" + NgayTao + ", TrangThai=" + TrangThai + ", IDChiNhanh=" + IDChiNhanh + "]";
	}



	/*
	 * private String ID; private Date NgayThang; private String TenChiNhanh;
	 * private String IDChiNhanh; private String TenNhaCungCap; private String
	 * TenNhomVatLieu; private String TenLoaiVatLieu; private String TenDonViTinh;
	 * private Double TLTong; private Double TLBi; private Double TLHang; private
	 * Double TyLeQuyDoi; private Integer SoPhieuCan; private Double KLQuanCan;
	 * private Double KLBan; private Double KLXuatKho; private String TenBienSoXe;
	 * private String TenLaiXe; private BigDecimal DonGiaCoThue; private BigDecimal
	 * DonGiaKhongThue; private BigDecimal ThanhTienCoThue; private BigDecimal
	 * ThanhTienKhongThue; private Integer TrangThai; private String TrangThaiText;
	 * private Integer TrangThaiChot; private String NguoiDuyet; private String
	 * NguoiDuyetChot; private Date NgayTao; private String NguoiTao;
	 * 
	 * public GiaBanVatLieu() { super(); }
	 * 
	 * public GiaBanVatLieu(String iD, Date ngayThang, String tenChiNhanh, String
	 * iDChiNhanh, String tenNhaCungCap, String tenNhomVatLieu, String
	 * tenLoaiVatLieu, String tenDonViTinh, Double tLTong, Double tLBi, Double
	 * tLHang, Double tyLeQuyDoi, Integer soPhieuCan, Double kLQuanCan, Double
	 * kLBan, Double kLXuatKho, String tenBienSoXe, String tenLaiXe, BigDecimal
	 * donGiaCoThue, BigDecimal donGiaKhongThue, BigDecimal thanhTienCoThue,
	 * BigDecimal thanhTienKhongThue, Integer trangThai, String trangThaiText,
	 * Integer trangThaiChot, String nguoiDuyet, String nguoiDuyetChot, Date
	 * ngayTao, String nguoiTao) { super(); ID = iD; NgayThang = ngayThang;
	 * TenChiNhanh = tenChiNhanh; IDChiNhanh = iDChiNhanh; TenNhaCungCap =
	 * tenNhaCungCap; TenNhomVatLieu = tenNhomVatLieu; TenLoaiVatLieu =
	 * tenLoaiVatLieu; TenDonViTinh = tenDonViTinh; TLTong = tLTong; TLBi = tLBi;
	 * TLHang = tLHang; TyLeQuyDoi = tyLeQuyDoi; SoPhieuCan = soPhieuCan; KLQuanCan
	 * = kLQuanCan; KLBan = kLBan; KLXuatKho = kLXuatKho; TenBienSoXe = tenBienSoXe;
	 * TenLaiXe = tenLaiXe; DonGiaCoThue = donGiaCoThue; DonGiaKhongThue =
	 * donGiaKhongThue; ThanhTienCoThue = thanhTienCoThue; ThanhTienKhongThue =
	 * thanhTienKhongThue; TrangThai = trangThai; TrangThaiText = trangThaiText;
	 * TrangThaiChot = trangThaiChot; NguoiDuyet = nguoiDuyet; NguoiDuyetChot =
	 * nguoiDuyetChot; NgayTao = ngayTao; NguoiTao = nguoiTao; }
	 * 
	 * public String getID() { return ID; }
	 * 
	 * public void setID(String iD) { ID = iD; }
	 * 
	 * public Date getNgayThang() { return NgayThang; }
	 * 
	 * public void setNgayThang(Date ngayThang) { NgayThang = ngayThang; }
	 * 
	 * public String getTenChiNhanh() { return TenChiNhanh; }
	 * 
	 * public void setTenChiNhanh(String tenChiNhanh) { TenChiNhanh = tenChiNhanh; }
	 * 
	 * public String getTenNhaCungCap() { return TenNhaCungCap; }
	 * 
	 * public void setTenNhaCungCap(String tenNhaCungCap) { TenNhaCungCap =
	 * tenNhaCungCap; }
	 * 
	 * public String getTenNhomVatLieu() { return TenNhomVatLieu; }
	 * 
	 * public void setTenNhomVatLieu(String tenNhomVatLieu) { TenNhomVatLieu =
	 * tenNhomVatLieu; }
	 * 
	 * public String getTenLoaiVatLieu() { return TenLoaiVatLieu; }
	 * 
	 * public void setTenLoaiVatLieu(String tenLoaiVatLieu) { TenLoaiVatLieu =
	 * tenLoaiVatLieu; }
	 * 
	 * public String getTenDonViTinh() { return TenDonViTinh; }
	 * 
	 * public void setTenDonViTinh(String tenDonViTinh) { TenDonViTinh =
	 * tenDonViTinh; }
	 * 
	 * public Double getTLTong() { return TLTong; }
	 * 
	 * public void setTLTong(Double tLTong) { TLTong = tLTong; }
	 * 
	 * public Double getTLBi() { return TLBi; }
	 * 
	 * public void setTLBi(Double tLBi) { TLBi = tLBi; }
	 * 
	 * public Double getTLHang() { return TLHang; }
	 * 
	 * public void setTLHang(Double tLHang) { TLHang = tLHang; }
	 * 
	 * public Double getTyLeQuyDoi() { return TyLeQuyDoi; }
	 * 
	 * public void setTyLeQuyDoi(Double tyLeQuyDoi) { TyLeQuyDoi = tyLeQuyDoi; }
	 * 
	 * public Integer getSoPhieuCan() { return SoPhieuCan; }
	 * 
	 * public void setSoPhieuCan(Integer soPhieuCan) { SoPhieuCan = soPhieuCan; }
	 * 
	 * public Double getKLQuanCan() { return KLQuanCan; }
	 * 
	 * public void setKLQuanCan(Double kLQuanCan) { KLQuanCan = kLQuanCan; }
	 * 
	 * public Double getKLBan() { return KLBan; }
	 * 
	 * public void setKLBan(Double kLBan) { KLBan = kLBan; }
	 * 
	 * public Double getKLXuatKho() { return KLXuatKho; }
	 * 
	 * public void setKLXuatKho(Double kLXuatKho) { KLXuatKho = kLXuatKho; }
	 * 
	 * public String getTenBienSoXe() { return TenBienSoXe; }
	 * 
	 * public void setTenBienSoXe(String tenBienSoXe) { TenBienSoXe = tenBienSoXe; }
	 * 
	 * public String getTenLaiXe() { return TenLaiXe; }
	 * 
	 * public void setTenLaiXe(String tenLaiXe) { TenLaiXe = tenLaiXe; }
	 * 
	 * public BigDecimal getDonGiaCoThue() { return DonGiaCoThue; }
	 * 
	 * public void setDonGiaCoThue(BigDecimal donGiaCoThue) { DonGiaCoThue =
	 * donGiaCoThue; }
	 * 
	 * public BigDecimal getDonGiaKhongThue() { return DonGiaKhongThue; }
	 * 
	 * public void setDonGiaKhongThue(BigDecimal donGiaKhongThue) { DonGiaKhongThue
	 * = donGiaKhongThue; }
	 * 
	 * public BigDecimal getThanhTienCoThue() { return ThanhTienCoThue; }
	 * 
	 * public void setThanhTienCoThue(BigDecimal thanhTienCoThue) { ThanhTienCoThue
	 * = thanhTienCoThue; }
	 * 
	 * public BigDecimal getThanhTienKhongThue() { return ThanhTienKhongThue; }
	 * 
	 * public void setThanhTienKhongThue(BigDecimal thanhTienKhongThue) {
	 * ThanhTienKhongThue = thanhTienKhongThue; }
	 * 
	 * public String getTrangThaiText() { return TrangThaiText; }
	 * 
	 * public void setTrangThaiText(String trangThaiText) { TrangThaiText =
	 * trangThaiText; }
	 * 
	 * public Integer getTrangThaiChot() { return TrangThaiChot; }
	 * 
	 * public void setTrangThaiChot(Integer trangThaiChot) { TrangThaiChot =
	 * trangThaiChot; }
	 * 
	 * public String getNguoiDuyet() { return NguoiDuyet; }
	 * 
	 * public void setNguoiDuyet(String nguoiDuyet) { NguoiDuyet = nguoiDuyet; }
	 * 
	 * public String getNguoiDuyetChot() { return NguoiDuyetChot; }
	 * 
	 * public void setNguoiDuyetChot(String nguoiDuyetChot) { NguoiDuyetChot =
	 * nguoiDuyetChot; }
	 * 
	 * public Date getNgayTao() { return NgayTao; }
	 * 
	 * public void setNgayTao(Date ngayTao) { NgayTao = ngayTao; }
	 * 
	 * public String getNguoiTao() { return NguoiTao; }
	 * 
	 * public void setNguoiTao(String nguoiTao) { NguoiTao = nguoiTao; }
	 * 
	 * public String getIDChiNhanh() { return IDChiNhanh; }
	 * 
	 * public void setIDChiNhanh(String iDChiNhanh) { IDChiNhanh = iDChiNhanh; }
	 * 
	 * public Integer getTrangThai() { return TrangThai; }
	 * 
	 * public void setTrangThai(Integer trangThai) { TrangThai = trangThai; }
	 * 
	 * @Override public String toString() { return "GiaBanVatLieu [ID=" + ID +
	 * ", NgayThang=" + NgayThang + ", TenChiNhanh=" + TenChiNhanh + ", IDChiNhanh="
	 * + IDChiNhanh + ", TenNhaCungCap=" + TenNhaCungCap + ", TenNhomVatLieu=" +
	 * TenNhomVatLieu + ", TenLoaiVatLieu=" + TenLoaiVatLieu + ", TenDonViTinh=" +
	 * TenDonViTinh + ", TLTong=" + TLTong + ", TLBi=" + TLBi + ", TLHang=" + TLHang
	 * + ", TyLeQuyDoi=" + TyLeQuyDoi + ", SoPhieuCan=" + SoPhieuCan +
	 * ", KLQuanCan=" + KLQuanCan + ", KLBan=" + KLBan + ", KLXuatKho=" + KLXuatKho
	 * + ", TenBienSoXe=" + TenBienSoXe + ", TenLaiXe=" + TenLaiXe +
	 * ", DonGiaCoThue=" + DonGiaCoThue + ", DonGiaKhongThue=" + DonGiaKhongThue +
	 * ", ThanhTienCoThue=" + ThanhTienCoThue + ", ThanhTienKhongThue=" +
	 * ThanhTienKhongThue + ", TrangThai=" + TrangThai + ", TrangThaiText=" +
	 * TrangThaiText + ", TrangThaiChot=" + TrangThaiChot + ", NguoiDuyet=" +
	 * NguoiDuyet + ", NguoiDuyetChot=" + NguoiDuyetChot + ", NgayTao=" + NgayTao +
	 * ", NguoiTao=" + NguoiTao + "]"; }
	 */
}
