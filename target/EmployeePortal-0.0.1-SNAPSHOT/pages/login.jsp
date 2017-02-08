<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Here</title>
<link rel="icon" type="image/png" href="resources/images/icon.jpg">
 <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <style type="text/css">
  body {
	background-image: url(resources/images/log.jpg);
	padding-top: 40px;
	padding-bottom: 40px;
	min-height: 100%;
	bgcolor:"skyblue"
	color:red;
}
  
  </style>
</head>
<body>
<div class="container">
  <h2>Login form</h2>
  <form action="validateStudent">
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="email" class="form-control" id="email" name="email" placeholder="email">
    </div>
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="password" name="password" placeholder="Enter password">
    </div>
    <button type="submit" class="btn btn-default">Login</button>
  </form>
</div>

</body>
</html>