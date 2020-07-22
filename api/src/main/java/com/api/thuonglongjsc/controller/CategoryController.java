
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

import com.api.thuonglongjsc.dto.CategoryDTO;
import com.api.thuonglongjsc.dto.CategorySearch;
import com.api.thuonglongjsc.exception.ResourceNotFoundException;
import com.api.thuonglongjsc.model.TblChiNhanh;
import com.api.thuonglongjsc.repository.CategoryRepository;
import com.api.thuonglongjsc.repository.ChiNhanhRepository;
import com.api.thuonglongjsc.repository.StatisticRepository;
import com.api.thuonglongjsc.utils.Constants;

@RestController

@RequestMapping("/api/cat/v1")
public class CategoryController {

	@Autowired
	private ChiNhanhRepository chiNhanhRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/chinhanh")
	public List<TblChiNhanh> getBranch() {
//		List<TblChiNhanh> res = chiNhanhRepository.findAll().;
//		if (res != null && res.size() > 0) {
//			Collections.sort(res, new Comparator<TblChiNhanh>() {
//				@Override
//				public int compare(final TblChiNhanh object1, final TblChiNhanh object2) {
//					return object1.getTenChiNhanh().compareTo(object2.getTenChiNhanh());
//				}
//			});
//		}
//		return res;
		List<TblChiNhanh> res = chiNhanhRepository.getListChiNhanh();
		res.add(0, new TblChiNhanh("BranchIdAll", "Tất cả"));
		return res;
	}

	@PostMapping("/lichxuatbetong/nhacungcap")
	public List<CategoryDTO> getNhaCungCapLXBT(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.PROVIDER);
		List<CategoryDTO> res = categoryRepository.getCategoryLichXuatBeTong(entity);
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	@PostMapping("/lichxuatbetong/congtrinh")
	public List<CategoryDTO> getCongTrinhLXBT(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.CONG_TRINH);
		List<CategoryDTO> res = categoryRepository.getCategoryLichXuatBeTong(entity);
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	@PostMapping("/lichxuatbetong/hinhthucbom")
	public List<CategoryDTO> getHinhThucBomLXBT(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.HINH_THUC_BOM);
		List<CategoryDTO> res = categoryRepository.getCategoryLichXuatBeTong(entity);
		if(res != null && res.size() == 0) {
			res.add(new CategoryDTO("2862C6F2-0AE1-499B-93B7-6E2B0AB46B83", "Không dùng bơm"));
		}
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	@PostMapping("/lichxuatbetong/macbetong")
	public List<CategoryDTO> getMacBeTongLXBT(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.MAC_BE_TONG);
		List<CategoryDTO> res = categoryRepository.getCategoryLichXuatBeTong(entity);
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	@PostMapping("/lichxuatbetong/employee")
	public List<CategoryDTO> getEmployeesLXBT(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.EMPLOYEE);
		List<CategoryDTO> res = categoryRepository.getCategoryLichXuatBeTong(entity);
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	/*
	 * ****************************************************************************
	 * lich ban gach
	 ****************************************************************************/
	@PostMapping("/lichbangach/employee")
	public List<CategoryDTO> getEmployeesLBG(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.EMPLOYEE);
		List<CategoryDTO> res = categoryRepository.getCategoryLichBanGach(entity);
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}
	
	@PostMapping("/lichbangach/nhacungcap")
	public List<CategoryDTO> getNhaCungCapLBG(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.PROVIDER);
		List<CategoryDTO> res = categoryRepository.getCategoryLichBanGach(entity);
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	@PostMapping("/lichbangach/congtrinh")
	public List<CategoryDTO> getCongTrinhLBG(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.CONG_TRINH);
		List<CategoryDTO> res = categoryRepository.getCategoryLichBanGach(entity);
		//res.add(0, new CategoryDTO("None", ""));
		return res;
	}



	@PostMapping("/lichbangach/donvitinh")
	public List<CategoryDTO> getDonViTinhLBG(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.DON_VI_TINH);
		List<CategoryDTO> res = categoryRepository.getCategoryLichBanGach(entity);
//		res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	@PostMapping("/lichbangach/nhomvatlieu")
	public List<CategoryDTO> getNhomVatLieuLBG(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.NHOM_VAT_LIEU);
		List<CategoryDTO> res = categoryRepository.getCategoryLichBanGach(entity);
//		res.add(0, new CategoryDTO("None", ""));
		return res;
	}

	@PostMapping("/lichbangach/loaivatlieu")
	public List<CategoryDTO> getLoaiVatLieuLBG(@Valid @RequestBody CategorySearch entity) {
		if (entity == null) {
			entity = new CategorySearch();
		}
		entity.setCategoryType(Constants.CATEGORY_TYPE.LOAI_VAT_LIEU);
		List<CategoryDTO> res = categoryRepository.getCategoryLichBanGach(entity);
//		res.add(0, new CategoryDTO("None", ""));
		return res;
	}
}
