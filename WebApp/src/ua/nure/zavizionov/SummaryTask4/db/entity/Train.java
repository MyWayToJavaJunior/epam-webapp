package ua.nure.zavizionov.SummaryTask4.db.entity;

import java.util.Date;
import java.util.List;

public class Train extends Entity{
	
	private static final long serialVersionUID = -3924337161584843834L;
	
	private Route route;
	private Date departureDate;
	private Date arrivalDate;
	private List<Wagon> wagons;

	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
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
	public List<Wagon> getWagons() {
		return wagons;
	}
	public void setWagons(List<Wagon> wagons) {
		this.wagons = wagons;
	}


}
