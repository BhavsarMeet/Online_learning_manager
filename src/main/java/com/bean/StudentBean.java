package com.bean;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class StudentBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int studentId;
	
	@NotNull(message = "must not be empty")
	@Size(min = 2,message = "name should have atleast two characters!")
	private String studentName;
	
	@NotNull(message = "must not be empty")
	@Email(message = "enter valid email!")
	private String studentEmail;
	
	@NotNull(message = "must not be empty")
	@Size(min = 8,max = 20,message = "password must be of 8-20 characters!and includes digits,num,alpha(uandl),s sys")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message = "password should be strong(include special char or numbers)!")
	private String studentPassword;
	
	@Size(max = 10,min = 10,message = "size must be 10")
	@NotNull(message = "must not be empty")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "enter valid mobile number!")
	private String studentPhone;
	
	@ManyToMany
	private List<CourseBean> coursesTakenByStudent;
	
	@ManyToMany 
	private List<QuizBean> quizByStudent; 
	
	@OneToMany(mappedBy = "student") 
	private List<ResultBean> resultsOfStudent;  
	
	@OneToMany(mappedBy = "student")
	private List<DoubtBean> doubtOfStudent;
	
	public List<DoubtBean> getDoubtOfStudent() {
		return doubtOfStudent;
	}
	public void setDoubtOfStudent(List<DoubtBean> doubtOfStudent) {
		this.doubtOfStudent = doubtOfStudent;
	}
	public List<ResultBean> getResultsOfStudent() {
		return resultsOfStudent;
	}
	public void setResultsOfStudent(List<ResultBean> resultsOfStudent) {
		this.resultsOfStudent = resultsOfStudent;
	}
	public List<QuizBean> getQuizByStudent() {
		return quizByStudent;
	}
	public void setQuizByStudent(List<QuizBean> quizByStudent) {
		this.quizByStudent = quizByStudent;
	}
	public String getStudentPhone() {
		return studentPhone;
	}
	public List<CourseBean> getCoursesTakenByStudent() {
		return coursesTakenByStudent;
	}
	public void setCoursesTakenByStudent(List<CourseBean> coursesTakenByStudent) {
		this.coursesTakenByStudent = coursesTakenByStudent;
	}
	public void setStudentPhone(String studentPhone) {
		this.studentPhone = studentPhone;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	public String getStudentPassword() {
		return studentPassword;
	}
	public void setStudentPassword(String studentPassword) {
		this.studentPassword = studentPassword;
	}
	/*
	 * public List<String> getStudentSubjects() { return studentSubjects; } public
	 * void setStudentSubjects(List<String> studentSubjects) { this.studentSubjects
	 * = studentSubjects; }
	 */
	
	
}
