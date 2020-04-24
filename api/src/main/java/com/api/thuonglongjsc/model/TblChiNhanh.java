package com.api.thuonglongjsc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tblchinhanh", schema = "dbo")
public class TblChiNhanh {
	private String ID;
	private String IDCha;
	private String TenChiNhanh;
	private String DiaChi;
	private String Email;
	private String PhoneNumber;
	private Boolean TrangThai;
	private String TrangThaiText;
	private Integer LoaiChiNhanh;
	private Date NgayTao;
	private String NguoiTao;

	@Column(name = "IDCha")
	public String getIDCha() {
		return IDCha;
	}

	public void setIDCha(String iDCha) {
		IDCha = iDCha;
	}

	@Column(name = "TenChiNhanh")
	public String getTenChiNhanh() {
		return TenChiNhanh;
	}

	public void setTenChiNhanh(String tenChiNhanh) {
		TenChiNhanh = tenChiNhanh;
	}

	@Column(name = "diachi")
	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	@Column(name = "Email")
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Column(name = "PhoneNumber")
	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Column(name = "TrangThai")
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}

	@Column(name = "TrangThaiText")
	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	@Column(name = "loaichinhanh")
	public Integer getLoaiChiNhanh() {
		return LoaiChiNhanh;
	}

	public void setLoaiChiNhanh(Integer loaiChiNhanh) {
		LoaiChiNhanh = loaiChiNhanh;
	}

	public TblChiNhanh() {
		super();
	}	


	public TblChiNhanh(String iD, String tenChiNhanh) {
		super();
		ID = iD;
		TenChiNhanh = tenChiNhanh;
	}

	public TblChiNhanh(String iD, String iDCha, String tenChiNhanh, String diaChi, String email, String phoneNumber,
			Boolean trangThai, String trangThaiText, Integer loaiChiNhanh, Date ngayTao, String nguoiTao) {
		super();
		ID = iD;
		IDCha = iDCha;
		TenChiNhanh = tenChiNhanh;
		DiaChi = diaChi;
		Email = email;
		PhoneNumber = phoneNumber;
		TrangThai = trangThai;
		TrangThaiText = trangThaiText;
		LoaiChiNhanh = loaiChiNhanh;
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

	@Override
	public String toString() {
		return "TblChiNhanh [ID=" + ID + ", IDCha=" + IDCha + ", TenChiNhanh=" + TenChiNhanh + ", DiaChi=" + DiaChi
				+ ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", TrangThai=" + TrangThai + ", TrangThaiText="
				+ TrangThaiText + ", LoaiChiNhanh=" + LoaiChiNhanh + ", NgayTao=" + NgayTao + ", NguoiTao=" + NguoiTao
				+ "]";
	}

}
