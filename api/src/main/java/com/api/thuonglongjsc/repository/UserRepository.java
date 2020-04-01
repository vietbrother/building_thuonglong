package com.api.thuonglongjsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.thuonglongjsc.model.TblUserAccount;

@Repository
public interface UserRepository extends JpaRepository<TblUserAccount, String>, CustomRepository{

}
