package com.examPortal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_result")
public class Result {
	@Id
	@Column(name = "RESULT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "TOPIC_ID")
	private Integer topic_id;
	@Column(name = "TOPIC_NAME")
	private String topic_name;
	@Column(name = "NO_OF_QUES")
	private Integer no_of_question;
	@Column(name = "NO_OF_CORRECT_QUES")
	private Integer no_of_correct_question;

	public Result(Integer id, Integer userId, Integer topic_id, String topic_name, Integer no_of_question,
			Integer no_of_correct_question, Date created_at) {
		super();
		this.id = id;
		this.userId = userId;
		this.topic_id = topic_id;
		this.topic_name = topic_name;
		this.no_of_question = no_of_question;
		this.no_of_correct_question = no_of_correct_question;
		this.created_at = created_at;
	}

	public String getTopic_name() {
		return topic_name;
	}

	public void setTopic_name(String topic_name) {
		this.topic_name = topic_name;
	}

	private Date created_at;

	

	public Result() {
		super();
	}


	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public int getUser_id() {
		return userId;
	}

	public void setUser_id(Integer user_id) {
		this.userId = user_id;
	}

	public int getTopic_id() {
		return topic_id;
	}

	public void setTopic_id(Integer topic_id) {
		this.topic_id = topic_id;
	}

	public int getNo_of_question() {
		return no_of_question;
	}

	public void setNo_of_question(Integer no_of_question) {
		this.no_of_question = no_of_question;
	}

	public int getNo_of_correct_question() {
		return no_of_correct_question;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setNo_of_correct_question(Integer no_of_correct_question) {
		this.no_of_correct_question = no_of_correct_question;
	}

}
