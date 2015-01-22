package ua.nure.zavizionov.SummaryTask4.db;

public final class Fields {
	
	public static final String ID = "id";
	
	//users
	public static final String USER_LOGIN = "login";
	public static final String USER_PASSWORD = "password";
	public static final String USER_EMAIL = "email";
	public static final String USER_ROLE_ID = "role_id";
	
	//trains
	public static final String TRAIN_ROUTE_ID = "route_id";
	public static final String TRAIN_DEPARTURE_DATE = "depDate";
	public static final String TRAIN_ARRIVAL_DATE = "arrDate";
	
	//routes
	public static final String ROUTE_DEPARTURE_STATION_ID = "dep_station_id";
	public static final String ROUTE_DEPARTURE_TIME = "dep_time";
	public static final String ROUTE_ARRIVAL_STATION_ID = "arr_station_id";
	public static final String ROUTE_ARRIVAL_TIME = "arr_time";
	
	//stations
	public static final String STATION_NAME = "name";
	
	
	//roles
	public static final String ROLE_NAME = "name";
	public static final String ROLE_DESCRIPTION = "description";

	
	
	//TrainBean
	public static final String TRAIN_BEAN_DEPARTURE_STATION_NAME = "dep_station_name";
	public static final String TRAIN_BEAN_ARRIVAL_STATION_NAME = "arr_station_name";
	
}
