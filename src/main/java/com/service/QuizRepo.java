package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.QuizBean;
import com.bean.StudentBean;

public interface QuizRepo extends JpaRepository<QuizBean, Integer> {

	public List<QuizBean> getQuizByQuizTitle(String name);
}
