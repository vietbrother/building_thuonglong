package com.api.thuonglongjsc.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.api.thuonglongjsc.dto.*;

@Repository
public interface CategoryRepository {
	public List<CategoryDTO> getCategoryLichXuatBeTong(CategorySearch entity);
	
	public List<CategoryDTO> getProvider(CategorySearch entity);

	public List<CategoryDTO> getCongTrinh(CategorySearch entity);

	public List<CategoryDTO> getHinhThucBom(CategorySearch entity);

	public List<CategoryDTO> getMacBeTong(CategorySearch entity);

	public List<CategoryDTO> getEmployee(CategorySearch entity);
	
	
	public List<CategoryDTO> getCategoryLichBanGach(CategorySearch entity);
}