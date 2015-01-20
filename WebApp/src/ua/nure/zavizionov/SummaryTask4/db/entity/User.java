package ua.nure.zavizionov.SummaryTask4.db.entity;

import java.util.Date;

public class User extends Entity {

	private static final long serialVersionUID = 8583493071625618117L;
	
	private String login;
	private String password;
	private String email;
	private Role role;
	
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		String result = login;
		//TODO
		return result;
	}
	
	
	
}
