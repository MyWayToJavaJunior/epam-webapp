package ua.nure.zavizionov.SummaryTask4.db;

import ua.nure.zavizionov.SummaryTask4.db.entity.User;

/**
 * Role entity.
 * 
 * @author D.Kolesnikov
 * 
 */

public enum Role {
	ADMIN("admin"), USER("user");
	
	private String name;
	
	Role(String name){
		this.name = name;
	}
	
	
	public String getName() {
		return name;
	}
	
}
