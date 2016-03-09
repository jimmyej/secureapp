package pe.com.dev.domain;

import java.io.Serializable;

public class RolePermission implements Serializable {

	private static final long serialVersionUID = -5959424203527808909L;
	
	private int roleId;
	private int permissionId;
	private boolean actived;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	@Override
	public String toString() {
		return "RolePermission [roleId=" + roleId + ", permissionId=" + permissionId + ", actived=" + actived + "]";
	}
}
