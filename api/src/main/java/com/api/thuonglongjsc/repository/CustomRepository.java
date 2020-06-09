package com.api.thuonglongjsc.repository;

import java.util.List;

import com.api.thuonglongjsc.dto.*;
import com.api.thuonglongjsc.model.TblChiNhanh;

public interface CustomRepository {
	public ResultDTO login(String username, String password);
	public List<TblChiNhanh> getListChiNhanh();
	
	public List<HopDongBeTong> getListHopDongBeTong(HopDongBeTongSearch entity);

	public List<LichXuatBeTong> getListLichXuatBeTong(LichXuatBeTongSearch entity);
	
	public List<GiaBanVatLieu> getListGiaBanVatLieu(GiaBanVatLieuSearch entity);
	
	public List<GachMenBongSearch> getListGiaBanVatLieu(GachMenBongSearch entity);
	public List<GachTerrazoSearch> getListGiaBanVatLieu(GachTerrazoSearch entity);
	public List<GachXayDungSearch> getListGiaBanVatLieu(GachXayDungSearch entity);
	
	public ResultDTO approveContract(String contractId, String username, String approveType, String stateId);
}