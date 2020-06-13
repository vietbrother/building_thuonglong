package com.api.thuonglongjsc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.thuonglongjsc.dto.*;
import com.api.thuonglongjsc.exception.ResourceNotFoundException;
import com.api.thuonglongjsc.model.TblUserAccount;
import com.api.thuonglongjsc.repository.StatisticRepository;
import com.api.thuonglongjsc.repository.UserRepository;

@RestController
@RequestMapping("/api/main")
public class MainController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private StatisticRepository statisticRepository;

	@PostMapping("/v1/login")
	public ResultDTO login(@Valid @RequestBody TblUserAccount user) {
		ResultDTO res = userRepository.login(user.getUserName(), user.getPassword());
		return res;
	}

	@PostMapping("/v1/hopdongbetong")
	public List<HopDongBeTong> getListHopDongBeTong(@RequestBody HopDongBeTongSearch entity) {
		return userRepository.getListHopDongBeTong(entity);
	}

	@PostMapping("/v1/lichxuatbetong")
	public List<LichXuatBeTong> getListLichXuatBeTong(@RequestBody LichXuatBeTongSearch entity) {
		return userRepository.getListLichXuatBeTong(entity);
	}

	@PostMapping("/v1/giabanvatlieu")
	public List<GiaBanVatLieu> getListGiaBanVatLieu(@RequestBody GiaBanVatLieuSearch entity) {
		return userRepository.getListGiaBanVatLieu(entity);
	}
	
	@PostMapping("/v1/gachmenbong")
	public List<GachMenBong> getListGachMenBong(@RequestBody GachMenBongSearch entity) {
		return userRepository.getListGachMenBong(entity);
	}
	
	@PostMapping("/v1/gachterrazo")
	public List<GachTerrazo> getListGachTerrazo(@RequestBody GachTerrazoSearch entity) {
		return userRepository.getListGachTerrazo(entity);
	}
	
	@PostMapping("/v1/gachxaydung")
	public List<GachXayDung> getListGachXayDung(@RequestBody GachXayDungSearch entity) {
		return userRepository.getListGachXayDung(entity);
	}
	
	@PostMapping("/v1/approve")
	public ResultDTO approve(@Valid @RequestBody ApproveInputDTO param) {
		ResultDTO res = userRepository.approveContract(param.getContractId(), param.getUsername(), param.getType(), param.getApproveStateId());
		return res;
	}
	
	@PostMapping("/v1/statistic/sumary")
	public List<ChartData> getChartTotal(@Valid @RequestBody ChartSearch entity) {
		return statisticRepository.getChartTotal(entity);
	}
	
	@PostMapping("/v1/statistic/detail")
	public List<ChartDataDetail> getChartDetail(@Valid @RequestBody ChartSearch entity){
		return statisticRepository.getChartDetail(entity);
	}
	
	@PostMapping("/v1/statistic/daily")
	public List<ChartDataDaily> getChartDaily(@Valid @RequestBody ChartSearch entity) {
		return statisticRepository.getChartDaily(entity);
	}
	
	@PostMapping("/v1/statistic/daily/bricks")
	public List<ChartDataBricksDaily> getChartBricksDaily(@Valid @RequestBody ChartSearch entity) {
		return statisticRepository.getChartBricksDaily(entity);
	}
}
