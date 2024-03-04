<%@page import="com.User.AddNotes"%>
<%@page import="com.DB.DBConnect"%>
<%@page import="com.DAO.AddNotesDAO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
UserDetails trackuser = (UserDetails) session.getAttribute("userD");
if (trackuser == null) {
	response.sendRedirect("login.jsp");
	session.setAttribute("withoutLogin", "Please Login firsr to access Notes..");

}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show notes</title>
<%@ include file="component/allcss.jsp"%>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>
	<!-- updation mssg -->
	<!-- updation success msgg -->
	<%
	String updateMsg = (String) session.getAttribute("updateSucess");
	if (updateMsg != null) {
	%>
	<div class="alert alert-success" role="alert">
		<%=updateMsg%>
	</div>
	<%
	session.removeAttribute("updateSucess");
	}
	%>
	<!-- updation unsuccess msg -->
	<%
	String updateunSucess = (String) session.getAttribute("update-unSucess");
	if (updateunSucess != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=updateunSucess%></div>
	<%
	session.removeAttribute("update-unSucess");
	}
	%>
	<!-- Deletion Msgg -->
	<%
	String deleteSuccessMsg = (String) session.getAttribute("deleteSuccess");
	if (deleteSuccessMsg != null) {
	%>
	<div class="alert alert-success" role="alert">
		<%=deleteSuccessMsg%>
	</div>
	<%
	session.removeAttribute("deleteSuccess");
	}
	%>
	<!-- updation unsuccess msg -->
	<%
	String deleteunSucess = (String) session.getAttribute("delete-unsuccess");
	if (deleteunSucess != null) {
	%>
	<div class="alert alert-danger" role="alert">
		<%=deleteunSucess%></div>
	<%
	session.removeAttribute("delete-unsuccess");
	}
	%>
	
	<div class="container">
		<div class="row p-3">
			<div class="col-md-12 ">
				<%
				if (trackuser != null) {
					AddNotesDAO ob = new AddNotesDAO(DBConnect.getConn());
					List<AddNotes> list = ob.getData(trackuser.getId());
					for (AddNotes notes : list) { // now we are able to get the details of notes
				%>
				<!-- iterate each card  -->
				<br>
				<div class="card">
					<div class="card-body">

						<h3 class="card-title text-success"><%=notes.getTitle()%></h3>
						<p><%=notes.getContent()%></p>

						<p>
							<b class="text-success">Published by</b> <b class="text-primary"><%=trackuser.getName()%></b>
						</p>
						<p>
							<b class="text-success">Published Date</b> <b
								class="text-primary"><%=notes.getPdate()%></b>

						</p>
						<div class="container">
							<a href="DeleteServlet?note_id=<%=notes.getId()%>" class="btn btn-danger">Delete</a> 
							<a href="edit.jsp?note_id=<%=notes.getId()%>" class="btn btn-primary">Edit</a>

						</div>
					</div>
				</div>
				<%
				}
				}
				%>

			</div>
		</div>
	</div>
</body>
</html>
