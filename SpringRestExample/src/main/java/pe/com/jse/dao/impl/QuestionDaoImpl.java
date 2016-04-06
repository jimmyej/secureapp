package pe.com.jse.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.jse.dao.QuestionDao;
import pe.com.jse.model.Question;

@Repository("questionDao")
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Question getQuestion(int questionId) {
		Question response = null;
		try {
			String sql = "SELECT * FROM QUESTION WHERE QUESTION_ID = ? ";
			response = jdbcTemplate.queryForObject(sql, new Object[] { questionId }, new BeanPropertyRowMapper<Question>(Question.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	@Override
	public List<Question> getAllQuestions() {
		List<Question> response = null;
		try {
			String sql = "SELECT * FROM QUESTION";
			response = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Question>(Question.class));
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	@Override
	public int createQuestion(Question question) {
		int response = 0;
		try {
			String sql = "INSERT INTO QUESTION (SECURE_QUESTION, ACTIVED) VALUES (?,?)";
			response = jdbcTemplate.update(sql, new Object[] {question.getSecureQuestion(), question.isActived()});
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	@Override
	public int updateQuestion(Question question) {
		int response = 0;
		try {
			String sql = "UPDATE QUESTION SET SECURE_QUESTION= ? ACTIVED=? WHERE QUESTION_ID=? ";
			response = jdbcTemplate.update(sql, new Object[] {question.getSecureQuestion(), question.isActived(), question.getQuestionId()});
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

	@Override
	public int deleteQuestion(int questionId) {
		int response = 0;
		try {
			String sql = "DELETE FROM QUESTION WHERE QUESTION_ID=?";
			response = jdbcTemplate.update(sql, new Object[] {questionId});
		} catch (Exception e) {
			e.getMessage();
		}
		return response;
	}

}
