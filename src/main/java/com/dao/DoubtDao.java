package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.bean.DoubtBean;
import com.bean.ResultBean;
import com.bean.StudentBean;
import com.service.DoubtRepo;

@Service
public class DoubtDao {

	@Autowired
	DoubtRepo doubtRepo;
	
	public DoubtBean addDoubt(DoubtBean doubtBean) {
		return doubtRepo.save(doubtBean);
	}
	
	public List<DoubtBean> getDoubts(String ans){
		return doubtRepo.getDoubts(ans);
	}
	
	public DoubtBean getDoubtById(int doubtId) {
		return doubtRepo.getById(doubtId);
	}
	
	public DoubtBean updateDoubt(DoubtBean doubtBean) {
		doubtRepo.save(doubtBean);
		
		return doubtBean;
	}

}
