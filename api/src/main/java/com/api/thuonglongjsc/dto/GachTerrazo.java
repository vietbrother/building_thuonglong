package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class GachTerrazo {
	private String ID;

	private Timestamp NgayThang;

	private String TenChiNhanh;

	private String TenLoaiGach;

	private Integer SoLuong;

	private String GhiChu;

	private Integer SoMeTron1;

	private Integer SoMeTron2;

	private Double TLMauXi;

	private Double TLMauDo;

	private Double TLBotDa;

	private Double TLDaDen2ly;

	private Double TLDaTrang2Ly;

	private Double TLDaTrang4Ly;

	private Double TLXiMangPCB401;

	private Double TLXiMangPCB402;

	private Double TLMatDa;

	private Double TLCatSongDa;

	private String TrangThaiText;

	private Integer TrangThaiChot;

	private String NguoiDuyet;

	private String NguoiDuyetChot;

	private Timestamp NgayTao;

	private String NguoiTao;
	private String IDChiNhanh;
	private Integer TrangThai;

	public GachTerrazo() {
		super();
	}

	public GachTerrazo(String iD, Timestamp ngayThang, String tenChiNhanh, String tenLoaiGach, Integer soLuong,
			String ghiChu, Integer soMeTron1, Integer soMeTron2, Double tLMauXi, Double tLMauDo, Double tLBotDa,
			Double tLDaDen2ly, Double tLDaTrang2Ly, Double tLDaTrang4Ly, Double tLXiMangPCB401, Double tLXiMangPCB402,
			Double tLMatDa, Double tLCatSongDa, String trangThaiText, Integer trangThaiChot, String nguoiDuyet,
			String nguoiDuyetChot, Timestamp ngayTao, String nguoiTao, String iDChiNhanh, Integer trangThai) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		TenChiNhanh = tenChiNhanh;
		TenLoaiGach = tenLoaiGach;
		SoLuong = soLuong;
		GhiChu = ghiChu;
		SoMeTron1 = soMeTron1;
		SoMeTron2 = soMeTron2;
		TLMauXi = tLMauXi;
		TLMauDo = tLMauDo;
		TLBotDa = tLBotDa;
		TLDaDen2ly = tLDaDen2ly;
		TLDaTrang2Ly = tLDaTrang2Ly;
		TLDaTrang4Ly = tLDaTrang4Ly;
		TLXiMangPCB401 = tLXiMangPCB401;
		TLXiMangPCB402 = tLXiMangPCB402;
		TLMatDa = tLMatDa;
		TLCatSongDa = tLCatSongDa;
		TrangThaiText = trangThaiText;
		TrangThaiChot = trangThaiChot;
		NguoiDuyet = nguoiDuyet;
		NguoiDuyetChot = nguoiDuyetChot;
		NgayTao = ngayTao;
		NguoiTao = nguoiTao;
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

	public Double getTLMauXi() {
		return TLMauXi;
	}

	public void setTLMauXi(Double tLMauXi) {
		TLMauXi = tLMauXi;
	}

	public Double getTLMauDo() {
		return TLMauDo;
	}

	public void setTLMauDo(Double tLMauDo) {
		TLMauDo = tLMauDo;
	}

	public Double getTLBotDa() {
		return TLBotDa;
	}

	public void setTLBotDa(Double tLBotDa) {
		TLBotDa = tLBotDa;
	}

	public Double getTLDaDen2ly() {
		return TLDaDen2ly;
	}

	public void setTLDaDen2ly(Double tLDaDen2ly) {
		TLDaDen2ly = tLDaDen2ly;
	}

	public Double getTLDaTrang2Ly() {
		return TLDaTrang2Ly;
	}

	public void setTLDaTrang2Ly(Double tLDaTrang2Ly) {
		TLDaTrang2Ly = tLDaTrang2Ly;
	}

	public Double getTLDaTrang4Ly() {
		return TLDaTrang4Ly;
	}

	public void setTLDaTrang4Ly(Double tLDaTrang4Ly) {
		TLDaTrang4Ly = tLDaTrang4Ly;
	}

	public Double getTLXiMangPCB401() {
		return TLXiMangPCB401;
	}

	public void setTLXiMangPCB401(Double tLXiMangPCB401) {
		TLXiMangPCB401 = tLXiMangPCB401;
	}

	public Double getTLXiMangPCB402() {
		return TLXiMangPCB402;
	}

	public void setTLXiMangPCB402(Double tLXiMangPCB402) {
		TLXiMangPCB402 = tLXiMangPCB402;
	}

	public Double getTLMatDa() {
		return TLMatDa;
	}

	public void setTLMatDa(Double tLMatDa) {
		TLMatDa = tLMatDa;
	}

	public Double getTLCatSongDa() {
		return TLCatSongDa;
	}

	public void setTLCatSongDa(Double tLCatSongDa) {
		TLCatSongDa = tLCatSongDa;
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
		return "GachTerrazo [ID=" + ID + ", NgayThang=" + NgayThang + ", TenChiNhanh=" + TenChiNhanh + ", TenLoaiGach="
				+ TenLoaiGach + ", SoLuong=" + SoLuong + ", GhiChu=" + GhiChu + ", SoMeTron1=" + SoMeTron1
				+ ", SoMeTron2=" + SoMeTron2 + ", TLMauXi=" + TLMauXi + ", TLMauDo=" + TLMauDo + ", TLBotDa=" + TLBotDa
				+ ", TLDaDen2ly=" + TLDaDen2ly + ", TLDaTrang2Ly=" + TLDaTrang2Ly + ", TLDaTrang4Ly=" + TLDaTrang4Ly
				+ ", TLXiMangPCB401=" + TLXiMangPCB401 + ", TLXiMangPCB402=" + TLXiMangPCB402 + ", TLMatDa=" + TLMatDa
				+ ", TLCatSongDa=" + TLCatSongDa + ", TrangThaiText=" + TrangThaiText + ", TrangThaiChot="
				+ TrangThaiChot + ", NguoiDuyet=" + NguoiDuyet + ", NguoiDuyetChot=" + NguoiDuyetChot + ", NgayTao="
				+ NgayTao + ", NguoiTao=" + NguoiTao + ", IDChiNhanh=" + IDChiNhanh + ", TrangThai=" + TrangThai + "]";
	}

}
