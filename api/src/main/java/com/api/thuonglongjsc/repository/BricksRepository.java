package com.api.thuonglongjsc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.thuonglongjsc.dto.*;

@Repository
public interface BricksRepository {
	public List<BricksContract> getBricksContracts(BricksSearch entity);
	public List<BricksTicket> getBricksTikets(BricksSearch entity);
	public List<BricksOrder> getBricksOrders(BricksSearch entity);

}