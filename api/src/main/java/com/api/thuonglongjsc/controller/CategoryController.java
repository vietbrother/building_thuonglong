
package com.api.thuonglongjsc.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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

import com.api.thuonglongjsc.exception.ResourceNotFoundException;
import com.api.thuonglongjsc.model.Sp_LoadChiNhanhDaiLy;
import com.api.thuonglongjsc.repository.ChiNhanhRepository;

@RestController

@RequestMapping("/api/cat/v1")
public class CategoryController {

	@Autowired
	private ChiNhanhRepository chiNhanhRepository;

	@GetMapping("/chinhanh")
	public List<Sp_LoadChiNhanhDaiLy> getAllEmployees() {
		List<Sp_LoadChiNhanhDaiLy> res = chiNhanhRepository.findAll();
		if (res != null && res.size() > 0) {
			Collections.sort(res, new Comparator<Sp_LoadChiNhanhDaiLy>() {
				@Override
				public int compare(final Sp_LoadChiNhanhDaiLy object1, final Sp_LoadChiNhanhDaiLy object2) {
					return object1.getTen().compareTo(object2.getTen());
				}
			});
		}
		return res;
	}

}
