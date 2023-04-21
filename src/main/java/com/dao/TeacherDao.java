package com.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CourseBean;
import com.bean.QuizBean;
import com.bean.TeacherBean;
import com.bean.VideoBean;
import com.service.CourseRepo;
import com.service.TeacherRepo;
@Service
public class TeacherDao {
	
	@Autowired
	TeacherRepo teacherRepo;
	
	@Autowired
	CourseRepo courserepo;
	
	@Autowired
	CourseDao courseDao;
	
	public TeacherBean addTeacher(TeacherBean entity) {
		return teacherRepo.save(entity);
	}
	
	public TeacherBean getTeacherById(int id) {
		return teacherRepo.findById(id).orElse(null);
	}
	
	public List<TeacherBean> getAllTeachers(){
		return teacherRepo.findAll();
	}
	
	public TeacherBean updateTeacher(TeacherBean newTeacher,String email) {
		TeacherBean oldTeacher = getTeacherByEmail(email);
		oldTeacher.setTeacherEmail(newTeacher.getTeacherEmail());
		oldTeacher.setTeacherName(newTeacher.getTeacherName());
		oldTeacher.setTeacherPhone(newTeacher.getTeacherPhone());
		//oldTeacher.setTeacherSubjects(newTeacher.getTeacherSubjects());
		teacherRepo.save(oldTeacher);
		return oldTeacher;
	}
	
	public void delete(int id) {
		teacherRepo.deleteById(id);
	}
	
	public TeacherBean getTeacherByEmail(String email) {
		return teacherRepo.findByTeacherEmail(email);
	}
		
	public CourseBean addvideosandcourse(VideoBean video,CourseBean course) {
		
		List<VideoBean> courselink = new ArrayList<VideoBean>();
		courselink = courseDao.getCourseVideoLinksByCourseId(course.getCourseId());
		
		courselink.add(video);
	    course.setCourseVideoLinks(courselink);
	    courserepo.save(course);
	    return course;
	}
	
	public List<CourseBean> getCourseByTeacherId(int teacherId){
		return getTeacherById(teacherId).getTeacherTakenCourse();
	}
	
}
