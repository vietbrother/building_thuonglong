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
		String queryStr = "SELECT a.ID, h.TenChiNhanh, g.TenCongTrinh, b.TenNhaCungCap, TenMacBeTong = c.TenLoaiVatLieu,"
				+ " TenLoaiDa = '', '' as TenDoSut, '' as TenYCDB, "
				+ "a.DonGiaHoaDon,a.DonGiaThanhToan,a.TuNgay,a.DenNgay,"
				+ "a.TrangThai, a.IDChiNhanh, a.TrangThaiText, a.NguoiTao,a.NgayTao \r\n"
				+ "FROM tblGiaBanBeTong AS a JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID \r\n"
				+ "JOIN tblLoaiVatLieu AS c ON a.MacBeTong = c.ID \r\n"
//						+ "JOIN tblLoaiVatLieu AS d ON a.LoaiDa = d.ID\r\n"
//						+ "JOIN tblDoSut AS e ON a.DoSut = e.ID JOIN tblYCDB AS f ON a.YCDB = f.ID \r\n"
				+ "join tblCongTrinhNhaCungCap as g on a.IDCongTrinh = g.ID JOIN tblChiNhanh AS h ON a.IDChiNhanh = h.ID where 1 = 1 ";

		List<String> lstParams = new ArrayList<>();
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			queryStr += " and a.IDChiNhanh = ? ";
			lstParams.add(entity.getIDChiNhanh());
		}
		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
			queryStr += " and a.TrangThai = ? ";
			lstParams.add(entity.getIdTrangThai());
		}
		queryStr += " ORDER BY a.TrangThaiText asc, a.TuNgay desc";
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
		String queryStr = "SELECT a.ID, h.TenChiNhanh, g.TenCongTrinh, b.TenNhaCungCap, TenMacBeTong = c.TenLoaiVatLieu,"
				+ " TenLoaiDa = '', '' as TenDoSut, '' as TenYCDB, "
				+ "a.DonGiaHoaDon,a.DonGiaThanhToan,a.TuNgay,a.DenNgay,"
				+ "a.TrangThai, a.IDChiNhanh, a.TrangThaiText, a.NguoiTao,a.NgayTao \r\n"
				+ "FROM tblGiaBanBeTong AS a JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID \r\n"
				+ "JOIN tblLoaiVatLieu AS c ON a.MacBeTong = c.ID \r\n"
//						+ "JOIN tblLoaiVatLieu AS d ON a.LoaiDa = d.ID\r\n"
//						+ "JOIN tblDoSut AS e ON a.DoSut = e.ID JOIN tblYCDB AS f ON a.YCDB = f.ID \r\n"
				+ "join tblCongTrinhNhaCungCap as g on a.IDCongTrinh = g.ID JOIN tblChiNhanh AS h ON a.IDChiNhanh = h.ID where 1 = 1 ";

		List<String> lstParams = new ArrayList<>();
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			queryStr += " and a.IDChiNhanh = ? ";
			lstParams.add(entity.getIDChiNhanh());
		}
		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
			queryStr += " and a.TrangThai = ? ";
			lstParams.add(entity.getIdTrangThai());
		}
		queryStr += " ORDER BY a.TrangThaiText asc, a.TuNgay desc";
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
		String queryStr = "SELECT a.ID, h.TenChiNhanh, g.TenCongTrinh, b.TenNhaCungCap, TenMacBeTong = c.TenLoaiVatLieu,"
				+ " TenLoaiDa = '', '' as TenDoSut, '' as TenYCDB, "
				+ "a.DonGiaHoaDon,a.DonGiaThanhToan,a.TuNgay,a.DenNgay,"
				+ "a.TrangThai, a.IDChiNhanh, a.TrangThaiText, a.NguoiTao,a.NgayTao \r\n"
				+ "FROM tblGiaBanBeTong AS a JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID \r\n"
				+ "JOIN tblLoaiVatLieu AS c ON a.MacBeTong = c.ID \r\n"
//						+ "JOIN tblLoaiVatLieu AS d ON a.LoaiDa = d.ID\r\n"
//						+ "JOIN tblDoSut AS e ON a.DoSut = e.ID JOIN tblYCDB AS f ON a.YCDB = f.ID \r\n"
				+ "join tblCongTrinhNhaCungCap as g on a.IDCongTrinh = g.ID JOIN tblChiNhanh AS h ON a.IDChiNhanh = h.ID where 1 = 1 ";

		List<String> lstParams = new ArrayList<>();
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			queryStr += " and a.IDChiNhanh = ? ";
			lstParams.add(entity.getIDChiNhanh());
		}
		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
			queryStr += " and a.TrangThai = ? ";
			lstParams.add(entity.getIdTrangThai());
		}
		queryStr += " ORDER BY a.TrangThaiText asc, a.TuNgay desc";
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
