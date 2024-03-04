package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DAO.AddNotesDAO;
import com.DB.DBConnect;

@WebServlet("/NotesEditServlet")
public class NotesEditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			int noteid = Integer.parseInt(request.getParameter("noteid"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			AddNotesDAO addNotesDAO = new AddNotesDAO(DBConnect.getConn());
			boolean status = addNotesDAO.NotesUpdate(noteid, title, content);
			HttpSession Session = request.getSession();
			if (status) {
				Session.setAttribute("updateSucess", "Notes Updated Sucessfully");
				response.sendRedirect("shownotes.jsp");

				System.out.println("updation sussfully!");
			} else {
				Session.setAttribute("update-unSucess", "Try Again!");
				response.sendRedirect("shownotes.jsp");
				System.out.println("unsucc update");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
