package com.bean;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Entity
public class AdminBean {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
	
	@NotNull(message = "must not be empty")
	@Size(min = 2,message = "name should have atleast two characters!")
	private String adminName;
	
	@NotNull(message = "must not be empty")
	@Email(message = "enter valid email!")
	private String adminEmail;
	
	@NotNull(message = "must not be empty")
	@Size(min = 8,max = 20,message = "password must be of 8-20 characters!and includes digits,num,alpha(uandl),s sys")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message = "password should be strong(include special char or numbers)!")
	private String adminPassword;
	
	@Size(max = 10,min = 10,message = "size must be 10")
	@NotNull(message = "must not be empty")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "enter valid mobile number!")
	private String adminPhone;
	
	public String getAdminPhone() {
		return adminPhone;
	}
	public void setAdminPhone(String adminPhone) {
		this.adminPhone = adminPhone;
	}
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
}
