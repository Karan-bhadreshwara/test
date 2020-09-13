package com.examPortal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.examPortal.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@GetMapping(path = "/getTopic")
	public ModelAndView getAllTopics(Model model) {
		topicService.getAllTopic(model);
		return new ModelAndView("/select_topic");
	}

}
