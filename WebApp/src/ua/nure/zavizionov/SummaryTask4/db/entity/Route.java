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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((arrivalStation == null) ? 0 : arrivalStation.hashCode());
		result = prime * result
				+ ((arrivalTime == null) ? 0 : arrivalTime.hashCode());
		result = prime
				* result
				+ ((departureStation == null) ? 0 : departureStation.hashCode());
		result = prime * result
				+ ((departureTime == null) ? 0 : departureTime.hashCode());
		result = prime
				* result
				+ ((routeComposition == null) ? 0 : routeComposition.hashCode());
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
		Route other = (Route) obj;
		if (arrivalStation == null) {
			if (other.arrivalStation != null)
				return false;
		} else if (!arrivalStation.equals(other.arrivalStation))
			return false;
		if (arrivalTime == null) {
			if (other.arrivalTime != null)
				return false;
		} else if (!arrivalTime.equals(other.arrivalTime))
			return false;
		if (departureStation == null) {
			if (other.departureStation != null)
				return false;
		} else if (!departureStation.equals(other.departureStation))
			return false;
		if (departureTime == null) {
			if (other.departureTime != null)
				return false;
		} else if (!departureTime.equals(other.departureTime))
			return false;
		if (routeComposition == null) {
			if (other.routeComposition != null)
				return false;
		} else if (!routeComposition.equals(other.routeComposition))
			return false;
		return true;
	}

	
}
