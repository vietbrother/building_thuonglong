package com.api.thuonglongjsc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.thuonglongjsc.dto.*;
//import com.api.thuonglongjsc.model.TblLichBanGach;
//import com.api.thuonglongjsc.model.TblLichXuatBeTong;

@Repository
public interface CalendarRepository {
	public ResultDTO lichXuatBeTongSave(TblLichXuatBeTong model);

	public ResultDTO lichBanGachSave(TblLichBanGach model);

	public ResultDTO lichXuatBeTongDelete(TblLichBanGach model);

	public ResultDTO lichBanGachDelete(TblLichBanGach model);
}