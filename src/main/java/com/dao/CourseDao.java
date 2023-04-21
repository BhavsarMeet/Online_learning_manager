package com.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CourseBean;
import com.bean.QuizBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.bean.VideoBean;
import com.service.CourseRepo;

@Service
public class CourseDao {
	
	@Autowired
	CourseRepo courseRepo;
	
	@Autowired
	StudentDao studentDao;
	
	public List<TeacherBean> courseByTeacher(int courseId){
		return courseRepo.getByCourseId(courseId);
	}
	public List<StudentBean> studentByCourseId(int courseId){
		return courseRepo.getStudentByCourseId(courseId);
	}
	public CourseBean addCourse(CourseBean entity) {
		return courseRepo.save(entity);
	}
	
	public CourseBean getCourseById(int id) {
		return courseRepo.findById(id).orElse(null);
	}
	public List<QuizBean> getQuizByCourseId(int courseId){
		return getCourseById(courseId).getQuizes();
	}
	public List<CourseBean> getAllCourses(){
		return courseRepo.findAll();
	}

	public CourseBean updateCourse(CourseBean newCourse) {
		CourseBean oldCourse = getCourseById(newCourse.getCourseId());
		oldCourse.setCourseTitle(newCourse.getCourseTitle());
		oldCourse.setCourseDesc(newCourse.getCourseDesc());
		
		
		return oldCourse;
	}
	
	public void delete(int id) {
		courseRepo.deleteById(id);
	}

	public List<VideoBean> getCourseVideoLinksByCourseId(int courseId) {
		return	getCourseById(courseId).getCourseVideoLinks();
	}
	

}
