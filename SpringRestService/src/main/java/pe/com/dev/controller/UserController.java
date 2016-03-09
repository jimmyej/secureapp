package pe.com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.dev.constant.URIConstants;
import pe.com.dev.domain.User;
import pe.com.dev.service.UserService;

@Controller("userController")
public class UserController {
private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = URIConstants.GET_USER_BY_ID, method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable("id") int userId) {
		User result = new User();
        logger.info("Start getUserById. userId= "+userId);
        result = service.UserInfoById(userId);
        return result;
	}
	
	@RequestMapping(value = URIConstants.GET_USER_BY_NAME, method = RequestMethod.GET)
	public @ResponseBody User getUserByName(@PathVariable("name") String username) {
		User result = new User();
        logger.info("Start getUserByName. username= "+username);
        result = service.UserInfoByName(username);
        return result;
	}
	
	@RequestMapping(value = URIConstants.GET_ALL_USER, method = RequestMethod.GET)
	public @ResponseBody List<User> getAllUsers() {
		List<User> result = new ArrayList<User>();
        logger.info("Start getAllUsers. ="+result);
        result = service.UserList();
        return result;
	}
	
	@RequestMapping(value = URIConstants.CREATE_USER, method = RequestMethod.POST)
	public @ResponseBody int createUser(@RequestBody User user) {
		int result = 0;
        logger.info("Start createUser. input= "+user);
        result = service.createUser(user);
        return result;
	}
	
	@RequestMapping(value = URIConstants.UPDATE_USER, method = RequestMethod.PUT)
	public @ResponseBody int updateUser(@RequestBody User user) {
		int result = 0;
        logger.info("Start updateUser. input= "+user);
		result = service.modifyUser(user);
        return result;
	}
	
	@RequestMapping(value = URIConstants.DELETE_USER, method = RequestMethod.DELETE)
	public @ResponseBody int deleteUser(@PathVariable("id") int userId) {
		int result = 0;
		logger.info("Start deleteUser. ID= "+userId);
		result = service.removeUser(userId);
        return result;
	}
}
