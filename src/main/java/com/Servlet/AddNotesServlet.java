package com.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.AddNotesDAO;
import com.DB.DBConnect;
import com.User.AddNotes;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int uid = Integer.parseInt(request.getParameter("uid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		AddNotesDAO dao = new AddNotesDAO(DBConnect.getConn());
		boolean addNoteStatus = dao.AddNotes(title, content, uid);
		System.out.println("Add notes status" + addNoteStatus);
		if (addNoteStatus) {

			System.out.println("notes added succesfully!");
			response.sendRedirect("shownotes.jsp");
		} else {
			System.out.println("somthing went wrong!");
		}

	}

}
