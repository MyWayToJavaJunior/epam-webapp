package ua.nure.zavizionov.SummaryTask4.db.entity;

public class WagonType extends Entity {

	private static final long serialVersionUID = -6435453725527249587L;
	private String typeName;
	private Integer seats;
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Integer getSeats() {
		return seats;
	}
	public void setSeats(Integer seats) {
		this.seats = seats;
	}

}
