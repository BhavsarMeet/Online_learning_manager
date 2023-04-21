package com.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bean.VideoBean;

@Repository
public interface VideoRepo extends JpaRepository<VideoBean, Integer>{


}
