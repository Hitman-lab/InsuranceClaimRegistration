<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Profile</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="LoginFormValidation.js" type="text/javascript"></script>
</head>
<body>
	<div class="container" style="margin-top: 90px">
		<div class="row">
			<div class="col-lg-4 col-lg-5 col-md-5 offset-sm-3 center">
				<div class="card">
					<h3 class="card-header alert alert-danger" style="color: maroon;">Create
						Profile</h3>
					<div class="card-body">
						<form action="#" method="post" name="loginForm">
							<div class="form-group">
								<input type="text" class="form-control" id="username"
									placeholder="Enter username" name="user_name"
									required="required"> <span id="user_check"
									style="color: red;"></span>
							</div>
							<div class="form-group">
								<input type="password" class="form-control" id="pass"
									placeholder="Enter password" name="pass" required="required">
								<span id="user_pass" style="color: red;"></span>
							</div>
							<div class="form-group">
								<select class="custom-select" id="roleCode" name="roleCode">
									<option selected>Choose Roles .....</option>
									<option value="CLAIM HANDLER">CLAIM HANDLER</option>
									<option value="INSURED">INSURED</option>
								</select>
							</div>

							<input type="submit" value="Submit" class="btn btn-danger"
								onclick='return(validate())'>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>