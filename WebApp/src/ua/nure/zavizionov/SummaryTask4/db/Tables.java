package ua.nure.zavizionov.SummaryTask4.db;

import ua.nure.zavizionov.SummaryTask4.db.entity.*;


public enum Tables {
	
	ROLE("roles", Role.class), ROUTE("routes", Route.class), 
	ROUTE_COMPOSITION("route_compositions", RouteComposition.class),
	STATION("stations", Station.class), TRAIN("trains", Train.class), 
	USER("users", User.class), WAGON("wagons", Wagon.class), WAGON_TYPE("wagon_types", WagonType.class);
	
	private String tableName;
	private Class<? extends Entity> daoClass;
	
	Tables(String table, Class<? extends Entity> daoClass){
		this.tableName = table;
		this.daoClass = daoClass;
	}
	
	public String getTableName(){
		return tableName;
	}
	
	


}
