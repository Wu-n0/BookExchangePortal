package dao;



import entity.RequestBook;
import java.util.ArrayList;
public interface Requestdao {
    ArrayList<RequestBook> requestlist(String requesteduser);
    boolean addrequest(RequestBook r);
	boolean deleterequest(int id);
	ArrayList<RequestBook> myrequests(String userid);
	ArrayList<RequestBook> acceptrequests(String userid);
	boolean acceptrequest(int id);
	boolean rejectrequest(int id);
	boolean returnbook(int id);
    
}
