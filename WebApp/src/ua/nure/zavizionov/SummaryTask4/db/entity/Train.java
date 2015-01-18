package ua.nure.zavizionov.SummaryTask4.db.entity;

import java.util.Date;

public class Train extends Entity{
	
	private static final long serialVersionUID = -3924337161584843834L;
	
	private Integer routeId;
	private Date departureDate;
	private Date arrivalDate;
	

	public Integer getRouteId() {
		return routeId;
	}
	public void setRouteId(Integer routeId) {
		this.routeId = routeId;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getArrivalDate() {
		return arrivalDate;
	}
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


}
