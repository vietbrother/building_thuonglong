package com.api.thuonglongjsc.dto;

public class LichBanGachDuyet {
	private String IDChiNhanh;
	private String TuNgay;
	private String DenNgay;
	private String IDNhaCungCap;
	private String IDCongTrinh;
	private String MacBeTong;
	private String LoaiDa;
	private String DoSut;
	private String YCDB;
	private String HinhThucBom;
	private String idTrangThai;
	private String TrangThaiText;

	public LichBanGachDuyet() {
		super();
	}

	

	public LichBanGachDuyet(String iDChiNhanh, String tuNgay, String denNgay, String iDNhaCungCap,
			String iDCongTrinh, String macBeTong, String loaiDa, String doSut, String yCDB, String hinhThucBom,
			String idTrangThai, String trangThaiText) {
		super();
		IDChiNhanh = iDChiNhanh;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		IDNhaCungCap = iDNhaCungCap;
		IDCongTrinh = iDCongTrinh;
		MacBeTong = macBeTong;
		LoaiDa = loaiDa;
		DoSut = doSut;
		YCDB = yCDB;
		HinhThucBom = hinhThucBom;
		this.idTrangThai = idTrangThai;
		TrangThaiText = trangThaiText;
	}





	public String getIDChiNhanh() {
		return IDChiNhanh;
	}

	public void setIDChiNhanh(String iDChiNhanh) {
		IDChiNhanh = iDChiNhanh;
	}




	public String getTuNgay() {
		return TuNgay;
	}

	public void setTuNgay(String tuNgay) {
		TuNgay = tuNgay;
	}

	public String getDenNgay() {
		return DenNgay;
	}

	public void setDenNgay(String denNgay) {
		DenNgay = denNgay;
	}

	public String getIDNhaCungCap() {
		return IDNhaCungCap;
	}

	public void setIDNhaCungCap(String iDNhaCungCap) {
		IDNhaCungCap = iDNhaCungCap;
	}

	public String getIDCongTrinh() {
		return IDCongTrinh;
	}

	public void setIDCongTrinh(String iDCongTrinh) {
		IDCongTrinh = iDCongTrinh;
	}

	public String getMacBeTong() {
		return MacBeTong;
	}

	public void setMacBeTong(String macBeTong) {
		MacBeTong = macBeTong;
	}

	public String getLoaiDa() {
		return LoaiDa;
	}

	public void setLoaiDa(String loaiDa) {
		LoaiDa = loaiDa;
	}

	public String getDoSut() {
		return DoSut;
	}

	public void setDoSut(String doSut) {
		DoSut = doSut;
	}

	public String getYCDB() {
		return YCDB;
	}

	public void setYCDB(String yCDB) {
		YCDB = yCDB;
	}

	public String getHinhThucBom() {
		return HinhThucBom;
	}

	public void setHinhThucBom(String hinhThucBom) {
		HinhThucBom = hinhThucBom;
	}
	


	public String getIdTrangThai() {
		return idTrangThai;
	}



	public void setIdTrangThai(String idTrangThai) {
		this.idTrangThai = idTrangThai;
	}


	public String getTrangThaiText() {
		return TrangThaiText;
	}

	public void setTrangThaiText(String trangThaiText) {
		TrangThaiText = trangThaiText;
	}



	@Override
	public String toString() {
		return "LichXuatBeTongSearch [IDChiNhanh=" + IDChiNhanh + ", TuNgay=" + TuNgay + ", DenNgay=" + DenNgay
				+ ", IDNhaCungCap=" + IDNhaCungCap + ", IDCongTrinh=" + IDCongTrinh + ", MacBeTong=" + MacBeTong
				+ ", LoaiDa=" + LoaiDa + ", DoSut=" + DoSut + ", YCDB=" + YCDB + ", HinhThucBom=" + HinhThucBom
				+ ", idTrangThai=" + idTrangThai + ", TrangThaiText=" + TrangThaiText + "]";
	}



}
