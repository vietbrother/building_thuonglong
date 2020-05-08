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

import com.api.thuonglongjsc.dto.ChartData;
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
public class StatisticRepositoryImpl implements StatisticRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(StatisticRepositoryImpl.class.getName());

	@Override
	public List<ChartData> getChartTotal(ChartSearch entity) {
		// TODO Auto-generated method stub
		List<ChartData> res = new ArrayList<>();
		String queryStr = "SELECT h.TenChiNhanh, a.total FROM (\r\n" + "	SELECT IDChiNhanh, COUNT(id) as total\r\n"
				+ "	FROM tblGiaBanBeTong  \r\n" + "	GROUP BY IDChiNhanh\r\n" + " ) \r\n"
				+ " AS a JOIN tblChiNhanh AS h ON a.IDChiNhanh = h.ID where 1 = 1 ";

		List<String> lstParams = new ArrayList<>();
//		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
//			queryStr += " and a.IDChiNhanh = ? ";
//			lstParams.add(entity.getIDChiNhanh());
//		}
//		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
//			queryStr += " and a.TrangThai = ? ";
//			lstParams.add(entity.getIdTrangThai());
//		}
		queryStr += " ORDER BY h.TenChiNhanh";
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(ChartData.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}

	@Override
	public List<ChartDataDetail> getChartDetail(ChartSearch entity) {
		// TODO Auto-generated method stub
		List<ChartDataDetail> res = new ArrayList<>();
		List<String> lstParams = new ArrayList<>();
		String queryStr = "SELECT h.TenChiNhanh,a.IDChiNhanh, a.total , a.TrangThaiText\r\n" 
				+ " FROM (\r\n"
				+ "	 SELECT IDChiNhanh,TrangThaiText, COUNT(id) as total\r\n" + "	FROM tblGiaBanBeTong\r\n"
				+ "	 where 1 = 1	\r\n";
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			queryStr += " and IDChiNhanh = ? ";
			lstParams.add(entity.getIDChiNhanh());
		}
		queryStr += "	GROUP BY IDChiNhanh, TrangThaiText\r\n" + ") \r\n"
				+ "AS a JOIN tblChiNhanh AS h ON a.IDChiNhanh = h.ID where 1 = 1 ";

//		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
//			queryStr += " and a.TrangThai = ? ";
//			lstParams.add(entity.getIdTrangThai());
//		}
		queryStr += " ORDER BY h.TenChiNhanh";
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(ChartDataDetail.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}
}
