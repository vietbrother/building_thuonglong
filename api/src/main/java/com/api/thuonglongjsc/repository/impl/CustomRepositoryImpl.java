package com.api.thuonglongjsc.repository.impl;

import java.util.Optional;

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
import org.springframework.transaction.annotation.Transactional;

import com.api.thuonglongjsc.dto.HopDongBeTong;
import com.api.thuonglongjsc.dto.HopDongBeTongSearch;
import com.api.thuonglongjsc.dto.LichXuatBeTong;
import com.api.thuonglongjsc.dto.LichXuatBeTongSearch;
import com.api.thuonglongjsc.dto.ResultDTO;
import com.api.thuonglongjsc.model.TblUserAccount;
import com.api.thuonglongjsc.repository.CustomRepository;
import com.api.thuonglongjsc.utils.Constants;
import com.api.thuonglongjsc.utils.Utils;

import ch.qos.logback.classic.pattern.Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomRepositoryImpl implements CustomRepository {

	@PersistenceContext
	private EntityManager entityManager;

	private static final Logger logger = LoggerFactory.getLogger(CustomRepositoryImpl.class.getName());

//	private JpaEntityInformation<Vpg2LogPayment, ?> entityInformation;
//
//	@PostConstruct
//	public void postConstruct() {
//		this.entityInformation = JpaEntityInformationSupport.getEntityInformation(Vpg2LogPayment.class, entityManager);
//	}

	@Override
//	@Transactional
	public ResultDTO duyetHopDong(String idHopDong) {
		// TODO Auto-generated method stub
		// entityManager.persist(entity);
		try {

			StoredProcedureQuery storedProcedure = entityManager
					.createNamedStoredProcedureQuery("VPG2_LOG_PAYMENT_INSERT");
			storedProcedure.registerStoredProcedureParameter("SERVICE_CODE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("TRANS_DIRECT", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("TRANS_TYPE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("LOG_DATE", Date.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("LOG_ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("GATEWAY_ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PRODUCT_CODE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PROVIDER_ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PROCESSING_CODE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PAYMENT_CHANNEL", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PAYMENT_METHOD", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("MSG_ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("MSG_TYPE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CUSTOMER_CODE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CUSTOMER_NAME", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CUSTOMER_ADD", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CUSTOMER_PHONE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CUSTOMER_INDENT", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("CLIENT_ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PAYMENT_CODE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("TRACE_NO", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("MSG_CONTENT", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PARTNER_CONTENT_BEFORE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PARTNER_CONTENT_AFTER", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("BILL_ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("BILL_MONTH", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("BILL_AMOUNT", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("BILL_FEE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("BILL_VAT", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("BILL_DETAILS", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("LOG_NOTE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PAYMENT_ID", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("OWNER_ERROR_CODE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("OWNER_ERROR_DESC", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PARTNER_ERROR_CODE", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("PARTNER_ERROR_DESC", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("MONTH", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("DAY", Long.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("SERVER_IP", String.class, ParameterMode.IN);
			storedProcedure.registerStoredProcedureParameter("O_ERROR_CODE", String.class, ParameterMode.OUT);
			storedProcedure.registerStoredProcedureParameter("O_ERROR_DESC", String.class, ParameterMode.OUT);

			/*
			 * storedProcedure.setParameter("SERVICE_CODE", entity.getService_code())
			 * .setParameter("TRANS_DIRECT", entity.getTrans_direct())
			 * .setParameter("TRANS_TYPE", entity.getTrans_type()).setParameter("LOG_DATE",
			 * entity.getLog_date()) .setParameter("LOG_ID",
			 * entity.getLog_id()).setParameter("GATEWAY_ID", entity.getGateway_id())
			 * .setParameter("PRODUCT_CODE", entity.getProduct_code())
			 * .setParameter("PROVIDER_ID", entity.getProvider_id())
			 * .setParameter("PROCESSING_CODE", entity.getProcessing_code())
			 * .setParameter("PAYMENT_CHANNEL", entity.getPayment_channel())
			 * .setParameter("PAYMENT_METHOD", entity.getPayment_method())
			 * .setParameter("MSG_ID", entity.getMsg_id()).setParameter("MSG_TYPE",
			 * entity.getMsg_type()) .setParameter("CUSTOMER_CODE",
			 * entity.getCustomer_code()) .setParameter("CUSTOMER_NAME",
			 * entity.getCustomer_name()) .setParameter("CUSTOMER_ADD",
			 * entity.getCustomer_add()) .setParameter("CUSTOMER_PHONE",
			 * entity.getCustomer_phone()) .setParameter("CUSTOMER_INDENT",
			 * entity.getCustomer_indent()) .setParameter("CLIENT_ID",
			 * entity.getClient_id()) .setParameter("PAYMENT_CODE",
			 * entity.getPayment_code()) .setParameter("TRACE_NO",
			 * entity.getTrace_no()).setParameter("MSG_CONTENT", entity.getMsg_content())
			 * .setParameter("PARTNER_CONTENT_BEFORE", entity.getPartner_content_before())
			 * .setParameter("PARTNER_CONTENT_AFTER", entity.getPartner_content_after())
			 * .setParameter("BILL_ID", entity.getBill_id()).setParameter("BILL_MONTH",
			 * entity.getBill_month()) .setParameter("BILL_AMOUNT",
			 * entity.getBill_amount()).setParameter("BILL_FEE", entity.getBill_fee())
			 * .setParameter("BILL_VAT", entity.getBill_vat()) .setParameter("BILL_DETAILS",
			 * entity.getBill_details()) .setParameter("LOG_NOTE",
			 * entity.getLog_note()).setParameter("PAYMENT_ID", entity.getPayment_id())
			 * .setParameter("OWNER_ERROR_CODE", entity.getOwner_error_code())
			 * .setParameter("OWNER_ERROR_DESC", entity.getOwner_error_desc())
			 * .setParameter("PARTNER_ERROR_CODE", entity.getPartner_error_code())
			 * .setParameter("PARTNER_ERROR_DESC", entity.getPartner_error_desc())
			 * .setParameter("MONTH", entity.getMonth()).setParameter("DAY",
			 * entity.getDay()) .setParameter("SERVER_IP", entity.getServer_ip());
			 * 
			 * // storedProcedure.setParameter(0, entity.getService_code()).setParameter(1,
			 * entity.getTrans_direct()) // .setParameter(2,
			 * entity.getTrans_type()).setParameter(3, entity.getLog_date()) //
			 * .setParameter(4, entity.getLog_id()).setParameter(5, entity.getGateway_id())
			 * // .setParameter(6, entity.getProduct_code()).setParameter(7,
			 * entity.getProvider_id()) // .setParameter(8,
			 * entity.getProcessing_code()).setParameter(9, entity.getPayment_channel()) //
			 * .setParameter(10, entity.getPayment_method()).setParameter(11,
			 * entity.getMsg_id()) // .setParameter(12,
			 * entity.getMsg_type()).setParameter(13, entity.getCustomer_code()) //
			 * .setParameter(14, entity.getCustomer_name()).setParameter(15,
			 * entity.getCustomer_add()) // .setParameter(16,
			 * entity.getCustomer_phone()).setParameter(17, entity.getCustomer_indent()) //
			 * .setParameter(18, entity.getClient_id()).setParameter(19,
			 * entity.getPayment_code()) // .setParameter(20,
			 * entity.getTrace_no()).setParameter(21, entity.getMsg_content()) //
			 * .setParameter(22, entity.getPartner_content_before()) // .setParameter(23,
			 * entity.getPartner_content_after()).setParameter(24, entity.getBill_id()) //
			 * .setParameter(25, entity.getBill_month()).setParameter(26,
			 * entity.getBill_amount()) // .setParameter(27,
			 * entity.getBill_fee()).setParameter(28, entity.getBill_vat()) //
			 * .setParameter(29, entity.getBill_details()).setParameter(30,
			 * entity.getLog_note()) // .setParameter(31,
			 * entity.getPayment_id()).setParameter(32, entity.getOwner_error_code()) //
			 * .setParameter(33, entity.getOwner_error_desc()).setParameter(34,
			 * entity.getPartner_error_code()) // .setParameter(35,
			 * entity.getPartner_error_desc()).setParameter(36, entity.getMonth()) //
			 * .setParameter(37, entity.getDay()).setParameter(38, entity.getServer_ip());
			 * 
			 */

			// storedProcedure.execute();
			return new ResultDTO(String.valueOf(storedProcedure.getOutputParameterValue("O_ERROR_CODE")), "");

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
			return new ResultDTO(Constants.ERROR_CODE.ERROR, e.getMessage());
		}
	}

	@Override
	public List<HopDongBeTong> getListHopDongBeTong(HopDongBeTongSearch entity) {
		// TODO Auto-generated method stub
		List<HopDongBeTong> res = new ArrayList<>();
		String queryStr = "SELECT a.ID, h.TenChiNhanh, g.TenCongTrinh, b.TenNhaCungCap, TenMacBeTong = c.TenLoaiVatLieu, TenLoaiDa = d.TenLoaiVatLieu, e.TenDoSut, f.TenYCDB, a.DonGiaHoaDon,a.DonGiaThanhToan,a.TuNgay,a.DenNgay,a.TrangThaiText, a.NguoiTao,a.NgayTao \r\n"
				+ "FROM tblGiaBanBeTong AS a JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID \r\n"
				+ "JOIN tblLoaiVatLieu AS c ON a.MacBeTong = c.ID \r\n"
				+ "JOIN tblLoaiVatLieu AS d ON a.LoaiDa = d.ID\r\n"
				+ "JOIN tblDoSut AS e ON a.DoSut = e.ID JOIN tblYCDB AS f ON a.YCDB = f.ID \r\n"
				+ "join tblCongTrinhNhaCungCap as g on a.IDCongTrinh = g.ID JOIN tblChiNhanh AS h ON a.IDChiNhanh = h.ID where 1 = 1 ";
		queryStr += " ORDER BY a.TrangThaiText asc, a.TuNgay desc";
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(HopDongBeTong.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}

	@Override
	public List<LichXuatBeTong> getListLichXuatBeTong(LichXuatBeTongSearch entity) {
		List<LichXuatBeTong> res = new ArrayList<>();
		String queryStr = "SELECT a.ID, a.NgayThang, a.GioXuat, i.TenChiNhanh, h.TenCongTrinh, b.TenNhaCungCap, TenMacBeTong = c.TenLoaiVatLieu, TenLoaiDa = d.TenLoaiVatLieu, \r\n"
				+ "	e.TenDoSut, f.TenYCDB, g.TenHinhThucBom, a.KLThucXuat, \r\n"
				+ "	a.KLKhachHang, a.TrangThaiText, a.NguoiTao, a.NgayTao \r\n"
				+ "FROM tblLichXuatBeTong AS a JOIN tblNhaCungCap AS b ON a.IDNhaCungCap = b.ID \r\n"
				+ " JOIN tblLoaiVatLieu AS c ON a.MacBeTong = c.ID \r\n"
				+ " JOIN tblLoaiVatLieu AS d ON a.LoaiDa = d.ID \r\n" + "JOIN tblDoSut AS e ON a.DoSut = e.ID \r\n"
				+ " JOIN tblYCDB AS f ON a.YCDB = f.ID \r\n" + "JOIN tblHinhThucBom AS g ON a.HinhThucBom = g.ID \r\n"
				+ " JOIN tblCongTrinhNhaCungCap AS h ON a.IDCongTrinh = h.ID \r\n"
				+ " JOIN tblChiNhanh AS i ON a.IDChiNhanh = i.ID \r\n" + " WHERE 1 = 1 ";
		queryStr += " ORDER BY a.TrangThaiText asc, a.NgayThang desc";
		try {
			Query query = entityManager.createNativeQuery(queryStr);
			res = query.unwrap(org.hibernate.query.Query.class)
					.setResultTransformer(Transformers.aliasToBean(LichXuatBeTong.class)).getResultList();
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
		}
		return res;
	}

	@Override
	public ResultDTO login(String username, String password) {
		ResultDTO res = new ResultDTO(Constants.ERROR_CODE.ERROR, "");
		try {
			String message = "";
			if (Utils.isNullOrEmpty(username) || Utils.isNullOrEmpty(password)) {
				message = "Cần nhập tên đăng nhập và mật khẩu";
				res.setMessage(message);
				return res;
			}

			Query query = entityManager.createNativeQuery(
					"select * from tblUserAccount p where p.UserName = ? and p.Password = ?", TblUserAccount.class);
			query.setParameter(1, username.toLowerCase().trim()).setParameter(2,
					Utils.md5Genarate(password.toLowerCase().trim()));
			List<TblUserAccount> users = query.getResultList();
			if (users == null || users.isEmpty() || users.size() == 0) {
				message = "Tên đăng nhập hoặc mật khẩu không đúng";
			} else if (users.size() > 1) {
				message = "Tài khoản bị trùng";
			} else {
				TblUserAccount userInfo = users.get(0);
				if (userInfo.getTrangThai() == false) {
					message = "Tài khoản bị khóa";
				} else {
					message = "Đăng nhập thành công";
					res.setId(String.valueOf(System.currentTimeMillis()));
					res.setData(userInfo);
					res.setCode(Constants.ERROR_CODE.SUCCESS);
				}
			}

			res.setMessage(message);
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("error ", e);
			res.setMessage(e.getMessage());
		}
		return res;
	}

}
