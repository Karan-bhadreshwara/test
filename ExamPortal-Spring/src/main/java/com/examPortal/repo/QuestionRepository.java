package com.examPortal.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examPortal.entity.Question;


public interface QuestionRepository extends JpaRepository<Question, Integer> {
	
	List<Question> findAllByTopicId(Integer topicId);


}
