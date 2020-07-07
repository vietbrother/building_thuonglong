package com.api.thuonglongjsc.dto;

public class CategorySearch {
	private String id;
	private String name;
	private String type;
	private String status;
	private String ngayThang;
	private String IDChiNhanh;
	private String TuNgay;
	private String DenNgay;
	private String idTrangThai;
	private String categoryType;
	private String IDNhaCungCap;
	private String IDHD;
	private String IDCongTrinh;
	private String IDLoaiVatLieu;
	private String IDNhomVatLieu;

	public CategorySearch() {
		super();
	}

	public CategorySearch(String id, String name, String type, String status, String ngayThang, String iDChiNhanh,
			String tuNgay, String denNgay, String idTrangThai, String categoryType, String iDNhaCungCap, String iDHD,
			String iDCongTrinh, String iDLoaiVatLieu, String iDNhomVatLieu) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
		this.ngayThang = ngayThang;
		IDChiNhanh = iDChiNhanh;
		TuNgay = tuNgay;
		DenNgay = denNgay;
		this.idTrangThai = idTrangThai;
		this.categoryType = categoryType;
		IDNhaCungCap = iDNhaCungCap;
		IDHD = iDHD;
		IDCongTrinh = iDCongTrinh;
		IDLoaiVatLieu = iDLoaiVatLieu;
		IDNhomVatLieu = iDNhomVatLieu;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNgayThang() {
		return ngayThang;
	}

	public void setNgayThang(String ngayThang) {
		this.ngayThang = ngayThang;
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

	public String getIdTrangThai() {
		return idTrangThai;
	}

	public void setIdTrangThai(String idTrangThai) {
		this.idTrangThai = idTrangThai;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getIDNhaCungCap() {
		return IDNhaCungCap;
	}

	public void setIDNhaCungCap(String iDNhaCungCap) {
		IDNhaCungCap = iDNhaCungCap;
	}

	public String getIDHD() {
		return IDHD;
	}

	public String getIDCongTrinh() {
		return IDCongTrinh;
	}

	public void setIDCongTrinh(String iDCongTrinh) {
		IDCongTrinh = iDCongTrinh;
	}

	public void setIDHD(String iDHD) {
		IDHD = iDHD;
	}

	public String getIDLoaiVatLieu() {
		return IDLoaiVatLieu;
	}

	public void setIDLoaiVatLieu(String iDLoaiVatLieu) {
		IDLoaiVatLieu = iDLoaiVatLieu;
	}

	public String getIDNhomVatLieu() {
		return IDNhomVatLieu;
	}

	public void setIDNhomVatLieu(String iDNhomVatLieu) {
		IDNhomVatLieu = iDNhomVatLieu;
	}

	@Override
	public String toString() {
		return "CategorySearch [id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + ", ngayThang="
				+ ngayThang + ", IDChiNhanh=" + IDChiNhanh + ", TuNgay=" + TuNgay + ", DenNgay=" + DenNgay
				+ ", idTrangThai=" + idTrangThai + ", categoryType=" + categoryType + ", IDNhaCungCap=" + IDNhaCungCap
				+ ", IDHD=" + IDHD + ", IDCongTrinh=" + IDCongTrinh + ", IDLoaiVatLieu=" + IDLoaiVatLieu
				+ ", IDNhomVatLieu=" + IDNhomVatLieu + "]";
	}

}
