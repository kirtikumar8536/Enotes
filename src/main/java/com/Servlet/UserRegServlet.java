package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.UserDAO;
import com.DB.DBConnect;
import com.User.UserDetails;

@WebServlet("/UserRegServlet")
public class UserRegServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		System.out.println(name);
		System.out.println(email);
		System.out.println(password);
		// setting the setter method in userDetails
		// creating the object of userdetails to set the setter method
		UserDetails udtls = new UserDetails();
		udtls.setName(name);
		udtls.setEmail(email);
		udtls.setPassword(password);
		// after setting the all field now we will create UserDetails object to
		// pass the udtls object ,so that our fields value are stored in database

		UserDAO userDAO = new UserDAO(DBConnect.getConn());
		boolean status = userDAO.addUser(udtls);
		
		HttpSession session = request.getSession();
		if (status) {

			session.setAttribute("RegistersuccessMsg", "Registration Succesfully...");
			// request.setAttribute("successMsg", "Registration Succesfully...");

//			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
//			rd.forward(request, response);
			response.sendRedirect("register.jsp");
		} else {

			session.setAttribute("RegisterfailMsg", "failed registration...");

			// request.setAttribute("failMsg", "failed registration...");
//			RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
//			rd.forward(request, response);
			response.sendRedirect("register.jsp");

		}

	}

}
