package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bean.DoubtBean;

@Repository
public interface DoubtRepo extends JpaRepository<DoubtBean, Integer> {

	@Query(value = "SELECT * FROM doubt_bean WHERE doubt_ans=?1", nativeQuery = true)
	List<DoubtBean> getDoubts(String ans);
}
