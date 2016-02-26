package pe.com.dev.domain;

import java.io.Serializable;

public class UserRole implements Serializable {

	private static final long serialVersionUID = -1654054396179168L;
	
	private int userId;
	private int roleId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
	}
}
