package pe.com.jse.snippets;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.jse.model.Question;

public class QuestionRowMapper implements RowMapper<Question>{
	
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question question = new Question();
		question.setQuestionId(rs.getInt("QUESTION_ID"));
		question.setSecureQuestion(rs.getString("SECURE_QUESTION"));
		question.setActived(rs.getBoolean("ACTIVED"));
		return question;
	}

}
