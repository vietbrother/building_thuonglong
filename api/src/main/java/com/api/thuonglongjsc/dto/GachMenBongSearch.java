package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class GachMenBongSearch {
	private String ID;

	private Timestamp NgayThang;

	private String TenChiNhanh;

	private String TenLoaiGach;

	private Integer SoLuong;

	private String GhiChu;

	private Integer SoMeTron1;

	private Integer SoMeTron2;

	private Double KLCatSongDa;

	private Double KLBotMau;

	private Double KLKeoBong;

	private Double KLXiMangPCB401;

	private Double KLCatSongDa2;

	private Double KLXiMangPCB402;

	private Double KLDaMat;

	private String TrangThaiText;

	private Integer TrangThaiChot;

	private String NguoiDuyet;

	private String NguoiDuyetChot;

	private Timestamp NgayTao;

	private String NguoiTao;

	public GachMenBongSearch() {
		super();
	}

	public GachMenBongSearch(String iD, Timestamp ngayThang, String tenChiNhanh, String tenLoaiGach, Integer soLuong,
			String ghiChu, Integer soMeTron1, Integer soMeTron2, Double kLCatSongDa, Double kLBotMau, Double kLKeoBong,
			Double kLXiMangPCB401, Double kLCatSongDa2, Double kLXiMangPCB402, Double kLDaMat, String trangThaiText,
			Integer trangThaiChot, String nguoiDuyet, String nguoiDuyetChot, Timestamp ngayTao, String nguoiTao) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		TenChiNhanh = tenChiNhanh;
		TenLoaiGach = tenLoaiGach;
		SoLuong = soLuong;
		GhiChu = ghiChu;
		SoMeTron1 = soMeTron1;
		SoMeTron2 = soMeTron2;
		KLCatSongDa = kLCatSongDa;
		KLBotMau = kLBotMau;
		KLKeoBong = kLKeoBong;
		KLXiMangPCB401 = kLXiMangPCB401;
		KLCatSongDa2 = kLCatSongDa2;
		KLXiMangPCB402 = kLXiMangPCB402;
		KLDaMat = kLDaMat;
		TrangThaiText = trangThaiText;
		TrangThaiChot = trangThaiChot;
		NguoiDuyet = nguoiDuyet;
		NguoiDuyetChot = nguoiDuyetChot;
		NgayTao = ngayTao;
		NguoiTao = nguoiTao;
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

	public String getTenLoaiGach() {
		return TenLoaiGach;
	}

	public void setTenLoaiGach(String tenLoaiGach) {
		TenLoaiGach = tenLoaiGach;
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

	public Integer getSoMeTron1() {
		return SoMeTron1;
	}

	public void setSoMeTron1(Integer soMeTron1) {
		SoMeTron1 = soMeTron1;
	}

	public Integer getSoMeTron2() {
		return SoMeTron2;
	}

	public void setSoMeTron2(Integer soMeTron2) {
		SoMeTron2 = soMeTron2;
	}

	public Double getKLCatSongDa() {
		return KLCatSongDa;
	}

	public void setKLCatSongDa(Double kLCatSongDa) {
		KLCatSongDa = kLCatSongDa;
	}

	public Double getKLBotMau() {
		return KLBotMau;
	}

	public void setKLBotMau(Double kLBotMau) {
		KLBotMau = kLBotMau;
	}

	public Double getKLKeoBong() {
		return KLKeoBong;
	}

	public void setKLKeoBong(Double kLKeoBong) {
		KLKeoBong = kLKeoBong;
	}

	public Double getKLXiMangPCB401() {
		return KLXiMangPCB401;
	}

	public void setKLXiMangPCB401(Double kLXiMangPCB401) {
		KLXiMangPCB401 = kLXiMangPCB401;
	}

	public Double getKLCatSongDa2() {
		return KLCatSongDa2;
	}

	public void setKLCatSongDa2(Double kLCatSongDa2) {
		KLCatSongDa2 = kLCatSongDa2;
	}

	public Double getKLXiMangPCB402() {
		return KLXiMangPCB402;
	}

	public void setKLXiMangPCB402(Double kLXiMangPCB402) {
		KLXiMangPCB402 = kLXiMangPCB402;
	}

	public Double getKLDaMat() {
		return KLDaMat;
	}

	public void setKLDaMat(Double kLDaMat) {
		KLDaMat = kLDaMat;
	}

	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	public Integer getTrangThaiChot() {
		return TrangThaiChot;
	}

	public void setTrangThaiChot(Integer trangThaiChot) {
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

	@Override
	public String toString() {
		return "GachMenBongSearch [ID=" + ID + ", NgayThang=" + NgayThang + ", TenChiNhanh=" + TenChiNhanh
				+ ", TenLoaiGach=" + TenLoaiGach + ", SoLuong=" + SoLuong + ", GhiChu=" + GhiChu + ", SoMeTron1="
				+ SoMeTron1 + ", SoMeTron2=" + SoMeTron2 + ", KLCatSongDa=" + KLCatSongDa + ", KLBotMau=" + KLBotMau
				+ ", KLKeoBong=" + KLKeoBong + ", KLXiMangPCB401=" + KLXiMangPCB401 + ", KLCatSongDa2=" + KLCatSongDa2
				+ ", KLXiMangPCB402=" + KLXiMangPCB402 + ", KLDaMat=" + KLDaMat + ", TrangThaiText=" + TrangThaiText
				+ ", TrangThaiChot=" + TrangThaiChot + ", NguoiDuyet=" + NguoiDuyet + ", NguoiDuyetChot="
				+ NguoiDuyetChot + ", NgayTao=" + NgayTao + ", NguoiTao=" + NguoiTao + "]";
	}
}
