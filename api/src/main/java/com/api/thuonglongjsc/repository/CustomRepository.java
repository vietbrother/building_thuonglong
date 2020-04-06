package com.api.thuonglongjsc.repository;

import java.util.List;

import com.api.thuonglongjsc.dto.HopDongBeTong;
import com.api.thuonglongjsc.dto.LichXuatBeTong;
import com.api.thuonglongjsc.dto.LichXuatBeTongSearch;
import com.api.thuonglongjsc.dto.ResultDTO;
import com.api.thuonglongjsc.dto.HopDongBeTongSearch;

public interface CustomRepository {
	public ResultDTO login(String username, String password);
	
	public List<HopDongBeTong> getListHopDongBeTong(HopDongBeTongSearch entity);

	public List<LichXuatBeTong> getListLichXuatBeTong(LichXuatBeTongSearch entity);
	
	public ResultDTO approveContract(String contractId, String username, String approveType);
}