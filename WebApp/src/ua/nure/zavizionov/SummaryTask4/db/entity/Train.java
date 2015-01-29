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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result
				+ ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((route == null) ? 0 : route.hashCode());
		result = prime * result + ((wagons == null) ? 0 : wagons.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Train other = (Train) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (route == null) {
			if (other.route != null)
				return false;
		} else if (!route.equals(other.route))
			return false;
		if (wagons == null) {
			if (other.wagons != null)
				return false;
		} else if (!wagons.equals(other.wagons))
			return false;
		return true;
	}

	
	

}
