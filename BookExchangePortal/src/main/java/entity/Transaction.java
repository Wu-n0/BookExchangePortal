package entity;

public class Transaction {
	private int id;
	private String dateadded;
	private String datetaken;
	private String givenby;
	private String takenby;
	private String title;
	private String returnduration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateadded() {
		return dateadded;
	}
	public void setDateadded(String dateadded) {
		this.dateadded = dateadded;
	}
	public String getGivenby() {
		return givenby;
	}
	public void setGivenby(String givenby) {
		this.givenby = givenby;
	}
	public String getTakenby() {
		return takenby;
	}
	public void setTakenby(String takenby) {
		this.takenby = takenby;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDatetaken() {
		return datetaken;
	}
	public void setDatetaken(String datetaken) {
		this.datetaken = datetaken;
	}
	public String getReturnduration() {
		return returnduration;
	}
	public void setReturnduration(String returnduration) {
		this.returnduration = returnduration;
	}
	
	
}
