package ua.nure.zavizionov.SummaryTask4.db.entity;

public class Wagon extends Entity {

	//will use List<Wagon> instead of reference
	//to train in every object like private Train train;;
	private Integer seats;
	private WagonType type;
	
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}
	public WagonType getType() {
		return type;
	}
	public void setType(WagonType type) {
		this.type = type;
	}

}
