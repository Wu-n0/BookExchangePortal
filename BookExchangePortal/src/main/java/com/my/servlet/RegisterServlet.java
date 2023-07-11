package com.my.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.my.dao.UserDao;
import com.my.entities.User;
import com.my.helper.ConnectionProvider;

/**
 * Servlet implementation class RegisterServlet
 */
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out=response.getWriter();
		
		
		String name=request.getParameter("user_name");
		String id=request.getParameter("user_id");
		String password=request.getParameter("user_password");
		String email=request.getParameter("user_email");
		String address=request.getParameter("user_address");
		String phonenumber= request.getParameter("user_number");
		String option = request.getParameter("user_options");
		int admin= option.equals("1")?0:1;
		
		User user=new User(id,name,email,password,address,phonenumber,admin);
		
		UserDao dao=new UserDao(ConnectionProvider.getConnection());
		if(dao.saveUser(user))
		{
			out.println("successful");
		}
		else
		{
			out.println(user.getId());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}
