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
						<i class="fa-solid fa-right-to-bracket" style="color: #38b79e;"></i>
						<h4>Login page</h4>
					</div>
					<!-- check the  -->
					<%
					String failedMssg = (String) session.getAttribute("login-failed");
					if (failedMssg != null) {
					%>
					<div class="alert alert-danger" role="alert">
						<%=failedMssg%>
					</div>
					<%
					session.removeAttribute("login-failed");
					}
					%>
					<!--  -->
					<%
					String withoutLogin = (String) session.getAttribute("withoutLogin");
					if (withoutLogin != null) {
					%>
					<div class="alert alert-danger" role="alert">
						<%=withoutLogin%></div>
					<%
					session.removeAttribute("withoutLogin");
					}
					%>
					<!-- logout successfully msg -->
					<%
					HttpSession session2 = request.getSession();
					
					String logoutMsg = (String) session2.getAttribute("logoutMsg");
					if (logoutMsg != null) {
					%>
					<div class="alert alert-success" role="alert">
						<%=logoutMsg%></div>
					<%
					session2.removeAttribute("logoutMsg");
					session2.invalidate(); 
					}
					%>
					

					<div class="card-body">

						<form action="LoginServlet" method="post">

							<div class="mb-3">
								<input type="email" class="form-control"
									placeholder="Enter your Email" name="email" required>
							</div>

							<div class="mb-3">
								<input type="password" class="form-control" required
									placeholder="Enter your password" name="password">
							</div>
							<div class="d-grid gap-2">
								<button type="submit" class="btn btn-primary ">Login</button>
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