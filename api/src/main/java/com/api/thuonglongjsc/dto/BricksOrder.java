package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class BricksOrder {
	private String ID;

	private Timestamp NgayThang;

	private String TenChiNhanh;

	private String TenNhaCungCap;

	private BigDecimal TienCoThue;

	private BigDecimal TienKhongThue;

	private String NoiDung;

	private Integer Loai;

	private String TenLoai;

	private String TrangThaiText;

	private String NguoiDuyet;

	private String NguoiXoa;

	private Timestamp NgayTao;

	private String NguoiTao;
	private String IDChiNhanh;
	
	private Integer TrangThai;

	public BricksOrder() {
		super();
	}
	
	public BricksOrder(String iD, Timestamp ngayThang, String tenChiNhanh, String tenNhaCungCap, BigDecimal tienCoThue,
			BigDecimal tienKhongThue, String noiDung, Integer loai, String tenLoai, String trangThaiText,
			String nguoiDuyet, String nguoiXoa, Timestamp ngayTao, String nguoiTao, String iDChiNhanh,
			Integer trangThai) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		TenChiNhanh = tenChiNhanh;
		TenNhaCungCap = tenNhaCungCap;
		TienCoThue = tienCoThue;
		TienKhongThue = tienKhongThue;
		NoiDung = noiDung;
		Loai = loai;
		TenLoai = tenLoai;
		TrangThaiText = trangThaiText;
		NguoiDuyet = nguoiDuyet;
		NguoiXoa = nguoiXoa;
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



	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}



	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
	}



	public BigDecimal getTienCoThue() {
		return TienCoThue;
	}



	public void setTienCoThue(BigDecimal tienCoThue) {
		TienCoThue = tienCoThue;
	}



	public BigDecimal getTienKhongThue() {
		return TienKhongThue;
	}



	public void setTienKhongThue(BigDecimal tienKhongThue) {
		TienKhongThue = tienKhongThue;
	}



	public String getNoiDung() {
		return NoiDung;
	}



	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}



	public Integer getLoai() {
		return Loai;
	}



	public void setLoai(Integer loai) {
		Loai = loai;
	}



	public String getTenLoai() {
		return TenLoai;
	}



	public void setTenLoai(String tenLoai) {
		TenLoai = tenLoai;
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
		return "BricksOrder [ID=" + ID + ", NgayThang=" + NgayThang + ", TenChiNhanh=" + TenChiNhanh
				+ ", TenNhaCungCap=" + TenNhaCungCap + ", TienCoThue=" + TienCoThue + ", TienKhongThue=" + TienKhongThue
				+ ", NoiDung=" + NoiDung + ", Loai=" + Loai + ", TenLoai=" + TenLoai + ", TrangThaiText="
				+ TrangThaiText + ", NguoiDuyet=" + NguoiDuyet + ", NguoiXoa=" + NguoiXoa + ", NgayTao=" + NgayTao
				+ ", NguoiTao=" + NguoiTao + ", IDChiNhanh=" + IDChiNhanh + ", TrangThai=" + TrangThai + "]";
	}
}
