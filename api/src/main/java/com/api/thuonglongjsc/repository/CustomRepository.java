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

	public List<GachMenBong> getListGachMenBong(GachMenBongSearch entity);

	public List<GachTerrazo> getListGachTerrazo(GachTerrazoSearch entity);

	public List<GachXayDung> getListGachXayDung(GachXayDungSearch entity);

	public ResultDTO approveContract(String contractId, String username, String approveType, String stateId);
}