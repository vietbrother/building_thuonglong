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
		String queryStr = "SELECT h.TenChiNhanh, a.IDChiNhanh, a.total FROM (\r\n" + "	SELECT IDChiNhanh, COUNT(id) as total\r\n"
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
	
	@Override
	public List<ChartDataDaily> getChartDaily(ChartSearch entity) {
		// TODO Auto-generated method stub
		List<ChartDataDaily> res = new ArrayList<>();
		List<String> lstParams = new ArrayList<>();
		String condition = ""; 
		
		
//		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
//			queryStr += " and IDChiNhanh = ? ";
//			lstParams.add(entity.getIDChiNhanh());
//		}
		
		
		if (!Utils.isNullOrEmpty(entity.getNgayThang())) {
			//https://stackoverflow.com/questions/207190/sql-server-string-to-date-conversion
			//https://docs.microsoft.com/en-us/previous-versions/sql/sql-server-2005/ms187928(v=sql.90)?redirectedfrom=MSDN
			//http://www.sqlines.com/oracle-to-sql-server/trunc_datetime
			condition = " AND CONVERT(DATETIME, CONVERT(DATE, NgayThang)) = convert(date, ? , 103) ";
		}
		if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
			condition += " and IDChiNhanh = ? ";
		}
		for(int i = 0; i < 5; i++) {
			if (!Utils.isNullOrEmpty(entity.getNgayThang())) {
				lstParams.add(entity.getNgayThang());//table a
			}
			if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
				lstParams.add(entity.getIDChiNhanh());
			}
		}

		
		String queryStr = "select TongThu,TongChi,CongNoThu,CongNoTra,  KLBeTongBan, KLBeTongDuKien, KLBeTongDaTron\r\n" + 
				"from \r\n" + 
				"( SELECT  ISNULL(SUM(ISNULL(KLKhachHang, 0)), 0) AS KLBeTongBan, '1' as ID\r\n" + 
				"  FROM tblXuatBeTong \r\n" + 
				"  where 1=1 " + condition + 
				" ) a,\r\n" + 
				"( SELECT ISNULL(SUM(ISNULL(KLThucXuat, 0)), 0) as KLBeTongDuKien, '1' as ID\r\n" + 
				"        FROM tblLichXuatBeTong\r\n" + 
				"  where 1=1 " + condition + 
				" ) b,\r\n" + 
				"( SELECT  ISNULL(SUM(CongNoThuThanhToan), 0) as CongNoThu, \r\n" + 
				"                ISNULL(SUM(CongNoTraThanhToan),0) as CongNoTra, '1' as ID\r\n" + 
				"        FROM tblCongNo\r\n" + 
				"  where 1=1 " + condition + 
				" ) c,\r\n" + 
				"( SELECT  ISNULL(SUM(SoTienThu), 0) as TongThu, \r\n" + 
				"                ISNULL(SUM(SoTienChi), 0) as TongChi, '1' as ID\r\n" + 
				"        FROM tblPhieuThuChi\r\n" + 
				"  where 1=1 " + condition + 
				" ) d ,\r\n" + 
				"(  SELECT KLBeTongDaTron = SUM(NumberofBatch), '1' as ID  \r\n" + 
				"   FROM  \r\n" + 
				"   (  \r\n" + 
				"    SELECT DISTINCT DocketNumber, NumberofBatch  \r\n" + 
				"    FROM tblDuLieuTramTron  \r\n" + 
				"    WHERE 1 = 1 AND OrderID != 0  \r\n" + condition + 
				"   ) temp " +
				") e " + 
				"where a.id = b.id  and b.id = c.id and c.id = d.id and d.id = e.id";
//		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
//			queryStr += " and a.TrangThai = ? ";
//			lstParams.add(entity.getIdTrangThai());
//		}
		
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(ChartDataDaily.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}
	
	@Override
	public List<ChartDataBricksDaily> getChartBricksDaily(ChartSearch entity) {
		// TODO Auto-generated method stub
		List<ChartDataBricksDaily> res = new ArrayList<>();
		List<String> lstParams = new ArrayList<>();
		String condition = ""; 
		
		if (!Utils.isNullOrEmpty(entity.getNgayThang())) {
			condition = " AND CONVERT(DATETIME, CONVERT(DATE, NgayThang)) = convert(date, ? , 103) ";
			lstParams.add(entity.getNgayThang());//table a
			lstParams.add(entity.getNgayThang());//table b
			lstParams.add(entity.getNgayThang());// table c
		}
		String queryStr = "SELECT b.TenLoaiVatLieu as name, \r\n" + 
				"               ISNULL(SUM(a.SoLuong), 0) as value, 'tblGachTerrazo' as type\r\n" + 
				"        FROM tblGachTerrazo AS a\r\n" + 
				"             JOIN tblLoaiVatLieu AS b ON a.LoaiGach = b.ID\r\n" + 
				"  		where 1=1 " + condition + 
				"        GROUP BY b.TenLoaiVatLieu \r\n";
		queryStr += " UNION ALL \r\n";
		queryStr += "SELECT b.TenLoaiVatLieu as name, \r\n" + 
				"               ISNULL(SUM(a.SoLuong), 0) as value, 'tblGachMenBong' as type\r\n" + 
				"        FROM tblGachMenBong AS a\r\n" + 
				"             JOIN tblLoaiVatLieu AS b ON a.LoaiGach = b.ID\r\n" + 
				"  		where 1=1 " + condition + 
				"        GROUP BY b.TenLoaiVatLieu \r\n";
		queryStr += " UNION ALL \r\n";
		queryStr += "SELECT b.TenLoaiVatLieu as name, \r\n" + 
				"               ISNULL(SUM(a.SoLuong), 0) as value, 'tblGachXayDung' as type\r\n" + 
				"        FROM tblGachXayDung AS a\r\n" + 
				"             JOIN tblLoaiVatLieu AS b ON a.LoaiGach = b.ID\r\n" + 
				"  		where 1=1 " + condition + 
				"        GROUP BY b.TenLoaiVatLieu \r\n";
//		if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
//			queryStr += " and a.TrangThai = ? ";
//			lstParams.add(entity.getIdTrangThai());
//		}
		
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(ChartDataBricksDaily.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}
}
