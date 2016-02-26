package pe.com.dev.service;

import java.util.List;

import pe.com.dev.domain.User;

public interface UserService {
	public User UserInfoById(int userId);
	public User UserInfoByName(String username);
	public List<User> UserList();
	public int createUser(User user);
	public int modifyUser(User user);
	public int removeUser(int userId);
}
