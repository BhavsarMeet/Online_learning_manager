package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.CourseBean;
import com.bean.DoubtBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.bean.VideoBean;
import com.dao.CourseDao;
import com.dao.DoubtDao;
import com.dao.QuizDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.dao.VideoDao;
import com.service.CourseRepo;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherDao teacherDao;
	@Autowired
	CourseDao courseDao;
	@Autowired
	VideoDao videoDao;
	@Autowired
	CourseRepo courseRepo;
	@Autowired
	QuizDao quizDao;
	@Autowired
	StudentDao studentDao;
	@Autowired
	DoubtDao doubtDao;
	
	@PostMapping("addTeacher")
	public ModelAndView addTeacher(TeacherBean teacher, ModelAndView modelandview, HttpServletRequest req) {

		teacherDao.addTeacher(teacher);
		modelandview.addObject("Teacher", teacher);

		HttpSession session = req.getSession();
		session.setAttribute("Teacher", teacher);

		modelandview.setViewName("/faculty/dashboard");
		return modelandview;
	}

	@PostMapping("/updateteacher")
	public ModelAndView updateTeacher(TeacherBean teacher,@RequestParam("email") String email,HttpSession session,ModelAndView modelandview) {
		
		System.out.println(teacher.getTeacherName());
		System.out.println("hereemail-"+email);
		
		TeacherBean updatedTeacher = teacherDao.updateTeacher(teacher,email);
		
		if(updatedTeacher!=null) {
			System.out.println("upadted");
			modelandview.addObject("teacher",updatedTeacher);
			session.removeAttribute("teacher");
			session.setAttribute("teacher",updatedTeacher);
			modelandview.addObject("successupdate","account updated successfully!");
			modelandview.setViewName("/faculty/dashboard");
		}
		else {
			modelandview.addObject("errorupdate","error updating profile,please try again later!");
			modelandview.setViewName("/faculty/dashboard");
		}
		return modelandview;
	}
	
	@GetMapping("/teacher-edit")
	public ModelAndView editStudent(@RequestParam("email") String email,ModelAndView modelAndView) {
		System.out.println("here");
		TeacherBean teacher = teacherDao.getTeacherByEmail(email);
		if(teacher!=null) {
			System.out.println("teacher not null");
			modelAndView.addObject("teacher",teacher);
			modelAndView.setViewName("/faculty/edit-teacher");
		}
		else {
			modelAndView.addObject("editerror","something went wrong!,please try again later!");
			modelAndView.setViewName("/faculty/dashboard");
		}
		
		return modelAndView;
	} 
	
	@GetMapping("deleteTeacher/{id}")
	public String deleteTeacher(@PathVariable("id") int id) {
		teacherDao.delete(id);
		return "TeacherList";
	}

	@PostMapping("/addcourse")
	public ModelAndView addCourse(CourseBean course, ModelAndView modelandview, HttpSession session) {
		
		TeacherBean teacher =(TeacherBean) session.getAttribute("teacher");
		course.setCourseTakenByTeacher(teacher);
		courseDao.addCourse(course);
		modelandview.setViewName("forward:/teacher/courses"); 
		return modelandview;
	}

	@GetMapping("/getAddCourse")
	public String getAddCourse() {
		return "/faculty/addcourse";
	}
	
	@RequestMapping("/courses")
	public ModelAndView getCourseListofTeacher(ModelAndView modelandview, HttpSession session) {

		TeacherBean teacher = (TeacherBean) session.getAttribute("teacher");
		List<CourseBean> list = teacherDao.getCourseByTeacherId(teacher.getTeacherId());
		modelandview.addObject("Courses", list);

		modelandview.setViewName("/faculty/courseList");
		return modelandview;
	}
	
	@GetMapping("/dashboard")
	public ModelAndView getDashboard(ModelAndView mv,HttpSession session) {
		TeacherBean teacher = (TeacherBean) session.getAttribute("teacher");
		int cnt = 0;
		
		List<CourseBean> courses = teacherDao.getCourseByTeacherId(teacher.getTeacherId());
		mv.addObject("totalTeacherCourse",courses.size());
		
		for(CourseBean course : courses) {
			cnt = cnt + course.getQuizes().size();
		}
		mv.addObject("totalTeacherQuiz", cnt);
		
		mv.setViewName("/faculty/dashboard");
		return mv;
	}
	
	@RequestMapping("/gotoCourseLessonList")
	public ModelAndView lessonList(ModelAndView modelAndView,@RequestParam("id") int courseId) {
		modelAndView.addObject("courseId",courseId);
		
		List<VideoBean> list = courseDao.getCourseVideoLinksByCourseId(courseId);
		modelAndView.addObject("lessons",list);
		modelAndView.setViewName("/faculty/courseLessonList");
		return modelAndView;
	}
	@RequestMapping("/gotoAddLinks")
	public ModelAndView addLinks(ModelAndView modelAndView,@RequestParam("id") int courseId) {
		System.out.println("id"+courseId);
		modelAndView.addObject("courseId",courseId);
		modelAndView.setViewName("/faculty/add-links");
		return modelAndView;
	}

	@RequestMapping("/playvideo")
	public ModelAndView playVideo(ModelAndView modelAndView,@RequestParam("link") String link,@RequestParam("title") String title,@RequestParam("courseId") int courseId) {
		
		List<VideoBean> videos = courseDao.getCourseVideoLinksByCourseId(courseId);
		modelAndView.addObject("courseId",courseId);
		modelAndView.addObject("link",link);
		modelAndView.addObject("title",title);
		modelAndView.addObject("videos",videos); 
		modelAndView.setViewName("/faculty/videos");
		
		return modelAndView;
	}
	
	@PostMapping("/addlink")
	public ModelAndView addLink(VideoBean videoBean,@RequestParam("id") int id,ModelAndView modelAndView) {
		
		System.out.println("link-"+videoBean.getVideoLink());
		System.out.println("add link-id"+id);
		CourseBean course= courseDao.getCourseById(id);
		videoDao.addVideo(videoBean);
		teacherDao.addvideosandcourse(videoBean, course);
		List<VideoBean> list = courseDao.getCourseVideoLinksByCourseId(id);
		modelAndView.addObject("lessons",list);
		modelAndView.addObject("courseId",id);
		System.out.println("gone");
		modelAndView.setViewName("/faculty/courseLessonList");
		return modelAndView;
	}
	

	@RequestMapping("/ans-doubts")
	public ModelAndView getDoubtsOfStudent(ModelAndView modelAndView,HttpSession session) {
		
		StudentBean student =(StudentBean)session.getAttribute("student");	
		List<DoubtBean> doubts=doubtDao.getDoubts("Not Answered!");
		if(doubts.isEmpty()) {
			
			modelAndView.addObject("doubterr","No doubts raised at the moment!");
			modelAndView.setViewName("/faculty/doubt-list");
		}else{
			modelAndView.addObject("doubts",doubts);
			modelAndView.setViewName("/faculty/doubt-list");
		}
		return modelAndView;
	}
	
	@RequestMapping("/adddoubtans/{id}")
	public ModelAndView addDoubtAns(DoubtBean doubtBean,ModelAndView modelAndView,@PathVariable("id") int id) {
		
		DoubtBean doubt =doubtDao.getDoubtById(id);
		
		doubt.setDoubtAns(doubtBean.getDoubtAns());
		DoubtBean dou= doubtDao.updateDoubt(doubt);
		
		if(dou==null) {
			
			modelAndView.addObject("doubt-ans-err","Error giving answer!");
			modelAndView.setViewName("forward:/teacher/ans-doubts");
		}else {
			System.out.println("here in done sectin");
			modelAndView.setViewName("forward:/teacher/ans-doubts");
		}
		
		
		return modelAndView;
	}
}
