package pe.com.jse.snippets;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.com.jse.model.User;

@SuppressWarnings("rawtypes")
public class UserRowMapper implements RowMapper{
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setUserId(rs.getInt("USER_ID"));
		user.setEmployeeFlag(rs.getBoolean("EMPLOYEE_FLAG"));
		user.setUsername(rs.getString("USERNAME"));
		user.setPassword(rs.getString("PASSWORD"));
		user.setKey(rs.getString("KEY"));
		user.setCreatedDate(rs.getDate("CREATED_DATE"));
		user.setCreatedBy(rs.getString("CREATED_BY"));
		user.setUpdatedDate(rs.getDate("UPDATED_DATE"));
		user.setUpdatedBy(rs.getString("UPDATED_BY"));
		user.setEmail(rs.getString("EMAIL"));
		user.setActived(rs.getBoolean("ACTIVED"));
		return user;
	}
}
