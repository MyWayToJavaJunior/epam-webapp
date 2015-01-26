package ua.nure.zavizionov.SummaryTask4.db;

import ua.nure.zavizionov.SummaryTask4.db.entity.User;

/**
 * Role entity.
 * 
 * @author D.Kolesnikov
 * 
 */

public enum Roles {
	ADMIN("admin", 1), USER("user", 2);
	
	private String name;
	private int id;
	
	Roles(String name, int id){
		this.name = name;
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	public int getId() {
		return id;
	}
}
