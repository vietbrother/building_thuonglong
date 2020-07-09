package com.api.thuonglongjsc.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.thuonglongjsc.dto.CategoryDTO;
import com.api.thuonglongjsc.dto.CategorySearch;
import com.api.thuonglongjsc.dto.ChartData;
import com.api.thuonglongjsc.dto.ChartDataBricksDaily;
import com.api.thuonglongjsc.dto.ChartDataDaily;
import com.api.thuonglongjsc.dto.ChartDataDetail;
import com.api.thuonglongjsc.dto.ChartSearch;
import com.api.thuonglongjsc.dto.GiaBanVatLieu;
import com.api.thuonglongjsc.dto.GiaBanVatLieuSearch;
import com.api.thuonglongjsc.dto.HopDongBeTong;
import com.api.thuonglongjsc.dto.HopDongBeTongSearch;
import com.api.thuonglongjsc.dto.LichBanGach;
import com.api.thuonglongjsc.dto.LichXuatBeTong;
import com.api.thuonglongjsc.dto.LichXuatBeTongSearch;
import com.api.thuonglongjsc.dto.ResultDTO;
import com.api.thuonglongjsc.model.TblChiNhanh;
import com.api.thuonglongjsc.dto.TblLichBanGach;
import com.api.thuonglongjsc.dto.TblLichXuatBeTong;
import com.api.thuonglongjsc.model.TblUserAccount;
import com.api.thuonglongjsc.repository.CalendarRepository;
import com.api.thuonglongjsc.repository.CategoryRepository;
import com.api.thuonglongjsc.repository.StatisticRepository;
import com.api.thuonglongjsc.utils.Constants;
import com.api.thuonglongjsc.utils.Utils;

import ch.qos.logback.classic.pattern.Util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service
public class CalendarRepositoryImpl implements CalendarRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(CalendarRepositoryImpl.class.getName());

	@Override
	public ResultDTO lichXuatBeTongSave(TblLichXuatBeTong model) {
		ResultDTO res = new ResultDTO(Constants.ERROR_CODE.ERROR, "");
		try {
			String message = "";
			if (Utils.isNullOrEmptyObj(model.getNgayThang()) || Utils.isNullOrEmptyObj(model.getGioXuat())
					|| Utils.isNullOrEmptyObj(model.getIDChiNhanh()) || Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
					|| Utils.isNullOrEmptyObj(model.getIDCongTrinh()) || Utils.isNullOrEmptyObj(model.getMacBeTong())
					|| Utils.isNullOrEmptyObj(model.getIDHopDong()) || Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
					|| Utils.isNullOrEmptyObj(model.getIDHopDongBom()) || Utils.isNullOrEmptyObj(model.getKLThucXuat())
					|| Utils.isNullOrEmptyObj(model.getKLKhachHang())
					|| Utils.isNullOrEmptyObj(model.getCuLyVanChuyen())
					|| Utils.isNullOrEmptyObj(model.getTrangThai())) {
				message = "Input empty";
				res.setMessage(message);
				return res;
			}

			if (Utils.isNullOrEmptyObj(model.getNguoiTao())) {
				message = "Input empty";
				res.setMessage(message);
				return res;
			}

			String queryStr = "";
			List<String> lstParams = new ArrayList<>();
			if (Utils.isNullOrEmpty(model.getID())) {
				queryStr = "insert into tblLichXuatBeTong (\r\n" + "		ID,\r\n" + "		GioXuat,\r\n"
						+ "		NgayThang,\r\n" + "		IDChiNhanh,\r\n" + "		IDNhaCungCap,\r\n"
						+ "		IDCongTrinh,\r\n" + "		MacBeTong,\r\n" + "		IDHopDong,\r\n"
						+ "		HangMuc,\r\n" + "		HinhThucBom,\r\n" + "		IDHopDongBom,\r\n"
						+ "		KLThucXuat,\r\n" + "		KLKhachHang,\r\n" + "		CuLyVanChuyen,\r\n"
						+ "		TrangThai,\r\n" + "		TrangThaiText,\r\n" + "		NguoiDuyet,\r\n"
						+ "		NguoiXoa,\r\n" + "		NgayTao,\r\n" + "		NguoiTao,\r\n" + "		MoTa,\r\n"
						+ "		TrangThaiHoanThanh,\r\n" + "		KLDaXuat,\r\n" + "		KLDaBan,\r\n"
						+ "		IDNVKD,\r\n" + "		IDChiTietKinhDoanh,\r\n" + "		KyThuat,\r\n"
						+ "		NguoiThuTien) \r\n" + " VALUES ( \r\n" + "		newID(),\r\n" + "		?,\r\n"
						+ "		convert(datetime,?,103),--dd/mm/yyyy\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		GETDATE(),\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?) ";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getNgayThang());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getMacBeTong());
				lstParams.add(model.getIDHopDong());
				lstParams.add(model.getHangMuc());
				lstParams.add(model.getHinhThucBom());
				lstParams.add(model.getIDHopDongBom());
				lstParams.add(model.getKLThucXuat());
				lstParams.add(model.getKLKhachHang());
				lstParams.add(model.getCuLyVanChuyen());
				lstParams.add(model.getTrangThai());
				lstParams.add(model.getTrangThaiText());
				lstParams.add(model.getNguoiDuyet());
				lstParams.add(model.getNguoiXoa());
				lstParams.add(model.getNguoiTao());
				lstParams.add(model.getMoTa());
				lstParams.add(model.getTrangThaiHoanThanh());
				lstParams.add(model.getKLDaXuat());
				lstParams.add(model.getKLDaBan());
				lstParams.add(model.getIDNVKD());
				lstParams.add(model.getIDChiTietKinhDoanh());
				lstParams.add(model.getKyThuat());
				lstParams.add(model.getNguoiThuTien());
			} else {
				queryStr = " UPDATE tblLichXuatBeTong SET\r\n" + "		GioXuat = ?,\r\n" + "		NgayThang = ?,\r\n"
						+ "		IDChiNhanh = ?,\r\n" + "		IDNhaCungCap = ?,\r\n" + "		IDCongTrinh = ?,\r\n"
						+ "		MacBeTong = ?,\r\n" + "		IDHopDong = ?,\r\n" + "		HangMuc = ?,\r\n"
						+ "		HinhThucBom = ?,\r\n" + "		IDHopDongBom = ?,\r\n" + "		KLThucXuat = ?,\r\n"
						+ "		KLKhachHang = ?,\r\n" + "		CuLyVanChuyen = ?,\r\n" + "		TrangThai = ?,\r\n"
						+ "		TrangThaiText = ?,\r\n" + "		MoTa = ?,\r\n" + "		KLDaXuat = ?,\r\n"
						+ "		KLDaBan = ?,\r\n" + "		IDNVKD = ?,\r\n" + "		IDChiTietKinhDoanh = ?,\r\n"
						+ "		KyThuat = ?,\r\n" + "		NguoiThuTien = ? \r\n" + " where ID = ? ";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getNgayThang());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getMacBeTong());
				lstParams.add(model.getIDHopDong());
				lstParams.add(model.getHangMuc());
				lstParams.add(model.getHinhThucBom());
				lstParams.add(model.getIDHopDongBom());
				lstParams.add(model.getKLThucXuat());
				lstParams.add(model.getKLKhachHang());
				lstParams.add(model.getCuLyVanChuyen());
				lstParams.add(model.getTrangThai());
				lstParams.add(model.getTrangThaiText());
				lstParams.add(model.getMoTa());
				lstParams.add(model.getKLDaXuat());
				lstParams.add(model.getKLDaBan());
				lstParams.add(model.getIDNVKD());
				lstParams.add(model.getIDChiTietKinhDoanh());
				lstParams.add(model.getKyThuat());
				lstParams.add(model.getNguoiThuTien());
				lstParams.add(model.getID());
			}


			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			int resUpdate = query.executeUpdate();
			logger.info("update result :  " + resUpdate);
			if (resUpdate == 1) {
				message = Constants.ERROR_CODE.SUCCESS;
				res.setCode(Constants.ERROR_CODE.SUCCESS);
			} else {
				res.setCode(String.valueOf(resUpdate));
			}

			res.setId(String.valueOf(System.currentTimeMillis()));

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	@Override
	public ResultDTO lichBanGachSave(TblLichBanGach model) {
		// TODO Auto-generated method stub
		ResultDTO res = new ResultDTO(Constants.ERROR_CODE.ERROR, "");
		try {
			String message = "";
			if (Utils.isNullOrEmptyObj(model.getNgayThang()) || Utils.isNullOrEmptyObj(model.getGioXuat())
					|| Utils.isNullOrEmptyObj(model.getIDChiNhanh()) || Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
					|| Utils.isNullOrEmptyObj(model.getIDCongTrinh()) || Utils.isNullOrEmptyObj(model.getIDNhomVatLieu())
					|| Utils.isNullOrEmptyObj(model.getIDHopDong()) || Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
					|| Utils.isNullOrEmptyObj(model.getIDLoaiVatLieu()) || Utils.isNullOrEmptyObj(model.getKLThucXuat())
					|| Utils.isNullOrEmptyObj(model.getKLKhachHang())
					|| Utils.isNullOrEmptyObj(model.getCuLyVanChuyen())
					|| Utils.isNullOrEmptyObj(model.getTrangThai())) {
				message = "Input empty";
				res.setMessage(message);
				return res;
			}

			if (Utils.isNullOrEmptyObj(model.getNguoiTao())) {
				message = "Input empty";
				res.setMessage(message);
				return res;
			}

			String queryStr = "";
			List<String> lstParams = new ArrayList<>();
			if (Utils.isNullOrEmpty(model.getID())) {
				queryStr = "insert into tblLichBanGach (\r\n" + 
						"		ID,\r\n" + 
						"		GioXuat,\r\n" + 
						"		NgayThang,\r\n" + 
						"		IDChiNhanh,\r\n" + 
						"		IDNhaCungCap,\r\n" + 
						"		IDCongTrinh,\r\n" + 
						"		IDNhomVatLieu,\r\n" + 
						"		IDLoaiVatLieu,\r\n" + 
						"		IDDonViTinh,\r\n" + 
						"		IDHopDong,\r\n" + 
						"		HangMuc,\r\n" + 
						"		KLThucXuat,\r\n" + 
						"		KLKhachHang,\r\n" + 
						"		CuLyVanChuyen,\r\n" + 
						"		TrangThai,\r\n" + 
						"		TrangThaiText,\r\n" + 
						"		NguoiDuyet,\r\n" + 
						"		NguoiXoa,\r\n" + 
						"		NgayTao,\r\n" + 
						"		NguoiTao,\r\n" + 
						"		MoTa,\r\n" + 
						"		TrangThaiHoanThanh,\r\n" + 
						"		KLDaXuat,\r\n" + 
						"		KLDaBan,\r\n" + 
						"		IDNVKD,\r\n" + 
						"		IDChiTietKinhDoanh,\r\n" + 
						"		NguoiThuTien\r\n" + 
						") VALUES (\r\n" + 
						"		newID(),\r\n" + 
						"		?,\r\n" + 
						"		convert(datetime,?,103),--dd/mm/yyyy\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		GETDATE(),\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?,\r\n" + 
						"		?\r\n" + 
						")";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getIDNhomVatLieu());
				lstParams.add(model.getIDLoaiVatLieu());
				lstParams.add(model.getIDDonViTinh());
				lstParams.add(model.getIDHopDong());
				lstParams.add(model.getHangMuc());
				lstParams.add(model.getKLThucXuat());
				lstParams.add(model.getKLKhachHang());
				lstParams.add(model.getCuLyVanChuyen());
				lstParams.add(model.getTrangThai());
				lstParams.add(model.getTrangThaiText());
				lstParams.add(model.getNguoiDuyet());
				lstParams.add(model.getNguoiXoa());
				lstParams.add(model.getNguoiTao());
				lstParams.add(model.getMoTa());
				lstParams.add(model.getTrangThaiHoanThanh());
				lstParams.add(model.getKLDaXuat());
				lstParams.add(model.getKLDaBan());
				lstParams.add(model.getIDNVKD());
				lstParams.add(model.getIDChiTietKinhDoanh());
				lstParams.add(model.getNguoiThuTien());
			} else {
				queryStr = " UPDATE tblLichBanGach SET\r\n" + 
						"		GioXuat = ?,\r\n" + 
						"		NgayThang = ?,\r\n" + 
						"		IDChiNhanh = ?,\r\n" + 
						"		IDNhaCungCap = ?,\r\n" + 
						"		IDCongTrinh = ?,\r\n" + 
						"		IDNhomVatLieu = ?,\r\n" + 
						"		IDLoaiVatLieu = ?,\r\n" + 
						"		IDDonViTinh = ?,\r\n" + 
						"		IDHopDong = ?,\r\n" + 
						"		HangMuc = ?,\r\n" + 
						"		KLThucXuat = ?,\r\n" + 
						"		KLKhachHang = ?,\r\n" + 
						"		CuLyVanChuyen = ?,\r\n" + 
						"		TrangThai = ?,\r\n" + 
						"		TrangThaiText = ?,\r\n" + 
						"		MoTa = ?,\r\n" + 
						"		KLDaXuat = ?,\r\n" + 
						"		KLDaBan = ?,\r\n" + 
						"		IDNVKD = ?,\r\n" + 
						"		IDChiTietKinhDoanh = ?,\r\n" + 
						"		NguoiThuTien = ?\r\n" + 
						"where ID = ? ";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getNgayThang());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getIDNhomVatLieu());
				lstParams.add(model.getIDLoaiVatLieu());
				lstParams.add(model.getIDDonViTinh());
				lstParams.add(model.getIDHopDong());
				lstParams.add(model.getHangMuc());
				lstParams.add(model.getKLThucXuat());
				lstParams.add(model.getKLKhachHang());
				lstParams.add(model.getCuLyVanChuyen());
				lstParams.add(model.getTrangThai());
				lstParams.add(model.getTrangThaiText());
				lstParams.add(model.getMoTa());
				lstParams.add(model.getKLDaXuat());
				lstParams.add(model.getKLDaBan());
				lstParams.add(model.getIDNVKD());
				lstParams.add(model.getIDChiTietKinhDoanh());
				lstParams.add(model.getNguoiThuTien());
				lstParams.add(model.getID());
			}


			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			int resUpdate = query.executeUpdate();
			logger.info("update result :  " + resUpdate);
			if (resUpdate == 1) {
				message = Constants.ERROR_CODE.SUCCESS;
				res.setCode(Constants.ERROR_CODE.SUCCESS);
			} else {
				res.setCode(String.valueOf(resUpdate));
			}

			res.setId(String.valueOf(System.currentTimeMillis()));

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
			res.setMessage(e.getMessage());
		}
		return res;
	}

	boolean checkPermisionAdd() {
		boolean res = false;
		
		return res;
	}
	
	boolean checkPermisionEdit() {
		boolean res = false;
		
		return res;
	}
}
