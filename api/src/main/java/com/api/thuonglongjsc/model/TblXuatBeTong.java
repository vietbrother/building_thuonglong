package com.api.thuonglongjsc.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TblXuatBeTong")
public class TblXuatBeTong {
	private String ID;
	private String IDChung;
	private Date GioXuat;
	private Date NgayThang;
	private String IDChiNhanh;
	private String IDNhaCungCap;
	private String IDCongTrinh;
	private String MacBeTong;
	private String LoaiDa;
	private String DoSut;
	private String YCDB;
	private String XiMang;
	private String Cat;
	private String PhuGia;
	private String TroBay;
	private String HinhThucBom;
	private String IDHopDong;
	private String IDHopDongBom;
	private String IDLich;
	private String IDXeBom;
	private String IDXeTron;
	private String TenXeBom;
	private String TenXeTron;
	private Long DonGiaHoaDon;
	private Long DonGiaThanhToan;
	private Long TienHoaDon;
	private Long TienThanhToan;
	private Long DonGiaHoaDonBom;
	private Long DonGiaThanhToanBom;
	private Long TienHoaDonBom;
	private Long TienThanhToanBom;
	private Double KLKhachHang;
	private Double KLThucXuat;
	private Double KLQuaCan;
	private Double KLTramTron;
	private Double KLXiMang;
	private Double KLDa;
	private Double KLCat;
	private Double KLPhuGia;
	private Double KLTroBay;
	private Double DMXiMang;
	private Double DMDa;
	private Double DMCat;
	private Double DMPhuGia;
	private Double DMTroBay;
	private Integer TrangThai;
	private String TrangThaiText;
	private String NguoiDuyet;
	private Integer TrangThaiChot;
	private String NguoiChot;
	private String NguoiDuyetChot;
	private String NguoiXoa;
	private Date NgayTao;
	private String NguoiTao;

	public TblXuatBeTong() {
		super();
	}

	public TblXuatBeTong(String iD, String iDChung, Date gioXuat, Date ngayThang, String iDChiNhanh,
			String iDNhaCungCap, String iDCongTrinh, String macBeTong, String loaiDa, String doSut, String yCDB,
			String xiMang, String cat, String phuGia, String troBay, String hinhThucBom, String iDHopDong,
			String iDHopDongBom, String iDLich, String iDXeBom, String iDXeTron, String tenXeBom, String tenXeTron,
			Long donGiaHoaDon, Long donGiaThanhToan, Long tienHoaDon, Long tienThanhToan, Long donGiaHoaDonBom,
			Long donGiaThanhToanBom, Long tienHoaDonBom, Long tienThanhToanBom, Double kLKhachHang, Double kLThucXuat,
			Double kLQuaCan, Double kLTramTron, Double kLXiMang, Double kLDa, Double kLCat, Double kLPhuGia,
			Double kLTroBay, Double dMXiMang, Double dMDa, Double dMCat, Double dMPhuGia, Double dMTroBay,
			Integer trangThai, String trangThaiText, String nguoiDuyet, Integer trangThaiChot, String nguoiChot,
			String nguoiDuyetChot, String nguoiXoa, Date ngayTao, String nguoiTao) {
		super();
		ID = iD;
		IDChung = iDChung;
		GioXuat = gioXuat;
		NgayThang = ngayThang;
		IDChiNhanh = iDChiNhanh;
		IDNhaCungCap = iDNhaCungCap;
		IDCongTrinh = iDCongTrinh;
		MacBeTong = macBeTong;
		LoaiDa = loaiDa;
		DoSut = doSut;
		YCDB = yCDB;
		XiMang = xiMang;
		Cat = cat;
		PhuGia = phuGia;
		TroBay = troBay;
		HinhThucBom = hinhThucBom;
		IDHopDong = iDHopDong;
		IDHopDongBom = iDHopDongBom;
		IDLich = iDLich;
		IDXeBom = iDXeBom;
		IDXeTron = iDXeTron;
		TenXeBom = tenXeBom;
		TenXeTron = tenXeTron;
		DonGiaHoaDon = donGiaHoaDon;
		DonGiaThanhToan = donGiaThanhToan;
		TienHoaDon = tienHoaDon;
		TienThanhToan = tienThanhToan;
		DonGiaHoaDonBom = donGiaHoaDonBom;
		DonGiaThanhToanBom = donGiaThanhToanBom;
		TienHoaDonBom = tienHoaDonBom;
		TienThanhToanBom = tienThanhToanBom;
		KLKhachHang = kLKhachHang;
		KLThucXuat = kLThucXuat;
		KLQuaCan = kLQuaCan;
		KLTramTron = kLTramTron;
		KLXiMang = kLXiMang;
		KLDa = kLDa;
		KLCat = kLCat;
		KLPhuGia = kLPhuGia;
		KLTroBay = kLTroBay;
		DMXiMang = dMXiMang;
		DMDa = dMDa;
		DMCat = dMCat;
		DMPhuGia = dMPhuGia;
		DMTroBay = dMTroBay;
		TrangThai = trangThai;
		TrangThaiText = trangThaiText;
		NguoiDuyet = nguoiDuyet;
		TrangThaiChot = trangThaiChot;
		NguoiChot = nguoiChot;
		NguoiDuyetChot = nguoiDuyetChot;
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

	@Column(name = "IDChung")
	public String getIDChung() {
		return IDChung;
	}

	public void setIDChung(String iDChung) {
		IDChung = iDChung;
	}

	@Column(name = "GioXuat")
	public Date getGioXuat() {
		return GioXuat;
	}

	public void setGioXuat(Date gioXuat) {
		GioXuat = gioXuat;
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

	@Column(name = "IDNhaCungCap")
	public String getIDNhaCungCap() {
		return IDNhaCungCap;
	}

	public void setIDNhaCungCap(String iDNhaCungCap) {
		IDNhaCungCap = iDNhaCungCap;
	}

	@Column(name = "IDCongTrinh")
	public String getIDCongTrinh() {
		return IDCongTrinh;
	}

	public void setIDCongTrinh(String iDCongTrinh) {
		IDCongTrinh = iDCongTrinh;
	}

	@Column(name = "MacBeTong")
	public String getMacBeTong() {
		return MacBeTong;
	}

	public void setMacBeTong(String macBeTong) {
		MacBeTong = macBeTong;
	}

	@Column(name = "LoaiDa")
	public String getLoaiDa() {
		return LoaiDa;
	}

	public void setLoaiDa(String loaiDa) {
		LoaiDa = loaiDa;
	}

	@Column(name = "DoSut")
	public String getDoSut() {
		return DoSut;
	}

	public void setDoSut(String doSut) {
		DoSut = doSut;
	}

	@Column(name = "YCDB")
	public String getYCDB() {
		return YCDB;
	}

	public void setYCDB(String yCDB) {
		YCDB = yCDB;
	}

	@Column(name = "XiMang")
	public String getXiMang() {
		return XiMang;
	}

	public void setXiMang(String xiMang) {
		XiMang = xiMang;
	}

	@Column(name = "Cat")
	public String getCat() {
		return Cat;
	}

	public void setCat(String cat) {
		Cat = cat;
	}

	@Column(name = "PhuGia")
	public String getPhuGia() {
		return PhuGia;
	}

	public void setPhuGia(String phuGia) {
		PhuGia = phuGia;
	}

	@Column(name = "TroBay")
	public String getTroBay() {
		return TroBay;
	}

	public void setTroBay(String troBay) {
		TroBay = troBay;
	}

	@Column(name = "HinhThucBom")
	public String getHinhThucBom() {
		return HinhThucBom;
	}

	public void setHinhThucBom(String hinhThucBom) {
		HinhThucBom = hinhThucBom;
	}

	@Column(name = "IDHopDong")
	public String getIDHopDong() {
		return IDHopDong;
	}

	public void setIDHopDong(String iDHopDong) {
		IDHopDong = iDHopDong;
	}

	@Column(name = "IDHopDongBom")
	public String getIDHopDongBom() {
		return IDHopDongBom;
	}

	public void setIDHopDongBom(String iDHopDongBom) {
		IDHopDongBom = iDHopDongBom;
	}

	@Column(name = "IDLich")
	public String getIDLich() {
		return IDLich;
	}

	public void setIDLich(String iDLich) {
		IDLich = iDLich;
	}

	@Column(name = "IDXeBom")
	public String getIDXeBom() {
		return IDXeBom;
	}

	public void setIDXeBom(String iDXeBom) {
		IDXeBom = iDXeBom;
	}

	@Column(name = "IDXeTron")
	public String getIDXeTron() {
		return IDXeTron;
	}

	public void setIDXeTron(String iDXeTron) {
		IDXeTron = iDXeTron;
	}

	@Column(name = "TenXeBom")
	public String getTenXeBom() {
		return TenXeBom;
	}

	public void setTenXeBom(String tenXeBom) {
		TenXeBom = tenXeBom;
	}

	@Column(name = "TenXeTron")
	public String getTenXeTron() {
		return TenXeTron;
	}

	public void setTenXeTron(String tenXeTron) {
		TenXeTron = tenXeTron;
	}

	@Column(name = "DonGiaHoaDon")
	public Long getDonGiaHoaDon() {
		return DonGiaHoaDon;
	}

	public void setDonGiaHoaDon(Long donGiaHoaDon) {
		DonGiaHoaDon = donGiaHoaDon;
	}

	@Column(name = "DonGiaThanhToan")
	public Long getDonGiaThanhToan() {
		return DonGiaThanhToan;
	}

	public void setDonGiaThanhToan(Long donGiaThanhToan) {
		DonGiaThanhToan = donGiaThanhToan;
	}

	@Column(name = "TienHoaDon")
	public Long getTienHoaDon() {
		return TienHoaDon;
	}

	public void setTienHoaDon(Long tienHoaDon) {
		TienHoaDon = tienHoaDon;
	}

	@Column(name = "TienThanhToan")
	public Long getTienThanhToan() {
		return TienThanhToan;
	}

	public void setTienThanhToan(Long tienThanhToan) {
		TienThanhToan = tienThanhToan;
	}

	@Column(name = "DonGiaHoaDonBom")
	public Long getDonGiaHoaDonBom() {
		return DonGiaHoaDonBom;
	}

	public void setDonGiaHoaDonBom(Long donGiaHoaDonBom) {
		DonGiaHoaDonBom = donGiaHoaDonBom;
	}

	@Column(name = "DonGiaThanhToanBom")
	public Long getDonGiaThanhToanBom() {
		return DonGiaThanhToanBom;
	}

	public void setDonGiaThanhToanBom(Long donGiaThanhToanBom) {
		DonGiaThanhToanBom = donGiaThanhToanBom;
	}

	@Column(name = "TienHoaDonBom")
	public Long getTienHoaDonBom() {
		return TienHoaDonBom;
	}

	public void setTienHoaDonBom(Long tienHoaDonBom) {
		TienHoaDonBom = tienHoaDonBom;
	}

	@Column(name = "TienThanhToanBom")
	public Long getTienThanhToanBom() {
		return TienThanhToanBom;
	}

	public void setTienThanhToanBom(Long tienThanhToanBom) {
		TienThanhToanBom = tienThanhToanBom;
	}

	@Column(name = "KLKhachHang")
	public Double getKLKhachHang() {
		return KLKhachHang;
	}

	public void setKLKhachHang(Double kLKhachHang) {
		KLKhachHang = kLKhachHang;
	}

	@Column(name = "KLThucXuat")
	public Double getKLThucXuat() {
		return KLThucXuat;
	}

	public void setKLThucXuat(Double kLThucXuat) {
		KLThucXuat = kLThucXuat;
	}

	@Column(name = "KLQuaCan")
	public Double getKLQuaCan() {
		return KLQuaCan;
	}

	public void setKLQuaCan(Double kLQuaCan) {
		KLQuaCan = kLQuaCan;
	}

	@Column(name = "KLTramTron")
	public Double getKLTramTron() {
		return KLTramTron;
	}

	public void setKLTramTron(Double kLTramTron) {
		KLTramTron = kLTramTron;
	}

	@Column(name = "KLXiMang")
	public Double getKLXiMang() {
		return KLXiMang;
	}

	public void setKLXiMang(Double kLXiMang) {
		KLXiMang = kLXiMang;
	}

	@Column(name = "KLDa")
	public Double getKLDa() {
		return KLDa;
	}

	public void setKLDa(Double kLDa) {
		KLDa = kLDa;
	}

	@Column(name = "KLCat")
	public Double getKLCat() {
		return KLCat;
	}

	public void setKLCat(Double kLCat) {
		KLCat = kLCat;
	}

	@Column(name = "KLPhuGia")
	public Double getKLPhuGia() {
		return KLPhuGia;
	}

	public void setKLPhuGia(Double kLPhuGia) {
		KLPhuGia = kLPhuGia;
	}

	@Column(name = "KLTroBay")
	public Double getKLTroBay() {
		return KLTroBay;
	}

	public void setKLTroBay(Double kLTroBay) {
		KLTroBay = kLTroBay;
	}

	@Column(name = "DMXiMang")
	public Double getDMXiMang() {
		return DMXiMang;
	}

	public void setDMXiMang(Double dMXiMang) {
		DMXiMang = dMXiMang;
	}

	@Column(name = "DMDa")
	public Double getDMDa() {
		return DMDa;
	}

	public void setDMDa(Double dMDa) {
		DMDa = dMDa;
	}

	@Column(name = "DMCat")
	public Double getDMCat() {
		return DMCat;
	}

	public void setDMCat(Double dMCat) {
		DMCat = dMCat;
	}

	@Column(name = "DMPhuGia")
	public Double getDMPhuGia() {
		return DMPhuGia;
	}

	public void setDMPhuGia(Double dMPhuGia) {
		DMPhuGia = dMPhuGia;
	}

	@Column(name = "DMTroBay")
	public Double getDMTroBay() {
		return DMTroBay;
	}

	public void setDMTroBay(Double dMTroBay) {
		DMTroBay = dMTroBay;
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

	@Column(name = "TrangThaiChot")
	public Integer getTrangThaiChot() {
		return TrangThaiChot;
	}

	public void setTrangThaiChot(Integer trangThaiChot) {
		TrangThaiChot = trangThaiChot;
	}

	@Column(name = "NguoiChot")
	public String getNguoiChot() {
		return NguoiChot;
	}

	public void setNguoiChot(String nguoiChot) {
		NguoiChot = nguoiChot;
	}

	@Column(name = "NguoiDuyetChot")
	public String getNguoiDuyetChot() {
		return NguoiDuyetChot;
	}

	public void setNguoiDuyetChot(String nguoiDuyetChot) {
		NguoiDuyetChot = nguoiDuyetChot;
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
		return "TblXuatBeTong [ID=" + ID + ", IDChung=" + IDChung + ", GioXuat=" + GioXuat + ", NgayThang=" + NgayThang
				+ ", IDChiNhanh=" + IDChiNhanh + ", IDNhaCungCap=" + IDNhaCungCap + ", IDCongTrinh=" + IDCongTrinh
				+ ", MacBeTong=" + MacBeTong + ", LoaiDa=" + LoaiDa + ", DoSut=" + DoSut + ", YCDB=" + YCDB
				+ ", XiMang=" + XiMang + ", Cat=" + Cat + ", PhuGia=" + PhuGia + ", TroBay=" + TroBay + ", HinhThucBom="
				+ HinhThucBom + ", IDHopDong=" + IDHopDong + ", IDHopDongBom=" + IDHopDongBom + ", IDLich=" + IDLich
				+ ", IDXeBom=" + IDXeBom + ", IDXeTron=" + IDXeTron + ", TenXeBom=" + TenXeBom + ", TenXeTron="
				+ TenXeTron + ", DonGiaHoaDon=" + DonGiaHoaDon + ", DonGiaThanhToan=" + DonGiaThanhToan
				+ ", TienHoaDon=" + TienHoaDon + ", TienThanhToan=" + TienThanhToan + ", DonGiaHoaDonBom="
				+ DonGiaHoaDonBom + ", DonGiaThanhToanBom=" + DonGiaThanhToanBom + ", TienHoaDonBom=" + TienHoaDonBom
				+ ", TienThanhToanBom=" + TienThanhToanBom + ", KLKhachHang=" + KLKhachHang + ", KLThucXuat="
				+ KLThucXuat + ", KLQuaCan=" + KLQuaCan + ", KLTramTron=" + KLTramTron + ", KLXiMang=" + KLXiMang
				+ ", KLDa=" + KLDa + ", KLCat=" + KLCat + ", KLPhuGia=" + KLPhuGia + ", KLTroBay=" + KLTroBay
				+ ", DMXiMang=" + DMXiMang + ", DMDa=" + DMDa + ", DMCat=" + DMCat + ", DMPhuGia=" + DMPhuGia
				+ ", DMTroBay=" + DMTroBay + ", TrangThai=" + TrangThai + ", TrangThaiText=" + TrangThaiText
				+ ", NguoiDuyet=" + NguoiDuyet + ", TrangThaiChot=" + TrangThaiChot + ", NguoiChot=" + NguoiChot
				+ ", NguoiDuyetChot=" + NguoiDuyetChot + ", NguoiXoa=" + NguoiXoa + ", NgayTao=" + NgayTao
				+ ", NguoiTao=" + NguoiTao + "]";
	}

}
