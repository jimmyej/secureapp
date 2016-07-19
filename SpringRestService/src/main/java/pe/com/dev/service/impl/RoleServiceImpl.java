package pe.com.dev.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.RoleDao;
import pe.com.dev.domain.Role;
import pe.com.dev.service.RoleService;

@Repository("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao dao;
	
	@Override
	public Role RoleInfo(int roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> RoleList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> RoleListByUser(String username) {
		return dao.getRolesByUser(username);
	}

	@Override
	public int createRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifyRole(Role role) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeRole(int roleId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int createRoleByUser(String username, String rolename) {
		return dao.addRoleByUser(username, rolename);
	}

}
