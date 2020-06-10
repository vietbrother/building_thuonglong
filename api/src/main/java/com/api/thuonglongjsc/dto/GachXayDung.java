package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class GachXayDung {
	private String ID;
	private Timestamp NgayThang;
	private String TenChiNhanh;
	private String TenLoaiVatLieu;
	private Integer SoMeTron;
	private Double KLXiMang;
	private Double KLCat;
	private Double KLDaMat;
	private Double KLVLKhac;
	private Integer SoLuong;
	private String GhiChu;
	private String TrangThaiText;
	private String TrangThaiChot;
	private String NguoiDuyet;
	private String NguoiDuyetChot;
	private Timestamp NgayTao;
	private String NguoiTao;
	private Integer TrangThai;
	private String IDChiNhanh;

	public GachXayDung() {
		super();
	}

	public GachXayDung(String iD, Timestamp ngayThang, String tenChiNhanh, String tenLoaiVatLieu, Integer soMeTron,
			Double kLXiMang, Double kLCat, Double kLDaMat, Double kLVLKhac, Integer soLuong, String ghiChu,
			String trangThaiText, String trangThaiChot, String nguoiDuyet, String nguoiDuyetChot, Timestamp ngayTao,
			String nguoiTao, Integer trangThai, String iDChiNhanh) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		TenChiNhanh = tenChiNhanh;
		TenLoaiVatLieu = tenLoaiVatLieu;
		SoMeTron = soMeTron;
		KLXiMang = kLXiMang;
		KLCat = kLCat;
		KLDaMat = kLDaMat;
		KLVLKhac = kLVLKhac;
		SoLuong = soLuong;
		GhiChu = ghiChu;
		TrangThaiText = trangThaiText;
		TrangThaiChot = trangThaiChot;
		NguoiDuyet = nguoiDuyet;
		NguoiDuyetChot = nguoiDuyetChot;
		NgayTao = ngayTao;
		NguoiTao = nguoiTao;
		TrangThai = trangThai;
		IDChiNhanh = iDChiNhanh;
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

	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	public String getTenLoaiVatLieu() {
		return TenLoaiVatLieu;
	}

	public void setTenLoaiVatLieu(String tenLoaiVatLieu) {
		TenLoaiVatLieu = tenLoaiVatLieu;
	}

	public Integer getSoMeTron() {
		return SoMeTron;
	}

	public void setSoMeTron(Integer soMeTron) {
		SoMeTron = soMeTron;
	}

	public Double getKLXiMang() {
		return KLXiMang;
	}

	public void setKLXiMang(Double kLXiMang) {
		KLXiMang = kLXiMang;
	}

	public Double getKLCat() {
		return KLCat;
	}

	public void setKLCat(Double kLCat) {
		KLCat = kLCat;
	}

	public Double getKLDaMat() {
		return KLDaMat;
	}

	public void setKLDaMat(Double kLDaMat) {
		KLDaMat = kLDaMat;
	}

	public Double getKLVLKhac() {
		return KLVLKhac;
	}

	public void setKLVLKhac(Double kLVLKhac) {
		KLVLKhac = kLVLKhac;
	}

	public Integer getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(Integer soLuong) {
		SoLuong = soLuong;
	}

	public String getGhiChu() {
		return GhiChu;
	}

	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}

	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	public String getTrangThaiChot() {
		return TrangThaiChot;
	}

	public void setTrangThaiChot(String trangThaiChot) {
		TrangThaiChot = trangThaiChot;
	}

	public String getNguoiDuyet() {
		return NguoiDuyet;
	}

	public void setNguoiDuyet(String nguoiDuyet) {
		NguoiDuyet = nguoiDuyet;
	}

	public String getNguoiDuyetChot() {
		return NguoiDuyetChot;
	}

	public void setNguoiDuyetChot(String nguoiDuyetChot) {
		NguoiDuyetChot = nguoiDuyetChot;
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
		return "GachXayDung [ID=" + ID + ", NgayThang=" + NgayThang + ", TenChiNhanh=" + TenChiNhanh
				+ ", TenLoaiVatLieu=" + TenLoaiVatLieu + ", SoMeTron=" + SoMeTron + ", KLXiMang=" + KLXiMang
				+ ", KLCat=" + KLCat + ", KLDaMat=" + KLDaMat + ", KLVLKhac=" + KLVLKhac + ", SoLuong=" + SoLuong
				+ ", GhiChu=" + GhiChu + ", TrangThaiText=" + TrangThaiText + ", TrangThaiChot=" + TrangThaiChot
				+ ", NguoiDuyet=" + NguoiDuyet + ", NguoiDuyetChot=" + NguoiDuyetChot + ", NgayTao=" + NgayTao
				+ ", NguoiTao=" + NguoiTao + ", TrangThai=" + TrangThai + ", IDChiNhanh=" + IDChiNhanh + "]";
	}

}
