<%@page import="com.User.AddNotes"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.AddNotesDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
UserDetails trackuser = (UserDetails) session.getAttribute("userD");
if (trackuser == null) {
	session.setAttribute("withoutLogin", "Please Login firsr to access Notes..");
	response.sendRedirect("login.jsp");

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Page</title>
<%@ include file="component/allcss.jsp"%>

</head>
<body>
	<%
	//getting the note_id from the show note (check url)
	Integer note_id = Integer.parseInt(request.getParameter("note_id"));
	//creating AddnotesDAO object 
	AddNotesDAO notedao = new AddNotesDAO(DBConnect.getConn());
	//now we will send note_id to Dao function to get all the field of that id
	AddNotes note = notedao.getDataById(note_id);
	%>
	<%@ include file="component/navbar.jsp"%>

	<div class="container-fluid py-4">
		<div class="container">
			<h1 class="text-center">Add Your Notes</h1>
			<div class="card ">

				<div class="card-body ">

					<div class="row">
						<div class="col-md-12">
							<form action="NotesEditServlet" method="post">

								<input type="text" value="<%=note_id%>" name="noteid">



								<div class="mb-3">
									<label class="form-label">update Title</label> <input
										type="text" class="form-control" name="title" required
										value="<%=note.getTitle()%>">
								</div>
								<div class="mb-3">
									<label class="form-label">Update Your Notes Here</label>
									<textarea class="form-control" rows="3" name="content" required><%=note.getContent()%></textarea>
								</div>
								<div class="container text-center">
									<button type="submit" class="btn btn-primary">update</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>