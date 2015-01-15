package ua.nure.zavizionov.SummaryTask4.db.dao;

public class PersistException extends Exception {

	private static final long serialVersionUID = 6910428426523184405L;

	public PersistException(String string) {
		super(string);
	}

	public PersistException(Exception e) {
		super(e);
	}

}
