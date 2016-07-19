package pe.com.dev.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.dev.constant.URIConstants;
import pe.com.dev.domain.Role;
import pe.com.dev.service.RoleService;

@Controller("roleController")
public class RoleController {
	@Autowired
	RoleService service;

	@RequestMapping(value = URIConstants.GET_ROLES_BY_USER, method = RequestMethod.GET)
	public @ResponseBody List<Role> getRolesByName(@PathVariable("name") String username) {
		List<Role> result = new ArrayList<Role>();
        result = service.RoleListByUser(username);
        return result;
	}
	@RequestMapping(value = URIConstants.ADD_ROLE_BY_ID, method = RequestMethod.GET)
	public @ResponseBody int addRoleByUser(@PathVariable("username") String username, @PathVariable("rolename") String rolename) { 
        return service.createRoleByUser(username, rolename);
	}
}
