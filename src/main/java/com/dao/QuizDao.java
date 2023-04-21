package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.QuestionBean;
import com.bean.QuizBean;
import com.bean.ResultBean;
import com.bean.StudentBean;
import com.bean.TeacherBean;
import com.service.QuizRepo;

@Service
public class QuizDao {
	@Autowired
	QuizRepo quizRepo;
	
	

	public QuizBean addQuiz(QuizBean entity) {
		return quizRepo.save(entity);
	}
	
	public QuizBean getQuizById(int id) {
		return quizRepo.findById(id).orElse(null);
	}
	
	
	public List<QuizBean> getAllQuizs(){
		return quizRepo.findAll();
	}
	
	public List<QuizBean> getQuizByName(String name){
		List<QuizBean> quizes= quizRepo.findAll();
		List<QuizBean> quizForStudent=new ArrayList<>();
		for(int i=0;i<quizes.size();i++) {
			if(quizes.get(i).getQuizTitle().contains(name)) {
				
						quizForStudent.add(quizes.get(i));
			}
		}
		return quizForStudent;
	}
/*	public QuizBean updateQuiz(QuizBean newQuiz) {
		QuizBean oldQuiz = getQuizById(newQuiz.getQuizId());
		oldQuiz.setQuizTitle(newQuiz.getQuizTitle());
		oldQuiz.setQuizTopic(newQuiz.getQuizTopic());
		oldQuiz.setQuizQuestions(newQuiz.getQuizQuestions());
		oldQuiz.setQuizMarks(newQuiz.getQuizMarks());
		quizRepo.save(oldQuiz);
		return oldQuiz;
	}
	*/
	public void delete(int id) {
		quizRepo.deleteById(id);
	}
	
	

	

	public List<QuestionBean> getQuestionByQuizId(int quizId) {
		return getQuizById(quizId).getQuestionsForQuiz();
	}

}
