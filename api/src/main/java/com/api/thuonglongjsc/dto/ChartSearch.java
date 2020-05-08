package com.api.thuonglongjsc.dto;

public class ChartSearch {
	private String IDChiNhanh;
	private String TuNgay;
	private String DenNgay;
	private String idTrangThai;
	private String TrangThaiText;

	public ChartSearch() {
		super();
	}

	public ChartSearch(String iDChiNhanh, String tuNgay, String denNgay, String idTrangThai,
			String trangThaiText) {
		super();
		IDChiNhanh = iDChiNhanh;
		TuNgay = tuNgay;
		DenNgay = denNgay;
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
		return "ChartTotalSearch [IDChiNhanh=" + IDChiNhanh + ", TuNgay=" + TuNgay + ", DenNgay=" + DenNgay
				+ ", idTrangThai=" + idTrangThai + ", TrangThaiText=" + TrangThaiText + "]";
	}

}
