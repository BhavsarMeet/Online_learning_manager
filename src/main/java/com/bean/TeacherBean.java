package com.bean;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
public class TeacherBean {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int teacherId;

	@NotNull(message = "must not be empty")
	@Size(min = 2,message = "name should have atleast two characters!")
	private String teacherName;
	
	@NotNull(message = "must not be empty")
	@Email(message = "enter valid email!")
	private String teacherEmail;
	
	@NotNull(message = "must not be empty")
	@Size(min = 8,max = 20,message = "password must be of 8-20 characters!and includes digits,num,alpha(uandl),s sys")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message = "password should be strong(include special char or numbers)!")
	private String teacherPassword;
	
	@Size(max = 10,min = 10,message = "size must be 10")
	@NotNull(message = "must not be empty")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "enter valid mobile number!")
	private String teacherPhone;
	
	
	@OneToMany(mappedBy = "CourseTakenByTeacher")
	private List<CourseBean> teacherTakenCourse;
	
	public List<CourseBean> getTeacherTakenCourse() {
		return teacherTakenCourse;
	}

	public void setTeacherTakenCourse(List<CourseBean> teacherTakenCourse) {
		this.teacherTakenCourse = teacherTakenCourse;
	}

	public String getTeacherPhone() {
		return teacherPhone;
	}
	
	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}
	
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherEmail() {
		return teacherEmail;
	}
	public void setTeacherEmail(String teacherEmail) {
		this.teacherEmail = teacherEmail;
	}
	public String getTeacherPassword() {
		return teacherPassword;
	}
	public void setTeacherPassword(String teacherPassword) {
		this.teacherPassword = teacherPassword;
	}
	
	
}
