<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="component/allcss.jsp"%>
<title>Register Page</title>
</head>
<body>
	<%@ include file="component/navbar.jsp"%>
	<div class="container-fluid gradient-color-register">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa-solid fa-user-plus fa-3x"></i>
						<h4>Registration</h4>
					</div>

					<%
					String successMssg = (String) session.getAttribute("RegistersuccessMsg");
					if (successMssg != null) {
					%>
					<div class="alert alert-success" role="alert">
						<%=successMssg%><a href="login.jsp">Login</a>
					</div>
					<%
					session.removeAttribute("RegistersuccessMsg");
					}
					%>


					<%
					String failMsg = (String) session.getAttribute("RegisterfailMsg");
					if (failMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=failMsg%></div>
					<%
					session.removeAttribute("RegisterfailMsg");
					}
					%>
					
					<div class="card-body">
						<form action="UserRegServlet" method="post">
							<div class="mb-3">
								<input type="text" class="form-control"
									placeholder="Enter your Name" name="name" required>
							</div>
							<div class="mb-3">
								<input type="email" class="form-control"
									placeholder="Enter your Email" name="email" required>
							</div>

							<div class="mb-3">

								<input type="password" class="form-control"
									placeholder="Enter your password" name="password" required>
							</div>
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-primary ">Register</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="component/footer.jsp"%>
</body>
</html>