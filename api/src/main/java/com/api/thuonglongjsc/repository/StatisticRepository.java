package com.api.thuonglongjsc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.thuonglongjsc.dto.*;

@Repository
public interface StatisticRepository {
	public List<ChartData> getChartTotal(ChartSearch entity);
	public List<ChartDataDetail> getChartDetail(ChartSearch entity);
}