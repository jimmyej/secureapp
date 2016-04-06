package pe.com.jse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.jse.constants.URIConstants;
import pe.com.jse.dao.QuestionDao;
import pe.com.jse.model.Question;

@Controller
public class QuestionController {
	
	@Autowired
	private QuestionDao questionDao;
	
	@RequestMapping(value = URIConstants.GET_ALL_QUESTION, method = RequestMethod.GET)
	public @ResponseBody Question getUserInfo(@PathVariable("questionId") int questionId) {
		Question user = questionDao.getQuestion(questionId);
		return user;
	}

	@RequestMapping(value = URIConstants.GET_ALL_QUESTION, method = RequestMethod.GET)
	public @ResponseBody List<Question> getAllUsers() {
		List<Question> users = questionDao.getAllQuestions();
		return users;
	}

	@RequestMapping(value = URIConstants.CREATE_QUESTION, method = RequestMethod.POST)	
	public @ResponseBody int createUser(@RequestBody Question question) {
		int response = questionDao.createQuestion(question);
		return response	;
	}

	@RequestMapping(value = URIConstants.UPDATE_QUESTION, method = RequestMethod.PUT)
	public @ResponseBody int updateUser(@RequestBody Question question) {
		int response = questionDao.updateQuestion(question);
		return response;
	}

	@RequestMapping(value = URIConstants.DELETE_QUESTION, method = RequestMethod.DELETE)
	public @ResponseBody int deleteUser(@PathVariable("questionId") int questionId) {
		int response = questionDao.deleteQuestion(questionId);
		return response;
	}
}
