package pe.com.dev.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.UserDao;
import pe.com.dev.domain.User;
import pe.com.dev.util.EncryptDecryptDES;
import pe.com.dev.util.KeyGenaratorUtil;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
	
	public User getUserById(int id) {
		User user = (User) getJdbcTemplate().queryForObject(getUserByIdSql(), new Object[] { id }, new BeanPropertyRowMapper<User>(User.class));
		return user;
	}
	public User getUserByName(String username){
		User user = (User) getJdbcTemplate().queryForObject(getUserByNameSql(), new Object[] { username }, new BeanPropertyRowMapper<User>(User.class));
		return user;
	}
	public List<User> getAllUsers() {
		List<User> users = (ArrayList<User>) getJdbcTemplate().query(getAllUsersSql(), new BeanPropertyRowMapper<User>(User.class));
		return users;
	}
	public int adduser(User user) {
		int result = 0;
		System.out.println("user: "+user);
		Calendar cal = Calendar.getInstance();
		user.setCreatedDate(cal.getTime());
		user.setUpdatedDate(cal.getTime());
		
		user.setKey(KeyGenaratorUtil.generateKeyUUID());
		user.setPassword(EncryptDecryptDES.encrypt(user.getPassword(), user.getKey()));
		System.out.println("user: "+user);
		
		Object[] parameters = new Object[] { 
			user.isEmployeeFlag(),
			user.getUsername(),
			user.getPassword(),
			user.getKey(),
			user.getCreatedDate(),
			user.getCreatedBy(),
			user.getUpdatedDate(),
			user.getUpdatedBy(),
			user.getEmail(),
			user.isActived()
	    };
		result = getJdbcTemplate().update(insUserSql(), parameters);
		return result;
	}
	public int updUser(User user) {
		User userInfo = getUserByName(user.getUsername());
		String params = "";
		int result = 0;
		ArrayList<Object> parameters = new ArrayList<Object>();
		
		if(user.isEmployeeFlag() != userInfo.isEmployeeFlag()){
			params = params + "EMPLOYEE_FLAG,";
			parameters.add(user.isEmployeeFlag());
		}
		if(!user.getPassword().equals(userInfo.getPassword())){
			params = params + "PASSWORD,";
			user.setPassword(EncryptDecryptDES.encrypt(user.getPassword(), user.getKey()));
			parameters.add(user.getPassword());
		}
		if(!user.getEmail().equals(userInfo.getEmail())){
			params = params + "EMAIL,";
			parameters.add(user.getEmail());
		}
		if(user.isActived() != userInfo.isActived()){
			params = params + "ACTIVED,";
			parameters.add(user.isActived());
		}
		Calendar cal = Calendar.getInstance();
		user.setUpdatedDate(cal.getTime());
		
		parameters.add(user.getUpdatedDate());
		parameters.add(user.getUpdatedBy());
		parameters.add(user.getUserId());
		
		result = getJdbcTemplate().update(updUserAllSql(params), parameters.toArray() );
		
		return result;
	}

	@Override
	public int delUser(int id) {
		int result = 0;
		result = jdbcTemplate.update(delUserSql(), new Object[] { id });
		if(result!=0)
			System.out.println("User deleted successfully.");
		else
			System.out.println("Couldn't delete User with given id as it doesn't exist");
		return result;
	}
	
	private String getUserByIdSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USER WHERE USER_ID = ?");
		return sql.toString();
	}
	private String getUserByNameSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USER WHERE USERNAME = ?");
		return sql.toString();
	}
	private String getAllUsersSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM USER");
		return sql.toString();
	}
	private String insUserSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO USER ( EMPLOYEE_FLAG, USERNAME, PASSWORD, KEY_VALUE, CREATED_DATE, CREATED_BY, UPDATED_DATE, UPDATED_BY, EMAIL, ACTIVED ) VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )");
		return sql.toString();
	}

	@SuppressWarnings("unused")
	private String updUserSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE USER SET EMPLOYEE_FLAG= ?, USERNAME= ?, PASSWORD= ?, UPDATED_DATE= ?, UPDATED_BY= ?, EMAIL= ?, ACTIVED= ? WHERE USER_ID= ?");
		return sql.toString();
	}
	private String updUserAllSql(String params){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE USER SET ");
		if(params.contains("EMPLOYEE_FLAG")){
			sql.append("EMPLOYEE_FLAG= ? , ");
		}
		if(params.contains("PASSWORD")){
			sql.append("PASSWORD= ? , ");
		}
		if(params.contains("EMAIL")){
			sql.append("EMAIL= ? , ");
		}
		if(params.contains("ACTIVED")){
			sql.append("ACTIVED= ? , ");
		}
		sql.append("UPDATED_DATE= ?, UPDATED_BY= ? WHERE USER_ID= ?");
		return sql.toString();
	}
	private String delUserSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM USER WHERE USER_ID = ?");
		return sql.toString();
	}
}
