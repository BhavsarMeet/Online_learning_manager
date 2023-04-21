package com.controller;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.CourseBean;
import com.bean.DoubtBean;
import com.bean.QuestionBean;
import com.bean.QuizBean;
import com.bean.ResultBean;
import com.bean.StudentBean;
import com.bean.VideoBean;
import com.dao.CourseDao;
import com.dao.DoubtDao;
import com.dao.QuestionDao;
import com.dao.QuizDao;
import com.dao.ResultDao;
import com.dao.StudentDao;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentDao studentDao;
	
	@Autowired
	CourseDao courseDao;
	
	@Autowired
	QuizDao quizDao;
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	ResultDao resDao;
	
	@Autowired
	DoubtDao doubtDao;
	
	@RequestMapping("/")
	public ModelAndView getindex() {
		return new ModelAndView("/student/index");
	}
	
	@RequestMapping("/getResultDetails")
	public ModelAndView getResults(ModelAndView modelAndView,HttpSession session)
	{
		
		StudentBean student=(StudentBean)session.getAttribute("student");
	
		List<QuizBean> quizes=studentDao.getQuizesByStudentId(student.getStudentId());
		List<ResultBean> results=studentDao.getResultsOfStudent(student.getStudentId());
		
		modelAndView.addObject("results",results);
		modelAndView.addObject("quizes",quizes);
		modelAndView.setViewName("/student/resultDetails");
		return modelAndView;
	}
	
	
	@PostMapping("/addStudent")
	public ModelAndView addStudent(StudentBean student,ModelAndView modelandview,HttpServletRequest req) {
		
		studentDao.addStudent(student);
		modelandview.addObject("Student",student);
		
		HttpSession session = req.getSession();
		session.setAttribute("Student", student);
		
		modelandview.setViewName("/student/index");
		return modelandview;
	}
	
	@PostMapping("/updatestudent")
	public ModelAndView updateStudent(StudentBean student,@RequestParam("email") String email,HttpSession session,ModelAndView modelandview) {
		
		System.out.println(student.getStudentName());
		System.out.println("hereemail-"+email);
		
		StudentBean updatedStudent = studentDao.updateStudent(student,email);
		
		if(updatedStudent!=null) {
			System.out.println("upadted");
			modelandview.addObject("student",updatedStudent);
			session.removeAttribute("student");
			session.setAttribute("student",updatedStudent);
			modelandview.addObject("successupdate","account updated successfully!");
			modelandview.setViewName("/student/dashboard");
		}
		else {
			
			modelandview.addObject("errorupdate","error updating profile,please try again later!");
			modelandview.setViewName("/student/dashboard");
		}
		return modelandview;
	}
	
	@GetMapping("/students")
	public ModelAndView getStudent(ModelAndView modelandview) {
		List<StudentBean> list =studentDao.getAllStudents();
		modelandview.addObject("list" , list);
		modelandview.setViewName("/student/StudentList");
		return modelandview;
	}
	
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable("id") int id) {
		studentDao.delete(id);
		return "/student/StudentList" ;
	}
	
	@RequestMapping("/getquizlist/{courseId}")
	public ModelAndView getQuizList(@PathVariable("courseId") int courseId,ModelAndView modelAndView){
		
		List<QuizBean> quizs =courseDao.getQuizByCourseId(courseId);
		if(quizs.isEmpty()) {
			modelAndView.setViewName("/student/quiz-manager");
			
		}else {
			modelAndView.setViewName("/student/quiz-manager");
			modelAndView.addObject("quizs",quizs);
		}
		return modelAndView;
	}

	
	@RequestMapping("getViewQuestionstudent/{quizId}")
	public ModelAndView getQuizQuestionsForStudent(@PathVariable("quizId") int quizId,ModelAndView modelAndView,HttpSession session) {
	
		StudentBean student =(StudentBean)session.getAttribute("student");
		
		QuizBean quizData = studentDao.getQuizDetailsForStudent(quizId, student.getStudentId());
		
		if(quizData.isAttended()) {
			
			modelAndView.addObject("quizerror","quiz already given!");
			modelAndView.setViewName("forward:/student/courses");
		
		}else{
		
			List<QuestionBean> questions = quizDao.getQuestionByQuizId(quizId);
			modelAndView.addObject("questions",questions);
			modelAndView.addObject("quizId",quizId);
			modelAndView.setViewName("/student/start-exam");
			
		}
		return modelAndView;
	} 
	
	@RequestMapping("/evaluation")
	public ModelAndView evalutateScore(@RequestParam("quest") String question[],@RequestParam("quizId") int quizId,HttpServletRequest request,HttpSession session,ModelAndView modelAndView) {
		
		
		//quiz added in student attended quiz list
		QuizBean quiz= quizDao.getQuizById(quizId);
		quiz.setAttended(true);
		StudentBean student=(StudentBean)session.getAttribute("student");
		List<QuizBean> quizesByStudent = studentDao.getQuizesByStudentId(student.getStudentId());
		quizesByStudent.add(quiz);
		student.setQuizByStudent(quizesByStudent);
		studentDao.addStudent(student);
	
		int score=0;
		List<QuestionBean> questions= quizDao.getQuestionByQuizId(quizId);
		for(String ques:question){	
			System.out.println(ques);
			for(int i=0;i<questions.size();i++) {
				
				if(questions.get(i).getQuestionId()==Integer.parseInt(ques)) {
				
					if(questions.get(i).getCorrectOption().equals(request.getParameter("choice_"+ques)))
					{
						score++;
						break;
					}
				}
			}
		}	
			
		//adding result for the quiz and student
		ResultBean resultBean=new ResultBean();
		resultBean.setMarks(score);
		resultBean.setQuizData(quiz);
		resultBean.setStudent(student);
		resDao.addResult(resultBean);
		
		List<ResultBean> results= studentDao.getResultsOfStudent(student.getStudentId());
		List<QuizBean> quizes =studentDao.getQuizesByStudentId(student.getStudentId());
		
		modelAndView.addObject("results",results);
		modelAndView.addObject("quizes",quizes);
		modelAndView.setViewName("/student/resultDetails");
		
	
		return modelAndView;
	}
	
	@RequestMapping("dashboard")
	public ModelAndView gotoDashboard(ModelAndView modelAndView,HttpSession session) {
		int cnt = 0 ;
		StudentBean student = (StudentBean) session.getAttribute("student");
		List<CourseBean> courses = studentDao.getCourseTakenByStudent(student.getStudentId());
		modelAndView.addObject("totalStudentCourse", courses.size());
		for(CourseBean course : courses) {
			for(QuizBean quiz : course.getQuizes()) {
				cnt = cnt + quiz.getResultsForQuizes().size();
			}
		}
		modelAndView.addObject("totalStudentResult", cnt);
		modelAndView.setViewName("/student/dashboard");
		return modelAndView;
	}  
	@GetMapping("/student-edit")
	public ModelAndView editStudent(@RequestParam("email") String email,HttpSession session,ModelAndView modelAndView) {
		
		StudentBean student = studentDao.getStudentByEmail(email);
		if(student!=null) {
			System.out.println("student not null");
			StudentBean s=(StudentBean)session.getAttribute("student");
			System.out.println("session"+s.getStudentName());
			modelAndView.addObject("student",student);
			modelAndView.setViewName("/student/edit-student");
		}
		else {
			modelAndView.addObject("editerror","something went wrong!,please try again later!");
			modelAndView.setViewName("/student/dashboard");
		}
		
		return modelAndView;
	} 
	
	@RequestMapping("/getadddoubt")
	public ModelAndView getAddDoubt(ModelAndView modelAndView) {
		modelAndView.setViewName("/student/add-doubt");
		return modelAndView;
	}
	
	@PostMapping("/adddoubt")
	public ModelAndView addDoubt(DoubtBean doubt,ModelAndView modelAndView,HttpSession session) {
		
		StudentBean student=(StudentBean)session.getAttribute("student");
		doubt.setStudent(student);
		doubt.setDoubtAns("Not Answered!");
		DoubtBean doubtBean = doubtDao.addDoubt(doubt);
		
		if(doubtBean!=null) {
			List<DoubtBean> doubts=studentDao.getDoubtsOfStudent(student.getStudentId());
			if(doubts.isEmpty()) {
				
				modelAndView.addObject("doubterr","no doubts raised yet!");
				modelAndView.setViewName("forward:/student/doubts");
			}else{
				modelAndView.addObject("doubts",doubts);
				modelAndView.setViewName("forward:/student/doubts");
			}
		}else {
			modelAndView.addObject("doubterr","Error while asking questions!");
			modelAndView.setViewName("forward:/student/doubts");
		}
		return modelAndView;
	}
	
	@RequestMapping("/doubts")
	public ModelAndView getDoubtsOfStudent(ModelAndView modelAndView,HttpSession session) {
		
		StudentBean student =(StudentBean)session.getAttribute("student");	
		List<DoubtBean> doubts=studentDao.getDoubtsOfStudent(student.getStudentId());
		if(doubts.isEmpty()) {
			
			modelAndView.addObject("doubterr","No doubts raised yet!");
			modelAndView.setViewName("/student/doubt-list");
		}else{
			modelAndView.addObject("doubts",doubts);
			modelAndView.setViewName("/student/doubt-list");
		}
		return modelAndView;
	}
	
	@RequestMapping("/courses")
	public ModelAndView getCourseListofStudent(ModelAndView modelandview, HttpSession session) {

		StudentBean student = (StudentBean) session.getAttribute("student");
		// System.out.println(teacher.getTeacherName());
		List<CourseBean> list = studentDao.getCourseTakenByStudent(student.getStudentId());
		modelandview.addObject("Courses", list);

		modelandview.setViewName("/student/courseList");
		return modelandview;
	}
	
	@RequestMapping("/playvideostudent")
	public ModelAndView playVideo(ModelAndView modelAndView,@RequestParam("link") String link,@RequestParam("title") String title,@RequestParam("courseId") int courseId) {
		
		List<VideoBean> videos = courseDao.getCourseVideoLinksByCourseId(courseId);
		modelAndView.addObject("courseId",courseId);
		modelAndView.addObject("link",link);
		modelAndView.addObject("title",title);
		modelAndView.addObject("videos",videos); 
		modelAndView.setViewName("/student/videos");
		
		return modelAndView;
	}
	@RequestMapping("/gotoCourseLessonList")
	public ModelAndView lessonList(ModelAndView modelAndView,@RequestParam("id") int courseId) {
		modelAndView.addObject("courseId",courseId);
		
		List<VideoBean> list = courseDao.getCourseVideoLinksByCourseId(courseId);
		modelAndView.addObject("lessons",list);
		modelAndView.setViewName("/student/courseLessonList");
		return modelAndView;
	}

}
