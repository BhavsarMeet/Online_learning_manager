package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.CourseBean;
import com.bean.QuizBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.bean.VideoBean;

public interface CourseRepo extends JpaRepository<CourseBean, Integer>{

	public List<VideoBean> findByCourseId(int courseId);
	public List<TeacherBean> getByCourseId(int courseId);
	public List<StudentBean> getStudentByCourseId(int courseId);
	
}
