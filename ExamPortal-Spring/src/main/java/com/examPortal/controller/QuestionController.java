package com.examPortal.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.examPortal.service.QuestionService;
import com.examPortal.service.ResultService;
import com.examPortal.entity.UserEnt;
import com.examPortal.exceptions.NoRecordFoundException;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private ResultService resultService;

	@Autowired
	private HttpSession session;

	private Integer CurrentTopicId;

	@GetMapping(path = "/showQuestions/{topicId}")
	public ModelAndView displayQuestions(@PathVariable Integer topicId, Model model) {
		try {
			CurrentTopicId = topicId;
			questionService.getAllQuestionsByTopicId(topicId, model);
			return new ModelAndView("/quiz");
		} catch (NoRecordFoundException e) {
			model.addAttribute("message", e.getMessage());
			return new ModelAndView("error");
		}
	}

	@PostMapping(path = "/submitQuiz")
	public ModelAndView processResult(HttpServletRequest request, HttpServletResponse response, Model model) {
		Integer correct = 0;
		Integer totalQuestions = questionService.totalQuestion;
		System.out.println("totalQ" + totalQuestions);
		for (int i = 1; i <= totalQuestions; i++) {
			Integer ques_id = Integer.parseInt(request.getParameter("question" + i + "_id"));
			Integer option = Integer.parseInt(request.getParameter("question" + i + "_option"));
			if (option.equals(questionService.getCorrectAnswerByQuestionId(ques_id))) {
				correct++;
			}
		}
		System.out.println("correct" + correct);
		Integer user_id = ((UserEnt) session.getAttribute("USER")).getUserId();
		String topicName = (String) session.getAttribute("topicName");
		System.out.println(CurrentTopicId);

		resultService.addResult(user_id, topicName, CurrentTopicId, totalQuestions, correct);
		resultService.getUserResults(model);
		return new ModelAndView("/Processing");

	}
}
