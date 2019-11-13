<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
	<div class="container" style="margin-top: 100px">
		<div class="card">
			<div class="row">
				<div class="col-lg-4 col-lg-5 col-md-5 offset-sm-3 center">
					<form action="" method="post">
						<div class="form-group">
							<label for="username"></label>Username<input type="text"
								class="form-control" id="username" placeholder="Enter username"
								name="username" required="required">
						</div>
						<div class="form-group">
							<label for="password">Password:</label> <input type="password"
								class="form-control" id="pwd" placeholder="Enter password"
								name="pass" required="required">
						</div>
						<div class="form-group">
							<label for="password">Role Code:</label> <select
								name="role_choice">
								<option selected="selected">----Select Role----</option>
								<option value="INSURED">INSURED</option>
								<option value="ADMIN">ADMIN</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Create</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>