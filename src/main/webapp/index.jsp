<%@page import="com.DB.DBConnect"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.back-img {
	background: url("image/Enotes_login1.jpg") no-repeat;
	background-size: cover;
	width: 100%;
	height: 80vh;
}
</style>
<meta charset="ISO-8859-1">
<title>Home page</title>
<%@ include file="component/allcss.jsp"%>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>
	<%
	Connection con = DBConnect.getConn();
	System.out.println("Connection at index page"+con);
	%>

	<div class="container-fluid back-img">
		<div class="text-center">
			<h1 class="text-white">The only thing that interferes with my
				learning is my education.</h1>
			<a href="login.jsp" class="btn btn-primary"><i
				class="fa-solid fa-right-to-bracket" style="color: #38b79e;"></i>Login</a>
			<a href="register.jsp" class="btn btn-primary"><i
				class="fa-solid fa-user-plus" style="color: #38b79e;"></i>Register</a>
		</div>
	</div>
	<%@ include file="component/footer.jsp"%>

</body>
</html>