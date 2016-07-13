package pe.com.dev.service;

import java.util.List;

import pe.com.dev.domain.Role;

public interface RoleService {
	public Role RoleInfo(int roleId);
	public List<Role> RoleList();
	public List<Role> RoleListByUser(String username);
	public int createRole(Role role);
	public int modifyRole(Role role);
	public int removeRole(int roleId);
}
