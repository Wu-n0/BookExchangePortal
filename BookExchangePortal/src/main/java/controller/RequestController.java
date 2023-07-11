package controller;

import java.io.IOException;
import java.util.ArrayList;

import com.my.entities.User;

import dao.Requestdao;
import dao.Requestdaoimpl;
import entity.Book;
import entity.RequestBook;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestController
 */
@WebServlet("/RequestController")
public class RequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Requestdao requestdao =null;
       BookController bookcontroller=null;
       RequestDispatcher dispatcher = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestController() {
         requestdao = new Requestdaoimpl();
         bookcontroller = new BookController();
         
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		 if(action == null) {
			 action ="addrequest";
		 }
		 switch(action){
		 case "addrequest" :
			  	addrequest(request,response);
			  break;
		 case "deleterequest":
			 deleterequest(request,response);
		 case "acceptrequests":
			 acceptrequests(request,response);
		 case "acceptrequest":
			 acceptrequest(request,response);
			 break;
		 case "rejectrequest":
			 rejectrequest(request,response);
		 case "listrequest":
		 	listrequest(request,response);
		 case "returnbook":
			 returnbook(request,response);
//		 default :
//			 	
//				 break;
		 }
		
		
	}

	private void returnbook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		if(requestdao.returnbook(id)) {
			request.setAttribute("message", "Returned Succesfully");
		}else {
			request.setAttribute("message", "Returned UnSuccesfully");
		}
		
		dispatcher = request.getRequestDispatcher( "/BookController?action=borrowedbooks");
		  dispatcher.forward(request, response);
		
	}

	private void rejectrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		if(requestdao.rejectrequest(id)) {
			request.setAttribute("message", "Rejected Succesfully");
		}else {
			request.setAttribute("message", "Rejected UnSuccesfully");
		}
		acceptrequests(request,response);
		
	}

	public void acceptrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		if(requestdao.acceptrequest(id)) {
			request.setAttribute("message", "Accepted Succesfully");
		}else {
			request.setAttribute("message", "Accepted UnSuccesfully");
		}
		acceptrequests(request,response);
		
	}

	public void acceptrequests(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("currentUser");
		if(user==null)
		{
			dispatcher = request.getRequestDispatcher( "./login.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
		 String userid = user.getId();
		 System.out.println(userid);
		 ArrayList<RequestBook> list =  requestdao.acceptrequests(userid);
		 System.out.println(list);
		 request.setAttribute( "list",list);
		  System.out.println(list);
		   dispatcher = request.getRequestDispatcher( "/views/requestsaccept.jsp");
		  dispatcher.forward(request, response);
		}
	}

	public void deleterequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		if(requestdao.deleterequest(id)) {
			request.setAttribute("message", "Deleted Succesfully");
		}else {
			request.setAttribute("message", "unDeleted Succesfully");
		}
		listrequest(request,response);
		
	}

	public void addrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User user = (User) request.getSession().getAttribute("currentUser");
		 if(user==null)
			{
				dispatcher = request.getRequestDispatcher( "./login.jsp");
				dispatcher.forward(request, response);
			}
		 else
		 {
		 String requesteduser = user.getId();
		 
		 String date = request.getParameter( "date");
		 String place = request.getParameter( "place");
		 String title = request.getParameter("title");
		 String duration=request.getParameter("duration");
		 String markasdone="1";
		 RequestBook r =new RequestBook();
		 r.setDate(date);
		 r.setMarkasdone(markasdone);
		 r.setPlace(place);
		 r.setRequesteduser(requesteduser);
		 r.setTitle(title);
		 r.setDuration(duration);
		 if(requestdao.addrequest(r)) {
			 request.setAttribute("message", "Requested Successfully");
	    }else {
	    	request.setAttribute("message", "Requested UnSuccessfully");
	    }
		listrequest(request, response); 
		 }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	 public void listrequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User user = (User) request.getSession().getAttribute("currentUser");
		 if(user==null)
			{
				dispatcher = request.getRequestDispatcher( "./login.jsp");
				dispatcher.forward(request, response);
			}
		 else
		 {
		 String userid = user.getId();
		 System.out.println(userid);
		 ArrayList<RequestBook> list =  requestdao.myrequests(userid);
		  
		  request.setAttribute( "list",list);
		  System.out.println(list);
		   dispatcher = request.getRequestDispatcher( "/views/requestssent.jsp");
		  dispatcher.forward(request, response);
		 }
	 }

}
