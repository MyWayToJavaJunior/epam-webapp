package ua.nure.zavizionov.SummaryTask4.db;

public interface Fields {
	
	String ID = "id";
	
	//users
	String USER_LOGIN = "login";
	String USER_PASSWORD = "password";
	String USER_EMAIL = "email";
	String USER_ROLE_ID = "role_id";
	
	//trains
	String TRAIN_ROUTE_ID = "route_id";
	String TRAIN_DEPARTURE_DATE = "depDate";
	String TRAIN_ARRIVAL_DATE = "arrDate";
	
	//routes
	String ROUTE_DEPARTURE_STATION_ID = "dep_station_id";
	String ROUTE_DEPARTURE_TIME = "dep_time";
	String ROUTE_ARRIVAL_STATION_ID = "arr_station_id";
	String ROUTE_ARRIVAL_TIME = "arr_time";
	
	//routes composition
	String ROUTE_COMPOSITION_ROUTE_ID = "route_id";
	String ROUTE_COMPOSITION_ARRIVAL_TIME = "arr_time";
	String ROUTE_COMPOSITION_DEPARTURE_TIME = "dep_time";
	String ROUTE_COMPOSITION_STAY = "stay";
	String ROUTE_COMPOSITION_STATION_ID = "station_id";
	
	//wagons
	String WAGON_SEATS = "seats";
	String WAGON_TYPE_ID = "type_id";
	String WAGON_TRAIN_ID = "train_id";
	String WAGON_NUMBER = "number";

	
	//wagon_types
	String WAGON_TYPE_NAME = "type_name";
	String WAGON_TYPE_SEATS = "seats";
	
	//stations
	String STATION_NAME = "name";
	
	
	//roles
	String ROLE_NAME = "name";
	String ROLE_DESCRIPTION = "description";

	
	
	//TrainBean
	String TRAIN_BEAN_DEPARTURE_STATION_NAME = "dep_station_name";
	String TRAIN_BEAN_ARRIVAL_STATION_NAME = "arr_station_name";
	
}
