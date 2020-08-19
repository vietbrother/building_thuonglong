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

import com.api.thuonglongjsc.dto.BricksContract;
import com.api.thuonglongjsc.dto.BricksOrder;
import com.api.thuonglongjsc.dto.BricksSearch;
import com.api.thuonglongjsc.dto.BricksTicket;
import com.api.thuonglongjsc.dto.ChartData;
import com.api.thuonglongjsc.dto.ChartDataBricksDaily;
import com.api.thuonglongjsc.dto.ChartDataDaily;
import com.api.thuonglongjsc.dto.ChartDataDetail;
import com.api.thuonglongjsc.dto.ChartSearch;
import com.api.thuonglongjsc.dto.GiaBanVatLieu;
import com.api.thuonglongjsc.dto.GiaBanVatLieuSearch;
import com.api.thuonglongjsc.dto.HopDongBeTong;
import com.api.thuonglongjsc.dto.HopDongBeTongSearch;
import com.api.thuonglongjsc.dto.LichXuatBeTong;
import com.api.thuonglongjsc.dto.LichXuatBeTongSearch;
import com.api.thuonglongjsc.dto.ResultDTO;
import com.api.thuonglongjsc.model.TblChiNhanh;
import com.api.thuonglongjsc.model.TblUserAccount;
import com.api.thuonglongjsc.repository.BricksRepository;
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
public class BricksRepositoryImpl implements BricksRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(BricksRepositoryImpl.class.getName());

	@Override
	public List<BricksContract> getBricksContracts(BricksSearch entity) {
		// TODO Auto-generated method stub
		List<BricksContract> res = new ArrayList<>();
		String queryStr = "        SELECT a.ID, \r\n" + 
				"               a.SoHD, \r\n" + 
				"               g.TenChiNhanh, \r\n" + 
				"               a.CongTrinh, \r\n" + 
				"               b.TenNhaCungCap AS NhaCungCap, \r\n" + 
				"               d.TenNhomVatLIeu AS NhomVatLieu, \r\n" + 
				"               e.TenLoaiVatLieu AS LoaiVatLieu, \r\n" + 
				"               f.TenDonViTinh AS DonViTinh, \r\n" + 
				"               h.DonGiaCoThue, \r\n" + 
				"               h.DonGiaKhongThue, \r\n" + 
				"               h.TuNgay, \r\n" + 
				"               h.DenNgay, \r\n" + 
				"               a.TrangThaiText, \r\n" + 
				"               a.NguoiTao, \r\n" + 
				"               a.NgayTao,a.TrangThai, a.IDChiNhanh\r\n" + 
				"        FROM tblGiaBanGach AS a\r\n" + 
				"             JOIN tblGiaBanGach_ChiTiet AS h ON a.ID = h.IDHD\r\n" + 
				"             JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID\r\n" + 
				"             JOIN tblNhomVatLieu AS d ON h.IDNhomVatLieu = d.ID\r\n" + 
				"             JOIN tblLoaiVatLieu AS e ON h.IDLoaiVatLieu = e.ID\r\n" + 
				"             JOIN tblDonViTinh AS f ON h.IDDonViTinh = f.ID\r\n" + 
				"             JOIN tblChiNhanh AS g ON a.IDChiNhanh = g.ID\r\n" + 
				"        WHERE 1 = 1 \r\n";

		List<String> lstParams = new ArrayList<>();
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			queryStr += " and a.IDChiNhanh = ? ";
			lstParams.add(entity.getIDChiNhanh());
		}
		if (!Utils.isNullOrEmpty(entity.getTuNgay())) {
			queryStr += " and a.NgayThang >= convert(date, ? , 103) ";
			lstParams.add(entity.getTuNgay());
		}
		if (!Utils.isNullOrEmpty(entity.getDenNgay())) {
			queryStr += " and a.NgayThang <= convert(date, ? , 103) ";
			lstParams.add(entity.getDenNgay());
		}
		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
			queryStr += " and a.TrangThai = ? ";
			lstParams.add(entity.getIdTrangThai());
		}
		queryStr +=  " ORDER BY  a.NgayThang desc "; 
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(BricksContract.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}

	@Override
	public List<BricksTicket> getBricksTikets(BricksSearch entity) {
		// TODO Auto-generated method stub
		List<BricksTicket> res = new ArrayList<>();
		String queryStr = "SELECT a.ID, \r\n" + 
				"               a.SoPhieu, \r\n" + 
				"               a.TenBienSoXe, \r\n" + 
				"               a.TenLaiXe, \r\n" + 
				"               a.NgayThang, \r\n" + 
				"               c.TenChiNhanh, \r\n" + 
				"               b.TenNhaCungCap, \r\n" + 
				"               a.CongTrinh, \r\n" + 
				"               d.TenNhomVatLieu, \r\n" + 
				"               e.TenLoaiVatLieu, \r\n" + 
				"               f.TenDonViTinh, \r\n" + 
				"               g.SoLuongThucXuat, \r\n" + 
				"               g.SoLuongNhan, \r\n" + 
				"               g.DonGiaCoThue, \r\n" + 
				"               g.DonGiaKhongThue, \r\n" + 
				"               g.ThanhTienCoThue, \r\n" + 
				"               g.ThanhTienKhongThue, \r\n" + 
				"               a.TrangThai, \r\n" + 
				"               a.TrangThaiText, \r\n" + 
				"               a.NguoiDuyet, \r\n" + 
				"               a.NguoiXoa, \r\n" + 
				"               a.NgayTao, \r\n" + 
				"               a.NguoiTao, \r\n" + 
				"               a.MoTa,a.IDChiNhanh\r\n" + 
				"        FROM tblBanGach AS a\r\n" + 
				"             JOIN tblBanGach_ChiTiet AS g ON a.ID = g.IDBan\r\n" + 
				"             JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID\r\n" + 
				"             JOIN tblChiNhanh AS c ON a.IDChiNhanh = c.ID\r\n" + 
				"             JOIN tblNhomVatLieu AS d ON g.IDNhomVatLieu = d.ID\r\n" + 
				"             JOIN tblLoaiVatLieu AS e ON g.IDLoaiVatLieu = e.ID\r\n" + 
				"             JOIN tblDonViTinh AS f ON g.IDDonViTinh = f.ID\r\n" + 
				"        WHERE 1 = 1\r\n";

		List<String> lstParams = new ArrayList<>();
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			queryStr += " and a.IDChiNhanh = ? ";
			lstParams.add(entity.getIDChiNhanh());
		}
		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
			queryStr += " and a.TrangThai = ? ";
			lstParams.add(entity.getIdTrangThai());
		}
		queryStr += " ORDER BY a.NgayThang desc ";
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(BricksTicket.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}

	@Override
	public List<BricksOrder> getBricksOrders(BricksSearch entity) {
		// TODO Auto-generated method stub
		List<BricksOrder> res = new ArrayList<>();
		String queryStr = "SELECT a.ID, \r\n" + 
				"               a.NgayThang, \r\n" + 
				"               g.TenChiNhanh, \r\n" + 
				"               b.TenNhaCungCap, \r\n" + 
				"               TienCoThue = a.CongNoThuHoaDon, \r\n" + 
				"               TienKhongThue = a.CongNoThuThanhToan, \r\n" + 
				"               a.NoiDung, \r\n" + 
				"               a.Loai, \r\n" + 
				"               a.TenLoai, \r\n" + 
				"               a.TrangThai, \r\n" + 
				"               a.TrangThaiText, \r\n" + 
				"               a.NguoiDuyet, \r\n" + 
				"               a.NguoiXoa, \r\n" + 
				"               a.NgayTao, \r\n" + 
				"               a.NguoiTao, a.IDChiNhanh\r\n" + 
				"        FROM tblCongNo AS a\r\n" + 
				"             JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID\r\n" + 
				"             JOIN tblChiNhanh AS g ON a.IDChiNhanh = g.ID\r\n" + 
				"        WHERE 1 = 1 --a.TrangThai != 2             \r\n" + 
				"              --AND IDChiNhanh = @IDChiNhanh\r\n" + 
				"              AND Loai = 3\r\n" + 
				"        ";

		List<String> lstParams = new ArrayList<>();
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			queryStr += " and a.IDChiNhanh = ? ";
			lstParams.add(entity.getIDChiNhanh());
		}
		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
			queryStr += " and a.TrangThai = ? ";
			lstParams.add(entity.getIdTrangThai());
		}
		queryStr += " ORDER BY a.NgayThang desc";
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(BricksOrder.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}
}
