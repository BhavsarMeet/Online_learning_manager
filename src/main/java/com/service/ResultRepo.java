package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bean.QuizBean; 
import com.bean.ResultBean;

@Repository
public interface ResultRepo extends JpaRepository<ResultBean,Integer> {

}
