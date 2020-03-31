package com.api.thuonglongjsc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblUserAccount")
public class TblUserAccount {

	private String UserName;
	private String Password;
	private Date BirthDay;
	private String Email;
	private String PhoneNumber;
	private Boolean TrangThai;
	private String TrangThaiText;
	private Integer LoaiTaiKhoan;
	private Date NgayTao;
	private String NguoiTao;
	private Integer CauHoi1;
	private String TraLoi1;
	private Integer CauHoi2;
	private String TraLoi2;
	private Integer CauHoi3;
	private String TraLoi3;
	private String SessionLogin;

	public TblUserAccount() {

	}

	public TblUserAccount(String userName, String password, Date birthDay, String email, String phoneNumber,
			Boolean trangThai, String trangThaiText, Integer loaiTaiKhoan, Date ngayTao, String nguoiTao,
			Integer cauHoi1, String traLoi1, Integer cauHoi2, String traLoi2, Integer cauHoi3, String traLoi3,
			String sessionLogin) {
		super();
		UserName = userName;
		Password = password;
		BirthDay = birthDay;
		Email = email;
		PhoneNumber = phoneNumber;
		TrangThai = trangThai;
		TrangThaiText = trangThaiText;
		LoaiTaiKhoan = loaiTaiKhoan;
		NgayTao = ngayTao;
		NguoiTao = nguoiTao;
		CauHoi1 = cauHoi1;
		TraLoi1 = traLoi1;
		CauHoi2 = cauHoi2;
		TraLoi2 = traLoi2;
		CauHoi3 = cauHoi3;
		TraLoi3 = traLoi3;
		SessionLogin = sessionLogin;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}
	
	@Column(name = "Password", nullable = true)
	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Column(name = "BirthDay", nullable = true)
	public Date getBirthDay() {
		return BirthDay;
	}

	public void setBirthDay(Date birthDay) {
		BirthDay = birthDay;
	}

	@Column(name = "Email", nullable = true)
	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Column(name = "PhoneNumber", nullable = true)
	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	@Column(name = "TrangThai", nullable = true)
	public Boolean getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Boolean trangThai) {
		TrangThai = trangThai;
	}

	@Column(name = "TrangThaiText", nullable = true)
	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}

	@Column(name = "LoaiTaiKhoan", nullable = true)
	public Integer getLoaiTaiKhoan() {
		return LoaiTaiKhoan;
	}

	public void setLoaiTaiKhoan(Integer loaiTaiKhoan) {
		LoaiTaiKhoan = loaiTaiKhoan;
	}

	@Column(name = "NgayTao", nullable = true)
	public Date getNgayTao() {
		return NgayTao;
	}

	public void setNgayTao(Date ngayTao) {
		NgayTao = ngayTao;
	}

	@Column(name = "NguoiTao", nullable = true)
	public String getNguoiTao() {
		return NguoiTao;
	}

	public void setNguoiTao(String nguoiTao) {
		NguoiTao = nguoiTao;
	}

	@Column(name = "CauHoi1", nullable = true)
	public Integer getCauHoi1() {
		return CauHoi1;
	}

	public void setCauHoi1(Integer cauHoi1) {
		CauHoi1 = cauHoi1;
	}

	@Column(name = "TraLoi1", nullable = true)
	public String getTraLoi1() {
		return TraLoi1;
	}

	public void setTraLoi1(String traLoi1) {
		TraLoi1 = traLoi1;
	}

	@Column(name = "CauHoi2", nullable = true)
	public Integer getCauHoi2() {
		return CauHoi2;
	}

	public void setCauHoi2(Integer cauHoi2) {
		CauHoi2 = cauHoi2;
	}

	@Column(name = "TraLoi2", nullable = true)
	public String getTraLoi2() {
		return TraLoi2;
	}

	public void setTraLoi2(String traLoi2) {
		TraLoi2 = traLoi2;
	}

	@Column(name = "CauHoi3", nullable = true)
	public Integer getCauHoi3() {
		return CauHoi3;
	}

	public void setCauHoi3(Integer cauHoi3) {
		CauHoi3 = cauHoi3;
	}

	@Column(name = "TraLoi3", nullable = true)
	public String getTraLoi3() {
		return TraLoi3;
	}

	public void setTraLoi3(String traLoi3) {
		TraLoi3 = traLoi3;
	}

	@Column(name = "SessionLogin", nullable = true)
	public String getSessionLogin() {
		return SessionLogin;
	}

	public void setSessionLogin(String sessionLogin) {
		SessionLogin = sessionLogin;
	}

	@Override
	public String toString() {
		return "UserAccount [UserName=" + UserName + ", Password=" + Password + ", BirthDay=" + BirthDay + ", Email="
				+ Email + ", PhoneNumber=" + PhoneNumber + ", TrangThai=" + TrangThai + ", TrangThaiText="
				+ TrangThaiText + ", LoaiTaiKhoan=" + LoaiTaiKhoan + ", NgayTao=" + NgayTao + ", NguoiTao=" + NguoiTao
				+ ", CauHoi1=" + CauHoi1 + ", TraLoi1=" + TraLoi1 + ", CauHoi2=" + CauHoi2 + ", TraLoi2=" + TraLoi2
				+ ", CauHoi3=" + CauHoi3 + ", TraLoi3=" + TraLoi3 + ", SessionLogin=" + SessionLogin + "]";
	}



}
