package pe.com.jse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.jse.constants.URIConstants;
import pe.com.jse.dao.UserDao;
import pe.com.jse.model.User;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;

	@RequestMapping(value = URIConstants.GET_USER, method = RequestMethod.GET)
	public @ResponseBody User getUserInfo(@PathVariable("userId") int userId) {
		User user = userDao.getUserInfo(userId);
		return user;
	}

	@RequestMapping(value = URIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return users;
	}

	@RequestMapping(value = URIConstants.CREATE_USER, method = RequestMethod.POST)	
	public @ResponseBody User createUser(@RequestBody User user) {
		User userResponse = userDao.createUser(user);
		return userResponse	;
	}

	@RequestMapping(value = URIConstants.UPDATE_USER, method = RequestMethod.PUT)
	public @ResponseBody User updateUser(@RequestBody User user) {
		User userResponse = userDao.updateUser(user);
		return userResponse;
	}

	@RequestMapping(value = URIConstants.DELETE_USER, method = RequestMethod.DELETE)
	public @ResponseBody User deleteUser(@PathVariable("userId") int userId) {
		User userResponse = userDao.deleteUser(userId);
		return userResponse;
	}
}
