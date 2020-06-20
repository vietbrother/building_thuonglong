package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class GiaBanVatLieu {

	private String ID;
	private Integer SoHD;
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

	public GiaBanVatLieu(String iD, Integer soHD, String tenChiNhanh, String congTrinh, String nhaCungCap,
			String nhomVatLieu, String loaiVatLieu, String donViTinh, BigDecimal donGiaCoThue,
			BigDecimal donGiaKhongThue, Date tuNgay, Date denNgay, String trangThaiText, String nguoiTao,
			Timestamp ngayTao, Integer trangThai, String iDChiNhanh) {
		super();
		ID = iD;
		SoHD = soHD;
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

	public Date getTuNgay() {
		return TuNgay;
	}

	public void setTuNgay(Date tuNgay) {
		TuNgay = tuNgay;
	}

	public Date getDenNgay() {
		return DenNgay;
	}

	public void setDenNgay(Date denNgay) {
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
		return "GiaBanVatLieu [ID=" + ID + ", SoHD=" + SoHD + ", TenChiNhanh=" + TenChiNhanh + ", CongTrinh="
				+ CongTrinh + ", NhaCungCap=" + NhaCungCap + ", NhomVatLieu=" + NhomVatLieu + ", LoaiVatLieu="
				+ LoaiVatLieu + ", DonViTinh=" + DonViTinh + ", DonGiaCoThue=" + DonGiaCoThue + ", DonGiaKhongThue="
				+ DonGiaKhongThue + ", TuNgay=" + TuNgay + ", DenNgay=" + DenNgay + ", TrangThaiText=" + TrangThaiText
				+ ", NguoiTao=" + NguoiTao + ", NgayTao=" + NgayTao + ", TrangThai=" + TrangThai + ", IDChiNhanh="
				+ IDChiNhanh + "]";
	}

}
