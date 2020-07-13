package com.api.thuonglongjsc.dto;

public class LichXuatBeTongDuyet {
	private Integer TrangThai;
	private String IDHopDong;

	public LichXuatBeTongDuyet() {
		super();
	}

	public LichXuatBeTongDuyet(Integer trangThai, String iDHopDong) {
		super();
		TrangThai = trangThai;
		IDHopDong = iDHopDong;
	}

	public Integer getTrangThai() {
		return TrangThai;
	}

	public void setTrangThai(Integer trangThai) {
		TrangThai = trangThai;
	}

	public String getIDHopDong() {
		return IDHopDong;
	}

	public void setIDHopDong(String iDHopDong) {
		IDHopDong = iDHopDong;
	}

	@Override
	public String toString() {
		return "LichXuatBeTongDuyet [TrangThai=" + TrangThai + ", IDHopDong=" + IDHopDong + "]";
	}

}
