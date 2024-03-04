package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
//			if(session!=null) {
//				//
//				session.removeAttribute("userd");
//				
//				//HttpSession session2 = request.getSession();
//				//session2.setAttribute("logoutMsg", "succesfully logout");
//				session.setAttribute("logoutMsg", "succesfully logout");
//				response.sendRedirect("login.jsp");
//				
//				
//			}
//			else {
//				//if user directly hit the logout button
//				response.sendRedirect("index.jsp");
//			}
			session.removeAttribute("userd");
			session.invalidate();
			
			//creating new session 
			HttpSession session2 = request.getSession(true);
			session2.setAttribute("logoutMsg", "succesfully logout");
			response.sendRedirect("login.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
