package com.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bean.CourseBean;
import com.dao.CourseDao;

@Controller
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseDao courseDao;
	
	@GetMapping("/getAddCourse")
	public String getAddCourse() {
		return "/faculty/addcourse";
	}
	@PostMapping("/addcourse")
	public ModelAndView addCourse(CourseBean Course,ModelAndView modelandview,HttpServletRequest req) {
		courseDao.addCourse(Course);
		
		List<CourseBean> list = courseDao.getAllCourses();
		modelandview.addObject("Courses" , list);
		
		modelandview.setViewName("/admin/courseList");
		return modelandview;
	}
	
	@PostMapping("/updateCourse")
	public ModelAndView updateCourse(CourseBean Course,ModelAndView modelandview) {
		courseDao.updateCourse(Course);
		
		List<CourseBean> list = courseDao.getAllCourses();
		modelandview.addObject("Courses" , list);
		
		modelandview.setViewName("/admin/courseList");
		return modelandview;
	}
	
	@GetMapping("/courses")
	public ModelAndView getCourse(ModelAndView modelandview) {
		List<CourseBean> list = courseDao.getAllCourses();
		modelandview.addObject("Courses" , list);
		modelandview.setViewName("/admin/courseList");
		return modelandview;
	}
	
	@GetMapping("/deleteCourse/{id}")
	public String deleteCourse(@PathVariable("id") int id) {
		courseDao.delete(id);
		return "/admin/courseList" ;
	}

}
