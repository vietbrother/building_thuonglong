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
import com.api.thuonglongjsc.model.TblUserAccount;
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
public class CategoryRepositoryImpl implements CategoryRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(CategoryRepositoryImpl.class.getName());

	@Override
	public List<CategoryDTO> getCategoryLichXuatBeTong(CategorySearch entity) {
		// TODO Auto-generated method stub
		List<CategoryDTO> res = new ArrayList<>();
		List<String> lstParams = new ArrayList<>();

		String queryStr = "";
		try {
			if (Constants.CATEGORY_TYPE.PROVIDER.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT a.IDNhaCungCap as ID, " + " 	b.TenNhaCungCap as name \n"
						+ " FROM tblHopDongBanBeTong as a \n"
						+ " 	JOIN tblHopDongBanBeTong_ChiTiet as i on a.id = i.IDHD \n"
						+ " 	JOIN tblNhaCungCap as b on a.IDNhaCungCap = b.id \\n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
					queryStr += " and a.IDChiNhanh = ? ";
					lstParams.add(entity.getIDChiNhanh());
				}

				queryStr += " and a.TrangThai = 2 ";
				// if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
				// queryStr += " and a.TrangThai = ? ";
				// lstParams.add(entity.getIdTrangThai());
				// }

			} else if (Constants.CATEGORY_TYPE.CONG_TRINH.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT a.ID as ID, " + " 	a.CongTrinh as name \n"
						+ " FROM tblHopDongBanBeTong as a \n"
						+ " 	JOIN tblHopDongBanBeTong_ChiTiet as i on a.id = i.IDHD \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
					queryStr += " and a.IDChiNhanh = ? ";
					lstParams.add(entity.getIDChiNhanh());
				}
				if (!Utils.isNullOrEmpty(entity.getIDNhaCungCap())
						&& !"NhaCungCapIdAll".equals(entity.getIDNhaCungCap())) {
					queryStr += " and a.IDNhaCungCap = ? ";
					lstParams.add(entity.getIDNhaCungCap());
				}
				queryStr += " and a.TrangThai = 2 ";
			} else if (Constants.CATEGORY_TYPE.HINH_THUC_BOM.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT i.HinhThucBom as ID, " + " 	b.TenHinhThucBom as name \n"
						+ " FROM tblHopDongBanBeTong_Bom as i \n"
						+ " 	JOIN tblHinhThucBom as b on i.HinhThucBom = b.ID \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDCongTrinh())
						&& !"CongTrinhIdAll".equals(entity.getIDCongTrinh())) {
					queryStr += " and i.IDHD = ? ";
					lstParams.add(entity.getIDCongTrinh());
				}
				queryStr += " and i.TrangThai = 2 ";

			} else if (Constants.CATEGORY_TYPE.MAC_BE_TONG.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT i.MacBeTong as ID, " + " 	b.TenLoaiVatLieu as name \n"
						+ " FROM tblHopDongBanBeTong as a \n"
						+ " 	JOIN tblHopDongBanBeTong_ChiTiet as i on a.id = i.IDHD \n"
						+ " 	JOIN tblLoaiVatLieu as b on i.MacBeTong = b.ID \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDCongTrinh())
						&& !"CongTrinhIdAll".equals(entity.getIDCongTrinh())) {
					queryStr += " and a.ID = ? ";
					lstParams.add(entity.getIDCongTrinh());
				}
				queryStr += " and a.TrangThai = 2 ";

			} else if (Constants.CATEGORY_TYPE.EMPLOYEE.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT i.IDNhanVien as ID, " + " 	b.TenNhanVien as name \n"
						+ " FROM tblHopDongBanBeTong as a \n"
						+ " 	JOIN tblHopDongBanBeTong_NVKD as i on a.id = i.IDHD \n"
						+ " 	JOIN tblNhanSu as b on i.IDNhanVien = b.ID \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDCongTrinh())
						&& !"CongTrinhIdAll".equals(entity.getIDCongTrinh())) {
					queryStr += " and a.ID = ? ";
					lstParams.add(entity.getIDCongTrinh());
				}
				queryStr += " and a.TrangThai = 2 ";

			} else {
				return res;
			}

			queryStr += " ORDER BY name ";

			Query query = entityManager.createNativeQuery(queryStr, CategoryDTO.class);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(CategoryDTO.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}

		return res;
	}

	@Override
	public List<CategoryDTO> getProvider(CategorySearch entity) {
		// TODO Auto-generated method stub
		List<CategoryDTO> res = new ArrayList<>();
		List<String> lstParams = new ArrayList<>();

		String condition = "";
		return res;
	}

	@Override
	public List<CategoryDTO> getCongTrinh(CategorySearch entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> getHinhThucBom(CategorySearch entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> getMacBeTong(CategorySearch entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> getEmployee(CategorySearch entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoryDTO> getCategoryLichBanGach(CategorySearch entity) {
		// TODO Auto-generated method stub
		List<CategoryDTO> res = new ArrayList<>();
		List<String> lstParams = new ArrayList<>();

		String queryStr = "";
		try {
			if (Constants.CATEGORY_TYPE.PROVIDER.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT a.IDNhaCungCap as ID, " + " 	b.TenNhaCungCap as name \n"
						+ " FROM tblGiaBanGach as a \n" + " 	JOIN tblGiaBanGach_ChiTiet as i on a.id = i.IDHD \n"
						+ " 	JOIN tblNhaCungCap as b on a.IDNhaCungCap = b.id \\n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
					queryStr += " and a.IDChiNhanh = ? ";
					lstParams.add(entity.getIDChiNhanh());
				}

				queryStr += " and a.TrangThai = 2 ";
				// if (!Utils.isNullOrEmpty(entity.getIdTrangThai())) {
				// queryStr += " and a.TrangThai = ? ";
				// lstParams.add(entity.getIdTrangThai());
				// }

			} else if (Constants.CATEGORY_TYPE.CONG_TRINH.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT a.ID as ID, " + " 	a.CongTrinh as name \n"
						+ " FROM tblGiaBanGach as a \n" + " 	JOIN tblGiaBanGach_ChiTiet as i on a.id = i.IDHD \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDChiNhanh()) && !"BranchIdAll".equals(entity.getIDChiNhanh())) {
					queryStr += " and a.IDChiNhanh = ? ";
					lstParams.add(entity.getIDChiNhanh());
				}
				if (!Utils.isNullOrEmpty(entity.getIDNhaCungCap())
						&& !"NhaCungCapIdAll".equals(entity.getIDNhaCungCap())) {
					queryStr += " and a.IDNhaCungCap = ? ";
					lstParams.add(entity.getIDNhaCungCap());
				}
				queryStr += " and a.TrangThai = 2 ";
			} else if (Constants.CATEGORY_TYPE.DON_VI_TINH.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT i.IDDonViTinh as ID, " + " 	b.TenDonViTinh as name \n"
						+ " FROM tblGiaBanGach as a \n"
						+ " 	JOIN tblGiaBanGach_ChiTiet as i on a.ID = i.IDHD \n"
				+ " 	JOIN tblDonViTinh as b on i.IDDonViTinh = b.ID \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDCongTrinh())
						&& !"CongTrinhIdAll".equals(entity.getIDCongTrinh())) {
					queryStr += " and a.ID = ? ";
					lstParams.add(entity.getIDCongTrinh());
				}
				
				if (!Utils.isNullOrEmpty(entity.getIDLoaiVatLieu())
						&& !"LoaiVatLieuIdAll".equals(entity.getIDLoaiVatLieu())) {
					queryStr += " and a.ID = ? ";
					lstParams.add(entity.getIDLoaiVatLieu());
				}
				queryStr += " and a.TrangThai = 2 ";

			} else if (Constants.CATEGORY_TYPE.NHOM_VAT_LIEU.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT i.IDNhomVatLieu as ID, " + " 	b.TenNhomVatLieu as name \n"
						+ " FROM tblGiaBanGach as a \n"
						+ " 	JOIN tblGiaBanGach_ChiTiet as i on a.ID = i.IDHD \n"
				+ " 	JOIN tblNhomVatLieu as b on i.IDNhomVatLieu = b.ID \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDCongTrinh())
						&& !"CongTrinhIdAll".equals(entity.getIDCongTrinh())) {
					queryStr += " and a.ID = ? ";
					lstParams.add(entity.getIDCongTrinh());
				}
				
				queryStr += " and a.TrangThai = 2 ";
			} else if (Constants.CATEGORY_TYPE.LOAI_VAT_LIEU.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT i.IDLoaiVatLieu as ID, " + " 	b.TenLoaiVatLieu as name \n"
						+ " FROM tblGiaBanGach as a \n" + " 	JOIN tblGiaBanGach_ChiTiet as i on a.id = i.IDHD \n"
						+ " 	JOIN tblLoaiVatLieu as b on i.IDLoaiVatLieu = b.ID \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDCongTrinh())
						&& !"CongTrinhIdAll".equals(entity.getIDCongTrinh())) {
					queryStr += " and a.ID = ? ";
					lstParams.add(entity.getIDCongTrinh());
				}
				if (!Utils.isNullOrEmpty(entity.getIDNhomVatLieu())
						&& !"CongTrinhIdAll".equals(entity.getIDNhomVatLieu())) {
					queryStr += " and i.IDNhomVatLieu = ? ";
					lstParams.add(entity.getIDNhomVatLieu());
				}
				queryStr += " and a.TrangThai = 2 ";

			} else if (Constants.CATEGORY_TYPE.EMPLOYEE.equals(entity.getCategoryType())) {
				queryStr += " select DISTINCT i.IDNhanVien as ID, " + " 	b.TenNhanVien as name \n"
						+ " FROM tblGiaBanGach as a \n" + " 	JOIN tblGiaBanGach_NVKD as i on a.id = i.IDHD \n"
						+ " 	JOIN tblNhanSu as b on i.IDNhanVien = b.ID \n";
				queryStr += " where 1 = 1 ";

				if (!Utils.isNullOrEmpty(entity.getIDCongTrinh())
						&& !"CongTrinhIdAll".equals(entity.getIDCongTrinh())) {
					queryStr += " and a.ID = ? ";
					lstParams.add(entity.getIDCongTrinh());
				}
				queryStr += " and a.TrangThai = 2 ";

			} else {
				return res;
			}

			queryStr += " ORDER BY name ";

			Query query = entityManager.createNativeQuery(queryStr, CategoryDTO.class);
			for (int i = 0; i < lstParams.size(); i++) {
				query.setParameter(i + 1, lstParams.get(i));
			}
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(CategoryDTO.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}

		return res;
	}

}
