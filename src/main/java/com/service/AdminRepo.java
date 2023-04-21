package com.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.AdminBean;

@Repository
public interface AdminRepo extends JpaRepository<AdminBean, Integer> {

	AdminBean findByAdminEmail(String email);

}
