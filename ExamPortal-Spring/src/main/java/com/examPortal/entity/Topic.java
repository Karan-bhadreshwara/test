package com.examPortal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name = "tbl_topic")
public class Topic {
	@Id
	@Column(name = "TOPIC_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "TOPIC_NAME", unique = true)
	private String name;

	public Integer getId() {
		return id;
	}

	public Topic() {
		super();
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Topic(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
