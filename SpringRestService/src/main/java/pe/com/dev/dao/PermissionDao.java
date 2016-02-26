package pe.com.dev.dao;

import java.util.List;

import pe.com.dev.domain.Permission;

public interface PermissionDao {
	public Permission getPermission(int id);
	public List<Permission> getAllPermissions();
	public int addPermission(Permission perms);
	public int updPermission(Permission perms);
	public int delPermission(int id);
}
