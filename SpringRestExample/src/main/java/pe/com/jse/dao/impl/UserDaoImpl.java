package pe.com.jse.dao.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

//import org.apache.log4j.BasicConfigurator;
//import org.apache.log4j.LogManager;
//import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.jse.dao.UserDao;
import pe.com.jse.model.User;
import pe.com.jse.snippets.UserRowMapper;
import pe.com.jse.util.DateUtil;
import pe.com.jse.util.EncryptDecryptAES;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	//private static final Logger logger = LogManager.getLogger(UserDaoImpl.class);//LogManager.getRootLogger();//
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Value( "${jdbc.database}" )
	private String database;


	public String getTable(String tableName){
		String motordb = database;//"postgresql";
		String schema = "public";
		if("postgresql".equals(motordb)){
			tableName = "\""+schema+"\".\""+tableName+"\"";
		}
		return tableName;
	}
	
	@Override
	public User getUserInfo(int userId) {
		//logger.info("Method: "+"getUserInfo");
		//logger.info("Input: "+"userId= "+userId);
		
		String sql = "SELECT * FROM "+getTable("USER")+" WHERE "+"\""+"USER_ID"+"\""+" = ?";
        User user = (User) jdbcTemplate.queryForObject(sql, new Object[] { userId }, new UserRowMapper());
        
        //logger.info("Output: "+"getUserInfo");
		return user;
	}
	
	@Override
	public User getUserByName(String username) {
		//logger.info("Method: "+"getUserByName");
		//logger.info("Input: "+"username= "+username);
		
		String sql = "SELECT * FROM "+getTable("USER")+" WHERE "+"\""+"USERNAME"+"\""+" = ?";
        User user = (User) jdbcTemplate.queryForObject(sql, new Object[] { username }, new UserRowMapper());
        
        //logger.info("Output: "+"getUserByName");
		return user;
	}
	
	@Override
	public List<User> getAllUsers() {
		//BasicConfigurator.configure();
		//logger.info("Method: "+"getUserInfo");
		//logger.info("Input: ");
		
		String sql = "SELECT * FROM "+getTable("USER");
        List<User> users = new ArrayList<User>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
			User user = new User();
			user.setUserId(Integer.parseInt(String.valueOf(row.get("USER_ID"))));
			user.setEmployeeFlag(Boolean.parseBoolean(String.valueOf("EMPLOYEE_FLAG")));
			user.setUsername(row.get("USERNAME").toString());
			user.setPassword(row.get("PASSWORD").toString());
			user.setKey(row.get("KEY_VALUE").toString());
			user.setCreatedDate(DateUtil.convertStringToDate(row.get("CREATED_DATE").toString()));
			user.setCreatedBy(row.get("CREATED_BY").toString());
			user.setUpdatedDate(DateUtil.convertStringToDate(row.get("UPDATED_DATE").toString()));
			user.setUpdatedBy(row.get("UPDATED_BY").toString());
			user.setEmail(row.get("EMAIL").toString());
			user.setActived(Boolean.parseBoolean(String.valueOf("ACTIVED")));
			users.add(user);
		}
        //logger.info("Output: "+users);
		return users;
	}

	@Override
	public User createUser(User user) {
		//logger.info("Method: "+"getUserInfo");
		//logger.info("Input: "+user);
		
        String sql = "INSERT INTO "+getTable("USER")+" (EMPLOYEE_FLAG, USERNAME, PASSWORD, KEY_VALUE, CREATED_DATE, CREATED_BY, UPDATED_DATE, UPDATED_BY, EMAIL, ACTIVED) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
        Calendar cal = Calendar.getInstance();
        user.setCreatedDate(cal.getTime());
        user.setUpdatedDate(cal.getTime());
        
        String key = EncryptDecryptAES.generateKeyAlphaNumeric();
        user.setKey(key);
        user.setPassword(EncryptDecryptAES.encrypt(user.getPassword(), user.getKey()));
        
        jdbcTemplate.update(sql, new Object[] { user.isEmployeeFlag(), user.getUsername(), user.getPassword(), user.getKey(),
    		user.getCreatedDate(), user.getCreatedBy(), user.getUpdatedDate(), user.getUpdatedBy(), user.getEmail(), user.isActived()
        });
        
        //logger.info("Output: "+user);
		return user;
	}

	@Override
	public User updateUser(User user) {
		//logger.info("Method: "+"getUserInfo");
		//logger.info("Input: "+user);

		Calendar cal = Calendar.getInstance();
        user.setUpdatedDate(cal.getTime());
        
        User userInfo = getUserInfo(user.getUserId());
        String oldPassword = EncryptDecryptAES.decrypt(userInfo.getPassword(), userInfo.getKey());
        if(!user.getPassword().equals(oldPassword)){
        	user.setPassword(EncryptDecryptAES.encrypt(user.getPassword(), userInfo.getKey()));
        } else {
        	user.setPassword(userInfo.getPassword());
        }
        
		String sql = "UPDATE "+getTable("USER")+" SET " +
	            "EMPLOYEE_FLAG=?, USERNAME=?, PASSWORD=?, UPDATED_DATE=?, UPDATED_BY=?, EMAIL=?, ACTIVED=? WHERE "+"\""+"USER_ID"+"\""+" =?";

		jdbcTemplate.update(sql, new Object[] { user.isEmployeeFlag(), user.getUsername(), user.getPassword(),
    		user.getUpdatedDate(), user.getUpdatedBy(), user.getEmail(), user.isActived(), user.getUserId()
        });
		
		//logger.info("Output: "+user);
		return user;
	}

	@Override
	public User deleteUser(int userId) {
		//logger.info("Method: "+"getUserInfo");
		//logger.info("Input: "+"userId= "+userId);
		
		String sql = "DELETE FROM "+getTable("USER")+" WHERE "+"\""+"USER_ID"+"\""+" =?";
		int row = jdbcTemplate.update(sql, new Object[] { userId });
		
		//logger.info("Output: "+row);
		return null;
	}



}
