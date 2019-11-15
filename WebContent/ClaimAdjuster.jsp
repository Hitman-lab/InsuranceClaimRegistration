<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Claim Adjuster</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
	li a:hover {
		background-color: hsl(0, 60%, 50%);;
		color: white;
	}
	.nav-link{
		color: hsl(0, 60%, 50%);
		font-weight: bold;
	}
</style>
</head>
<body>
	<div class="jumbotron">
		<h2 style="text-align: center; color: maroon;">CLAIM ADJUSTER</h2>
	</div>
	<div class="container">
		<ul class="nav nav-pills nav-justified">
			<li class="nav-item">
				<a class="nav-link" href="CreateProfile.jsp" target="iframe_a">CREATE NEW PROFILE</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" target="iframe_a" href="CreateClaim.jsp">CREATE CLAIM</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" target="iframe_a" href="#">VIEW CLAIM</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" target="iframe_a" href="#">GENERATE REPORT</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="Login.jsp">LOGOUT</a>
			</li>
		</ul>
	</div>
	<div>
		<iframe src="adjuster_iframe.htm" height="550px" width="100%"
			style="border: none;" name="iframe_a"></iframe>
	</div>
</body>
</html>