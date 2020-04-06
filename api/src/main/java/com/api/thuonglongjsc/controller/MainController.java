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

import com.api.thuonglongjsc.dto.ApproveInputDTO;
import com.api.thuonglongjsc.dto.HopDongBeTong;
import com.api.thuonglongjsc.dto.HopDongBeTongSearch;
import com.api.thuonglongjsc.dto.LichXuatBeTong;
import com.api.thuonglongjsc.dto.LichXuatBeTongSearch;
import com.api.thuonglongjsc.dto.ResultDTO;
import com.api.thuonglongjsc.exception.ResourceNotFoundException;
import com.api.thuonglongjsc.model.TblUserAccount;
import com.api.thuonglongjsc.repository.UserRepository;

@RestController
@RequestMapping("/api/main")
public class MainController {
	@Autowired
	private UserRepository userRepository;

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

	@PostMapping("/v1/approve")
	public ResultDTO approve(@Valid @RequestBody ApproveInputDTO param) {
		ResultDTO res = userRepository.approveContract(param.getContractId(), param.getUsername(), param.getType());
		return res;
	}
}
