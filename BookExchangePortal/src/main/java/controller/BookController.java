package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.my.entities.User;

import dao.Bookdao;
import dao.Bookdaoimpl;
import entity.Book;
import entity.RequestBook;
import entity.Transaction;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

/**
 * Servlet implementation class BookController
 */

@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Bookdao bookdao = null;
       RequestDispatcher dispatcher = null;
    public BookController() {
    	bookdao = new Bookdaoimpl();
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		 if(action == null) {
			 action ="DISPLAYBOOKS";
		 }
		 if(request.getParameter("query") != null) {
			 action ="DISPLAYBOOKS";
		 }
		 switch(action){
		 case "DISPLAYBOOKS" :
			   displayBooks(request,response);
			  break;
		 case "DELETE":
			 deleteBook(request,response);
			 break;
		 case "listbooks":
			 listbooks(request,response);
		 case "borrowedbooks":
			 borrowedbooks(request,response);
		 case "showtransactions":
			 showtransactions(request,response);
		 default :
				 listbooks(request,response);
				 break;
		 }
	}

	 
	 
	private void showtransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("currentUser");
		if(user==null)
		{
			dispatcher = request.getRequestDispatcher( "./login.jsp");
			dispatcher.forward(request, response);
		}
	 else
	 {
		 String userid = user.getId();
		 String query = request.getParameter("q");
		 ArrayList<Transaction> list =  bookdao.showalltransactions(query);
		  
		  request.setAttribute( "list",list);
		  System.out.println(list);
		   dispatcher = request.getRequestDispatcher( "/views/showtransactions.jsp");
		  dispatcher.forward(request, response);
	 }
		
	}
	private void borrowedbooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = (User) request.getSession().getAttribute("currentUser");
		if(user==null)
		{
			dispatcher = request.getRequestDispatcher( "./login.jsp");
			dispatcher.forward(request, response);
		}
	 else
	 {
		 String userid = user.getId();
		 ArrayList<RequestBook> list =  bookdao.borrowedbook(userid);
		  
		  request.setAttribute( "list",list);
		   dispatcher = request.getRequestDispatcher( "/views/borrowedbooks.jsp");
		  dispatcher.forward(request, response);
	 }
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 User user = (User) request.getSession().getAttribute("currentUser");
		 if(user==null)
			{
				dispatcher = request.getRequestDispatcher( "./login.jsp");
				dispatcher.forward(request, response);
			}
		 else
		 {
		 String userid = user.getId();
		 String title = request.getParameter( "title");
		 String author = request.getParameter( "author");
		 String publisher = request.getParameter( "publisher");
		 String year = request.getParameter( "year");
		 String edition = request.getParameter( "edition");
		 Part part = request.getPart("image");
		 String imageName = part.getSubmittedFileName();
		 String uploadpath="C:/Users/gorip/eclipse-workspace/BookExchangePortal/src/main/webapp/img/"+imageName;
		 System.out.println(part);
		 System.out.println(imageName);
		 System.out.println(uploadpath);
		 try {
			 FileOutputStream fos=new FileOutputStream(uploadpath);
			 InputStream is=part.getInputStream();
			 byte[] data=new byte[is.available()];
			 is.read(data);
			 fos.write(data);
			 fos.close();
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 
		 Book b =new Book();
		 b.setAuthor(author);
		 b.setEdition(edition);
		 b.setPublisher(publisher);
		 b.setTitle(title);
		 b.setYear(year);
		 b.setOwnerid(userid);
		 b.setImagepath(imageName);
		if(bookdao.save(b)) {
			request.setAttribute("message", "Saved Successfully");
		}else
			request.setAttribute("message", "unSaved Successfully");
	 listbooks(request,response);
		 }
	}
 public void listbooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	 User user = (User) request.getSession().getAttribute("currentUser");
	 if(user==null)
		{
			dispatcher = request.getRequestDispatcher( "./login.jsp");
			dispatcher.forward(request, response);
		}
	 else
	 {
	 String userid = user.getId();
	 
	 ArrayList<Book> list =  bookdao.get(userid);
	  
	  request.setAttribute( "list",list);
	   dispatcher = request.getRequestDispatcher( "/views/booklist.jsp");
	  dispatcher.forward(request, response);
	 }
 }
 public void deleteBook(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		// TODO Auto-generated method stub
	 String title = request.getParameter("id");
		if(bookdao.delete(title)) {
			request.setAttribute("message", "Deleted Succesfully");
		}else {
			request.setAttribute("message", "unDeleted Succesfully");
		}
		listbooks(request,response);
	}
 public void displayBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		// TODO Auto-generated method stub
	 String query = request.getParameter("query");
	 if(query == null) {
		 query ="";
	 }
		ArrayList<Book> bookposts= bookdao.getallbooks(query);
		if(bookposts !=  null) {
		request.setAttribute( "bookposts", bookposts);
		dispatcher = request.getRequestDispatcher("/views/bookposts.jsp");
		dispatcher.forward(request, response);}
		
	}
 
 
 }

