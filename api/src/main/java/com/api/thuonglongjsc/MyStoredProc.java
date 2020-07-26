package com.api.thuonglongjsc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.thuonglongjsc.dto.TblLichBanGach;

public class MyStoredProc implements Work {
	  private  Long numeroPedido;
      private  String codigoFilialNF;
      private  String cgcEntCGCENT;
      private  Long numeroSequencia;
      private  String integradora;
      private String mensagem;
      private String geroubrinde;
      private TblLichBanGach entity;

      public MyStoredProc(TblLichBanGach entity) {
    	  this.entity = entity;
      }

      @Override
      public void execute(Connection conn) throws SQLException {
    	  SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
    	  try (CallableStatement stmt = 
					conn.prepareCall("{CALL dbo.sp_LichBanGach_CheckSua(?1, ?2, ?3,  ?4, ?5, ?6, ?7, ?8, ?9, ?10, ?11, ?12)}")) {
	              stmt.setString(1, entity.getID());
	              java.sql.Date date = new java.sql.Date(sp.parse(entity.getNgayThang()).getTime());
	              stmt.setDate(2, date);
	              stmt.setString(3, entity.getIDChiNhanh());
	              stmt.setString(4, entity.getIDCongTrinh());
	              stmt.setString(5, entity.getHangMuc());
	              stmt.setString(6, entity.getIDNVKD());
	              stmt.setString(7, entity.getIDLoaiVatLieu());
	              stmt.setString(8, entity.getIDDonViTinh());
	              stmt.registerOutParameter(9, Types.NVARCHAR, "IDHopDong");
	              stmt.registerOutParameter(10, Types.NVARCHAR, "IDHopDongBom");
	              stmt.registerOutParameter(11, Types.NVARCHAR, "IDChiTietKinhDoanh");
	              stmt.registerOutParameter(12, Types.NVARCHAR, "Error");
	              stmt.executeUpdate();
	              String mensagem = stmt.getString(9);
	              String geroubrinde = stmt.getString(10);
	              String tea = stmt.getString(11);
	              String te = stmt.getString(12);
	              if (stmt.wasNull()) {
	                  geroubrinde = null;
	                  mensagem = null;
	              }
	          } catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
      }

      public String getMensagem() {
          return mensagem;
      }

      public String getGeroubrinde() {
          return geroubrinde;
      }
}
