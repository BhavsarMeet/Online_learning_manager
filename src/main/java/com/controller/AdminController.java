package com.controller;

import java.util.List;

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

import com.bean.AdminBean;
import com.bean.CourseBean;
import com.bean.QuizBean;
import com.bean.ResultBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.bean.VideoBean;
import com.dao.AdminDao;
import com.dao.CourseDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	StudentDao studentDao;

	@Autowired
	TeacherDao teacherDao;
	
	@Autowired
	CourseDao courseDao;
	
	@RequestMapping("/gotoCourseLessonListAdmin")
	public ModelAndView lessonListAdmin(ModelAndView modelAndView,@RequestParam("id") int courseId) {
		modelAndView.addObject("courseId",courseId);
		
		List<VideoBean> list = courseDao.getCourseVideoLinksByCourseId(courseId);
		modelAndView.addObject("lessons",list);
		modelAndView.setViewName("/admin/courseLessonList");
		return modelAndView;
	}
	
	@RequestMapping("/playvideoadmin")
	public ModelAndView playVideo(ModelAndView modelAndView,@RequestParam("link") String link,@RequestParam("title") String title,@RequestParam("courseId") int courseId) {
		
		List<VideoBean> videos = courseDao.getCourseVideoLinksByCourseId(courseId);
		modelAndView.addObject("courseId",courseId);
		modelAndView.addObject("link",link);
		modelAndView.addObject("title",title);
		modelAndView.addObject("videos",videos); 
		modelAndView.setViewName("/admin/videos");
		
		return modelAndView;
	}
	@RequestMapping("/students")
	public ModelAndView getStudentList(ModelAndView  mv) {
		List<StudentBean> students = studentDao.getAllStudents();
		if(students.isEmpty()) {
			mv.setViewName("/admin/studentList");
			mv.addObject("errorstudent", "no student added yet!");
		}else {
		mv.addObject("students",students);
		mv.setViewName("/admin/studentList");
		}
		return mv;
	}
	@RequestMapping("/faculties")
	public ModelAndView getList(ModelAndView mv) {
		List<TeacherBean> faculties = teacherDao.getAllTeachers();
		mv.addObject("faculties",faculties);
		mv.setViewName("/admin/facultyList");
		return mv;
	}
	@PostMapping("/addAdmin")
	public ModelAndView addAdmin(AdminBean Admin,ModelAndView modelandview,HttpServletRequest req) {
		adminDao.addAdmin(Admin);
		modelandview.addObject("Admin",Admin);
		HttpSession session = req.getSession();
		session.setAttribute("Admin", Admin);
		modelandview.setViewName("/admin/dashboard");
		return modelandview;
	}
	@GetMapping("/admin-edit")
	public ModelAndView editAdmin(@RequestParam("email") String email,ModelAndView modelAndView) {
		System.out.println("here");
		AdminBean admin = adminDao.getAdminByEmail(email);
		if(admin!=null) {
		
			modelAndView.addObject("admin",admin);
			modelAndView.setViewName("/admin/edit-admin");
		}
		else {
			modelAndView.addObject("editerror","something went wrong!,please try again later!");
			modelAndView.setViewName("/admin/dashboard");
		}
		
		return modelAndView;
	} 
	
	@RequestMapping("/viewstudentresult")
	public ModelAndView getStudentResult(ModelAndView modelAndView,@RequestParam("studentId") int studentId) {
	
		List<QuizBean> quizes=studentDao.getQuizesByStudentId(studentId);
		List<ResultBean> results=studentDao.getResultsOfStudent(studentId);
		
		modelAndView.addObject("results",results);
		modelAndView.addObject("quizes",quizes);
		modelAndView.setViewName("/admin/resultDetails");
		
		return modelAndView;
	}
	@PostMapping("/updateadmin")
	public ModelAndView updateAdmin(AdminBean admin,@RequestParam("email") String email,HttpSession session,ModelAndView modelandview) {
		
		System.out.println(admin.getAdminName());
		System.out.println("hereemail-"+email);
		
		AdminBean updatedAdmin = adminDao.updateAdmin(admin,email);
		
		if(updatedAdmin!=null) {
			System.out.println("upadted");
			modelandview.addObject("admin",updatedAdmin);
			session.removeAttribute("admin");
			session.setAttribute("admin",updatedAdmin);
			modelandview.addObject("successupdate","account updated successfully!");
			modelandview.setViewName("/admin/dashboard");
		}
		else {
			System.err.println("not updated");
			modelandview.addObject("errorupdate","error updating profile,please try again later!");
			modelandview.setViewName("/admin/dashboard");
		}
		return modelandview;
	}
	@GetMapping("/Admins")
	public ModelAndView getAdmin(ModelAndView modelandview) {
		List<AdminBean> list =adminDao.getAllAdmins();
		modelandview.addObject("list" , list);
		modelandview.setViewName("/admin/AdminList");
		return modelandview;
	}
	
	@GetMapping("/deleteAdmin/{id}")
	public String deleteAdmin(@PathVariable("id") int id) {
		adminDao.delete(id);
		return "/admin/AdminList" ;
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView getDashboard(ModelAndView mv) {
		List<TeacherBean> faculties = teacherDao.getAllTeachers();
		List<StudentBean> students = studentDao.getAllStudents();
		List<CourseBean> list = courseDao.getAllCourses();
		mv.addObject("totalCourse",list.size());
		mv.addObject("totalStudent",students.size());
		mv.addObject("totalFaculty",faculties.size());
		
		System.out.println("studnet"+students.size());
		mv.setViewName("/admin/dashboard");
		return mv;
	}
	
	@RequestMapping("getCourses")
	public ModelAndView getCourseList(@RequestParam("studentId") int studentId,ModelAndView modelandview) {
		modelandview.addObject("studentId",studentId);
		
		List<CourseBean> list = courseDao.getAllCourses();
		modelandview.addObject("Courses" , list);
		
		modelandview.setViewName("admin/courseList");
		return modelandview;
	}
	
	@RequestMapping("assignCourse")
	public ModelAndView assignCourse(@RequestParam("studentId") int studentId,@RequestParam("courseId") int courseId,ModelAndView modelandview) {
		boolean result = studentDao.assignCourseTostudent(courseId, studentId);
		if(result) {
			modelandview.addObject("msg","course assigned successfully");
			modelandview.setViewName("/admin/dashboard");
		}else {
			modelandview.addObject("msg","course assigned failed,try after some time");
			modelandview.setViewName("/admin/courseList");
		}
		return modelandview;
	}
	
	@RequestMapping("viewCourseOfStudent")
	public ModelAndView viewCourseOfStudent(@RequestParam("studentId") int studentId,ModelAndView modelandview) {
	
		List<CourseBean> list = studentDao.getCourseTakenByStudent(studentId);
		modelandview.addObject("Courses",list);
		modelandview.addObject("studentId",studentId);
		modelandview.setViewName("/admin/viewCourseList");
		return modelandview;
	}
	
	@RequestMapping("viewCourseOfFaculty")
	public ModelAndView viewCourseOfFaculty(@RequestParam("facultyId") int facultyId,ModelAndView modelandview) {
		List<CourseBean> list = teacherDao.getCourseByTeacherId(facultyId);
		modelandview.addObject("Courses",list);
		modelandview.setViewName("/admin/viewCourseList");
		return modelandview;
	}
		
}
