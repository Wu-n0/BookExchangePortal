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
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=response.getWriter();
		
		String userid = request.getParameter("user_id");
        String userPassword = request.getParameter("user_password");
        String option=request.getParameter("user_options");
        int admin= option.equals("1")?0:1;

        UserDao dao=new UserDao(ConnectionProvider.getConnection());

        User u = dao.getUserByUseridAndPassword(userid, userPassword);

        if (u == null) {
            //login.................
//            error///
        	out.println("Invalid Details..try again");
            Message msg = new Message("Invalid Details ! try with another", "error", "alert-danger");
            HttpSession s = request.getSession();
            s.setAttribute("msg", msg);

            response.sendRedirect("login.jsp");
        } else {
            //......
//            login success
            HttpSession s = request.getSession();
            s.setAttribute("currentUser", u);
            if(u.getAdmin()==0 && admin==0)
            	response.sendRedirect("profile.jsp");
            else if(u.getAdmin()==1 && admin==1)
            	response.sendRedirect("adminprofile.jsp");
            else
            {
            	Message msg = new Message("Invalid Details ! try with correct details", "error", "alert-danger");
                HttpSession s1 = request.getSession();
                s1.setAttribute("msg", msg);
                response.sendRedirect("login.jsp");
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
