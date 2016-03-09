package pe.com.dev.domain;

import java.io.Serializable;

public class Role implements Serializable {

	private static final long serialVersionUID = -2338883345711438503L;
	
	private int roleId;
	private String roleName;
	private String description;
	private boolean actived;
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + ", actived="
				+ actived + "]";
	}
}
