<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insured</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<style type="text/css">
li a:hover {
	background-color: hsl(0, 60%, 50%);;
	color: white;
}

.nav-link {
	color: hsl(0, 60%, 50%);
	font-weight: bold;
}
</style>
</head>
<body>
	<div class="jumbotron">
		<h2 style="text-align: center; color: maroon;">INSURED</h2>
	</div>
	<div class="container">
		<ul class="nav nav-pills nav-justified">
			<li class="nav-item"><a class="nav-link" target="claim_ab"
				href="ViewPolicyClaim.jsp?usrName=${param.userName }">VIEW
					POLICY</a></li>
			<li class="nav-item"><a class="nav-link" target="claim_ab"
				href="ViewInsuredClaim.jsp?usrName=${param.userName }">VIEW
					CLAIM</a></li>
			<li class="nav-item"><a class="nav-link" href="Login.jsp">LOGOUT</a>
			</li>
		</ul>
	</div>
	<div>
		<iframe src="insured_iframe.htm" height="950px" width="100%"
			style="border: none;" name="claim_ab"></iframe>
	</div>
</body>
</html>