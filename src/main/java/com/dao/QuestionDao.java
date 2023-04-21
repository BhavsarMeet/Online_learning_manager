package com.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.QuestionBean;
import com.bean.QuizBean;
import com.service.QuestionRepo;

@Service
public class QuestionDao {
	
	@Autowired
	QuestionRepo questionRepo;
	

	public QuestionBean addQuestion(QuestionBean entity) {
		return questionRepo.save(entity);
	}
	
	public QuestionBean getQuestionById(int id) {
		return questionRepo.findById(id).orElse(null);
	}
	
	public List<QuestionBean> getAllQuestions(){
		return questionRepo.findAll();
	}
	
	public QuestionBean addQuestion(QuestionBean question,QuizBean quiz) {
			
		question.setQuestionInquiz(quiz);
		return questionRepo.save(question);
	}
	
	public QuestionBean updateQuestion(QuestionBean newQuestion) {
		QuestionBean oldQuestion = getQuestionById(newQuestion.getQuestionId());
		oldQuestion.setQuestion(newQuestion.getQuestion());
		oldQuestion.setOption1(newQuestion.getOption1());
		oldQuestion.setOption2(newQuestion.getOption2());
		oldQuestion.setOption3(newQuestion.getOption3());
		oldQuestion.setOption4(newQuestion.getOption4());
		oldQuestion.setCorrectOption(newQuestion.getCorrectOption());
		
		questionRepo.save(oldQuestion);
		return oldQuestion;
	}
	
	public void delete(int id) {
		questionRepo.deleteById(id);
	}

}
