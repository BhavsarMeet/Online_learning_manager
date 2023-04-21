package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bean.QuestionBean;
import com.bean.QuizBean;
import com.bean.TeacherBean;
import com.dao.QuestionDao;
import com.dao.QuizDao;

@Controller
@RequestMapping("/question")
public class QuestionController {
	
	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	QuizDao quizDao;
	
	@RequestMapping("/getViewQuestion/{quizId}")
	public ModelAndView getView(ModelAndView modelandview,@PathVariable("quizId") int quizId) {
		List<QuestionBean> questions = quizDao.getQuestionByQuizId(quizId);
		modelandview.addObject("questions",questions);
		modelandview.addObject("quizId",quizId);
		modelandview.setViewName("/faculty/view-question");
		
		return modelandview;
	}
	@RequestMapping("/getAddNewQuestion/{quizId}")
	public ModelAndView getAddquiz(ModelAndView modelandview,@PathVariable("quizId") int quizId) {
		
		QuizBean quiz = quizDao.getQuizById(quizId);
		
		if(quiz.getQuestionsForQuiz().size()<quiz.getQuizMarks()) {
		
			modelandview.setViewName("/faculty/add-question");
			modelandview.addObject("quizId",quizId);
			
		}else {
			modelandview.addObject("quizquestionerror","quiz already ready to deliver!");
			modelandview.setViewName("forward:/quiz/quiz-manager");	
		}
		return modelandview;
	}

	@PostMapping("/addQuestion")
	public ModelAndView addQuestion(QuestionBean question,@RequestParam("quizId") int quizId,ModelAndView modelandview,HttpSession session ) {
		
		//questions added to quiz
		QuizBean quiz = quizDao.getQuizById(quizId);
		
		question.setQuestionInquiz(quiz);
		questionDao.addQuestion(question);
		
		//list all the questions 
		List<QuestionBean> questions = quizDao.getQuestionByQuizId(quizId); 
		
		modelandview.addObject("quizId",quizId);
		modelandview.addObject("questions",questions);
		modelandview.setViewName("/faculty/view-question");
		
		return modelandview;
	}
}
