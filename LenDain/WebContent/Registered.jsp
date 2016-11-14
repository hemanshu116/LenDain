<%@page import="java.util.ArrayList"%>
<%@page import="dao.AddFriend"%>
<%@page import="pojo.LoginPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Untitled</title>
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/user.css">

<script type="text/javascript">
	function functiona() {
		document.getElementById("add").style.display = "block";

	}
</script>
</head>
<%
	HttpSession hs = request.getSession(false);
	if (hs.getAttribute("login") == null) {
		request.setAttribute("error", "Not logged in. Please log in.");
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	} else {
		LoginPojo l = (LoginPojo) hs.getAttribute("login");
		String name = l.getName();
		if (request.getAttribute("message") == null) {
			request.setAttribute("message", "");
		}
%>


<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navcol-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand navbar-link" href="#">Len Dain</a>
		</div>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav navbar-right">
				<li class="active" role="presentation"><a href="#"><strong>Add
							Bill</strong></a></li>
				<li role="presentation"><a href="#"><strong>View
							All</strong></a></li>
				<li role="presentation"><a href="#"><strong>Hemanshu
					</strong> </a></li>
			</ul>
		</div>
	</div>
	</nav>
	<div>
		<heading>Welcome,Hemanshu</heading>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<h5>
					Friends <a class=""> <span class="glyphicon glyphicon-plus"
						onclick="functiona()"></span></a>

				</h5>
				<div class="col-lg-8 col-md-8">
					<form id="add" class="form" role="form" method="post"
						action="http://localhost:8083/LenDain/AddFriend"
						accept-charset="UTF-8" id="login-nav" style="display: none;">
						<div class="form-group">
							<label class="sr-only" for="emailId">Email address</label> <input
								type="email" class="form-control" id="emailId" name="emailId"
								placeholder="Email address" required>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-block"
								value="Search">
						</div>
					</form>
					<h6>Already added</h6>
					<%
						ArrayList<String> names = (ArrayList<String>) new AddFriend().getnames(l.getEmailId());
							for (int i = 0; i < names.size(); i++) {
					%>
					<div>
						<h6>
							<%=names.get(i)%>

						</h6>
					</div>
					<%
						}
					%>

				</div>


			</div>
			<div class="col-md-4">
				<h5>DashBoard</h5>
				<div></div>

			</div>
			<div class="col-md-4">
				<h5>Balance</h5>
			</div>

			`
			<%
				}
			%>
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>