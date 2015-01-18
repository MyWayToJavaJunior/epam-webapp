package ua.nure.zavizionov.SummaryTask4.db.entity;

import java.util.Date;

public class User extends Entity {

	private static final long serialVersionUID = 8583493071625618117L;
	
	private String login;
	private String password;
	private String email;
	private Integer roleId;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
