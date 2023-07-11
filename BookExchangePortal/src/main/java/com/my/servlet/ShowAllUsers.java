package com.my.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.my.dao.UserDao;
import com.my.entities.User;
import com.my.helper.ConnectionProvider;

import entity.Book;

/**
 * Servlet implementation class ShowAllUsers
 */
public class ShowAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("currentUser");
		 String userid = user.getId();
		 UserDao dao=new UserDao(ConnectionProvider.getConnection());
		 ArrayList<User> list =  dao.getOtherUsers(userid);
		  System.out.println(list);
		  request.setAttribute( "list",list);
		   RequestDispatcher dispatcher = request.getRequestDispatcher( "showallusers.jsp");
		  dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
