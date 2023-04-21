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
public class QuizBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int quizId;
	private String quizTitle;
	private String quizTopic;
	private int quizMarks;
	private boolean attended;
	
	@OneToMany(mappedBy = "questionInquiz")
	private List<QuestionBean> questionsForQuiz;
	
	@ManyToMany(mappedBy = "quizByStudent")
	private List<StudentBean> studentAttendedQuiz;
	
	@ManyToOne
	private CourseBean courseForQuiz;
	
	@OneToMany(mappedBy = "quizData")
	private List<ResultBean> resultsForQuizes;
	
	public List<StudentBean> getStudentAttendedQuiz() {
		return studentAttendedQuiz;
	}
	public void setStudentAttendedQuiz(List<StudentBean> studentAttendedQuiz) {
		this.studentAttendedQuiz = studentAttendedQuiz;
	}
	public List<ResultBean> getResultsForQuizes() {
		return resultsForQuizes;
	}
	public void setResultsForQuizes(List<ResultBean> resultsForQuizes) {
		this.resultsForQuizes = resultsForQuizes;
	}
	
	
	public List<QuestionBean> getQuestionsForQuiz() {
		return questionsForQuiz; 
	}
	public void setQuestionsForQuiz(List<QuestionBean> questionsForQuiz) {
		this.questionsForQuiz = questionsForQuiz;
	}
	public CourseBean getCourseForQuiz() {
		return courseForQuiz;
	}
	public void setCourseForQuiz(CourseBean courseForQuiz) {
		this.courseForQuiz = courseForQuiz;
	}
	public boolean isAttended() {
		return attended;
	}
	public void setAttended(boolean attended) {
		this.attended = attended;
	}
	public int getQuizId() {
		return quizId;
	}
	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}
	public String getQuizTitle() {
		return quizTitle;
	}
	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}
	public String getQuizTopic() {
		return quizTopic;
	}
	public void setQuizTopic(String quizTopic) {
		this.quizTopic = quizTopic;
	}
	public int getQuizMarks() {
		return quizMarks;
	}
	public void setQuizMarks(int quizMarks) {
		this.quizMarks = quizMarks;
	}
	
}
