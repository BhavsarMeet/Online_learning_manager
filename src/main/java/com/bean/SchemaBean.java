package com.bean;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class SchemaBean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@NotNull(message = "must not be empty")
	@Size(min = 2,message = "name should have atleast two characters!")
	private String name;
	
	@NotNull(message = "must not be empty")
	@Email(message = "enter valid email!")
	private String email;
	
	@Size(min = 8,max = 20,message = "password must be of 8-20 characters!and includes digits,num,alpha(uandl),s sys")
	@Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$",message = "password should be strong(include special char or numbers)!")
	private String password;
	
	@Size(max = 10,min = 10,message = "size must be 10")
	@NotNull(message = "must not be empty")
	@Pattern(regexp = "[6789]{1}[0-9]{9}",message = "enter valid mobile number!")
	private String phone;
	
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
