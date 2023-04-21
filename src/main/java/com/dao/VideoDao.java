package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.TeacherBean;
import com.bean.VideoBean;
import com.service.VideoRepo;
@Service
public class VideoDao {

	@Autowired
	VideoRepo videoRepo;
	
	public VideoBean addVideo(VideoBean videoBean) {
		return videoRepo.save(videoBean);
	} 
	public VideoBean  getTeacherById(int id) {
		return videoRepo.findById(id).orElse(null);
	}
	
	public List<VideoBean> getAllVideo(){
		return videoRepo.findAll();
	}


}
