package com.api.thuonglongjsc.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Entity;

public class ChartDataDaily {
	private BigDecimal TongThu;
	private BigDecimal TongChi;
	private BigDecimal CongNoThu;
	private BigDecimal CongNoTra;
	private Double KLBeTongBan;
	private Double KLBeTongDuKien;
	private Double KLBeTongDaTron;

	public ChartDataDaily() {
		super();
	}



	public ChartDataDaily(BigDecimal tongThu, BigDecimal tongChi, BigDecimal congNoThu, BigDecimal congNoTra,
			Double kLBeTongBan, Double kLBeTongDuKien, Double kLBeTongDaTron) {
		super();
		TongThu = tongThu;
		TongChi = tongChi;
		CongNoThu = congNoThu;
		CongNoTra = congNoTra;
		KLBeTongBan = kLBeTongBan;
		KLBeTongDuKien = kLBeTongDuKien;
		KLBeTongDaTron = kLBeTongDaTron;
	}



	public BigDecimal getTongThu() {
		return TongThu;
	}

	public void setTongThu(BigDecimal tongThu) {
		TongThu = tongThu;
	}

	public BigDecimal getTongChi() {
		return TongChi;
	}

	public void setTongChi(BigDecimal tongChi) {
		TongChi = tongChi;
	}

	public BigDecimal getCongNoThu() {
		return CongNoThu;
	}

	public void setCongNoThu(BigDecimal congNoThu) {
		CongNoThu = congNoThu;
	}

	public BigDecimal getCongNoTra() {
		return CongNoTra;
	}

	public void setCongNoTra(BigDecimal congNoTra) {
		CongNoTra = congNoTra;
	}

	public Double getKLBeTongBan() {
		return KLBeTongBan;
	}

	public void setKLBeTongBan(Double kLBeTongBan) {
		KLBeTongBan = kLBeTongBan;
	}

	public Double getKLBeTongDuKien() {
		return KLBeTongDuKien;
	}

	public void setKLBeTongDuKien(Double kLBeTongDuKien) {
		KLBeTongDuKien = kLBeTongDuKien;
	}
	

	public Double getKLBeTongDaTron() {
		return KLBeTongDaTron;
	}



	public void setKLBeTongDaTron(Double kLBeTongDaTron) {
		KLBeTongDaTron = kLBeTongDaTron;
	}



	@Override
	public String toString() {
		return "ChartDataDaily [TongThu=" + TongThu + ", TongChi=" + TongChi + ", CongNoThu=" + CongNoThu
				+ ", CongNoTra=" + CongNoTra + ", KLBeTongBan=" + KLBeTongBan + ", KLBeTongDuKien=" + KLBeTongDuKien
				+ ", KLBeTongDaTron=" + KLBeTongDaTron + "]";
	}

}
