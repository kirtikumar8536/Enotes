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
import com.mysql.cj.xdevapi.DbDoc;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer noteid= Integer.parseInt(request.getParameter("note_id"));
		AddNotesDAO deletedao=new AddNotesDAO(DBConnect.getConn());
		boolean status = deletedao.NotesDelete(noteid);
		System.out.println(status);
		HttpSession session = request.getSession();
		if(status) {
			session.setAttribute("deleteSuccess", "Notes deletion succesfully");
			response.sendRedirect("shownotes.jsp");
		}
		else {
			session.setAttribute("delete-unsuccess", "try Again! deletetion unsuccesfull");
			response.sendRedirect("shownotes.jsp");
		}
	}


}
