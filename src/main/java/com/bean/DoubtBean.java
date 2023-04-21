package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DoubtBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int doubtId;
	
	private String doubtQues;
	
	private String doubtAns;
	
	@ManyToOne
	StudentBean student;

	public int getDoubtId() {
		return doubtId;
	}

	public void setDoubtId(int doubtId) {
		this.doubtId = doubtId;
	}

	public String getDoubtQues() {
		return doubtQues;
	}

	public void setDoubtQues(String doubtQues) {
		this.doubtQues = doubtQues;
	}

	public String getDoubtAns() {
		return doubtAns;
	}

	public void setDoubtAns(String doubtAns) {
		this.doubtAns = doubtAns;
	}

	public StudentBean getStudent() {
		return student;
	}

	public void setStudent(StudentBean student) {
		this.student = student;
	}

	
	
}
