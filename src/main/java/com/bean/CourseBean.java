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

@Entity
public class CourseBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int courseId;
	
	private String courseTitle;
	
	private String courseDesc;
	
	@ElementCollection
	private List<VideoBean> courseVideoLinks;
	
	@ManyToOne
	private TeacherBean CourseTakenByTeacher;

	@ManyToMany(mappedBy = "coursesTakenByStudent")
	private List<StudentBean> assignedCoursesToStudent;
	
	@OneToMany(mappedBy = "courseForQuiz")
	private List<QuizBean> quizes;

	public List<QuizBean> getQuizes() {
		return quizes;
	}

	public void setQuizes(List<QuizBean> quizes) {
		this.quizes = quizes;
	}

	public List<StudentBean> getAssignedCoursesToStudent() {
		return assignedCoursesToStudent;
	}

	public void setAssignedCoursesToStudent(List<StudentBean> assignedCoursesToStudent) {
		this.assignedCoursesToStudent = assignedCoursesToStudent;
	}

	public TeacherBean getCourseTakenByTeacher() {
		return CourseTakenByTeacher;
	}

	public void setCourseTakenByTeacher(TeacherBean courseTakenByTeacher) {
		CourseTakenByTeacher = courseTakenByTeacher;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public List<VideoBean> getCourseVideoLinks() {
		return courseVideoLinks;
	}

	public void setCourseVideoLinks(List<VideoBean> courseVideoLinks) {
		this.courseVideoLinks = courseVideoLinks;
	}

}
