package pe.com.dev.dao;

import java.util.List;

import pe.com.dev.domain.Role;

public interface RoleDao {
	public Role getRole(int id);
	public List<Role> getAllRoles();
	public List<Role> getRolesByUser(String username);
	public int addRole(Role role);
	public int updRole(Role role);
	public int delRole(int id);
}
