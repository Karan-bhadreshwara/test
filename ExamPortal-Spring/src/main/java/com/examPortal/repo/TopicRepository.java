package com.examPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
	


}
