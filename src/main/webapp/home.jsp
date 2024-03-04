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
<style type="text/css">

</style>
<meta charset="ISO-8859-1">
<title>Home</title>
<%@ include file="component/allcss.jsp"%>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>
	<div class="container-fluid p-0"><!-- revome p-0 check this -->
	
		<div class="card  py-2">
			<div class="card-body text-center">
				<img alt="#" src="image/notes_logo.jpg" class="img-fluid mx-auto"/>
				<h1>START TAKING YOUR NOTES....</h1>
				<a href="addNotes.jsp" class="btn btn-outline-primary">Start here</a>

			</div>
		</div>
	</div>
	<%@ include file="component/footer.jsp"%>
</body>
</html>