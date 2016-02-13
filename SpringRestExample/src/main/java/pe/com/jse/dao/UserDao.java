package pe.com.jse.dao;

import java.util.List;

import pe.com.jse.model.User;

public interface UserDao {
	public User getUserInfo(int userId);
	public User getUserByName(String username);
	public List<User> getAllUsers();
	public User createUser(User user);
	public User updateUser(User user);
	public User deleteUser(int userId);
}
