	package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.CourseBean;
import com.bean.QuizBean;
import com.bean.TeacherBean;
import com.dao.CourseDao;
import com.dao.QuizDao;
import com.dao.TeacherDao;

@Controller
@RequestMapping("/quiz")
public class QuizController {
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	CourseDao courseDao;
	
	@RequestMapping("/quiz-manager")
	public ModelAndView getQuizManager(ModelAndView modelandview,HttpSession session) {
		
		TeacherBean teacher = (TeacherBean) session.getAttribute("teacher");
		List<CourseBean> list = teacherDao.getCourseByTeacherId(teacher.getTeacherId());
		modelandview.addObject("Courses", list);
	
		modelandview.setViewName("/faculty/quiz-manager");
		return modelandview;
	}
	
	@RequestMapping("/viewquiz")
	public ModelAndView getQuizByCourse(@RequestParam("courseId")int courseId,ModelAndView modelAndView) {
		List<QuizBean> quizes = courseDao.getQuizByCourseId(courseId);
		if(quizes.isEmpty()) {
			modelAndView.addObject("quiznotfound","no quizes added yet");
			modelAndView.setViewName("/faculty/quizes");
			modelAndView.addObject("courseId",courseId);
			
		}
		else {
			modelAndView.addObject("courseId",courseId);
			modelAndView.addObject("quizes",quizes);
			modelAndView.setViewName("/faculty/quizes"); 
		}
		return modelAndView;
	}
	@RequestMapping("/gotoAddNewQuiz")
	public ModelAndView getAddquiz(ModelAndView modelandview,@RequestParam("id") int courseId) {
		modelandview.addObject("courseId",courseId);
		modelandview.setViewName("/faculty/add-quiz");
		return modelandview;
	}
	
	@PostMapping("/addQuiz")
	public ModelAndView addQuiz(QuizBean quiz,@RequestParam("courseId") int courseId,ModelAndView modelandview,HttpSession session ) {
		
		CourseBean course=courseDao.getCourseById(courseId);
		quiz.setCourseForQuiz(course);
		quizDao.addQuiz(quiz);
		modelandview.setViewName("redirect:/quiz/quiz-manager");
		return modelandview;
	}
}
