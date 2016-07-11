package pe.com.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.UserDao;
import pe.com.dev.domain.User;
import pe.com.dev.service.UserService;

@Repository("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	public User UserInfoById(int userId) {
		return dao.getUserById(userId);
	}
	public User UserInfoByName(String username) {
		return dao.getUserByName(username);
	}
	public List<User> UserList() {
		return dao.getAllUsers();
	}
	public int createUser(User user) {
		return dao.adduser(user);
	}
	public int modifyUser(User user) {
		return dao.updUser(user);
	}
	public int removeUser(int userId) {
		return dao.delUser(userId);
	}

}
