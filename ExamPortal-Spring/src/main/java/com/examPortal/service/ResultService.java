package com.examPortal.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.examPortal.entity.Result;
import com.examPortal.entity.UserEnt;
import com.examPortal.repo.ResultRepository;

@Service
public class ResultService {

	@Autowired
	private HttpSession session;

	@Autowired
	private ResultRepository resultRepository;

	@Transactional
	public void getUserResults(Model model) {
		Integer score = 0;
		Integer userId = ((UserEnt) session.getAttribute("USER")).getUserId();
		System.out.println(userId);
		List<Result> userResults = resultRepository.findAllByUserId(userId);
		for (Result result : userResults) {
			score += result.getNo_of_correct_question();
		}
		model.addAttribute("average_score", (float) (score * 10) / userResults.size());
		model.addAttribute("total_quiz", userResults.size());
		model.addAttribute("resultset", userResults);
	}

	@Transactional
	public void addResult(Integer user_id, String topicName, Integer currentTopicId, Integer totalQuestions,
			Integer correct) {
		System.out.println("saving result");
		Result result = new Result();
		result.setUser_id(user_id);
		result.setCreated_at(new Date());
		result.setNo_of_correct_question(correct);
		result.setNo_of_question(totalQuestions);
		result.setTopic_id(currentTopicId);
		result.setTopic_name(topicName);
		resultRepository.save(result);

	}

}
