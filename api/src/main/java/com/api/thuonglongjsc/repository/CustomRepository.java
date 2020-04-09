package com.api.thuonglongjsc.repository;

import java.util.List;

import com.api.thuonglongjsc.dto.*;

public interface CustomRepository {
	public ResultDTO login(String username, String password);
	
	public List<HopDongBeTong> getListHopDongBeTong(HopDongBeTongSearch entity);

	public List<LichXuatBeTong> getListLichXuatBeTong(LichXuatBeTongSearch entity);
	
	public List<GiaBanVatLieu> getListGiaBanVatLieu(GiaBanVatLieuSearch entity);
	
	public ResultDTO approveContract(String contractId, String username, String approveType, String stateId);
}