package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.QuizBean;
import com.bean.ResultBean;
import com.service.ResultRepo;

@Service
public class ResultDao {

	@Autowired
	ResultRepo resRepo;
	
//	public List<QuizBean> byQuizAndStudent(int quizId,int studentId){
//		return resRepo.getByQuizIdAndStudentId(quizId, studentId);
//	}
	public ResultBean addResult(ResultBean result){
		
		return resRepo.save(result);
	}
	
//	public List<ResultBean> getAllResultsByStudentIdandQuizId(int studentId,int quizId){
//		return resRepo.getByStudentIdAndQuizId(studentId,quizId); 
//	}
}
