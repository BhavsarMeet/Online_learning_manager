package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class ResultBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int resultId;
	private int marks;
	@ManyToOne
	private QuizBean quizData;
	
	@ManyToOne
	private StudentBean student;
	
	public StudentBean getStudent() {
		return student;
	}
	public void setStudent(StudentBean student) {
		this.student = student;
	}
	public QuizBean getQuizData() {
		return quizData;
	}
	public void setQuizData(QuizBean quizData) {
		this.quizData = quizData;
	}
	public int getResultId() {
		return resultId;
	}
	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	 
}
