package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.User.UserDetails;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email);
		System.out.println(password);

		// setting the setter method in userDetails
		// creating the object of userdetails to set the setter method
		UserDetails loginuser = new UserDetails();
		loginuser.setEmail(email);
		loginuser.setPassword(password);

		UserDAO userDAO = new UserDAO(DBConnect.getConn());
		
		UserDetails user = userDAO.loginVerify(loginuser);
		
		if(user!=null) {
			HttpSession session = request.getSession();
			
			session.setAttribute("userD", user);
			
			response.sendRedirect("home.jsp");
		}else {
			HttpSession session = request.getSession();
				session.setAttribute("login-failed", "Invalid UserName and Password!");
				response.sendRedirect("login.jsp");
		}
		
		
	}

}
