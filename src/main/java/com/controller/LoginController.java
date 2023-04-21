package com.controller;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.AdminBean;
import com.bean.CourseBean;
import com.bean.LoginBean;
import com.bean.SchemaBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.dao.AdminDao;
import com.dao.CourseDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;
import com.util.EmailService;

@Controller
public class LoginController {

	@Autowired
	AdminDao adminDao;
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	TeacherDao teacherDao; 
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	EmailService emailService;
	@RequestMapping("/")
	public ModelAndView gotoLoginPage(ModelAndView modelAndView) {
		modelAndView.setViewName("redirect:/login.jsp");
		return modelAndView;
	}
	
	@RequestMapping("/signup")
	public ModelAndView signUp(ModelAndView modelAndView) {
		modelAndView.setViewName("/common/signup");
		return modelAndView;
	}
	
	@PostMapping("/login")
	public ModelAndView login(LoginBean loginBean,HttpSession session,ModelAndView modelAndView) {
		System.out.println("here");
		System.out.println("email-"+loginBean.getEmail());
		System.out.println("email-"+loginBean.getPassword());
		StudentBean student=studentDao.getStudentByEmail(loginBean.getEmail());
		
		if(student!=null){
			
			if(student.getStudentPassword().equals(loginBean.getPassword())){
				modelAndView.addObject("student",student);
				session.setAttribute("student", student);
				modelAndView.setViewName("forward:/student/dashboard");
			}
			else {
				modelAndView.addObject("error","invalid credentials!");
				modelAndView.setViewName("forward:/login.jsp");
			}
		}
		else if(student==null) {
			AdminBean admin=adminDao.getAdminByEmail(loginBean.getEmail());
			if(admin!=null){
				
				if(admin.getAdminPassword().equals(loginBean.getPassword())){
					modelAndView.addObject("admin",admin);
					session.setAttribute("admin",admin);
					
					modelAndView.setViewName("forward:/admin/dashboard");
				}
				else {
					modelAndView.addObject("error","invalid credentials!");
					modelAndView.setViewName("forward:/login.jsp");
				}
			}
			else if(admin==null){
				
				TeacherBean teacher=teacherDao.getTeacherByEmail(loginBean.getEmail());
				
				if(teacher!=null){
					
					if(teacher.getTeacherPassword().equals(loginBean.getPassword())){
						
						modelAndView.addObject("teacher",teacher);
						session.setAttribute("teacher", teacher);
						
						modelAndView.setViewName("forward:/faculty/dashboard");
					}
					else {
						modelAndView.addObject("error","invalid credentials!");
						modelAndView.setViewName("forward:/login.jsp");
					}
				}
				else {
					modelAndView.addObject("error","invalid credentials!");
					modelAndView.setViewName("forward:/login.jsp");
				}
			}
		}
		return modelAndView;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(ModelAndView modelAndView,HttpSession session) {
		
		session.removeAttribute("student");
		session.removeAttribute("admin");
		session.removeAttribute("student");
		
		session.invalidate();
		
		modelAndView.setViewName("redirect:/login.jsp");
		return modelAndView;
	}
	
	@PostMapping("/register")
	public ModelAndView register(@Valid @ModelAttribute("schema") SchemaBean schema,BindingResult br,ModelAndView modelAndView) {
		
		
		if(br.hasErrors()) {
			modelAndView.setViewName("/common/signup");
			
		} 
		else {
			if(schema.getRole().equals("student")) {
				
				StudentBean student = new StudentBean();
				System.out.println(schema.getName());
				student.setStudentName(schema.getName());
				student.setStudentPassword(schema.getPassword());
				student.setStudentEmail(schema.getEmail() );
				student.setStudentPhone(schema.getPhone());
		
				StudentBean result  = studentDao.addStudent(student);
				if(result==null) {
					modelAndView.addObject("error","error creating account,try after sometime!");
					modelAndView.setViewName("/common/signup");
				}
				else if(result!=null){
					modelAndView.addObject("successlogin","student account created successfully!");
					modelAndView.setViewName("forward:/admin/dashboard");
				}
			}
			else if(schema.getRole().equals("admin")) {
				AdminBean admin = new AdminBean();
				
				admin.setAdminName(schema.getName());
				admin.setAdminEmail(schema.getEmail() );
				admin.setAdminPassword(schema.getPassword());
				admin.setAdminPhone(schema.getPhone());
		
				AdminBean result  = adminDao.addAdmin(admin);
				if(result==null) {
					modelAndView.addObject("error","error creating account,try after sometime!");
					modelAndView.setViewName("/common/signup");
				}
				else if(result!=null){
					modelAndView.addObject("successlogin","Admin account created successfully!");
					modelAndView.setViewName("forward:/login.jsp");
				}
			}
			else if(schema.getRole().equals("teacher")){
				TeacherBean teacher =new TeacherBean();
				
				teacher.setTeacherName(schema.getName());
				teacher.setTeacherPassword(schema.getPassword());
				teacher.setTeacherEmail(schema.getEmail());
				teacher.setTeacherPhone(schema.getPhone());
		
				TeacherBean result  = teacherDao.addTeacher(teacher);
				if(result==null) {
					modelAndView.addObject("error","error creating account,try after sometime!");
					modelAndView.setViewName("/common/signup");
				}
				else if(result!=null){
					
					modelAndView.addObject("successlogin","faculty account created successfully!");	
					modelAndView.setViewName("forward:/admin/dashboard");
				}
			}
			else {
		
				modelAndView.addObject("error","something went wrong please try again later!");
				modelAndView.setViewName("forward:/login.jsp");
			}
		}	
		return modelAndView;
	} 
	@GetMapping("getForgetPassword")
	public String getForget() {
		return "/common/forget-password";
	}
	
	@PostMapping("verifyEmail")
	public ModelAndView verifyEmail(@RequestParam("email") String email,ModelAndView mv) {
		int otp=(int)(Math.random()*100000);
		
		emailService.send(email, "verify account", "this is your one time password(OTP) is :"+otp);
		mv.addObject("otp", otp);
		mv.addObject("email", email);
		mv.setViewName("/common/verify-otp");
		return mv;
	}
	@PostMapping("checkOtp")
	public ModelAndView verifyOtp(@RequestParam("otp") int otp,@RequestParam("uotp") int uotp,@RequestParam("eamil") String email,ModelAndView mv) {
		if(otp == uotp) {
			StudentBean student = studentDao.getStudentByEmail(email);
			if(student != null) {
				mv.addObject("success", "password sent to email!");
				emailService.send(email, "student password", "password:"+student.getStudentPassword());
			}else {
				AdminBean admin = adminDao.getAdminByEmail(email);
				if(admin != null) {
					mv.addObject("success", "password sent to email!");
					emailService.send(email, "admin password", "password:"+admin.getAdminPassword());
				}else {
					TeacherBean teacher = teacherDao.getTeacherByEmail(email);
					if(teacher != null) {
						mv.addObject("success", "password sent to email!");
						emailService.send(email, "teacher password", "password:"+teacher.getTeacherPassword());
					}else {
						mv.addObject("error", "user doesn't exists");
					}
				}
			}
		}
		else {
			mv.addObject("error", "user doesn't exists");
		}
		mv.setViewName("forward:/login.jsp");
		return mv;
	}
}
