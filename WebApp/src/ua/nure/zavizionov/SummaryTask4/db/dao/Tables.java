package ua.nure.zavizionov.SummaryTask4.db.dao;

public enum Tables {
	
	ROLE("roles"), ROUTE("routes"), ROUTE_COMPOSITION("route_compositions"),
	STATION("stations"), TRAIN("trains"), USER("users"), WAGON("wagons"), WAGON_TYPE("wagon_types");
	
	private String tableName;
	
	Tables(String table){
		this.tableName = table;		
	}
	
	public String getTableName(){
		return tableName;
	}


}
