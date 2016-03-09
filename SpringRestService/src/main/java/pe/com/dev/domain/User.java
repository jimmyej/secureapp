package pe.com.dev.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	private static final long serialVersionUID = -7544084897099613715L;
	
	private int userId;
	private boolean employeeFlag;
	private String username;
	private String password;
	private String key;
	private Date createdDate;
	private String createdBy;
	private Date updatedDate;
	private String updatedBy;
	private String email;
	private boolean actived;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public boolean isEmployeeFlag() {
		return employeeFlag;
	}
	public void setEmployeeFlag(boolean employeeFlag) {
		this.employeeFlag = employeeFlag;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", employeeFlag=" + employeeFlag + ", username=" + username + ", password="
				+ password + ", key=" + key + ", createdDate=" + createdDate + ", createdBy=" + createdBy
				+ ", updatedDate=" + updatedDate + ", updatedBy=" + updatedBy + ", email=" + email + ", actived="
				+ actived + "]";
	}
}
