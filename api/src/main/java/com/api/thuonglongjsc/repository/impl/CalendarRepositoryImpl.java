package com.api.thuonglongjsc.repository.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.internal.SessionImpl;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.thuonglongjsc.MyStoredProc;
import com.api.thuonglongjsc.dto.*;
import com.api.thuonglongjsc.repository.CalendarRepository;
import com.api.thuonglongjsc.utils.Constants;
import com.api.thuonglongjsc.utils.Utils;

import java.lang.reflect.Field;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class CalendarRepositoryImpl implements CalendarRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(CalendarRepositoryImpl.class.getName());

	@Override
	@Transactional
	public ResultDTO lichXuatBeTongSave(TblLichXuatBeTong model) {
		ResultDTO res = new ResultDTO(Constants.ERROR_CODE.ERROR, "");
		try {
			String message = "";
			if (Utils.isNullOrEmptyObj(model.getNgayThang()) || Utils.isNullOrEmptyObj(model.getGioXuat())
					|| Utils.isNullOrEmptyObj(model.getIDChiNhanh()) || Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
					|| Utils.isNullOrEmptyObj(model.getIDCongTrinh()) || Utils.isNullOrEmptyObj(model.getMacBeTong())
					|| Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
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
				String checkPermission = checkPermisionAddLXBT(model);
				if (!Utils.isNullOrEmptyObj(checkPermission)) {
					res.setMessage(checkPermission);
					return res;
				}

				queryStr = "insert into TblLichXuatBeTong (\r\n" + "		ID,\r\n" + "		GioXuat,\r\n"
						+ "		NgayThang,\r\n" + "		IDChiNhanh,\r\n" + "		IDNhaCungCap,\r\n"
						+ "		IDCongTrinh,\r\n" + "		MacBeTong,\r\n" + "		IDHopDong,\r\n"
						+ "		HangMuc,\r\n" + "		HinhThucBom,\r\n" + "		IDHopDongBom,\r\n"
						+ "		KLThucXuat,\r\n" + "		KLKhachHang,\r\n" + "		CuLyVanChuyen,\r\n"
						+ "		TrangThai,\r\n" + "		TrangThaiText,\r\n" + "		NguoiDuyet,\r\n"
						+ "		NguoiXoa,\r\n" + "		NgayTao,\r\n" + "		NguoiTao,\r\n" + "		MoTa,\r\n"
						+ "		TrangThaiHoanThanh,\r\n" + "		KLDaXuat,\r\n" + "		KLDaBan,\r\n"
						+ "		IDNVKD,\r\n" + "		IDChiTietKinhDoanh,\r\n" + "		KyThuat,\r\n"
						+ "		NguoiThuTien) \r\n" + " VALUES ( \r\n" + "		CONVERT(uniqueidentifier,newID()),\r\n"
						+ "		?,\r\n" + "		convert(datetime,?,103), \n"
						+ "		CONVERT(uniqueidentifier, ? ), \r\n" + "		CONVERT(uniqueidentifier, ? ), \r\n"
						+ "		CONVERT(uniqueidentifier, ? ), \r\n" + "		CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		CONVERT(uniqueidentifier,newID()),\r\n" + "		?,\r\n"
						+ "		CONVERT(uniqueidentifier, ? ),\r\n" + "		CONVERT(uniqueidentifier,newID()),\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		GETDATE(),\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		CONVERT(uniqueidentifier,newID()),\r\n" + "		?,\r\n" + "		?) ";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getNgayThang());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getMacBeTong());
//				lstParams.add(model.getIDHopDong());
				lstParams.add(model.getHangMuc());
				lstParams.add(model.getHinhThucBom());
//				lstParams.add(model.getIDHopDongBom());
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
//				lstParams.add(model.getIDChiTietKinhDoanh());
				lstParams.add(model.getKyThuat());
				lstParams.add(model.getNguoiThuTien());
			} else {
				String checkPermission = checkPermisionEditLXBT(model);
				if (!Utils.isNullOrEmptyObj(checkPermission)) {
					res.setMessage(checkPermission);
					return res;
				}

				queryStr = " UPDATE tblLichXuatBeTong SET\r\n" + "		GioXuat = ?,\r\n"
						+ "		NgayThang = convert(datetime,?,103),\r\n"
						+ "		IDChiNhanh = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		IDNhaCungCap = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		IDCongTrinh = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		MacBeTong = CONVERT(uniqueidentifier, ? ),\r\n"
//						+ "		IDHopDong = CONVERT(uniqueidentifier, ? ),\r\n" 
						+ "		HangMuc = ?,\r\n" + "		HinhThucBom = CONVERT(uniqueidentifier, ? ),\r\n"
//						+ "		IDHopDongBom = ?,\r\n" 
						+ "		KLThucXuat = ?,\r\n" + "		KLKhachHang = ?,\r\n" + "		CuLyVanChuyen = ?,\r\n"
						+ "		TrangThai = ?,\r\n" + "		TrangThaiText = ?,\r\n" + "		MoTa = ?,\r\n"
						+ "		KLDaXuat = ?,\r\n" + "		KLDaBan = ?,\r\n"
						+ "		IDNVKD = CONVERT(uniqueidentifier, ? ),\r\n" + "		KyThuat = ?,\r\n"
						+ "		NguoiThuTien = ? \r\n" + " where ID = CONVERT(uniqueidentifier, ? ) ";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getNgayThang());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getMacBeTong());
//				lstParams.add(model.getIDHopDong());
				lstParams.add(model.getHangMuc());
				lstParams.add(model.getHinhThucBom());
//				lstParams.add(model.getIDHopDongBom());
				lstParams.add(model.getKLThucXuat());
				lstParams.add(model.getKLKhachHang());
				lstParams.add(model.getCuLyVanChuyen());
				lstParams.add(model.getTrangThai());
				lstParams.add(model.getTrangThaiText());
				lstParams.add(model.getMoTa());
				lstParams.add(model.getKLDaXuat());
				lstParams.add(model.getKLDaBan());
				lstParams.add(model.getIDNVKD());
//				lstParams.add(model.getIDChiTietKinhDoanh());
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

	/**
	 * {"id":"","cuLyVanChuyen":"10","gioXuat":"09:00","idchiNhanh":"0A70374D-C820-406E-AB11-F13CDE69D22B","idchiTietKinhDoanh":"","idcongTrinh":"8FEB04FC-370A-4C83-91E5-7245CCB2590F","idhopDong":1595353854237,"idloaiVatLieu":"372F25D5-5D9D-4339-A44A-EC966493B95B","idnhaCungCap":"DB31C043-14CD-44E4-99D2-57B6EE767E32","idnhomVatLieu":"97CF73BB-E552-4A07-9F8B-5DD5C68F7287","idnvkd":"93E83567-8AB2-4FAC-A4A8-0E000D1A5DDA","kldaBan":0,"kldaXuat":0,"klkhachHang":"10","klthucXuat":"10","moTa":"","ngayThang":"22/07/2020","nguoiTao":"viethau89nd","nguoiThuTien":"test","trangThai":"1","trangThaiHoanThanh":"Chưa
	 * hoàn thành","trangThaiText":"Chờ duyệt"} 07-22 00:50:55.425 6939 7083 I
	 * ReactNativeJS: { timestamp: '2020-07-21T17:50:48.585+0000', 07-22
	 * 00:50:55.425 6939 7083 I ReactNativeJS: message: 'Transaction silently rolled
	 * back because it has been marked as rollback-only',
	 */
	@Override
	@Transactional
	public ResultDTO lichBanGachSave(TblLichBanGach model) {
		// TODO Auto-generated method stub
		ResultDTO res = new ResultDTO(Constants.ERROR_CODE.ERROR, "");
		try {
			String message = "";
			if (Utils.isNullOrEmptyObj(model.getNgayThang()) || Utils.isNullOrEmptyObj(model.getGioXuat())
					|| Utils.isNullOrEmptyObj(model.getIDChiNhanh()) || Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
					|| Utils.isNullOrEmptyObj(model.getIDCongTrinh())
					|| Utils.isNullOrEmptyObj(model.getIDNhomVatLieu())
					|| Utils.isNullOrEmptyObj(model.getIDNhaCungCap())
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

				queryStr = "insert into TblLichBanGach (\r\n" + "		ID,\r\n" + "		GioXuat,\r\n"
						+ "		NgayThang,\r\n" + "		IDChiNhanh,\r\n" + "		IDNhaCungCap,\r\n"
						+ "		IDCongTrinh,\r\n" + "		IDNhomVatLieu,\r\n" + "		IDLoaiVatLieu,\r\n"
						+ "		IDDonViTinh,\r\n" + "		IDHopDong,\r\n" + "		HangMuc,\r\n"
						+ "		KLThucXuat,\r\n" + "		KLKhachHang,\r\n" + "		CuLyVanChuyen,\r\n"
						+ "		TrangThai,\r\n" + "		TrangThaiText,\r\n" + "		NguoiDuyet,\r\n"
						+ "		NguoiXoa,\r\n" + "		NgayTao,\r\n" + "		NguoiTao,\r\n" + "		MoTa,\r\n"
						+ "		TrangThaiHoanThanh,\r\n" + "		KLDaXuat,\r\n" + "		KLDaBan,\r\n"
						+ "		IDNVKD,\r\n" + "		IDChiTietKinhDoanh,\r\n" + "		NguoiThuTien\r\n"
						+ ") VALUES (\r\n" + "		newID(),\r\n" + "		?,\r\n"
						+ "		convert(datetime,?,103),--dd/mm/yyyy\r\n" + "		CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		CONVERT(uniqueidentifier, ? ),\r\n" + "		CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		CONVERT(uniqueidentifier, ? ),\r\n" + "		CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		CONVERT(uniqueidentifier, ? ),\r\n" + "		newID(),\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		GETDATE(),\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		0,\r\n" + "		0,\r\n" + "		CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		newID(),\r\n" + "		?\r\n" + ")";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getNgayThang());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getIDNhomVatLieu());
				lstParams.add(model.getIDLoaiVatLieu());
				lstParams.add(model.getIDDonViTinh());
//				lstParams.add(model.getIDHopDong());
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
//				lstParams.add(model.getKLDaXuat());
//				lstParams.add(model.getKLDaBan());
				lstParams.add(model.getIDNVKD());
//				lstParams.add(model.getIDChiTietKinhDoanh());
				lstParams.add(model.getNguoiThuTien());
			} else {
				String checkPermission = checkPermisionEditLichBanGach(model);
				if (!Utils.isNullOrEmptyObj(checkPermission)) {
					res.setMessage(checkPermission);
					return res;
				}

				queryStr = " UPDATE tblLichBanGach SET\r\n" + "		GioXuat = ?,\r\n"
						+ "		NgayThang = convert(datetime,?,103),\r\n"
						+ "		IDChiNhanh = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		IDNhaCungCap = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		IDCongTrinh = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		IDNhomVatLieu = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		IDLoaiVatLieu = CONVERT(uniqueidentifier, ? ),\r\n"
						+ "		IDDonViTinh = CONVERT(uniqueidentifier, ? ),\r\n" +
//						"		IDHopDong = CONVERT(uniqueidentifier, ? ),\r\n" + 
						"		HangMuc = ?,\r\n" + "		KLThucXuat = ?,\r\n" + "		KLKhachHang = ?,\r\n"
						+ "		CuLyVanChuyen = ?,\r\n" + "		TrangThai = ?,\r\n" + "		TrangThaiText = ?,\r\n" +
//						"		MoTa = ?,\r\n" + 
//						"		KLDaXuat = ?,\r\n" + 
//						"		KLDaBan = ?,\r\n" + 
						"		IDNVKD = CONVERT(uniqueidentifier, ? ),\r\n" +
//						"		IDChiTietKinhDoanh = ?,\r\n" + 
						"		NguoiThuTien = ?\r\n" + "where ID = CONVERT(uniqueidentifier, ? ) ";

				lstParams.add(model.getGioXuat());
				lstParams.add(model.getNgayThang());
				lstParams.add(model.getIDChiNhanh());
				lstParams.add(model.getIDNhaCungCap());
				lstParams.add(model.getIDCongTrinh());
				lstParams.add(model.getIDNhomVatLieu());
				lstParams.add(model.getIDLoaiVatLieu());
				lstParams.add(model.getIDDonViTinh());
//				lstParams.add(model.getIDHopDong());
				lstParams.add(model.getHangMuc());
				lstParams.add(model.getKLThucXuat());
				lstParams.add(model.getKLKhachHang());
				lstParams.add(model.getCuLyVanChuyen());
				lstParams.add(model.getTrangThai());
				lstParams.add(model.getTrangThaiText());
//				lstParams.add(model.getMoTa());
//				lstParams.add(model.getKLDaXuat());
//				lstParams.add(model.getKLDaBan());
				lstParams.add(model.getIDNVKD());
//				lstParams.add(model.getIDChiTietKinhDoanh());
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

//	{"cuLyVanChuyen":"10","gioXuat":"09:00","idchiNhanh":"0A70374D-C820-406E-AB11-F13CDE69D22B","idchiTietKinhDoanh":"","idcongTrinh":"C34D15FC-142F-4F71-A530-760DD7BBC4A3","idhopDong":1594836004121,"idhopDongBom":1594836004121,"idnhaCungCap":"E6B8C11A-765C-4A44-99C9-B56604CC63D9","idnvkd":"93E83567-8AB2-4FAC-A4A8-0E000D1A5DDA","kldaBan":"10","kldaXuat":"10","klkhachHang":"10","klthucXuat":"10","kyThuat":"123","macBeTong":"B4B9E95F-1A66-4B56-BBF1-54D7B07E188F","ngayThang":"16/07/2020","nguoiTao":"viethau89nd","nguoiThuTien":"abc","trangThai":"1","trangThaiHoanThanh":"Chưa hoàn thành","trangThaiText":"Chờ duyệt"}
	public String checkPermisionAddLXBT(TblLichXuatBeTong entity) {
		String res = "";
		String queryStr = "SELECT COUNT(IDCongTrinh) \r\n" + "        FROM tblLichXuatBeTong\r\n"
				+ "        WHERE IDCongTrinh = ? \r\n" + "              AND IDChiNhanh = ? \r\n"
				+ "              AND MacBeTong = ? \r\n" + "              AND HinhThucBom = ? \r\n"
				+ "              AND CONVERT(DATETIME, CONVERT(DATE, NgayThang)) = convert(date, ? , 103) \r\n"
				+ "              AND HangMuc = ? ";

		List<String> lstParams = new ArrayList<>();
		lstParams.add(entity.getIDCongTrinh());
		lstParams.add(entity.getIDChiNhanh());
		lstParams.add(entity.getMacBeTong());
		lstParams.add(entity.getHinhThucBom());
		lstParams.add(entity.getNgayThang());
		lstParams.add(entity.getHangMuc());

		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			Integer count = (Integer) query.getSingleResult();
//			unwrap(org.hibernate.query.Query.class)
//					.setResultTransformer(Transformers.aliasToBean(String.class)).getResultList();

			if (count > 0) {
				return "Không được thiết lập 2 lịch bán bê tông giống nhau trong cùng 1 ngày.";
			}

			// check gia ban be tong
			queryStr = "SELECT TrangThai = b.TrangThai, \r\n" + "                       IDHopDong = b.ID\r\n"
					+ "                FROM tblHopDongBanBeTong AS a\r\n"
					+ "                     JOIN tblHopDongBanBeTong_ChiTiet AS b ON a.ID = b.IDHD\r\n"
					+ "                WHERE IDChiNhanh = ? \r\n" + "                      AND a.ID = ? \r\n"
					+ "                      AND b.MacBeTong = ? \r\n"
					+ "                      AND convert(date, ? , 103) BETWEEN TuNgay AND ISNULL(DenNgay, '6/6/2079') ";

			lstParams = new ArrayList<>();
			lstParams.add(entity.getIDChiNhanh());
			lstParams.add(entity.getIDCongTrinh());
			lstParams.add(entity.getMacBeTong());
			lstParams.add(entity.getNgayThang());

			Query queryGiaBan = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				queryGiaBan.setParameter(i + 1, lstParams.get(i));
			}
			List<LichXuatBeTongDuyet> resGiaBanBeTong = queryGiaBan.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(LichXuatBeTongDuyet.class)).getResultList();
			if (resGiaBanBeTong != null && resGiaBanBeTong.size() > 0) {
				LichXuatBeTongDuyet duyet = resGiaBanBeTong.get(0);
				if (duyet.getTrangThai() == null) {
					return "Thời gian này bạn chưa thiết lập giá bán bê tông cho thông tin vừa chọn";
				}
				if (duyet.getTrangThai() != 2) {
					return "Thông tin giá bán bê tông đang chờ duyệt";
				}
			}

			// check hinh thuc bom
			if (entity.getHinhThucBom() != "2862C6F2-0AE1-499B-93B7-6E2B0AB46B83") {
				queryStr = "SELECT TrangThai = b.TrangThai, \r\n" + "                       IDHopDong = b.ID\r\n"
						+ "                FROM tblHopDongBanBeTong_Bom AS b\r\n"
						+ "                WHERE b.IDHD = ? \r\n" + "                      AND b.HinhThucBom = ? \r\n"
						+ "                      AND convert(date, ? , 103) BETWEEN TuNgay AND ISNULL(DenNgay, '6/6/2079') ";

				lstParams = new ArrayList<>();

				lstParams.add(entity.getIDCongTrinh());
				lstParams.add(entity.getHinhThucBom());
				lstParams.add(entity.getNgayThang());

				Query queryCheckHinhThucBom = entityManager.createNativeQuery(queryStr);
				for (int i = 0; i < lstParams.size(); i++) {
					queryCheckHinhThucBom.setParameter(i + 1, lstParams.get(i));
				}
				List<LichXuatBeTongDuyet> resHinhThucBom = queryCheckHinhThucBom.unwrap(org.hibernate.query.Query.class)
						.setResultTransformer(Transformers.aliasToBean(LichXuatBeTongDuyet.class)).getResultList();
				if (resHinhThucBom != null && resHinhThucBom.size() > 0) {
					LichXuatBeTongDuyet duyet = resHinhThucBom.get(0);
					if (duyet.getTrangThai() == null) {
						return "Thời gian này bạn chưa thiết lập giá thuê bơm bê tông cho thông tin vừa chọn";
					}
					if (duyet.getTrangThai() != 2) {
						return "Thông tin giá thuê bơm bê tông đang chờ duyệt";
					}
				}
			}

			// check nhan vien kinh doanh
			queryStr = "SELECT TrangThai = b.TrangThai, \r\n" + "                       IDHopDong = b.ID\r\n"
					+ "                FROM tblHopDongBanBeTong AS a\r\n"
					+ "                     JOIN tblHopDongBanBeTong_NVKD AS b ON a.ID = b.IDHD\r\n"
					+ "                WHERE IDChiNhanh = ? \r\n" + "                      AND a.ID = ? \r\n"
					+ "                      AND b.IDNhanVien = ?\r\n"
					+ "                      AND convert(date, ? , 103) BETWEEN TuNgay AND ISNULL(DenNgay, '6/6/2079') ";

			lstParams = new ArrayList<>();
			lstParams.add(entity.getIDChiNhanh());
			lstParams.add(entity.getIDCongTrinh());
			lstParams.add(entity.getIDNVKD());
			lstParams.add(entity.getNgayThang());

			Query queryCheckNVKD = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				queryGiaBan.setParameter(i + 1, lstParams.get(i));
			}
			List<LichXuatBeTongDuyet> resCheckNVKD = queryGiaBan.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(LichXuatBeTongDuyet.class)).getResultList();
			if (resGiaBanBeTong != null && resGiaBanBeTong.size() > 0) {
				LichXuatBeTongDuyet duyet = resGiaBanBeTong.get(0);
				if (duyet.getTrangThai() == null) {
					return "Thời gian này bạn chưa thiết lập nhân viên kinh doanh cho thông tin vừa chọn";
				}
				if (duyet.getTrangThai() != 2) {
					return "Thông tin nhân viên kinh doanh đang chờ duyệt";
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}

	public String checkPermisionEditLXBT(TblLichXuatBeTong entity) {
		String res = "";
		try {
			StoredProcedureQuery storedProcedure = entityManager
					.createStoredProcedureQuery("dbo.sp_GiaBanVatLieu_ListDuyet");
			// set parameters
			storedProcedure.registerStoredProcedureParameter("ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("NgayThang", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDChiNhanh", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDCongTrinh", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("HangMuc", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDNVKD", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("MacBeTong", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("HinhThucBom", String.class, ParameterMode.IN);
			
			storedProcedure.registerStoredProcedureParameter("IDHopDong", String.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("IDHopDongBom", String.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("IDChiTietKinhDoanh", String.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("Error", String.class, ParameterMode.OUT);
			
			storedProcedure.setParameter("ID", entity.getID());
			storedProcedure.setParameter("NgayThang", entity.getNgayThang());
			storedProcedure.setParameter("IDChiNhanh", entity.getIDChiNhanh());
			storedProcedure.setParameter("IDCongTrinh", entity.getIDCongTrinh());
			storedProcedure.setParameter("HangMuc", entity.getHangMuc());
			storedProcedure.setParameter("IDNVKD", entity.getIDNVKD());
			storedProcedure.setParameter("MacBeTong", entity.getMacBeTong());
			storedProcedure.setParameter("HinhThucBom", entity.getHinhThucBom());
			storedProcedure.execute(); // res = storedProcedure.getResultList();

			Object obj = storedProcedure.getOutputParameterValue("Error");
			// Load all fields in the class (private included)
			//List<Object[]> lst = storedProcedure.getResultList();


			// System.out.println(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return res;
	}
	
	@Transactional
	public String checkPermisionEditLichBanGach(TblLichBanGach entity) {
		String res = "";
		try {
			/*
			SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
			StoredProcedureQuery storedProcedure = entityManager
					.createStoredProcedureQuery("dbo.sp_LichBanGach_CheckSua");
			// set parameters
			storedProcedure.registerStoredProcedureParameter("ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("NgayThang", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDChiNhanh", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDCongTrinh", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("HangMuc", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDNVKD", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDLoaiVatLieu", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("IDDonViTinh", String.class, ParameterMode.IN);
			
			storedProcedure.registerStoredProcedureParameter("IDHopDong", String.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("IDHopDongBom", String.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("IDChiTietKinhDoanh", String.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("Error", String.class, ParameterMode.OUT);
			
			storedProcedure.setParameter("ID", entity.getID());
			storedProcedure.setParameter("NgayThang", sp.parse(entity.getNgayThang()));
			storedProcedure.setParameter("IDChiNhanh", entity.getIDChiNhanh());
			storedProcedure.setParameter("IDCongTrinh", entity.getIDCongTrinh());
			storedProcedure.setParameter("HangMuc", entity.getHangMuc());
			storedProcedure.setParameter("IDNVKD", entity.getIDNVKD());
			storedProcedure.setParameter("IDLoaiVatLieu", entity.getIDLoaiVatLieu());
			storedProcedure.setParameter("IDDonViTinh", entity.getIDDonViTinh());
			boolean queryResult = storedProcedure.execute(); // res = storedProcedure.getResultList();
			
			//Object temp = storedProcedure.getOutputParameterValue("@return_value");
			Object obj = storedProcedure.getOutputParameterValue("Error");
			// Load all fields in the class (private included)
			//List<Object[]> lst = storedProcedure.getResultList();
			
 
			{
	"id": "39075479-7ACA-4039-AA1B-72920CDB5604",
	"cuLyVanChuyen": "10",
	"gioXuat": "09:00:00",
	"hangMuc": "test",
	"idchiNhanh": "0A70374D-C820-406E-AB11-F13CDE69D22B",
	"idchiTietKinhDoanh": "",
	"idcongTrinh": "2E5F3B72-B60C-46B2-89FA-4BE5857F6D87",
	"iddonViTinh": "56226266-0CD8-496D-B28C-9CABB1AC0F30",
	"idhopDong": 1595671495047,
	"idloaiVatLieu": "E124BBF4-127E-42E6-9EF7-CAB62443D8C1",
	"idnhaCungCap": "577B63D3-FDA1-4CB5-9CB3-D32466BAE308",
	"nhomVatLieu": "97CF73BB-E552-4A07-9F8B-5DD5C68F7287",
	"kldaBan": 0,
	"kldaXuat": 0,
	"klkhachHang": "10",
	"klthucXuat": "10",
	"moTa": "",
	"ngayThang": "25/07/2020",
	"nguoiTao": "viethau89nd",
	"nguoiThuTien": "test",
	"trangThai": "1",
	"trangThaiHoanThanh": "Chưa hoàn thành",
	"trangThaiText": "Chờ duyệt",
"idnhomVatLieu" : "123123"
}
			try {
		            MyStoredProc storedProc = new MyStoredProc(entity);
		            entityManager.unwrap(Session.class).doWork(storedProc);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			

			 Session session = entityManager.unwrap(Session.class);
			 session.doWork(new Work() {
			     
				    @Override
				    public void execute(Connection con)  {
				        // do something useful
				    	
				    	try (CallableStatement stmt = 
								con.prepareCall("{CALL dbo.sp_LichBanGach_CheckSua(?1, ?2, ?3,  ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)}")) {
				              stmt.setString(1, entity.getID());
				              SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
				              java.sql.Date date = new java.sql.Date(sp.parse(entity.getNgayThang()).getTime());
				              stmt.setDate(2, date) ;
				              stmt.setString(3, entity.getIDChiNhanh());
				              stmt.setString(4, entity.getIDCongTrinh());
				              stmt.setString(5, entity.getHangMuc());
				              stmt.setString(6, entity.getIDNVKD());
				              stmt.setString(7, entity.getIDLoaiVatLieu());
				              stmt.setString(8, entity.getIDDonViTinh());
				              stmt.registerOutParameter(9, Types.NVARCHAR);
				              stmt.registerOutParameter(10, Types.NVARCHAR);
				              stmt.registerOutParameter(11, Types.NVARCHAR);
				              stmt.registerOutParameter(12, Types.NVARCHAR);
				              stmt.executeUpdate();
				              String mensagem = stmt.getString(9);
				              String geroubrinde = stmt.getString(10);
				              String tea = stmt.getString(11);
				              String te = stmt.getString(12);
				              if (stmt.wasNull()) {
				                  geroubrinde = null;
				                  mensagem = null;
				              }
				          } catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						 System.out.println(obj.toString());

					
				    }
				});
			 
			Connection con = ((SessionImpl) entityManager.unwrap(Session.class)).connection();
			try (CallableStatement stmt = 
					con.prepareCall("{CALL dbo.sp_LichBanGach_CheckSua(?1, ?2, ?3,  ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)}")) {
	              stmt.setString(1, entity.getID());
	              stmt.setDate(2, (java.sql.Date) sp.parse(entity.getNgayThang()));
	              stmt.setString(3, entity.getIDChiNhanh());
	              stmt.setString(4, entity.getIDCongTrinh());
	              stmt.setString(5, entity.getHangMuc());
	              stmt.setString(6, entity.getIDNVKD());
	              stmt.setString(7, entity.getIDLoaiVatLieu());
	              stmt.setString(8, entity.getIDDonViTinh());
	              stmt.registerOutParameter(9, Types.NVARCHAR);
	              stmt.registerOutParameter(10, Types.NVARCHAR);
	              stmt.registerOutParameter(11, Types.NVARCHAR);
	              stmt.registerOutParameter(12, Types.NVARCHAR);
	              stmt.executeUpdate();
	              String mensagem = stmt.getString(9);
	              String geroubrinde = stmt.getString(10);
	              String tea = stmt.getString(11);
	              String te = stmt.getString(12);
	              if (stmt.wasNull()) {
	                  geroubrinde = null;
	                  mensagem = null;
	              }
	          }
			
			 System.out.println(obj.toString());
			 */

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return res;
	}
}
