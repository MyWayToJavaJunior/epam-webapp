package ua.nure.zavizionov.SummaryTask4.db.bean;


import java.util.Date;

import ua.nure.zavizionov.SummaryTask4.db.entity.Train;

public class TrainBean extends Train {

	private static final long serialVersionUID = -656952708900900389L;
	
	private Date departureTime;
	private Date arrivalTime;
	private String departureStationName;
	private String arrivalStationName;
	
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
	public String getDepartureStationName() {
		return departureStationName;
	}
	public void setDepartureStationName(String departureStationName) {
		this.departureStationName = departureStationName;
	}
	public String getArrivalStationName() {
		return arrivalStationName;
	}
	public void setArrivalStationName(String arrivalStationName) {
		this.arrivalStationName = arrivalStationName;
	}
	
	

}
