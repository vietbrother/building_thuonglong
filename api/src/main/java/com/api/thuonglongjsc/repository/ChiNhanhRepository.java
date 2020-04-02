
package com.api.thuonglongjsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.thuonglongjsc.model.TblChiNhanh;

@Repository
public interface ChiNhanhRepository extends JpaRepository<TblChiNhanh, Long> {

}
