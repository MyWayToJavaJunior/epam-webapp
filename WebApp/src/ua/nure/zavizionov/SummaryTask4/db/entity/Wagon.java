package ua.nure.zavizionov.SummaryTask4.db.entity;

public class Wagon extends Entity {

	//will use List<Wagon> instead of reference
	//to train in every object like private Train train;;
	//but need to store trainId for some DB operations
	private int trainId;
	private Integer seats;
	private WagonType type;
	private int number;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
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
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}

}
