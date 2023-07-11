package com.my.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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
 * Servlet implementation class ChangePasswordServlet
 */
@MultipartConfig
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
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
		String oldPassword = request.getParameter("old_password");
		String newPassword = request.getParameter("new_password");
		UserDao dao=new UserDao(ConnectionProvider.getConnection());

        User u = dao.getUserByUseridAndPassword(userid,oldPassword);
        
        if (u == null || oldPassword.equals(newPassword) ||!oldPassword.equals(user.getPassword())) {
            
            Message msg = new Message("Your password matches with oldPassword ! try new Password", "error", "alert-danger");
            HttpSession s = request.getSession();
            s.setAttribute("msg", msg);
            out.println("new page");
            response.sendRedirect("changepassword.jsp");
        }
        else
        {
        	if(dao.changepassword(userid,newPassword))
    		{
        		Message msg = new Message("Password Changed! login with new Password.", "error", "alert-success");
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
