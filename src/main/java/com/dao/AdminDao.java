package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.AdminBean;
import com.service.AdminRepo;

@Service
public class AdminDao {
	
	@Autowired
	AdminRepo adminRepo;
	
	public AdminBean addAdmin(AdminBean entity) {
		return adminRepo.save(entity);
	}
	
	public AdminBean getAdminById(int id) {
		return adminRepo.findById(id).orElse(null);
	}
	
	public List<AdminBean> getAllAdmins(){
		return adminRepo.findAll();
	}
	
	public AdminBean updateAdmin(AdminBean newAdmin,String email) {
		
		AdminBean oldAdmin = getAdminByEmail(email);
		oldAdmin.setAdminEmail(newAdmin.getAdminEmail());
		oldAdmin.setAdminName(newAdmin.getAdminName());
		oldAdmin.setAdminPhone(newAdmin.getAdminPhone());
		
		adminRepo.save(oldAdmin);
		return oldAdmin;
	}
	
	public void delete(int id) {
		adminRepo.deleteById(id);
	}
	
	public AdminBean getAdminByEmail(String email) {
		return adminRepo.findByAdminEmail(email);
	}
}
