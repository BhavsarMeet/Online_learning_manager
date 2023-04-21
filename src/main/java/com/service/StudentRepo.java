package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.QuizBean;
import com.bean.StudentBean;

@Repository
public interface StudentRepo extends JpaRepository<StudentBean, Integer>{

	StudentBean findByStudentEmail(String email);
	
}
