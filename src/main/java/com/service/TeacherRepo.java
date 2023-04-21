package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.CourseBean;
import com.bean.TeacherBean;

@Repository
public interface TeacherRepo extends JpaRepository<TeacherBean, Integer>{

	TeacherBean findByTeacherEmail(String email);

}
