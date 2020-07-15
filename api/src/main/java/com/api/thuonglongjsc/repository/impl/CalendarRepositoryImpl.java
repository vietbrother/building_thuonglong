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

import com.api.thuonglongjsc.dto.*;
import com.api.thuonglongjsc.repository.CalendarRepository;
import com.api.thuonglongjsc.utils.Constants;
import com.api.thuonglongjsc.utils.Utils;

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
				String checkPermission = checkPermisionAddLXBT(model);
				if (!Utils.isNullOrEmptyObj(checkPermission)) {
					res.setMessage(checkPermission);
					return res;
				}
				
				queryStr = "insert into tblLichXuatBeTong (\r\n" 
						+ "		ID,\r\n" 
						+ "		GioXuat,\r\n"
						+ "		NgayThang,\r\n" 
						+ "		IDChiNhanh,\r\n" 
						+ "		IDNhaCungCap,\r\n"
						+ "		IDCongTrinh,\r\n" 
						+ "		MacBeTong,\r\n" 
						+ "		IDHopDong,\r\n"
						+ "		HangMuc,\r\n" 
						+ "		HinhThucBom,\r\n" 
						+ "		IDHopDongBom,\r\n"
						+ "		KLThucXuat,\r\n" 
						+ "		KLKhachHang,\r\n" + "		CuLyVanChuyen,\r\n"
						+ "		TrangThai,\r\n" + "		TrangThaiText,\r\n" + "		NguoiDuyet,\r\n"
						+ "		NguoiXoa,\r\n" + "		NgayTao,\r\n" + "		NguoiTao,\r\n" + "		MoTa,\r\n"
						+ "		TrangThaiHoanThanh,\r\n" + "		KLDaXuat,\r\n" + "		KLDaBan,\r\n"
						+ "		IDNVKD,\r\n" + "		IDChiTietKinhDoanh,\r\n" + "		KyThuat,\r\n"
						+ "		NguoiThuTien) \r\n" 
						+ " VALUES ( \r\n" 
						+ "		newID(),\r\n" 
						+ "		?,\r\n"
						+ "		convert(datetime,?,103),--dd/mm/yyyy\r\n" 
						+ "		?,\r\n" 
						+ "		?,\r\n"
						+ "		?,\r\n" 
						+ "		?,\r\n" 
						+ "		newID(),\r\n" 
						+ "		?,\r\n" 
						+ "		?,\r\n" 
						+ "		newID(),\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		GETDATE(),\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n"
						+ "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?,\r\n" + "		?) ";

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
				lstParams.add(model.getIDChiTietKinhDoanh());
				lstParams.add(model.getKyThuat());
				lstParams.add(model.getNguoiThuTien());
			} else {
				String checkPermission = checkPermisionEditLXBT(model);
				if (!Utils.isNullOrEmptyObj(checkPermission)) {
					res.setMessage(checkPermission);
					return res;
				}
				
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

//	{"cuLyVanChuyen":"10","gioXuat":"09:00","idchiNhanh":"0A70374D-C820-406E-AB11-F13CDE69D22B","idchiTietKinhDoanh":"","idcongTrinh":"C34D15FC-142F-4F71-A530-760DD7BBC4A3","idhopDong":1594836004121,"idhopDongBom":1594836004121,"idnhaCungCap":"E6B8C11A-765C-4A44-99C9-B56604CC63D9","idnvkd":"93E83567-8AB2-4FAC-A4A8-0E000D1A5DDA","kldaBan":"10","kldaXuat":"10","klkhachHang":"10","klthucXuat":"10","kyThuat":"123","macBeTong":"B4B9E95F-1A66-4B56-BBF1-54D7B07E188F","ngayThang":"16/07/2020","nguoiTao":"viethau89nd","nguoiThuTien":"abc","trangThai":"1","trangThaiHoanThanh":"Chưa hoàn thành","trangThaiText":"Chờ duyệt"}
	public String checkPermisionAddLXBT(TblLichXuatBeTong entity) {
		String res = "";
		String queryStr = "SELECT COUNT(IDCongTrinh) \r\n" + 
				"        FROM tblLichXuatBeTong\r\n" + 
				"        WHERE IDCongTrinh = ? \r\n" + 
				"              AND IDChiNhanh = ? \r\n" + 
				"              AND MacBeTong = ? \r\n" + 
				"              AND HinhThucBom = ? \r\n" + 
				"              AND CONVERT(DATETIME, CONVERT(DATE, NgayThang)) = convert(date, ? , 103) \r\n" + 
				"              AND HangMuc = ? ";

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
			

			if(count > 0){
				return "Không được thiết lập 2 lịch bán bê tông giống nhau trong cùng 1 ngày.";
			}
			
			//check gia ban be tong
			queryStr = "SELECT TrangThai = b.TrangThai, \r\n" + 
					"                       IDHopDong = b.ID\r\n" + 
					"                FROM tblHopDongBanBeTong AS a\r\n" + 
					"                     JOIN tblHopDongBanBeTong_ChiTiet AS b ON a.ID = b.IDHD\r\n" + 
					"                WHERE IDChiNhanh = ? \r\n" + 
					"                      AND a.ID = ? \r\n" + 
					"                      AND b.MacBeTong = ? \r\n" + 
					"                      AND convert(date, ? , 103) BETWEEN TuNgay AND ISNULL(DenNgay, '6/6/2079') ";

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
			if(resGiaBanBeTong != null && resGiaBanBeTong.size() > 0) {
				LichXuatBeTongDuyet duyet = resGiaBanBeTong.get(0);
				if(duyet.getTrangThai() == null) {
					return "Thời gian này bạn chưa thiết lập giá bán bê tông cho thông tin vừa chọn";
				}
				if(duyet.getTrangThai() != 2) {
					return "Thông tin giá bán bê tông đang chờ duyệt";
				}
			}
			
			//check hinh thuc bom
			if(entity.getHinhThucBom() != "2862C6F2-0AE1-499B-93B7-6E2B0AB46B83") {
				queryStr = "SELECT TrangThai = b.TrangThai, \r\n" + 
						"                       IDHopDong = b.ID\r\n" + 
						"                FROM tblHopDongBanBeTong_Bom AS b\r\n" + 
						"                WHERE b.IDHD = ? \r\n" + 
						"                      AND b.HinhThucBom = ? \r\n" + 
						"                      AND convert(date, ? , 103) BETWEEN TuNgay AND ISNULL(DenNgay, '6/6/2079') ";

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
				if(resHinhThucBom != null && resHinhThucBom.size() > 0) {
					LichXuatBeTongDuyet duyet = resHinhThucBom.get(0);
					if(duyet.getTrangThai() == null) {
						return "Thời gian này bạn chưa thiết lập giá thuê bơm bê tông cho thông tin vừa chọn";
					}
					if(duyet.getTrangThai() != 2) {
						return "Thông tin giá thuê bơm bê tông đang chờ duyệt";
					}
				}
			}
			
			
			//check nhan vien kinh doanh
			queryStr = "SELECT TrangThai = b.TrangThai, \r\n" + 
					"                       IDHopDong = b.ID\r\n" + 
					"                FROM tblHopDongBanBeTong AS a\r\n" + 
					"                     JOIN tblHopDongBanBeTong_NVKD AS b ON a.ID = b.IDHD\r\n" + 
					"                WHERE IDChiNhanh = ? \r\n" + 
					"                      AND a.ID = ? \r\n" + 
					"                      AND b.IDNhanVien = ?\r\n" + 
					"                      AND convert(date, ? , 103) BETWEEN TuNgay AND ISNULL(DenNgay, '6/6/2079') ";

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
			if(resGiaBanBeTong != null && resGiaBanBeTong.size() > 0) {
				LichXuatBeTongDuyet duyet = resGiaBanBeTong.get(0);
				if(duyet.getTrangThai() == null) {
					return "Thời gian này bạn chưa thiết lập nhân viên kinh doanh cho thông tin vừa chọn";
				}
				if(duyet.getTrangThai() != 2) {
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
		
		return res;
	}
}
