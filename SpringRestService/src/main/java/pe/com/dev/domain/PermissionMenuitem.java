package pe.com.dev.domain;

import java.io.Serializable;

public class PermissionMenuitem implements Serializable {

	private static final long serialVersionUID = 4295082209004748803L;
	
	private int permissionId;
	private int itemId;
	public int getPermissionId() {
		return permissionId;
	}
	public void setPermissionId(int permissionId) {
		this.permissionId = permissionId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Override
	public String toString() {
		return "PermissionMenuitem [permissionId=" + permissionId + ", itemId=" + itemId + "]";
	}
}
