package ua.nure.zavizionov.SummaryTask4.db.entity;

public class Role extends Entity {
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String name;
	
	private String description;

}
