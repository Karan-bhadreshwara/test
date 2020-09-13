package com.examPortal.service;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.examPortal.entity.Question;
import com.examPortal.exceptions.NoRecordFoundException;
import com.examPortal.repo.QuestionRepository;
import com.examPortal.repo.TopicRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private HttpSession session;

	public Integer totalQuestion;


	public void getAllQuestionsByTopicId(Integer topicId, Model model) throws NoRecordFoundException {

		String topicName = topicRepository.findById(topicId).orElseThrow(
				() -> new NoRecordFoundException("UNABLE TO FIND SELECTED TOPIC :(   PLEASE TRY WITH ANOTHER TOPIC"))
				.getName();
		List<Question> allQuestions = questionRepository.findAllByTopicId(topicId);
		if (allQuestions.size() < 1) {
			throw new NoRecordFoundException(
					"UNABLE TO FIND QUESTIONS OF SELECTED TOPIC :( " + "  PLEASE TRY WITH ANOTHER TOPIC");
		}
		Collections.shuffle(allQuestions);
		totalQuestion = allQuestions.size();
		model.addAttribute("quiz_list", allQuestions);
		model.addAttribute("topic_name", topicName);
		session.setAttribute("topicName", topicName);

	}

	
	public Integer getCorrectAnswerByQuestionId(Integer ques_id) {
		return questionRepository.findById(ques_id).orElse(null).getCorrect_answer();

	}

}
