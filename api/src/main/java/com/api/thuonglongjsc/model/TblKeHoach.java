package com.api.thuonglongjsc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblKeHoach")
public class TblKeHoach {

	private String ID;
	private Date NgayThang;
	private String IDChiNhanh;
	private String IDLoaiKeHoach;
	private String TenKeHoach;
	private String NoiDung;
	private String DonViThucHien;
	private String FileUpload;
	private Integer TrangThai;
	private String TrangThaiText;
	private String NguoiDuyet;
	private String NguoiXoa;
	private Date NgayTao;
	private String NguoiTao;

	public TblKeHoach() {

	}

	public TblKeHoach(String iD, Date ngayThang, String iDChiNhanh, String iDLoaiKeHoach, String tenKeHoach, String noiDung,
			String donViThucHien, String fileUpload, Integer trangThai, String trangThaiText, String nguoiDuyet,
			String nguoiXoa, Date ngayTao, String nguoiTao) {
		super();
		ID = iD;
		NgayThang = ngayThang;
		IDChiNhanh = iDChiNhanh;
		IDLoaiKeHoach = iDLoaiKeHoach;
		TenKeHoach = tenKeHoach;
		NoiDung = noiDung;
		DonViThucHien = donViThucHien;
		FileUpload = fileUpload;
		TrangThai = trangThai;
		TrangThaiText = trangThaiText;
		NguoiDuyet = nguoiDuyet;
		NguoiXoa = nguoiXoa;
		NgayTao = ngayTao;
		NguoiTao = nguoiTao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	@Column(name = "NgayThang")
	public Date getNgayThang() {
		return NgayThang;
	}

	public void setNgayThang(Date ngayThang) {
		NgayThang = ngayThang;
	}

	@Column(name = "IDChiNhanh")
	public String getIDChiNhanh() {
		return IDChiNhanh;
	}

	public void setIDChiNhanh(String iDChiNhanh) {
		IDChiNhanh = iDChiNhanh;
	}

	@Column(name = "IDLoaiKeHoach")
	public String getIDLoaiKeHoach() {
		return IDLoaiKeHoach;
	}

	public void setIDLoaiKeHoach(String iDLoaiKeHoach) {
		IDLoaiKeHoach = iDLoaiKeHoach;
	}

	@Column(name = "TenKeHoach")
	public String getTenKeHoach() {
		return TenKeHoach;
	}

	public void setTenKeHoach(String tenKeHoach) {
		TenKeHoach = tenKeHoach;
	}

	@Column(name = "NoiDung")
	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		NoiDung = noiDung;
	}

	@Column(name = "DonViThucHien")
	public String getDonViThucHien() {
		return DonViThucHien;
	}

	public void setDonViThucHien(String donViThucHien) {
		DonViThucHien = donViThucHien;
	}

	@Column(name = "FileUpload")
	public String getFileUpload() {
		return FileUpload;
	}

	public void setFileUpload(String fileUpload) {
		FileUpload = fileUpload;
	}

	@Column(name = "TrangThai")
	public Integer getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Integer trangThai) {
		TrangThai = trangThai;
	}

	@Column(name = "TrangThaiText")
	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	@Column(name = "NguoiDuyet")
	public String getNguoiDuyet() {
		return NguoiDuyet;
	}

	public void setNguoiDuyet(String nguoiDuyet) {
		NguoiDuyet = nguoiDuyet;
	}

	@Column(name = "NguoiXoa")
	public String getNguoiXoa() {
		return NguoiXoa;
	}

	public void setNguoiXoa(String nguoiXoa) {
		NguoiXoa = nguoiXoa;
	}

	@Column(name = "NgayTao")
	public Date getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(Date ngayTao) {
		NgayTao = ngayTao;
	}

	@Column(name = "NguoiTao")
	public String getNguoiTao() {
		return NguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		NguoiTao = nguoiTao;
	}

	@Override
	public String toString() {
		return "TblKeHoach [ID=" + ID + ", NgayThang=" + NgayThang + ", IDChiNhanh=" + IDChiNhanh + ", IDLoaiKeHoach="
				+ IDLoaiKeHoach + ", TenKeHoach=" + TenKeHoach + ", NoiDung=" + NoiDung + ", DonViThucHien="
				+ DonViThucHien + ", FileUpload=" + FileUpload + ", TrangThai=" + TrangThai + ", TrangThaiText="
				+ TrangThaiText + ", NguoiDuyet=" + NguoiDuyet + ", NguoiXoa=" + NguoiXoa + ", NgayTao=" + NgayTao
				+ ", NguoiTao=" + NguoiTao + "]";
	}

}
