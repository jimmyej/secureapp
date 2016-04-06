package pe.com.jse.dao;

import java.util.List;

import pe.com.jse.model.Question;

public interface QuestionDao {
	public Question getQuestion(int questionId);
	public List<Question> getAllQuestions();
	public int createQuestion(Question question);
	public int updateQuestion(Question question);
	public int deleteQuestion(int questionId);
}
