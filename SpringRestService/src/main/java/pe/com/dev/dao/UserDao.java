package pe.com.dev.dao;

import java.util.List;

import pe.com.dev.domain.User;

public interface UserDao {
	public User getUserById(int id);
	public User getUserByName(String username);
	public List<User> getAllUsers();
	public int adduser(User user);
	public int updUser(User user);
	public int delUser(int id);
}
