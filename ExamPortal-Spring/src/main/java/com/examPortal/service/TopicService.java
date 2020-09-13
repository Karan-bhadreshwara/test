package com.examPortal.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.examPortal.entity.Topic;
import com.examPortal.repo.TopicRepository;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	@Transactional
	public void getAllTopic(Model model) {
		List<Topic> allTopics = topicRepository.findAll();
		model.addAttribute("topic_list", allTopics);
	}

}
