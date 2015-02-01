package ua.nure.zavizionov.SummaryTask4.db.entity;

public class Wagon extends Entity {

	//will use List<Wagon> instead of reference
	//to train in every object like private Train train;;
	//but need to store trainId for some DB operations
	private int trainId;
	private Integer seats;
	private WagonType type;
	private int number;
	private double ticketPrice;
	
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + number;
		result = prime * result + ((seats == null) ? 0 : seats.hashCode());
		result = prime * result + trainId;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Wagon other = (Wagon) obj;
		if (number != other.number)
			return false;
		if (seats == null) {
			if (other.seats != null)
				return false;
		} else if (!seats.equals(other.seats))
			return false;
		if (trainId != other.trainId)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double price) {
		this.ticketPrice = price;
	}


	
	
}
