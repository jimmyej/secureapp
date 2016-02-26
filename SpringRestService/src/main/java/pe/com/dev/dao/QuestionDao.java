package pe.com.dev.dao;

import java.util.List;

import pe.com.dev.domain.Question;

public interface QuestionDao {
	public Question getQuestion(int id);
	public List<Question> getAllQuestions();
	public int addQuestion(Question question);
	public int updQuestion(Question question);
	public int delQuestion(int id);
}
