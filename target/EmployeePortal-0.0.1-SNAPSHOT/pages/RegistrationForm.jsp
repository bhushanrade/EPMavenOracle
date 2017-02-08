<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Registration</title>
<link rel="icon" type="image/png" href="resources/images/icon.jpg">
<style type="text/css">
body {
	background-image: url(resources/images/reg3.jpg);
	padding-top: 40px;
	padding-bottom: 40px;
	min-height: 100%;
	bgcolor:"skyblue"
	color:red;
}

h1 {
	font-family: courier; 
	//font-style: oblique; 
	//background-color: orange
}

#header {
	//color: hsl(0, 100%, 30%);
	//background-color: hsl(0, 100%, 90%);
}
</style>
</head>
<body>
	<div class="container">
		<div id="header" class="page-header">
			<h2>Enter Details Here..!</h2>
		</div>
		<form modelAttribute="command" action="registerEmployee" method="post">
			<div class="form-group">
				<label for="firstname" class="inline">First Name:</label> <input
					type="text" class="form-control" name="firstname"
					placeholder="First Name " autofocus required />
			</div>
			<div class="form-group">
				<label for="lastname">Last Name:</label> <input type="text"
					class="form-control" name="lastname" placeholder="Last Name "
					required />
			</div>
			<div class="form-group">
				<label for="gender">Gender:</label> <label class="radio-inline"><input
					type="radio" name="gender" value="Male">Male</label> <label
					class="radio-inline"> <input type="radio" name="gender"
					value="Female">Female
				</label>
			</div>

			<div class="form-group">
				<label for="dateofBirth">Date of Birth :</label> <input type="date"
					class="form-control" name="dateofBirth"
					placeholder="Date of Birth " required />
			</div>
			<div class="form-group">
				<label for="phone">Mobile No.:</label> <input type="text"
					class="form-control" name="phone" placeholder="Mobile no "
					pattern="(7|8|9)\d{9}" maxlength="10" required />
			</div>
			<div class="form-group">
				<label for="email">Email :</label> <input type="text"
					class="form-control" name="email" placeholder="abc@xyz.com "
					required />
			</div>
			<div class="form-group">
				<label for="password">Password:</label> <input type="password"
					class="form-control" name="password" placeholder="Password "
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required />
			</div>

			<button type="submit" class="btn btn-default">sign me
				up</button>
		</form>
	</div>



</body>
</html>