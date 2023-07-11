package entity;

public class RequestBook {
	private int id;
   private String requesteduser;
   private String ownerid;
   private String date;
   private String place;
   private String markasdone;
   private String title;
   private String duration;
   
   
   

public String getRequesteduser() {
	return requesteduser;
}
public void setRequesteduser(String requesteduser) {
	this.requesteduser = requesteduser;
}
public String getOwnerid() {
	return ownerid;
}
public void setOwnerid(String ownerid) {
	this.ownerid = ownerid;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getPlace() {
	return place;
}
public void setPlace(String place) {
	this.place = place;
}
public String getMarkasdone() {
	return markasdone;
}
public void setMarkasdone(String markasdone) {
	this.markasdone = markasdone;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDuration() {
	return duration;
}
public void setDuration(String duration) {
	this.duration = duration;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
   
}
