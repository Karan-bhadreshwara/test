package com.examPortal.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class UserEnt {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	@Column(length = 50, name = "USER_NAME", unique = true)
	private String username;
	@Column(name = "EMAIL")
	private String eMail;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "GENDER")
	private String gender;

	public UserEnt(Integer userId, String userName, String eMail, String password, String gender) {
		super();
		this.userId = userId;
		this.username = userName;
		this.eMail = eMail;
		this.password = password;
		this.gender = gender;
	}

	public UserEnt() {
	
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

}
