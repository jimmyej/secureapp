package pe.com.dev.domain;

import java.io.Serializable;

public class Permission implements Serializable {

	private static final long serialVersionUID = -9143109659003888343L;
	
	private int permissionId;
	private String permissionName;
	private String description;
	private boolean actived;
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
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
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + ", description="
				+ description + ", actived=" + actived + "]";
	}
}
