package ua.nure.zavizionov.SummaryTask4.db.entity;

import java.util.Date;
import java.util.List;

public class Route extends Entity {
	
	private static final long serialVersionUID = -6867499550319904833L;
	private Station departureStation;
	private Station arrivalStation;
	private Date departureTime;
	private Date arrivalTime;
	private List<RouteComposition> routeComposition;
	
	public Station getDepartureStation() {
		return departureStation;
	}
	public void setDepartureStation(Station departureStation) {
		this.departureStation = departureStation;
	}
	public Station getArrivalStation() {
		return arrivalStation;
	}
	public void setArrivalStation(Station arrivalStation) {
		this.arrivalStation = arrivalStation;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public List<RouteComposition> getRouteComposition() {
		return routeComposition;
	}
	public void setRouteComposition(List<RouteComposition> routeComposition) {
		this.routeComposition = routeComposition;
	}

}
