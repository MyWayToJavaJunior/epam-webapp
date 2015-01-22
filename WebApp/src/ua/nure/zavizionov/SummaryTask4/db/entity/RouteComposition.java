package ua.nure.zavizionov.SummaryTask4.db.entity;

import java.util.Date;

public class RouteComposition extends Entity {
	
	//will use List<RouteComposition> instead of reference
	//to route in every object like private Route route;
	private Station station;
	private Date departureTime;
	private Integer stay;
	private Date arrivalTime;
	
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public Date getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}
	public Integer getStay() {
		return stay;
	}
	public void setStay(Integer stay) {
		this.stay = stay;
	}
	public Date getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

}
