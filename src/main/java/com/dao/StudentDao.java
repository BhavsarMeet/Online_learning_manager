package com.dao;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.CourseBean;
import com.bean.DoubtBean;
import com.bean.QuizBean;
import com.bean.ResultBean;
import com.bean.StudentBean;
import com.bean.VideoBean;
import com.service.CourseRepo;
import com.service.StudentRepo;

@Service
public class StudentDao {
	
	@Autowired
	StudentRepo studentRepo;
	
	@Autowired
	CourseRepo courseRepo;
	

	public StudentBean addStudent(StudentBean entity) {
		return studentRepo.save(entity);
	}
	
	public StudentBean getStudentById(int id) {
		return studentRepo.findById(id).orElse(null);
	}
	
	public List<StudentBean> getAllStudents(){
		return studentRepo.findAll();
	}
	
	public StudentBean updateStudent(StudentBean newStudent,String email) {
		StudentBean oldStudent = getStudentByEmail(email);
		oldStudent.setStudentEmail(newStudent.getStudentEmail());
		oldStudent.setStudentName(newStudent.getStudentName());
		oldStudent.setStudentPhone(newStudent.getStudentPhone());
	//	oldStudent.setStudentSubjects(newStudent.getStudentSubjects());
		
		studentRepo.save(oldStudent);
		
		return oldStudent;
	}
	
	
	public void delete(int id) {
		studentRepo.deleteById(id);
	}
	
	
	public StudentBean getStudentByEmail(String email) {
		return studentRepo.findByStudentEmail(email);
	}
	
	public List<CourseBean> getCourseTakenByStudent(int studentId){
		return studentRepo.getById(studentId).getCoursesTakenByStudent();
	}
	
	public boolean assignCourseTostudent(int courseId,int studentId) {
		try {
			CourseBean course = courseRepo.getById(courseId);
			StudentBean student = getStudentById(studentId);
			
			List<CourseBean> studentCourse = getCourseTakenByStudent(studentId);
			studentCourse.add(course);
			student.setCoursesTakenByStudent(studentCourse);
			
			studentRepo.save(student);
		
			return true;
		}catch(Exception e) {
			return false;
		}
		
	}
 
	public QuizBean getQuizDetailsForStudent(int quizId,int studentId) {
		
		List<QuizBean> quizes=getStudentById(studentId).getQuizByStudent();
		QuizBean quiz=new QuizBean();
		for(int i=0;i<quizes.size();i++) {
			if(quizes.get(i).getQuizId()==quizId)
			{	
				quiz=quizes.get(i);
				break;
			}	
		}
		return quiz;
	}
	

	public List<QuizBean> getQuizesByStudentId(int studentId){
		return getStudentById(studentId).getQuizByStudent();
	}

	public List<ResultBean> getResultsOfStudent(int studentId){
		return getStudentById(studentId).getResultsOfStudent();
	}
	
	public List<DoubtBean> getDoubtsOfStudent(int studentId){
		return getStudentById(studentId).getDoubtOfStudent();
	}
}
