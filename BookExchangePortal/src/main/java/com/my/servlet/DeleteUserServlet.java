package com.my.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.my.dao.UserDao;
import com.my.entities.Message;
import com.my.entities.User;
import com.my.helper.ConnectionProvider;

/**
 * Servlet implementation class DeleteUserServlet
 */
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		User user = (User) request.getSession().getAttribute("currentUser");
		String userid = user.getId();
		String password=user.getPassword();
		
		
		UserDao dao=new UserDao(ConnectionProvider.getConnection());

        User u = dao.getUserByUseridAndPassword(userid,password);
        if (u == null) {
            
            Message msg = new Message("Something! went Wrong.....", "error", "alert-danger");
            HttpSession s = request.getSession();
            s.setAttribute("msg", msg);
            out.println("new page");
            response.sendRedirect("login.jsp");
        }
        else
        {
        	if(dao.DeleteUser(userid))
    		{
        		Message msg = new Message("Account Deleted! login with another Account.", "error", "alert-success");
                HttpSession s1 = request.getSession();
                s1.setAttribute("msg", msg);
                response.sendRedirect("login.jsp");
    		}
    		else
    		{
    			out.println(u.getId());
    		}
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
