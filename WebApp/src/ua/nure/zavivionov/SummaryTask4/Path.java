package ua.nure.zavivionov.SummaryTask4;

public interface Path {
	
	String ERROR_PAGE = "/WEB-INF/jsp/error_page.jsp";
	String LOGIN_PAGE = "login.jsp";
	String WELCOME_PAGE = "index.jsp";
	String LIST_TRAINS_PAGE = "/WEB-INF/jsp/all/list_trains.jsp";
	String LIST_ROUTES_PAGE = "/WEB-INF/jsp/all/list_routes.jsp";
	
	String ADD_STATION_PAGE = "/WEB-INF/jsp/admin/add_station.jsp";
	
	String ADD_STATION_COMMAND = "controller?command=addStation";
	
	String LIST_TRAINS_COMMAND = "controller?command=listTrains";
	String LIST_ROUTES_COMMAND = "controller?command=listRoutes";
	String LIST_ROUTE_COMMAND = "controller?command=listRoute";
	
}
